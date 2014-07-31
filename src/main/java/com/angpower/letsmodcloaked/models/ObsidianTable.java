
package com.angpower.letsmodcloaked.models;



import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ObsidianTable extends ModelBase
{
  //fields
    ModelRenderer tabletop;
    ModelRenderer legfour;
    ModelRenderer legtree;
    ModelRenderer legtwo;
    ModelRenderer legone;
  
  public ObsidianTable()
  {
    textureWidth = 64;
    textureHeight = 64;
    
      tabletop = new ModelRenderer(this, 0, 0);
      tabletop.addBox(0F, 0F, 0F, 16, 3, 16);
      tabletop.setRotationPoint(-8F, 11F, -8F);
      tabletop.setTextureSize(64, 32);
      tabletop.mirror = true;
      setRotation(tabletop, 0F, 0F, 0F);
      legfour = new ModelRenderer(this, 32, 19);
      legfour.addBox(0F, 0F, 0F, 4, 10, 4);
      legfour.setRotationPoint(4F, 14F, 4F);
      legfour.setTextureSize(64, 32);
      legfour.mirror = true;
      setRotation(legfour, 0F, 0F, 0F);
      legtree = new ModelRenderer(this, 48, 19);
      legtree.addBox(0F, 0F, 0F, 4, 10, 4);
      legtree.setRotationPoint(4F, 14F, -8F);
      legtree.setTextureSize(64, 32);
      legtree.mirror = true;
      setRotation(legtree, 0F, 0F, 0F);
      legtwo = new ModelRenderer(this, 16, 19);
      legtwo.addBox(0F, 0F, 0F, 4, 10, 4);
      legtwo.setRotationPoint(-8F, 14F, -8F);
      legtwo.setTextureSize(64, 32);
      legtwo.mirror = true;
      setRotation(legtwo, 0F, 0F, 0F);
      legone = new ModelRenderer(this, 0, 19);
      legone.addBox(0F, 0F, 0F, 4, 10, 4);
      legone.setRotationPoint(-8F, 14F, 4F);
      legone.setTextureSize(64, 32);
      legone.mirror = true;
      setRotation(legone, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    tabletop.render(f5);
    legfour.render(f5);
    legtree.render(f5);
    legtwo.render(f5);
    legone.render(f5);
  }

    public void renderModel(float f)
    {
        tabletop.render(f);
        legfour.render(f);
        legtree.render(f);
        legtwo.render(f);
        legone.render(f);
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
