package sdc.nekpek.Esquire.Items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import sdc.nekpek.Esquire.Blocks.BlockEsquireHerbs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemEsquireHerbs extends ItemBlock
    {
        private int HerbAmounts = BlockEsquireHerbs.HerbAmounts;
        private Icon[] field_94594_d;

        public ItemEsquireHerbs(int par1)
            {
                super(par1);
                setHasSubtypes(true);
            }

        @Override
        public String getUnlocalizedName(ItemStack itemstack)
            {
                int i = MathHelper.clamp_int(itemstack.getItemDamage(), 0, BlockEsquireHerbs.HerbAmounts - 1);
                return super.getUnlocalizedName() + BlockEsquireHerbs.HerbType[i];
            }

        @Override
        public int getMetadata(int par1)
            {
                return par1;
            }

        @Override
        @SideOnly(Side.CLIENT)
        public void registerIcons(IconRegister par1IconRegister)
            {
                this.field_94594_d = new Icon[HerbAmounts];

                for (int i = 0; i < HerbAmounts; ++i)
                    {
                        this.field_94594_d[i] = par1IconRegister.registerIcon("Esquire:" + BlockEsquireHerbs.HerbType[i]);
                    }
            }

        @Override
        @SideOnly(Side.CLIENT)
        /**
         * Gets an icon index based on an item's damage value
         */
        public Icon getIconFromDamage(int par1)
            {
                int j = MathHelper.clamp_int(par1, 0, HerbAmounts - 1);
                return this.field_94594_d[j];
            }
    }
