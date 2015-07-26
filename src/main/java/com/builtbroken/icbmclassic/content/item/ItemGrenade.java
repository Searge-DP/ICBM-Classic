package com.builtbroken.icbmclassic.content.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.entity.player.EntityPlayer;
import com.builtbroken.icbmclassic.content.entity.EntityGrenade;

/**
 * Created by Philipp on 26.07.2015.
 */
public class ItemGrenade extends Item{

    public ItemGrenade() {
        this.setUnlocalizedName("Grenade");
        this.setMaxStackSize(16);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }

    @Override
    public int getMaxItemUseDuration(ItemStack par1ItemStack){
        return 3 * 20;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer){
        // start explosion timer

        entityPlayer.setItemInUse(itemStack, getMaxItemUseDuration(itemStack));
        return itemStack;
    }

    @Override
    public void onPlayerStoppedUsing(ItemStack itemStack, World world, EntityPlayer entityPlayer, int duration){
        world.playSoundAtEntity(entityPlayer, "random.fuse", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
        world.spawnEntityInWorld(new EntityGrenade(world, entityPlayer, duration));

        if (!entityPlayer.capabilities.isCreativeMode) {
            itemStack.stackSize--;

            if (itemStack.stackSize <= 0){
                entityPlayer.inventory.setInventorySlotContents(entityPlayer.inventory.currentItem, null);
            }
        }
    }
    
}
