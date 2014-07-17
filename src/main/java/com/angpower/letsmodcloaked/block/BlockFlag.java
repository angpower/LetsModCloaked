package com.angpower.letsmodcloaked.block;


import net.minecraft.creativetab.CreativeTabs;

public class BlockFlag extends BlockLMC
{
    public BlockFlag()
    {
        super();
        this.setBlockName("flag");
        //name used for texture
        this.setBlockTextureName("flag");
        // hardness 0 easy to break
        //this.setCreativeTab(CreativeTabs.tabMisc);
        this.setHardness(1.5F);
        // Resistance 0 easy to explode / 6000000.0F dont explode
        this.setResistance(10F);
        // let it be a torch 0 - 15 float
        this.setLightLevel(1.0F);
    }
}
