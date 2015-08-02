package com.builtbroken.icbmclassic;

import com.builtbroken.icbmclassic.content.item.ItemTracker;
import com.builtbroken.icbmclassic.content.grenade.ItemGrenade;
import com.builtbroken.mc.lib.mod.AbstractMod;
import com.builtbroken.mc.lib.mod.AbstractProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import net.minecraft.item.Item;
import com.builtbroken.mc.lib.mod.ModCreativeTab;
import net.minecraft.item.ItemStack;
import com.builtbroken.icbmclassic.content.grenade.EntityGrenade;

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

    // Items

    public static Item itemTracker;
    public static Item itemGrenade;

    public final ModCreativeTab CREATIVE_TAB;

    @Mod.Instance(DOMAIN)
    public static ICBM_Classic INSTANCE;

    @Mod.Metadata(DOMAIN)
    public static ModMetadata metadata;

    @SidedProxy(clientSide = "com.builtbroken.icbmclassic.ClientProxy", serverSide = "com.builtbroken.icbmclassic.CommonProxy")
    public static CommonProxy proxy;

    public ICBM_Classic()
    {
        super(DOMAIN, "ICBM-Classic");

        CREATIVE_TAB = new ModCreativeTab("ICBM Classic ");
        CREATIVE_TAB.itemSorter = new ModCreativeTab.NameSorter()
        {
            @Override
            public String getLabel(ItemStack stack)
            {
                return stack.getDisplayName();
            }
        };
        super.manager.setTab(CREATIVE_TAB);
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        super.preInit(event);

        //Items
        itemTracker = manager.newItem(ItemTracker.class);
        itemGrenade = manager.newItem(ItemGrenade.class);

        int entityID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(EntityGrenade.class, "EntityGrenade", entityID);
        EntityRegistry.registerModEntity(EntityGrenade.class, "EntityGrenade", entityID+1, this, 64, 1, true);
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
