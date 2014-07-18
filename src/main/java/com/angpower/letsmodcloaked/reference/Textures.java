package com.angpower.letsmodcloaked.reference;

import com.angpower.letsmodcloaked.utility.ResourceLocationHelper;
import net.minecraft.util.ResourceLocation;

public class Textures
{
    public static final String RESOURCE_PREFIX = Reference.MOD_ID.toLowerCase() + ":";

    public static final class Armor
    {
        private static final String ARMOR_SHEET_LOCATION = "textures/armor/";
    }

    public static final class Model
    {
        private static final String MODEL_TEXTURE_LOCATION = "textures/models/";
        public static final ResourceLocation ALUDEL = ResourceLocationHelper.getResourceLocation(MODEL_TEXTURE_LOCATION + "aludel.png");
    }

    public static final class Gui
    {
        private static final String GUI_SHEET_LOCATION = "textures/gui/";

        //public static final ResourceLocation ALUDEL = ResourceLocationHelper.getResourceLocation(GUI_SHEET_LOCATION + "aludel.png");
        //public static final ResourceLocation PORTABLE_CRAFTING = new ResourceLocation("textures/gui/container/crafting_table.png");
    }

    public static final class Effect
    {
        private static final String EFFECTS_LOCATION = "textures/effects/";
       // public static final ResourceLocation WORLD_TRANSMUTATION = ResourceLocationHelper.getResourceLocation(EFFECTS_LOCATION + "noise.png");
    }
}
