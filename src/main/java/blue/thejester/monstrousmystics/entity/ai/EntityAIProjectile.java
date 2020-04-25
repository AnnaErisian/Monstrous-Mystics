package blue.thejester.monstrousmystics.entity.ai;

import blue.thejester.monstrousmystics.entity.EntityJesterMob;
import electroblob.wizardry.event.SpellCastEvent;
import electroblob.wizardry.packet.PacketNPCCastSpell;
import electroblob.wizardry.packet.WizardryPacketHandler;
import electroblob.wizardry.registry.Spells;
import electroblob.wizardry.spell.Spell;
import electroblob.wizardry.spell.SpellProjectile;
import electroblob.wizardry.util.SpellModifiers;
import net.ilexiconn.llibrary.server.animation.Animation;
import net.ilexiconn.llibrary.server.animation.AnimationAI;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class EntityAIProjectile extends AnimationAI {
    private final EntityJesterMob attacker;
    private final World world;
    protected final float minDistance;
    private int delayCounter;
    private EntityLivingBase target;
    private final Spell spell;
    private final Animation animation;
    private int firingFrame;

    public EntityAIProjectile(EntityJesterMob creature, float minDistance, Spell spell, Animation animation, int firingFrame) {
        super(creature);
        this.attacker = creature;
        this.world = creature.world;
        this.minDistance = minDistance;
        this.spell = spell;
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
        EntityLivingBase entitylivingbase = this.attacker.getAttackTarget();
        if(entitylivingbase != null && entitylivingbase.isEntityAlive() && this.attacker.getPositionVector().distanceTo(entitylivingbase.getPositionVector()) > minDistance) {
            this.target = entitylivingbase;
            return true;
        }
        return false;
    }

    @Override
    public void startExecuting() {
        super.startExecuting();
        attacker.setAnimation(animation);
    }

    public void updateTask() {
        EntityLivingBase entitylivingbase = this.attacker.getAttackTarget();
        if(entitylivingbase != null) {
            this.attacker.getLookHelper().setLookPositionWithEntity(entitylivingbase, 30.0F, 30.0F);
            double distanceSq = this.attacker.getDistanceSq(entitylivingbase.posX, entitylivingbase.getEntityBoundingBox().minY, entitylivingbase.posZ);
            if (attacker.getAnimationTick() == firingFrame) {
                attemptCastMissile();
            }
            if(attacker.getAnimationTick() > animation.getDuration()) {
                attacker.setAnimation(animation);
            }
        }
    }

    private void attemptCastMissile() {
        SpellModifiers modifiers = new SpellModifiers();

        // If anything stops the spell working at this point, nothing else happens.
        if(MinecraftForge.EVENT_BUS.post(new SpellCastEvent.Pre(SpellCastEvent.Source.NPC, spell, attacker, modifiers))){
            return;
        }

        //prevents swing on cast?
        boolean wasSwinging = attacker.isSwingInProgress;
        attacker.isSwingInProgress = true;
        if(spell.cast(attacker.world, attacker, EnumHand.MAIN_HAND, 0, target, modifiers)){
            MinecraftForge.EVENT_BUS.post(new SpellCastEvent.Post(SpellCastEvent.Source.NPC, spell, attacker, modifiers));


            if(spell.requiresPacket()){
                // Sends a packet to all players in dimension to tell them to spawn particles.
                IMessage msg = new PacketNPCCastSpell.Message(attacker.getEntityId(), target.getEntityId(),
                        EnumHand.MAIN_HAND, spell, modifiers);
                WizardryPacketHandler.net.sendToDimension(msg, attacker.world.provider.getDimension());
            }
        }
        attacker.isSwingInProgress = wasSwinging;
    }
}
