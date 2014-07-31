package com.angpower.letsmodcloaked.init;

import com.angpower.letsmodcloaked.block.*;
import com.angpower.letsmodcloaked.reference.Names;
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
    public static final BlockLMC copper_block = new BlockCopperBlock();

    // tile entity's
    public static final BlockAlabasterOven alabaster_oven = new BlockAlabasterOven(false);
    public static final BlockLMC aludel = new BlockAludel();
    public static final BlockLMC stone_furnace = new BlockStoneFurnace();
    public static final BlockLMC obsidian_table = new BlockObsidianTable();


    public static void init()

    {
        //---------------- register the Blocks -------------

        //ore's
        GameRegistry.registerBlock(copper_ore, Names.Blocks.COPPER_ORE);
        GameRegistry.registerBlock(tin_ore, Names.Blocks.TIN_ORE);
        GameRegistry.registerBlock(manganese_ore, Names.Blocks.MANGANESE_ORE);
        GameRegistry.registerBlock(vanadium_ore, Names.Blocks.VANADIUM_ORE);
        GameRegistry.registerBlock(rhodium_ore, Names.Blocks.RHODIUM_ORE);
        GameRegistry.registerBlock(peridium_ore, Names.Blocks.PERIDIUM_ORE);

        //Deco blocks
        GameRegistry.registerBlock(copper_block, Names.Blocks.COPPER_BLOCK);

        //tile entity's
        GameRegistry.registerBlock(alabaster_oven, Names.Blocks.ALABASTER_OVEN);
        GameRegistry.registerBlock(aludel, Names.Blocks.ALUDEL);
        GameRegistry.registerBlock(stone_furnace, Names.Blocks.STONE_FURNACE);
        GameRegistry.registerBlock(obsidian_table, Names.Blocks.OBSIDIAN_TABLE);

    }
}
