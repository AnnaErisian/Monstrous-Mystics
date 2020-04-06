package blue.thejester.monstrousmystics.core;

import blue.thejester.monstrousmystics.MonstrousMystics;
import blue.thejester.monstrousmystics.entity.tier1.EntitySpirit;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MonstrousMystics.MODID)
public class ClientOnlyProxy extends CommonProxy {

    @Override
    public void preInit() {

//        ClientRegistry.bindTileEntitySpecialRenderer(TileArrayedCrystalCube.class, new RenderTileArrayedCrystalCube());
//        ClientRegistry.bindTileEntitySpecialRenderer(TileSecondSun.class, new RenderTileSecondSun());

        EntitySpirit.registerOwnRenderer();

        super.preInit();
    }



    @Override
    public boolean isDedicatedServer() {
        return false;
    }

}
