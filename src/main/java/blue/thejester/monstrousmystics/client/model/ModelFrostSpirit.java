package blue.thejester.monstrousmystics.client.model;

import blue.thejester.monstrousmystics.client.render.IHasArms;
import net.ilexiconn.llibrary.client.model.ModelAnimator;
import net.ilexiconn.llibrary.client.model.tools.AdvancedModelBase;
import net.ilexiconn.llibrary.client.model.tools.AdvancedModelRenderer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumHandSide;

/**
 * ModelFrostSpirit - Anna Erisian
 * Created using Tabula 7.1.0
 */
public class ModelFrostSpirit extends AdvancedModelBase implements IHasArms {
    private final ModelAnimator animator;
    public AdvancedModelRenderer Body;
    public AdvancedModelRenderer ArmR;
    public AdvancedModelRenderer Head;
    public AdvancedModelRenderer Tail;
    public AdvancedModelRenderer ArmL;
    public AdvancedModelRenderer SpinesR;
    public AdvancedModelRenderer SpinesL;
    public AdvancedModelRenderer TailMiddle;
    public AdvancedModelRenderer TailBottom;
    public AdvancedModelRenderer Spine;
    public AdvancedModelRenderer Spine_1;
    public AdvancedModelRenderer Spine_2;
    public AdvancedModelRenderer Spine_3;
    public AdvancedModelRenderer Spine_4;
    public AdvancedModelRenderer Spine_5;
    public AdvancedModelRenderer Spine_6;
    public AdvancedModelRenderer Spine_7;

    public ModelFrostSpirit() {
        animator = ModelAnimator.create();
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.Head = new AdvancedModelRenderer(this, 0, 20);
        this.Head.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
        this.Spine_1 = new AdvancedModelRenderer(this, 46, 0);
        this.Spine_1.setRotationPoint(0.0F, -0.7F, 0.0F);
        this.Spine_1.addBox(-0.5F, 0.0F, 0.0F, 1, 4, 2, 0.0F);
        this.setRotateAngle(Spine_1, 1.6563174601426187F, 0.0F, 0.0F);
        this.Body = new AdvancedModelRenderer(this, 0, 0);
        this.Body.setRotationPoint(0.0F, -3.0F, 0.0F);
        this.Body.addBox(-5.0F, 0.0F, -2.0F, 10, 15, 5, 0.0F);
        this.setRotateAngle(Body, 0.18203784098300857F, 0.0F, 0.0F);
        this.Spine_5 = new AdvancedModelRenderer(this, 46, 0);
        this.Spine_5.setRotationPoint(0.0F, -0.7F, 0.0F);
        this.Spine_5.addBox(-0.5F, 0.0F, 0.0F, 1, 4, 2, 0.0F);
        this.setRotateAngle(Spine_5, 1.6563174601426187F, 0.0F, 0.0F);
        this.ArmL = new AdvancedModelRenderer(this, 30, 0);
        this.ArmL.setRotationPoint(-6.0F, 2.0F, 0.0F);
        this.ArmL.addBox(-3.0F, -2.0F, -2.0F, 4, 16, 4, 0.0F);
        this.setRotateAngle(ArmL, -1.3962634015954636F, -0.10000736613927509F, 0.10000736613927509F);
        this.Spine_3 = new AdvancedModelRenderer(this, 46, 0);
        this.Spine_3.setRotationPoint(0.0F, 6.0F, -0.4F);
        this.Spine_3.addBox(-0.5F, 0.0F, 0.0F, 1, 4, 2, 0.0F);
        this.setRotateAngle(Spine_3, 1.3962634015954636F, 0.0F, 0.0F);
        this.Spine_7 = new AdvancedModelRenderer(this, 46, 0);
        this.Spine_7.setRotationPoint(0.0F, 6.0F, -0.4F);
        this.Spine_7.addBox(-0.5F, 0.0F, 0.0F, 1, 4, 2, 0.0F);
        this.setRotateAngle(Spine_7, 1.3962634015954636F, 0.0F, 0.0F);
        this.Spine = new AdvancedModelRenderer(this, 46, 0);
        this.Spine.setRotationPoint(0.0F, -3.8F, -0.4F);
        this.Spine.addBox(-0.5F, 0.0F, 0.0F, 1, 4, 2, 0.0F);
        this.setRotateAngle(Spine, 1.7453292519943295F, 0.0F, 0.0F);
        this.SpinesL = new AdvancedModelRenderer(this, 0, 0);
        this.SpinesL.setRotationPoint(-2.1F, 7.0F, 3.0F);
        this.SpinesL.addBox(0.0F, 0.0F, 0.0F, 0, 0, 0, 0.0F);
        this.setRotateAngle(SpinesL, 0.0F, -0.16580627893946132F, -0.041887902047863905F);
        this.TailBottom = new AdvancedModelRenderer(this, 32, 35);
        this.TailBottom.setRotationPoint(0.0F, 4.0F, 0.0F);
        this.TailBottom.addBox(-2.5F, 0.0F, 0.0F, 5, 4, 2, 0.0F);
        this.setRotateAngle(TailBottom, 0.4553564018453205F, 0.0F, 0.0F);
        this.Spine_2 = new AdvancedModelRenderer(this, 46, 0);
        this.Spine_2.setRotationPoint(0.0F, 2.6F, -0.1F);
        this.Spine_2.addBox(-0.5F, 0.0F, 0.0F, 1, 4, 2, 0.0F);
        this.setRotateAngle(Spine_2, 1.48352986419518F, 0.0F, 0.0F);
        this.Tail = new AdvancedModelRenderer(this, 32, 20);
        this.Tail.mirror = true;
        this.Tail.setRotationPoint(0.0F, 15.0F, -1.8F);
        this.Tail.addBox(-4.0F, 0.0F, 0.0F, 8, 6, 3, 0.0F);
        this.Spine_4 = new AdvancedModelRenderer(this, 46, 0);
        this.Spine_4.setRotationPoint(0.0F, -3.8F, -0.4F);
        this.Spine_4.addBox(-0.5F, 0.0F, 0.0F, 1, 4, 2, 0.0F);
        this.setRotateAngle(Spine_4, 1.7453292519943295F, 0.0F, 0.0F);
        this.ArmR = new AdvancedModelRenderer(this, 30, 0);
        this.ArmR.mirror = true;
        this.ArmR.setRotationPoint(6.0F, 2.0F, 0.0F);
        this.ArmR.addBox(-1.0F, -2.0F, -2.0F, 4, 16, 4, 0.0F);
        this.setRotateAngle(ArmR, -1.3962634015954636F, 0.10000736613927509F, -0.10000736613927509F);
        this.Spine_6 = new AdvancedModelRenderer(this, 46, 0);
        this.Spine_6.setRotationPoint(0.0F, 2.6F, -0.1F);
        this.Spine_6.addBox(-0.5F, 0.0F, 0.0F, 1, 4, 2, 0.0F);
        this.setRotateAngle(Spine_6, 1.48352986419518F, 0.0F, 0.0F);
        this.TailMiddle = new AdvancedModelRenderer(this, 32, 29);
        this.TailMiddle.setRotationPoint(0.0F, 6.0F, 0.0F);
        this.TailMiddle.addBox(-3.5F, 0.0F, 0.0F, 7, 4, 2, 0.0F);
        this.setRotateAngle(TailMiddle, 0.31869712141416456F, 0.0F, 0.0F);
        this.SpinesR = new AdvancedModelRenderer(this, 0, 0);
        this.SpinesR.setRotationPoint(2.1F, 7.0F, 3.0F);
        this.SpinesR.addBox(0.0F, 0.0F, 0.0F, 0, 0, 0, 0.0F);
        this.setRotateAngle(SpinesR, 0.0F, 0.16580627893946132F, 0.041887902047863905F);
        this.Body.addChild(this.Head);
        this.SpinesR.addChild(this.Spine_1);
        this.SpinesL.addChild(this.Spine_5);
        this.Body.addChild(this.ArmL);
        this.SpinesR.addChild(this.Spine_3);
        this.SpinesL.addChild(this.Spine_7);
        this.SpinesR.addChild(this.Spine);
        this.Body.addChild(this.SpinesL);
        this.TailMiddle.addChild(this.TailBottom);
        this.SpinesR.addChild(this.Spine_2);
        this.Body.addChild(this.Tail);
        this.SpinesL.addChild(this.Spine_4);
        this.Body.addChild(this.ArmR);
        this.SpinesL.addChild(this.Spine_6);
        this.Tail.addChild(this.TailMiddle);
        this.Body.addChild(this.SpinesR);

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
