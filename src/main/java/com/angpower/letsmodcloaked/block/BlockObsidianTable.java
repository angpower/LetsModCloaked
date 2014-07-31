package com.angpower.letsmodcloaked.block;

import com.angpower.letsmodcloaked.reference.Names;
import com.angpower.letsmodcloaked.reference.RenderIds;
import com.angpower.letsmodcloaked.tileentity.TileEntityObsidianTable;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockObsidianTable extends BlockLMC implements ITileEntityProvider
{
    public BlockObsidianTable()
    {
        super();
        this.setBlockName(Names.Blocks.OBSIDIAN_TABLE);
        this.setResistance(12.0F);
        this.setHardness(4.0F);
    }

    @Override
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    @Override
    public int getRenderType()
    {
        return RenderIds.obsidian_table;
    }

    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }


    @Override
    public TileEntity createNewTileEntity(World var1, int var2) {
        return new TileEntityObsidianTable();
    }
}
