package com.builtbroken.icbmclassic.content;

import com.builtbroken.icbm.ICBM;
import com.builtbroken.icbmclassic.ICBM_Classic;
import com.builtbroken.mc.core.References;
import com.builtbroken.mc.lib.render.model.loader.EngineModelLoader;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.IModelCustom;

/**
 * Created by Philipp on 26.07.2015.
 */
public class Assets
{
    public static final IModelCustom GRENADE_MODEL = model("PineGrenade.obj");

    public static IModelCustom model(String name)
    {
        return EngineModelLoader.loadModel(new ResourceLocation(ICBM_Classic.DOMAIN, References.MODEL_PATH + name));
    }

    public static ResourceLocation texture(String name)
    {
        return new ResourceLocation(ICBM.DOMAIN, "textures/models/" + name + ".png");
    }
}
