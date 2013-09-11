package sdc.nekpek.Esquire.Items;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import sdc.nekpek.Esquire.Blocks.BlockEsquireHerbs;
import sdc.nekpek.Esquire.CreativeTabs.EsquireTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemEsquireHerbLeaf extends Item
    {

        private int HerbAmounts = BlockEsquireHerbs.HerbAmounts;
        private Icon[] field_94594_d;

        public ItemEsquireHerbLeaf(int par1)
            {
                super(par1);
                this.setCreativeTab(EsquireTabs.EsquireTabHerbs);
                this.setHasSubtypes(true);
                this.setMaxDamage(0);
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

        @Override
        public String getUnlocalizedName(ItemStack par1ItemStack)
            {
                int i = MathHelper.clamp_int(par1ItemStack.getItemDamage(), 0, HerbAmounts - 1);
                return super.getUnlocalizedName() + BlockEsquireHerbs.HerbType[i];
            }

        @Override
        @SideOnly(Side.CLIENT)
        public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List)
            {
                for (int j = 0; j < HerbAmounts; ++j)
                    {
                        par3List.add(new ItemStack(par1, 1, j));
                    }
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

    }
