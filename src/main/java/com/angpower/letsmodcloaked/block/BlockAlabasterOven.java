package com.angpower.letsmodcloaked.block;


import com.angpower.letsmodcloaked.LetsModCloaked;
import com.angpower.letsmodcloaked.init.ModBlocks;
import com.angpower.letsmodcloaked.reference.GuiId;
import com.angpower.letsmodcloaked.reference.Names;
import com.angpower.letsmodcloaked.tileentity.TileEntityAlabasterOven;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import java.util.Random;


public class BlockAlabasterOven extends BlockLMC implements ITileEntityProvider
{

    public final boolean isActive;

    @SideOnly(Side.CLIENT)
        private IIcon iconFront;
    @SideOnly(Side.CLIENT)
        private IIcon iconTop;

    private static boolean keepInventory;
    private Random rand = new Random();

    public BlockAlabasterOven(boolean isActive)
    {
        //the material when breaking
        super(Material.iron);
        //name used for texture
        this.setBlockName(Names.Blocks.ALABASTER_OVEN);
        // hardness 0 easy to break
        this.setHardness(2F);
        // Resistance 0 easy to explode / 6000000.0F don't explode
        this.setResistance(10F);
        // sound when step on and placed or broken
        this.setStepSound(soundTypeMetal);
        this.isActive = isActive;
    }


    @Override
    public TileEntity createNewTileEntity(World world, int metaData)
    {
        return new TileEntityAlabasterOven();
    }



    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
    {
        if (player.isSneaking())
        {
            return false;
        }
        else
        {
            if (!world.isRemote)
            {
                if (world.getTileEntity(x, y, z) instanceof TileEntityAlabasterOven)
                {
                    player.openGui(LetsModCloaked.instance, GuiId.ALABASTEROVEN.ordinal(), world, x, y, z);
                }
            }

            return true;
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister par1IconRegister) {
        this.iconFront = par1IconRegister.registerIcon(this.isActive ? "LetsModCloaked:stone_furnace_front_on" : "LetsModCloaked:stone_furnace_front_off");
        this.blockIcon = par1IconRegister.registerIcon("LetsModCloaked:stone_furnace_side");
        this.iconTop = par1IconRegister.registerIcon("LetsModCloaked:stone_furnace_top");
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int metadata)
    {
        // 0 = bottom  // 1 = top  // 2 = left side  // 3 = front  // 4 = right side  // 5 = back
        return metadata == 0 && side == 3 ? this.iconFront : side == 1 ? this.iconTop : (side == 0 ? this.iconTop : (side == metadata ? this.iconFront : this.blockIcon));
    }

    public Item getItemDropped(int i, Random random, int j)
    {
        return Item.getItemFromBlock(ModBlocks.alabaster_oven);
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

    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World world, int x, int y, int z, Random random){
        if(this.isActive) {
            int direction = world.getBlockMetadata(x, y, z);

            float x1 = (float)x + 0.5F;
            float y1 = (float)y + random.nextFloat();
            float z1 = (float)z + 0.5F;

            float f = 0.52F;
            float f1 = random.nextFloat() * 0.6F - 0.3F;

            if(direction == 4){
                world.spawnParticle("smoke", (double)(x1 - f),(double)(y1),(double)(z1 + f1), 0D, 0D, 0D);
                world.spawnParticle("flame", (double)(x1 - f),(double)(y1),(double)(z1 + f1), 0D, 0D, 0D);
            }
            if(direction == 5){
                world.spawnParticle("smoke", (double)(x1 + f),(double)(y1),(double)(z1 + f1), 0D, 0D, 0D);
                world.spawnParticle("flame", (double)(x1 + f),(double)(y1),(double)(z1 + f1), 0D, 0D, 0D);
            }
            if(direction == 2){
                world.spawnParticle("smoke", (double)(x1 + f1),(double)(y1),(double)(z1 - f), 0D, 0D, 0D);
                world.spawnParticle("flame", (double)(x1 + f1),(double)(y1),(double)(z1 - f), 0D, 0D, 0D);
            }
            if(direction == 3){
                world.spawnParticle("smoke", (double)(x1 + f1),(double)(y1),(double)(z1 + f), 0D, 0D, 0D);
                world.spawnParticle("flame", (double)(x1 + f1),(double)(y1),(double)(z1 + f), 0D, 0D, 0D);
            }
        }
    }

    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLivingBase, ItemStack itemstack)
    {
        int l = MathHelper.floor_double((double) (entityLivingBase.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

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

        if (itemstack.hasDisplayName())
        {
            ((TileEntityAlabasterOven)world.getTileEntity(x, y, z)).setGuiDisplayName(itemstack.getDisplayName());
        }
    }

    public static void updateAlabasterOvenBlockState(boolean active, World worldObj, int xCoord, int yCoord, int zCoord){
        int i = worldObj.getBlockMetadata(xCoord, yCoord, zCoord);

        TileEntity tileentity = worldObj.getTileEntity(xCoord, yCoord, zCoord);
        keepInventory = true;

        if(active) {
            worldObj.setBlock(xCoord, yCoord, zCoord, ModBlocks.alabaster_oven);
        }else{
            worldObj.setBlock(xCoord, yCoord, zCoord, ModBlocks.alabaster_oven);
        }

        keepInventory = false;

        worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, i, 2);

        if(tileentity != null )
        {
            tileentity.validate();
            worldObj.setTileEntity(xCoord, yCoord, zCoord, tileentity);
        }
    }

    public Item getItem(World world, int x, int y, int z)
    {
        return Item.getItemFromBlock(ModBlocks.alabaster_oven);
    }

}
