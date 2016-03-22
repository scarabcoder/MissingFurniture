package com.scarabcoder.furniture.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;

public class Desk extends BlockFurniture {

	public Desk(Material materialIn) {
		super(materialIn);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void func_180681_d(IBlockState state)
	{
		this.setBlockBounds(0F, 0.40625F, 0F, 1F, 1F, 1F);
	}

}
