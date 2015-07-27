package com.builtbroken.icbmclassic.content.render;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.item.Item;


/**
 * Created by Philipp on 27.07.2015.
 */

    @SideOnly(Side.CLIENT)
    public class RenderGrenade extends RenderSnowball
{
    public RenderGrenade(Item item) {
        this(item, 0);
    }

    public RenderGrenade(Item item, int par2) {
        super(item, par2);
    }
}
