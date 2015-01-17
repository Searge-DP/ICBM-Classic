package com.builtbroken.icbmclassic.missile;

import com.builtbroken.icbm.ICBM;
import com.builtbroken.icbm.content.crafting.missile.MissileModuleBuilder;
import com.builtbroken.icbm.content.crafting.missile.casing.Missile;
import com.builtbroken.icbm.content.crafting.missile.casing.MissileCasings;
import com.builtbroken.icbm.content.missile.EntityMissile;
import com.builtbroken.mc.api.explosive.IExplosive;
import cpw.mods.fml.common.network.ByteBufUtils;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

/**
 * Created by robert on 1/17/2015.
 */
public class EntityClassicMissile extends EntityMissile
{
    public int id = 0;

    public EntityClassicMissile(World w)
    {
        super(w);
    }

    public EntityClassicMissile(EntityLivingBase entity)
    {
        super(entity);
    }

    @Override
    public String getCommandSenderName()
    {
        return "Classic_Missile_" + EnumMissiles.get(id).unlocalizedName;
    }

    @Override
    protected void readEntityFromNBT(NBTTagCompound nbt)
    {
        super.readEntityFromNBT(nbt);
        id = nbt.getInteger("missileID");
    }

    @Override
    protected void writeEntityToNBT(NBTTagCompound nbt)
    {
        super.writeEntityToNBT(nbt);
        nbt.setInteger("missileID", id);
    }

    @Override
    public void writeSpawnData(ByteBuf buffer)
    {
        buffer.writeInt(id);
    }

    @Override
    public void readSpawnData(ByteBuf buffer)
    {
        id = buffer.readInt();
    }

    @Override
    public Missile getMissile()
    {
        return null;
    }

    @Override
    public void setMissile(Missile missile)
    {

    }

    @Override
    public IExplosive getExplosive()
    {
        return EnumMissiles.get(id).ex;
    }
}
