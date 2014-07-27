package com.angpower.letsmodcloaked.handler;

import com.angpower.letsmodcloaked.init.ModItems;
import cpw.mods.fml.common.IFuelHandler;
import net.minecraft.item.ItemStack;


public class FuelHandler implements IFuelHandler
{

    @Override
    public int getBurnTime(ItemStack fuel) {

        if (fuel.getItem() == ModItems.peridium) return 800;

        return 0;
    }
}
