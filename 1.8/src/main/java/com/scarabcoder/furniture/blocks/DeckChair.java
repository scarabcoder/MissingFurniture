package com.scarabcoder.furniture.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import util.SittingUtil;

public class DeckChair extends BlockFurniture{
	
	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	
	public DeckChair(Material materialIn) {
		super(materialIn);
		
	}
	
	@Override
	public void func_180681_d(IBlockState state)
	{
		this.setBlockBounds(0F, 0F, 0F, 1F, 0.5F, 1F);
	}
	
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ)
	{
		
		return SittingUtil.sitOnBlock(world, pos.getX(), pos.getY(), pos.getZ(), player, 9 * 0.0625);
	}

    
}
