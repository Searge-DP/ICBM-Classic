package com.builtbroken.icbmclassic.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

/** Written By Herobrine11892 **/

public class ReinforcedGlass extends Block {

	protected ReinforcedGlass(Material Reinforced) {
		super(Reinforced);
		this.setHardness(4);
		this.setResistance(9999);
		this.setHarvestLevel("pickaxe", 50);
	}
	
	public boolean isOpaqueCube()
    {
	    return false;
    }

}
