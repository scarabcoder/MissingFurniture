package com.scarabcoder.furniture.init;
/*
 * 
 */
import com.scarabcoder.furniture.MissingFurniture;
import com.scarabcoder.furniture.Strings;
import com.scarabcoder.furniture.blocks.CoffeeCup;
import com.scarabcoder.furniture.blocks.CoffeeMachine;
import com.scarabcoder.furniture.blocks.Cup;
import com.scarabcoder.furniture.blocks.DPrinter;
import com.scarabcoder.furniture.blocks.DeckChair;
import com.scarabcoder.furniture.blocks.Desk;
import com.scarabcoder.furniture.blocks.Lamp;
import com.scarabcoder.furniture.blocks.Laptop;
import com.scarabcoder.furniture.blocks.Microphone;
import com.scarabcoder.furniture.blocks.Monitor;
import com.scarabcoder.furniture.blocks.Shelf;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class FurnitureBlocks {
	
	public static Block deckChair;
	public static Block monitor;
	public static Block coffeeMachine;
	public static Block coffeeCup;
	public static Block DPrinter;
	public static Block laptop;
	public static Block microphone;
	public static Block desk;
	public static Block lamp;
	public static Block shelf;
	public static Block cup;
	public static Block trashCan;
	public static Block filament;
	
	public static void init(){
		deckChair = new DeckChair(Material.carpet).setUnlocalizedName("deckChair");
		monitor = new Monitor(Material.carpet).setUnlocalizedName("monitor");
		coffeeMachine = new CoffeeMachine(Material.carpet).setUnlocalizedName("coffeeMachine");
		coffeeCup = new CoffeeCup(Material.carpet).setUnlocalizedName("coffeeCup");
		DPrinter = new DPrinter(Material.carpet).setUnlocalizedName("3DPrinter");
		laptop = new Laptop(Material.carpet).setUnlocalizedName("laptop");
		microphone = new Microphone(Material.carpet).setUnlocalizedName("microphone");
		desk = new Desk(Material.carpet).setUnlocalizedName("desk");
		lamp = new Lamp(Material.carpet).setUnlocalizedName("lamp");
		shelf = new Shelf(Material.carpet).setUnlocalizedName("shelf");
		cup = new Cup(Material.carpet).setUnlocalizedName("cup");
		trashCan = new TrashCan(Material.carpet).setUnlocalizedName("trashCan");
		filament = new Filament(Material.carpet).setUnlocalizedName("filament");
	}
	
	private static String name(Block block){
		return block.getUnlocalizedName().substring(5);
	}
	
	private static void registerBlock(Block block){
		GameRegistry.registerBlock(block, name(block));
	}
	
	private static String name(Item item){
		return item.getUnlocalizedName().substring(5);
	}
	public static void register(){
		registerBlock(deckChair);
		registerBlock(monitor);
		registerBlock(coffeeMachine);
		registerBlock(coffeeCup);
		registerBlock(DPrinter);
		registerBlock(laptop);
		registerBlock(microphone);
		registerBlock(desk);
		registerBlock(lamp);
		registerBlock(shelf);
		registerBlock(cup);
		registerBlock(trashCan);
		registerBlock(filament);
	}
	
	public static void registerRenders(){
		registerRender(deckChair);
		registerRender(monitor);
		registerRender(coffeeMachine);
		registerRender(coffeeCup);
		registerRender(DPrinter);
		registerRender(laptop);
		registerRender(microphone);
		registerRender(desk);
		registerRender(lamp);
		registerRender(shelf);
		registerRender(cup);
		registerRender(trashCan);
		registerRender(filament);
	}
	
	public static void registerRender(Block block){
		Item item = Item.getItemFromBlock(block);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Strings.id + ":" + name(item), "inventory"));
	}
}
