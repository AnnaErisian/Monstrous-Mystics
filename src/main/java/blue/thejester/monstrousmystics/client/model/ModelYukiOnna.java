package blue.thejester.monstrousmystics.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * ModelYukiOnna - Either Mojang or a mod author
 * Created using Tabula 7.1.0
 */
public class ModelYukiOnna extends ModelBase {
    public ModelRenderer Body;
    public ModelRenderer Head;
    public ModelRenderer ArmR;
    public ModelRenderer ArmL;
    public ModelRenderer DressTop;
    public ModelRenderer Hair;
    public ModelRenderer HairFront;
    public ModelRenderer SleeveR;
    public ModelRenderer SleeveL;
    public ModelRenderer DressMid;
    public ModelRenderer DressBot;

    public ModelYukiOnna() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.Head = new ModelRenderer(this, 30, 0);
        this.Head.setRotationPoint(0.0F, 0.0F, -0.0F);
        this.Head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
        this.SleeveL = new ModelRenderer(this, 48, 50);
        this.SleeveL.mirror = true;
        this.SleeveL.setRotationPoint(0.0F, -1.9F, 0.0F);
        this.SleeveL.addBox(-2.0F, -0.3F, -2.0F, 4, 10, 4, 0.0F);
        this.Hair = new ModelRenderer(this, 0, 0);
        this.Hair.setRotationPoint(0.0F, -8.0F, 0.0F);
        this.Hair.addBox(-4.5F, -0.5F, -1.7F, 9, 15, 6, 0.0F);
        this.DressBot = new ModelRenderer(this, 0, 45);
        this.DressBot.setRotationPoint(0.0F, 7.3F, 0.0F);
        this.DressBot.addBox(-7.0F, 0.0F, -4.5F, 14, 9, 9, 0.0F);
        this.DressTop = new ModelRenderer(this, 24, 16);
        this.DressTop.setRotationPoint(0.0F, 11.3F, 0.0F);
        this.DressTop.addBox(-5.0F, 0.0F, -3.0F, 10, 7, 6, 0.0F);
        this.SleeveR = new ModelRenderer(this, 48, 50);
        this.SleeveR.mirror = true;
        this.SleeveR.setRotationPoint(0.0F, -1.9F, 0.0F);
        this.SleeveR.addBox(-2.0F, -0.3F, -2.0F, 4, 10, 4, 0.0F);
        this.ArmL = new ModelRenderer(this, 56, 16);
        this.ArmL.setRotationPoint(-5.0F, 2.0F, 0.0F);
        this.ArmL.addBox(-1.0F, -2.0F, -1.0F, 2, 16, 2, 0.0F);
        this.setRotateAngle(ArmL, 0.0F, 0.0F, 0.12095131716320703F);
        this.HairFront = new ModelRenderer(this, 0, 0);
        this.HairFront.setRotationPoint(-4.5F, 0.0F, -3.0F);
        this.HairFront.addBox(0.0F, -0.5F, -1.5F, 9, 3, 6, 0.0F);
        this.Body = new ModelRenderer(this, 40, 34);
        this.Body.setRotationPoint(0.0F, -10.0F, -0.0F);
        this.Body.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
        this.DressMid = new ModelRenderer(this, 0, 29);
        this.DressMid.setRotationPoint(0.0F, 6.3F, 0.0F);
        this.DressMid.addBox(-6.0F, 0.0F, -4.0F, 12, 8, 8, 0.0F);
        this.ArmR = new ModelRenderer(this, 56, 16);
        this.ArmR.mirror = true;
        this.ArmR.setRotationPoint(5.0F, 2.0F, 0.0F);
        this.ArmR.addBox(-1.0F, -2.0F, -1.0F, 2, 16, 2, 0.0F);
        this.setRotateAngle(ArmR, 0.0F, 0.0F, -0.10000736613927509F);
        this.Body.addChild(this.Head);
        this.ArmL.addChild(this.SleeveL);
        this.Head.addChild(this.Hair);
        this.DressMid.addChild(this.DressBot);
        this.Body.addChild(this.DressTop);
        this.ArmR.addChild(this.SleeveR);
        this.Body.addChild(this.ArmL);
        this.Hair.addChild(this.HairFront);
        this.DressTop.addChild(this.DressMid);
        this.Body.addChild(this.ArmR);
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
