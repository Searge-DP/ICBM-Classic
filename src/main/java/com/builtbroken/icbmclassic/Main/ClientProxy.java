package com.builtbroken.icbmclassic.Main;

import com.builtbroken.icbmclassic.entities.explosiveentities.CondensedExplosivesEntity;
import com.builtbroken.icbmclassic.entities.tileentity.TileEntityEMPTower;
import com.builtbroken.icbmclassic.entities.tileentity.TileEntityRadarStation;
import com.builtbroken.icbmclassic.renderers.ItemRenderEMPTower;
import com.builtbroken.icbmclassic.renderers.ItemRenderRadarStation;
import com.builtbroken.icbmclassic.renderers.RenderCondensedExplosivesEntity;
import com.builtbroken.icbmclassic.renderers.RenderEMPTower;
import com.builtbroken.icbmclassic.renderers.RenderRadarStation;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

/** Written By Herobrine11892 **/

public class ClientProxy extends ServerProxy{
	
	public void registerRenderInfo()
	{
		//Radar Station
		TileEntitySpecialRenderer RadarRender = new RenderRadarStation();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRadarStation.class, RadarRender);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(com.builtbroken.icbmclassic.blocks.BlockMain.RadarStation),new ItemRenderRadarStation(RadarRender, new TileEntityRadarStation()));
		//EMP Tower
		TileEntitySpecialRenderer EMPTowerRender = new RenderEMPTower();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityEMPTower.class, EMPTowerRender);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(com.builtbroken.icbmclassic.blocks.BlockMain.EMPTower),new ItemRenderEMPTower(EMPTowerRender, new TileEntityEMPTower()));
		//Condensed Explosives
		RenderingRegistry.registerEntityRenderingHandler(CondensedExplosivesEntity.class, new RenderCondensedExplosivesEntity());
	}
	
	public void registerTileEntitySpecialRenderer()
	{
		
	}

}
