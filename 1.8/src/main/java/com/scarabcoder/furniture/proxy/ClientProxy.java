package com.scarabcoder.furniture.proxy;

import com.scarabcoder.furniture.init.FurnitureBlocks;
import com.scarabcoder.furniture.init.FurnitureItems;

public class ClientProxy extends CommonProxy{
	@Override
	public void registerRenders(){
		FurnitureItems.registerRenders();
		FurnitureBlocks.registerRenders();
		
	}
}
