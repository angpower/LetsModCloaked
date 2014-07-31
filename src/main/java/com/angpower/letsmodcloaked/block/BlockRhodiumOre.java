package com.angpower.letsmodcloaked.block;


import com.angpower.letsmodcloaked.reference.Names;

public class BlockRhodiumOre extends BlockLMC
{
    public BlockRhodiumOre()
    {
        super();
        this.setBlockName(Names.Blocks.RHODIUM_ORE);
        this.setHardness(3F);
        this.setResistance(5F);
        this.setStepSound(soundTypeStone);
    }
}
