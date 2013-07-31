package nekpek.mod.Naturalis.Tabs;

import nekpek.mod.Naturalis.common.Naturalis;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class NaturalisTabItems extends CreativeTabs
    {
        public NaturalisTabItems(int position, String tabID)
            {
                super(position, tabID);
            }

        @Override
        @SideOnly(Side.CLIENT)
        public int getTabIconItemIndex()
            {
                return Naturalis.NaturalisCork.itemID;
            }

        @Override
        public String getTranslatedTabLabel()
            {
                return "Naturalis Items";
            }
    }