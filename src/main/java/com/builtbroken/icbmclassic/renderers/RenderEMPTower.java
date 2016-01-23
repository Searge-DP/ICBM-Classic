package com.builtbroken.icbmclassic.renderers;

import org.lwjgl.opengl.GL11;

import com.builtbroken.icbmclassic.models.EMPTowerModel;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

/** Written By Herobrine11892 **/

public class RenderEMPTower extends TileEntitySpecialRenderer{
	
	private static final ResourceLocation texture = new ResourceLocation(com.builtbroken.icbmclassic.lib.RefStrings.MODID + ":" + "textures/models/emp_tower.png");
	
	private EMPTowerModel model;
	
	public RenderEMPTower()
	{
		this.model = new EMPTowerModel();
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
