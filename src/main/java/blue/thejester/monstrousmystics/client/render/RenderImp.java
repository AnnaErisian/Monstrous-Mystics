package blue.thejester.monstrousmystics.client.render;

import blue.thejester.monstrousmystics.MonstrousMystics;
import blue.thejester.monstrousmystics.client.model.ModelImp;
import blue.thejester.monstrousmystics.client.render.layers.LayerHeldItems;
import blue.thejester.monstrousmystics.entity.tier2.EntityImp;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;


public class RenderImp extends RenderLiving<EntityImp> {

    ResourceLocation resourceLocation = new ResourceLocation(MonstrousMystics.MODID, "textures/entity/imp.png");

    public RenderImp(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelImp(), 0.4f);
        this.addLayer(new LayerHeldItems(this, -0.2f));
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityImp entity) {
        return resourceLocation;
    }

    public static final RenderImp.Factory FACTORY = new RenderImp.Factory();

    public static class Factory implements IRenderFactory<EntityImp> {
        @Override
        public Render<? super EntityImp> createRenderFor(RenderManager renderManager) {
            return new RenderImp(renderManager);
        }
    }

    @Override
    public void doRender(EntityImp entity, double x, double y, double z, float entityYaw, float partialTicks) {
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }
}
