package com.angpower.letsmodcloaked;

import com.angpower.letsmodcloaked.handler.ConfigurationHandler;
import com.angpower.letsmodcloaked.handler.CraftingHandler;
import com.angpower.letsmodcloaked.handler.FuelHandler;
import com.angpower.letsmodcloaked.handler.GuiHandler;
import com.angpower.letsmodcloaked.init.ModBlocks;
import com.angpower.letsmodcloaked.init.ModItems;
import com.angpower.letsmodcloaked.init.Recipes;
import com.angpower.letsmodcloaked.network.PacketHandler;
import com.angpower.letsmodcloaked.proxy.IProxy;
import com.angpower.letsmodcloaked.reference.Reference;
import com.angpower.letsmodcloaked.util.LogHelper;
import com.angpower.letsmodcloaked.world.gen.LMCBaseWorldGenerator;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid= Reference.MOD_ID, name= Reference.MOD_NAME, version= Reference.VERSION, guiFactory = Reference.GUI_FACTORY_CLASS)
public class LetsModCloaked
{
    @Mod.Instance(Reference.MOD_ID)
    public static LetsModCloaked instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static IProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        //network handling
        ConfigurationHandler.init(event.getSuggestedConfigurationFile());

        PacketHandler.init();

        proxy.registerKeybindings();
        //initialize items
        ModItems.init();
        //initialize blocks
        ModBlocks.init();
        LogHelper.info("Pre Initialization Compleet!");
    }

    @Mod.EventHandler
    public void Init(FMLInitializationEvent event)

    {
        // Register the GUI Handler
        NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());

        //register tile entities
        proxy.registerTileEntities();

        // Initialize custom rendering and pre-load textures (Client only)
        proxy.initRenderingAndTextures();

        //register crafting recipes
        //FMLCommonHandler.instance().bus().register(new CraftingHandler());

        // Register the Items Event Handler
        proxy.registerEventHandlers();

        //new register crafting recipes
        CraftingHandler.init();

        // register Recipes
        Recipes.init();

       // register our fuels
        GameRegistry.registerFuelHandler(new FuelHandler());
        // register our World gen
        GameRegistry.registerWorldGenerator(new LMCBaseWorldGenerator(), 0);

        LogHelper.info("Initialization Compleet!");
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)

    {
        // wrap things up
        LogHelper.info("Post Initialization Compleet!");
    }
}

