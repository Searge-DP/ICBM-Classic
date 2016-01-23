package com.builtbroken.icbmclassic.Main;

import com.builtbroken.icbmclassic.blocks.BlockMain;
import com.builtbroken.icbmclassic.items.ItemMain;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

/** Written By Herobrine11892 **/

public class CraftingManager {
	
	public static void mainRegistry()
	{
		addCraftingRec();
		addSmeltingRec();
	}
	
	public static void addCraftingRec()
	{
		GameRegistry.addRecipe(new ItemStack(BlockMain.ReinfGlass, 8), new Object[]{"IGI","GIG","IGI", 'I' , Items.iron_ingot, 'G' , Blocks.glass});
		//Poison Powder
		GameRegistry.addRecipe(new ItemStack(ItemMain.PoisonPowder, 3), new Object[]{"SR ","   ","   ", 'S' , Items.spider_eye, 'R' , Items.rotten_flesh});
		GameRegistry.addRecipe(new ItemStack(ItemMain.PoisonPowder, 3), new Object[]{" SR","   ","   ", 'S' , Items.spider_eye, 'R' , Items.rotten_flesh});
		GameRegistry.addRecipe(new ItemStack(ItemMain.PoisonPowder, 3), new Object[]{"   ","SR ","   ", 'S' , Items.spider_eye, 'R' , Items.rotten_flesh});
		GameRegistry.addRecipe(new ItemStack(ItemMain.PoisonPowder, 3), new Object[]{"   "," SR","   ", 'S' , Items.spider_eye, 'R' , Items.rotten_flesh});
		GameRegistry.addRecipe(new ItemStack(ItemMain.PoisonPowder, 3), new Object[]{"   ","   ","SR ", 'S' , Items.spider_eye, 'R' , Items.rotten_flesh});
		GameRegistry.addRecipe(new ItemStack(ItemMain.PoisonPowder, 3), new Object[]{"   ","   "," SR", 'S' , Items.spider_eye, 'R' , Items.rotten_flesh});
		//End Of Poison Powder
		
	}
	
	public static void addSmeltingRec()
	{
		GameRegistry.addSmelting(BlockMain.SulfurOre, new ItemStack(ItemMain.Sulfur, 4), 0.0f);
	}

}
