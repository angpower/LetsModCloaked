package com.angpower.letsmodcloaked.handler;

import com.angpower.letsmodcloaked.client.gui.inventory.GuiAlabasterOven;
import com.angpower.letsmodcloaked.inventory.ContainerAlabasterOven;
import com.angpower.letsmodcloaked.reference.GuiId;
import com.angpower.letsmodcloaked.tileentity.TileEntityAlabasterOven;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler
{
        @Override
        public Object getServerGuiElement(int id, EntityPlayer entityPlayer, World world, int x, int y, int z) {
            if (id == GuiId.ALABASTEROVEN.ordinal()) {
                TileEntityAlabasterOven tileEntityAlabasterOven = (TileEntityAlabasterOven) world.getTileEntity(x, y, z);
                return new ContainerAlabasterOven(entityPlayer.inventory, tileEntityAlabasterOven);
            /*
            } else if (id == GuiId.GLASS_BELL.ordinal()) {
                TileEntityGlassBell tileEntityGlassBell = (TileEntityGlassBell) world.getTileEntity(x, y, z);
                return new ContainerGlassBell(entityPlayer.inventory, tileEntityGlassBell);
            */
            }
            return null;
        }

        @Override
        public Object getClientGuiElement(int id, EntityPlayer entityPlayer, World world, int x, int y, int z)
        {
            if (id == GuiId.ALABASTEROVEN.ordinal()) {
                TileEntityAlabasterOven tileEntityAlabasterOven = (TileEntityAlabasterOven) world.getTileEntity(x, y, z);
                return new GuiAlabasterOven(entityPlayer.inventory, tileEntityAlabasterOven);
            /*
            } else if (id == GuiId.GLASS_BELL.ordinal()) {
                TileEntityGlassBell tileEntityGlassBell = (TileEntityGlassBell) world.getTileEntity(x, y, z);
                return new GuiGlassBell(entityPlayer.inventory, tileEntityGlassBell);
            */
            }
            return null;
        }
}
