package com.builtbroken.icbmclassic.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/** Written By Herobrine11892 **/

public class EMPTowerModel extends ModelBase
{
  //fields
    ModelRenderer Base;
    ModelRenderer Support;
    ModelRenderer Turret_Support;
    ModelRenderer Main_Coil;
    ModelRenderer Support_Beam_A1;
    ModelRenderer Support_Beam_B1;
    ModelRenderer Support_Beam_C1;
    ModelRenderer Support_Beam_D1;
    ModelRenderer Support_Beam_DB1;
    ModelRenderer Support_Beam_CA1;
    ModelRenderer Support_Beam_CA2;
    ModelRenderer Support_Beam_DB2;
  
  public EMPTowerModel()
  {
    textureWidth = 128;
    textureHeight = 128;
    
      Base = new ModelRenderer(this, 0, 0);
      Base.addBox(0F, 0F, 0F, 16, 6, 16);
      Base.setRotationPoint(-8F, 18F, -8F);
      Base.setTextureSize(128, 128);
      Base.mirror = true;
      setRotation(Base, 0F, 0F, 0F);
      Support = new ModelRenderer(this, 0, 24);
      Support.addBox(0F, 0F, 0F, 10, 8, 10);
      Support.setRotationPoint(-5F, 10F, -5F);
      Support.setTextureSize(128, 128);
      Support.mirror = true;
      setRotation(Support, 0F, 0F, 0F);
      Turret_Support = new ModelRenderer(this, 0, 44);
      Turret_Support.addBox(-7F, 0F, -7F, 14, 1, 14);
      Turret_Support.setRotationPoint(0F, 9F, 0F);
      Turret_Support.setTextureSize(128, 128);
      Turret_Support.mirror = true;
      setRotation(Turret_Support, 0F, 0.7853982F, 0F);
      Main_Coil = new ModelRenderer(this, 66, 0);
      Main_Coil.addBox(-2F, 0F, -2F, 4, 11, 4);
      Main_Coil.setRotationPoint(0F, -5F, 0F);
      Main_Coil.setTextureSize(128, 128);
      Main_Coil.mirror = true;
      setRotation(Main_Coil, 0F, 0F, 0F);
      Support_Beam_A1 = new ModelRenderer(this, 66, 16);
      Support_Beam_A1.addBox(8F, 0F, -1F, 1, 18, 2);
      Support_Beam_A1.setRotationPoint(0F, -8F, 0F);
      Support_Beam_A1.setTextureSize(128, 128);
      Support_Beam_A1.mirror = true;
      setRotation(Support_Beam_A1, 0F, 0F, 0F);
      Support_Beam_B1 = new ModelRenderer(this, 73, 16);
      Support_Beam_B1.addBox(-1F, 0F, -9F, 2, 18, 1);
      Support_Beam_B1.setRotationPoint(0F, -8F, 0F);
      Support_Beam_B1.setTextureSize(128, 128);
      Support_Beam_B1.mirror = true;
      setRotation(Support_Beam_B1, 0F, 0F, 0F);
      Support_Beam_C1 = new ModelRenderer(this, 66, 16);
      Support_Beam_C1.addBox(-9F, 0F, -1F, 1, 18, 2);
      Support_Beam_C1.setRotationPoint(0F, -8F, 0F);
      Support_Beam_C1.setTextureSize(128, 128);
      Support_Beam_C1.mirror = true;
      setRotation(Support_Beam_C1, 0F, 0F, 0F);
      Support_Beam_D1 = new ModelRenderer(this, 73, 16);
      Support_Beam_D1.addBox(-1F, 0F, 8F, 2, 18, 1);
      Support_Beam_D1.setRotationPoint(0F, -8F, 0F);
      Support_Beam_D1.setTextureSize(128, 128);
      Support_Beam_D1.mirror = true;
      setRotation(Support_Beam_D1, 0F, 0F, 0F);
      Support_Beam_DB1 = new ModelRenderer(this, 85, 0);
      Support_Beam_DB1.addBox(-1F, 0F, -8F, 2, 1, 16);
      Support_Beam_DB1.setRotationPoint(0F, 3F, 0F);
      Support_Beam_DB1.setTextureSize(128, 128);
      Support_Beam_DB1.mirror = true;
      setRotation(Support_Beam_DB1, 0F, 0F, 0F);
      Support_Beam_CA1 = new ModelRenderer(this, 85, 19);
      Support_Beam_CA1.addBox(-8F, 0F, -1F, 16, 1, 2);
      Support_Beam_CA1.setRotationPoint(0F, 3F, 0F);
      Support_Beam_CA1.setTextureSize(128, 128);
      Support_Beam_CA1.mirror = true;
      setRotation(Support_Beam_CA1, 0F, 0F, 0F);
      Support_Beam_CA2 = new ModelRenderer(this, 85, 19);
      Support_Beam_CA2.addBox(-8F, 0F, -1F, 16, 1, 2);
      Support_Beam_CA2.setRotationPoint(0F, -3F, 0F);
      Support_Beam_CA2.setTextureSize(128, 128);
      Support_Beam_CA2.mirror = true;
      setRotation(Support_Beam_CA2, 0F, 0F, 0F);
      Support_Beam_DB2 = new ModelRenderer(this, 85, 0);
      Support_Beam_DB2.addBox(-1F, 0F, -8F, 2, 1, 16);
      Support_Beam_DB2.setRotationPoint(0F, -3F, 0F);
      Support_Beam_DB2.setTextureSize(128, 128);
      Support_Beam_DB2.mirror = true;
      setRotation(Support_Beam_DB2, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Base.render(f5);
    Support.render(f5);
    Turret_Support.render(f5);
    Main_Coil.render(f5);
    Support_Beam_A1.render(f5);
    Support_Beam_B1.render(f5);
    Support_Beam_C1.render(f5);
    Support_Beam_D1.render(f5);
    Support_Beam_DB1.render(f5);
    Support_Beam_CA1.render(f5);
    Support_Beam_CA2.render(f5);
    Support_Beam_DB2.render(f5);
  }
  
  public void renderModel(float f)
  {
	Base.render(f);
	Support.render(f);
	Turret_Support.render(f);
	Main_Coil.render(f);
	Support_Beam_A1.render(f);
	Support_Beam_B1.render(f);
	Support_Beam_C1.render(f);
	Support_Beam_D1.render(f);
	Support_Beam_DB1.render(f);
	Support_Beam_CA1.render(f);
	Support_Beam_CA2.render(f);
	Support_Beam_DB2.render(f); 
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }

}
