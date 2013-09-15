package sdc.nekpek.Esquire.CooknCraft;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import sdc.nekpek.Esquire.Blocks.BlockEsquireHerbs;
import sdc.nekpek.Esquire.Blocks.EsquireBlocks;
import sdc.nekpek.Esquire.Items.EsquireItems;
import cpw.mods.fml.common.registry.GameRegistry;

public class EsquireCooknCrafts
    {
        public static void OreDic()
            {
                OreDictionary.registerOre("itemLeather", EsquireItems.EsquireLeather);
                OreDictionary.registerOre("itemLeather", Item.leather);
                OreDictionary.registerOre("itemSalt", new ItemStack(EsquireItems.EsquireSalt, 1, 0));
                OreDictionary.registerOre("itemSalt", new ItemStack(EsquireItems.EsquireSalt, 1, 1));
                OreDictionary.registerOre("dyeBlack", EsquireItems.EsquireTar);
            }

        public static void Cookings()
            {
                GameRegistry.addSmelting(Item.bucketWater.itemID, new ItemStack(EsquireItems.EsquireBucketSalt), 0.1f);
                GameRegistry.addSmelting(EsquireItems.EsquireTarBucket.itemID, new ItemStack(EsquireItems.EsquireTar, 4), 0.1f);
                GameRegistry.addSmelting(EsquireItems.EsquireBreadedSquid.itemID, new ItemStack(EsquireItems.EsquireFriedSquid, 1), 0.1f);
                GameRegistry.addSmelting(EsquireItems.EsquireDough.itemID, new ItemStack(Item.bread, 1), 0.1f);

            }

        public static void Craftings()
            {
                GameRegistry.addRecipe(new ItemStack(EsquireItems.EsquireSalt, 4, 0), new Object[] { "X", 'X', EsquireItems.EsquireBucketSalt });
                GameRegistry.addRecipe(new ItemStack(EsquireItems.EsquireScraper, 1), new Object[] { "Y", "X", "*", 'Y', Item.ingotIron, 'X', Item.axeIron, '*', Item.stick });
                GameRegistry.addRecipe(new ItemStack(Block.planks, 2, 0), new Object[] { "X", 'X', new ItemStack(EsquireBlocks.EsquireLogBare, 1, 0) });
                GameRegistry.addRecipe(new ItemStack(Block.planks, 2, 1), new Object[] { "X", 'X', new ItemStack(EsquireBlocks.EsquireLogBare, 1, 1) });
                GameRegistry.addRecipe(new ItemStack(Block.planks, 2, 2), new Object[] { "X", 'X', new ItemStack(EsquireBlocks.EsquireLogBare, 1, 2) });
                GameRegistry.addRecipe(new ItemStack(Block.planks, 2, 3), new Object[] { "X", 'X', new ItemStack(EsquireBlocks.EsquireLogBare, 1, 3) });
                GameRegistry.addRecipe(new ItemStack(EsquireItems.EsquireLeather, 1), new Object[] { "XXX", "X*X", "XXX", 'X', EsquireItems.EsquireCork, '*', Item.silk });
                GameRegistry.addRecipe(new ItemStack(EsquireItems.EsquireCork, 4), new Object[] { "X", 'X', new ItemStack(EsquireItems.EsquireBark, 1, 0) });
                GameRegistry.addRecipe(new ItemStack(Item.silk, 1), new Object[] { "X", "X", "X", 'X', EsquireItems.EsquireBastFibre });
                GameRegistry.addRecipe(new ItemStack(Block.torchWood, 4), new Object[] { "X", "*", 'X', EsquireItems.EsquireTar, '*', Item.stick });
                GameRegistry.addRecipe(new ItemStack(EsquireItems.EsquireBreadedSquid, 1), new Object[] { "X*X", 'X', EsquireItems.EsquireDough, '*', EsquireItems.EsquireRawSquid });
                GameRegistry.addRecipe(new ItemStack(EsquireBlocks.EsquirePowerFurnaceIdle, 1), new Object[] { "IRI", "LFT", "IBI", 'I', Block.blockIron, 'R', Block.blockRedstone, 'L', Block.lever, 'F', Block.furnaceIdle, 'T', Block.torchRedstoneActive, 'B', Item.blazeRod });
                GameRegistry.addRecipe(new ItemStack(EsquireItems.EsquireSushi, 1, 0), new Object[] { "NQN", 'N', EsquireItems.EsquireNoriSheet, 'Q', EsquireItems.EsquireRawSquid });
                GameRegistry.addRecipe(new ItemStack(EsquireItems.EsquireSushi, 1, 1), new Object[] { "NQN", 'N', EsquireItems.EsquireNoriSheet, 'Q', Item.fishRaw });
                GameRegistry.addRecipe(new ItemStack(EsquireItems.EsquireNoriSheet, 9), new Object[] { "SSS", 'S', EsquireBlocks.EsquireSeaWeed });
                /*
                 * using another type of loading a recipe because i use
                 * oreDictionary as an item reference.
                 */
                CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(EsquireItems.EsquireSaltedMeat, 1, 1), Item.porkRaw, "itemSalt"));
                CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(EsquireItems.EsquireSaltedMeat, 1, 0), Item.beefRaw, "itemSalt"));
                CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(EsquireItems.EsquireDough, 5), EsquireItems.EsquireFlour, Item.bucketWater, "itemSalt"));

                // ADDING SHAPELESS RECIPIES
                GameRegistry.addShapelessRecipe(new ItemStack(EsquireItems.EsquireChocoBucket, 1), Item.sugar, new ItemStack(Item.dyePowder, 1, 3), Item.bucketMilk);
                GameRegistry.addShapelessRecipe(new ItemStack(EsquireItems.EsquireChocoMilk, 3), Item.glassBottle, Item.glassBottle, Item.glassBottle, EsquireItems.EsquireChocoBucket);
                GameRegistry.addShapelessRecipe(new ItemStack(EsquireBlocks.EsquireRottingBark0, 1), new ItemStack(EsquireItems.EsquireBark, 1, 2), Item.bucketWater);
                GameRegistry.addShapelessRecipe(new ItemStack(EsquireItems.EsquireTarBucket, 1), EsquireBlocks.EsquireRottingBark0, Item.bucketWater);

                // SINGLE INGREDIENT POTIONS
                GameRegistry.addShapelessRecipe(new ItemStack(EsquireItems.EsquirePotions, 1, 0), new ItemStack(EsquireItems.EsquireHerbPowder, 1, 0), Item.potion);
                GameRegistry.addShapelessRecipe(new ItemStack(EsquireItems.EsquirePotions, 1, 1), new ItemStack(EsquireItems.EsquireHerbPowder, 1, 1), Item.potion);
                // DUEL INGREDIENT POTIONS
                // Potion 1: START :
                GameRegistry.addShapelessRecipe(new ItemStack(EsquireItems.EsquirePotions, 1, 2), new ItemStack(EsquireItems.EsquireHerbPowder, 1, 0), new ItemStack(EsquireItems.EsquireHerbPowder, 1, 1), Item.potion);
                GameRegistry.addShapelessRecipe(new ItemStack(EsquireItems.EsquirePotions, 1, 2), new ItemStack(EsquireItems.EsquirePotions, 1, 0), new ItemStack(EsquireItems.EsquireHerbPowder, 1, 1));
                GameRegistry.addShapelessRecipe(new ItemStack(EsquireItems.EsquirePotions, 1, 2), new ItemStack(EsquireItems.EsquireHerbPowder, 1, 0), new ItemStack(EsquireItems.EsquirePotions, 1, 1));
                // Potion 1: END :

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
                // ADDING WOOD MORTAR RECIPE'S (SAME AS STONE JUST WITH WOOD)
                CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(EsquireItems.EsquireWoodPestle, 1), "  X", " X ", "Y  ", 'X', "stickWood", 'Y', "plankWood"));
                for (int i = 0; i < EsquireItems.EsquireWoodPestle.getMaxDamage(); i++)
                    {
                        GameRegistry.addShapedRecipe(new ItemStack(EsquireItems.EsquireSalt, 3, 1), "X", "Y", "Z", 'X', new ItemStack(EsquireItems.EsquireWoodPestle, 1, i), 'Y', new ItemStack(EsquireItems.EsquireSalt, 1, 2), 'Z', Block.cobblestone);
                        GameRegistry.addShapedRecipe(new ItemStack(EsquireItems.EsquireFlour, 1), "X", "Y", "Z", 'X', new ItemStack(EsquireItems.EsquireWoodPestle, 1, i), 'Y', Item.wheat, 'Z', Block.cobblestone);
                        for (int i2 = 0; i2 < BlockEsquireHerbs.HerbAmounts; i2++)
                            {
                                GameRegistry.addShapedRecipe(new ItemStack(EsquireItems.EsquireHerbPowder, 1, i2), "X", "Y", "Z", 'X', new ItemStack(EsquireItems.EsquireWoodPestle, 1, i), 'Y', new ItemStack(EsquireItems.EsquireHerbLeaf, 1, i2), 'Z', Block.cobblestone);

                            }
                    }
                // ADDING STONE MORTAR RECIPE'S (SAME AS WOOD JUST WITH STONE)
                CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(EsquireItems.EsquireStonePestle, 1), "  X", " X ", "Y  ", 'X', "stickWood", 'Y', "plankWood"));
                for (int i = 0; i < EsquireItems.EsquireStonePestle.getMaxDamage(); i++)
                    {
                        GameRegistry.addShapedRecipe(new ItemStack(EsquireItems.EsquireSalt, 4, 1), "X", "Y", "Z", 'X', new ItemStack(EsquireItems.EsquireStonePestle, 1, i), 'Y', new ItemStack(EsquireItems.EsquireSalt, 1, 2), 'Z', Block.cobblestone);
                        GameRegistry.addShapedRecipe(new ItemStack(EsquireItems.EsquireFlour, 2), "X", "Y", "Z", 'X', new ItemStack(EsquireItems.EsquireStonePestle, 1, i), 'Y', Item.wheat, 'Z', Block.cobblestone);

                        for (int i2 = 0; i2 < BlockEsquireHerbs.HerbAmounts; i2++)
                            {
                                GameRegistry.addShapedRecipe(new ItemStack(EsquireItems.EsquireHerbPowder, 2, i2), "X", "Y", "Z", 'X', new ItemStack(EsquireItems.EsquireStonePestle, 1, i), 'Y', new ItemStack(EsquireItems.EsquireHerbLeaf, 1, i2), 'Z', Block.cobblestone);

                            }
                    }
            }
    }
