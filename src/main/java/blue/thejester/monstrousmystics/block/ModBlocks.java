package blue.thejester.monstrousmystics.block;

import blue.thejester.monstrousmystics.MonstrousMystics;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = MonstrousMystics.MODID)
public class ModBlocks {

//    public static final Block corporeaArrayedCrystalCube = new BlockArrayedCrystalCube();
//    public static final Block secondSunCore0 = new BlockSecondSunCore(0);
//    public static final Block secondSunCore1 = new BlockSecondSunCore(1);
//    public static final Block secondSunCore2 = new BlockSecondSunCore(2);
//    public static final Block secondSunCore3 = new BlockSecondSunCore(3);
//    public static final Block secondSunCore4 = new BlockSecondSunCore(4);
//    public static final Block secondSunCore5 = new BlockSecondSunCore(5);
//    public static final Block secondSunCore6 = new BlockSecondSunCore(6);

    @SubscribeEvent
    public static void onBlockRegistry(RegistryEvent.Register<Block> e) {
//        e.getRegistry().register(corporeaArrayedCrystalCube);
//        e.getRegistry().register(secondSunCore0);
//        e.getRegistry().register(secondSunCore1);
//        e.getRegistry().register(secondSunCore2);
//        e.getRegistry().register(secondSunCore3);
//        e.getRegistry().register(secondSunCore4);
//        e.getRegistry().register(secondSunCore5);
//        e.getRegistry().register(secondSunCore6);
    }

    @SubscribeEvent
    public static void registerItemBlocks(RegistryEvent.Register<Item> evt) {
//        evt.getRegistry().register(new ItemBlockMod(corporeaArrayedCrystalCube).setRegistryName(corporeaArrayedCrystalCube.getRegistryName()));
//        GameRegistry.registerTileEntity(TileArrayedCrystalCube.class, "monstrousmystics:arrayed_crystal_cube");
//        evt.getRegistry().register(new ItemBlockMod(secondSunCore0).setRegistryName(secondSunCore0.getRegistryName()));
//        evt.getRegistry().register(new ItemBlockMod(secondSunCore1).setRegistryName(secondSunCore1.getRegistryName()));
//        evt.getRegistry().register(new ItemBlockMod(secondSunCore2).setRegistryName(secondSunCore2.getRegistryName()));
//        evt.getRegistry().register(new ItemBlockMod(secondSunCore3).setRegistryName(secondSunCore3.getRegistryName()));
//        evt.getRegistry().register(new ItemBlockMod(secondSunCore4).setRegistryName(secondSunCore4.getRegistryName()));
//        evt.getRegistry().register(new ItemBlockMod(secondSunCore5).setRegistryName(secondSunCore5.getRegistryName()));
//        evt.getRegistry().register(new ItemBlockMod(secondSunCore6).setRegistryName(secondSunCore6.getRegistryName()));
//        GameRegistry.registerTileEntity(TileSecondSun.class, "monstrousmystics:" + BlockSecondSunCore.NAME);
    }
}
