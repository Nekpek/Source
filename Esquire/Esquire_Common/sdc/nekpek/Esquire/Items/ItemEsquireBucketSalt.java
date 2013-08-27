package sdc.nekpek.Esquire.Items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import sdc.nekpek.Esquire.CreativeTabs.EsquireTabs;

public class ItemEsquireBucketSalt extends Item
    {

        public ItemEsquireBucketSalt(int par1)
            {
                super(par1);
                this.setCreativeTab(EsquireTabs.EsquireTabItems);
                this.setContainerItem(Item.bucketEmpty);
            }

        @Override
        public void registerIcons(IconRegister par1IconRegister)
            {
                itemIcon = par1IconRegister.registerIcon("Esquire:BucketSalt");
            }
    }
