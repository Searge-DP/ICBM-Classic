package com.builtbroken.icbmclassic.content.grenade;

import com.builtbroken.icbmclassic.ICBM_Classic;
import com.builtbroken.mc.api.explosive.ICustomGrenadeRenderer;
import com.builtbroken.mc.api.explosive.IExplosiveHandler;
import com.builtbroken.mc.api.items.IExplosiveItem;
import com.builtbroken.mc.core.registry.implement.IPostInit;
import com.builtbroken.mc.lib.world.explosive.ExplosiveItemUtility;
import com.builtbroken.mc.lib.world.explosive.ExplosiveRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by Philipp on 26.07.2015.
 */
public class ItemGrenade extends Item implements IExplosiveItem, IPostInit
{
    private double minVelovity = 0.30;
    private double maxVelovity = 0.80;

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

    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean p_77624_4_)
    {
        //TODO add explosive information
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister reg)
    {
        this.itemIcon = reg.registerIcon(ICBM_Classic.PREFIX + "grenade.default");
        //Registered icons for custom grenades
        for (IExplosiveHandler handler : ExplosiveRegistry.getExplosives())
        {
            if (handler instanceof ICustomGrenadeRenderer)
            {
                ((ICustomGrenadeRenderer) handler).registerGrenadeIcons(reg);
            }
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(ItemStack stack, int pass)
    {
        IExplosiveHandler handler = getExplosive(stack);
        if (handler instanceof ICustomGrenadeRenderer)
        {
            return ((ICustomGrenadeRenderer) handler).getGrenadeIcon(stack);
        }
        return super.getIcon(stack, pass);
    }

    @Override
    public int getMaxItemUseDuration(ItemStack par1ItemStack)
    {
        return 5 * 20;
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
            EntityGrenade grenade = new EntityGrenade(world, entityPlayer, Math.max(minVelovity, Math.min((duration / getMaxItemUseDuration(itemStack)) * maxVelovity, maxVelovity)));
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
