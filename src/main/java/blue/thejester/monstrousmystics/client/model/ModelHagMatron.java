package blue.thejester.monstrousmystics.client.model;

import net.ilexiconn.llibrary.client.model.ModelAnimator;
import net.ilexiconn.llibrary.client.model.tools.AdvancedModelBase;
import net.ilexiconn.llibrary.client.model.tools.AdvancedModelRenderer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;

/**
 * HagMatron - Either Mojang or a mod author
 * Created using Tabula 7.1.0
 */
public class ModelHagMatron extends AdvancedModelBase {
    private final ModelAnimator animator;
    public AdvancedModelRenderer Body;
    public AdvancedModelRenderer Head;
    public AdvancedModelRenderer LegL;
    public AdvancedModelRenderer LegR;
    public AdvancedModelRenderer Robe;
    public AdvancedModelRenderer ArmM;
    public AdvancedModelRenderer ArmR;
    public AdvancedModelRenderer ArmL;
    public AdvancedModelRenderer Nose;
    public AdvancedModelRenderer Hat1;
    public AdvancedModelRenderer Hat2;
    public AdvancedModelRenderer HatFlap1;
    public AdvancedModelRenderer HatFlap1_1;
    public AdvancedModelRenderer HatFlap1_2;
    public AdvancedModelRenderer HatFlap1_3;
    public AdvancedModelRenderer HatFlap1_4;
    public AdvancedModelRenderer HatFlap1_5;
    public AdvancedModelRenderer HatFlap1_6;
    public AdvancedModelRenderer HatFlap1_7;
    public AdvancedModelRenderer HatFlap1_8;
    public AdvancedModelRenderer HatFlap1_9;
    public AdvancedModelRenderer Hat3;
    public AdvancedModelRenderer Hat4;

    public ModelHagMatron() {
        animator = ModelAnimator.create();
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.Head = new AdvancedModelRenderer(this, 0, 0);
        this.Head.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Head.addBox(-4.0F, -10.0F, -4.0F, 8, 10, 8, 0.0F);
        this.HatFlap1_5 = new AdvancedModelRenderer(this, 43, 0);
        this.HatFlap1_5.setRotationPoint(5.0F, 4.0F, 0.0F);
        this.HatFlap1_5.addBox(0.0F, 0.0F, 0.0F, 3, 4, 0, 0.0F);
        this.HatFlap1_3 = new AdvancedModelRenderer(this, 32, 10);
        this.HatFlap1_3.setRotationPoint(0.0F, 4.0F, 10.0F);
        this.HatFlap1_3.addBox(0.0F, 0.0F, 0.0F, 1, 3, 0, 0.0F);
        this.Hat1 = new AdvancedModelRenderer(this, 88, 0);
        this.Hat1.setRotationPoint(-5.0F, -9.93F, -5.0F);
        this.Hat1.addBox(0.0F, 0.0F, 0.0F, 10, 4, 10, 0.0F);
        this.setRotateAngle(Hat1, 0.10402162341886204F, 0.0F, -0.06928957130417489F);
        this.Nose = new AdvancedModelRenderer(this, 24, 0);
        this.Nose.setRotationPoint(0.0F, -2.0F, 0.0F);
        this.Nose.addBox(-1.0F, -1.0F, -6.0F, 2, 4, 2, 0.0F);
        this.setRotateAngle(Nose, 0.0F, 0.0F, 0.04363323129985824F);
        this.HatFlap1_6 = new AdvancedModelRenderer(this, 43, 1);
        this.HatFlap1_6.setRotationPoint(10.0F, 4.0F, 2.0F);
        this.HatFlap1_6.addBox(0.0F, 0.0F, 0.0F, 0, 4, 3, 0.0F);
        this.LegR = new AdvancedModelRenderer(this, 0, 23);
        this.LegR.mirror = true;
        this.LegR.setRotationPoint(2.0F, 12.0F, 0.0F);
        this.LegR.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.ArmL = new AdvancedModelRenderer(this, 44, 25);
        this.ArmL.setRotationPoint(0.0F, 3.0F, -1.0F);
        this.ArmL.addBox(-8.0F, -2.0F, -2.0F, 4, 8, 4, 0.0F);
        this.setRotateAngle(ArmL, -0.7499679795819634F, 0.0F, 0.0F);
        this.ArmM = new AdvancedModelRenderer(this, 40, 37);
        this.ArmM.setRotationPoint(0.0F, 3.0F, -1.0F);
        this.ArmM.addBox(-4.0F, 2.0F, -2.0F, 8, 4, 4, 0.0F);
        this.setRotateAngle(ArmM, -0.7499679795819634F, 0.0F, 0.0F);
        this.ArmR = new AdvancedModelRenderer(this, 44, 25);
        this.ArmR.setRotationPoint(0.0F, 3.0F, -1.0F);
        this.ArmR.addBox(4.0F, -2.0F, -2.0F, 4, 8, 4, 0.0F);
        this.setRotateAngle(ArmR, -0.7499679795819634F, 0.0F, 0.0F);
        this.Hat4 = new AdvancedModelRenderer(this, 118, 0);
        this.Hat4.setRotationPoint(1.75F, -2.9F, 2.0F);
        this.Hat4.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F);
        this.setRotateAngle(Hat4, -0.2441715623540067F, 0.01727875959474386F, 0.10471975511965977F);
        this.HatFlap1_7 = new AdvancedModelRenderer(this, 43, 7);
        this.HatFlap1_7.setRotationPoint(10.0F, 4.0F, 7.0F);
        this.HatFlap1_7.addBox(0.0F, 0.0F, 0.0F, 0, 3, 1, 0.0F);
        this.HatFlap1_9 = new AdvancedModelRenderer(this, 43, 15);
        this.HatFlap1_9.setRotationPoint(3.0F, 4.0F, 10.0F);
        this.HatFlap1_9.addBox(0.0F, 0.0F, 0.0F, 1, 3, 0, 0.0F);
        this.HatFlap1_8 = new AdvancedModelRenderer(this, 43, 11);
        this.HatFlap1_8.setRotationPoint(0.0F, 4.0F, 10.0F);
        this.HatFlap1_8.addBox(0.0F, 0.0F, 0.0F, 1, 4, 0, 0.0F);
        this.Robe = new AdvancedModelRenderer(this, 0, 39);
        this.Robe.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Robe.addBox(-4.5F, 0.0F, -3.3F, 9, 18, 7, 0.0F);
        this.Hat3 = new AdvancedModelRenderer(this, 82, 0);
        this.Hat3.setRotationPoint(1.75F, -4.8F, 2.0F);
        this.Hat3.addBox(0.0F, 0.0F, 0.0F, 4, 5, 4, 0.0F);
        this.setRotateAngle(Hat3, -0.20874137853852182F, 0.0F, 0.06963863715457375F);
        this.LegL = new AdvancedModelRenderer(this, 0, 23);
        this.LegL.setRotationPoint(-2.0F, 12.0F, 0.0F);
        this.LegL.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.HatFlap1_2 = new AdvancedModelRenderer(this, 32, 6);
        this.HatFlap1_2.setRotationPoint(5.8F, 4.0F, 10.0F);
        this.HatFlap1_2.addBox(0.0F, 0.0F, 0.0F, 4, 4, 0, 0.0F);
        this.Body = new AdvancedModelRenderer(this, 16, 23);
        this.Body.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Body.addBox(-4.0F, 0.0F, -3.0F, 8, 10, 6, 0.0F);
        this.Hat2 = new AdvancedModelRenderer(this, 54, 0);
        this.Hat2.setRotationPoint(1.75F, -5.9F, 2.0F);
        this.Hat2.addBox(0.0F, 0.0F, 0.0F, 7, 6, 7, 0.0F);
        this.setRotateAngle(Hat2, -0.05235987755982988F, 0.0F, 0.130201562198777F);
        this.HatFlap1_1 = new AdvancedModelRenderer(this, 32, -1);
        this.HatFlap1_1.setRotationPoint(0.0F, 4.0F, 6.0F);
        this.HatFlap1_1.addBox(0.0F, 0.0F, 0.0F, 0, 3, 4, 0.0F);
        this.HatFlap1 = new AdvancedModelRenderer(this, 32, -3);
        this.HatFlap1.setRotationPoint(0.0F, 4.0F, 0.0F);
        this.HatFlap1.addBox(0.0F, 0.0F, 0.0F, 0, 3, 3, 0.0F);
        this.HatFlap1_4 = new AdvancedModelRenderer(this, 32, 13);
        this.HatFlap1_4.setRotationPoint(0.0F, 4.0F, 0.0F);
        this.HatFlap1_4.addBox(0.0F, 0.0F, 0.0F, 2, 4, 0, 0.0F);
        this.Body.addChild(this.Head);
        this.Hat1.addChild(this.HatFlap1_5);
        this.Hat1.addChild(this.HatFlap1_3);
        this.Head.addChild(this.Hat1);
        this.Head.addChild(this.Nose);
        this.Hat1.addChild(this.HatFlap1_6);
        this.Body.addChild(this.LegR);
        this.Body.addChild(this.ArmL);
        this.Body.addChild(this.ArmM);
        this.Body.addChild(this.ArmR);
        this.Hat3.addChild(this.Hat4);
        this.Hat1.addChild(this.HatFlap1_7);
        this.Hat1.addChild(this.HatFlap1_9);
        this.Hat1.addChild(this.HatFlap1_8);
        this.Body.addChild(this.Robe);
        this.Hat2.addChild(this.Hat3);
        this.Body.addChild(this.LegL);
        this.Hat1.addChild(this.HatFlap1_2);
        this.Hat1.addChild(this.Hat2);
        this.Hat1.addChild(this.HatFlap1_1);
        this.Hat1.addChild(this.HatFlap1);
        this.Hat1.addChild(this.HatFlap1_4);

        updateDefaultPose();
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.Body.render(f5);
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
