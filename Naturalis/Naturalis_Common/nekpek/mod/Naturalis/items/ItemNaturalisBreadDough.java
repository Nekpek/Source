package nekpek.mod.Naturalis.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class ItemNaturalisBreadDough extends Item
    {

        public ItemNaturalisBreadDough(int par1)
            {
                super(par1);
            }

        @Override
        public void registerIcons(IconRegister iconRegister)
            {
                itemIcon = iconRegister.registerIcon("Naturalis:NaturalisBreadDough");
            }

    }
