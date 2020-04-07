package blue.thejester.monstrousmystics.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * ModelInfernoCreeper - Either Mojang or a mod author
 * Created using Tabula 7.1.0
 */
public class ModelInfernoCreeper extends ModelBase {
    public ModelRenderer Body;
    public ModelRenderer OrbRoot;
    public ModelRenderer LegBR;
    public ModelRenderer LegFR;
    public ModelRenderer LegFL;
    public ModelRenderer LegBL;
    public ModelRenderer Head;
    public ModelRenderer HornR;
    public ModelRenderer HornL;
    public ModelRenderer OrbRotator;
    public ModelRenderer Orb1;
    public ModelRenderer Orb2;
    public ModelRenderer Orb3;
    public ModelRenderer Orb4;
    public ModelRenderer Orb5;
    public ModelRenderer Orb6;
    public ModelRenderer Orb7;
    public ModelRenderer Orb8;

    public ModelInfernoCreeper() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.HornR = new ModelRenderer(this, 0, 0);
        this.HornR.setRotationPoint(2.2F, -8.4F, -2.3F);
        this.HornR.addBox(-1.0F, -3.0F, -1.0F, 2, 4, 2, 0.0F);
        this.setRotateAngle(HornR, 0.3262020371977402F, -0.42586033748661634F, 0.12723450247038662F);
        this.Head = new ModelRenderer(this, 0, 0);
        this.Head.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
        this.Orb5 = new ModelRenderer(this, 0, 26);
        this.Orb5.setRotationPoint(0.0F, 0.0F, -8.0F);
        this.Orb5.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
        this.Orb8 = new ModelRenderer(this, 8, 26);
        this.Orb8.setRotationPoint(-5.65F, 0.0F, 5.65F);
        this.Orb8.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
        this.Orb1 = new ModelRenderer(this, 0, 26);
        this.Orb1.setRotationPoint(0.0F, 0.0F, 8.0F);
        this.Orb1.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
        this.LegBR = new ModelRenderer(this, 0, 16);
        this.LegBR.setRotationPoint(2.0F, 12.0F, 4.0F);
        this.LegBR.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 4, 0.0F);
        this.Orb3 = new ModelRenderer(this, 0, 26);
        this.Orb3.setRotationPoint(8.0F, 0.0F, 0.0F);
        this.Orb3.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
        this.OrbRoot = new ModelRenderer(this, 0, 0);
        this.OrbRoot.setRotationPoint(0.0F, 8.9F, -1.4F);
        this.OrbRoot.addBox(0.0F, 0.0F, 0.0F, 0, 0, 0, 0.0F);
        this.setRotateAngle(OrbRoot, 0.40980330836826856F, -0.6373942428283291F, 0.0F);
        this.LegBL = new ModelRenderer(this, 0, 16);
        this.LegBL.setRotationPoint(-2.0F, 12.0F, 4.0F);
        this.LegBL.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 4, 0.0F);
        this.Orb2 = new ModelRenderer(this, 8, 26);
        this.Orb2.setRotationPoint(5.65F, 0.0F, 5.65F);
        this.Orb2.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
        this.OrbRotator = new ModelRenderer(this, 0, 0);
        this.OrbRotator.setRotationPoint(0.0F, 2.1F, 0.0F);
        this.OrbRotator.addBox(-0.5F, -0.5F, -0.5F, 0, 0, 0, 0.0F);
        this.HornL = new ModelRenderer(this, 0, 0);
        this.HornL.setRotationPoint(-2.2F, -8.4F, -2.3F);
        this.HornL.addBox(-1.0F, -3.0F, -1.0F, 2, 4, 2, 0.0F);
        this.setRotateAngle(HornL, 0.3262020371977402F, 0.42586033748661634F, -0.12723450247038662F);
        this.Orb4 = new ModelRenderer(this, 8, 26);
        this.Orb4.setRotationPoint(5.65F, 0.0F, -5.65F);
        this.Orb4.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
        this.Body = new ModelRenderer(this, 16, 16);
        this.Body.setRotationPoint(0.0F, 6.0F, 0.0F);
        this.Body.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
        this.Orb7 = new ModelRenderer(this, 0, 26);
        this.Orb7.setRotationPoint(-8.0F, 0.0F, 0.0F);
        this.Orb7.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
        this.Orb6 = new ModelRenderer(this, 8, 26);
        this.Orb6.setRotationPoint(-5.65F, 0.0F, -5.65F);
        this.Orb6.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
        this.LegFR = new ModelRenderer(this, 0, 16);
        this.LegFR.setRotationPoint(2.0F, 12.0F, -4.0F);
        this.LegFR.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 4, 0.0F);
        this.LegFL = new ModelRenderer(this, 0, 16);
        this.LegFL.setRotationPoint(-2.0F, 12.0F, -4.0F);
        this.LegFL.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 4, 0.0F);
        this.Head.addChild(this.HornR);
        this.Body.addChild(this.Head);
        this.OrbRotator.addChild(this.Orb5);
        this.OrbRotator.addChild(this.Orb8);
        this.OrbRotator.addChild(this.Orb1);
        this.Body.addChild(this.LegBR);
        this.OrbRotator.addChild(this.Orb3);
        this.Body.addChild(this.LegBL);
        this.OrbRotator.addChild(this.Orb2);
        this.OrbRoot.addChild(this.OrbRotator);
        this.Head.addChild(this.HornL);
        this.OrbRotator.addChild(this.Orb4);
        this.OrbRotator.addChild(this.Orb7);
        this.OrbRotator.addChild(this.Orb6);
        this.Body.addChild(this.LegFR);
        this.Body.addChild(this.LegFL);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.OrbRoot.render(f5);
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
