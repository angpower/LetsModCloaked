package com.angpower.letsmodcloaked.client.renderer.model;

import com.angpower.letsmodcloaked.reference.Models;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;


    @SideOnly(Side.CLIENT)
     public class ModelObsidianTable
    {
        private IModelCustom ModelObsidianTable;

        public ModelObsidianTable()
        {
            ModelObsidianTable = AdvancedModelLoader.loadModel(Models.OBSIDIAN_TABLE);
        }

        public void render()
        {
            ModelObsidianTable.renderPart("base");
        }
    }

