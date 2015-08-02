package com.builtbroken.icbmclassic.content.grenade;

import com.builtbroken.icbmclassic.content.Assets;
import com.builtbroken.mc.api.explosive.ICustomGrenadeRenderer;
import com.builtbroken.mc.api.explosive.IExplosiveHandler;
import com.builtbroken.mc.api.explosive.IGrenadeEntity;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;


@SideOnly(Side.CLIENT)
public class RenderGrenade extends Render
{
    @Override
    public void doRender(Entity entity, double xx, double yy, double zz, float p_76986_8_, float p_76986_9_)
    {
        GL11.glPushMatrix();
        GL11.glTranslatef((float) xx, (float) yy, (float) zz);
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        
        //Grabs a custom renderer for the explosive contained within the grenade
        if (entity instanceof IGrenadeEntity)
        {
            IExplosiveHandler ex = ((IGrenadeEntity) entity).getExplosive();
            if (ex instanceof ICustomGrenadeRenderer && ((ICustomGrenadeRenderer) ex).shouldHandleGrenadeRenderer(entity))
            {
                ((ICustomGrenadeRenderer) ex).renderGrenade(entity, xx, yy, zz);
            }
            else
            {
                renderDefault(entity, xx, yy, zz, p_76986_8_, p_76986_9_);
            }
        }
        else
        {
            renderDefault(entity, xx, yy, zz, p_76986_8_, p_76986_9_);
        }
        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        GL11.glPopMatrix();
    }

    //Default renderer for the grenade entity
    private void renderDefault(Entity entity, double xx, double yy, double zz, float p_76986_8_, float p_76986_9_)
    {
        this.bindEntityTexture(entity);
        GL11.glTranslatef(0, .15f, 0);
        GL11.glScalef(0.3F, 0.3F, 0.3F);
        Assets.GRENADE_MODEL.renderAll();
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity)
    {
        //TODO replace with actual texture
        return com.builtbroken.icbm.content.Assets.GREY_FAKE_TEXTURE;
    }
}
