package com.angpower.letsmodcloaked.block;


import com.angpower.letsmodcloaked.init.ModBlocks;
import com.angpower.letsmodcloaked.init.ModItems;
import net.minecraft.item.Item;

import java.util.Random;

public class BlockPeridiumOre extends BlockLMC
{
    public BlockPeridiumOre()
    {
        super();
        this.setBlockName("peridium_ore");
        this.setBlockTextureName("peridium_ore");
        this.setHardness(3F);
        this.setResistance(5F);
        this.setStepSound(soundTypeStone);
    }

    public Item getItemDropped(int i, Random random, int j)
    {
        return this == ModBlocks.peridium_ore ? ModItems.peridium : Item.getItemFromBlock(this);
    }

    public int quantityDropped(Random random)
    {
        return 3;
    }

}
