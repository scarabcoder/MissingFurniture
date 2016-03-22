package com.scarabcoder.furniture.blocks;

import com.scarabcoder.furniture.MissingFurniture;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;

public class Microphone extends BlockFurniture {

	public Microphone(Material materialIn) {
		super(materialIn);
		this.setCreativeTab(MissingFurniture.tab);
	}

	@Override
	public void func_180681_d(IBlockState state)
	{
		this.setBlockBounds(0.3125F, 0F, 0.3125F, 0.6875F, 0.8F, 0.6875F);
	}
}
