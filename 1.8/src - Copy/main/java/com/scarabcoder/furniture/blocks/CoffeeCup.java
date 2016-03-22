package com.scarabcoder.furniture.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CoffeeCup extends BlockFurniture {

	public CoffeeCup(Material materialIn) {
		super(materialIn);
		// TODO Auto-generated constructor stub
	}

	@SideOnly(Side.CLIENT)
    public EnumWorldBlockLayer getBlockLayer()
    {
        return EnumWorldBlockLayer.CUTOUT;
    }
	@Override
	public void func_180681_d(IBlockState state)
	{
		this.setBlockBounds(0.375F, 0F, 0.375F, 0.625F, 0.25F, 0.625F);
	}
}
