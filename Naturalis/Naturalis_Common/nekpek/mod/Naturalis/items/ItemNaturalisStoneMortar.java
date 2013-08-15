package nekpek.mod.Naturalis.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class ItemNaturalisStoneMortar extends Item
    {

        public ItemNaturalisStoneMortar(int par1)
            {
                super(par1);
                maxStackSize = 1;
                this.setMaxDamage(32);
            }

        @Override
        public void registerIcons(IconRegister iconRegister)
            {
                itemIcon = iconRegister.registerIcon("Naturalis:NaturalisStoneMortar");

            }

    }
