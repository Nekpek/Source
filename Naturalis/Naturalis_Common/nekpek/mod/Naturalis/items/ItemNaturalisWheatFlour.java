package nekpek.mod.Naturalis.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class ItemNaturalisWheatFlour extends Item
    {

        public ItemNaturalisWheatFlour(int par1)
            {
                super(par1);
            }

        @Override
        public void registerIcons(IconRegister iconRegister)
            {
                itemIcon = iconRegister.registerIcon("Naturalis:NaturalisWheatFlour");
            }

    }
