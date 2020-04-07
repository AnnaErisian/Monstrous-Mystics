package blue.thejester.monstrousmystics.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * ModelImp - Either Mojang or a mod author
 * Created using Tabula 7.1.0
 */
public class ModelImp extends ModelBase {
    public ModelRenderer Body;
    public ModelRenderer ArmR;
    public ModelRenderer Head;
    public ModelRenderer LegR;
    public ModelRenderer LegL;
    public ModelRenderer ArmL;
    public ModelRenderer HornR;
    public ModelRenderer HornL;

    public ModelImp() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.HornR = new ModelRenderer(this, 0, 0);
        this.HornR.mirror = true;
        this.HornR.setRotationPoint(2.8F, -10.5F, -4.1F);
        this.HornR.addBox(-0.5F, 0.0F, 0.0F, 1, 3, 2, 0.0F);
        this.setRotateAngle(HornR, 0.20943951023931953F, -0.11693705988362009F, 0.10122909661567112F);
        this.HornL = new ModelRenderer(this, 0, 0);
        this.HornL.mirror = true;
        this.HornL.setRotationPoint(-2.8F, -10.5F, -4.1F);
        this.HornL.addBox(-0.5F, 0.0F, 0.0F, 1, 3, 2, 0.0F);
        this.setRotateAngle(HornL, 0.20943951023931953F, 0.11693705988362009F, -0.10122909661567112F);
        this.ArmR = new ModelRenderer(this, 32, 0);
        this.ArmR.mirror = true;
        this.ArmR.setRotationPoint(5.0F, 2.0F, 0.0F);
        this.ArmR.addBox(-1.0F, -2.0F, -2.0F, 3, 10, 3, 0.0F);
        this.setRotateAngle(ArmR, -1.3962634015954636F, 0.10000736613927509F, -0.10000736613927509F);
        this.LegL = new ModelRenderer(this, 0, 16);
        this.LegL.setRotationPoint(-1.9F, 10.0F, 0.1F);
        this.LegL.addBox(-2.0F, 0.0F, -2.0F, 4, 10, 4, 0.0F);
        this.ArmL = new ModelRenderer(this, 32, 0);
        this.ArmL.setRotationPoint(-5.0F, 2.0F, 0.0F);
        this.ArmL.addBox(-2.0F, -2.0F, -2.0F, 3, 10, 3, 0.0F);
        this.setRotateAngle(ArmL, -1.3962634015954636F, -0.10000736613927509F, 0.10000736613927509F);
        this.Head = new ModelRenderer(this, 0, 0);
        this.Head.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
        this.LegR = new ModelRenderer(this, 0, 16);
        this.LegR.mirror = true;
        this.LegR.setRotationPoint(1.9F, 10.0F, 0.1F);
        this.LegR.addBox(-2.0F, 0.0F, -2.0F, 4, 10, 4, 0.0F);
        this.Body = new ModelRenderer(this, 16, 16);
        this.Body.setRotationPoint(0.0F, 4.0F, 0.0F);
        this.Body.addBox(-4.0F, 0.0F, -2.0F, 8, 10, 4, 0.0F);
        this.Head.addChild(this.HornR);
        this.Head.addChild(this.HornL);
        this.Body.addChild(this.ArmR);
        this.Body.addChild(this.LegL);
        this.Body.addChild(this.ArmL);
        this.Body.addChild(this.Head);
        this.Body.addChild(this.LegR);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.Body.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
