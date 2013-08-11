package nekpek.mod.Naturalis.common;

import nekpek.mod.Naturalis.Entity.EntityNaturalisFish;
import nekpek.mod.Naturalis.Entity.NaturalisEntity;
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
import nekpek.mod.Naturalis.items.ItemNaturalisBreadDough;
import nekpek.mod.Naturalis.items.ItemNaturalisBucketSalt;
import nekpek.mod.Naturalis.items.ItemNaturalisChocoBucket;
import nekpek.mod.Naturalis.items.ItemNaturalisChocoMilk;
import nekpek.mod.Naturalis.items.ItemNaturalisCookedSquid;
import nekpek.mod.Naturalis.items.ItemNaturalisCork;
import nekpek.mod.Naturalis.items.ItemNaturalisFishSushi;
import nekpek.mod.Naturalis.items.ItemNaturalisFlouredSquid;
import nekpek.mod.Naturalis.items.ItemNaturalisLeather;
import nekpek.mod.Naturalis.items.ItemNaturalisNoriSheet;
import nekpek.mod.Naturalis.items.ItemNaturalisRawCork;
import nekpek.mod.Naturalis.items.ItemNaturalisRawSquid;
import nekpek.mod.Naturalis.items.ItemNaturalisSalt;
import nekpek.mod.Naturalis.items.ItemNaturalisSaltedBeef;
import nekpek.mod.Naturalis.items.ItemNaturalisSaltedPork;
import nekpek.mod.Naturalis.items.ItemNaturalisScraper;
import nekpek.mod.Naturalis.items.ItemNaturalisTar;
import nekpek.mod.Naturalis.items.ItemNaturalisTarBucket;
import nekpek.mod.Naturalis.items.ItemNaturalisWheatFlour;
import nekpek.mod.Naturalis.items.ItemNaturlisSquidSushi;
import nekpek.mod.Naturalis.models.NaturalisFish;
import nekpek.mod.Naturalis.render.RenderNaturalisFish;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
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
        public static Item NaturalisSquidSushi;
        public static Item NaturalisFishSushi;
        public static Item NaturalisNoriSheet;
        public static Item NaturalisWheatFlour;
        public static Item NaturalisBreadDough;

        public static Block NaturalisRottingBark0;
        public static Block NaturalisRottingBark1;
        public static Block NaturalisRottingBark2;
        public static Block NaturalisOakBare;
        public static Block NaturalisBirchBare;
        public static Block NaturalisSaltOre;
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
                NaturalisSalt = new ItemNaturalisSalt(2300).setUnlocalizedName("NaturalisSalt").setCreativeTab(NaturalisTabItems);
                NaturalisBucketSalt = new ItemNaturalisBucketSalt(2301).setUnlocalizedName("NaturalisBucketSalt").setCreativeTab(NaturalisTabItems).setContainerItem(Item.bucketEmpty).setMaxStackSize(16);
                NaturalisLeather = new ItemNaturalisLeather(2302).setUnlocalizedName("NaturalisLeather").setCreativeTab(NaturalisTabItems);
                NaturalisScraper = new ItemNaturalisScraper(2303, NaturalisTools).setUnlocalizedName("NaturalisScaper").setCreativeTab(NaturalisTabItems);
                NaturalisCork = new ItemNaturalisCork(2304).setUnlocalizedName("NaturalisCork").setCreativeTab(NaturalisTabItems);
                NaturalisRawCork = new ItemNaturalisRawCork(2305).setUnlocalizedName("NaturlisRawCork").setCreativeTab(NaturalisTabItems);
                NaturalisSaltedPork = new ItemNaturalisSaltedPork(2306, 5, 0.2F, true).setUnlocalizedName("NaturalisSaltedPork").setCreativeTab(NaturalisTabItems);
                NaturalisSaltedBeef = new ItemNaturalisSaltedBeef(2307, 5, 0.2F, true).setUnlocalizedName("NaturalisSaltedBeef").setCreativeTab(NaturalisTabItems);
                NaturalisChocoBucket = new ItemNaturalisChocoBucket(2308).setUnlocalizedName("NaturalisChocoBucket").setCreativeTab(NaturalisTabItems).setContainerItem(Item.bucketEmpty).setMaxStackSize(16);
                NaturalisChocoMilk = new ItemNaturalisChocoMilk(2309, 3, 0.5f, false).setUnlocalizedName("NaturalisChocoMilk").setCreativeTab(NaturalisTabItems).setMaxStackSize(9);
                NaturalisBirchBark = new ItemNaturalisBirchBark(2310).setUnlocalizedName("NaturalisBirchBark").setCreativeTab(NaturalisTabItems);
                NaturalisBastFibre = new ItemNaturalisBastFibre(2311).setUnlocalizedName("NaturalisBastFibre").setCreativeTab(NaturalisTabItems);
                NaturalisSalt2 = new ItemNaturalisSalt(2312).setUnlocalizedName("NaturalisSalt2").setCreativeTab(NaturalisTabItems);
                NaturalisTarBucket = new ItemNaturalisTarBucket(2313).setUnlocalizedName("NaturalisTarBucket").setCreativeTab(NaturalisTabItems);
                NaturalisTar = new ItemNaturalisTar(2314).setUnlocalizedName("NaturalisTar").setCreativeTab(NaturalisTabItems);
                NaturalisRawSquid = new ItemNaturalisRawSquid(2315, 3, 0.4f, true).setUnlocalizedName("NaturalisRawSquid").setCreativeTab(NaturalisTabItems);
                NaturalisFlouredSquid = new ItemNaturalisFlouredSquid(2316).setUnlocalizedName("NaturalisFlouredSquid").setCreativeTab(NaturalisTabItems);
                NaturalisCookedSquid = new ItemNaturalisCookedSquid(2317, 9, 0.9f, true).setUnlocalizedName("NaturalisCookedSquid").setCreativeTab(NaturalisTabItems);
                NaturalisSquidSushi = new ItemNaturlisSquidSushi(2318, 8, 0.8f, true).setUnlocalizedName("NaturalisSquidSushi").setCreativeTab(NaturalisTabItems);
                NaturalisFishSushi = new ItemNaturalisFishSushi(2319, 8, 0.8f, true).setUnlocalizedName("NaturalisFishSushi").setCreativeTab(NaturalisTabItems);
                NaturalisNoriSheet = new ItemNaturalisNoriSheet(2320).setUnlocalizedName("NaturalisNoriSheet").setCreativeTab(NaturalisTabItems);
                NaturalisWheatFlour = new ItemNaturalisWheatFlour(2321).setUnlocalizedName("NaturalisWheatFlour").setCreativeTab(NaturalisTabItems);
                NaturalisBreadDough = new ItemNaturalisBreadDough(2322).setUnlocalizedName("NatualisBreadDough").setCreativeTab(NaturalisTabItems);

                // BLOCKS
                NaturalisRottingBark0 = new BlockNaturalisRottingBark0(2402, Material.wood).setUnlocalizedName("NaturalisRottingBark0").setHardness(2.0F).setStepSound(Block.soundWoodFootstep).setCreativeTab(NaturalisTabBlocks);
                NaturalisRottingBark1 = new BlockNaturalisRottingBark1(2403, Material.wood).setUnlocalizedName("NaturalisRottingBark1").setHardness(-1.0F).setStepSound(Block.soundWoodFootstep).setCreativeTab(NaturalisTabBlocks);
                NaturalisRottingBark2 = new BlockNaturalisRottingBark2(2404, Material.wood).setUnlocalizedName("NaturalisRottingBark2").setHardness(2.0F).setStepSound(Block.soundWoodFootstep).setCreativeTab(NaturalisTabBlocks);
                NaturalisOakBare = new BlockNaturalisOakBare(2400, Material.wood).setUnlocalizedName("NaturalisOakBare").setHardness(2.0F).setStepSound(Block.soundWoodFootstep).setCreativeTab(NaturalisTabBlocks);
                NaturalisBirchBare = new BlockNaturalisBirchBare(2401, Material.wood).setUnlocalizedName("NaturalisBirchBare").setHardness(2.0F).setStepSound(Block.soundWoodFootstep).setCreativeTab(NaturalisTabBlocks);
                NaturalisSaltOre = new BlockNaturalisSaltOre(2405, Material.sand).setUnlocalizedName("NaturalisSaltOre").setHardness(3.0f).setStepSound(Block.soundSandFootstep).setCreativeTab(NaturalisTabBlocks);
                NaturalisCorkWall = new BlockNaturalisCorkWall(2406, Material.wood).setUnlocalizedName("NaturalisCorkWall").setHardness(2.0f).setStepSound(Block.soundWoodFootstep).setCreativeTab(NaturalisTabBlocks);
                NaturalisSeaWeed = new BlockNaturalisSeaWeed(2407, Material.water).setUnlocalizedName("NaturalisSeaWeed").setHardness(0.4f).setCreativeTab(NaturalisTabBlocks);
                NaturalisPowerFurnaceIdle = new BlockNaturalisPowerFurnace(2409, false).setHardness(3.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("NaturalisPoweredFurnaceIdle").setCreativeTab(NaturalisTabBlocks);
                NaturalisPowerFurnaceLit = new BlockNaturalisPowerFurnace(2410, true).setHardness(3.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("NaturalisPoweredFurnaceLit");

                // MOBS
                EntityRegistry.registerGlobalEntityID(EntityNaturalisFish.class, "Fish", 1);
                EntityRegistry.addSpawn(EntityNaturalisFish.class, 10, 5, 12, EnumCreatureType.waterCreature, BiomeGenBase.ocean);
                EntityRegistry.findGlobalUniqueEntityId();
                NaturalisEntity.registerEntityEgg(EntityNaturalisFish.class, 0x0FF7700, 0x0FFC592);
                RenderingRegistry.registerEntityRenderingHandler(EntityNaturalisFish.class, new RenderNaturalisFish(new NaturalisFish(), 0.3f));

                // REGISTERING NAMES TO ITEMS
                LanguageRegistry.addName(NaturalisSalt, "Sea Salt");
                LanguageRegistry.addName(NaturalisSalt2, "Rock Salt");
                LanguageRegistry.addName(NaturalisBucketSalt, "Bucket of Salt");
                LanguageRegistry.addName(NaturalisLeather, "Cork Leather");
                LanguageRegistry.addName(NaturalisScraper, "Long Handled Hatchet");
                LanguageRegistry.addName(NaturalisCork, "Cork");
                LanguageRegistry.addName(NaturalisRawCork, "Raw Cork");
                LanguageRegistry.addName(NaturalisSaltedBeef, "Salted Beef");
                LanguageRegistry.addName(NaturalisSaltedPork, "Salted Pork");
                LanguageRegistry.addName(NaturalisChocoBucket, "Bucket of Chocomilk");
                LanguageRegistry.addName(NaturalisChocoMilk, "Chocomilk");
                LanguageRegistry.addName(NaturalisBirchBark, "Birch Bark");
                LanguageRegistry.addName(NaturalisBastFibre, "Bast Fibre");
                LanguageRegistry.addName(NaturalisTarBucket, "Bucket of Birch Bark");
                LanguageRegistry.addName(NaturalisTar, "Tar");
                LanguageRegistry.addName(NaturalisRawSquid, "Raw Squid legs");
                LanguageRegistry.addName(NaturalisFlouredSquid, "Breaded Squid legs");
                LanguageRegistry.addName(NaturalisCookedSquid, "Fried Squid legs");
                LanguageRegistry.addName(NaturalisSquidSushi, "Squid roll");
                LanguageRegistry.addName(NaturalisFishSushi, "Fish roll");
                LanguageRegistry.addName(NaturalisNoriSheet, "Nori Sheet");
                LanguageRegistry.addName(NaturalisWheatFlour, "Flour");
                LanguageRegistry.addName(NaturalisBreadDough, "Dough");

                // REGISERING NAMES TO EGG
                LanguageRegistry.instance().addStringLocalization("entity.Fish.name", "Fish");

                // REGISTERING NAMES TO BLOCKS
                LanguageRegistry.addName(NaturalisOakBare, "Barkless Oak Log");
                LanguageRegistry.addName(NaturalisBirchBare, "Barkless Birch Log");
                LanguageRegistry.addName(NaturalisSaltOre, "Rock Salt");
                LanguageRegistry.addName(NaturalisRottingBark0, "Rotting Bark");
                LanguageRegistry.addName(NaturalisRottingBark1, "Rotting Bark MidTerm");
                LanguageRegistry.addName(NaturalisRottingBark2, "Rotting Bark End");
                LanguageRegistry.addName(NaturalisCorkWall, "Cork Wall");
                LanguageRegistry.addName(NaturalisSeaWeed, "Sea Weed");
                LanguageRegistry.addName(NaturalisPowerFurnaceIdle, "Powered Furnace");
                LanguageRegistry.addName(NaturalisPowerFurnaceLit, "Powered Furnaced");

                // REGISTER BLOCKS AND SET MINING LEVELS
                // - ROTTING BARK 1
                MinecraftForge.setBlockHarvestLevel(NaturalisRottingBark0, "axe", 0);
                GameRegistry.registerBlock(NaturalisRottingBark0, "NaturalisRottingBark0");
                // - ROTTING BARK 2
                MinecraftForge.setBlockHarvestLevel(NaturalisRottingBark1, null, 100);
                GameRegistry.registerBlock(NaturalisRottingBark1, "NaturalisRottingBark1");
                // - ROTTING BARK 3
                MinecraftForge.setBlockHarvestLevel(NaturalisRottingBark2, "axe", 0);
                GameRegistry.registerBlock(NaturalisRottingBark2, "NaturalisRottingBark2");
                // - BARKLESS OAK
                MinecraftForge.setBlockHarvestLevel(NaturalisOakBare, "axe", 0);
                GameRegistry.registerBlock(NaturalisOakBare, "NaturalisOakBare");
                // - BARKLESS BIRCH
                MinecraftForge.setBlockHarvestLevel(NaturalisBirchBare, "axe", 0);
                GameRegistry.registerBlock(NaturalisBirchBare, "NaturalisBirchBare");
                // - SALT ORE
                MinecraftForge.setBlockHarvestLevel(NaturalisSaltOre, "shovel", 1);
                GameRegistry.registerBlock(NaturalisSaltOre, "NaturalisSaltOre");
                // - CORK WALL
                MinecraftForge.setBlockHarvestLevel(NaturalisCorkWall, "axe", 0);
                GameRegistry.registerBlock(NaturalisCorkWall, "NaturalisCorkWall");
                // - SEA WEED
                MinecraftForge.setBlockHarvestLevel(NaturalisSeaWeed, null, 0);
                GameRegistry.registerBlock(NaturalisSeaWeed, "NaturalisSeaWeed");
                // - POWERED FURNACE
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

                // LOADING COSTUM FUELS
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
                GameRegistry.addSmelting(NaturalisBreadDough.itemID, new ItemStack(Item.bread, 1), 0.1f);

                // ADDING RECIPIES
                GameRegistry.addRecipe(new ItemStack(NaturalisSalt, 4), new Object[] { "X", 'X', NaturalisBucketSalt });
                GameRegistry.addRecipe(new ItemStack(NaturalisScraper, 1), new Object[] { "Y", "X", "*", 'Y', Item.ingotIron, 'X', Item.axeIron, '*', Item.stick });
                GameRegistry.addRecipe(new ItemStack(Block.planks, 2, 0), new Object[] { "X", 'X', NaturalisOakBare });
                GameRegistry.addRecipe(new ItemStack(Block.planks, 2, 2), new Object[] { "X", 'X', NaturalisBirchBare });
                GameRegistry.addRecipe(new ItemStack(NaturalisLeather, 1), new Object[] { "XXX", "X*X", "XXX", 'X', NaturalisCork, '*', Item.silk });
                GameRegistry.addRecipe(new ItemStack(NaturalisCork, 4), new Object[] { "X", 'X', NaturalisRawCork });
                GameRegistry.addRecipe(new ItemStack(Item.silk, 1), new Object[] { "X", "X", "X", 'X', NaturalisBastFibre });
                GameRegistry.addRecipe(new ItemStack(Block.torchWood, 4), new Object[] { "X", "*", 'X', NaturalisTar, '*', Item.stick });
                GameRegistry.addRecipe(new ItemStack(NaturalisFlouredSquid, 1), new Object[] { "X*X", 'X', NaturalisBreadDough, '*', NaturalisRawSquid });
                GameRegistry.addRecipe(new ItemStack(NaturalisPowerFurnaceIdle, 1), new Object[] { "IRI", "LFT", "IBI", 'I', Block.blockIron, 'R', Block.blockRedstone, 'L', Block.lever, 'F', Block.furnaceIdle, 'T', Block.torchRedstoneActive, 'B', Item.blazeRod });
                GameRegistry.addRecipe(new ItemStack(NaturalisSquidSushi, 1), new Object[] { "NQN", 'N', NaturalisNoriSheet, 'Q', NaturalisRawSquid });
                GameRegistry.addRecipe(new ItemStack(NaturalisFishSushi, 1), new Object[] { "NQN", 'N', NaturalisNoriSheet, 'Q', Item.fishRaw });
                GameRegistry.addRecipe(new ItemStack(NaturalisNoriSheet, 9), new Object[] { "SSS", 'S', NaturalisSeaWeed });
                /*
                 * using another type of loading a recipe because i use
                 * oreDictionary as an item reference.
                 */
                CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(NaturalisSaltedPork, 1), Item.porkRaw, "itemSalt"));
                CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(NaturalisSaltedBeef, 1), Item.beefRaw, "itemSalt"));
                CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(NaturalisBreadDough, 5), NaturalisWheatFlour, Item.bucketWater, "itemSalt"));
                CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(NaturalisWheatFlour, 2), Item.wheat, Item.wheat));
                // ADDING SHAPELESS RECIPIES
                GameRegistry.addShapelessRecipe(new ItemStack(NaturalisChocoBucket, 1), Item.sugar, new ItemStack(Item.dyePowder, 1, 3), Item.bucketMilk);
                GameRegistry.addShapelessRecipe(new ItemStack(NaturalisChocoMilk, 3), Item.glassBottle, Item.glassBottle, Item.glassBottle, NaturalisChocoBucket);
                GameRegistry.addShapelessRecipe(new ItemStack(NaturalisRottingBark0, 1), NaturalisBirchBark, Item.bucketWater);
                GameRegistry.addShapelessRecipe(new ItemStack(NaturalisTarBucket, 1), NaturalisRottingBark0, Item.bucketWater);

                // REMOVING VANILLA RECIPES.
                CraftingManager.getInstance().getRecipeList().remove(Item.book);
                CraftingManager.getInstance().getRecipeList().remove(Item.legsLeather);
                CraftingManager.getInstance().getRecipeList().remove(Item.bootsLeather);
                CraftingManager.getInstance().getRecipeList().remove(Item.helmetLeather);
                CraftingManager.getInstance().getRecipeList().remove(Item.plateLeather);
                CraftingManager.getInstance().getRecipeList().remove(Item.itemFrame);
                CraftingManager.getInstance().getRecipeList().remove(Item.bread);

                // ADDING RECIPES WITH LEATHER
                CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(Item.book, 1), Item.paper, Item.paper, Item.paper, "itemLeather"));
                CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(Item.legsLeather, 1), "XXX", "X X", "X X", 'X', "itemLeather"));
                CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(Item.bootsLeather, 1), "X X", "X X", 'X', "itemLeather"));
                CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(Item.helmetLeather, 1), "XXX", "X X", 'X', "itemLeather"));
                CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(Item.plateLeather, 1), "X X", "XXX", "XXX", 'X', "itemLeather"));
                CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(Item.itemFrame, 1), "***", "*X*", "***", 'X', "itemLeather", '*', "stickWood"));

            }
    }
