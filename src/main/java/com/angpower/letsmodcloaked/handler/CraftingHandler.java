package com.angpower.letsmodcloaked.handler;


import com.angpower.letsmodcloaked.init.ModItems;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

public class CraftingHandler
{

    public static void init()
    {

    }

    @SubscribeEvent
    public void onCrafting(PlayerEvent.ItemCraftedEvent event)
    {
        final IInventory craftMatrix = null;
        for(int i = 0; i < event.craftMatrix.getSizeInventory(); i++)
        {
            if(event.craftMatrix.getStackInSlot(i) != null)
            {
                ItemStack item0 = event.craftMatrix.getStackInSlot(i);
                if(item0 != null && item0.getItem() == ModItems.mapleleaf)
                {
                    ItemStack k = new ItemStack(ModItems.mapleleaf, 2, (item0.getItemDamage() + 1));
                    if (k.getItemDamage() >= k.getMaxDamage())
                    {
                        k.stackSize--;
                    }

                    event.craftMatrix.setInventorySlotContents(i,k);
                }
            }
        }
    }
}
