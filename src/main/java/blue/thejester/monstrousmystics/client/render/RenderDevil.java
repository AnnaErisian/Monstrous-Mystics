package blue.thejester.monstrousmystics.client.render;

import blue.thejester.monstrousmystics.MonstrousMystics;
import blue.thejester.monstrousmystics.client.model.ModelDevil;
import blue.thejester.monstrousmystics.client.render.layers.LayerHeldItems;
import blue.thejester.monstrousmystics.entity.tier2.EntityDevil;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;


public class RenderDevil extends RenderLiving<EntityDevil> {

    ResourceLocation resourceLocation = new ResourceLocation(MonstrousMystics.MODID, "textures/entity/devil.png");

    public RenderDevil(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelDevil(), 0.4f);
        this.addLayer(new LayerHeldItems(this, -0.2f));
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityDevil entity) {
        return resourceLocation;
    }

    public static final RenderDevil.Factory FACTORY = new RenderDevil.Factory();

    public static class Factory implements IRenderFactory<EntityDevil> {
        @Override
        public Render<? super EntityDevil> createRenderFor(RenderManager renderManager) {
            return new RenderDevil(renderManager);
        }
    }

    @Override
    public void doRender(EntityDevil entity, double x, double y, double z, float entityYaw, float partialTicks) {
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }
}
