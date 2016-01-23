package com.builtbroken.icbmclassic.items;

import com.builtbroken.icbmclassic.creativeTabs.CreativeTabsMain;
import com.builtbroken.icbmclassic.lib.RefStrings;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/** Written By Herobrine11892 **/

public class ItemMain {
	
	public static void mainRegistry ()
	{
		initializeItem();
		registerItem();
	}
	
	public static Item Sulfur;
	public static Item PoisonPowder;
	//public static Item RadarGun;
	//public static Item Tracker;
	
	public static void initializeItem ()
	{
		Sulfur = new Item().setUnlocalizedName("Sulfur").setCreativeTab(CreativeTabs.tabMisc).setTextureName(RefStrings.MODID + ":Sulfur");
		PoisonPowder = new Item().setUnlocalizedName("PoisonPowder").setCreativeTab(CreativeTabsMain.CreativeTabICBM).setTextureName(RefStrings.MODID + ":PoisonPowder");
		//RadarGun = new ItemRadargun().setUnlocalizedName("RadarGun").setCreativeTab(CreativeTabsMain.CreativeTabICBM).setTextureName(RefStrings.MODID + ":radarGun");
		//Tracker = new ItemTracker().setUnlocalizedName("Tracker").setCreativeTab(CreativeTabsMain.CreativeTabICBM).setTextureName(RefStrings.MODID + ":tracker");
	}
	
	public static void registerItem ()
	{
		GameRegistry.registerItem(Sulfur, Sulfur.getUnlocalizedName());
		GameRegistry.registerItem(PoisonPowder, PoisonPowder.getUnlocalizedName());
		//GameRegistry.registerItem(RadarGun, RadarGun.getUnlocalizedName());
		//GameRegistry.registerItem(Tracker, Tracker.getUnlocalizedName());
	}

}
