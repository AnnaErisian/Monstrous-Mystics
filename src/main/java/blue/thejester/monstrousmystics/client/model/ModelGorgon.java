package blue.thejester.monstrousmystics.client.model;

import net.ilexiconn.llibrary.client.model.ModelAnimator;
import net.ilexiconn.llibrary.client.model.tools.AdvancedModelBase;
import net.ilexiconn.llibrary.client.model.tools.AdvancedModelRenderer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;

/**
 * ModelGorgon - Anna Erisian
 * Created using Tabula 7.1.0
 */
public class ModelGorgon extends AdvancedModelBase {
    private final ModelAnimator animator;
    public AdvancedModelRenderer Base;
    public AdvancedModelRenderer Body1;
    public AdvancedModelRenderer Tail1;
    public AdvancedModelRenderer Body2;
    public AdvancedModelRenderer Head;
    public AdvancedModelRenderer ArmR;
    public AdvancedModelRenderer ArmL;
    public AdvancedModelRenderer SnakeR1;
    public AdvancedModelRenderer ShakeR2;
    public AdvancedModelRenderer ShakeBR;
    public AdvancedModelRenderer ShakeB;
    public AdvancedModelRenderer ShakeBL;
    public AdvancedModelRenderer SnakeL1;
    public AdvancedModelRenderer ShakeL2;
    public AdvancedModelRenderer ShakeFR;
    public AdvancedModelRenderer ShakeFL;
    public AdvancedModelRenderer Tail2;
    public AdvancedModelRenderer Tail3;
    public AdvancedModelRenderer Tail4;
    public AdvancedModelRenderer Tail3_1;

    public ModelGorgon() {
        animator = ModelAnimator.create();
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.ArmL = new AdvancedModelRenderer(this, 12, 18);
        this.ArmL.setRotationPoint(-5.0F, -8.4F, 0.0F);
        this.ArmL.addBox(-2.0F, -1.5F, -1.5F, 3, 11, 3, 0.0F);
        this.setRotateAngle(ArmL, -0.3490658503988659F, 0.0F, 0.08726646259971647F);
        this.ShakeL2 = new AdvancedModelRenderer(this, 12, 0);
        this.ShakeL2.setRotationPoint(-4.2F, -7.5F, 2.0F);
        this.ShakeL2.addBox(0.0F, 0.0F, -1.0F, 1, 9, 2, 0.0F);
        this.setRotateAngle(ShakeL2, 0.13962634015954636F, 0.0F, 0.3141592653589793F);
        this.Tail3_1 = new AdvancedModelRenderer(this, 106, 54);
        this.Tail3_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Tail3_1.addBox(-1.5F, 1.0F, 8.0F, 3, 2, 8, 0.0F);
        this.Head = new AdvancedModelRenderer(this, 40, 0);
        this.Head.setRotationPoint(0.0F, -10.0F, -0.5F);
        this.Head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
        this.setRotateAngle(Head, 0.0F, -0.017453292519943295F, 0.0F);
        this.SnakeL1 = new AdvancedModelRenderer(this, 6, 0);
        this.SnakeL1.setRotationPoint(-4.2F, -7.5F, -2.0F);
        this.SnakeL1.addBox(0.0F, 0.0F, -1.0F, 1, 7, 2, 0.0F);
        this.setRotateAngle(SnakeL1, 0.13962634015954636F, 0.0F, 0.3141592653589793F);
        this.Tail2 = new AdvancedModelRenderer(this, 90, 34);
        this.Tail2.setRotationPoint(0.0F, 0.0F, 12.0F);
        this.Tail2.addBox(-3.0F, -2.0F, 0.0F, 6, 5, 13, 0.0F);
        this.ArmR = new AdvancedModelRenderer(this, 0, 18);
        this.ArmR.setRotationPoint(5.0F, -8.4F, 0.0F);
        this.ArmR.addBox(-1.0F, -1.5F, -1.5F, 3, 11, 3, 0.0F);
        this.setRotateAngle(ArmR, -0.3490658503988659F, 0.0F, -0.08726646259971647F);
        this.Tail3 = new AdvancedModelRenderer(this, 48, 49);
        this.Tail3.setRotationPoint(0.0F, 0.0F, 12.0F);
        this.Tail3.addBox(-2.5F, -1.0F, 0.0F, 5, 4, 11, 0.0F);
        this.Body1 = new AdvancedModelRenderer(this, 72, 0);
        this.Body1.setRotationPoint(0.0F, 1.0F, -0.7F);
        this.Body1.addBox(-4.0F, -10.0F, -3.0F, 8, 10, 6, 0.0F);
        this.Tail1 = new AdvancedModelRenderer(this, 50, 30);
        this.Tail1.setRotationPoint(0.0F, 8.5F, -1.7F);
        this.Tail1.addBox(-3.5F, -3.0F, 0.0F, 7, 6, 13, 0.0F);
        this.ShakeR2 = new AdvancedModelRenderer(this, 12, 0);
        this.ShakeR2.setRotationPoint(4.2F, -7.5F, 2.0F);
        this.ShakeR2.addBox(-1.0F, 0.0F, -1.0F, 1, 9, 2, 0.0F);
        this.setRotateAngle(ShakeR2, 0.13962634015954636F, 0.0F, -0.3141592653589793F);
        this.ShakeBL = new AdvancedModelRenderer(this, 18, 0);
        this.ShakeBL.setRotationPoint(-2.6F, -7.5F, 4.2F);
        this.ShakeBL.addBox(-1.0F, 0.0F, -1.0F, 2, 9, 1, 0.0F);
        this.setRotateAngle(ShakeBL, 0.3141592653589793F, 0.0F, 0.08726646259971647F);
        this.ShakeFL = new AdvancedModelRenderer(this, 0, 0);
        this.ShakeFL.setRotationPoint(-2.6F, -7.5F, -4.2F);
        this.ShakeFL.addBox(-1.0F, 0.0F, 0.0F, 2, 5, 1, 0.0F);
        this.setRotateAngle(ShakeFL, -0.3141592653589793F, 0.0F, 0.20943951023931953F);
        this.Body2 = new AdvancedModelRenderer(this, 100, 0);
        this.Body2.setRotationPoint(0.0F, -10.0F, 0.0F);
        this.Body2.addBox(-4.0F, -10.0F, -3.0F, 8, 12, 6, 0.0F);
        this.setRotateAngle(Body2, -0.017453292519943295F, 0.0F, 0.0F);
        this.ShakeB = new AdvancedModelRenderer(this, 24, 0);
        this.ShakeB.setRotationPoint(0.0F, -7.5F, 4.2F);
        this.ShakeB.addBox(-1.0F, 0.0F, -1.0F, 2, 9, 1, 0.0F);
        this.setRotateAngle(ShakeB, 0.3141592653589793F, 0.0F, 0.0F);
        this.ShakeFR = new AdvancedModelRenderer(this, 0, 0);
        this.ShakeFR.setRotationPoint(2.6F, -7.5F, -4.2F);
        this.ShakeFR.addBox(-1.0F, 0.0F, 0.0F, 2, 5, 1, 0.0F);
        this.setRotateAngle(ShakeFR, -0.3141592653589793F, 0.0F, -0.20943951023931953F);
        this.Base = new AdvancedModelRenderer(this, 16, 46);
        this.Base.setRotationPoint(0.0F, 12.0F, 0.0F);
        this.Base.addBox(-4.0F, 0.0F, -4.0F, 8, 10, 8, 0.0F);
        this.SnakeR1 = new AdvancedModelRenderer(this, 6, 0);
        this.SnakeR1.setRotationPoint(4.2F, -7.5F, -2.0F);
        this.SnakeR1.addBox(-1.0F, 0.0F, -1.0F, 1, 7, 2, 0.0F);
        this.setRotateAngle(SnakeR1, 0.13962634015954636F, 0.0F, -0.3141592653589793F);
        this.ShakeBR = new AdvancedModelRenderer(this, 18, 0);
        this.ShakeBR.setRotationPoint(2.6F, -7.5F, 4.2F);
        this.ShakeBR.addBox(-1.0F, 0.0F, -1.0F, 2, 9, 1, 0.0F);
        this.setRotateAngle(ShakeBR, 0.3141592653589793F, 0.0F, -0.08726646259971647F);
        this.Tail4 = new AdvancedModelRenderer(this, 80, 52);
        this.Tail4.setRotationPoint(0.0F, 0.0F, 10.0F);
        this.Tail4.addBox(-2.0F, 0.0F, 0.0F, 4, 3, 9, 0.0F);
        this.Body2.addChild(this.ArmL);
        this.Head.addChild(this.ShakeL2);
        this.Tail4.addChild(this.Tail3_1);
        this.Body2.addChild(this.Head);
        this.Head.addChild(this.SnakeL1);
        this.Tail1.addChild(this.Tail2);
        this.Body2.addChild(this.ArmR);
        this.Tail2.addChild(this.Tail3);
        this.Base.addChild(this.Body1);
        this.Base.addChild(this.Tail1);
        this.Head.addChild(this.ShakeR2);
        this.Head.addChild(this.ShakeBL);
        this.Head.addChild(this.ShakeFL);
        this.Body1.addChild(this.Body2);
        this.Head.addChild(this.ShakeB);
        this.Head.addChild(this.ShakeFR);
        this.Head.addChild(this.SnakeR1);
        this.Head.addChild(this.ShakeBR);
        this.Tail3.addChild(this.Tail4);

        updateDefaultPose();
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.Base.render(f5);
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
