package com.scarabcoder.furniture.blocks;

import com.scarabcoder.furniture.MissingFurniture;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Lamp extends BlockFurniture {

	public Lamp(Material materialIn) {
		super(materialIn);
		this.setCreativeTab(MissingFurniture.tab);
		this.setLightLevel(1.0F);
	}
	@SideOnly(Side.CLIENT)
    public EnumWorldBlockLayer getBlockLayer()
    {
        return EnumWorldBlockLayer.TRANSLUCENT;
    }

	@Override
	public void func_180681_d(IBlockState state)
	{
		this.setBlockBounds(0.25F, 0.75F, 0.25F, 0.75F, 1F, 0.75F);
	}
}
