package com.scarabcoder.furniture.blocks;

import org.lwjgl.input.Keyboard;

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
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CoffeeMachine extends BlockFurniture {
	
	public CoffeeMachine(Material materialIn) {
		super(materialIn);
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.SOUTH));
        this.setDefaultState(this.blockState.getBaseState().withProperty(FILLED, 3));
		this.setCreativeTab(MissingFurniture.tab);
	}
	
	
	
	//So, uh, the order of numbers here are a bit strange. Maybe I should change this, but I'm lazy and out of coffee.
	//3 = empty, 2 = full cup, 1 = empty cup
	public static final PropertyInteger FILLED = PropertyInteger.create("filled", 1, 3);
	
	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);

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
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
    {	
    	if(!Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)){
	    	if(playerIn.getHeldItem() != null){
	    		if(state.getValue(FILLED).intValue() == 3){
			    	if(playerIn.getHeldItem().getItem().equals(Item.getItemFromBlock(FurnitureBlocks.coffeeCup))){
			    		worldIn.setBlockState(pos, state.withProperty(FILLED, 2), 2);
			    		if(!playerIn.capabilities.isCreativeMode){
			    			decreaseStack(playerIn);
			    		}
			    		return true;
			    	}else if(playerIn.getHeldItem().getItem().equals(Item.getItemFromBlock(FurnitureBlocks.cup))){
			    		worldIn.setBlockState(pos, state.withProperty(FILLED, 1), 2);
			    		if(!playerIn.capabilities.isCreativeMode){
			    			decreaseStack(playerIn);
			    		}
			    		return true;
			    	}
		    	}
	    	}
	    	if(state.getValue(FILLED).intValue() != 3){
	    		if(state.getValue(FILLED).intValue() == 2){
	    			worldIn.setBlockState(pos, state.withProperty(FILLED, 3),2);
	    			playerIn.inventory.addItemStackToInventory(new ItemStack(Item.getItemFromBlock(FurnitureBlocks.coffeeCup)));
	    			return true;
	    		}else{
	    			worldIn.setBlockState(pos, state.withProperty(FILLED, 3),2);
	    			playerIn.inventory.addItemStackToInventory(new ItemStack(Item.getItemFromBlock(FurnitureBlocks.cup)));
	    			return true;
	    		}
	    	}
    	}else{
    		if(state.getValue(FILLED).intValue() == 1){
    			worldIn.setBlockState(pos, state.withProperty(FILLED, 2), 2);
    			worldIn.playSoundAtEntity(playerIn, "random.fizz", 1.0f, 1.0f);
    			return true;
    		}
    	}
    	return false;
    	
    	
    }
    public static void decreaseStack(EntityPlayer player){
    	ItemStack stack = player.getHeldItem();
    	stack.stackSize = stack.stackSize - 1;
    	if(stack.stackSize == 0){
    		player.inventory.removeStackFromSlot(player.inventory.currentItem);
    	}else{
    		player.inventory.setInventorySlotContents(player.inventory.currentItem, stack);
    	}
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
        worldIn.setBlockState(pos, state.withProperty(FILLED, 3), 2);
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
        return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite()).withProperty(FILLED, 3);
    }
    
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
    {
        worldIn.setBlockState(pos, state.withProperty(FACING, placer.getHorizontalFacing().getOpposite()).withProperty(FILLED, 3), 2);

    }
    public int getRenderType()
    {
        return 3;
    }
    
    @SideOnly(Side.CLIENT)
    public IBlockState getStateForEntityRender(IBlockState state)
    {
        return this.getDefaultState().withProperty(FACING, EnumFacing.SOUTH).withProperty(FILLED, 3);
    }
    @Override
    public int getMetaFromState(IBlockState state)
    {	
    	
    	int i;

        switch ((EnumFacing)state.getValue(FACING))
        {
            case EAST:
                i = 1;
                break;
            case WEST:
                i = 2;
                break;
            case SOUTH:
                i = 3;
                break;
            case NORTH:
                i = 4;
                break;
            case UP:
            default:
                i = 5;
                break;
            case DOWN:
                i = 0;
        }
        
        i |= 10 * state.getValue(FILLED).intValue();
        //return i;
        return (state.getValue(FACING).getIndex() + state.getValue(FILLED).intValue() * 4);
    }
    
    

    protected BlockState createBlockState()
    {
        return new BlockState(this, new IProperty[] {FACING, FILLED});
    }
    
	
}
