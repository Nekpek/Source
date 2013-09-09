package sdc.nekpek.Esquire.Items;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemEsquireHerbs extends ItemBlock
    {

        public ItemEsquireHerbs(int par1)
            {
                super(par1);
                setHasSubtypes(true);
            }

        @Override
        public String getUnlocalizedName(ItemStack itemstack)
            {
                String name = "";
                switch (itemstack.getItemDamage()) {
                    case 0:
                        {
                            name = "BlackSunFlower";
                            break;
                        }
                    case 1:
                        {
                            name = "SnowyMist";
                            break;
                        }
                    default:
                        name = "broken";
                }
                return getUnlocalizedName() + "." + name;
            }

        @Override
        public int getMetadata(int par1)
            {
                return par1;
            }
    }
