package blue.thejester.monstrousmystics.entity.ai;

import blue.thejester.monstrousmystics.entity.tier1.EntitySpirit;
import electroblob.wizardry.event.SpellCastEvent;
import electroblob.wizardry.packet.PacketNPCCastSpell;
import electroblob.wizardry.packet.WizardryPacketHandler;
import electroblob.wizardry.registry.Spells;
import electroblob.wizardry.spell.Spell;
import electroblob.wizardry.util.SpellModifiers;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.pathfinding.PathPoint;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class EntityAIMagicMissile extends EntityAIBase {
    private final EntityMob attacker;
    private final World world;
    private int delayCounter;
    private EntityLivingBase target;

    public EntityAIMagicMissile(EntityMob creature) {
        this.attacker = creature;
        this.world = creature.world;
        setMutexBits(2); // conflcit with attacking but not moving
    }

    @Override
    public boolean shouldExecute() {
        EntityLivingBase entitylivingbase = this.attacker.getAttackTarget();
        if(entitylivingbase != null && entitylivingbase.isEntityAlive()) {
            this.target = entitylivingbase;
            return true;
        }
        return false;
    }

    public boolean shouldContinueExecuting() {
        EntityLivingBase entitylivingbase = this.attacker.getAttackTarget();
        if (entitylivingbase == null) {
            return false;
        } else if (!entitylivingbase.isEntityAlive()) {
            return false;
        } else if (this.attacker.getPositionVector().distanceTo(this.attacker.getPositionVector()) < 3) {
            return false;
        } else {
            return !(entitylivingbase instanceof EntityPlayer) || !((EntityPlayer)entitylivingbase).isSpectator() && !((EntityPlayer)entitylivingbase).isCreative();
        }
    }

    public void updateTask() {
        EntityLivingBase entitylivingbase = this.attacker.getAttackTarget();
        this.attacker.getLookHelper().setLookPositionWithEntity(entitylivingbase, 30.0F, 30.0F);
        double distanceSq = this.attacker.getDistanceSq(entitylivingbase.posX, entitylivingbase.getEntityBoundingBox().minY, entitylivingbase.posZ);
        if(this.delayCounter > 0) {
            --this.delayCounter;
        }
        if (this.delayCounter <= 0 && this.attacker.getEntitySenses().canSee(entitylivingbase)) {
            this.delayCounter = 10;
            if (distanceSq > 1024.0D) {
                this.delayCounter += 10;
            } else if (distanceSq > 256.0D) {
                this.delayCounter += 5;
            }
            attemptCastMissile();
        }
    }

    private void attemptCastMissile() {
        Spell mm = Spells.magic_missile;
        SpellModifiers modifiers = new SpellModifiers();

        // If anything stops the spell working at this point, nothing else happens.
        if(MinecraftForge.EVENT_BUS.post(new SpellCastEvent.Pre(SpellCastEvent.Source.NPC, mm, attacker, modifiers))){
            return;
        }

        //prevents swing on cast?
        boolean wasSwinging = attacker.isSwingInProgress;
        attacker.isSwingInProgress = true;
        if(mm.cast(attacker.world, attacker, EnumHand.MAIN_HAND, 0, target, modifiers)){
            MinecraftForge.EVENT_BUS.post(new SpellCastEvent.Post(SpellCastEvent.Source.NPC, mm, attacker, modifiers));

            //We know MM does not need a packet, so we omitted that code - other spells might need one though
        }
        attacker.isSwingInProgress = wasSwinging;
    }
}
