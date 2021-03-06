package com.angpower.letsmodcloaked.network.message;

import com.angpower.letsmodcloaked.tileentity.TileEntityLMC;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.tileentity.TileEntity;

public class MessageTileEntityLMC implements IMessage, IMessageHandler<MessageTileEntityLMC, IMessage>
{
    public int x, y, z;
    public byte orientation, state;
    public String customName, owner;

    public MessageTileEntityLMC()
    {
    }

    public MessageTileEntityLMC(TileEntityLMC tileEntityLMC)
    {
        this.x = tileEntityLMC.xCoord;
        this.y = tileEntityLMC.yCoord;
        this.z = tileEntityLMC.zCoord;
        this.orientation = (byte) tileEntityLMC.getOrientation().ordinal();
        this.state = (byte) tileEntityLMC.getState();
        this.customName = tileEntityLMC.getCustomName();
        this.owner = tileEntityLMC.getOwner();
    }

    @Override
    public void fromBytes(ByteBuf buf)
    {
        this.x = buf.readInt();
        this.y = buf.readInt();
        this.z = buf.readInt();
        this.orientation = buf.readByte();
        this.state = buf.readByte();
        int customNameLength = buf.readInt();
        this.customName = new String(buf.readBytes(customNameLength).array());
        int ownerLength = buf.readInt();
        this.owner = new String(buf.readBytes(ownerLength).array());
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
        buf.writeInt(x);
        buf.writeInt(y);
        buf.writeInt(z);
        buf.writeByte(orientation);
        buf.writeByte(state);
        buf.writeInt(customName.length());
        buf.writeBytes(customName.getBytes());
        buf.writeInt(owner.length());
        buf.writeBytes(owner.getBytes());
    }

    @Override
    public IMessage onMessage(MessageTileEntityLMC message, MessageContext ctx)
    {
        TileEntity tileEntity = FMLClientHandler.instance().getClient().theWorld.getTileEntity(message.x, message.y, message.z);

        if (tileEntity instanceof TileEntityLMC)
        {
            ((TileEntityLMC) tileEntity).setOrientation(message.orientation);
            ((TileEntityLMC) tileEntity).setState(message.state);
            ((TileEntityLMC) tileEntity).setCustomName(message.customName);
            ((TileEntityLMC) tileEntity).setOwner(message.owner);
        }

        return null;
    }

    @Override
    public String toString()
    {
        return String.format("MessageTileEntityEE - x:%s, y:%s, z:%s, orientation:%s, state:%s, customName:%s, owner:%s", x, y, z, orientation, state, customName, owner);
    }
}