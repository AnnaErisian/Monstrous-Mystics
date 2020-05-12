package blue.thejester.monstrousmystics.client.render;

import blue.thejester.monstrousmystics.MonstrousMystics;
import blue.thejester.monstrousmystics.client.model.ModelWindScouredSpirit;
import blue.thejester.monstrousmystics.client.render.layers.LayerHeldItems;
import blue.thejester.monstrousmystics.entity.tier2.EntityWindScouredSpirit;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;


public class RenderWindScouredSpirit extends RenderLiving<EntityWindScouredSpirit> {

    ResourceLocation resourceLocation = new ResourceLocation(MonstrousMystics.MODID, "textures/entity/wind_scoured_spirit.png");

    public RenderWindScouredSpirit(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelWindScouredSpirit(), 0.0f);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityWindScouredSpirit entity) {
        return resourceLocation;
    }

    public static final RenderWindScouredSpirit.Factory FACTORY = new RenderWindScouredSpirit.Factory();

    public static class Factory implements IRenderFactory<EntityWindScouredSpirit> {
        @Override
        public Render<? super EntityWindScouredSpirit> createRenderFor(RenderManager renderManager) {
            return new RenderWindScouredSpirit(renderManager);
        }
    }

    @Override
    public void doRender(EntityWindScouredSpirit entity, double x, double y, double z, float entityYaw, float partialTicks) {
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }
}
