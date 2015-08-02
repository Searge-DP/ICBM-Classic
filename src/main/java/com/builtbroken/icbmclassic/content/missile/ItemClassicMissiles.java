package com.builtbroken.icbmclassic.content.missile;

import com.builtbroken.icbm.ICBM;
import com.builtbroken.icbm.api.IAmmo;
import com.builtbroken.icbm.api.IAmmoType;
import com.builtbroken.icbm.api.IMissileItem;
import com.builtbroken.icbm.api.IWeapon;
import com.builtbroken.icbm.content.missile.EntityMissile;
import com.builtbroken.mc.api.explosive.IExplosiveHandler;
import com.builtbroken.mc.api.items.IExplosiveItem;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by robert on 1/17/2015.
 */
public class ItemClassicMissiles extends Item implements IExplosiveItem, IAmmo, IMissileItem
{
    public ItemClassicMissiles()
    {
        this.setUnlocalizedName("missileclassic");
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
        this.setMaxStackSize(1);
    }

    @Override
    public int getMetadata(int damage)
    {
        return damage;
    }

    @Override
    public String getUnlocalizedName()
    {
        return "item." + ICBM.PREFIX + "missile";
    }

    @Override
    public String getUnlocalizedName(ItemStack item)
    {
        return getUnlocalizedName() + EnumMissiles.get(item.getItemDamage()).unlocalizedName;
    }

    @Override
    public IExplosiveHandler getExplosive(ItemStack stack)
    {
        return EnumMissiles.get(stack.getItemDamage()).ex;
    }

    @Override
    public boolean isAmmo(ItemStack stack)
    {
        return true;
    }

    @Override
    public boolean isClip(ItemStack stack)
    {
        return false;
    }

    @Override
    public IAmmoType getAmmoType(ItemStack stack)
    {
        return EnumMissiles.get(stack.getItemDamage()).size;
    }

    @Override
    public int getAmmoCount(ItemStack ammoStack)
    {
        return ammoStack.stackSize;
    }

    @Override
    public void fireAmmo(IWeapon weapon, ItemStack weaponStack, ItemStack ammoStack, Entity firingEntity)
    {
        EntityMissile.fireMissileByEntity(firingEntity, ammoStack);
    }

    @Override
    public void consumeAmmo(IWeapon weapon, ItemStack weaponStack, ItemStack ammoStack, int shotsFired)
    {
        ammoStack.stackSize -= shotsFired;
    }

    @Override
    public void getSubItems(Item item, CreativeTabs tab, List list)
    {
        for (EnumMissiles missile : EnumMissiles.values())
        {
            list.add(new ItemStack(item, 1, missile.ordinal()));
        }
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean bool)
    {
        super.addInformation(stack, player, list, bool);
    }

    @Override
    public Entity getMissileEntity(ItemStack stack)
    {
        EntityClassicMissile missile = new EntityClassicMissile((World)null);
        missile.id = stack.getItemDamage();
        return missile;
    }

    @Override
    public Entity getMissileEntity(ItemStack stack, Entity firedBy)
    {
        if(firedBy instanceof EntityLivingBase)
        {
            EntityClassicMissile missile = new EntityClassicMissile((EntityLivingBase)firedBy);
            missile.id = stack.getItemDamage();
            return missile;
        }
        return null;
    }
}
