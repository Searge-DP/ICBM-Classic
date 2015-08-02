package com.builtbroken.icbmclassic.content.grenade;

import com.builtbroken.mc.api.event.TriggerCause;
import com.builtbroken.mc.api.explosive.IExplosiveHandler;
import com.builtbroken.mc.api.explosive.IGrenadeEntity;
import com.builtbroken.mc.lib.world.explosive.ExplosiveRegistry;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

/**
 * Created by Philipp on 26.07.2015.
 */
public class EntityGrenade extends EntityThrowable implements IGrenadeEntity
{
    private double relVelocity = 0.75;
    private int lifespan;

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

    public EntityGrenade(World world, EntityLivingBase throwingEntity, int timer)
    {
        super(world, throwingEntity);
        //slows down the grenade depending on a maximum throw force and velocity of the Player.
        double x = throwingEntity.getLookVec().xCoord * relVelocity + throwingEntity.motionX;
        double y = throwingEntity.getLookVec().yCoord * relVelocity + throwingEntity.motionY;
        double z = throwingEntity.getLookVec().zCoord * relVelocity + throwingEntity.motionZ;
        this.setVelocity(x, y, z);
        this.lifespan = timer;
        this.throwingEntity = throwingEntity;
    }

    @Override
    public void onUpdate()
    {
        if (!this.worldObj.isRemote)
        {
            this.lifespan--;
            if (this.lifespan <= 0)
            {
                if(getExplosive() != null)
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
        double x = this.motionX;
        double y = this.motionY;
        double z = this.motionZ;

        if (mop.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK)
        {
            //TODO have not bounce off of things like grass or spider webs
            switch (mop.sideHit)
            {
                case 0: //BOTTOM
                    this.setVelocity(0.75 * x, -0.1 * y, 0.75 * z);
                    break;
                case 1: //TOP
                    this.setVelocity(0.75 * x, -0.1 * y, 0.75 * z);
                    break;
                case 2: //EAST
                    this.setVelocity(0.75 * x, 0.75 * y, -0.1 * z);
                    break;
                case 3: //WEST
                    this.setVelocity(0.75 * x, 0.75 * y, -0.1 * z);
                    break;
                case 4: //NORTH
                    this.setVelocity(-0.1 * x, 0.75 * y, 0.75 * z);
                    break;
                case 5: //SOUTH
                    this.setVelocity(-0.1 * x, 0.75 * y, 0.75 * z);
                    break;
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
