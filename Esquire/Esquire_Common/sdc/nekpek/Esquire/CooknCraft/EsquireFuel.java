package sdc.nekpek.Esquire.CooknCraft;

import net.minecraft.item.ItemStack;
import sdc.nekpek.Esquire.Items.EsquireItems;
import cpw.mods.fml.common.IFuelHandler;

public class EsquireFuel implements IFuelHandler
    {

        @Override
        public int getBurnTime(ItemStack fuel)
            {
                if (fuel.itemID == EsquireItems.EsquireTar.itemID)
                    {
                        return 3200;
                    }
                if (fuel.itemID == EsquireItems.EsquireBark.itemID)
                    {
                        return 300;
                    }
                return 0;

            }
    }
