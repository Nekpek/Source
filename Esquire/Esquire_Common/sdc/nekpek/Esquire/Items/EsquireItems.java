package sdc.nekpek.Esquire.Items;

import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class EsquireItems
    {
        public static Item EsquireSalt = new ItemEsquireSalt(2300).setUnlocalizedName("EsquireSalt");
        public static Item EsquireBucketSalt = new ItemEsquireBucketSalt(2301).setUnlocalizedName("EsquireBucketSalt");
        public static Item EsquireLeather = new ItemEsquireLeather(2302).setUnlocalizedName("EsquireLeather");
        public static Item EsquireScraper = new itemEsquireScraper(2303, EnumToolMaterial.IRON).setUnlocalizedName("EsquireScraper");
        public static Item EsquireBark = new ItemEsquireBark(2304).setUnlocalizedName("EsquireBark");
        public static Item EsquireCork = new ItemEsquireCork(2305).setUnlocalizedName("EsquireCork");
        public static Item EsquireSaltedMeat = new ItemEsquireSaltedMeat(2306, 5, 0.2F, true).setUnlocalizedName("EsquireSaltedMeat");
        public static Item EsquireChocoBucket = new ItemEsquireChocoBucket(2307).setUnlocalizedName("EsquireChocoBucket");
        public static Item EsquireChocoMilk = new ItemEsquireChocoMilk(2308, 3, 0.5f, false).setUnlocalizedName("EsquireChocoMilk");
        public static Item EsquireBastFibre = new ItemEsquireBastFibre(2309).setUnlocalizedName("EsquireBastFibre");
        public static Item EsquireTarBucket = new ItemEsquireTarBucket(2310).setUnlocalizedName("EsquireTarBucket");
        public static Item EsquireTar = new ItemEsquireTar(2311).setUnlocalizedName("EsquireTar");
        public static Item EsquireRawSquid = new ItemEsquireRawSquid(2313, 3, 0.4f, true).setUnlocalizedName("EsquireSquid");
        public static Item EsquireBreadedSquid = new ItemEsquireBreadedSquid(2314).setUnlocalizedName("EsquireBreadedSquid");
        public static Item EsquireFriedSquid = new ItemEsquireFriedSquid(2315, 9, 0.9f, true).setUnlocalizedName("EsquireFriedSquid");
        public static Item EsquireSushi = new ItemEsquireSushi(2316, 8, 0.8f, true).setUnlocalizedName("EsquireSuidSushi");
        public static Item EsquireNoriSheet = new ItemEsquireNoriSheet(2317).setUnlocalizedName("EsquireNoriSheet");
        public static Item EsquireFlour = new ItemEsquireFlour(2318).setUnlocalizedName("EsquireFlour");
        public static Item EsquireDough = new ItemEsquireDough(2319).setUnlocalizedName("EsquireDough");
        public static Item EsquireWoodPestle = new ItemEsquireWoodPestle(2320).setUnlocalizedName("EsquireWoodPestle");
        public static Item EsquireStonePestle = new ItemEsquireStonePestle(2321).setUnlocalizedName("EsquireStonePestle");

        public static void ItemNames()
            {

                LanguageRegistry.addName(EsquireBucketSalt, "Bucket of Sea Salt");
                LanguageRegistry.addName(new ItemStack(EsquireSalt, 1, 0), "Sea Salt");
                LanguageRegistry.addName(new ItemStack(EsquireSalt, 1, 1), "Rock Salt");
                LanguageRegistry.addName(new ItemStack(EsquireSalt, 1, 2), "Course Rock Salt");
                LanguageRegistry.addName(EsquireLeather, "Cork Leather");
                LanguageRegistry.addName(EsquireScraper, "Long Handled Hatchet");
                LanguageRegistry.addName(new ItemStack(EsquireBark, 1, 0), "Oak Bark");
                LanguageRegistry.addName(new ItemStack(EsquireBark, 1, 1), "Spruce Bark");
                LanguageRegistry.addName(new ItemStack(EsquireBark, 1, 2), "Birch Bark");
                LanguageRegistry.addName(new ItemStack(EsquireBark, 1, 3), "Jungle Bark");
                LanguageRegistry.addName(EsquireCork, "Cork");
                LanguageRegistry.addName(new ItemStack(EsquireSaltedMeat, 1, 0), "Salted Beef");
                LanguageRegistry.addName(new ItemStack(EsquireSaltedMeat, 1, 1), "Salted Pork");
                LanguageRegistry.addName(EsquireChocoBucket, "Bucket of Chocomilk");
                LanguageRegistry.addName(EsquireChocoMilk, "Bottle of Chocomilk");
                LanguageRegistry.addName(EsquireBastFibre, "Bast Fibre");
                LanguageRegistry.addName(EsquireTarBucket, "Bucket of Birch");
                LanguageRegistry.addName(EsquireTar, "Tar");
                LanguageRegistry.addName(EsquireRawSquid, "Raw Squid");
                LanguageRegistry.addName(EsquireBreadedSquid, "Breaded Squid");
                LanguageRegistry.addName(EsquireFriedSquid, "Fried Squid");
                LanguageRegistry.addName(EsquireNoriSheet, "Nori Sheet");
                LanguageRegistry.addName(new ItemStack(EsquireSushi, 1, 0), "Squid Roll");
                LanguageRegistry.addName(new ItemStack(EsquireSushi, 1, 1), "Fish Roll");
                LanguageRegistry.addName(EsquireWoodPestle, "Wooden Pestle");
                LanguageRegistry.addName(EsquireStonePestle, "Stone Pestle");
                LanguageRegistry.addName(EsquireDough, "Dough");
                LanguageRegistry.addName(EsquireFlour, "Flour");

            }
    }
