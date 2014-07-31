package com.angpower.letsmodcloaked.block;


import com.angpower.letsmodcloaked.reference.Names;

public class BlockTinOre extends BlockLMC
{
    public BlockTinOre()
    {

        super();
        this.setBlockName(Names.Blocks.TIN_ORE);
        this.setHardness(3F);
        this.setResistance(5F);
        this.setStepSound(soundTypeStone);
    }
}

