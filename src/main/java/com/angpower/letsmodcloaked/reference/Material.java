package com.angpower.letsmodcloaked.reference;

import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;

public class Material
{
    public static final class Tools
    {
        public static final Item.ToolMaterial VANADIUM = EnumHelper.addToolMaterial(Names.Materials.VANADIUM, 3, 2700, 14f, 5.0f, 0);
    }

    public static final class Armor
    {
        public static final ItemArmor.ArmorMaterial VANADIUM = EnumHelper.addArmorMaterial(Names.Materials.VANADIUM, 0, new int[]{3, 8, 6, 3}, 0);
    }
}




