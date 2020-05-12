package blue.thejester.monstrousmystics.client.model;

import blue.thejester.monstrousmystics.client.render.IHasArms;
import blue.thejester.monstrousmystics.entity.tier2.EntityImp;
import net.ilexiconn.llibrary.client.model.ModelAnimator;
import net.ilexiconn.llibrary.client.model.tools.AdvancedModelBase;
import net.ilexiconn.llibrary.client.model.tools.AdvancedModelRenderer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHandSide;
import net.minecraft.util.math.MathHelper;

/**
 * ModelImp - Either Mojang or a mod author
 * Created using Tabula 7.1.0
 */
public class ModelImp extends AdvancedModelBase implements IHasArms {
    private static final float LIMB_SWING_WALK_SCALE = 0.1f;
    private final ModelAnimator animator;
    public AdvancedModelRenderer Body;
    public AdvancedModelRenderer ArmR;
    public AdvancedModelRenderer Head;
    public AdvancedModelRenderer LegR;
    public AdvancedModelRenderer LegL;
    public AdvancedModelRenderer ArmL;
    public AdvancedModelRenderer HornR;
    public AdvancedModelRenderer HornL;

    public ModelImp() {
        animator = ModelAnimator.create();
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.HornR = new AdvancedModelRenderer(this, 0, 0);
        this.HornR.mirror = true;
        this.HornR.setRotationPoint(2.8F, -10.5F, -4.1F);
        this.HornR.addBox(-0.5F, 0.0F, 0.0F, 1, 3, 2, 0.0F);
        this.setRotateAngle(HornR, 0.20943951023931953F, -0.11693705988362009F, 0.10122909661567112F);
        this.HornL = new AdvancedModelRenderer(this, 0, 0);
        this.HornL.mirror = true;
        this.HornL.setRotationPoint(-2.8F, -10.5F, -4.1F);
        this.HornL.addBox(-0.5F, 0.0F, 0.0F, 1, 3, 2, 0.0F);
        this.setRotateAngle(HornL, 0.20943951023931953F, 0.11693705988362009F, -0.10122909661567112F);
        this.ArmR = new AdvancedModelRenderer(this, 32, 0);
        this.ArmR.mirror = true;
        this.ArmR.setRotationPoint(5.0F, 2.0F, 0.0F);
        this.ArmR.addBox(-1.0F, -2.0F, -2.0F, 3, 10, 3, 0.0F);
        this.setRotateAngle(ArmR, -1.3962634015954636F, 0.10000736613927509F, -0.10000736613927509F);
        this.LegL = new AdvancedModelRenderer(this, 0, 16);
        this.LegL.setRotationPoint(-1.9F, 10.0F, 0.1F);
        this.LegL.addBox(-2.0F, 0.0F, -2.0F, 4, 10, 4, 0.0F);
        this.ArmL = new AdvancedModelRenderer(this, 32, 0);
        this.ArmL.setRotationPoint(-5.0F, 2.0F, 0.0F);
        this.ArmL.addBox(-2.0F, -2.0F, -2.0F, 3, 10, 3, 0.0F);
        this.setRotateAngle(ArmL, -1.3962634015954636F, -0.10000736613927509F, 0.10000736613927509F);
        this.Head = new AdvancedModelRenderer(this, 0, 0);
        this.Head.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
        this.LegR = new AdvancedModelRenderer(this, 0, 16);
        this.LegR.mirror = true;
        this.LegR.setRotationPoint(1.9F, 10.0F, 0.1F);
        this.LegR.addBox(-2.0F, 0.0F, -2.0F, 4, 10, 4, 0.0F);
        this.Body = new AdvancedModelRenderer(this, 16, 16);
        this.Body.setRotationPoint(0.0F, 4.0F, 0.0F);
        this.Body.addBox(-4.0F, 0.0F, -2.0F, 8, 10, 4, 0.0F);
        this.Head.addChild(this.HornR);
        this.Head.addChild(this.HornL);
        this.Body.addChild(this.ArmR);
        this.Body.addChild(this.LegL);
        this.Body.addChild(this.ArmL);
        this.Body.addChild(this.Head);
        this.Body.addChild(this.LegR);

        updateDefaultPose();
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        GlStateManager.pushMatrix();
        animate(f, f1, f2, f3, f4, f5, (EntityImp) entity);
        this.Body.render(f5);
        GlStateManager.popMatrix();
    }

    private void animate(float f, float f1, float f2, float f3, float f4, float f5, EntityImp entity) {
        animator.update(entity);
        setRotationAngles(f,f1,f2,f3,f4,f5,entity);
        if(entity.getAnimation() == EntityImp.SHOOT_ANIMATION || entity.getAnimation() == EntityImp.SHOOT_ANIMATION_LONG ) {
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

        walk(LegL, 2f, 0.8f, false, 0, 0, limbSwing, limbSwingAmount);
        walk(LegR, 2f, 0.8f, true, 0, 0, limbSwing, limbSwingAmount);

        //walking arm swing
        this.ArmR.rotateAngleX = -1.5f + MathHelper.cos(limbSwing * 0.6662F + 3.1415927F) * 2.0F * limbSwingAmount * LIMB_SWING_WALK_SCALE;
        this.ArmL.rotateAngleX = -1.5f + MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * LIMB_SWING_WALK_SCALE;
        this.ArmR.rotateAngleZ = MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * LIMB_SWING_WALK_SCALE;
        this.ArmL.rotateAngleZ = MathHelper.cos(limbSwing * 0.6662F + 3.1415927F) * 2.0F * limbSwingAmount * LIMB_SWING_WALK_SCALE;

        //attack arm swing. code based on ModelZombie
        if(this.swingProgress != 0) {
            float f = MathHelper.sin(this.swingProgress * 3.1415927F);
            float f1 = MathHelper.sin((1.0F - (1.0F - this.swingProgress) * (1.0F - this.swingProgress)) * 3.1415927F);
            if(((EntityImp) entityIn).getHeldItemMainhand() != ItemStack.EMPTY) {
                this.ArmR.rotateAngleY = -(0.1F - f * 0.6F);
                this.ArmR.rotateAngleX += f * 1.2F - f1 * 0.4F;
            }
            if(((EntityImp) entityIn).getHeldItemOffhand() != ItemStack.EMPTY) {
                this.ArmL.rotateAngleY = 0.1F - f * 0.6F;
                this.ArmL.rotateAngleX += f * 1.2F - f1 * 0.4F;
            }
        }
    }


    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
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
