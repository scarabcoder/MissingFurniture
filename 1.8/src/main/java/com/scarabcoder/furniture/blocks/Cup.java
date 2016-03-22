package com.scarabcoder.furniture.blocks;

import com.scarabcoder.furniture.MissingFurniture;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;

public class Cup extends BlockFurniture {

	public Cup(Material materialIn) {
		super(materialIn);
		this.setCreativeTab(MissingFurniture.tab);
	}
	@Override
	public void func_180681_d(IBlockState state)
	{
		this.setBlockBounds(0.375F, 0F, 0.375F, 0.625F, 0.25F, 0.625F);
	}

}
