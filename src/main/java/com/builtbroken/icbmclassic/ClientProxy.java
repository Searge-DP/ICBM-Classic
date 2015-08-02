package com.builtbroken.icbmclassic;

import com.builtbroken.icbmclassic.content.grenade.EntityGrenade;
import com.builtbroken.icbmclassic.content.grenade.RenderGrenade;
import cpw.mods.fml.client.registry.RenderingRegistry;

/**
 * Created by robert on 1/17/2015.
 */
public class ClientProxy extends CommonProxy
{
    @Override
    public void init()
    {
        RenderingRegistry.registerEntityRenderingHandler(EntityGrenade.class, new RenderGrenade());
    }
}
