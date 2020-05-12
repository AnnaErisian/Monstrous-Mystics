package blue.thejester.monstrousmystics.client.model;

import blue.thejester.monstrousmystics.entity.tier2.EntityBlackBlaze;
import net.ilexiconn.llibrary.client.model.ModelAnimator;
import net.ilexiconn.llibrary.client.model.tools.AdvancedModelBase;
import net.ilexiconn.llibrary.client.model.tools.AdvancedModelRenderer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;

/**
 * ModelBlackBlaze - Either Mojang or a mod author
 * Created using Tabula 7.1.0
 */
public class ModelBlackBlaze extends AdvancedModelBase {
    private final ModelAnimator animator;
    public AdvancedModelRenderer Head;
    public AdvancedModelRenderer Rod;
    public AdvancedModelRenderer Rod_1;
    public AdvancedModelRenderer Rod_2;
    public AdvancedModelRenderer Rod_3;
    public AdvancedModelRenderer Rod_4;
    public AdvancedModelRenderer Rod_5;
    public AdvancedModelRenderer Rod_6;
    public AdvancedModelRenderer Rod_7;
    public AdvancedModelRenderer Rod_8;
    public AdvancedModelRenderer Rod_9;
    public AdvancedModelRenderer Rod_10;
    public AdvancedModelRenderer Rod_11;
    public AdvancedModelRenderer SpineTop;
    public AdvancedModelRenderer SpineBottom;

    public ModelBlackBlaze() {
        animator = ModelAnimator.create();
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.Rod_10 = new AdvancedModelRenderer(this, 8, 16);
        this.Rod_10.setRotationPoint(4.95F, 1.06F, -4.95F);
        this.Rod_10.addBox(0.0F, 0.0F, 0.0F, 2, 8, 2, 0.0F);
        this.Head = new AdvancedModelRenderer(this, 0, 0);
        this.Head.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Head.addBox(-4.0F, -4.0F, -4.0F, 8, 8, 8, 0.0F);
        this.Rod_11 = new AdvancedModelRenderer(this, 16, 16);
        this.Rod_11.setRotationPoint(-4.95F, 1.2F, 4.95F);
        this.Rod_11.addBox(0.0F, 0.0F, 0.0F, 2, 8, 2, 0.0F);
        this.Rod_1 = new AdvancedModelRenderer(this, 8, 16);
        this.Rod_1.setRotationPoint(0.0F, -1.12F, 9.0F);
        this.Rod_1.addBox(0.0F, 0.0F, 0.0F, 2, 8, 2, 0.0F);
        this.Rod_9 = new AdvancedModelRenderer(this, 0, 16);
        this.Rod_9.setRotationPoint(0.0F, -1.93F, -9.0F);
        this.Rod_9.addBox(0.0F, 0.0F, 0.0F, 2, 8, 2, 0.0F);
        this.Rod_4 = new AdvancedModelRenderer(this, 8, 16);
        this.Rod_4.setRotationPoint(-4.46F, 11.35F, -2.27F);
        this.Rod_4.addBox(0.0F, 0.0F, 0.0F, 2, 8, 2, 0.0F);
        this.Rod_8 = new AdvancedModelRenderer(this, 16, 16);
        this.Rod_8.setRotationPoint(4.95F, 1.58F, 4.95F);
        this.Rod_8.addBox(0.0F, 0.0F, 0.0F, 2, 8, 2, 0.0F);
        this.SpineBottom = new AdvancedModelRenderer(this, 30, 17);
        this.SpineBottom.setRotationPoint(0.0F, 8.0F, 0.0F);
        this.SpineBottom.addBox(-1.0F, 0.0F, -1.0F, 2, 8, 1, 0.0F);
        this.setRotateAngle(SpineBottom, 0.31869712141416456F, 0.0F, 0.0F);
        this.Rod = new AdvancedModelRenderer(this, 0, 16);
        this.Rod.setRotationPoint(2.27F, 10.61F, -4.46F);
        this.Rod.addBox(0.0F, 0.0F, 0.0F, 2, 8, 2, 0.0F);
        this.Rod_6 = new AdvancedModelRenderer(this, 0, 16);
        this.Rod_6.setRotationPoint(4.46F, 11.96F, 2.27F);
        this.Rod_6.addBox(0.0F, 0.0F, 0.0F, 2, 8, 2, 0.0F);
        this.SpineTop = new AdvancedModelRenderer(this, 24, 17);
        this.SpineTop.setRotationPoint(0.0F, 4.0F, 4.0F);
        this.SpineTop.addBox(-1.0F, 0.0F, -1.0F, 2, 8, 1, 0.0F);
        this.setRotateAngle(SpineTop, -0.091106186954104F, 0.0F, 0.0F);
        this.Rod_7 = new AdvancedModelRenderer(this, 8, 16);
        this.Rod_7.setRotationPoint(-9.0F, -1.46F, 0.0F);
        this.Rod_7.addBox(0.0F, 0.0F, 0.0F, 2, 8, 2, 0.0F);
        this.Rod_3 = new AdvancedModelRenderer(this, 0, 16);
        this.Rod_3.setRotationPoint(-2.27F, 11.89F, 4.46F);
        this.Rod_3.addBox(0.0F, 0.0F, 0.0F, 2, 8, 2, 0.0F);
        this.Rod_2 = new AdvancedModelRenderer(this, 16, 16);
        this.Rod_2.setRotationPoint(9.0F, -1.0F, 0.0F);
        this.Rod_2.addBox(0.0F, 0.0F, 0.0F, 2, 8, 2, 0.0F);
        this.Rod_5 = new AdvancedModelRenderer(this, 16, 16);
        this.Rod_5.setRotationPoint(-4.95F, 1.01F, -4.95F);
        this.Rod_5.addBox(0.0F, 0.0F, 0.0F, 2, 8, 2, 0.0F);
        this.Head.addChild(this.Rod_10);
        this.Head.addChild(this.Rod_11);
        this.Head.addChild(this.Rod_1);
        this.Head.addChild(this.Rod_9);
        this.Head.addChild(this.Rod_4);
        this.Head.addChild(this.Rod_8);
        this.SpineTop.addChild(this.SpineBottom);
        this.Head.addChild(this.Rod);
        this.Head.addChild(this.Rod_6);
        this.Head.addChild(this.SpineTop);
        this.Head.addChild(this.Rod_7);
        this.Head.addChild(this.Rod_3);
        this.Head.addChild(this.Rod_2);
        this.Head.addChild(this.Rod_5);

        updateDefaultPose();
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        GlStateManager.pushMatrix();
        animate(f, f1, f2, f3, f4, f5, (EntityBlackBlaze) entity);
        this.Head.render(f5);
        GlStateManager.popMatrix();
    }


    private void animate(float f, float f1, float f2, float f3, float f4, float f5, EntityBlackBlaze entity) {
        animator.update((EntityBlackBlaze) entity);
        setRotationAngles(f,f1,f2,f3,f4,f5,entity);
//        if(entity.getAnimation() == EntityIceSpirit.SHOOT_ANIMATION || entity.getAnimation() == EntityIceSpirit.SHOOT_ANIMATION_LONG ) {
//            animator.setAnimation(entity.getAnimation());
//            animator.startKeyframe(8);
//            animator.rotate(ArmL, -1, 0, 0);
//            animator.endKeyframe();
//            animator.resetKeyframe(3);
//        }
    }

    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
        resetToDefaultPose();

        float oscillating = (float) (Math.sin(ageInTicks / 30) / 3 - 1);

        //constant bob
        bob(Head, 3f, 0.4f, false, oscillating, oscillating);

        //walking tail swing
        chainWave(new AdvancedModelRenderer[] {SpineTop, SpineBottom}, 1, 0.3f, 0, limbSwing, limbSwingAmount);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(AdvancedModelRenderer AdvancedModelRenderer, float x, float y, float z) {
        AdvancedModelRenderer.rotateAngleX = x;
        AdvancedModelRenderer.rotateAngleY = y;
        AdvancedModelRenderer.rotateAngleZ = z;
    }
}
