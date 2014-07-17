package com.angpower.letsmodcloaked.network;

import com.angpower.letsmodcloaked.network.message.MessageTileEntityLMC;
import com.angpower.letsmodcloaked.reference.Reference;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

public class PacketHandler
{
    public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MOD_ID.toLowerCase());

    public static void init()
    {
        INSTANCE.registerMessage(MessageTileEntityLMC.class, MessageTileEntityLMC.class, 0, Side.CLIENT);
        //INSTANCE.registerMessage(MessageTileCalcinator.class, MessageTileCalcinator.class, 1, Side.CLIENT);
       // INSTANCE.registerMessage(MessageTileEntityAludel.class, MessageTileEntityAludel.class, 2, Side.CLIENT);
       // INSTANCE.registerMessage(MessageTileEntityGlassBell.class, MessageTileEntityGlassBell.class, 3, Side.CLIENT);
       // INSTANCE.registerMessage(MessageKeyPressed.class, MessageKeyPressed.class, 4, Side.SERVER);
    }
}
