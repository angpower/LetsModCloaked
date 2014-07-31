package com.angpower.letsmodcloaked.item;

import com.angpower.letsmodcloaked.reference.Names;

public class ItemVanadiumChestPlate extends ItemLMC
{
    public ItemVanadiumChestPlate()
    {
        super();
        this.setUnlocalizedName(Names.Armor.VANADIUM_CHESTPLATE);
        this.setTextureName("vanadium_chestplate");
        this.setMaxStackSize(1);
        this.setNoRepair();
    }
}
