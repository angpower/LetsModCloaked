package com.angpower.letsmodcloaked.item;

import com.angpower.letsmodcloaked.reference.Names;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemMapleLeaf extends  ItemLMC
{
    public ItemMapleLeaf()

    {
        super();
        // name used for texture
        this.setUnlocalizedName(Names.Items.MAPLE_LEAF);
        this.maxStackSize = 1;
        this.setMaxDamage(10);
    }

    //TO_DO when it hit maxDamage Destroy the item

    @Override
    public boolean itemInteractionForEntity (ItemStack itemStack, EntityPlayer player, EntityLivingBase target)
    {
        if (!target.worldObj.isRemote)
        {
            //launch the target in the air by amount.
            target.motionY = 2;
            //goes from zero to maxDamage by increment of + 1
            itemStack.setItemDamage(itemStack.getItemDamage() + 1);
        }
         return false;
    }

    private boolean isShown(int dmg){
        return dmg <= 0;
    }

    // show the durability bar
    @Override
    public boolean showDurabilityBar(ItemStack stack)
    {
        if(isShown(stack.getItemDamage())){
            return false;
        }else {
            return true;
        }
    }




} // end of class
