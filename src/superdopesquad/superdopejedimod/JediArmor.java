package superdopesquad.superdopejedimod;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class JediArmor extends BaseArmor{

	public JediArmor(ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
		
		super(materialIn, renderIndexIn, equipmentSlotIn);

	}
	public JediArmor(EntityEquipmentSlot equipmentSlotIn, String nameInput) {
		
		super(SuperDopeJediMod.jediArmorMaterial, equipmentSlotIn, nameInput);
	}
	
	public void registerRecipe() {
		
		ItemStack saphireStack = new ItemStack(SuperDopeJediMod.saphire);
		
		// Helmet.
    	GameRegistry.addShapedRecipe(getRegistryName(), null, new ItemStack(SuperDopeJediMod.jediHelmet), "xxx", "x x", 'x', saphireStack);		
		// Chest.
    	GameRegistry.addShapedRecipe(getRegistryName(), null, new ItemStack(SuperDopeJediMod.jediChestplate), "x x", "xxx", "xxx", 'x', saphireStack);
    	// Leggings.
    	GameRegistry.addShapedRecipe(getRegistryName(), null, new ItemStack(SuperDopeJediMod.jediLeggings), "xxx", "x x", "x x", 'x', saphireStack);
    	// Boots.
    	GameRegistry.addShapedRecipe(getRegistryName(), null, new ItemStack(SuperDopeJediMod.jediBoots), "x x", "x x", 'x', saphireStack);
    	// Shield.
    	//GameRegistry.addRecipe(new ItemStack(SuperDopeJediMod.mandalorianIronShield), "xxx", "xxx", " x ", 'x', mandalorianIronIngotStack);
	}	
	
}
