package com.angpower.letsmodcloaked.block;


import com.angpower.letsmodcloaked.reference.Names;

public class BlockVanadiumOre extends BlockLMC
{
    public BlockVanadiumOre()
    {
        super();
        this.setBlockName(Names.Blocks.VANADIUM_ORE);
        this.setHardness(3F);
        this.setResistance(5F);
        this.setStepSound(soundTypeStone);
    }
}
