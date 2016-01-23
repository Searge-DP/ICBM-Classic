package com.builtbroken.icbmclassic.blocks;

import com.builtbroken.icbmclassic.lib.RefStrings;
import com.builtbroken.icbmclassic.entities.tileentity.TileEntityRadarStation;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

/** Written By Herobrine11892 **/

public class RadarStation extends BlockContainer {

	protected RadarStation(Material material) {
		super(material);
	}
	
	public int getRenderType()
	{
		return -1;
	}
	
	public boolean isOpaqueCube(){
		return false;
	}
	
	public boolean renderAsNormalBlock(){
		return false;
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileEntityRadarStation();
	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.blockIcon = iconRegister.registerIcon(RefStrings.MODID + ":" + this.getUnlocalizedName().substring(5));
	}

}