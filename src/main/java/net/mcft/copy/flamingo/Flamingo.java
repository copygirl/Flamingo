package net.mcft.copy.flamingo;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = "Flamingo", version = "1.8.8-1.4", useMetadata = true)
public class Flamingo {

	@Instance("Flamingo")
	public static Flamingo instance;

	@SidedProxy(clientSide = "net.mcft.copy.flamingo.ClientProxy",
		serverSide = "net.mcft.copy.flamingo.CommonProxy")
	public static CommonProxy proxy;

	public static BlockFlamingo flamingo;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		initializeItems();
		GameRegistry.registerTileEntity(TileEntityFlamingo.class, "flamingo.flamingo");
		proxy.registerItemModels();
	}

	@Mod.EventHandler
	public void load(FMLInitializationEvent event) {
		addRecipes();
		proxy.registerRenderers();
	}

	private void initializeItems() {
		flamingo = new BlockFlamingo();
	}

	private void addRecipes() {
		GameRegistry.addRecipe(new ItemStack(flamingo),
			"  o",
			"ooo",
			" / ",

			'o', new ItemStack(Blocks.WOOL, 1, 6),
			'/', Items.STICK);
		GameRegistry.addRecipe(new ItemStack(flamingo),
			"o  ",
			"ooo",
			" / ",

			'o', new ItemStack(Blocks.WOOL, 1, 6),
			'/', Items.STICK);
	}

}
