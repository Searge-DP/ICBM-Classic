package com.builtbroken.icbmclassic.creativeTabs;

import com.builtbroken.icbmclassic.blocks.BlockMain;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/** Written By Herobrine11892 **/

public class CreativeTabICBM extends CreativeTabs {

	public CreativeTabICBM(String lable) {
		super(lable);
		
	}

	@Override
	public Item getTabIconItem() {
		
		return Item.getItemFromBlock(BlockMain.ConExplosives);
	}

}
