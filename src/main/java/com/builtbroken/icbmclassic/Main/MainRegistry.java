package com.builtbroken.icbmclassic.Main;

import com.builtbroken.icbmclassic.blocks.BlockMain;
import com.builtbroken.icbmclassic.creativeTabs.CreativeTabsMain;
import com.builtbroken.icbmclassic.items.ItemMain;
import com.builtbroken.icbmclassic.lib.RefStrings;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

/** Written By Herobrine11892 **/

@Mod(modid = RefStrings.MODID ,name = RefStrings.NAME ,version = RefStrings.VERSION)
public class MainRegistry {
	
	@SidedProxy(clientSide = RefStrings.CLIENTSIDE , serverSide = RefStrings.SERVERSIDE)
	public static ServerProxy proxy;
	
	@EventHandler
	public static void PreLoad(FMLPreInitializationEvent PreEvent)
	{
		CreativeTabsMain.initialiseTabs();
		ItemMain.mainRegistry();
		BlockMain.mainRegistry();
		CraftingManager.mainRegistry();
		proxy.registerRenderInfo();
	}
	public static void Load(FMLInitializationEvent Event)
	{
		
	}
	public static void PostLoad(FMLPostInitializationEvent PostEvent)
	{
		
	}
}
