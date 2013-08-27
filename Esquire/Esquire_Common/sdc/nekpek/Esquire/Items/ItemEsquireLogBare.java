package sdc.nekpek.Esquire.Items;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemEsquireLogBare extends ItemBlock
    {

        public ItemEsquireLogBare(int par1)
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
                            name = "Oak";
                            break;
                        }
                    case 1:
                        {
                            name = "Spruce";
                            break;
                        }
                    case 2:
                        {
                            name = "Birch";
                            break;
                        }
                    case 3:
                        {
                            name = "Jungle";
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
