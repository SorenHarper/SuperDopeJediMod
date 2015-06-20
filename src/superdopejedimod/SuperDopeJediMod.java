package superdopesquad.superdopejedimod;

import java.util.Set;
import java.util.HashSet;

import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
//import net.minecraftforge.fml.common.Mod.Instance;
//import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;


@Mod(modid=SuperDopeJediMod.MODID, name=SuperDopeJediMod.MODNAME, version=SuperDopeJediMod.MODVER) //Tell forge "Oh hey, there's a new mod here to load."
public class SuperDopeJediMod //Start the class Declaration
{
    // Set the metadata of the mod.
    public static final String MODID = "superdopejedimod";
    public static final String MODNAME = "SuperDopeJediMod";
    public static final String MODVER = "0.0.1";

    // This is the collection of custom objects we will maintain.
    public static Set<BaseItem> customItems = new HashSet<BaseItem>();
    public static Set<BaseBlock> customBlocks = new HashSet<BaseBlock>();
    
    // instance variable.
    //@Instance(value = SuperDopeJediMod.MODID) //Tell Forge what instance to use.
    //public static SuperDopeJediMod instance;
    
    // Custom blocks items.
    public static BaseItem gaffiStick = new GaffiStick("gaffiStick");  
    public static BaseBlock brownSteel = new BrownSteel("brownSteel");
    public static Item brownSteelIngot = new BrownSteelIngot("brownSteelIngot");    
    public static BaseBlock brownSteelOre = new BrownSteelOre("brownSteelOre");
    public static Block vehicleSeat = new VehicleSeat("vehicleSeat");
    public static Item nourishmentCapsule = new NourishmentCapsule();
    public static Item lightSaberRed = new LightSaber("lightSaberRed", "Red"); 
    public static Item lightSaberBlue = new LightSaber("lightSaberBlue", "Blue");
    public static Item lightSaberGreen = new LightSaber("lightSaberGreen", "Green");
    public static Item lightSaberPurple = new LightSaber("lightSaberPurple", "Purple");
    public static Item doubleLightSaberRed = new DoubleLightSaber("doubleLightSaberRed", "Red");
    public static Item doubleLightSaberBlue = new DoubleLightSaber("doubleLightSaberBlue", "Blue");
    public static Item doubleLightSaberGreen = new DoubleLightSaber("doubleLightSaberGreen", "Green");
    public static Item doubleLightSaberPurple = new DoubleLightSaber("doubleLightSaberPurple", "Purple");
    public static Item redPowerCrystal = new PowerCrystal("redPowerCrystal", "Red");
    public static Item bluePowerCrystal = new PowerCrystal("bluePowerCrystal", "Blue");
    public static Item greenPowerCrystal = new PowerCrystal("greenPowerCrystal", "Green");
    public static Item purplePowerCrystal = new PowerCrystal("purplePowerCrystal", "Purple");
    public static Block redPowerCrystalOre = new PowerCrystalOre("redPowerCrystalOre", "Red");
    public static Block bluePowerCrystalOre = new PowerCrystalOre("bluePowerCrystalOre", "Blue");
    public static Block greenPowerCrystalOre = new PowerCrystalOre("greenPowerCrystalOre", "Green");
    public static Block purplePowerCrystalOre = new PowerCrystalOre("purplePowerCrystalOre", "Purple");

    //@SidedProxy(clientSide="tutorial.generic.client.ClientProxy",
    //        serverSide="tutorial.generic.CommonProxy")
    
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    	
    	//this.customItems.add(this.gaffiStick);
    	
    	// Iterate through all our custom blocks and items, and
    	// register them all.
    	for (BaseBlock baseBlock : this.customBlocks) {
    		baseBlock.registerBlock();
    	}
    	for (BaseItem baseItem : this.customItems) {
    		baseItem.registerItem();
    	}
    }
     
     
    
    @EventHandler
    public void load(FMLInitializationEvent event) {
    }
      
    
    @EventHandler
    public void init(FMLInitializationEvent event) {
    	
    	// Iterate through all our custom blocks and items, 
    	// and see if we have any recipes to register.
    	for (BaseBlock baseBlock : this.customBlocks) {
    		baseBlock.registerRecipe();
    	}
    	for (BaseItem baseItem : this.customItems) {
    		baseItem.registerRecipe();
    	}
    	
    	// All model and texture rendering has to be client-side only.
    	if(event.getSide() == Side.CLIENT) {
    	     
    		// Iterate through all our custom objects, and
        	// see if we have any models to render.
        	for (BaseBlock baseBlock : this.customBlocks) {
        		baseBlock.registerModel();
        	}
        	for (BaseItem baseItem : this.customItems) {
        		baseItem.registerModel();
        	}
    	}
    }
    
 
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    }
    
}
