package com.angpower.letsmodcloaked.init;

import com.angpower.letsmodcloaked.item.*;
import com.angpower.letsmodcloaked.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems
{
    // create instance of the item
    public static final ItemLMC mapleleaf = new ItemMapleLeaf();
    public static final ItemLMC copper_ingot = new ItemCopperIngot();
    public static final ItemLMC vanadium_ingot = new ItemVanadiumIngot();
    public static final ItemLMC tin_ingot = new ItemTinIngot();
    public static final ItemLMC manganese_ingot = new ItemManganeseIngot();
    public static final ItemLMC vanadium_pickaxe = new ItemVanadiumPickAxe();
    public static final ItemLMC tin_cog = new ItemTinCog();
    public static final ItemLMC peridium = new ItemPeridium();
    public static final ItemLMC rhodium = new ItemRhodium();

    public static void init()

    {
        //register items

        GameRegistry.registerItem(mapleleaf, "mapleleaf");
        GameRegistry.registerItem(copper_ingot, "copper_ingot");
        GameRegistry.registerItem(vanadium_ingot, "vanadium_ingot");
        GameRegistry.registerItem(tin_ingot, "tin_ingot");
        GameRegistry.registerItem(manganese_ingot, "manganese_ingot");
        GameRegistry.registerItem(vanadium_pickaxe, "vanadium_pickaxe");
        GameRegistry.registerItem(tin_cog, "tin_cog");
        GameRegistry.registerItem(peridium, "peridium");
        GameRegistry.registerItem(rhodium, "rhodium");
    }
}
