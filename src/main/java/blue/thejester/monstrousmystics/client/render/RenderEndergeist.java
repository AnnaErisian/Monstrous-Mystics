package blue.thejester.monstrousmystics.client.render;

import blue.thejester.monstrousmystics.MonstrousMystics;
import blue.thejester.monstrousmystics.client.model.ModelEndergeist;
import blue.thejester.monstrousmystics.client.render.layers.LayerHeldItems;
import blue.thejester.monstrousmystics.entity.tier2.EntityEndergeist;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;


public class RenderEndergeist extends RenderLiving<EntityEndergeist> {

    ResourceLocation resourceLocation = new ResourceLocation(MonstrousMystics.MODID, "textures/entity/endergeist.png");

    public RenderEndergeist(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelEndergeist(), 0.0f);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityEndergeist entity) {
        return resourceLocation;
    }

    public static final RenderEndergeist.Factory FACTORY = new RenderEndergeist.Factory();

    public static class Factory implements IRenderFactory<EntityEndergeist> {
        @Override
        public Render<? super EntityEndergeist> createRenderFor(RenderManager renderManager) {
            return new RenderEndergeist(renderManager);
        }
    }

    @Override
    public void doRender(EntityEndergeist entity, double x, double y, double z, float entityYaw, float partialTicks) {
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }
}
