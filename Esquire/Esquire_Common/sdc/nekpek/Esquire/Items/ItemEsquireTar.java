package sdc.nekpek.Esquire.Items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import sdc.nekpek.Esquire.CreativeTabs.EsquireTabs;

public class ItemEsquireTar extends Item
    {

        public ItemEsquireTar(int par1)
            {
                super(par1);
                setCreativeTab(EsquireTabs.EsquireTabItems);
            }

        @Override
        public void registerIcons(IconRegister par1IconRegister)
            {
                itemIcon = par1IconRegister.registerIcon("Esquire:Tar");
            }

    }
