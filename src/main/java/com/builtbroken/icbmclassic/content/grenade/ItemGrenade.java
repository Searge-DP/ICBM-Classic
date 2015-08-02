package com.builtbroken.icbmclassic.content.grenade;

import com.builtbroken.mc.api.explosive.IExplosiveHandler;
import com.builtbroken.mc.api.items.IExplosiveItem;
import com.builtbroken.mc.core.registry.implement.IPostInit;
import com.builtbroken.mc.lib.world.explosive.ExplosiveItemUtility;
import com.builtbroken.mc.lib.world.explosive.ExplosiveRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by Philipp on 26.07.2015.
 */
public class ItemGrenade extends Item implements IExplosiveItem, IPostInit
{
    public ItemGrenade()
    {
        this.setUnlocalizedName("Grenade");
        this.setMaxStackSize(16);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }

    @Override
    public void onPostInit()
    {
        //TODO register recipes for items
    }

    @Override
    public int getMaxItemUseDuration(ItemStack par1ItemStack)
    {
        return 3 * 20;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer)
    {
        // start explosion timer
        entityPlayer.setItemInUse(itemStack, getMaxItemUseDuration(itemStack));
        return itemStack;
    }

    @Override
    public void onPlayerStoppedUsing(ItemStack itemStack, World world, EntityPlayer entityPlayer, int duration)
    {
        world.playSoundAtEntity(entityPlayer, "random.fuse", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

        if (!entityPlayer.capabilities.isCreativeMode)
        {
            itemStack.stackSize--;

            if (itemStack.stackSize <= 0)
            {
                entityPlayer.inventory.setInventorySlotContents(entityPlayer.inventory.currentItem, null);
            }
        }

        if (!world.isRemote)
        {
            EntityGrenade grenade = new EntityGrenade(world, entityPlayer, duration);
            grenade.setExplosive(getExplosive(itemStack), 1.0, new NBTTagCompound());
            world.spawnEntityInWorld(grenade);
        }
    }

    @Override
    public IExplosiveHandler getExplosive(ItemStack stack)
    {
        return ExplosiveItemUtility.getExplosive(stack);
    }

    public void setExplosive(ItemStack stack, IExplosiveHandler ex)
    {
        ExplosiveItemUtility.setExplosive(stack, ex);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(Item item, CreativeTabs tab, List items)
    {
        for (IExplosiveHandler handler : ExplosiveRegistry.getExplosives())
        {
            ItemStack stack = new ItemStack(item, 1, 0);
            setExplosive(stack, handler);
            items.add(stack);
        }
    }
}
