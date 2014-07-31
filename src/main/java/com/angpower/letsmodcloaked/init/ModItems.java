package com.angpower.letsmodcloaked.init;

import com.angpower.letsmodcloaked.item.*;
import com.angpower.letsmodcloaked.reference.Names;
import com.angpower.letsmodcloaked.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems
{

    // create instance of the item
    public static final ItemLMC mapleleaf = new ItemMapleLeaf();
    public static final ItemLMC tin_cog = new ItemTinCog();
    public static final ItemLMC peridium = new ItemPeridium();
    public static final ItemLMC rhodium = new ItemRhodium();

    // Ingots
    public static final ItemLMC copper_ingot = new ItemCopperIngot();
    public static final ItemLMC vanadium_ingot = new ItemVanadiumIngot();
    public static final ItemLMC tin_ingot = new ItemTinIngot();
    public static final ItemLMC manganese_ingot = new ItemManganeseIngot();
    public static final ItemLMC rainbow_ingot = new ItemRainbowIngot();

    // Tools
    public static final ItemToolLMC vanadium_pickaxe = new ItemVanadiumPickAxe();
    public static final ItemToolLMC vanadium_shovel = new ItemVanadiumShovel();
    public static final ItemToolLMC vanadium_axe = new ItemVanadiumAxe();
    public static final ItemVanadiumHoe vanadium_hoe = new ItemVanadiumHoe();

    // Weapons
    public static final ItemVanadiumSword vanadium_sword = new ItemVanadiumSword();

    // Armor
    public static final ItemLMC vanadium_helmet = new ItemVanadiumHelmet();
    public static final ItemLMC vanadium_chestplate = new ItemVanadiumChestPlate();
    public static final ItemLMC vanadium_leggings = new ItemVanadiumLeggings();
    public static final ItemLMC vanadium_boots = new ItemVanadiumBoots();



    public static void init()

    {
        //register items
        GameRegistry.registerItem(mapleleaf, Names.Items.MAPLE_LEAF);
        GameRegistry.registerItem(tin_cog, Names.Items.TIN_COG);
        GameRegistry.registerItem(peridium, Names.Items.PERIDIUM);
        GameRegistry.registerItem(rhodium, Names.Items.RHODIUM);


        // Ingots
        GameRegistry.registerItem(copper_ingot, Names.Items.COPPER_INGOT);
        GameRegistry.registerItem(vanadium_ingot, Names.Items.VANADIUM_INGOT);
        GameRegistry.registerItem(tin_ingot, Names.Items.TIN_INGOT);
        GameRegistry.registerItem(manganese_ingot, Names.Items.MANGANESE_INGOT);
        GameRegistry.registerItem(rainbow_ingot, Names.Items.RAINBOW_INGOT);

        // Tools
        GameRegistry.registerItem(vanadium_pickaxe, Names.Tools.VANADIUM_PICKAXE);
        GameRegistry.registerItem(vanadium_shovel, Names.Tools.VANADIUM_SHOVEL);
        GameRegistry.registerItem(vanadium_axe, Names.Tools.VANADIUM_AXE);
        GameRegistry.registerItem(vanadium_hoe, Names.Tools.VANADIUM_HOE);

        // Weapons
        GameRegistry.registerItem(vanadium_sword, Names.Weapons.VANADIUM_SWORD);

        // Armor
        GameRegistry.registerItem(vanadium_helmet, Names.Armor.VANADIUM_HELMET);
        GameRegistry.registerItem(vanadium_chestplate, Names.Armor.VANADIUM_CHESTPLATE);
        GameRegistry.registerItem(vanadium_leggings, Names.Armor.VANADIUM_LEGGINGS);
        GameRegistry.registerItem(vanadium_boots, Names.Armor.VANADIUM_BOOTS);

    }
}
