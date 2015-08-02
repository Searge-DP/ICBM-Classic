package com.builtbroken.icbmclassic.content.grenade;

import com.builtbroken.mc.api.event.TriggerCause;
import com.builtbroken.mc.api.explosive.IExplosiveHandler;
import com.builtbroken.mc.api.explosive.IGrenadeEntity;
import com.builtbroken.mc.lib.transform.vector.Pos;
import com.builtbroken.mc.lib.world.explosive.ExplosiveRegistry;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.nbt.NBTTagCompound;
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
    private Pos prev_pos;

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
        this.motionX = this.motionX * 0.98;
        this.motionY = this.motionY * 0.98;
        this.motionZ = this.motionZ * 0.98;

        if (!inGround && mop.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK)
        {
            Block block = worldObj.getBlock(mop.blockX, mop.blockY, mop.blockZ);

            if (block != null && block == cachedBlock)
            {
                this.blockX = mop.blockX;
                this.blockY = mop.blockY;
                this.blockZ = mop.blockZ;
                this.cachedBlock = block;
                this.inGround = true;
            }
            else
            {
                switch (ForgeDirection.getOrientation(mop.sideHit))
                {
                    case UP:
                    case DOWN:
                        this.setThrowableHeading(motionX, -motionY, motionZ, 1.0f, 0.0f);
                        break;
                    case EAST:
                    case WEST:
                        this.setThrowableHeading(-motionX, motionY, motionZ, 1.0f, 0.0f);
                        break;
                    case NORTH:
                    case SOUTH:
                        this.setThrowableHeading(motionX, motionY, -motionZ, 1.0f, 0.0f);
                        break;
                }
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
