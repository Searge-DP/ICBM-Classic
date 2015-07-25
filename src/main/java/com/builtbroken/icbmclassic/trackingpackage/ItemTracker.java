package com.builtbroken.icbmclassic.trackingpackage;

import com.builtbroken.icbmclassic.ICBM_Classic;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraft.nbt.NBTTagCompound;
import com.builtbroken.mc.lib.helper.LanguageUtility;

import java.util.List;

/**
 * Created by Philipp on 25.07.2015.
 * Basic Item to Track Players
 *
 */


public class ItemTracker extends Item {

    public ItemTracker() {
        this.setUnlocalizedName("Item Tracker");
        this.setMaxStackSize(1);
        this.setMaxDamage(64);
    }

    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4) {
        if(itemStack.stackTagCompound == null){
            list.add(EnumChatFormatting.BLUE +  LanguageUtility.getLocalName("item.icbmclassic:itemtracker.description.name"));
        }else{
            Entity entity = getTrackingEntity(player.worldObj, itemStack);
            if(entity != null){
            //add information where my entity is gone.
                list.add(EnumChatFormatting.BLUE +
                    " X: " + Math.round(entity.posX) +
                    " Y: " + Math.round(entity.posY) +
                    " Z: " + Math.round(entity.posZ));
            }else{
                list.add(EnumChatFormatting.BLUE +  LanguageUtility.getLocalName("item.icbmclassic:itemtracker.description.name"));
            }
        }
    }

    public void setTrackingEntity(ItemStack itemStack, Entity entity){
        if (itemStack.stackTagCompound == null)
        {
            itemStack.setTagCompound(new NBTTagCompound());
        }

        if (entity != null)
        {
            itemStack.stackTagCompound.setInteger("trackingEntity", entity.getEntityId());
        }
    }

    public Entity getTrackingEntity(World worldObj, ItemStack itemStack){
        if (worldObj != null)
        {
            if (itemStack.stackTagCompound != null)
            {
                int trackingID = itemStack.stackTagCompound.getInteger("trackingEntity");
                if (worldObj.getEntityByID(trackingID) != null){
                    return worldObj.getEntityByID(trackingID);
                }
            }
        }
        return null;
    }


    public boolean onLeftClickEntity(ItemStack itemStack, EntityPlayer player, Entity entity){
        setTrackingEntity(itemStack, entity);
        LanguageUtility.addChatToPlayer(player, "Tracking now Entity: " + entity.getCommandSenderName());
        return true;
    }
}
