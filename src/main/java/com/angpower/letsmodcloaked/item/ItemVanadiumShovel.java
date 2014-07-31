package com.angpower.letsmodcloaked.item;

import com.angpower.letsmodcloaked.reference.Names;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

import java.util.Set;

public class ItemVanadiumShovel extends ItemToolLMC
{
    private static final Set blocksEffectiveAgainst = Sets.newHashSet(new Block[]{Blocks.grass, Blocks.dirt, Blocks.sand, Blocks.gravel, Blocks.snow_layer, Blocks.snow, Blocks.clay, Blocks.farmland, Blocks.soul_sand, Blocks.mycelium});

    public ItemVanadiumShovel()
    {
        super(1.0f, ToolMaterial.EMERALD, blocksEffectiveAgainst);
        this.setUnlocalizedName(Names.Tools.VANADIUM_SHOVEL);
        this.setTextureName("vanadium_shovel");
        this.setMaxStackSize(1);
        this.setNoRepair();
    }

    @Override
    public Set<String> getToolClasses(ItemStack itemStack)
    {
        return ImmutableSet.of("shovel");
    }

}
