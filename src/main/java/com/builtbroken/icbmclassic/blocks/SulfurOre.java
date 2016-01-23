package com.builtbroken.icbmclassic.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

/** Written By Herobrine11892 **/

public class SulfurOre extends Block{
	
	protected SulfurOre(Material Reinforced) {
		super(Reinforced);
		this.setHardness(4);
		this.setResistance(2);
		this.setHarvestLevel("pickaxe", 8);
	}

}
