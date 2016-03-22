package com.scarabcoder.furniture.blocks;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import com.scarabcoder.furniture.MissingFurniture;
import com.scarabcoder.furniture.init.FurnitureBlocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import util.Util;

public class DPrinter extends BlockFurniture {
	
	Util util = new Util();
	
	public DPrinter(Material materialIn) {
		super(materialIn);
		this.setCreativeTab(MissingFurniture.tab);
	}
	@Override
	public void func_180681_d(IBlockState state)
	{
		this.setBlockBounds(0.0625F, 0F, 0.0625F, 0.9375F, 0.75F, 0.9375F);
	}
    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ){
    	
    	if(playerIn.getHeldItem() != null){
    		if(playerIn.getHeldItem().getItem().equals(Item.getItemFromBlock(FurnitureBlocks.filament))){
    			ItemStack stack = new ItemStack(Items.skull, 1, 3);
    			if(stack.getTagCompound() == null){
    				stack.setTagCompound(new NBTTagCompound());
    			}
				try {
				 URL url = new URL("http://www.puzzlers.org/pub/wordlists/pocket.txt");
					Scanner s = new Scanner(url.openStream());
					
					String[] list = s.nextLine().split("\n");
					util.print(list[0]);
					s.close();
	    			
				} catch (MalformedURLException e) {
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    			stack.getTagCompound().setString("SkullOwner", "ScarabCoder");
    			playerIn.inventory.addItemStackToInventory(stack);
    			util.decreaseStack(playerIn);
    			return true;
    		}
    	}
    	
    	
    	return false;
    }
    
    
    
}
