package sdc.nekpek.Esquire.CreativeTabs;

import net.minecraft.creativetab.CreativeTabs;
import sdc.nekpek.Esquire.Items.EsquireItems;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EsquireTabItems extends CreativeTabs
    {

        public EsquireTabItems(int par1, String par2Str)
            {
                super(par1, par2Str);
            }

        @Override
        @SideOnly(Side.CLIENT)
        public int getTabIconItemIndex()
            {
                return EsquireItems.EsquireCork.itemID;
            }

        @Override
        public String getTranslatedTabLabel()
            {
                return "Esquire Items";
            }
    }
