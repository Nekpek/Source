package nekpek.mod.Naturalis.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class ItemNaturalisWoodMortar extends Item
    {

        public ItemNaturalisWoodMortar(int par1)
            {
                super(par1);
                maxStackSize = 1;
                this.setMaxDamage(16);
            }

        @Override
        public void registerIcons(IconRegister iconRegister)
            {
                itemIcon = iconRegister.registerIcon("Naturalis:NaturalisWoodMortar");

            }

    }
