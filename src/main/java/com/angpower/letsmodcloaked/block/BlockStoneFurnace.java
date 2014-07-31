package com.angpower.letsmodcloaked.block;


import com.angpower.letsmodcloaked.reference.Names;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockStoneFurnace extends BlockLMC
{
    //setup the variable for the IIcons

    private IIcon textureTop;
    private IIcon textureBottom;
    private IIcon textureSide;
    private IIcon textureFront;

    public BlockStoneFurnace()
    {
        super();
        this.setBlockName(Names.Blocks.STONE_FURNACE);
        this.setHardness(1.5F);
        this.setResistance(10F);
        this.setStepSound(soundTypeStone);
    }

    /*
    @Override
    public TileEntity createNewTileEntity(World world, int metaData)
    {
        return new TileEntity();
    }
    */

    //register the IIcons with a variable
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister par1IconRegister) {
        textureTop = par1IconRegister.registerIcon("LetsModCloaked:machine_top");
        textureBottom = par1IconRegister.registerIcon("LetsModCloaked:machine_bottom");
        textureSide = par1IconRegister.registerIcon("LetsModCloaked:machine_side");
        textureFront = par1IconRegister.registerIcon("LetsModCloaked:machine_front");

    }

    //put all the textures on the right side
    // 0 = bottom  // 1 = top  // 2 = left side  // 3 = front  // 4 = right side  // 5 = back
    // int side , int metadata
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int i, int j)
    {
        if (j == 0 && i == 3) {
            return textureFront;
        }

        if (i == j && i > 1) {
            return textureFront;
        }

        switch (i) {
            case 1:
                return textureTop;
            default:
                return textureSide;
        }
    }

    @Override
    public void onBlockAdded(World world, int x, int y, int z)
    {
        super.onBlockAdded(world, x, y, z);
        this.setDefaultDirection(world, x, y, z);
    }

    private void setDefaultDirection(World world, int x, int y, int z) {
        if (!world.isRemote) {
            Block block1 = world.getBlock(x, y, z - 1);
            Block block2 = world.getBlock(x, y, z + 1);
            Block block3 = world.getBlock(x - 1, y, z);
            Block block4 = world.getBlock(x + 1, y, z);
            byte b0 = 3;

            if (block1.func_149730_j() && !block2.func_149730_j()) {
                b0 = 3;
            }
            if (block2.func_149730_j() && !block1.func_149730_j()) {
                b0 = 2;
            }
            if (block3.func_149730_j() && !block4.func_149730_j()) {
                b0 = 5;
            }
            if (block4.func_149730_j() && !block3.func_149730_j()) {
                b0 = 4;
            }

            world.setBlockMetadataWithNotify(x, y, z, b0, 2);
        }
    }
        //set the block facing direction
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLivingBase, ItemStack itemstack)
    {
        int l = MathHelper.floor_double((double) (entityLivingBase.rotationYaw * 4.0F / 360.0F) + 0.50) & 3;

        if(l == 0){
            world.setBlockMetadataWithNotify(x, y, z, 2, 2);
        }
        if(l == 1){
            world.setBlockMetadataWithNotify(x, y, z, 5, 2);
        }
        if(l == 2){
            world.setBlockMetadataWithNotify(x, y, z, 3, 2);
        }
        if(l == 3){
            world.setBlockMetadataWithNotify(x, y, z, 4, 2);
        }
    }
} //end of class
