package com.angpower.letsmodcloaked.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class Recipes {

    public static void init()
    {
        initModRecipes();
    }

    public static void initModRecipes()
    {
        //Register Recipes
        GameRegistry.addRecipe(new ItemStack(ModBlocks.copper_block), "fff", "fff", "fff", 'f', new ItemStack(ModItems.copper_ingot));
        GameRegistry.addRecipe(new ItemStack(ModItems.vanadium_pickaxe), "iii", " s ", " s ", 'i', new ItemStack(ModItems.vanadium_ingot), 's', new ItemStack(Items.stick));
        GameRegistry.addRecipe(new ItemStack(ModItems.tin_cog), " i ", "ifi", " i ", 'i', new ItemStack(ModItems.tin_ingot), 'f', new ItemStack(Items.flint));

        GameRegistry.addRecipe(new ItemStack(ModItems.tin_cog), "fi ", "   ", "   ", 'i', new ItemStack(ModItems.tin_ingot), 'f', new ItemStack(ModItems.mapleleaf, 1, OreDictionary.WILDCARD_VALUE));

        //Shapeless Recipes
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.copper_ingot, 9, 0), new ItemStack(ModBlocks.copper_block, 1, 0));

        //Smelting Recipes
        GameRegistry.addSmelting(new ItemStack(ModBlocks.copper_ore), new ItemStack(ModItems.copper_ingot, 1), 0);
        GameRegistry.addSmelting(new ItemStack(ModBlocks.vanadium_ore), new ItemStack(ModItems.vanadium_ingot, 1), 0);
        GameRegistry.addSmelting(new ItemStack(ModBlocks.tin_ore), new ItemStack(ModItems.tin_ingot, 1), 0);
        GameRegistry.addSmelting(new ItemStack(ModBlocks.manganese_ore), new ItemStack(ModItems.manganese_ingot, 1), 0);

    }
}
