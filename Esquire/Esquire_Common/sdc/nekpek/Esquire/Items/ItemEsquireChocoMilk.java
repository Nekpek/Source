package sdc.nekpek.Esquire.Items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import sdc.nekpek.Esquire.CreativeTabs.EsquireTabs;

public class ItemEsquireChocoMilk extends ItemFood
    {

        public ItemEsquireChocoMilk(int par1, int par2, float par3, boolean par4)
            {
                super(par1, par2, par3, par4);
                setCreativeTab(EsquireTabs.EsquireTabItems);
                setMaxStackSize(9);
            }

        @Override
        public ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
            {
                if (!par3EntityPlayer.capabilities.isCreativeMode)
                    {
                        --par1ItemStack.stackSize;
                    }

                if (!par2World.isRemote)
                    {
                        par3EntityPlayer.curePotionEffects(par1ItemStack);
                    }

                par3EntityPlayer.getFoodStats().addStats(this);
                this.onFoodEaten(par1ItemStack, par2World, par3EntityPlayer);
                return par1ItemStack.stackSize <= -1 ? new ItemStack(Item.bucketEmpty) : par1ItemStack;
            }

        @Override
        public void registerIcons(IconRegister iconRegister)
            {
                itemIcon = iconRegister.registerIcon("Esquire:ChocoMilk");
            }

        @Override
        public EnumAction getItemUseAction(ItemStack par1ItemStack)
            {
                return EnumAction.drink;
            }

        @Override
        protected void onFoodEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
            {
                par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Item.glassBottle, 1));
            }

        @Override
        public int getMaxItemUseDuration(ItemStack par1ItemStack)
            {
                return 32;
            }

        @Override
        public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
            {
                par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
                return par1ItemStack;
            }
    }
