package nekpek.mod.Naturalis.common;

import nekpek.mod.Naturalis.Generation.NaturalisWorldGeneration;
import nekpek.mod.Naturalis.Gui.GuiHandler;
import nekpek.mod.Naturalis.Mobs.NaturalisDrops;
import nekpek.mod.Naturalis.Tabs.NaturalisTabBlocks;
import nekpek.mod.Naturalis.Tabs.NaturalisTabItems;
import nekpek.mod.Naturalis.blocks.BlockNaturalisBirchBare;
import nekpek.mod.Naturalis.blocks.BlockNaturalisCorkWall;
import nekpek.mod.Naturalis.blocks.BlockNaturalisOakBare;
import nekpek.mod.Naturalis.blocks.BlockNaturalisPowerFurnace;
import nekpek.mod.Naturalis.blocks.BlockNaturalisRottingBark0;
import nekpek.mod.Naturalis.blocks.BlockNaturalisRottingBark1;
import nekpek.mod.Naturalis.blocks.BlockNaturalisRottingBark2;
import nekpek.mod.Naturalis.blocks.BlockNaturalisSaltOre;
import nekpek.mod.Naturalis.blocks.BlockNaturalisSeaWeed;
import nekpek.mod.Naturalis.blocks.TileEntityNaturalisFurnace;
import nekpek.mod.Naturalis.items.ItemNaturalisBastFibre;
import nekpek.mod.Naturalis.items.ItemNaturalisBirchBark;
import nekpek.mod.Naturalis.items.ItemNaturalisBucketSalt;
import nekpek.mod.Naturalis.items.ItemNaturalisChocoBucket;
import nekpek.mod.Naturalis.items.ItemNaturalisChocoMilk;
import nekpek.mod.Naturalis.items.ItemNaturalisCookedSquid;
import nekpek.mod.Naturalis.items.ItemNaturalisCork;
import nekpek.mod.Naturalis.items.ItemNaturalisFlouredSquid;
import nekpek.mod.Naturalis.items.ItemNaturalisLeather;
import nekpek.mod.Naturalis.items.ItemNaturalisRawCork;
import nekpek.mod.Naturalis.items.ItemNaturalisRawSquid;
import nekpek.mod.Naturalis.items.ItemNaturalisSalt;
import nekpek.mod.Naturalis.items.ItemNaturalisSaltedBeef;
import nekpek.mod.Naturalis.items.ItemNaturalisSaltedPork;
import nekpek.mod.Naturalis.items.ItemNaturalisScraper;
import nekpek.mod.Naturalis.items.ItemNaturalisTar;
import nekpek.mod.Naturalis.items.ItemNaturalisTarBucket;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "Naturalis", name = "Naturalis", version = "1.4")
@NetworkMod(clientSideRequired = true, serverSideRequired = false, channels = "Naturalis", packetHandler = NaturalisPackethandler.class)
public class Naturalis
    {

        @Instance
        public static Naturalis instance = new Naturalis();

        private final GuiHandler guihandler = new GuiHandler();

        public static Item NaturalisSalt;
        public static Item NaturalisSalt2;
        public static Item NaturalisBucketSalt;
        public static Item NaturalisLeather;
        public static Item NaturalisScraper;
        public static Item NaturalisCork;
        public static Item NaturalisRawCork;
        public static Item NaturalisSaltedBeef;
        public static Item NaturalisSaltedPork;
        public static Item NaturalisChocoBucket;
        public static Item NaturalisChocoMilk;
        public static Item NaturalisBirchBark;
        public static Item NaturalisBastFibre;
        public static Item NaturalisTarBucket;
        public static Item NaturalisTar;
        public static Item NaturalisRawSquid;
        public static Item NaturalisFlouredSquid;
        public static Item NaturalisCookedSquid;

        public static Block NaturalisRottingBark0;
        public static Block NaturalisRottingBark1;
        public static Block NaturalisRottingBark2;
        public static Block NaturalisOakBare;
        public static Block NaturalisBirchBare;
        public static Block NaturalisSaltOre;
        public static Block NaturalisTarSand;
        public static Block NaturalisCorkWall;
        public static Block NaturalisSeaWeed;

        public static Block NaturalisPowerFurnaceIdle;
        public static Block NaturalisPowerFurnaceLit;

        public static EnumToolMaterial NaturalisTools = EnumHelper.addToolMaterial("Naturalis", 2, 250, 6.0F, 2, 14);
        public static CreativeTabs NaturalisTabItems = new NaturalisTabItems(CreativeTabs.getNextID(), "NaturalisTabItems");
        public static CreativeTabs NaturalisTabBlocks = new NaturalisTabBlocks(CreativeTabs.getNextID(), "NaturalisTabBlocks");
        public static NaturalisWorldGeneration Genworld = new NaturalisWorldGeneration();

        @EventHandler
        public void load(FMLInitializationEvent event)
            {
                // ITEMS
                NaturalisSalt = new ItemNaturalisSalt(1000).setUnlocalizedName("NaturalisSalt").setCreativeTab(NaturalisTabItems);
                NaturalisBucketSalt = new ItemNaturalisBucketSalt(1001).setUnlocalizedName("NaturalisBucketSalt").setCreativeTab(NaturalisTabItems).setContainerItem(Item.bucketEmpty).setMaxStackSize(16);
                NaturalisLeather = new ItemNaturalisLeather(1002).setUnlocalizedName("NaturalisLeather").setCreativeTab(NaturalisTabItems);
                NaturalisScraper = new ItemNaturalisScraper(1003, NaturalisTools).setUnlocalizedName("NaturalisScaper").setCreativeTab(NaturalisTabItems);
                NaturalisCork = new ItemNaturalisCork(1004).setUnlocalizedName("NaturalisCork").setCreativeTab(NaturalisTabItems);
                NaturalisRawCork = new ItemNaturalisRawCork(1005).setUnlocalizedName("NaturlisRawCork").setCreativeTab(NaturalisTabItems);
                NaturalisSaltedPork = new ItemNaturalisSaltedPork(1006, 5, 0.2F, true).setUnlocalizedName("NaturalisSaltedPork").setCreativeTab(NaturalisTabItems);
                NaturalisSaltedBeef = new ItemNaturalisSaltedBeef(1007, 5, 0.2F, true).setUnlocalizedName("NaturalisSaltedBeef").setCreativeTab(NaturalisTabItems);
                NaturalisChocoBucket = new ItemNaturalisChocoBucket(1008).setUnlocalizedName("NaturalisChocoBucket").setCreativeTab(NaturalisTabItems).setContainerItem(Item.bucketEmpty).setMaxStackSize(16);
                NaturalisChocoMilk = new ItemNaturalisChocoMilk(1009, 3, 0.5f, false).setUnlocalizedName("NaturalisChocoMilk").setCreativeTab(NaturalisTabItems).setMaxStackSize(9);
                NaturalisBirchBark = new ItemNaturalisBirchBark(1010).setUnlocalizedName("NaturalisBirchBark").setCreativeTab(NaturalisTabItems);
                NaturalisBastFibre = new ItemNaturalisBastFibre(1011).setUnlocalizedName("NaturalisBastFibre").setCreativeTab(NaturalisTabItems);
                NaturalisSalt2 = new ItemNaturalisSalt(1012).setUnlocalizedName("NaturalisSalt2").setCreativeTab(NaturalisTabItems);
                NaturalisTarBucket = new ItemNaturalisTarBucket(1013).setUnlocalizedName("NaturalisTarBucket").setCreativeTab(NaturalisTabItems);
                NaturalisTar = new ItemNaturalisTar(1014).setUnlocalizedName("NaturalisTar").setCreativeTab(NaturalisTabItems);
                NaturalisRawSquid = new ItemNaturalisRawSquid(1015, 3, 0.4f, true).setUnlocalizedName("NaturalisRawSquid").setCreativeTab(NaturalisTabItems);
                NaturalisFlouredSquid = new ItemNaturalisFlouredSquid(1016).setUnlocalizedName("NaturalisFlouredSquid").setCreativeTab(NaturalisTabItems);
                NaturalisCookedSquid = new ItemNaturalisCookedSquid(1017, 9, 0.9f, true).setUnlocalizedName("NaturalisCookedSquid").setCreativeTab(NaturalisTabItems);

                // BLOCKS
                NaturalisRottingBark0 = new BlockNaturalisRottingBark0(1102, Material.wood).setUnlocalizedName("NaturalisRottingBark0").setHardness(2.0F).setStepSound(Block.soundWoodFootstep).setCreativeTab(NaturalisTabBlocks);
                NaturalisRottingBark1 = new BlockNaturalisRottingBark1(1103, Material.wood).setUnlocalizedName("NaturalisRottingBark1").setHardness(-1.0F).setStepSound(Block.soundWoodFootstep).setCreativeTab(NaturalisTabBlocks);
                NaturalisRottingBark2 = new BlockNaturalisRottingBark2(1104, Material.wood).setUnlocalizedName("NaturalisRottingBark2").setHardness(2.0F).setStepSound(Block.soundWoodFootstep).setCreativeTab(NaturalisTabBlocks);
                NaturalisOakBare = new BlockNaturalisOakBare(1100, Material.wood).setUnlocalizedName("NaturalisOakBare").setHardness(2.0F).setStepSound(Block.soundWoodFootstep).setCreativeTab(NaturalisTabBlocks);
                NaturalisBirchBare = new BlockNaturalisBirchBare(1101, Material.wood).setUnlocalizedName("NaturalisBirchBare").setHardness(2.0F).setStepSound(Block.soundWoodFootstep).setCreativeTab(NaturalisTabBlocks);
                NaturalisSaltOre = new BlockNaturalisSaltOre(1105, Material.sand).setUnlocalizedName("NaturalisSaltOre").setHardness(3.0f).setStepSound(Block.soundSandFootstep).setCreativeTab(NaturalisTabBlocks);
                NaturalisCorkWall = new BlockNaturalisCorkWall(1106, Material.wood).setUnlocalizedName("NaturalisCorkWall").setHardness(2.0f).setStepSound(Block.soundWoodFootstep).setCreativeTab(NaturalisTabBlocks);
                NaturalisSeaWeed = new BlockNaturalisSeaWeed(1107, Material.water).setUnlocalizedName("NaturalisSeaWeed").setHardness(0.4f).setCreativeTab(NaturalisTabBlocks);
                NaturalisPowerFurnaceIdle = new BlockNaturalisPowerFurnace(1109, false).setHardness(3.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("NaturalisPoweredFurnaceIdle").setCreativeTab(NaturalisTabBlocks);
                NaturalisPowerFurnaceLit = new BlockNaturalisPowerFurnace(1110, true).setHardness(3.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("NaturalisPoweredFurnaceLit");

                // ADDING NAMES TO THE ITEMS AND BLOCKS
                LanguageRegistry.addName(NaturalisSalt, "Sea Salt");
                LanguageRegistry.addName(NaturalisSalt2, "Rock Salt");
                LanguageRegistry.addName(NaturalisBucketSalt, "Bucket of Salt");
                LanguageRegistry.addName(NaturalisLeather, "Cork Leather");
                LanguageRegistry.addName(NaturalisScraper, "Long Handled Hatchet");
                LanguageRegistry.addName(NaturalisOakBare, "Barkless Oak Log");
                LanguageRegistry.addName(NaturalisBirchBare, "Barkless Birch Log");
                LanguageRegistry.addName(NaturalisCork, "Cork");
                LanguageRegistry.addName(NaturalisRawCork, "Raw Cork");
                LanguageRegistry.addName(NaturalisSaltedBeef, "Salted Beef");
                LanguageRegistry.addName(NaturalisSaltedPork, "Salted Pork");
                LanguageRegistry.addName(NaturalisChocoBucket, "Bucket of Chocomilk");
                LanguageRegistry.addName(NaturalisChocoMilk, "Chocomilk");
                LanguageRegistry.addName(NaturalisBirchBark, "Birch Bark");
                LanguageRegistry.addName(NaturalisBastFibre, "Bast Fibre");
                LanguageRegistry.addName(NaturalisSaltOre, "Rock Salt");
                LanguageRegistry.addName(NaturalisRottingBark0, "Rotting Bark");
                LanguageRegistry.addName(NaturalisRottingBark1, "Rotting Bark MidTerm");
                LanguageRegistry.addName(NaturalisRottingBark2, "Rotting Bark End");
                LanguageRegistry.addName(NaturalisTarBucket, "Bucket of Birch Bark");
                LanguageRegistry.addName(NaturalisTar, "Tar");
                LanguageRegistry.addName(NaturalisCorkWall, "Cork Wall");
                LanguageRegistry.addName(NaturalisRawSquid, "Raw Squid legs");
                LanguageRegistry.addName(NaturalisFlouredSquid, "Breaded Squid legs");
                LanguageRegistry.addName(NaturalisCookedSquid, "Fried Squid legs");
                LanguageRegistry.addName(NaturalisSeaWeed, "Sea Weed");
                LanguageRegistry.addName(NaturalisPowerFurnaceIdle, "Powered Furnace");
                LanguageRegistry.addName(NaturalisPowerFurnaceLit, "Powered Furnaced");

                // REGISTER BLOCKS AND SET MINING LEVELS
                MinecraftForge.setBlockHarvestLevel(NaturalisRottingBark0, "axe", 0);
                GameRegistry.registerBlock(NaturalisRottingBark0, "NaturalisRottingBark0");
                MinecraftForge.setBlockHarvestLevel(NaturalisRottingBark1, null, 100);
                GameRegistry.registerBlock(NaturalisRottingBark1, "NaturalisRottingBark1");
                MinecraftForge.setBlockHarvestLevel(NaturalisRottingBark2, "axe", 0);
                GameRegistry.registerBlock(NaturalisRottingBark2, "NaturalisRottingBark2");
                MinecraftForge.setBlockHarvestLevel(NaturalisOakBare, "axe", 0);
                GameRegistry.registerBlock(NaturalisOakBare, "NaturalisOakBare");
                MinecraftForge.setBlockHarvestLevel(NaturalisBirchBare, "axe", 0);
                GameRegistry.registerBlock(NaturalisBirchBare, "NaturalisBirchBare");
                MinecraftForge.setBlockHarvestLevel(NaturalisSaltOre, "shovel", 1);
                GameRegistry.registerBlock(NaturalisSaltOre, "NaturalisSaltOre");
                MinecraftForge.setBlockHarvestLevel(NaturalisCorkWall, "axe", 0);
                GameRegistry.registerBlock(NaturalisCorkWall, "NaturalisCorkWall");
                MinecraftForge.setBlockHarvestLevel(NaturalisSeaWeed, null, 0);
                GameRegistry.registerBlock(NaturalisSeaWeed, "NaturalisSeaWeed");
                MinecraftForge.setBlockHarvestLevel(NaturalisPowerFurnaceIdle, "pickaxe", 0);
                MinecraftForge.setBlockHarvestLevel(NaturalisPowerFurnaceLit, "pickaxe", 0);
                GameRegistry.registerBlock(NaturalisPowerFurnaceIdle, "NaturalisPowerFurnaceIdle");
                GameRegistry.registerBlock(NaturalisPowerFurnaceLit, "NaturalisPowerFurnaceLit");
                GameRegistry.registerTileEntity(TileEntityNaturalisFurnace.class, "TileEntityNaturalisFurnace");
                NetworkRegistry.instance().registerGuiHandler(this, guihandler);

                // LOADING COSTUM MOB DROPS
                MinecraftForge.EVENT_BUS.register(new NaturalisDrops());

                // LOADING WORLD GENERATOR
                GameRegistry.registerWorldGenerator(Genworld);
                // LOADING COSTUME FUELS
                GameRegistry.registerFuelHandler(new NaturalisFuel());

                // ADDING NAMES TO THE OREDICTIONARY
                OreDictionary.registerOre("itemLeather", NaturalisLeather);
                OreDictionary.registerOre("itemLeather", Item.leather);
                OreDictionary.registerOre("itemSalt", NaturalisSalt);
                OreDictionary.registerOre("itemSalt", NaturalisSalt2);
                OreDictionary.registerOre("dyeBlack", NaturalisTar);

                // ADDING SMELTING RECIPE
                GameRegistry.addSmelting(Item.bucketWater.itemID, new ItemStack(NaturalisBucketSalt), 0.1f);
                GameRegistry.addSmelting(NaturalisTarBucket.itemID, new ItemStack(NaturalisTar, 4), 0.1f);
                GameRegistry.addSmelting(NaturalisFlouredSquid.itemID, new ItemStack(NaturalisCookedSquid, 1), 0.1f);

                // ADDING RECIPIES
                GameRegistry.addRecipe(new ItemStack(NaturalisSalt, 4), new Object[] { "X", 'X', NaturalisBucketSalt });
                GameRegistry.addRecipe(new ItemStack(NaturalisScraper, 1), new Object[] { "Y", "X", "*", 'Y', Item.ingotIron, 'X', Item.axeIron, '*', Item.stick });
                GameRegistry.addRecipe(new ItemStack(Block.planks, 2, 0), new Object[] { "X", 'X', NaturalisOakBare });
                GameRegistry.addRecipe(new ItemStack(Block.planks, 2, 2), new Object[] { "X", 'X', NaturalisBirchBare });
                GameRegistry.addRecipe(new ItemStack(NaturalisLeather, 1), new Object[] { "XXX", "X*X", "XXX", 'X', NaturalisCork, '*', Item.silk });
                GameRegistry.addRecipe(new ItemStack(NaturalisCork, 4), new Object[] { "X", 'X', NaturalisRawCork });
                GameRegistry.addRecipe(new ItemStack(Item.silk, 1), new Object[] { "X", "X", "X", 'X', NaturalisBastFibre });
                GameRegistry.addRecipe(new ItemStack(Block.torchWood, 4), new Object[] { "X", "*", 'X', NaturalisTar, '*', Item.stick });
                GameRegistry.addRecipe(new ItemStack(NaturalisFlouredSquid, 1), new Object[] { "X*X", 'X', Item.wheat, '*', NaturalisRawSquid });
                GameRegistry.addRecipe(new ItemStack(NaturalisPowerFurnaceIdle, 1), new Object[] { "IRI", "LFT", "IBI", 'I', Block.blockIron, 'R', Block.blockRedstone, 'L', Block.lever, 'F', Block.furnaceIdle, 'T', Block.torchRedstoneActive, 'B', Item.blazeRod });
                /*
                 * using another type of loading a recipe because i use
                 * oreDictionary as an item reference.
                 */
                CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(NaturalisSaltedPork, 1), Item.porkRaw, "itemSalt"));
                CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(NaturalisSaltedBeef, 1), Item.beefRaw, "itemSalt"));
                // ADDING SHAPELESS RECIPIES
                GameRegistry.addShapelessRecipe(new ItemStack(NaturalisChocoBucket, 1), Item.sugar, new ItemStack(Item.dyePowder, 1, 3), Item.bucketMilk);
                GameRegistry.addShapelessRecipe(new ItemStack(NaturalisChocoMilk, 3), Item.glassBottle, Item.glassBottle, Item.glassBottle, NaturalisChocoBucket);
                GameRegistry.addShapelessRecipe(new ItemStack(NaturalisRottingBark0, 1), NaturalisBirchBark, Item.bucketWater);
                GameRegistry.addShapelessRecipe(new ItemStack(NaturalisTarBucket, 1), NaturalisRottingBark0, Item.bucketWater);

                // REMOVING VANILLA RECIPES WITH LEATHER
                CraftingManager.getInstance().getRecipeList().remove(Item.book);
                CraftingManager.getInstance().getRecipeList().remove(Item.legsLeather);
                CraftingManager.getInstance().getRecipeList().remove(Item.bootsLeather);
                CraftingManager.getInstance().getRecipeList().remove(Item.helmetLeather);
                CraftingManager.getInstance().getRecipeList().remove(Item.plateLeather);
                CraftingManager.getInstance().getRecipeList().remove(Item.itemFrame);

                // ADDING RECIPES WITH LEATHER
                CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(Item.book, 1), Item.paper, Item.paper, Item.paper, "itemLeather"));
                CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(Item.legsLeather, 1), "XXX", "X X", "X X", 'X', "itemLeather"));
                CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(Item.bootsLeather, 1), "X X", "X X", 'X', "itemLeather"));
                CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(Item.helmetLeather, 1), "XXX", "X X", 'X', "itemLeather"));
                CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(Item.plateLeather, 1), "X X", "XXX", "XXX", 'X', "itemLeather"));
                CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(Item.itemFrame, 1), "***", "*X*", "***", 'X', "itemLeather", '*', "stickWood"));

            }
    }
