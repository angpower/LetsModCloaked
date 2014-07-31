package com.angpower.letsmodcloaked.proxy;


import com.angpower.letsmodcloaked.handler.ConfigurationHandler;
import com.angpower.letsmodcloaked.handler.CraftingHandler;
import com.angpower.letsmodcloaked.reference.Names;
import com.angpower.letsmodcloaked.tileentity.TileEntityAlabasterOven;
import com.angpower.letsmodcloaked.tileentity.TileEntityAludel;
import com.angpower.letsmodcloaked.tileentity.TileEntityObsidianTable;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraftforge.common.MinecraftForge;

public  abstract class CommonProxy implements IProxy
{
    public void registerEventHandlers()
    {
        //ItemEventHandler itemEventHandler = new ItemEventHandler();
        CraftingHandler craftingHandler = new CraftingHandler();

        FMLCommonHandler.instance().bus().register(new ConfigurationHandler());
       // FMLCommonHandler.instance().bus().register(itemEventHandler);
       // MinecraftForge.EVENT_BUS.register(itemEventHandler);
       // MinecraftForge.EVENT_BUS.register(new WorldEventHandler());
       // MinecraftForge.EVENT_BUS.register(new PlayerEventHandler());
        FMLCommonHandler.instance().bus().register(craftingHandler);
        MinecraftForge.EVENT_BUS.register(craftingHandler);
    }
    public void registerTileEntities()
    {
        //------- register Tile Entity's --------------//
        GameRegistry.registerTileEntity(TileEntityAlabasterOven.class, Names.Blocks.ALABASTER_OVEN);
        GameRegistry.registerTileEntity(TileEntityObsidianTable.class, Names.Blocks.OBSIDIAN_TABLE);
        GameRegistry.registerTileEntityWithAlternatives(TileEntityAludel.class, Names.Blocks.ALUDEL, "tile." + Names.Blocks.ALUDEL);
    }

}
