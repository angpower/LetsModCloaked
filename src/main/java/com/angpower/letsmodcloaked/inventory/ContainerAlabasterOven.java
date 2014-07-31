package com.angpower.letsmodcloaked.inventory;

import com.angpower.letsmodcloaked.tileentity.TileEntityAlabasterOven;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;

public class ContainerAlabasterOven extends ContainerLMC
{

    private TileEntityAlabasterOven alabasterOven;

    public int lastburnTime;
    public int lastCurrentItemBurnTime;
    public int lastCookTime;

    public ContainerAlabasterOven(InventoryPlayer inventory, TileEntityAlabasterOven tileEntity)
    {
        this.alabasterOven = tileEntity;

        // slot for container ,slot number, xPos, yPos
        this.addSlotToContainer(new Slot(tileEntity, 0, 56, 35));
        this.addSlotToContainer(new Slot(tileEntity, 1, 8, 62));
        this.addSlotToContainer(new SlotFurnace(inventory.player, tileEntity, 2, 116, 35));

/*
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 9; j++) {
                this.addSlotToContainer(new Slot(inventory, j + i*9, 8 + j*18, 84 + i*18));
            }
        }

        for(int i = 0; i < 9; i++){
            this.addSlotToContainer(new Slot(inventory, i, 8 + i * 18, 142));
        }

*/
        // Add the player's inventory slots to the container
        for (int inventoryRowIndex = 0; inventoryRowIndex < PLAYER_INVENTORY_ROWS; ++inventoryRowIndex)
        {
            for (int inventoryColumnIndex = 0; inventoryColumnIndex < PLAYER_INVENTORY_COLUMNS; ++inventoryColumnIndex)
            {
                this.addSlotToContainer(new Slot(inventory, inventoryColumnIndex + inventoryRowIndex * 9 + 9, 8 + inventoryColumnIndex * 18, 84 + inventoryRowIndex * 18));
            }
        }

        // Add the player's action bar slots to the container
        for (int actionBarSlotIndex = 0; actionBarSlotIndex < 9; ++actionBarSlotIndex)
        {
            this.addSlotToContainer(new Slot(inventory, actionBarSlotIndex, 8 + actionBarSlotIndex * 18, 142));
        }
    }

    public void addCraftingToCrafters (ICrafting iCrafting){
        super.addCraftingToCrafters(iCrafting);
        iCrafting.sendProgressBarUpdate(this, 0, this.alabasterOven.cookTime);
        iCrafting.sendProgressBarUpdate(this, 1, this.alabasterOven.burnTime);
        iCrafting.sendProgressBarUpdate(this, 2, this.alabasterOven.currentItemBurnTime);
    }

    public void detectAndSendChanges()
    {
        super.detectAndSendChanges();

        //for(int i = 0; i < this.crafters.size(); i++){
        for (Object crafter : this.crafters){
            ICrafting iCrafting = (ICrafting) crafter;
            //ICrafting iCrafting = (ICrafting) this.crafters.get(i);

            if(this.lastCookTime != this.alabasterOven.cookTime){
                iCrafting.sendProgressBarUpdate(this, 0, this.alabasterOven.cookTime);
            }

            if(this.lastburnTime != this.alabasterOven.burnTime){
                iCrafting.sendProgressBarUpdate(this, 1, this.alabasterOven.burnTime);
            }

            if(this.lastCurrentItemBurnTime != this.alabasterOven.currentItemBurnTime){
                iCrafting.sendProgressBarUpdate(this, 2, this.alabasterOven.currentItemBurnTime);
            }
        }

        this.lastCookTime = this.alabasterOven.cookTime;
        this.lastburnTime = this.alabasterOven.burnTime;
        this.lastCurrentItemBurnTime = this.alabasterOven.currentItemBurnTime;
    }

    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int par1, int par2)
    {
        if(par1 == 0){
            this.alabasterOven.cookTime = par2;
        }
        if(par1 == 1){
            this.alabasterOven.burnTime = par2;
        }
        if(par1 == 2){
            this.alabasterOven.currentItemBurnTime = par2;
        }

    }

    public ItemStack transferStackInSlot(EntityPlayer player, int slotIndex)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(slotIndex);

        if (slot != null && slot.getHasStack())
        {
            ItemStack slotStack = slot.getStack();
            itemstack = slotStack.copy();

            if (slotIndex == 2)
            {
                if (!this.mergeItemStack(slotStack, 3, 39, true))
                {
                    return null;
                }

                slot.onSlotChange(slotStack, itemstack);
            }
            else if (slotIndex != 1 && slotIndex != 0)
            {
                if (FurnaceRecipes.smelting().getSmeltingResult(slotStack) != null)
                {
                    if (!this.mergeItemStack(slotStack, 0, 1, false))
                    {
                        return null;
                    }
                }
                else if (TileEntityAlabasterOven.isItemFuel(slotStack))
                {
                    if (!this.mergeItemStack(slotStack, 1, 2, false))
                    {
                        return null;
                    }
                }
                else if (slotIndex >= 3 && slotIndex < 30)
                {
                    if (!this.mergeItemStack(slotStack, 30, 39, false))
                    {
                        return null;
                    }
                }
                else if (slotIndex >= 30 && slotIndex < 39 && !this.mergeItemStack(slotStack, 3, 30, false))
                {
                    return null;
                }
            }
            else if (!this.mergeItemStack(slotStack, 3, 39, false))
            {
                return null;
            }

            if (slotStack.stackSize == 0)
            {
                slot.putStack((ItemStack)null);
            }
            else{
                slot.onSlotChanged();
            }

            if (slotStack.stackSize == itemstack.stackSize)
            {
                return null;
            }

            slot.onPickupFromSlot(player, slotStack);
        }

        return itemstack;
    }
}


