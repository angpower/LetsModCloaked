package com.angpower.letsmodcloaked.block;

import com.angpower.letsmodcloaked.tileentity.TileEntityBomb;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;


public class BlockBomb extends BlockLMC
{
    @SideOnly(Side.CLIENT)
        private IIcon iconFront;
    @SideOnly(Side.CLIENT)
        private IIcon iconTop;

    public BlockBomb()
    {
        //the material when breaking
        super(Material.iron);
        //also for texture ?
        this.setBlockName("bomb");
        //name used for texture
        this.setBlockTextureName("bomb");
        // hardness 0 easy to break
        this.setHardness(2F);
        // Resistance 0 easy to explode / 6000000.0F don't explode
        this.setResistance(10F);
        // sound when step on
        this.setStepSound(Block.soundTypeMetal);
    }

    /*
    @Override
    public TileEntity createNewTileEntity(World world, int metaData)
    {
        return new TileEntityBomb();
    }
    */


    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int faceHit, float par7, float par8, float par9) {
        if (player.isSneaking()) {
            return false;
        }
        else{
            return true;
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister par1IconRegister) {
        this.iconFront = par1IconRegister.registerIcon("LetsModCloaked:machine_front");
        //this.iconFront = par1IconRegister.registerIcon(this.isActive ? "LetsModCloaked:machine_frontOn" : "LetsModCloaked:machine_frontOff");
        this.blockIcon = par1IconRegister.registerIcon("LetsModCloaked:machine_side");
        this.iconTop = par1IconRegister.registerIcon("LetsModCloaked:machine_top");
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int metadata)
    {
        return metadata == 0 && side == 3 ? this.iconFront : side == 1 ? this.iconTop : (side == 0 ? this.iconTop : (side == metadata ? this.iconFront : this.blockIcon));
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
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLivingBase, ItemStack itemstack)
    {
            int l = MathHelper.floor_double((double)(entityLivingBase.rotationYaw * 4.0F / 360.0F) + 0.50) & 3;

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
}
