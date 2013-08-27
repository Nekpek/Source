package sdc.nekpek.Esquire.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import sdc.nekpek.Esquire.CreativeTabs.EsquireTabs;
import sdc.nekpek.Esquire.Entities.EsquireFurnaceTileEntity;
import sdc.nekpek.Esquire.Items.ItemEsquireLogBare;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class EsquireBlocks
    {

        public static Block EsquireLogBare = new BlockEsquireLogBare(2100, Material.wood).setUnlocalizedName("EsquireLogBare");
        public static Block EsquireCorkWall = new BlockEsquireCorkWall(2101, null, null, Material.wood, false).setUnlocalizedName("EsquireCorkWall");
        public static Block EsquireRottingBark0 = new BlockEsquireRottingBark0(2102, Material.wood).setUnlocalizedName("EsquireRottingBark0");
        public static Block EsquireRottingBark1 = new BlockEsquireRottingBark1(2103, Material.wood).setUnlocalizedName("EsquireRottingBark1");
        public static Block EsquireRottingBark2 = new BlockEsquireRottingBark2(2104, Material.wood).setUnlocalizedName("EsquireRottingBark2");
        public static Block EsquireSaltOre = new BlockEsquireSaltOre(2105, Material.sand).setUnlocalizedName("EsquireSaltOre");
        public static Block EsquireSeaWeed = new BlockEsquireSeaWeed(2106, Material.water).setUnlocalizedName("EsquireSeaWeed");

        public static Block EsquirePowerFurnaceIdle = new BlockEsquirePowerFurnace(2107, false).setUnlocalizedName("EsquirePowerFurnaceIdle").setCreativeTab(EsquireTabs.EsquireTabBlocks);
        public static Block EsquirePowerFurnaceLit = new BlockEsquirePowerFurnace(2108, true).setUnlocalizedName("EsquirePowerFurnaceLit");

        public static void Blocks()
            {

                MinecraftForge.setBlockHarvestLevel(EsquireLogBare, "axe", 0);
                GameRegistry.registerBlock(EsquireLogBare, ItemEsquireLogBare.class, "EsquireLogBare");

                MinecraftForge.setBlockHarvestLevel(EsquireCorkWall, "axe", 0);
                GameRegistry.registerBlock(EsquireCorkWall, "EsquireCorkWall");

                MinecraftForge.setBlockHarvestLevel(EsquireRottingBark0, "axe", 0);
                GameRegistry.registerBlock(EsquireRottingBark0, "EsquireRottingBark0");

                MinecraftForge.setBlockHarvestLevel(EsquireRottingBark1, null, 100);
                GameRegistry.registerBlock(EsquireRottingBark1, "EsquireRottingBark1");

                MinecraftForge.setBlockHarvestLevel(EsquireRottingBark2, "axe", 0);
                GameRegistry.registerBlock(EsquireRottingBark2, "EsquireRottingBark2");

                MinecraftForge.setBlockHarvestLevel(EsquireSaltOre, "shovel", 1);
                GameRegistry.registerBlock(EsquireSaltOre, "EsquireSaltOre");

                MinecraftForge.setBlockHarvestLevel(EsquireSeaWeed, null, 0);
                GameRegistry.registerBlock(EsquireSeaWeed, "EsquireSeaWeed");

                MinecraftForge.setBlockHarvestLevel(EsquirePowerFurnaceIdle, "pickaxe", 0);
                MinecraftForge.setBlockHarvestLevel(EsquirePowerFurnaceLit, "pickaxe", 0);
                GameRegistry.registerBlock(EsquirePowerFurnaceIdle, "EsquirePowerFurnaceIdle");
                GameRegistry.registerBlock(EsquirePowerFurnaceLit, "EsquirePowerFurnaceLit");
                GameRegistry.registerTileEntity(EsquireFurnaceTileEntity.class, "TileEntityNaturalisFurnace");

            }

        public static void BlockNames()
            {
                LanguageRegistry.addName(new ItemStack(EsquireLogBare, 1, 0), "Barkless Oak Log");
                LanguageRegistry.addName(new ItemStack(EsquireLogBare, 1, 1), "Barkless Spruce Log");
                LanguageRegistry.addName(new ItemStack(EsquireLogBare, 1, 2), "Barkless Birch Log");
                LanguageRegistry.addName(new ItemStack(EsquireLogBare, 1, 3), "Barkless Jungle Log");
                LanguageRegistry.addName(EsquireCorkWall, "Cork Wall");
                LanguageRegistry.addName(EsquireRottingBark0, "Rotting Bark");
                LanguageRegistry.addName(EsquireRottingBark1, "Rotting Bark MidTerm");
                LanguageRegistry.addName(EsquireRottingBark2, "Rotting Bark End");
                LanguageRegistry.addName(EsquireSaltOre, "Rock Salt");
                LanguageRegistry.addName(EsquireSeaWeed, "Sea Weed");
                LanguageRegistry.addName(EsquirePowerFurnaceIdle, "Powered Furnace");
                LanguageRegistry.addName(EsquirePowerFurnaceLit, "*Powered Furnace*");
            }
    }
