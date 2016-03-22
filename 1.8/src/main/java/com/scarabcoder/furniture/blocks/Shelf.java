package com.scarabcoder.furniture.blocks;

import com.scarabcoder.furniture.MissingFurniture;

import net.minecraft.block.material.Material;

public class Shelf extends BlockFurniture {

	public Shelf(Material materialIn) {
		super(materialIn);
		this.setCreativeTab(MissingFurniture.tab);
	}

}
