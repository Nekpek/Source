package nekpek.mod.Naturalis.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemFood;

public class ItemNaturalisSaltedPork extends ItemFood
    {
        public ItemNaturalisSaltedPork(int par1, int par2, float par3, boolean par4)
            {
                super(par1, par2, par3, par4);
            }

        @Override
        public void registerIcons(IconRegister iconRegister)
            {
                itemIcon = iconRegister.registerIcon("Naturalis:NaturalisSaltedPork");
            }
    }