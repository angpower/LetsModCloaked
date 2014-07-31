package com.angpower.letsmodcloaked.client.renderer.tileentity;


import com.angpower.letsmodcloaked.models.ObsidianTable;
import com.angpower.letsmodcloaked.reference.Textures;
import com.angpower.letsmodcloaked.tileentity.TileEntityObsidianTable;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class TileEntityRendererObsidianTable extends TileEntitySpecialRenderer
{

    private ObsidianTable model;

    public TileEntityRendererObsidianTable() {
        this.model = new ObsidianTable();
    }

    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float tick) {
        if (tileEntity instanceof TileEntityObsidianTable) {
            TileEntityObsidianTable tileEntityObsidianTable = (TileEntityObsidianTable) tileEntity;


            GL11.glPushMatrix();
            // Scale, Translate, Rotate
            //GL11.glTranslatef((float)x +0.5F, (float)y +0.5F, (float)z +0.5F);
            GL11.glRotatef(90, 0f, 0f, 1f);
            GL11.glScalef(0.1F, 0.1F, 0.1F);
            scaleTranslateRotate(x, y, z, tileEntityObsidianTable.getOrientation());

            // Bind texture
            this.bindTexture(Textures.Model.OBSIDIAN_TABLE);
            GL11.glPushMatrix();
            this.model.renderModel(0.625F);
            GL11.glPopMatrix();
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