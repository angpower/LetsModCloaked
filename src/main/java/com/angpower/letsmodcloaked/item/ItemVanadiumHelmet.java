package com.angpower.letsmodcloaked.item;

import com.angpower.letsmodcloaked.reference.Names;

public class ItemVanadiumHelmet extends ItemLMC
{
    public ItemVanadiumHelmet()
    {
        super();
        this.setUnlocalizedName(Names.Armor.VANADIUM_HELMET);
        this.setTextureName("vanadium_helmet");
        this.setMaxStackSize(1);
        this.setNoRepair();
    }
}
