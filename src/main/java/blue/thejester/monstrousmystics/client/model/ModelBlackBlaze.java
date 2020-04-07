package blue.thejester.monstrousmystics.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * ModelBlackBlaze - Either Mojang or a mod author
 * Created using Tabula 7.1.0
 */
public class ModelBlackBlaze extends ModelBase {
    public ModelRenderer Head;
    public ModelRenderer Rod;
    public ModelRenderer Rod_1;
    public ModelRenderer Rod_2;
    public ModelRenderer Rod_3;
    public ModelRenderer Rod_4;
    public ModelRenderer Rod_5;
    public ModelRenderer Rod_6;
    public ModelRenderer Rod_7;
    public ModelRenderer Rod_8;
    public ModelRenderer Rod_9;
    public ModelRenderer Rod_10;
    public ModelRenderer Rod_11;
    public ModelRenderer SpineTop;
    public ModelRenderer SpineBottom;

    public ModelBlackBlaze() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.Rod_10 = new ModelRenderer(this, 8, 16);
        this.Rod_10.setRotationPoint(4.95F, 1.06F, -4.95F);
        this.Rod_10.addBox(0.0F, 0.0F, 0.0F, 2, 8, 2, 0.0F);
        this.Head = new ModelRenderer(this, 0, 0);
        this.Head.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Head.addBox(-4.0F, -4.0F, -4.0F, 8, 8, 8, 0.0F);
        this.Rod_11 = new ModelRenderer(this, 16, 16);
        this.Rod_11.setRotationPoint(-4.95F, 1.2F, 4.95F);
        this.Rod_11.addBox(0.0F, 0.0F, 0.0F, 2, 8, 2, 0.0F);
        this.Rod_1 = new ModelRenderer(this, 8, 16);
        this.Rod_1.setRotationPoint(0.0F, -1.12F, 9.0F);
        this.Rod_1.addBox(0.0F, 0.0F, 0.0F, 2, 8, 2, 0.0F);
        this.Rod_9 = new ModelRenderer(this, 0, 16);
        this.Rod_9.setRotationPoint(0.0F, -1.93F, -9.0F);
        this.Rod_9.addBox(0.0F, 0.0F, 0.0F, 2, 8, 2, 0.0F);
        this.Rod_4 = new ModelRenderer(this, 8, 16);
        this.Rod_4.setRotationPoint(-4.46F, 11.35F, -2.27F);
        this.Rod_4.addBox(0.0F, 0.0F, 0.0F, 2, 8, 2, 0.0F);
        this.Rod_8 = new ModelRenderer(this, 16, 16);
        this.Rod_8.setRotationPoint(4.95F, 1.58F, 4.95F);
        this.Rod_8.addBox(0.0F, 0.0F, 0.0F, 2, 8, 2, 0.0F);
        this.SpineBottom = new ModelRenderer(this, 30, 17);
        this.SpineBottom.setRotationPoint(0.0F, 8.0F, 0.0F);
        this.SpineBottom.addBox(-1.0F, 0.0F, -1.0F, 2, 8, 1, 0.0F);
        this.setRotateAngle(SpineBottom, 0.31869712141416456F, 0.0F, 0.0F);
        this.Rod = new ModelRenderer(this, 0, 16);
        this.Rod.setRotationPoint(2.27F, 10.61F, -4.46F);
        this.Rod.addBox(0.0F, 0.0F, 0.0F, 2, 8, 2, 0.0F);
        this.Rod_6 = new ModelRenderer(this, 0, 16);
        this.Rod_6.setRotationPoint(4.46F, 11.96F, 2.27F);
        this.Rod_6.addBox(0.0F, 0.0F, 0.0F, 2, 8, 2, 0.0F);
        this.SpineTop = new ModelRenderer(this, 24, 17);
        this.SpineTop.setRotationPoint(0.0F, 4.0F, 4.0F);
        this.SpineTop.addBox(-1.0F, 0.0F, -1.0F, 2, 8, 1, 0.0F);
        this.setRotateAngle(SpineTop, -0.091106186954104F, 0.0F, 0.0F);
        this.Rod_7 = new ModelRenderer(this, 8, 16);
        this.Rod_7.setRotationPoint(-9.0F, -1.46F, 0.0F);
        this.Rod_7.addBox(0.0F, 0.0F, 0.0F, 2, 8, 2, 0.0F);
        this.Rod_3 = new ModelRenderer(this, 0, 16);
        this.Rod_3.setRotationPoint(-2.27F, 11.89F, 4.46F);
        this.Rod_3.addBox(0.0F, 0.0F, 0.0F, 2, 8, 2, 0.0F);
        this.Rod_2 = new ModelRenderer(this, 16, 16);
        this.Rod_2.setRotationPoint(9.0F, -1.0F, 0.0F);
        this.Rod_2.addBox(0.0F, 0.0F, 0.0F, 2, 8, 2, 0.0F);
        this.Rod_5 = new ModelRenderer(this, 16, 16);
        this.Rod_5.setRotationPoint(-4.95F, 1.01F, -4.95F);
        this.Rod_5.addBox(0.0F, 0.0F, 0.0F, 2, 8, 2, 0.0F);
        this.Head.addChild(this.Rod_10);
        this.Head.addChild(this.Rod_11);
        this.Head.addChild(this.Rod_1);
        this.Head.addChild(this.Rod_9);
        this.Head.addChild(this.Rod_4);
        this.Head.addChild(this.Rod_8);
        this.SpineTop.addChild(this.SpineBottom);
        this.Head.addChild(this.Rod);
        this.Head.addChild(this.Rod_6);
        this.Head.addChild(this.SpineTop);
        this.Head.addChild(this.Rod_7);
        this.Head.addChild(this.Rod_3);
        this.Head.addChild(this.Rod_2);
        this.Head.addChild(this.Rod_5);
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
