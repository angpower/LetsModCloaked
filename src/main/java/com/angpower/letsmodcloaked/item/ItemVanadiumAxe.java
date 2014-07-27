package com.angpower.letsmodcloaked.item;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;

import java.util.Set;

public class ItemVanadiumAxe extends ItemToolLMC
{
    private static final Set blocksEffectiveAgainst = Sets.newHashSet(new Block[]{Blocks.planks, Blocks.bookshelf, Blocks.log, Blocks.log2, Blocks.chest, Blocks.pumpkin, Blocks.lit_pumpkin});

    public ItemVanadiumAxe()
    {
        super(3.0f, ToolMaterial.EMERALD, blocksEffectiveAgainst);
        this.setUnlocalizedName("vanadium_axe");
        this.setTextureName("vanadium_axe");
        this.setMaxStackSize(1);
        this.setNoRepair();
    }

    @Override
    public Set<String> getToolClasses(ItemStack itemStack)
    {
        return ImmutableSet.of("axe");
    }


}
