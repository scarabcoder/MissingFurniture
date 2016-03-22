package com.scarabcoder.furniture.blocks;

import com.scarabcoder.furniture.MissingFurniture;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;

public class DPrinter extends BlockFurniture {

	public DPrinter(Material materialIn) {
		super(materialIn);
		this.setCreativeTab(MissingFurniture.tab);
	}
	@Override
	public void func_180681_d(IBlockState state)
	{
		this.setBlockBounds(0.0625F, 0F, 0.0625F, 0.9375F, 0.75F, 0.9375F);
	}

}
