package com.scarabcoder.furniture.init;

import org.lwjgl.input.Keyboard;

import com.scarabcoder.furniture.MissingFurniture;
import com.scarabcoder.furniture.blocks.BlockFurniture;

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
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import util.Util;

public class TrashCan extends BlockFurniture {
	
	Util util = new Util();
	
	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	
	public static final PropertyInteger LEVEL = PropertyInteger.create("level", 0, 3);

	public TrashCan(Material materialIn) {
		super(materialIn);
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.SOUTH).withProperty(LEVEL, 0));
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
    @Override
	public void setBlockBoundsBasedOnState(IBlockAccess access, BlockPos pos)
	{
		this.func_180681_d(access.getBlockState(pos));
	}
   	public void func_180681_d(IBlockState state)
	{
		this.setBlockBounds(0F, 0F, 0F, 1F, 1F, 1F);
	}
    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
    {
        this.setDefaultFacing(worldIn, pos, state);
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ){
    	if(playerIn.getHeldItem() != null){
    		if(state.getValue(LEVEL).intValue() != 3){
    			util.decreaseStack(playerIn);
    			worldIn.setBlockState(pos, state.withProperty(LEVEL, state.getValue(LEVEL) + 1), 2);
    			return true;
    		}
    	}
    	if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)){
    		if(state.getValue(LEVEL).intValue() == 3){
    			worldIn.setBlockState(pos, state.withProperty(LEVEL, 0), 2);
    			return true;
    		}
    	}else{
    		if(state.getValue(LEVEL).intValue() == 3){
    			playerIn.addChatComponentMessage(new ChatComponentText("Trash can full! Shift-right-click with hand to take it out."));
    		}
    	}
    	
    	return false;
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
        return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite()).withProperty(LEVEL, 0);
    }
    
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
    {
        worldIn.setBlockState(pos, state.withProperty(FACING, placer.getHorizontalFacing().getOpposite()).withProperty(LEVEL, 0), 2);

    }
    public int getRenderType()
    {
        return 3;
    }
    @SideOnly(Side.CLIENT)
    public IBlockState getStateForEntityRender(IBlockState state)
    {
        return this.getDefaultState().withProperty(FACING, EnumFacing.SOUTH).withProperty(LEVEL, 0);
    }
    
    public int getMetaFromState(IBlockState state)
    {
        return ((EnumFacing)state.getValue(FACING)).getIndex() + state.getValue(LEVEL).intValue() * 4;
    }

    protected BlockState createBlockState()
    {
        return new BlockState(this, new IProperty[] {FACING, LEVEL});
    }
}
