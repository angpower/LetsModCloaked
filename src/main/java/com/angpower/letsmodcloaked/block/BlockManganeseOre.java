package com.angpower.letsmodcloaked.block;

import com.angpower.letsmodcloaked.reference.Names;

public class BlockManganeseOre extends BlockLMC
{
    public BlockManganeseOre()
    {
        super();
        this.setBlockName(Names.Blocks.MANGANESE_ORE);
        this.setHardness(3F);
        this.setResistance(5F);
        this.setStepSound(soundTypeStone);
    }
}

