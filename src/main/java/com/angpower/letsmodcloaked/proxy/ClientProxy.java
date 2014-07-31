package com.angpower.letsmodcloaked.proxy;

import com.angpower.letsmodcloaked.client.renderer.item.ItemRendererAludel;
import com.angpower.letsmodcloaked.client.renderer.tileentity.TileEntityRendererAludel;
import com.angpower.letsmodcloaked.client.renderer.tileentity.TileEntityRendererObsidianTable;
import com.angpower.letsmodcloaked.init.ModBlocks;
import com.angpower.letsmodcloaked.reference.RenderIds;
import com.angpower.letsmodcloaked.tileentity.TileEntityAludel;
import com.angpower.letsmodcloaked.tileentity.TileEntityObsidianTable;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy
{

    @Override
    public void registerEventHandlers()
    {
        super.registerEventHandlers();
        //FMLCommonHandler.instance().bus().register(new KeyInputEventHandler());
        //MinecraftForge.EVENT_BUS.register(new ItemTooltipEventHandler());
        //MinecraftForge.EVENT_BUS.register(new DrawBlockHighlightEventHandler());
    }

    @Override
    public void registerKeybindings()
    {
       // ClientRegistry.registerKeyBinding(Keybindings.charge);
       // ClientRegistry.registerKeyBinding(Keybindings.extra);
       // ClientRegistry.registerKeyBinding(Keybindings.release);
       // ClientRegistry.registerKeyBinding(Keybindings.toggle);
    }

    @Override
    public void playSound(String soundName, float xCoord, float yCoord, float zCoord, float volume, float pitch)
    {
        //ClientSoundHelper.playSound(soundName, xCoord, yCoord, zCoord, volume, pitch);
    }

    @Override
    public void initRenderingAndTextures()
    {

        RenderIds.aludel = RenderingRegistry.getNextAvailableRenderId();
        RenderIds.obsidian_table = RenderingRegistry.getNextAvailableRenderId();



        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.aludel), new ItemRendererAludel());
        //MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.obsidian_table), new ItemRendererObsidianTable());



        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAludel.class, new TileEntityRendererAludel());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityObsidianTable.class, new TileEntityRendererObsidianTable());

    }
}
