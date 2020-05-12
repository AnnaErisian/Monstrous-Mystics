package blue.thejester.monstrousmystics.client.model;

import blue.thejester.monstrousmystics.client.render.IHasArms;
import blue.thejester.monstrousmystics.entity.EntityJesterMob;
import blue.thejester.monstrousmystics.entity.tier1.EntitySpirit;
import electroblob.wizardry.spell.Spell;
import net.ilexiconn.llibrary.client.model.ModelAnimator;
import net.ilexiconn.llibrary.client.model.tools.AdvancedModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHandSide;
import net.minecraft.util.math.MathHelper;
import net.ilexiconn.llibrary.client.model.tools.AdvancedModelRenderer;
import net.minecraft.world.EnumDifficulty;

import javax.annotation.Nonnull;
import java.util.List;


/**
 * ModelSpirit - Anna Erisian
 * Created using Tabula 7.1.0
 */
public class ModelSpirit extends AdvancedModelBase implements IHasArms {
    private static final float LIMB_SWING_WALK_SCALE = 0.1f;
    private final ModelAnimator animator;
    public AdvancedModelRenderer Body;
    public AdvancedModelRenderer ArmR;
    public AdvancedModelRenderer Head;
    public AdvancedModelRenderer Tail;
    public AdvancedModelRenderer ArmL;
    public AdvancedModelRenderer TailBottom;

    public ModelSpirit() {
        animator = ModelAnimator.create();
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.Head = new AdvancedModelRenderer(this, 0, 17);
        this.Head.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
        this.Tail = new AdvancedModelRenderer(this, 36, 0);
        this.Tail.mirror = true;
        this.Tail.setRotationPoint(0.0F, 12.0F, -1.8F);
        this.Tail.addBox(-3.0F, 0.0F, 0.0F, 6, 7, 3, 0.0F);
        this.setRotateAngle(Tail, 0.22759093446006054F, 0.0F, 0.0F);
        this.ArmR = new AdvancedModelRenderer(this, 24, 0);
        this.ArmR.mirror = true;
        this.ArmR.setRotationPoint(5.0F, 2.0F, 0.0F);
        this.ArmR.addBox(-1.0F, -2.0F, -2.0F, 3, 14, 3, 0.0F);
        this.setRotateAngle(ArmR, -1.3962634015954636F, 0.10000736613927509F, -0.10000736613927509F);
        this.TailBottom = new AdvancedModelRenderer(this, 36, 10);
        this.TailBottom.setRotationPoint(0.0F, 7.0F, 0.0F);
        this.TailBottom.addBox(-2.0F, 0.0F, 0.0F, 4, 4, 2, 0.0F);
        this.setRotateAngle(TailBottom, 0.31869712141416456F, 0.0F, 0.0F);
        this.Body = new AdvancedModelRenderer(this, 0, 0);
        this.Body.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Body.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
        this.setRotateAngle(Body, 0.18203784098300857F, 0.0F, 0.0F);
        this.ArmL = new AdvancedModelRenderer(this, 24, 0);
        this.ArmL.setRotationPoint(-5.0F, 2.0F, 0.0F);
        this.ArmL.addBox(-2.0F, -2.0F, -2.0F, 3, 14, 3, 0.0F);
        this.setRotateAngle(ArmL, -1.3962634015954636F, -0.10000736613927509F, 0.10000736613927509F);
        this.Body.addChild(this.Head);
        this.Body.addChild(this.Tail);
        this.Body.addChild(this.ArmR);
        this.Tail.addChild(this.TailBottom);
        this.Body.addChild(this.ArmL);

        updateDefaultPose();
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        GlStateManager.pushMatrix();
        animate(f, f1, f2, f3, f4, f5, (EntitySpirit) entity);
        this.Body.render(f5);
        GlStateManager.popMatrix();
    }

    private void animate(float f, float f1, float f2, float f3, float f4, float f5, EntitySpirit entity) {
        animator.update((EntitySpirit) entity);
        setRotationAngles(f,f1,f2,f3,f4,f5,entity);
        if(entity.getAnimation() == EntitySpirit.SHOOT_ANIMATION || entity.getAnimation() == EntitySpirit.SHOOT_ANIMATION_LONG ) {
            animator.setAnimation(entity.getAnimation());
            animator.startKeyframe(8);
            animator.rotate(ArmL, -1, 0, 0);
            animator.endKeyframe();
            animator.resetKeyframe(3);
        }
    }


    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
        resetToDefaultPose();

        float oscillating = (float) (Math.sin(ageInTicks / 30) / 3 - 1);

        //constant bob
        bob(Body, 3f, 0.4f, false, oscillating, oscillating);

        //walking tail swing
        chainWave(new AdvancedModelRenderer[] {Tail, TailBottom}, 1, 0.3f, 0, limbSwing, limbSwingAmount);

        //walking arm swing
        this.ArmR.rotateAngleX = -1.5f + MathHelper.cos(limbSwing * 0.6662F + 3.1415927F) * 2.0F * limbSwingAmount * LIMB_SWING_WALK_SCALE;
        this.ArmL.rotateAngleX = -1.5f + MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * LIMB_SWING_WALK_SCALE;
        this.ArmR.rotateAngleZ = MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * LIMB_SWING_WALK_SCALE;
        this.ArmL.rotateAngleZ = MathHelper.cos(limbSwing * 0.6662F + 3.1415927F) * 2.0F * limbSwingAmount * LIMB_SWING_WALK_SCALE;

        //attack arm swing. code based on ModelZombie
        if(this.swingProgress != 0) {
            float f = MathHelper.sin(this.swingProgress * 3.1415927F);
            float f1 = MathHelper.sin((1.0F - (1.0F - this.swingProgress) * (1.0F - this.swingProgress)) * 3.1415927F);
            if(((EntitySpirit) entityIn).getHeldItemMainhand() != ItemStack.EMPTY) {
                this.ArmR.rotateAngleY = -(0.1F - f * 0.6F);
                this.ArmR.rotateAngleX += f * 1.2F - f1 * 0.4F;
            }
            if(((EntitySpirit) entityIn).getHeldItemOffhand() != ItemStack.EMPTY) {
                this.ArmL.rotateAngleY = 0.1F - f * 0.6F;
                this.ArmL.rotateAngleX += f * 1.2F - f1 * 0.4F;
            }
        }
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(AdvancedModelRenderer AdvancedModelRenderer, float x, float y, float z) {
        AdvancedModelRenderer.rotateAngleX = x;
        AdvancedModelRenderer.rotateAngleY = y;
        AdvancedModelRenderer.rotateAngleZ = z;
    }

    @Override
    public void postRenderArm(EnumHandSide side, float scale) {
        if (side == EnumHandSide.LEFT) {
            ArmL.postRender(scale);
            GlStateManager.translate(-0.05f, 0, 0);
        } else {
            ArmR.postRender(scale);
            GlStateManager.translate(0.05f, 0, 0);
        }
    }
}
