package com.builtbroken.icbmclassic.content.item;

import com.builtbroken.icbmclassic.ICBM_Classic;
import com.builtbroken.mc.lib.helper.LanguageUtility;
import com.builtbroken.mc.lib.transform.vector.Location;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import scala.tools.cmd.gen.AnyVals;

import java.util.List;


/**
 * Created by Philipp on 06.08.2015.
 */
public class ItemRadargun extends Item {
    Location target;
    long cooldown = 0;

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
        if(System.currentTimeMillis() >= this.cooldown) {
            this.cooldown = System.currentTimeMillis() + 1000;

            MovingObjectPosition mop = Minecraft.getMinecraft().renderViewEntity.rayTrace(200, 1.0F);
            if (mop != null) {

                if (!worldObj.isAirBlock(mop.blockX, mop.blockY, mop.blockZ)) {
                    this.target = new Location(worldObj, mop.blockX, mop.blockY, mop.blockZ);



                    LanguageUtility.addChatToPlayer(
                            player, "Block: " +
                            this.target.getX() + " " +
                            this.target.getY() + " " +
                            this.target.getZ());

                    this.saveLocation(stack, this.target);

                } else {
                    return stack;
                }

                //TODO Use Charge of Item

                return stack;
            } else {
                return stack;
            }
        }
        return stack;
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4) {
            if (this.target != null) {
                if (itemStack.hasTagCompound()) {
                    Location targetLocation = this.getLocation(itemStack);
                    targetLocation.getX();

                }
                //add information where my entity is gone.
                list.add(EnumChatFormatting.BLUE +
                        " X: " + this.target.getX() +
                        " Y: " + this.target.getY()+
                        " Z: " + this.target.getZ());
            } else {
                //TODO LOCALIZED ITEM DESCRIPTION
                list.add(EnumChatFormatting.BLUE + LanguageUtility.getLocal(getUnlocalizedName() + ".description"));
            }
    }

    public void saveLocation(ItemStack stack, Location loc){
        if (stack.getItem() == this && !stack.hasTagCompound()) {
            stack.setTagCompound(new NBTTagCompound());
            stack.getTagCompound().setTag("linkPos", loc.toNBT());
        }
    }

    public Location getLocation(ItemStack stack){
        if (stack.getItem() == this && stack.hasTagCompound()  && stack.getTagCompound().hasKey("linkPos")) {
            return new Location(stack.getTagCompound().getCompoundTag("linkPos"));
        }
        return null;
    }

}
