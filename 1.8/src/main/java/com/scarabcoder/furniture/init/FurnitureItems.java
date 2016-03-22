package com.scarabcoder.furniture.init;

import com.scarabcoder.furniture.MissingFurniture;
import com.scarabcoder.furniture.Strings;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class FurnitureItems {
	
	
	
	public static void init(){
	}
	
	public static void register(){
		
	}
	
	private static void registerItem(Item item){
		GameRegistry.registerItem(item, name(item));
	}
	
	public static void registerRenders(){
	}
	private static String name(Item item){
		return item.getUnlocalizedName().substring(5);
	}
	public static void registerRender(Item item){
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Strings.id + ":" + name(item), "inventory"));
	}
	
}
