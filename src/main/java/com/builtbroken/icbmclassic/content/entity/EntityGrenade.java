package com.builtbroken.icbmclassic.content.entity;

import com.builtbroken.mc.lib.helper.LanguageUtility;
import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

/**
 * Created by Philipp on 26.07.2015.
 */
public class EntityGrenade extends EntityThrowable{
    private double explosionRadius = 1.0F;
    private double relVelocity = 0.75;
    private EntityLivingBase player;
    private int lifespan;

    public EntityGrenade(World par1World) {
        super(par1World);
    }

    public EntityGrenade(World par1World, double arg1Double, double arg2Double, double arg3Double) {
        super(par1World, arg1Double, arg2Double, arg3Double);
    }

    public EntityGrenade(World par1World, EntityLivingBase arg1EntityLivingBase, int duration) {
        super(par1World, arg1EntityLivingBase);
        //slows down the grenade depending on a maximum throw force and velocity of the Player.
        double x = arg1EntityLivingBase.getLookVec().xCoord * relVelocity + arg1EntityLivingBase.motionX;
        double y = arg1EntityLivingBase.getLookVec().yCoord * relVelocity + arg1EntityLivingBase.motionY;
        double z = arg1EntityLivingBase.getLookVec().zCoord * relVelocity + arg1EntityLivingBase.motionZ;
        this.setVelocity(x, y, z);
        this.lifespan = duration;
        this.player = arg1EntityLivingBase;

        /*
        int entityID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(EntityGrenade.class, "EntityGrenade", entityID);
        EntityRegistry.registerModEntity(EntityGrenade.class, "EntityGrenade", entityID, this, 64, 1, true);
        */
    }

    public void onUpdate(){
        if(!this.worldObj.isRemote){
            this.lifespan --;
            if(this.lifespan <= 0){
                this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, (float) this.explosionRadius, true);
                this.setDead();
            }
        }
        super.onUpdate();
    }

    public void onImpact(MovingObjectPosition mop){
        double x = this.motionX;
        double y = this.motionY;
        double z = this.motionZ;

            if (mop.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {

                switch (mop.sideHit) {
                    case 0: //BOTTOM
                        this.setVelocity(0.75*x, -0.1 * y, 0.75*z);
                        break;
                    case 1: //TOP
                        this.setVelocity(0.75*x, -0.1 * y, 0.75*z);
                        break;
                    case 2: //EAST
                        this.setVelocity(0.75*x, 0.75*y, -0.1 * z);
                        break;
                    case 3: //WEST
                        this.setVelocity(0.75*x, 0.75*y, -0.1 * z);
                        break;
                    case 4: //NORTH
                        this.setVelocity(-0.1 * x, 0.75*y, 0.75*z);
                        break;
                    case 5: //SOUTH
                        this.setVelocity(-0.1 * x, 0.75*y, 0.75*z);
                        break;
                }
            }
    }
}
