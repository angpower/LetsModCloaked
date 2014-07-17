package com.angpower.letsmodcloaked.creativetab;

import com.angpower.letsmodcloaked.init.ModItems;
import com.angpower.letsmodcloaked.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.StatCollector;

public class CreativeTabLMC
{
    public static final CreativeTabs LMC_TAB = new CreativeTabs(Reference.MOD_ID.toLowerCase())
    {
        @Override
        public Item getTabIconItem()
        {
            return ModItems.mapleleaf;
        }

        /*
        @Override
        @SideOnly(Side.CLIENT)
        public String getTranslatedTabLabel()
        {
            return StatCollector.translateToLocal(Reference.MOD_NAME);
        }
        */

    };
}
