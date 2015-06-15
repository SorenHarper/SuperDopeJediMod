package superDopeJediMod;

import java.util.Random;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;



public class PowerCrystalOre extends BaseBlock {
	
	String color;
	
	protected PowerCrystalOre(String unlocalizedName, String colorInput) {
		
		super(Material.rock, unlocalizedName);
		
		this.color = colorInput;
		
		this.setCreativeTab(CreativeTabs.tabBlock);
	}
	
	
	public Item getItemDropped(int metadata, Random random, int fortune) {
        
		Item obj;
		
		if (this.color == "Red") {
			obj = SuperDopeJediMod.redPowerCrystal;
		}
		else if (this.color == "Green") {
			obj = SuperDopeJediMod.greenPowerCrystal;
		}
		else if (this.color == "Blue") {
			obj = SuperDopeJediMod.bluePowerCrystal;
		}
		else if (this.color == "Purple") {
			obj = SuperDopeJediMod.purplePowerCrystal;
		}
		else {
			obj = SuperDopeJediMod.greenPowerCrystal;
		}
		
    	return obj;
    	
    	
    }
	
	
	

}
