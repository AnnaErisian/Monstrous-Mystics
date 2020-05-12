package blue.thejester.monstrousmystics.client.render;

import blue.thejester.monstrousmystics.MonstrousMystics;
import blue.thejester.monstrousmystics.client.model.ModelIceSpirit;
import blue.thejester.monstrousmystics.client.render.layers.LayerHeldItems;
import blue.thejester.monstrousmystics.entity.tier2.EntityIceSpirit;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;


public class RenderIceSpirit extends RenderLiving<EntityIceSpirit> {

    ResourceLocation resourceLocation = new ResourceLocation(MonstrousMystics.MODID, "textures/entity/ice_spirit.png");

    public RenderIceSpirit(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelIceSpirit(), 0.0f);
        this.addLayer(new LayerHeldItems(this, -0.2f));
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityIceSpirit entity) {
        return resourceLocation;
    }

    public static final RenderIceSpirit.Factory FACTORY = new RenderIceSpirit.Factory();

    public static class Factory implements IRenderFactory<EntityIceSpirit> {
        @Override
        public Render<? super EntityIceSpirit> createRenderFor(RenderManager renderManager) {
            return new RenderIceSpirit(renderManager);
        }
    }

    @Override
    public void doRender(EntityIceSpirit entity, double x, double y, double z, float entityYaw, float partialTicks) {
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }
}
