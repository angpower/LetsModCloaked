package com.angpower.letsmodcloaked.util;

import com.angpower.letsmodcloaked.reference.ToolMode;
import net.minecraft.item.ItemStack;

import java.util.List;

public interface IModalTool
{
    public abstract List<ToolMode> getAvailableToolModes();

    public abstract ToolMode getCurrentToolMode(ItemStack itemStack);

    public abstract void setToolMode(ItemStack itemStack, ToolMode toolMode);

    public abstract void changeToolMode(ItemStack itemStack);
}
