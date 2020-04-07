package blue.thejester.monstrousmystics.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * ModelSkeleton - Either Mojang or a mod author
 * Created using Tabula 7.1.0
 */
public class ModelSparkSkeleton extends ModelBase {
    public ModelRenderer Body;
    public ModelRenderer Head;
    public ModelRenderer ArmL;
    public ModelRenderer ArmR;
    public ModelRenderer LegR;
    public ModelRenderer LegL;

    public ModelSparkSkeleton() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.Body = new ModelRenderer(this, 8, 16);
        this.Body.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Body.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
        this.ArmR = new ModelRenderer(this, 32, 16);
        this.ArmR.mirror = true;
        this.ArmR.setRotationPoint(5.0F, 2.0F, 0.0F);
        this.ArmR.addBox(-1.0F, -2.0F, -1.0F, 2, 12, 2, 0.0F);
        this.setRotateAngle(ArmR, 0.0F, 0.0F, -0.10000736613927509F);
        this.LegR = new ModelRenderer(this, 0, 16);
        this.LegR.mirror = true;
        this.LegR.setRotationPoint(2.0F, 12.0F, 0.1F);
        this.LegR.addBox(-1.0F, 0.0F, -1.0F, 2, 12, 2, 0.0F);
        this.Head = new ModelRenderer(this, 0, 0);
        this.Head.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
        this.ArmL = new ModelRenderer(this, 32, 16);
        this.ArmL.setRotationPoint(-5.0F, 2.0F, 0.0F);
        this.ArmL.addBox(-1.0F, -2.0F, -1.0F, 2, 12, 2, 0.0F);
        this.setRotateAngle(ArmL, 0.0F, 0.0F, 0.10000736613927509F);
        this.LegL = new ModelRenderer(this, 0, 16);
        this.LegL.setRotationPoint(-2.0F, 12.0F, 0.1F);
        this.LegL.addBox(-1.0F, 0.0F, -1.0F, 2, 12, 2, 0.0F);
        this.Body.addChild(this.ArmR);
        this.Body.addChild(this.LegR);
        this.Body.addChild(this.Head);
        this.Body.addChild(this.ArmL);
        this.Body.addChild(this.LegL);
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
