package com.builtbroken.icbmclassic.content.grenade;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by Dark on 8/2/2015.
 */
public abstract class EntityThrowable extends Entity implements IProjectile
{

    protected Block cachedBlock;
    protected boolean inGround;
    protected int blockX = -1;
    protected int blockY = -1;
    protected int blockZ = -1;
    /** The entity that threw this throwable item. */
    private EntityLivingBase thrower;
    private String throwerName;
    private int ticksInGround;
    private int ticksInAir;

    public EntityThrowable(World world)
    {
        super(world);
        this.setSize(0.25F, 0.25F);
        this.yOffset = 0.0F;
        this.ticksInGround = 0;
    }

    public EntityThrowable(World world, double xx, double yy, double zz)
    {
        this(world);
        this.setPosition(xx, yy, zz);
    }

    public EntityThrowable(World world, EntityLivingBase throwingEntity, float vel)
    {
        this(world);
        this.thrower = throwingEntity;

        //Set position from thrower
        this.setLocationAndAngles(throwingEntity.posX, throwingEntity.posY + (double) throwingEntity.getEyeHeight(), throwingEntity.posZ, throwingEntity.rotationYaw, throwingEntity.rotationPitch);
        this.posX -= (double) (MathHelper.cos(this.rotationYaw / 180.0F * (float) Math.PI) * 0.16F);
        this.posY -= 0.10000000149011612D;
        this.posZ -= (double) (MathHelper.sin(this.rotationYaw / 180.0F * (float) Math.PI) * 0.16F);
        this.setPosition(this.posX, this.posY, this.posZ);

        this.yOffset = 0.0F;

        //Update vel from thrower
        float f = 0.4F;
        this.motionX = (double) (-MathHelper.sin(this.rotationYaw / 180.0F * (float) Math.PI) * MathHelper.cos(this.rotationPitch / 180.0F * (float) Math.PI) * f);
        this.motionZ = (double) (MathHelper.cos(this.rotationYaw / 180.0F * (float) Math.PI) * MathHelper.cos(this.rotationPitch / 180.0F * (float) Math.PI) * f);
        this.motionY = (double) (-MathHelper.sin((this.rotationPitch) / 180.0F * (float) Math.PI) * f);
        this.setThrowableHeading(this.motionX, this.motionY, this.motionZ, vel, 1.0F);
    }

    public EntityThrowable(World world, EntityLivingBase throwingEntity)
    {
        this(world, throwingEntity, 1.5f);
    }


    @Override
    protected void entityInit() {}

    @Override
    @SideOnly(Side.CLIENT)
    public boolean isInRangeToRenderDist(double p_70112_1_)
    {
        double d1 = this.boundingBox.getAverageEdgeLength() * 4.0D;
        d1 *= 64.0D;
        return p_70112_1_ < d1 * d1;
    }

    @Override
    public void setThrowableHeading(double xx, double yy, double zz, float vel, float error)
    {
        //Normalize
        float sqrt = MathHelper.sqrt_double(xx * xx + yy * yy + zz * zz);
        xx /= (double) sqrt;
        yy /= (double) sqrt;
        zz /= (double) sqrt;

        //Add error
        xx += this.rand.nextGaussian() * 0.007499999832361937D * (double) error;
        yy += this.rand.nextGaussian() * 0.007499999832361937D * (double) error;
        zz += this.rand.nextGaussian() * 0.007499999832361937D * (double) error;

        //Add vel
        xx *= (double) vel;
        yy *= (double) vel;
        zz *= (double) vel;

        //Set motion
        this.motionX = xx;
        this.motionY = yy;
        this.motionZ = zz;

        //Update rotation
        float sq = MathHelper.sqrt_double(xx * xx + zz * zz);
        this.prevRotationYaw = this.rotationYaw = (float) (Math.atan2(xx, zz) * 180.0D / Math.PI);
        this.prevRotationPitch = this.rotationPitch = (float) (Math.atan2(yy, (double) sq) * 180.0D / Math.PI);
        this.ticksInGround = 0;
    }


    @Override
    @SideOnly(Side.CLIENT)
    public void setVelocity(double p_70016_1_, double p_70016_3_, double p_70016_5_)
    {
        this.motionX = p_70016_1_;
        this.motionY = p_70016_3_;
        this.motionZ = p_70016_5_;

        if (this.prevRotationPitch == 0.0F && this.prevRotationYaw == 0.0F)
        {
            float f = MathHelper.sqrt_double(p_70016_1_ * p_70016_1_ + p_70016_5_ * p_70016_5_);
            this.prevRotationYaw = this.rotationYaw = (float) (Math.atan2(p_70016_1_, p_70016_5_) * 180.0D / Math.PI);
            this.prevRotationPitch = this.rotationPitch = (float) (Math.atan2(p_70016_3_, (double) f) * 180.0D / Math.PI);
        }
    }

    @Override
    public void onUpdate()
    {
        this.lastTickPosX = this.posX;
        this.lastTickPosY = this.posY;
        this.lastTickPosZ = this.posZ;
        super.onUpdate();

        if (this.inGround)
        {
            if (this.worldObj.getBlock(this.blockX, this.blockY, this.blockZ) == this.cachedBlock)
            {
                ++this.ticksInGround;

                if (this.ticksInGround == 1200)
                {
                    this.setDead();
                }

                return;
            }

            this.inGround = false;
            this.motionX *= (double) (this.rand.nextFloat() * 0.2F);
            this.motionY *= (double) (this.rand.nextFloat() * 0.2F);
            this.motionZ *= (double) (this.rand.nextFloat() * 0.2F);
            this.ticksInGround = 0;
            this.ticksInAir = 0;
        }
        else
        {
            ++this.ticksInAir;
        }

        Vec3 vec3 = Vec3.createVectorHelper(this.posX, this.posY, this.posZ);
        Vec3 vec31 = Vec3.createVectorHelper(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
        MovingObjectPosition movingobjectposition = this.worldObj.rayTraceBlocks(vec3, vec31);
        vec3 = Vec3.createVectorHelper(this.posX, this.posY, this.posZ);
        vec31 = Vec3.createVectorHelper(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);

        if (movingobjectposition != null)
        {
            vec31 = Vec3.createVectorHelper(movingobjectposition.hitVec.xCoord, movingobjectposition.hitVec.yCoord, movingobjectposition.hitVec.zCoord);
        }

        if (!this.worldObj.isRemote)
        {
            Entity entity = null;
            List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.addCoord(this.motionX, this.motionY, this.motionZ).expand(1.0D, 1.0D, 1.0D));
            double d0 = 0.0D;
            EntityLivingBase entitylivingbase = this.getThrower();

            for (int j = 0; j < list.size(); ++j)
            {
                Entity entity1 = (Entity) list.get(j);

                if (entity1.canBeCollidedWith() && (entity1 != entitylivingbase || this.ticksInAir >= 5))
                {
                    float f = 0.3F;
                    AxisAlignedBB axisalignedbb = entity1.boundingBox.expand((double) f, (double) f, (double) f);
                    MovingObjectPosition movingobjectposition1 = axisalignedbb.calculateIntercept(vec3, vec31);

                    if (movingobjectposition1 != null)
                    {
                        double d1 = vec3.distanceTo(movingobjectposition1.hitVec);

                        if (d1 < d0 || d0 == 0.0D)
                        {
                            entity = entity1;
                            d0 = d1;
                        }
                    }
                }
            }

            if (entity != null)
            {
                movingobjectposition = new MovingObjectPosition(entity);
            }
        }

        if (movingobjectposition != null)
        {
            if (movingobjectposition.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK && this.worldObj.getBlock(movingobjectposition.blockX, movingobjectposition.blockY, movingobjectposition.blockZ) == Blocks.portal)
            {
                this.setInPortal();
            }
            else
            {
                this.onImpact(movingobjectposition);
            }
        }

        this.posX += this.motionX;
        this.posY += this.motionY;
        this.posZ += this.motionZ;
        float f1 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
        this.rotationYaw = (float) (Math.atan2(this.motionX, this.motionZ) * 180.0D / Math.PI);

        for (this.rotationPitch = (float) (Math.atan2(this.motionY, (double) f1) * 180.0D / Math.PI); this.rotationPitch - this.prevRotationPitch < -180.0F; this.prevRotationPitch -= 360.0F)
        {
            ;
        }

        while (this.rotationPitch - this.prevRotationPitch >= 180.0F)
        {
            this.prevRotationPitch += 360.0F;
        }

        while (this.rotationYaw - this.prevRotationYaw < -180.0F)
        {
            this.prevRotationYaw -= 360.0F;
        }

        while (this.rotationYaw - this.prevRotationYaw >= 180.0F)
        {
            this.prevRotationYaw += 360.0F;
        }

        this.rotationPitch = this.prevRotationPitch + (this.rotationPitch - this.prevRotationPitch) * 0.2F;
        this.rotationYaw = this.prevRotationYaw + (this.rotationYaw - this.prevRotationYaw) * 0.2F;
        float f2 = 0.99F;
        float f3 = this.getGravityVelocity();

        if (this.isInWater())
        {
            for (int i = 0; i < 4; ++i)
            {
                float f4 = 0.25F;
                this.worldObj.spawnParticle("bubble", this.posX - this.motionX * (double) f4, this.posY - this.motionY * (double) f4, this.posZ - this.motionZ * (double) f4, this.motionX, this.motionY, this.motionZ);
            }

            f2 = 0.8F;
        }

        this.motionX *= (double) f2;
        this.motionY *= (double) f2;
        this.motionZ *= (double) f2;
        this.motionY -= (double) f3;
        this.setPosition(this.posX, this.posY, this.posZ);
    }


    protected float getGravityVelocity()
    {
        return 0.03F;
    }

    /**
     * Called when this EntityThrowable hits a block or entity.
     */
    protected abstract void onImpact(MovingObjectPosition p_70184_1_);

    @Override
    public void writeEntityToNBT(NBTTagCompound p_70014_1_)
    {
        p_70014_1_.setShort("xTile", (short) this.blockX);
        p_70014_1_.setShort("yTile", (short) this.blockY);
        p_70014_1_.setShort("zTile", (short) this.blockZ);
        p_70014_1_.setByte("inTile", (byte) Block.getIdFromBlock(this.cachedBlock));
        p_70014_1_.setByte("inGround", (byte) (this.inGround ? 1 : 0));

        if ((this.throwerName == null || this.throwerName.length() == 0) && this.thrower != null && this.thrower instanceof EntityPlayer)
        {
            this.throwerName = this.thrower.getCommandSenderName();
        }

        p_70014_1_.setString("ownerName", this.throwerName == null ? "" : this.throwerName);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound p_70037_1_)
    {
        this.blockX = p_70037_1_.getShort("xTile");
        this.blockY = p_70037_1_.getShort("yTile");
        this.blockZ = p_70037_1_.getShort("zTile");
        this.cachedBlock = Block.getBlockById(p_70037_1_.getByte("inTile") & 255);
        this.inGround = p_70037_1_.getByte("inGround") == 1;
        this.throwerName = p_70037_1_.getString("ownerName");

        if (this.throwerName != null && this.throwerName.length() == 0)
        {
            this.throwerName = null;
        }
    }

    @SideOnly(Side.CLIENT)
    public float getShadowSize()
    {
        return 0.0F;
    }

    public EntityLivingBase getThrower()
    {
        if (this.thrower == null && this.throwerName != null && this.throwerName.length() > 0)
        {
            this.thrower = this.worldObj.getPlayerEntityByName(this.throwerName);
        }
        return this.thrower;
    }
}
