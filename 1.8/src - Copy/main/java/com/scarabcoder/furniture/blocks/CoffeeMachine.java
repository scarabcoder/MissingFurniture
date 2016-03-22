package com.scarabcoder.furniture.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CoffeeMachine extends BlockFurniture {

	public CoffeeMachine(Material materialIn) {
		super(materialIn);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void func_180681_d(IBlockState state)
	{
		this.setBlockBounds(0.0625F, 0F, 0.0625F, 0.9375F, 1F, 0.9375F);
	}

}
