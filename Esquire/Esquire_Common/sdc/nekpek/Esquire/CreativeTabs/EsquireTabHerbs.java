package sdc.nekpek.Esquire.CreativeTabs;

import net.minecraft.creativetab.CreativeTabs;
import sdc.nekpek.Esquire.Blocks.EsquireBlocks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EsquireTabHerbs extends CreativeTabs
    {

        public EsquireTabHerbs(int par1, String par2Str)
            {
                super(par1, par2Str);
            }

        @Override
        @SideOnly(Side.CLIENT)
        public int getTabIconItemIndex()
            {

                return EsquireBlocks.EsquireHerbs.blockID;
            }

        @Override
        public String getTranslatedTabLabel()
            {
                return "Esquire Herbs";
            }
    }
