package nekpek.mod.Naturalis.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class ItemNaturalisBucketSalt extends Item
    {
        public ItemNaturalisBucketSalt(int par1)
            {
                super(par1);
            }

        @Override
        public void registerIcons(IconRegister iconRegister)
            {
                itemIcon = iconRegister.registerIcon("Naturalis:NaturalisBucketSalt");
            }
    }
