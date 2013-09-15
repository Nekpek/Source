package sdc.nekpek.Esquire.Items;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import sdc.nekpek.Esquire.CreativeTabs.EsquireTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemEsquirePotions extends ItemFood
    {

        public static final String[] PotionsType = new String[] { "Black Sun Flower", "Snowy Mist", "Black Mist" };
        private int PotionAmounts = this.PotionsType.length;
        private Icon[] iconArray;

        public ItemEsquirePotions(int itemID)
            {
                super(itemID, 0, 0F, false);
                this.maxStackSize = 1;
                this.setAlwaysEdible();
                this.setCreativeTab(EsquireTabs.EsquireTabItems);
                this.setHasSubtypes(true);

                setPotionEffect(Potion.invisibility.id, 5, 0, 1.0F);
            }

        @Override
        @SideOnly(Side.CLIENT)
        public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List)
            {
                for (int j = 0; j < PotionAmounts; ++j)
                    {
                        par3List.add(new ItemStack(par1, 1, j));
                    }
            }

        @Override
        public String getUnlocalizedName(ItemStack par1ItemStack)
            {
                int i = MathHelper.clamp_int(par1ItemStack.getItemDamage(), 0, PotionAmounts - 1);
                return super.getUnlocalizedName() + PotionsType[i];
            }

        @Override
        @SideOnly(Side.CLIENT)
        /**
         * Gets an icon index based on an item's damage value
         */
        public Icon getIconFromDamage(int par1)
            {
                int j = MathHelper.clamp_int(par1, 0, PotionAmounts - 1);
                return this.iconArray[j];
            }

        @Override
        @SideOnly(Side.CLIENT)
        public void registerIcons(IconRegister par1IconRegister)
            {
                this.iconArray = new Icon[PotionAmounts];

                for (int i = 0; i < PotionAmounts; ++i)
                    {
                        this.iconArray[i] = par1IconRegister.registerIcon("Esquire:" + PotionsType[i] + " Potion");
                    }
            }

        @Override
        public void onFoodEaten(ItemStack itemstack, World world, EntityPlayer player)
            {

                player.getFoodStats().addStats(this);
                world.playSoundAtEntity(player, "random.burp", 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
                this.addPotionEffects(itemstack, world, player);

                itemstack.stackSize = 0;
            }

        protected void addPotionEffects(ItemStack item, World world, EntityPlayer player)
            {

                if (item.isItemEqual(new ItemStack(EsquireItems.EsquirePotions, 1, 0)))
                    {
                        player.addPotionEffect(new PotionEffect(14, 60 * 20, 1, false));
                    }
                if (item.isItemEqual(new ItemStack(EsquireItems.EsquirePotions, 1, 1)))
                    {
                        player.addPotionEffect(new PotionEffect(16, 60 * 20, 1, false));
                    }
                if (item.isItemEqual(new ItemStack(EsquireItems.EsquirePotions, 1, 2)))
                    {
                        player.addPotionEffect(new PotionEffect(14, 60 * 20, 1, false));
                        player.addPotionEffect(new PotionEffect(16, 60 * 20, 1, false));
                    }
            }

        @Override
        public EnumAction getItemUseAction(ItemStack itemstack)
            {
                return EnumAction.drink;
            }

        @Override
        public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player)
            {
                player.setItemInUse(itemstack, this.getMaxItemUseDuration(itemstack));
                return itemstack;
            }

        @Override
        public boolean hasEffect(ItemStack itemstack)
            {
                return true;
            }

        @Override
        public void addInformation(ItemStack item, EntityPlayer player, List list, boolean par4)
            {
                if (item.isItemEqual(new ItemStack(EsquireItems.EsquirePotions, 1, 0)))
                    {
                        list.add("Invisibility");
                    }
                if (item.isItemEqual(new ItemStack(EsquireItems.EsquirePotions, 1, 1)))
                    {
                        list.add("Night Vision");
                    }
                if (item.isItemEqual(new ItemStack(EsquireItems.EsquirePotions, 1, 2)))
                    {
                        list.add("Invisibility");
                        list.add("Night Vision");
                    }
            }
    }
