package blue.thejester.monstrousmystics.entity.ai;

import blue.thejester.monstrousmystics.entity.EntityJesterMob;
import electroblob.wizardry.event.SpellCastEvent;
import electroblob.wizardry.packet.PacketNPCCastSpell;
import electroblob.wizardry.packet.WizardryPacketHandler;
import electroblob.wizardry.registry.Spells;
import electroblob.wizardry.spell.Spell;
import electroblob.wizardry.util.SpellModifiers;
import net.ilexiconn.llibrary.server.animation.Animation;
import net.ilexiconn.llibrary.server.animation.AnimationAI;
import net.ilexiconn.llibrary.server.animation.IAnimatedEntity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class EntityAiSpellBase extends AnimationAI {
    protected final EntityJesterMob attacker;
    protected final World world;
    protected final float minDistance;
    protected final float maxDistance;
    protected EntityLivingBase target;
    protected int cooldownIndex;
    protected boolean targeted;
    protected Potion potion;
    protected final EntityJesterMob.WeightedSpell[] spells;
    protected final Animation animation;
    protected int firingFrame;
    protected boolean doneExecuting = false;

    public EntityAiSpellBase(EntityJesterMob creature, float minDistance, float maxDistance, Animation animation, int firingFrame, int cooldownIndex, boolean targeted, boolean repeating, Potion potion, EntityJesterMob.WeightedSpell... spells) {
        super(creature);
        this.attacker = creature;
        this.world = creature.world;
        this.minDistance = minDistance;
        this.maxDistance = maxDistance;
        this.cooldownIndex = cooldownIndex;
        this.targeted = targeted;
        this.potion = potion;
        this.spells = spells;
        this.animation = animation;
        this.firingFrame = firingFrame;
        setMutexBits(2); // conflcit with attacking but not moving
    }

    @Override
    public Animation getAnimation() {
        return animation;
    }

    @Override
    public boolean shouldAnimate() {
        if(cooldownReady()) {
            //if we're checking a potion then check that first
            if(potion != null && attacker.getActivePotionEffect(potion) != null) {
                return false;
            }
            if(!targeted) {
                return true;
            }
            EntityLivingBase entitylivingbase = this.attacker.getAttackTarget();
            if(!targeted || (entitylivingbase != null && entitylivingbase.isEntityAlive() && appropriateDistance(entitylivingbase))) {
                this.target = entitylivingbase;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean shouldContinueExecuting() {
        return super.shouldContinueExecuting() && this.animation == attacker.getAnimation() && canSee();
    }

    private boolean canSee() {
        return !targeted || (this.target != null && this.attacker.getEntitySenses().canSee(target));
    }

    private boolean cooldownReady() {
        if(cooldownIndex < 0) {
            return true;
        } else {
            return attacker.getCooldown(cooldownIndex) <= 0;
        }
    }

    private boolean appropriateDistance(EntityLivingBase entitylivingbase) {
        double d = this.attacker.getPositionVector().distanceTo(entitylivingbase.getPositionVector());
        return d > minDistance && d < maxDistance;
    }

    @Override
    public void startExecuting() {
        super.startExecuting();
        attacker.setAnimation(animation);
        this.doneExecuting = false;
    }

    @Override
    public void resetTask() {
        super.resetTask();
        attacker.setAnimation(IAnimatedEntity.NO_ANIMATION);

        this.setContinuousSpellAndNotify(Spells.none, new SpellModifiers());
    }

    private void setContinuousSpellAndNotify(Spell spell, SpellModifiers modifiers){
        attacker.setContinuousSpell(spell);
        WizardryPacketHandler.net.sendToAllAround(
                new PacketNPCCastSpell.Message(attacker.getEntityId(), target == null ? -1 : target.getEntityId(),
                        EnumHand.MAIN_HAND, spell, modifiers),
                new NetworkRegistry.TargetPoint(attacker.dimension, attacker.posX, attacker.posY, attacker.posZ, 128));
    }

    public void updateTask() {
        if(targeted) {
            EntityLivingBase entitylivingbase = this.attacker.getAttackTarget();
            if (entitylivingbase != null) {
                this.attacker.getLookHelper().setLookPositionWithEntity(entitylivingbase, 30.0F, 30.0F);
                double distanceSq = this.attacker.getDistanceSq(entitylivingbase.posX, entitylivingbase.getEntityBoundingBox().minY, entitylivingbase.posZ);
                if (attacker.getAnimationTick() == firingFrame) {
                    attemptCastSpell();
                }
            }
        } else {
            if (attacker.getAnimationTick() == firingFrame) {
                attemptCastSpell();
            }
        }
    }

    private void attemptCastSpell() {
        int total = 0;
        for(EntityJesterMob.WeightedSpell s : spells) {
            total += s.weight;
        }
        total = world.rand.nextInt(total);
        for(EntityJesterMob.WeightedSpell s : spells) {
            if(total < s.weight) {
                attemptCastSpell(s.spell);
                return;
            } else {
                total -= s.weight;
            }
        }
    }

    private void attemptCastSpell(Spell spell) {
        SpellModifiers modifiers = new SpellModifiers();

        // If anything stops the spell working at this point, nothing else happens.
        if(MinecraftForge.EVENT_BUS.post(new SpellCastEvent.Pre(SpellCastEvent.Source.NPC, spell, attacker, modifiers))){
            return;
        }

        //prevents swing on cast?
        boolean wasSwinging = attacker.isSwingInProgress;
        attacker.isSwingInProgress = true;
        if(spell.cast(attacker.world, attacker, EnumHand.MAIN_HAND, 0, target, modifiers)){

            attacker.beginCooldown(cooldownIndex);

            MinecraftForge.EVENT_BUS.post(new SpellCastEvent.Post(SpellCastEvent.Source.NPC, spell, attacker, modifiers));

            if (spell.requiresPacket()) {
                // Sends a packet to all players in dimension to tell them to spawn particles.
                IMessage msg = new PacketNPCCastSpell.Message(attacker.getEntityId(), target == null ? -1 : target.getEntityId(),
                        EnumHand.MAIN_HAND, spell, modifiers);
                WizardryPacketHandler.net.sendToDimension(msg, attacker.world.provider.getDimension());
            }
        }
        attacker.isSwingInProgress = wasSwinging;
    }
}
