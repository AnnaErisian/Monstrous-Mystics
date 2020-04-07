package blue.thejester.monstrousmystics.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * ModelBoneMaden - Either Mojang or a mod author
 * Created using Tabula 7.1.0
 */
public class ModelBoneMaden extends ModelBase {
    public ModelRenderer Body;
    public ModelRenderer Head;
    public ModelRenderer ArmL;
    public ModelRenderer ArmR;
    public ModelRenderer LegR;
    public ModelRenderer LegL;
    public ModelRenderer SkirtFFL;
    public ModelRenderer SkirtFR;
    public ModelRenderer SkirtBR;
    public ModelRenderer SkirtFL;
    public ModelRenderer SkirtBL;
    public ModelRenderer SkirtFFR;
    public ModelRenderer SkirtBBL;
    public ModelRenderer SkirtBBR;
    public ModelRenderer Tiara;
    public ModelRenderer ShoulderL;
    public ModelRenderer ShoulderR;

    public ModelBoneMaden() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.ShoulderL = new ModelRenderer(this, 42, 16);
        this.ShoulderL.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ShoulderL.addBox(-1.5F, -3.0F, -1.5F, 3, 3, 3, 0.0F);
        this.SkirtBBR = new ModelRenderer(this, 54, 16);
        this.SkirtBBR.setRotationPoint(1.7F, 9.0F, 2.7F);
        this.SkirtBBR.addBox(-2.0F, 0.0F, 0.0F, 4, 9, 1, 0.0F);
        this.setRotateAngle(SkirtBBR, 0.19198621771937624F, 0.2617993877991494F, 0.0F);
        this.SkirtFR = new ModelRenderer(this, 54, 16);
        this.SkirtFR.setRotationPoint(3.9F, 9.0F, -1.2F);
        this.SkirtFR.addBox(-2.0F, 0.0F, 0.0F, 4, 9, 1, 0.0F);
        this.setRotateAngle(SkirtFR, 0.19198621771937624F, 2.1467549799530254F, 0.0F);
        this.SkirtBR = new ModelRenderer(this, 54, 16);
        this.SkirtBR.setRotationPoint(3.9F, 9.0F, 0.8F);
        this.SkirtBR.addBox(-2.0F, 0.0F, 0.0F, 4, 9, 1, 0.0F);
        this.setRotateAngle(SkirtBR, 0.19198621771937624F, 0.9948376736367678F, 0.0F);
        this.Head = new ModelRenderer(this, 0, 0);
        this.Head.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
        this.SkirtFFR = new ModelRenderer(this, 54, 16);
        this.SkirtFFR.setRotationPoint(1.7F, 9.0F, -2.7F);
        this.SkirtFFR.addBox(-2.0F, 0.0F, 0.0F, 4, 9, 1, 0.0F);
        this.setRotateAngle(SkirtFFR, 0.19198621771937624F, 2.8797932657906435F, 0.0F);
        this.ArmR = new ModelRenderer(this, 0, 16);
        this.ArmR.mirror = true;
        this.ArmR.setRotationPoint(5.0F, 2.4F, 0.0F);
        this.ArmR.addBox(-1.0F, -2.0F, -1.0F, 2, 12, 2, 0.0F);
        this.setRotateAngle(ArmR, 0.0F, 0.0F, -0.22689280275926282F);
        this.Body = new ModelRenderer(this, 32, 0);
        this.Body.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Body.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
        this.ArmL = new ModelRenderer(this, 0, 16);
        this.ArmL.setRotationPoint(-5.0F, 2.4F, 0.0F);
        this.ArmL.addBox(-1.0F, -2.0F, -1.0F, 2, 12, 2, 0.0F);
        this.setRotateAngle(ArmL, 0.0F, 0.0F, 0.22689280275926282F);
        this.ShoulderR = new ModelRenderer(this, 42, 16);
        this.ShoulderR.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ShoulderR.addBox(-1.5F, -3.0F, -1.5F, 3, 3, 3, 0.0F);
        this.SkirtFFL = new ModelRenderer(this, 54, 16);
        this.SkirtFFL.setRotationPoint(-1.7F, 9.0F, -2.7F);
        this.SkirtFFL.addBox(-2.0F, 0.0F, 0.0F, 4, 9, 1, 0.0F);
        this.setRotateAngle(SkirtFFL, 0.19198621771937624F, -2.8797932657906435F, 0.0F);
        this.LegL = new ModelRenderer(this, 0, 16);
        this.LegL.setRotationPoint(-2.0F, 12.0F, 0.1F);
        this.LegL.addBox(-1.0F, 0.0F, -1.0F, 2, 12, 2, 0.0F);
        this.SkirtBL = new ModelRenderer(this, 54, 16);
        this.SkirtBL.setRotationPoint(-3.9F, 9.0F, 0.8F);
        this.SkirtBL.addBox(-2.0F, 0.0F, 0.0F, 4, 9, 1, 0.0F);
        this.setRotateAngle(SkirtBL, 0.19198621771937624F, -0.9948376736367678F, 0.0F);
        this.SkirtBBL = new ModelRenderer(this, 54, 16);
        this.SkirtBBL.setRotationPoint(-1.7F, 9.0F, 2.7F);
        this.SkirtBBL.addBox(-2.0F, 0.0F, 0.0F, 4, 9, 1, 0.0F);
        this.setRotateAngle(SkirtBBL, 0.19198621771937624F, -0.2617993877991494F, 0.0F);
        this.SkirtFL = new ModelRenderer(this, 54, 16);
        this.SkirtFL.setRotationPoint(-3.9F, 9.0F, -1.2F);
        this.SkirtFL.addBox(-2.0F, 0.0F, 0.0F, 4, 9, 1, 0.0F);
        this.setRotateAngle(SkirtFL, 0.19198621771937624F, -2.1467549799530254F, 0.0F);
        this.LegR = new ModelRenderer(this, 0, 16);
        this.LegR.mirror = true;
        this.LegR.setRotationPoint(2.0F, 12.0F, 0.1F);
        this.LegR.addBox(-1.0F, 0.0F, -1.0F, 2, 12, 2, 0.0F);
        this.Tiara = new ModelRenderer(this, 8, 16);
        this.Tiara.setRotationPoint(0.0F, -7.0F, 0.0F);
        this.Tiara.addBox(-4.5F, -5.0F, -4.5F, 9, 5, 9, 0.0F);
        this.ArmL.addChild(this.ShoulderL);
        this.Body.addChild(this.SkirtBBR);
        this.Body.addChild(this.SkirtFR);
        this.Body.addChild(this.SkirtBR);
        this.Body.addChild(this.Head);
        this.Body.addChild(this.SkirtFFR);
        this.Body.addChild(this.ArmR);
        this.Body.addChild(this.ArmL);
        this.ArmR.addChild(this.ShoulderR);
        this.Body.addChild(this.SkirtFFL);
        this.Body.addChild(this.LegL);
        this.Body.addChild(this.SkirtBL);
        this.Body.addChild(this.SkirtBBL);
        this.Body.addChild(this.SkirtFL);
        this.Body.addChild(this.LegR);
        this.Head.addChild(this.Tiara);
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
