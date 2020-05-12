package blue.thejester.monstrousmystics.client.render;

import blue.thejester.monstrousmystics.MonstrousMystics;
import blue.thejester.monstrousmystics.client.model.ModelBlackBlaze;
import blue.thejester.monstrousmystics.entity.tier2.EntityBlackBlaze;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;


public class RenderBlackBlaze extends RenderLiving<EntityBlackBlaze> {

    ResourceLocation resourceLocation = new ResourceLocation(MonstrousMystics.MODID, "textures/entity/black_blaze.png");

    public RenderBlackBlaze(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelBlackBlaze(), 0.0f);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityBlackBlaze entitySpirit) {
        return resourceLocation;
    }

    public static final RenderBlackBlaze.Factory FACTORY = new RenderBlackBlaze.Factory();

    public static class Factory implements IRenderFactory<EntityBlackBlaze> {
        @Override
        public Render<? super EntityBlackBlaze> createRenderFor(RenderManager renderManager) {
            return new RenderBlackBlaze(renderManager);
        }
    }

    @Override
    public void doRender(EntityBlackBlaze entity, double x, double y, double z, float entityYaw, float partialTicks) {
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }
}
