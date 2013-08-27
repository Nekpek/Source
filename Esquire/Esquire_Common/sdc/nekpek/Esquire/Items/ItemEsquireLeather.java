package sdc.nekpek.Esquire.Items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import sdc.nekpek.Esquire.CreativeTabs.EsquireTabs;

public class ItemEsquireLeather extends Item
    {

        public ItemEsquireLeather(int par1)
            {
                super(par1);
                this.setCreativeTab(EsquireTabs.EsquireTabItems);
            }

        @Override
        public void registerIcons(IconRegister iconRegister)
            {
                itemIcon = iconRegister.registerIcon("Esquire:Leather");
            }
    }
