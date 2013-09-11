package sdc.nekpek.Esquire.CreativeTabs;

import net.minecraft.creativetab.CreativeTabs;
import sdc.nekpek.Esquire.Blocks.EsquireBlocks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EsquireTabBlocks extends CreativeTabs
    {

        public EsquireTabBlocks(int par1, String par2Str)
            {
                super(par1, par2Str);
            }

        @Override
        @SideOnly(Side.CLIENT)
        public int getTabIconItemIndex()
            {

                return EsquireBlocks.EsquirePowerFurnaceIdle.blockID;
            }

        @Override
        public String getTranslatedTabLabel()
            {
                return "Esquire Blocks";
            }
    }
