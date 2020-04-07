package blue.thejester.monstrousmystics.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * ModelKraken - Anna Erisian
 * Created using Tabula 7.1.0
 */
public class ModelKraken extends ModelBase {
    public ModelRenderer Head;
    public ModelRenderer TentacleF;
    public ModelRenderer TentacleFR;
    public ModelRenderer TentacleBR;
    public ModelRenderer TentacleB;
    public ModelRenderer TentacleBL;
    public ModelRenderer TentacleFR_1;
    public ModelRenderer HeadTop;
    public ModelRenderer HeadFinR;
    public ModelRenderer HeadFinL;

    public ModelKraken() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.TentacleFR_1 = new ModelRenderer(this, 48, 0);
        this.TentacleFR_1.setRotationPoint(1.34F, 8.0F, -3.54F);
        this.TentacleFR_1.addBox(-1.0F, 0.0F, -1.0F, 2, 18, 2, 0.0F);
        this.setRotateAngle(TentacleFR_1, 0.0F, -3.9269908169872414F, 0.0F);
        this.TentacleB = new ModelRenderer(this, 48, 0);
        this.TentacleB.setRotationPoint(-5.0F, 8.0F, 0.0F);
        this.TentacleB.addBox(-1.0F, 0.0F, -1.0F, 2, 18, 2, 0.0F);
        this.setRotateAngle(TentacleB, 0.0F, -1.5707963267948966F, 0.0F);
        this.TentacleBR = new ModelRenderer(this, 48, 0);
        this.TentacleBR.setRotationPoint(-3.14F, 8.0F, 3.54F);
        this.TentacleBR.addBox(-1.0F, 0.0F, -1.0F, 2, 18, 2, 0.0F);
        this.setRotateAngle(TentacleBR, 0.0F, -0.7853981633974483F, 0.0F);
        this.TentacleBL = new ModelRenderer(this, 48, 0);
        this.TentacleBL.setRotationPoint(-3.14F, 8.0F, -3.54F);
        this.TentacleBL.addBox(-1.0F, 0.0F, -1.0F, 2, 18, 2, 0.0F);
        this.setRotateAngle(TentacleBL, 0.0F, -2.356194490192345F, 0.0F);
        this.HeadFinR = new ModelRenderer(this, 0, 0);
        this.HeadFinR.mirror = true;
        this.HeadFinR.setRotationPoint(0.0F, -4.9F, 3.8F);
        this.HeadFinR.addBox(-1.0F, -3.5F, -2.0F, 2, 7, 4, 0.0F);
        this.setRotateAngle(HeadFinR, 0.4553564018453205F, 0.0F, 0.0F);
        this.Head = new ModelRenderer(this, 0, 0);
        this.Head.setRotationPoint(0.0F, 8.0F, 0.0F);
        this.Head.addBox(-6.0F, -8.0F, -6.0F, 10, 16, 12, 0.0F);
        this.TentacleF = new ModelRenderer(this, 48, 0);
        this.TentacleF.setRotationPoint(3.0F, 8.0F, 0.0F);
        this.TentacleF.addBox(-1.0F, 0.0F, -1.0F, 2, 18, 2, 0.0F);
        this.setRotateAngle(TentacleF, 0.0F, 1.5707963267948966F, 0.0F);
        this.HeadFinL = new ModelRenderer(this, 0, 0);
        this.HeadFinL.setRotationPoint(0.0F, -4.9F, -3.8F);
        this.HeadFinL.addBox(-1.0F, -3.5F, -2.0F, 2, 7, 4, 0.0F);
        this.setRotateAngle(HeadFinL, -0.4553564018453205F, 0.0F, 0.0F);
        this.HeadTop = new ModelRenderer(this, 0, 28);
        this.HeadTop.setRotationPoint(-1.0F, -8.0F, 0.0F);
        this.HeadTop.addBox(-3.0F, -10.0F, -4.0F, 6, 10, 8, 0.0F);
        this.TentacleFR = new ModelRenderer(this, 48, 0);
        this.TentacleFR.setRotationPoint(1.34F, 8.0F, 3.54F);
        this.TentacleFR.addBox(-1.0F, 0.0F, -1.0F, 2, 18, 2, 0.0F);
        this.setRotateAngle(TentacleFR, 0.0F, 0.7853981633974483F, 0.0F);
        this.Head.addChild(this.TentacleFR_1);
        this.Head.addChild(this.TentacleB);
        this.Head.addChild(this.TentacleBR);
        this.Head.addChild(this.TentacleBL);
        this.HeadTop.addChild(this.HeadFinR);
        this.Head.addChild(this.TentacleF);
        this.HeadTop.addChild(this.HeadFinL);
        this.Head.addChild(this.HeadTop);
        this.Head.addChild(this.TentacleFR);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.Head.render(f5);
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
