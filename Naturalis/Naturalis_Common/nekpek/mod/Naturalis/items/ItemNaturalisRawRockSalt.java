package nekpek.mod.Naturalis.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class ItemNaturalisRawRockSalt extends Item
    {

        public ItemNaturalisRawRockSalt(int par1)
            {
                super(par1);
            }

        @Override
        public void registerIcons(IconRegister iconRegister)
            {
                itemIcon = iconRegister.registerIcon("Naturalis:NaturalisRawRockSalt");
            }

    }
