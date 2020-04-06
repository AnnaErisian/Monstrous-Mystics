package blue.thejester.monstrousmystics.item;

import blue.thejester.monstrousmystics.MonstrousMystics;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = MonstrousMystics.MODID)
public class ModItems {
//    public static final Item stabilizingSash = new ItemStabilizingSash();

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> evt) {
//        registerItem(evt, stabilizingSash);
    }

    private static void registerItem(RegistryEvent.Register<Item> evt, Item item) {
        if(item != null) {
            evt.getRegistry().register(item);
        }
    }
}
