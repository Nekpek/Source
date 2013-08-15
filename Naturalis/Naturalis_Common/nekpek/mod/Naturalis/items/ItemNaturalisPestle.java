package nekpek.mod.Naturalis.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class ItemNaturalisPestle extends Item
    {

        public ItemNaturalisPestle(int par1)
            {
                super(par1);
                maxStackSize = 1;
            }

        @Override
        public void registerIcons(IconRegister iconRegister)
            {
                itemIcon = iconRegister.registerIcon("Naturalis:NaturalisPestle");

            }
    }
