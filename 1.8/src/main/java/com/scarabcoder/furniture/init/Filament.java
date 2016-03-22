package com.scarabcoder.furniture.init;

import com.scarabcoder.furniture.MissingFurniture;
import com.scarabcoder.furniture.blocks.BlockFurniture;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;

public class Filament extends BlockFurniture {

	public Filament(Material materialIn) {
		super(materialIn);
		this.setCreativeTab(MissingFurniture.tab);
	}
	@Override
	public void func_180681_d(IBlockState state)
	{
		this.setBlockBounds(3/16F, 0F, 3/16F, 12/16F, 12/16F, 12/16F);
	}

}
