package com.angpower.letsmodcloaked.init;

import com.angpower.letsmodcloaked.block.*;
import com.angpower.letsmodcloaked.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)

public class ModBlocks
{
    // ---- create instance of the blocks -------

    //ore's
    public static final BlockLMC copper_ore = new BlockCopperOre();
    public static final BlockLMC tin_ore = new BlockTinOre();
    public static final BlockLMC manganese_ore = new BlockManganeseOre();
    public static final BlockLMC vanadium_ore = new BlockVanadiumOre();
    public static final BlockLMC rhodium_ore = new BlockRhodiumOre();
    public static final BlockLMC peridium_ore = new BlockPeridiumOre();

    // Deco blocks
    public static final BlockLMC aludel = new BlockAludel();
    public static final BlockLMC bomb = new BlockBomb();
    public static final BlockLMC copper_block = new BlockCopperBlock();

    // tile entity's
    public static final BlockLMC stonefurnace = new BlockStoneFurnace();


    public static void init()

    {
        //---------------- register the Blocks -------------

        //ore's
        GameRegistry.registerBlock(copper_ore, "copper_ore");
        GameRegistry.registerBlock(tin_ore, "tin_ore");
        GameRegistry.registerBlock(manganese_ore, "manganese_ore");
        GameRegistry.registerBlock(vanadium_ore, "vanadium_ore");
        GameRegistry.registerBlock(rhodium_ore, "rhodium_ore");
        GameRegistry.registerBlock(peridium_ore, "peridium_ore");

        //Deco blocks

        GameRegistry.registerBlock(bomb, "bomb");
        GameRegistry.registerBlock(copper_block, "copper_block");

        //tile entity's
        GameRegistry.registerBlock(aludel, "Aludel");
        GameRegistry.registerBlock(stonefurnace, "stonefurnace");

    }
}
