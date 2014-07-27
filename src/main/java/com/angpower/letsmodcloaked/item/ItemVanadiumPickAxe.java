package com.angpower.letsmodcloaked.item;


import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.ForgeHooks;

import java.util.Set;

public class ItemVanadiumPickAxe extends ItemToolLMC
{
    private static final Set blocksEffectiveAgainst = Sets.newHashSet(new Block[]{Blocks.cobblestone, Blocks.double_stone_slab, Blocks.stone_slab, Blocks.stone, Blocks.sandstone, Blocks.mossy_cobblestone, Blocks.iron_ore, Blocks.iron_block, Blocks.coal_ore, Blocks.gold_block, Blocks.gold_ore, Blocks.diamond_ore, Blocks.diamond_block, Blocks.ice, Blocks.netherrack, Blocks.lapis_ore, Blocks.lapis_block, Blocks.redstone_ore, Blocks.lit_redstone_ore, Blocks.rail, Blocks.detector_rail, Blocks.golden_rail, Blocks.activator_rail});


    public ItemVanadiumPickAxe()
    {
        super(2f, ToolMaterial.EMERALD, blocksEffectiveAgainst);
        this.setUnlocalizedName("vanadium_pickaxe");
        this.setTextureName("vanadium_pickaxe");
        this.setMaxStackSize(1);
        this.setNoRepair();
    }

    @Override
    public boolean func_150897_b(Block block)
    {
        return block == Blocks.obsidian ? this.toolMaterial.getHarvestLevel() == 3 : (block != Blocks.diamond_block && block != Blocks.diamond_ore ? (block != Blocks.emerald_ore && block != Blocks.emerald_block ? (block != Blocks.gold_block && block != Blocks.gold_ore ? (block != Blocks.iron_block && block != Blocks.iron_ore ? (block != Blocks.lapis_block && block != Blocks.lapis_ore ? (block != Blocks.redstone_ore && block != Blocks.lit_redstone_ore ? (block.getMaterial() == net.minecraft.block.material.Material.rock ? true : (block.getMaterial() == net.minecraft.block.material.Material.iron ? true : block.getMaterial() == net.minecraft.block.material.Material.anvil)) : this.toolMaterial.getHarvestLevel() >= 2) : this.toolMaterial.getHarvestLevel() >= 1) : this.toolMaterial.getHarvestLevel() >= 1) : this.toolMaterial.getHarvestLevel() >= 2) : this.toolMaterial.getHarvestLevel() >= 2) : this.toolMaterial.getHarvestLevel() >= 2);
    }

    @Override
    public float func_150893_a(ItemStack itemStack, Block block)
    {
        return block.getMaterial() != net.minecraft.block.material.Material.iron && block.getMaterial() != net.minecraft.block.material.Material.anvil && block.getMaterial() != net.minecraft.block.material.Material.rock ? super.func_150893_a(itemStack, block) : this.efficiencyOnProperMaterial;
    }

    @Override
    public Set<String> getToolClasses(ItemStack itemStack)
    {
        return ImmutableSet.of("pickaxe");
    }
}
