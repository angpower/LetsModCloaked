package com.angpower.letsmodcloaked.init;

import com.angpower.letsmodcloaked.item.*;
import com.angpower.letsmodcloaked.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems
{

   // public static Item.ToolMaterial VanadiumMaterial = EnumHelper.addToolMaterial("VanadiumMaterial", 2, 750, 10.0F, 5.0F, 10);

    // create instance of the item
    public static final ItemLMC mapleleaf = new ItemMapleLeaf();
    public static final ItemLMC tin_cog = new ItemTinCog();

    //ingots
    public static final ItemLMC copper_ingot = new ItemCopperIngot();
    public static final ItemLMC vanadium_ingot = new ItemVanadiumIngot();
    public static final ItemLMC tin_ingot = new ItemTinIngot();
    public static final ItemLMC manganese_ingot = new ItemManganeseIngot();

    //tools
    public static final ItemToolLMC vanadium_pickaxe = new ItemVanadiumPickAxe();

    public static final ItemToolLMC vanadium_shovel = new ItemVanadiumShovel();
    public static final ItemToolLMC vanadium_axe = new ItemVanadiumAxe();
    public static final ItemVanadiumHoe vanadium_hoe = new ItemVanadiumHoe();

    public static final ItemVanadiumSword vanadium_sword = new ItemVanadiumSword();

    //armor
    public static final ItemLMC vanadium_helmet = new ItemVanadiumHelmet();
    public static final ItemLMC vanadium_chestplate = new ItemVanadiumChestPlate();
    public static final ItemLMC vanadium_leggings = new ItemVanadiumLeggings();
    public static final ItemLMC vanadium_boots = new ItemVanadiumBoots();

    public static final ItemLMC peridium = new ItemPeridium();
    public static final ItemLMC rhodium = new ItemRhodium();

    public static void init()

    {
        //register items

        GameRegistry.registerItem(mapleleaf, "mapleleaf");
        GameRegistry.registerItem(tin_cog, "tin_cog");

        //ingots
        GameRegistry.registerItem(copper_ingot, "copper_ingot");
        GameRegistry.registerItem(vanadium_ingot, "vanadium_ingot");
        GameRegistry.registerItem(tin_ingot, "tin_ingot");
        GameRegistry.registerItem(manganese_ingot, "manganese_ingot");

        //tools
        GameRegistry.registerItem(vanadium_pickaxe, "vanadium_pickaxe");
        GameRegistry.registerItem(vanadium_shovel, "vanadium_shovel");
        GameRegistry.registerItem(vanadium_axe, "vanadium_axe");
        GameRegistry.registerItem(vanadium_hoe, "vanadium_hoe");
        GameRegistry.registerItem(vanadium_sword, "vanadium_sword");

        //armor
        GameRegistry.registerItem(vanadium_helmet, "vanadium_helmet");
        GameRegistry.registerItem(vanadium_chestplate, "vanadium_chestplate");
        GameRegistry.registerItem(vanadium_leggings, "vanadium_leggings");
        GameRegistry.registerItem(vanadium_boots, "vanadium_boots");

        GameRegistry.registerItem(peridium, "peridium");
        GameRegistry.registerItem(rhodium, "rhodium");
    }
}
