package com.scarabcoder.furniture.init;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class FurnitureTab extends CreativeTabs{

	public FurnitureTab(String label) {
		super(label);
		this.setBackgroundImageName("furniture.png");
	}

	@Override
	public Item getTabIconItem() {
		// TODO Auto-generated method stub
		return Item.getItemFromBlock(FurnitureBlocks.laptop);
	}
	
	

}
