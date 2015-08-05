package com.builtbroken.icbmclassic.content.grenade;

import com.builtbroken.mc.api.event.TriggerCause;
import com.builtbroken.mc.api.explosive.IExplosiveHandler;
import com.builtbroken.mc.api.explosive.IGrenadeEntity;
import com.builtbroken.mc.lib.transform.vector.Pos;
import com.builtbroken.mc.lib.world.explosive.ExplosiveRegistry;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

/**
 * Created by Philipp on 26.07.2015.
 */
public class EntityGrenade extends EntityThrowable implements IGrenadeEntity
{
    private int lifespan = 100;
    private boolean stuckInGround = false;
    private Entity hit;

    protected double explosionRadius = 1.0F;
    protected EntityLivingBase throwingEntity;
    protected IExplosiveHandler explosiveHandler;
    protected NBTTagCompound explosiveData;

    //Default entity method
    public EntityGrenade(World world)
    {
        super(world);
    }

    //TODO implement dispenser behavior code to throw grenade
    public EntityGrenade(World world, double xx, double yy, double zz)
    {
        super(world, xx, yy, zz);
    }

    public EntityGrenade(World world, EntityLivingBase throwingEntity, float vel)
    {
        super(world, throwingEntity, vel);
    }

    @Override
    public void onUpdate()
    {
        if (!this.worldObj.isRemote)
        {
            this.lifespan--;
            if (this.lifespan <= 0)
            {
                if (getExplosive() != null)
                {
                    ExplosiveRegistry.triggerExplosive(worldObj, posX, posY, posZ, getExplosive(), new TriggerCause.TriggerCauseEntity(throwingEntity), explosionRadius, explosiveData);
                }
                else
                {
                    this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, (float) this.explosionRadius, true);
                }
                this.setDead();
            }
        }
        super.onUpdate();
    }

    @Override
    public void onImpact(MovingObjectPosition mop)
    {
        //Reduced velocity for each time we hit something
        this.motionX = this.motionX * 0.65;
        this.motionY = this.motionY * 0.65;
        this.motionZ = this.motionZ * 0.65;

        if (mop.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK)
        {
            //TODO play impact sound effect: DONE
            //TODO play rolling on ground sound effect: Fixed with the same thing
            if (!inGround)
            {
                this.worldObj.playSoundAtEntity(this, "mob.pig.step", 0.5F, 0.4F / (rand.nextFloat()*0.4F + 0.4F));
                Block block = worldObj.getBlock(mop.blockX, mop.blockY, mop.blockZ);

                //Cuts motion Y if we are not moving in any direction
                if (this.motionX <= .05 && this.motionZ <= .05)
                {
                    this.motionY = 0;
                }

                //Checks if we are bounce on the same block
                if (block != null && block == this.cachedBlock)
                {
                    this.blockX = mop.blockX;
                    this.blockY = mop.blockY;
                    this.blockZ = mop.blockZ;
                    this.inGround = true;
                }
                else
                {
                    this.cachedBlock = block;

                    //Redirects the motion to the opposite direction based on side TODO use the same code for entity collisions
                    switch (ForgeDirection.getOrientation(mop.sideHit))
                    {
                        case UP:
                        case DOWN:
                            this.motionY = -this.motionY;
                            break;
                        case EAST:
                        case WEST:
                            this.motionX = -this.motionX;
                            break;
                        case NORTH:
                        case SOUTH:
                            this.motionZ = -this.motionZ;
                            break;
                    }
                }
            }
        }
        else if (mop.typeOfHit == MovingObjectPosition.MovingObjectType.ENTITY)
        {
            //TODO apply some damage to the entity based on velocity
            //TODO play impact sound effect

            // I dont belive, that grenades bounce off people and refuse to test it in real life.

            if (this.hit != null && this.hit == mop.entityHit){
                this.motionX = 0;
                this.motionY = 0;
                this.motionZ = 0;
            }else{
                this.hit = mop.entityHit;

                this.hit.attackEntityFrom(DamageSource.generic, 1);

                this.motionX = 0;
                this.motionY = 0;
                this.motionZ = 0;
                this.worldObj.playSoundAtEntity(this, "mob.sheep.step", 0.5F, 0.4F / (rand.nextFloat() * 0.4F + 0.4F));
            }
        }
    }



    @Override
    public boolean setExplosive(IExplosiveHandler ex, double size, NBTTagCompound nbt)
    {
        this.explosiveHandler = ex;
        this.explosionRadius = size;
        this.explosiveData = nbt;
        return true;
    }

    @Override
    public IExplosiveHandler getExplosive()
    {
        return explosiveHandler;
    }
}
