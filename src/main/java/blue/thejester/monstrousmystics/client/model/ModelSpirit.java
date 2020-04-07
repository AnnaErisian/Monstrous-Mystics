package blue.thejester.monstrousmystics.client.model;

import net.ilexiconn.llibrary.client.model.tools.AdvancedModelBase;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;

/**
 * ModelSpirit - Anna Erisian
 * Created using Tabula 7.1.0
 */
public class ModelSpirit extends AdvancedModelBase {
    public ModelRenderer Body;
    public ModelRenderer ArmR;
    public ModelRenderer Head;
    public ModelRenderer Tail;
    public ModelRenderer ArmL;
    public ModelRenderer TailBottom;

    public ModelSpirit() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.Head = new ModelRenderer(this, 0, 17);
        this.Head.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
        this.Tail = new ModelRenderer(this, 36, 0);
        this.Tail.mirror = true;
        this.Tail.setRotationPoint(0.0F, 12.0F, -1.8F);
        this.Tail.addBox(-3.0F, 0.0F, 0.0F, 6, 7, 3, 0.0F);
        this.setRotateAngle(Tail, 0.22759093446006054F, 0.0F, 0.0F);
        this.ArmR = new ModelRenderer(this, 24, 0);
        this.ArmR.mirror = true;
        this.ArmR.setRotationPoint(5.0F, 2.0F, 0.0F);
        this.ArmR.addBox(-1.0F, -2.0F, -2.0F, 3, 14, 3, 0.0F);
        this.setRotateAngle(ArmR, -1.3962634015954636F, 0.10000736613927509F, -0.10000736613927509F);
        this.TailBottom = new ModelRenderer(this, 36, 10);
        this.TailBottom.setRotationPoint(0.0F, 7.0F, 0.0F);
        this.TailBottom.addBox(-2.0F, 0.0F, 0.0F, 4, 4, 2, 0.0F);
        this.setRotateAngle(TailBottom, 0.31869712141416456F, 0.0F, 0.0F);
        this.Body = new ModelRenderer(this, 0, 0);
        this.Body.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Body.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
        this.setRotateAngle(Body, 0.18203784098300857F, 0.0F, 0.0F);
        this.ArmL = new ModelRenderer(this, 24, 0);
        this.ArmL.setRotationPoint(-5.0F, 2.0F, 0.0F);
        this.ArmL.addBox(-2.0F, -2.0F, -2.0F, 3, 14, 3, 0.0F);
        this.setRotateAngle(ArmL, -1.3962634015954636F, -0.10000736613927509F, 0.10000736613927509F);
        this.Body.addChild(this.Head);
        this.Body.addChild(this.Tail);
        this.Body.addChild(this.ArmR);
        this.Tail.addChild(this.TailBottom);
        this.Body.addChild(this.ArmL);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        GlStateManager.pushMatrix();
        this.Body.render(f5);
        GlStateManager.popMatrix();
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
