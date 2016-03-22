package com.scarabcoder.furniture;

import com.scarabcoder.furniture.init.FurnitureBlocks;
import com.scarabcoder.furniture.init.FurnitureItems;
import com.scarabcoder.furniture.init.FurnitureTab;
import com.scarabcoder.furniture.proxy.CommonProxy;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Strings.id, name = Strings.name, version = Strings.version)
public class MissingFurniture {
	
	public static final FurnitureTab tab = new FurnitureTab("tabMissingFurniture");
	
	@SidedProxy(clientSide = Strings.clientProxyClass, serverSide = Strings.commonProxyClass)
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		FurnitureBlocks.init();
		FurnitureBlocks.register();
		FurnitureItems.init();
		FurnitureItems.register();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event){
		proxy.registerRenders();
		
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		
	}
	
}
