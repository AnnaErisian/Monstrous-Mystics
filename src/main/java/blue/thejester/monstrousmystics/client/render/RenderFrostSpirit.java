package blue.thejester.monstrousmystics.client.render;

import blue.thejester.monstrousmystics.MonstrousMystics;
import blue.thejester.monstrousmystics.client.model.ModelFrostSpirit;
import blue.thejester.monstrousmystics.client.render.layers.LayerHeldItems;
import blue.thejester.monstrousmystics.entity.tier2.EntityFrostSpirit;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;


public class RenderFrostSpirit extends RenderLiving<EntityFrostSpirit> {

    ResourceLocation resourceLocation = new ResourceLocation(MonstrousMystics.MODID, "textures/entity/frost_spirit.png");

    public RenderFrostSpirit(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelFrostSpirit(), 0.0f);
        this.addLayer(new LayerHeldItems(this, -0.2f));
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityFrostSpirit entity) {
        return resourceLocation;
    }

    public static final RenderFrostSpirit.Factory FACTORY = new RenderFrostSpirit.Factory();

    public static class Factory implements IRenderFactory<EntityFrostSpirit> {
        @Override
        public Render<? super EntityFrostSpirit> createRenderFor(RenderManager renderManager) {
            return new RenderFrostSpirit(renderManager);
        }
    }

    @Override
    public void doRender(EntityFrostSpirit entity, double x, double y, double z, float entityYaw, float partialTicks) {
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }
}
