package sdc.nekpek.Esquire.Items;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import sdc.nekpek.Esquire.CreativeTabs.EsquireTabs;

public class ItemEsquireChocoBucket extends Item
    {

        public ItemEsquireChocoBucket(int par1)
            {
                super(par1);
                setCreativeTab(EsquireTabs.EsquireTabItems);
                setMaxStackSize(1);
                setContainerItem(Item.bucketEmpty);
            }

        @Override
        public void registerIcons(IconRegister par1IconRegister)
            {
                itemIcon = par1IconRegister.registerIcon("Esquire:ChocoBucket");
            }

        @Override
        public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par2List, boolean par4)
            {
                par2List.add("\u00a77" + "To much to drink at once");
                par2List.add("\u00a77" + "must split it up in bottles");
            }
    }
