package blue.thejester.monstrousmystics.client.model;

import net.ilexiconn.llibrary.client.model.ModelAnimator;
import net.ilexiconn.llibrary.client.model.tools.AdvancedModelBase;
import net.ilexiconn.llibrary.client.model.tools.AdvancedModelRenderer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;

/**
 * Enderghast - Anna Erisian
 * Created using Tabula 7.1.0
 */
public class ModelEndergeist extends AdvancedModelBase {
    private final ModelAnimator animator;
    public AdvancedModelRenderer BodyTop;
    public AdvancedModelRenderer BodyMid;
    public AdvancedModelRenderer HeadRoot;
    public AdvancedModelRenderer BodyBottom;
    public AdvancedModelRenderer HeadLowerLeft;
    public AdvancedModelRenderer HeadLowerRight;
    public AdvancedModelRenderer HeadUpperRight;
    public AdvancedModelRenderer HeadUpperLeft;
    public AdvancedModelRenderer Tendril1;
    public AdvancedModelRenderer Tendril2;
    public AdvancedModelRenderer Tendril3;
    public AdvancedModelRenderer Tendril1_1;
    public AdvancedModelRenderer Tendril2_1;
    public AdvancedModelRenderer Tendril3_1;
    public AdvancedModelRenderer Tendril1_2;
    public AdvancedModelRenderer Tendril2_2;
    public AdvancedModelRenderer Tendril3_2;
    public AdvancedModelRenderer Tendril1_3;
    public AdvancedModelRenderer Tendril2_3;
    public AdvancedModelRenderer Tendril3_3;

    public ModelEndergeist() {
        animator = ModelAnimator.create();
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.HeadUpperLeft = new AdvancedModelRenderer(this, 0, 12);
        this.HeadUpperLeft.setRotationPoint(0.0F, -4.0F, 1.0F);
        this.HeadUpperLeft.addBox(-4.0F, -4.0F, -5.0F, 4, 4, 8, 0.0F);
        this.Tendril2_2 = new AdvancedModelRenderer(this, 48, 0);
        this.Tendril2_2.setRotationPoint(3.6F, -3.5F, -1.5F);
        this.Tendril2_2.addBox(-0.5F, 0.0F, -0.5F, 1, 4, 1, 0.0F);
        this.setRotateAngle(Tendril2_2, 0.045553093477052F, 0.22759093446006054F, -0.5235987755982988F);
        this.HeadLowerLeft = new AdvancedModelRenderer(this, 0, 0);
        this.HeadLowerLeft.setRotationPoint(0.0F, -4.0F, 1.0F);
        this.HeadLowerLeft.addBox(-4.0F, 0.0F, -5.0F, 4, 4, 8, 0.0F);
        this.Tendril1_3 = new AdvancedModelRenderer(this, 48, 0);
        this.Tendril1_3.setRotationPoint(-3.6F, -3.5F, 0.6F);
        this.Tendril1_3.addBox(-0.5F, 0.0F, -0.5F, 1, 4, 1, 0.0F);
        this.setRotateAngle(Tendril1_3, 0.18203784098300857F, -0.22759093446006054F, 0.5235987755982988F);
        this.Tendril2_1 = new AdvancedModelRenderer(this, 48, 0);
        this.Tendril2_1.setRotationPoint(3.1F, 3.5F, -1.5F);
        this.Tendril2_1.addBox(-0.5F, 0.0F, -0.5F, 1, 4, 1, 0.0F);
        this.setRotateAngle(Tendril2_1, 0.045553093477052F, 0.22759093446006054F, -0.18203784098300857F);
        this.Tendril3 = new AdvancedModelRenderer(this, 48, 0);
        this.Tendril3.setRotationPoint(-3.1F, 3.5F, -3.6F);
        this.Tendril3.addBox(-0.5F, 0.0F, -0.5F, 1, 4, 1, 0.0F);
        this.setRotateAngle(Tendril3, -0.136659280431156F, -0.22759093446006054F, 0.31869712141416456F);
        this.BodyTop = new AdvancedModelRenderer(this, 24, 1);
        this.BodyTop.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.BodyTop.addBox(-1.5F, 0.0F, -1.5F, 3, 8, 3, 0.0F);
        this.setRotateAngle(BodyTop, 0.22759093446006054F, 0.0F, 0.0F);
        this.Tendril2 = new AdvancedModelRenderer(this, 48, 0);
        this.Tendril2.setRotationPoint(-3.1F, 3.5F, -1.5F);
        this.Tendril2.addBox(-0.5F, 0.0F, -0.5F, 1, 4, 1, 0.0F);
        this.setRotateAngle(Tendril2, 0.045553093477052F, -0.22759093446006054F, 0.18203784098300857F);
        this.BodyBottom = new AdvancedModelRenderer(this, 44, 3);
        this.BodyBottom.setRotationPoint(0.0F, 7.5F, 0.0F);
        this.BodyBottom.addBox(-1.5F, 0.0F, -1.4F, 1, 8, 1, 0.0F);
        this.setRotateAngle(BodyBottom, 0.31869712141416456F, 0.5009094953223726F, 0.8651597102135892F);
        this.Tendril2_3 = new AdvancedModelRenderer(this, 48, 0);
        this.Tendril2_3.setRotationPoint(-3.6F, -3.5F, -1.5F);
        this.Tendril2_3.addBox(-0.5F, 0.0F, -0.5F, 1, 4, 1, 0.0F);
        this.setRotateAngle(Tendril2_3, 0.045553093477052F, -0.22759093446006054F, 0.5235987755982988F);
        this.Tendril1 = new AdvancedModelRenderer(this, 48, 0);
        this.Tendril1.setRotationPoint(-3.1F, 3.5F, 0.6F);
        this.Tendril1.addBox(-0.5F, 0.0F, -0.5F, 1, 4, 1, 0.0F);
        this.setRotateAngle(Tendril1, 0.18203784098300857F, -0.22759093446006054F, 0.18203784098300857F);
        this.Tendril3_2 = new AdvancedModelRenderer(this, 48, 0);
        this.Tendril3_2.setRotationPoint(3.6F, -3.5F, -3.6F);
        this.Tendril3_2.addBox(-0.5F, 0.0F, -0.5F, 1, 4, 1, 0.0F);
        this.setRotateAngle(Tendril3_2, -0.136659280431156F, 0.22759093446006054F, -0.5235987755982988F);
        this.Tendril1_2 = new AdvancedModelRenderer(this, 48, 0);
        this.Tendril1_2.setRotationPoint(3.6F, -3.5F, 0.6F);
        this.Tendril1_2.addBox(-0.5F, 0.0F, -0.5F, 1, 4, 1, 0.0F);
        this.setRotateAngle(Tendril1_2, 0.18203784098300857F, 0.22759093446006054F, -0.5235987755982988F);
        this.HeadRoot = new AdvancedModelRenderer(this, 0, 0);
        this.HeadRoot.setRotationPoint(0.0F, 0.5F, 0.0F);
        this.HeadRoot.addBox(0.0F, 0.0F, 0.0F, 0, 0, 0, 0.0F);
        this.setRotateAngle(HeadRoot, -0.22759093446006054F, 0.0F, 0.0F);
        this.Tendril3_3 = new AdvancedModelRenderer(this, 48, 0);
        this.Tendril3_3.setRotationPoint(-3.6F, -3.5F, -3.6F);
        this.Tendril3_3.addBox(-0.5F, 0.0F, -0.5F, 1, 4, 1, 0.0F);
        this.setRotateAngle(Tendril3_3, -0.136659280431156F, -0.22759093446006054F, 0.5235987755982988F);
        this.Tendril3_1 = new AdvancedModelRenderer(this, 48, 0);
        this.Tendril3_1.setRotationPoint(3.1F, 3.5F, -3.6F);
        this.Tendril3_1.addBox(-0.5F, 0.0F, -0.5F, 1, 4, 1, 0.0F);
        this.setRotateAngle(Tendril3_1, -0.136659280431156F, 0.22759093446006054F, -0.31869712141416456F);
        this.BodyMid = new AdvancedModelRenderer(this, 36, 2);
        this.BodyMid.setRotationPoint(0.0F, 7.5F, 0.0F);
        this.BodyMid.addBox(-1.5F, 0.0F, -1.4F, 2, 8, 2, 0.0F);
        this.setRotateAngle(BodyMid, 0.22759093446006054F, -0.5009094953223726F, -0.40980330836826856F);
        this.HeadUpperRight = new AdvancedModelRenderer(this, 24, 12);
        this.HeadUpperRight.setRotationPoint(0.0F, -4.0F, 1.0F);
        this.HeadUpperRight.addBox(0.0F, -4.0F, -5.0F, 4, 4, 8, 0.0F);
        this.HeadLowerRight = new AdvancedModelRenderer(this, 0, 0);
        this.HeadLowerRight.mirror = true;
        this.HeadLowerRight.setRotationPoint(0.0F, -4.0F, 1.0F);
        this.HeadLowerRight.addBox(0.0F, 0.0F, -5.0F, 4, 4, 8, 0.0F);
        this.Tendril1_1 = new AdvancedModelRenderer(this, 48, 0);
        this.Tendril1_1.setRotationPoint(3.1F, 3.5F, 0.6F);
        this.Tendril1_1.addBox(-0.5F, 0.0F, -0.5F, 1, 4, 1, 0.0F);
        this.setRotateAngle(Tendril1_1, 0.18203784098300857F, 0.22759093446006054F, -0.18203784098300857F);
        this.HeadRoot.addChild(this.HeadUpperLeft);
        this.HeadUpperRight.addChild(this.Tendril2_2);
        this.HeadRoot.addChild(this.HeadLowerLeft);
        this.HeadUpperLeft.addChild(this.Tendril1_3);
        this.HeadLowerRight.addChild(this.Tendril2_1);
        this.HeadLowerLeft.addChild(this.Tendril3);
        this.HeadLowerLeft.addChild(this.Tendril2);
        this.BodyMid.addChild(this.BodyBottom);
        this.HeadUpperLeft.addChild(this.Tendril2_3);
        this.HeadLowerLeft.addChild(this.Tendril1);
        this.HeadUpperRight.addChild(this.Tendril3_2);
        this.HeadUpperRight.addChild(this.Tendril1_2);
        this.BodyTop.addChild(this.HeadRoot);
        this.HeadUpperLeft.addChild(this.Tendril3_3);
        this.HeadLowerRight.addChild(this.Tendril3_1);
        this.BodyTop.addChild(this.BodyMid);
        this.HeadRoot.addChild(this.HeadUpperRight);
        this.HeadRoot.addChild(this.HeadLowerRight);
        this.HeadLowerRight.addChild(this.Tendril1_1);

        updateDefaultPose();
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.BodyTop.render(f5);
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
