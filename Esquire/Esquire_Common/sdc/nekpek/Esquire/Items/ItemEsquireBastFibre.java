package sdc.nekpek.Esquire.Items;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import sdc.nekpek.Esquire.CreativeTabs.EsquireTabs;

public class ItemEsquireBastFibre extends Item
    {

        public ItemEsquireBastFibre(int par1)
            {
                super(par1);
                setCreativeTab(EsquireTabs.EsquireTabItems);
            }

        @Override
        public void registerIcons(IconRegister iconRegister)
            {
                itemIcon = iconRegister.registerIcon("Esquire:BastFibre");

            }

        @Override
        public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par2List, boolean par4)
            {
                par2List.add("\u00a77" + "A weak string, combining it");
                par2List.add("\u00a77" + "might make a suitable String");
            }

    }
