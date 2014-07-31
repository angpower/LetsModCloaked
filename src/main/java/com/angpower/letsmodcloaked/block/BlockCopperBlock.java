package com.angpower.letsmodcloaked.block;


import com.angpower.letsmodcloaked.reference.Names;
import net.minecraft.block.material.Material;

public class BlockCopperBlock extends BlockLMC
{
    public BlockCopperBlock()
    {
        super();
        this.setBlockName(Names.Blocks.COPPER_BLOCK);
        this.setHardness(1.5F);
        this.setResistance(10F);
    }
}
