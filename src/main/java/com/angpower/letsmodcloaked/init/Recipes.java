package com.angpower.letsmodcloaked.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Recipes {

    public static void init()
    {
        initModRecipes();
    }

    public static void initModRecipes()
    {
        //Register Recipes
        GameRegistry.addRecipe(new ItemStack(ModBlocks.copper_block), "fff", "fff", "fff", 'f', new ItemStack(ModItems.copper_ingot));
        GameRegistry.addRecipe(new ItemStack(ModItems.vanadium_pickaxe), "iii", " s ", " s ", 'i', new ItemStack(ModItems.copper_ingot), 's', new ItemStack(Items.stick));

        //Smelting Recipes
        GameRegistry.addSmelting(new ItemStack(ModBlocks.copper_ore), new ItemStack(ModItems.copper_ingot, 1), 0);
    }
}
