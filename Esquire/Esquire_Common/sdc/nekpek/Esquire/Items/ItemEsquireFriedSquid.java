package sdc.nekpek.Esquire.Items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemFood;
import sdc.nekpek.Esquire.CreativeTabs.EsquireTabs;

public class ItemEsquireFriedSquid extends ItemFood
    {

        public ItemEsquireFriedSquid(int par1, int par2, float par3, boolean par4)
            {
                super(par1, par2, par3, par4);
                setCreativeTab(EsquireTabs.EsquireTabItems);
            }

        @Override
        public void registerIcons(IconRegister iconRegister)
            {
                itemIcon = iconRegister.registerIcon("Esquire:CookedSquid");

            }
    }
