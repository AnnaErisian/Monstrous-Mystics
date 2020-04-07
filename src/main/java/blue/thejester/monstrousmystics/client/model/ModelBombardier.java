package blue.thejester.monstrousmystics.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * Bombardier - Anna Erisian
 * Created using Tabula 7.1.0
 */
public class ModelBombardier extends ModelBase {
    public ModelRenderer Body;
    public ModelRenderer Tail1;
    public ModelRenderer Head;
    public ModelRenderer WingRight1;
    public ModelRenderer WingLeft1;
    public ModelRenderer Tail2;
    public ModelRenderer WingRight2;
    public ModelRenderer Bomb1;
    public ModelRenderer WingRight2_1;
    public ModelRenderer Bomb1_1;

    public ModelBombardier() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.Tail2 = new ModelRenderer(this, 33, 0);
        this.Tail2.setRotationPoint(0.0F, 0.0F, 7.0F);
        this.Tail2.addBox(-1.0F, 0.0F, 0.0F, 2, 1, 6, 0.0F);
        this.WingRight2_1 = new ModelRenderer(this, 0, 27);
        this.WingRight2_1.setRotationPoint(-6.0F, 0.0F, 0.0F);
        this.WingRight2_1.addBox(-11.0F, 0.0F, 0.0F, 11, 1, 8, 0.0F);
        this.Body = new ModelRenderer(this, 0, 0);
        this.Body.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Body.addBox(-2.0F, -1.5F, 0.0F, 4, 3, 12, 0.0F);
        this.Head = new ModelRenderer(this, 0, 42);
        this.Head.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Head.addBox(-2.5F, -0.5F, -4.0F, 5, 3, 5, 0.0F);
        this.WingRight1 = new ModelRenderer(this, 0, 15);
        this.WingRight1.mirror = true;
        this.WingRight1.setRotationPoint(2.0F, -1.5F, 0.0F);
        this.WingRight1.addBox(0.0F, 0.0F, 0.0F, 6, 1, 11, 0.0F);
        this.WingLeft1 = new ModelRenderer(this, 0, 15);
        this.WingLeft1.setRotationPoint(-2.0F, -1.5F, 0.0F);
        this.WingLeft1.addBox(-6.0F, 0.0F, 0.0F, 6, 1, 11, 0.0F);
        this.Bomb1_1 = new ModelRenderer(this, 0, 36);
        this.Bomb1_1.setRotationPoint(-3.0F, 0.5F, 2.0F);
        this.Bomb1_1.addBox(-1.0F, 0.0F, 0.0F, 2, 1, 5, 0.0F);
        this.Tail1 = new ModelRenderer(this, 20, 0);
        this.Tail1.setRotationPoint(0.0F, -1.5F, 12.0F);
        this.Tail1.addBox(-1.5F, 0.0F, 0.0F, 3, 2, 7, 0.0F);
        this.WingRight2 = new ModelRenderer(this, 0, 27);
        this.WingRight2.mirror = true;
        this.WingRight2.setRotationPoint(6.0F, 0.0F, 0.0F);
        this.WingRight2.addBox(0.0F, 0.0F, 0.0F, 11, 1, 8, 0.0F);
        this.Bomb1 = new ModelRenderer(this, 0, 36);
        this.Bomb1.setRotationPoint(3.0F, 0.5F, 2.0F);
        this.Bomb1.addBox(-1.0F, 0.0F, 0.0F, 2, 1, 5, 0.0F);
        this.Tail1.addChild(this.Tail2);
        this.WingLeft1.addChild(this.WingRight2_1);
        this.Body.addChild(this.Head);
        this.Body.addChild(this.WingRight1);
        this.Body.addChild(this.WingLeft1);
        this.WingLeft1.addChild(this.Bomb1_1);
        this.Body.addChild(this.Tail1);
        this.WingRight1.addChild(this.WingRight2);
        this.WingRight1.addChild(this.Bomb1);
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
