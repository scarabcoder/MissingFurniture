package com.scarabcoder.furniture.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;

public class Monitor extends BlockFurniture {

	public Monitor(Material materialIn) {
		super(materialIn);
		
	}
	@Override
	public void func_180681_d(IBlockState state)
	{
		this.setBlockBounds(0.25F, 0F, 0.25F, 0.75F, 0.5F, 0.75F);
	}

}
