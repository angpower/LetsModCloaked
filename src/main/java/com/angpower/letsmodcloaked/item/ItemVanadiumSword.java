package com.angpower.letsmodcloaked.item;

import com.angpower.letsmodcloaked.creativetab.CreativeTabLMC;
import com.angpower.letsmodcloaked.reference.Material;
import com.angpower.letsmodcloaked.reference.Names;
import com.angpower.letsmodcloaked.reference.Reference;
import com.angpower.letsmodcloaked.reference.Textures;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;


public class ItemVanadiumSword extends ItemSword
{

    public ItemVanadiumSword()
    {
        super(Material.Tools.VANADIUM);
        this.setCreativeTab(CreativeTabLMC.LMC_TAB);
        this.setUnlocalizedName(Names.Weapons.VANADIUM_SWORD);
        this.setMaxStackSize(1);
        this.setNoRepair();
    }

    @Override
    public String getUnlocalizedName()
    {
        return String.format("item.%s%s", Textures.RESOURCE_PREFIX, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack)
    {
        return String.format("item.%s%s", Textures.RESOURCE_PREFIX, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
        //item.modid:itemname.name
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister)
    {
        itemIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
    }




    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }
}

