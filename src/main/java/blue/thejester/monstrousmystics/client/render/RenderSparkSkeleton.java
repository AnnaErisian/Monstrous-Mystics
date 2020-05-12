package blue.thejester.monstrousmystics.client.render;

import blue.thejester.monstrousmystics.MonstrousMystics;
import blue.thejester.monstrousmystics.client.model.ModelSparkSkeleton;
import blue.thejester.monstrousmystics.entity.tier2.EntitySparkSkeleton;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;


public class RenderSparkSkeleton extends RenderLiving<EntitySparkSkeleton> {

    ResourceLocation resourceLocation = new ResourceLocation(MonstrousMystics.MODID, "textures/entity/spark_skeleton.png");

    public RenderSparkSkeleton(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelSparkSkeleton(), 0.4f);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntitySparkSkeleton EntitySparkSkeleton) {
        return resourceLocation;
    }

    public static final RenderSparkSkeleton.Factory FACTORY = new RenderSparkSkeleton.Factory();

    public static class Factory implements IRenderFactory<EntitySparkSkeleton> {
        @Override
        public Render<? super EntitySparkSkeleton> createRenderFor(RenderManager renderManager) {
            return new RenderSparkSkeleton(renderManager);
        }
    }

    @Override
    public void doRender(EntitySparkSkeleton entity, double x, double y, double z, float entityYaw, float partialTicks) {
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }
}
