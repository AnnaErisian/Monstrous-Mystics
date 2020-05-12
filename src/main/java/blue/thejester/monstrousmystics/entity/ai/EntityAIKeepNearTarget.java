package blue.thejester.monstrousmystics.entity.ai;

import blue.thejester.monstrousmystics.entity.EntityJesterMob;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.pathfinding.Path;
import net.minecraft.pathfinding.PathPoint;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EntityAIKeepNearTarget extends EntityAIBase {
    World world;
    protected EntityJesterMob attacker;
    double speedTowardsTarget;
    boolean longMemory;
    private float minDistance;
    private float maxDistance;
    Path path;
    private int delayCounter;
    private double targetX;
    private double targetY;
    private double targetZ;

    public EntityAIKeepNearTarget(EntityJesterMob creature, double speedIn, boolean useLongMemory, float minDistance, float maxDistance) {
        this.attacker = creature;
        this.world = creature.world;
        this.speedTowardsTarget = speedIn;
        this.longMemory = useLongMemory;
        this.minDistance = minDistance;
        this.maxDistance = maxDistance;
        this.setMutexBits(1);
    }

    public boolean shouldExecute() {
        EntityLivingBase entitylivingbase = this.attacker.getAttackTarget();
        if (entitylivingbase == null) {
            return false;
        } else if (!entitylivingbase.isEntityAlive()) {
            return false;
        } else if(!appropriateDistance(entitylivingbase)){
            return false;

        } else {
            this.path = this.attacker.getNavigator().getPathToEntityLiving(entitylivingbase);
            return this.path != null;
        }
    }

    private boolean appropriateDistance(EntityLivingBase entitylivingbase) {
        double d = this.attacker.getPositionVector().distanceTo(entitylivingbase.getPositionVector());
        return d > minDistance && d < maxDistance;
    }

    public boolean shouldContinueExecuting() {
        EntityLivingBase entitylivingbase = this.attacker.getAttackTarget();
        if (entitylivingbase == null) {
            return false;
        } else if (!entitylivingbase.isEntityAlive()) {
            return false;
        } else if (!this.longMemory) {
            return !this.attacker.getNavigator().noPath();
        } else if (!this.attacker.isWithinHomeDistanceFromPosition(new BlockPos(entitylivingbase))) {
            return false;
        } else {
            return !(entitylivingbase instanceof EntityPlayer) || !((EntityPlayer) entitylivingbase).isSpectator() && !((EntityPlayer) entitylivingbase).isCreative();
        }
    }

    public void startExecuting() {
        this.attacker.getNavigator().setPath(this.path, this.speedTowardsTarget);
        this.delayCounter = 0;
    }

    public void resetTask() {
        EntityLivingBase entitylivingbase = this.attacker.getAttackTarget();
        if (entitylivingbase instanceof EntityPlayer && (((EntityPlayer) entitylivingbase).isSpectator() || ((EntityPlayer) entitylivingbase).isCreative())) {
            this.attacker.setAttackTarget((EntityLivingBase) null);
        }

        this.attacker.getNavigator().clearPath();
    }

    public void updateTask() {
        EntityLivingBase entitylivingbase = this.attacker.getAttackTarget();
        this.attacker.getLookHelper().setLookPositionWithEntity(entitylivingbase, 30.0F, 30.0F);
        double distanceSq = this.attacker.getDistanceSq(entitylivingbase.posX, entitylivingbase.getEntityBoundingBox().minY, entitylivingbase.posZ);
        --this.delayCounter;
        if (
                (this.longMemory || this.attacker.getEntitySenses().canSee(entitylivingbase))
                && this.delayCounter <= 0
                && (this.targetX == 0.0D && this.targetY == 0.0D && this.targetZ == 0.0D || entitylivingbase.getDistanceSq(this.targetX, this.targetY, this.targetZ) >= 1.0D || this.attacker.getRNG().nextFloat() < 0.05F)) {
            this.targetX = entitylivingbase.posX;
            this.targetY = entitylivingbase.getEntityBoundingBox().minY;
            this.targetZ = entitylivingbase.posZ;
            this.delayCounter = 4 + this.attacker.getRNG().nextInt(7);

            if (distanceSq > 1024.0D) {
                this.delayCounter += 10;
            } else if (distanceSq > 256.0D) {
                this.delayCounter += 5;
            }

            if (!this.attacker.getNavigator().tryMoveToEntityLiving(entitylivingbase, this.speedTowardsTarget)) {
                this.delayCounter += 15;
            }
        }
    }

    protected double getAttackReachSqr(EntityLivingBase attackTarget) {
        return (double) (this.attacker.width * 2.0F * this.attacker.width * 2.0F + attackTarget.width);
    }
}