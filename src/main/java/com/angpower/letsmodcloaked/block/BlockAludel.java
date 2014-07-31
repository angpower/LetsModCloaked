package com.angpower.letsmodcloaked.block;

import com.angpower.letsmodcloaked.LetsModCloaked;
import com.angpower.letsmodcloaked.init.ModBlocks;
import com.angpower.letsmodcloaked.reference.Names;
import com.angpower.letsmodcloaked.reference.RenderIds;
import com.angpower.letsmodcloaked.tileentity.TileEntityAludel;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;


public class BlockAludel extends BlockLMC implements ITileEntityProvider
{
    public BlockAludel()
    {
        super();
        //name used for texture
        this.setBlockName(Names.Blocks.ALUDEL);
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

    @Override
    public TileEntity createNewTileEntity(World world, int metadata) {
        return new TileEntityAludel();
    }
}
