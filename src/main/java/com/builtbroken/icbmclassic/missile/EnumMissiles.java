package com.builtbroken.icbmclassic.missile;

import com.builtbroken.icbm.content.missile.AmmoTypeMissile;
import com.builtbroken.mc.api.explosive.IExplosive;

/**
 * Created by robert on 1/17/2015.
 */
public enum EnumMissiles
{
    UNKNOWN(),
    REDMATTER();

    AmmoTypeMissile size = AmmoTypeMissile.STANDARD;
    IExplosive ex;
    String modelName;
    String textureName;
    String unlocalizedName;

    private EnumMissiles()
    {

    }

    private EnumMissiles(AmmoTypeMissile size, String modelName, String textureName, String unlocalizedName, IExplosive ex)
    {
        this.size = size;
        this.modelName = modelName;
        this.textureName = textureName;
        this.unlocalizedName = unlocalizedName;
        this.ex = ex;
    }

    public static EnumMissiles get(int id)
    {
        if(id >= 0 && id < values().length)
            return values()[id];
        return UNKNOWN;
    }
}
