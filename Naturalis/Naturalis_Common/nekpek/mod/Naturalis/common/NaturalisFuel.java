package nekpek.mod.Naturalis.common;

import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.IFuelHandler;

public class NaturalisFuel implements IFuelHandler
    {

        @Override
        public int getBurnTime(ItemStack fuel)
            {
                if (fuel.itemID == Naturalis.NaturalisTar.itemID)
                    {
                        return 3200;
                    }
                else
                    {
                        return 0;
                    }
            }

    }
