package com.builtbroken.icbmclassic;

import com.builtbroken.mc.lib.mod.AbstractMod;
import com.builtbroken.mc.lib.mod.AbstractProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by robert on 1/17/2015.
 */
@Mod(modid = ICBM_Classic.DOMAIN, name = ICBM_Classic.NAME, version = ICBM_Classic.VERSION, dependencies = "required-after:icbm")
public class ICBM_Classic extends AbstractMod
{
    /**
     * Name of the channel and mod ID.
     */
    public static final String NAME = "ICBM Class Missile Pack";
    public static final String DOMAIN = "icbmclassic";
    public static final String PREFIX = DOMAIN + ":";

    /**
     * The version of ICBM.
     */
    public static final String MAJOR_VERSION = "@MAJOR@";
    public static final String MINOR_VERSION = "@MINOR@";
    public static final String REVISION_VERSION = "@REVIS@";
    public static final String BUILD_VERSION = "@BUILD@";
    public static final String VERSION = MAJOR_VERSION + "." + MINOR_VERSION + "." + REVISION_VERSION + "." + BUILD_VERSION;

    public static final String ASSETS_PATH = "/assets/" + DOMAIN + "/";
    public static final String TEXTURE_PATH = "textures/";
    public static final String GUI_PATH = TEXTURE_PATH + "gui/";
    public static final String MODEL_PREFIX = "models/";
    public static final String MODEL_DIRECTORY = ASSETS_PATH + MODEL_PREFIX;

    public static final String MODEL_TEXTURE_PATH = TEXTURE_PATH + MODEL_PREFIX;
    public static final String BLOCK_PATH = TEXTURE_PATH + "blocks/";
    public static final String ITEM_PATH = TEXTURE_PATH + "items/";

    public static final Logger LOGGER = LogManager.getLogger(NAME);

    @Mod.Instance(DOMAIN)
    public static ICBM_Classic INSTANCE;

    @Mod.Metadata(DOMAIN)
    public static ModMetadata metadata;

    @SidedProxy(clientSide = "com.builtbroken.icbmclassic.ClientProxy", serverSide = "com.builtbroken.icbmclassic.CommonProxy")
    public static CommonProxy proxy;

    public ICBM_Classic()
    {
        super(DOMAIN);
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        super.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        super.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        super.postInit(event);
    }

    @Override
    public AbstractProxy getProxy()
    {
        return proxy;
    }
}
