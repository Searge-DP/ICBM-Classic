package com.builtbroken.icbmclassic.blocks;

import com.builtbroken.icbmclassic.lib.RefStrings;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

/** Written By Herobrine11892 **/

public class ReinforcedConcrete extends Block {
	
	public IIcon Bottom;
	public IIcon Top;
	public IIcon Side2;
	public IIcon Side3;
	public IIcon Side4;
	public IIcon Side5;

	
	protected ReinforcedConcrete(Material TNT) {
		super(TNT);
	}
	
	public void registerBlockIcons(IIconRegister icon)
	{
		Bottom = icon.registerIcon(RefStrings.MODID + ":concreteReinforced");
		Top = icon.registerIcon(RefStrings.MODID + ":concreteReinforced");
		Side2 = icon.registerIcon(RefStrings.MODID + ":concreteReinforced");
		Side3 = icon.registerIcon(RefStrings.MODID + ":concreteReinforced");
		Side4 = icon.registerIcon(RefStrings.MODID + ":concreteReinforced");
		Side5 = icon.registerIcon(RefStrings.MODID + ":concreteReinforced");
	}
	
	public IIcon getIcon(int side, int meta)
	{
		if(side == 0)
		{
			return Bottom;
		}else if(side == 1)
		{
			return Top;
		}else if(side == 2)
		{
			return Side2;
		}else if(side == 3)
		{
			return Side3;
		}else if(side == 4)
		{
			return Side4;
		}else if(side == 5)
		{
			return Side5;
		}
		return null;
	}

}
