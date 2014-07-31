package com.angpower.letsmodcloaked.client.gui.inventory;

import com.angpower.letsmodcloaked.inventory.ContainerAlabasterOven;
import com.angpower.letsmodcloaked.reference.Names;
import com.angpower.letsmodcloaked.reference.Textures;
import com.angpower.letsmodcloaked.tileentity.TileEntityAlabasterOven;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class GuiAlabasterOven extends GuiContainer
{
    private TileEntityAlabasterOven tileEntityAlabasterOven;

    public GuiAlabasterOven(InventoryPlayer inventoryPlayer, TileEntityAlabasterOven tileEntityAlabasterOven)
    {
        super(new ContainerAlabasterOven(inventoryPlayer, tileEntityAlabasterOven));
        this.tileEntityAlabasterOven = tileEntityAlabasterOven;
        xSize = 176;
        ySize = 166;

    }

    @Override
    protected void drawGuiContainerForegroundLayer(int x, int y)
    {
        String containerName = StatCollector.translateToLocal(tileEntityAlabasterOven.getInventoryName());
        //draw the container name from ySize / 2 - the name / 2 and 6 from the top , and the white color
        fontRendererObj.drawString(containerName, xSize / 2 - fontRendererObj.getStringWidth(containerName) / 2, 6, 4210752);
        //draw the Inventory name 120 from the left to the center, ySize - 96 = 70 + 2 from the top , and the White color
        fontRendererObj.drawString(StatCollector.translateToLocal(Names.Containers.VANILLA_INVENTORY), 120, ySize - 96 + 2, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float opacity, int x, int y)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

        this.mc.getTextureManager().bindTexture(Textures.Gui.ALABASTER_OVEN);

        int xStart = (width - xSize) / 2;
        int yStart = (height - ySize) / 2;
        this.drawTexturedModalRect(xStart, yStart, 0, 0, xSize, ySize);
        int scaleAdjustment;

       // if (this.tileEntityAlabasterOven.getState() == 1)
            if (this.tileEntityAlabasterOven.isBurning())
        {
            scaleAdjustment = this.tileEntityAlabasterOven.getBurnTimeRemainingScaled(40);
            // this will make it reverse
            int j = 40 - scaleAdjustment;
            // lets the fuel bar go from empty to full
            this.drawTexturedModalRect(xStart + 29, yStart + 65, 176, 0, 40 - j, 10);
        }

        scaleAdjustment = this.tileEntityAlabasterOven.getCookProgressScaled(24);
        this.drawTexturedModalRect(xStart + 79, yStart + 34, 176, 10, scaleAdjustment + 1, 16);

    }

} // end of class

