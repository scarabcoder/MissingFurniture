package util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class Util {
	
	public Util(){
		
	}
	
	
    public static void decreaseStack(EntityPlayer player){
    	ItemStack stack = player.getHeldItem();
    	stack.stackSize = stack.stackSize - 1;
    	if(stack.stackSize == 0){
    		player.inventory.removeStackFromSlot(player.inventory.currentItem);
    	}else{
    		player.inventory.setInventorySlotContents(player.inventory.currentItem, stack);
    	}
    }
    
    public static void print(String string){
    	System.out.println(string);
    }
}
