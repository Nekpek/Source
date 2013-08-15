package nekpek.mod.Naturalis.items;

import nekpek.mod.Naturalis.common.Naturalis;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class ItemNaturalisSalt extends Item
    {
        public ItemNaturalisSalt(int par1)
            {
                super(par1);
            }

        @Override
        public void registerIcons(IconRegister iconRegister)
            {
                if (this.itemID == Naturalis.NaturalisSalt.itemID)
                    {
                        itemIcon = iconRegister.registerIcon("Naturalis:NaturalisSalt");
                    }
                if (this.itemID == Naturalis.NaturalisSalt2.itemID)
                    {
                        itemIcon = iconRegister.registerIcon("Naturalis:NaturalisSalt2");
                    }
            }
    }
