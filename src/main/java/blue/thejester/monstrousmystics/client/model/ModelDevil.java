package blue.thejester.monstrousmystics.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * ModelDevil - Either Mojang or a mod author
 * Created using Tabula 7.1.0
 */
public class ModelDevil extends ModelBase {
    public ModelRenderer Body;
    public ModelRenderer ArmR;
    public ModelRenderer Head;
    public ModelRenderer LegR;
    public ModelRenderer LegL;
    public ModelRenderer ArmL;
    public ModelRenderer HornR;
    public ModelRenderer HornL;
    public ModelRenderer HornRR;
    public ModelRenderer HornRRR;
    public ModelRenderer HornLL;
    public ModelRenderer HornLLL;

    public ModelDevil() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.LegL = new ModelRenderer(this, 32, 22);
        this.LegL.setRotationPoint(-3.9F, 16.0F, 0.1F);
        this.LegL.addBox(-2.7F, 0.0F, -2.0F, 6, 16, 6, 0.0F);
        this.ArmL = new ModelRenderer(this, 40, 0);
        this.ArmL.setRotationPoint(-7.2F, 2.3F, 0.0F);
        this.ArmL.addBox(-4.3F, -1.8F, -1.8F, 5, 16, 6, 0.0F);
        this.setRotateAngle(ArmL, -1.3089969389957472F, 0.08726646259971647F, 0.08726646259971647F);
        this.HornR = new ModelRenderer(this, 0, 38);
        this.HornR.mirror = true;
        this.HornR.setRotationPoint(1.9F, -6.9F, -1.6F);
        this.HornR.addBox(-1.5F, -5.0F, -1.5F, 3, 5, 3, 0.0F);
        this.setRotateAngle(HornR, 0.6373942428283291F, -1.2292353921796064F, 0.136659280431156F);
        this.Body = new ModelRenderer(this, 0, 0);
        this.Body.setRotationPoint(0.0F, -8.0F, 0.0F);
        this.Body.addBox(-7.0F, 0.0F, -2.0F, 14, 16, 6, 0.0F);
        this.HornLL = new ModelRenderer(this, 12, 38);
        this.HornLL.setRotationPoint(0.0F, -4.7F, -0.2F);
        this.HornLL.addBox(-1.0F, -5.0F, -1.0F, 2, 5, 2, 0.0F);
        this.setRotateAngle(HornLL, -0.27314402793711257F, 0.0F, 0.0F);
        this.HornRRR = new ModelRenderer(this, 20, 38);
        this.HornRRR.mirror = true;
        this.HornRRR.setRotationPoint(0.0F, -1.8F, -0.3F);
        this.HornRRR.addBox(-0.5F, -5.0F, -0.5F, 1, 2, 1, 0.0F);
        this.setRotateAngle(HornRRR, -0.091106186954104F, 0.0F, 0.0F);
        this.HornLLL = new ModelRenderer(this, 20, 38);
        this.HornLLL.setRotationPoint(0.0F, -1.8F, -0.3F);
        this.HornLLL.addBox(-0.5F, -5.0F, -0.5F, 1, 2, 1, 0.0F);
        this.setRotateAngle(HornLLL, -0.091106186954104F, 0.0F, 0.0F);
        this.LegR = new ModelRenderer(this, 32, 22);
        this.LegR.mirror = true;
        this.LegR.setRotationPoint(1.9F, 16.0F, 0.1F);
        this.LegR.addBox(-1.3F, 0.0F, -2.0F, 6, 16, 6, 0.0F);
        this.ArmR = new ModelRenderer(this, 40, 0);
        this.ArmR.mirror = true;
        this.ArmR.setRotationPoint(7.2F, 2.3F, 0.0F);
        this.ArmR.addBox(-0.7F, -2.0F, -1.8F, 5, 16, 6, 0.0F);
        this.setRotateAngle(ArmR, -1.3089969389957472F, -0.08726646259971647F, -0.08726646259971647F);
        this.Head = new ModelRenderer(this, 0, 22);
        this.Head.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
        this.HornL = new ModelRenderer(this, 0, 38);
        this.HornL.setRotationPoint(-1.9F, -6.9F, -1.6F);
        this.HornL.addBox(-1.5F, -5.0F, -1.5F, 3, 5, 3, 0.0F);
        this.setRotateAngle(HornL, 0.6373942428283291F, 1.2292353921796064F, -0.136659280431156F);
        this.HornRR = new ModelRenderer(this, 12, 38);
        this.HornRR.mirror = true;
        this.HornRR.setRotationPoint(0.0F, -4.7F, -0.2F);
        this.HornRR.addBox(-1.0F, -5.0F, -1.0F, 2, 5, 2, 0.0F);
        this.setRotateAngle(HornRR, -0.27314402793711257F, 0.0F, 0.0F);
        this.Body.addChild(this.LegL);
        this.Body.addChild(this.ArmL);
        this.Head.addChild(this.HornR);
        this.HornL.addChild(this.HornLL);
        this.HornRR.addChild(this.HornRRR);
        this.HornLL.addChild(this.HornLLL);
        this.Body.addChild(this.LegR);
        this.Body.addChild(this.ArmR);
        this.Body.addChild(this.Head);
        this.Head.addChild(this.HornL);
        this.HornR.addChild(this.HornRR);
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
