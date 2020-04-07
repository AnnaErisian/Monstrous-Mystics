package blue.thejester.monstrousmystics.client.render;

import blue.thejester.monstrousmystics.MonstrousMystics;
import blue.thejester.monstrousmystics.client.model.ModelSpirit;
import blue.thejester.monstrousmystics.entity.tier1.EntitySpirit;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelSpider;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

public class RenderSpirit extends RenderLiving<EntitySpirit> {

    ResourceLocation resourceLocation = new ResourceLocation(MonstrousMystics.MODID, "textures/entity/spirit.png");

    public RenderSpirit(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelSpirit(), 0.0f);
//        this.addLayer(new LayerHeldItem(this)); can't use, requires ModelBiped
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntitySpirit entitySpirit) {
        return resourceLocation;
    }

    public static final RenderSpirit.Factory FACTORY = new RenderSpirit.Factory();

    public static class Factory implements IRenderFactory<EntitySpirit> {
        @Override
        public Render<? super EntitySpirit> createRenderFor(RenderManager renderManager) {
            return new RenderSpirit(renderManager);
        }
    }

    @Override
    public void doRender(EntitySpirit entity, double x, double y, double z, float entityYaw, float partialTicks) {
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
        //TODO I think we render the held items here?
//        ((ModelSpirit)getMainModel()).ArmR.postRender();
        //This class has relevant code, we can do what it does just fine I think
        //net/minecraft/client/renderer/entity/layers/LayerHeldItem.class
    }
}
