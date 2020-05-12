package blue.thejester.monstrousmystics.client.render;

import blue.thejester.monstrousmystics.MonstrousMystics;
import blue.thejester.monstrousmystics.client.model.ModelRoaringSpirit;
import blue.thejester.monstrousmystics.client.render.layers.LayerHeldItems;
import blue.thejester.monstrousmystics.entity.tier2.EntityRoaringSpirit;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;


public class RenderRoaringSpirit extends RenderLiving<EntityRoaringSpirit> {

    ResourceLocation resourceLocation = new ResourceLocation(MonstrousMystics.MODID, "textures/entity/roaring_spirit.png");

    public RenderRoaringSpirit(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelRoaringSpirit(), 0.0f);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityRoaringSpirit entity) {
        return resourceLocation;
    }

    public static final RenderRoaringSpirit.Factory FACTORY = new RenderRoaringSpirit.Factory();

    public static class Factory implements IRenderFactory<EntityRoaringSpirit> {
        @Override
        public Render<? super EntityRoaringSpirit> createRenderFor(RenderManager renderManager) {
            return new RenderRoaringSpirit(renderManager);
        }
    }

    @Override
    public void doRender(EntityRoaringSpirit entity, double x, double y, double z, float entityYaw, float partialTicks) {
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }
}
