package com.angpower.letsmodcloaked.block;


import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class BlockStoneFurnace extends BlockLMC
{
    //setup the variable for the IIcons
    @SideOnly(Side.CLIENT)
    private IIcon iconFront;
    @SideOnly(Side.CLIENT)
    private IIcon iconTop;

    public BlockStoneFurnace()
    {
        super();
        this.setBlockName("stonefurnace");
        this.setBlockTextureName("stonefurnace");
        this.setHardness(1.5F);
        this.setResistance(10F);
        this.setStepSound(Block.soundTypeStone);
    }

    //register the IIcons with a variable

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister par1IconRegister) {
        this.iconFront = par1IconRegister.registerIcon("LetsModCloaked:stonefurnace_front_off");
        //this.iconFront = par1IconRegister.registerIcon(this.isActive ? "LetsModCloaked:stonefurnace_front_on" : "LetsModCloaked:stonefurnace_front_off");
        this.blockIcon = par1IconRegister.registerIcon("LetsModCloaked:stonefurnace_side");
        this.iconTop = par1IconRegister.registerIcon("LetsModCloaked:stonefurnace_top");
    }

    //put all the textures on the right side

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int metadata)
    {
        return metadata == 0 && side == 3 ? this.iconFront : side == 1 ? this.iconTop : (side == 0 ? this.iconTop : (side == metadata ? this.iconFront : this.blockIcon));
    }
}
