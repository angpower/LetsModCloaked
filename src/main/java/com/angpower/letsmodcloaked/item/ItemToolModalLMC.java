package com.angpower.letsmodcloaked.item;

import com.angpower.letsmodcloaked.reference.Names;
import com.angpower.letsmodcloaked.reference.ToolMode;
import com.angpower.letsmodcloaked.util.IModalTool;
import com.angpower.letsmodcloaked.util.NBTHelper;
import net.minecraft.item.ItemStack;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class ItemToolModalLMC extends ItemToolLMC implements IModalTool
{
    public ItemToolModalLMC(float damageVsEntity, ToolMaterial toolMaterial, Set blocksEffectiveAgainst)
    {
        super(damageVsEntity, toolMaterial, blocksEffectiveAgainst);
    }

    @Override
    public List<ToolMode> getAvailableToolModes()
    {
        return Arrays.asList(ToolMode.UNKNOWN);
    }

    @Override
    public ToolMode getCurrentToolMode(ItemStack itemStack)
    {
        if (NBTHelper.getShort(itemStack, Names.NBT.MODE) < ToolMode.TYPES.length)
        {
            return ToolMode.TYPES[NBTHelper.getShort(itemStack, Names.NBT.MODE)];
        }

        return ToolMode.UNKNOWN;
    }

    @Override
    public void setToolMode(ItemStack itemStack, ToolMode toolMode)
    {
        NBTHelper.setShort(itemStack, Names.NBT.MODE, (short) toolMode.ordinal());
    }

    @Override
    public void changeToolMode(ItemStack itemStack)
    {
        ToolMode currentToolMode = getCurrentToolMode(itemStack);

        if (getAvailableToolModes().size() > 0)
        {
            if (getAvailableToolModes().contains(currentToolMode))
            {
                if (getAvailableToolModes().indexOf(currentToolMode) == getAvailableToolModes().size() - 1)
                {
                    setToolMode(itemStack, getAvailableToolModes().get(0));
                }
                else
                {
                    setToolMode(itemStack, getAvailableToolModes().get(getAvailableToolModes().indexOf(currentToolMode) + 1));
                }
            }
            else
            {
                setToolMode(itemStack, getAvailableToolModes().get(0));
            }
        }
        else
        {
            setToolMode(itemStack, ToolMode.UNKNOWN);
        }
    }
}
