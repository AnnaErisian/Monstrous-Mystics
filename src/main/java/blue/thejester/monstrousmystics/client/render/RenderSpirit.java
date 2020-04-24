package blue.thejester.monstrousmystics.client.render;

import blue.thejester.monstrousmystics.MonstrousMystics;
import blue.thejester.monstrousmystics.client.model.ModelSpirit;
import blue.thejester.monstrousmystics.client.render.layers.LayerHeldItems;
import blue.thejester.monstrousmystics.entity.tier1.EntitySpirit;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHandSide;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;


public class RenderSpirit extends RenderLiving<EntitySpirit> {

    ResourceLocation resourceLocation = new ResourceLocation(MonstrousMystics.MODID, "textures/entity/spirit.png");

    public RenderSpirit(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelSpirit(), 0.0f);
        this.addLayer(new LayerHeldItems(this));
    }

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
    }
}
