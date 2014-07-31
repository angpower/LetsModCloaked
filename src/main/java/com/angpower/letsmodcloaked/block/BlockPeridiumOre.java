package com.angpower.letsmodcloaked.block;


import com.angpower.letsmodcloaked.init.ModBlocks;
import com.angpower.letsmodcloaked.init.ModItems;
import com.angpower.letsmodcloaked.reference.Names;
import net.minecraft.item.Item;

import java.util.Random;

public class BlockPeridiumOre extends BlockLMC
{
    public BlockPeridiumOre()
    {
        super();
        this.setBlockName(Names.Blocks.PERIDIUM_ORE);
        this.setHardness(3F);
        this.setResistance(5F);
        this.setStepSound(soundTypeStone);
    }

    public Item getItemDropped(int i, Random random, int j)
    {
        //when broken what does it drop
        return this == ModBlocks.peridium_ore ? ModItems.peridium : Item.getItemFromBlock(this);
    }

    public int quantityDropped(Random random)
    {
        //how much get droped after breaking
        return 3;
    }

}
