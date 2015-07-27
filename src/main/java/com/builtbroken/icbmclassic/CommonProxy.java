package com.builtbroken.icbmclassic;

import com.builtbroken.icbmclassic.content.entity.EntityGrenade;
import com.builtbroken.icbmclassic.content.render.RenderGrenade;
import com.builtbroken.mc.lib.mod.AbstractProxy;
import cpw.mods.fml.client.registry.RenderingRegistry;

/**
 * Created by robert on 1/17/2015.
 */
public class CommonProxy extends AbstractProxy
{
    public void registerRenderers(){
        RenderingRegistry.registerEntityRenderingHandler(EntityGrenade.class, new RenderGrenade(ICBM_Classic.itemGrenade));
    }
}
