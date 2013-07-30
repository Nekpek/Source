package nekpek.mod.Naturalis.Tabs;

import nekpek.mod.Naturalis.common.Naturalis;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class NaturalisTabBlocks extends CreativeTabs
    {
        public NaturalisTabBlocks(int position, String tabID)
            {
                super(position, tabID);
            }

        @Override
        @SideOnly(Side.CLIENT)
        public int getTabIconItemIndex()
            {
                return Naturalis.NaturalisOakBare.blockID;
            }

        @Override
        public String getTranslatedTabLabel()
            {
                return "Naturalis Block";
            }
    }