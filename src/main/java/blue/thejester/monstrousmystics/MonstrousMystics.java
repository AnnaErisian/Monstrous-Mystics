package blue.thejester.monstrousmystics;

import blue.thejester.monstrousmystics.core.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

import java.util.LinkedHashSet;
import java.util.Set;

@Mod(modid = MonstrousMystics.MODID, name = MonstrousMystics.NAME, version = MonstrousMystics.VERSION, dependencies = MonstrousMystics.DEPENDS)
public class MonstrousMystics
{
    public static final String MODID = "monstrousmystics";
    public static final String NAME = "Monstrous Mystics";
    public static final String VERSION = "1.0";
    public static final String DEPENDS = "required-after:ebwizardry;";

    public static Logger logger;

    public static Set<String> subtilesForCreativeMenu = new LinkedHashSet();

    // The instance of your mod that Forge uses.  Optional.
    @Mod.Instance(MonstrousMystics.MODID)
    public static MonstrousMystics instance;

    // Says where the client and server 'proxy' code is loaded.
    @SidedProxy(clientSide="blue.thejester.monstrousmystics.core.ClientOnlyProxy", serverSide="blue.thejester.monstrousmystics.core.CommonProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();

        proxy.preInit();

    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init();
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        proxy.postInit();
    }
}
