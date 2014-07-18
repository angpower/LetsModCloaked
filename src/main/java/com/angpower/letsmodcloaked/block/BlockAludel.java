package com.angpower.letsmodcloaked.block;


import com.angpower.letsmodcloaked.reference.RenderIds;


public class BlockAludel extends BlockLMC
{
    public BlockAludel()
    {
        super();
        //this.setBlockName(Names.Blocks.ALUDEL);
        this.setBlockName("aludel");
        //name used for texture
       // this.setBlockTextureName("flag");
        // hardness 0 easy to break
        this.setHardness(1.5F);
        // Resistance 0 easy to explode / 6000000.0F dont explode
        this.setResistance(10F);
        // let it be a torch 0 - 15 float
        this.setBlockBounds(0.10F, 0.0F, 0.10F, 0.90F, 1.0F, 0.90F);

    }

    @Override
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    @Override
    public int getRenderType()
    {
        return RenderIds.aludel;
    }

    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }

}
