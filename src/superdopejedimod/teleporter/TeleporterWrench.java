package superdopesquad.superdopejedimod.teleporter;


import net.minecraft.block.Block;
import net.minecraft.block.BlockStoneBrick;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import superdopesquad.superdopejedimod.BaseItem;
import superdopesquad.superdopejedimod.GeometryUtil;
import superdopesquad.superdopejedimod.SuperDopeJediMod;

	
public class TeleporterWrench extends BaseItem {

		
	public TeleporterWrench(String unlocalizedName) {
			      
		super(unlocalizedName);
		this.setCreativeTab(CreativeTabs.MATERIALS);
	}
		
		
	@Override
	public void registerRecipe() {
		
		ItemStack itemStackTeleporterParts = new ItemStack(SuperDopeJediMod.teleporterManager.teleporterParts);
		ItemStack itemStackThis = new ItemStack(this);
		ItemStack itemStackTeleporterPartsMany = new ItemStack(SuperDopeJediMod.teleporterManager.teleporterParts, 3);
		
    	GameRegistry.addRecipe(itemStackThis, " x ", " x ", " x ", 'x', itemStackTeleporterParts);	
    	GameRegistry.addRecipe(itemStackTeleporterPartsMany, "x", 'x', itemStackThis);	
	}

	
	@Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos blockPos, EnumHand hand, EnumFacing facing, 
    		float hitX, float hitY, float hitZ) {
        
		boolean isWorldServer = (!world.isRemote);
		IBlockState blockStateClicked = world.getBlockState(blockPos);
    	Block blockClicked = blockStateClicked.getBlock();
    	boolean isTeleporterStarterKit = (blockClicked instanceof TeleporterStartingKit);
       	boolean isTeleporterKit = (blockClicked instanceof TeleporterFinishingKit);
           	
    	//System.out.println("DEBUG: inside TeleporterWrench:onItemUse: " + blockClicked.toString() + 
    	//		" : " + hand.name() + " : " + facing.getName() + " : " + (isTeleporterStarterKit) + " : " + (isTeleporterKit));
    	
    	// If we are on the server, and we are being held in the main hand, and this is actually a droidkit , ...
    	if ((isWorldServer) && (hand == EnumHand.MAIN_HAND) && (isTeleporterStarterKit)) {
        	    		
    		// Create a starter teleporter.
    		if (TeleporterManager.createStarterTeleporter(player, world, blockPos, facing)) {
    		
    			// Return something relevant.
    			return EnumActionResult.SUCCESS;
    		}
    	}
   	
    	return EnumActionResult.PASS;
    }
}
