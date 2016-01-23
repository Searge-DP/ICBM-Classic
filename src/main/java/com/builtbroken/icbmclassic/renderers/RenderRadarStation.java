package com.builtbroken.icbmclassic.renderers;

import org.lwjgl.opengl.GL11;

/** Written By Herobrine11892 **/

import com.builtbroken.icbmclassic.models.RadarStationModel;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class RenderRadarStation extends TileEntitySpecialRenderer{
	
	private static final ResourceLocation texture = new ResourceLocation(com.builtbroken.icbmclassic.lib.RefStrings.MODID + ":" + "textures/models/Radar.png");
	
	private RadarStationModel model;
	
	public RenderRadarStation()
	{
		this.model = new RadarStationModel();
	}

	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f) 
	{
		GL11.glPushMatrix();
			GL11.glTranslated((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
			GL11.glRotatef(180, 0F, 0F, 1F);
			
			this.bindTexture(texture);
			
			GL11.glPushMatrix();
				this.model.renderModel(0.0625F);
			GL11.glPopMatrix();
		GL11.glPopMatrix();
	}

}
