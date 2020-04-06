package blue.thejester.monstrousmystics.client.render;

import blue.thejester.monstrousmystics.MonstrousMystics;
import blue.thejester.monstrousmystics.client.model.ModelSpirit;
import blue.thejester.monstrousmystics.entity.tier1.EntitySpirit;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelSpider;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderSpirit extends RenderLiving<EntitySpirit> {

    ResourceLocation resourceLocation = new ResourceLocation(MonstrousMystics.MODID, "textures/entity/spirit.png");

    public RenderSpirit(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelSpirit(), 0.0f);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntitySpirit entitySpirit) {
        return resourceLocation;
    }
}
