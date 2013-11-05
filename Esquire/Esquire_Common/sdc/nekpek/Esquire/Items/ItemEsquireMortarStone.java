package sdc.nekpek.Esquire.Items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemBlock;

public class ItemEsquireMortarStone extends ItemBlock
    {

        public ItemEsquireMortarStone(int par1)
            {
                super(par1);
            }

        @Override
        public void registerIcons(IconRegister par1IconRegister)
            {
                itemIcon = par1IconRegister.registerIcon("Esquire:StoneMortar");
            }

    }
