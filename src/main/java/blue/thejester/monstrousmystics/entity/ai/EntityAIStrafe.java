package blue.thejester.monstrousmystics.entity.ai;

import blue.thejester.monstrousmystics.entity.EntityJesterMob;
import blue.thejester.monstrousmystics.entity.tier1.EntitySpirit;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.item.ItemBow;
import net.minecraft.util.EnumHand;

public class EntityAIStrafe extends EntityAIBase {
    private final EntityJesterMob entity;
    private final double moveSpeedAmp;
    private final float maxDistSq;
    private int seeTime;
    private boolean strafingClockwise;
    private boolean strafingBackwards;
    private int strafingTime = -1;

    public EntityAIStrafe(EntityJesterMob mob, double moveSpeedAmpIn, float maxDistance) {
        this.entity = mob;
        this.moveSpeedAmp = moveSpeedAmpIn;
        this.maxDistSq = maxDistance * maxDistance;
        this.setMutexBits(1);
    }

    public boolean shouldExecute() {
        return this.entity.getAttackTarget() != null && farEnough();
    }

    private boolean farEnough() {
        Entity target = this.entity.getAttackTarget();
        return target != null && this.entity.getDistanceSqToCenter(target.getPosition()) <= maxDistSq;
    }

    public boolean shouldContinueExecuting() {
        return this.shouldExecute();
    }

    public void startExecuting() {
        super.startExecuting();
    }

    public void resetTask() {
        super.resetTask();
        this.seeTime = 0;
    }

    public void updateTask() {
        EntityLivingBase entitylivingbase = this.entity.getAttackTarget();
        if (entitylivingbase != null) {
            double d0 = this.entity.getDistanceSq(entitylivingbase.posX, entitylivingbase.getEntityBoundingBox().minY, entitylivingbase.posZ);
            boolean flag = this.entity.getEntitySenses().canSee(entitylivingbase);
            boolean flag1 = this.seeTime > 0;
            if (flag != flag1) {
                this.seeTime = 0;
            }

            if (flag) {
                ++this.seeTime;
            } else {
                --this.seeTime;
            }

            if (d0 <= (double)this.maxDistSq && this.seeTime >= 20) {
                this.entity.getNavigator().clearPath();
                ++this.strafingTime;
            } else {
                this.entity.getNavigator().tryMoveToEntityLiving(entitylivingbase, this.moveSpeedAmp);
                this.strafingTime = -1;
            }

            if (this.strafingTime >= 20) {
                if ((double)this.entity.getRNG().nextFloat() < 0.3D) {
                    this.strafingClockwise = !this.strafingClockwise;
                }

                if ((double)this.entity.getRNG().nextFloat() < 0.3D) {
                    this.strafingBackwards = !this.strafingBackwards;
                }

                this.strafingTime = 0;
            }

            if (this.strafingTime > -1) {
                if (d0 > (double)(this.maxDistSq * 0.75F)) {
                    this.strafingBackwards = false;
                } else if (d0 < (double)(this.maxDistSq * 0.25F)) {
                    this.strafingBackwards = true;
                }

                this.entity.getMoveHelper().strafe(this.strafingBackwards ? -0.5F : 0.5F, this.strafingClockwise ? 0.5F : -0.5F);
                this.entity.faceEntity(entitylivingbase, 30.0F, 30.0F);
            } else {
                this.entity.getLookHelper().setLookPositionWithEntity(entitylivingbase, 30.0F, 30.0F);
            }
        }

    }
}
