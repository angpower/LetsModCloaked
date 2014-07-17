package com.angpower.letsmodcloaked;

import com.angpower.letsmodcloaked.handler.ConfigurationHandler;
import com.angpower.letsmodcloaked.init.ModBlocks;
import com.angpower.letsmodcloaked.init.ModItems;
import com.angpower.letsmodcloaked.init.Recipes;
import com.angpower.letsmodcloaked.proxy.IProxy;
import com.angpower.letsmodcloaked.reference.Reference;
import com.angpower.letsmodcloaked.utility.LogHelper;
import com.angpower.letsmodcloaked.world.gen.LMCBaseWorldGenerator;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
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
        FMLCommonHandler.instance().bus().register(new ConfigurationHandler());
        //initialize items
        ModItems.init();
        //initialize blocks
        ModBlocks.init();
        LogHelper.info("Pre Initialization Compleet!");
    }

    @Mod.EventHandler
    public void Init(FMLInitializationEvent event)

    {
        //register gui
        //register tile entities

        //register crafting recipes
        Recipes.init();
        //general event handling
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

