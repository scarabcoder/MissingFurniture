package com.scarabcoder.furniture.blocks;

import java.util.List;

import com.scarabcoder.furniture.MissingFurniture;
import com.scarabcoder.furniture.init.FurnitureBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CoffeeCup extends BlockFurniture {

	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	
	public static final PropertyInteger LEVEL = PropertyInteger.create("level", 1, 3);

	public CoffeeCup(Material materialIn) {
		super(materialIn);
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.SOUTH).withProperty(LEVEL, 3));
        this.setCreativeTab(MissingFurniture.tab);
	}
	@Override
    public boolean isOpaqueCube()
    {
        return false;
    }
    @Override
	public boolean isFullCube()
	{
		return false;
	}
	@SideOnly(Side.CLIENT)
    public EnumWorldBlockLayer getBlockLayer()
    {
        return EnumWorldBlockLayer.TRANSLUCENT;
    }
    //3 = highest, 2 = mid, 1 = lowest
    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ){
    	
    	
    	worldIn.playSoundAtEntity(playerIn, "random.drink", 1.0f, 1.0f);
    	playerIn.addPotionEffect(new PotionEffect(3, 45 * 20, 1));
    	playerIn.addPotionEffect(new PotionEffect(1, 45 * 20, 1));
    	playerIn.getFoodStats().addStats(2, 0);
    	
    	if(state.getValue(LEVEL).intValue() == 1){
    		worldIn.setBlockState(pos, FurnitureBlocks.cup.getDefaultState().withProperty(FACING, state.getValue(FACING)), 3);
    	}else{
    		worldIn.setBlockState(pos, state.withProperty(LEVEL, state.getValue(LEVEL).intValue() - 1), 2);
    	}
    	
    	
    	
    	return true;
    }
    @Override
	public void setBlockBoundsBasedOnState(IBlockAccess access, BlockPos pos)
	{
		this.func_180681_d(access.getBlockState(pos));
	}
    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
    {
        this.setDefaultFacing(worldIn, pos, state);
    }
    private void setDefaultFacing(World worldIn, BlockPos pos, IBlockState state)
    {
        if (!worldIn.isRemote)
        {
            Block block = worldIn.getBlockState(pos.north()).getBlock();
            Block block1 = worldIn.getBlockState(pos.south()).getBlock();
            Block block2 = worldIn.getBlockState(pos.west()).getBlock();
            Block block3 = worldIn.getBlockState(pos.east()).getBlock();
            EnumFacing enumfacing = (EnumFacing)state.getValue(FACING);

            if (enumfacing == EnumFacing.NORTH && block.isFullBlock() && !block1.isFullBlock())
            {
                enumfacing = EnumFacing.SOUTH;
            }
            else if (enumfacing == EnumFacing.SOUTH && block1.isFullBlock() && !block.isFullBlock())
            {
                enumfacing = EnumFacing.NORTH;
            }
            else if (enumfacing == EnumFacing.WEST && block2.isFullBlock() && !block3.isFullBlock())
            {
                enumfacing = EnumFacing.EAST;
            }
            else if (enumfacing == EnumFacing.EAST && block3.isFullBlock() && !block2.isFullBlock())
            {
                enumfacing = EnumFacing.WEST;
            }

            worldIn.setBlockState(pos, state.withProperty(FACING, enumfacing), 2);
        }
    }
    public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
        return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite()).withProperty(LEVEL, 3);
    }
    
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
    {
        worldIn.setBlockState(pos, state.withProperty(FACING, placer.getHorizontalFacing().getOpposite()), 2);
        worldIn.setBlockState(pos, state.withProperty(LEVEL, 3));

    }
    public int getRenderType()
    {
        return 3;
    }
    @SideOnly(Side.CLIENT)
    public IBlockState getStateForEntityRender(IBlockState state)
    {
        return this.getDefaultState().withProperty(FACING, EnumFacing.SOUTH).withProperty(LEVEL, 3);
    }
    
    public int getMetaFromState(IBlockState state)
    {
        return ((EnumFacing)state.getValue(FACING)).getIndex() + state.getValue(LEVEL) * 3;
    }

    protected BlockState createBlockState()
    {
        return new BlockState(this, new IProperty[] {FACING, LEVEL});
    }
	@Override
	public void func_180681_d(IBlockState state)
	{
		this.setBlockBounds(0.375F, 0F, 0.375F, 0.625F, 0.25F, 0.625F);
	}
}
