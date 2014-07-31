package com.angpower.letsmodcloaked.client.renderer.tileentity;

import com.angpower.letsmodcloaked.client.renderer.model.ModelAludel;
import com.angpower.letsmodcloaked.reference.Textures;
import com.angpower.letsmodcloaked.tileentity.TileEntityAludel;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class TileEntityRendererAludel extends TileEntitySpecialRenderer {

    private final ModelAludel modelAludel = new ModelAludel();
    private final RenderItem customRenderItem;

    public TileEntityRendererAludel() {

        customRenderItem = new RenderItem()
        {
            @Override
            public boolean shouldBob()
            {
                //don't no what it does
                return false;
            }
        };

        customRenderItem.setRenderManager(RenderManager.instance);
    }

    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float tick) {
        if (tileEntity instanceof TileEntityAludel)
        {
            TileEntityAludel tileEntityAludel = (TileEntityAludel) tileEntity;

            GL11.glPushMatrix();

            // Scale, Translate, Rotate
            scaleTranslateRotate(x, y, z, tileEntityAludel.getOrientation());

            // Bind texture
            this.bindTexture(Textures.Model.ALUDEL);

            // Render
            modelAludel.render();

            GL11.glPopMatrix();

        }
    }

    private void scaleTranslateRotate(double x, double y, double z, ForgeDirection orientation)
    {
        if (orientation == ForgeDirection.NORTH)
        {
            GL11.glTranslated(x + 1, y, z);
            GL11.glRotatef(180F, 0F, 1F, 0F);
            GL11.glRotatef(-90F, 1F, 0F, 0F);
        }
        else if (orientation == ForgeDirection.EAST)
        {
            GL11.glTranslated(x + 1, y, z + 1);
            GL11.glRotatef(90F, 0F, 1F, 0F);
            GL11.glRotatef(-90F, 1F, 0F, 0F);
        }
        else if (orientation == ForgeDirection.SOUTH)
        {
            GL11.glTranslated(x, y, z + 1);
            GL11.glRotatef(0F, 0F, 1F, 0F);
            GL11.glRotatef(-90F, 1F, 0F, 0F);
        }
        else if (orientation == ForgeDirection.WEST)
        {
            GL11.glTranslated(x, y, z);
            GL11.glRotatef(-90F, 0F, 1F, 0F);
            GL11.glRotatef(-90F, 1F, 0F, 0F);
        }
    }
}