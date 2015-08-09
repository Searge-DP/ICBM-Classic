package com.builtbroken.icbmclassic.content.item;

import com.builtbroken.icbmclassic.ICBM_Classic;
import com.builtbroken.mc.lib.helper.LanguageUtility;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import java.util.List;


/**
 * Created by Philipp on 06.08.2015.
 */
public class ItemRadargun extends Item {
    MovingObjectPosition target = null;

    public ItemRadargun(){
        //TODO GET LOCALIZED ITEMNAME
        this.setUnlocalizedName("Radar Gun");
        this.setMaxStackSize(1);
        this.setMaxDamage(64);

    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister reg)
    {
        this.itemIcon = reg.registerIcon(ICBM_Classic.PREFIX + "radarGun");
    }

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World worldObj, EntityPlayer player) {
        MovingObjectPosition mop = Minecraft.getMinecraft().renderViewEntity.rayTrace(200, 1.0F);
        if (mop != null) {
            int blockHitSide = mop.sideHit;
            this.target = mop;
            LanguageUtility.addChatToPlayer(player, "Block: "+mop.blockX+" "+mop.blockY+" "+mop.blockZ);

            //TODO CHECK IF BLOCK IS AIRBLOCK

            //TODO Use Charge of Item

            return stack;
        }else{
            return stack;
        }
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4) {
            if (this.target != null) {
                //add information where my entity is gone.
                list.add(EnumChatFormatting.BLUE +
                        " X: " + this.target.blockX +
                        " Y: " + this.target.blockY +
                        " Z: " + this.target.blockZ );
            } else {
                //TODO LOCALIZED ITEM DESCRIPTION
                list.add(EnumChatFormatting.BLUE + LanguageUtility.getLocal(getUnlocalizedName() + ".description"));
            }
    }


}
