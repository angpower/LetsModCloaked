package com.angpower.letsmodcloaked.block;


import com.angpower.letsmodcloaked.reference.Names;

public class BlockCopperOre extends BlockLMC
{
    public BlockCopperOre()
    {
        super();
        this.setBlockName(Names.Blocks.COPPER_ORE);
        this.setHardness(3F);
        this.setResistance(5F);
        this.setStepSound(soundTypeStone);
    }
}
