package com.scarabcoder.furniture.init;

import com.scarabcoder.furniture.MissingFurniture;
import com.scarabcoder.furniture.blocks.BlockFurniture;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;

public class Laptop extends BlockFurniture {

	public Laptop(Material materialIn) {
		super(materialIn);
		this.setCreativeTab(MissingFurniture.tab);
	}
	@Override
	public void func_180681_d(IBlockState state)
	{
		this.setBlockBounds(0.0625F, 0F, 0.0625F, 0.9375F, 0.5625F, 0.9375F);
	}

}
