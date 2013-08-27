package sdc.nekpek.Esquire.Items;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import sdc.nekpek.Esquire.CreativeTabs.EsquireTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemEsquireSalt extends Item
    {
        public static final String[] SaltNames = new String[] { "Sea", "Rock", "Course" };
        public static final String[] field_94595_b = new String[] { "Sea", "Rock", "Course" };
        private Icon[] field_94594_d;

        public ItemEsquireSalt(int par1)
            {
                super(par1);

                this.setCreativeTab(EsquireTabs.EsquireTabItems);
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
                int j = MathHelper.clamp_int(par1, 0, 2);
                return this.field_94594_d[j];
            }

        @Override
        public String getUnlocalizedName(ItemStack par1ItemStack)
            {
                int i = MathHelper.clamp_int(par1ItemStack.getItemDamage(), 0, 2);
                return super.getUnlocalizedName() + SaltNames[i];
            }

        @Override
        @SideOnly(Side.CLIENT)
        public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List)
            {
                for (int j = 0; j < 3; ++j)
                    {
                        par3List.add(new ItemStack(par1, 1, j));
                    }
            }

        @Override
        @SideOnly(Side.CLIENT)
        public void registerIcons(IconRegister par1IconRegister)
            {
                this.field_94594_d = new Icon[field_94595_b.length];

                for (int i = 0; i < field_94595_b.length; ++i)
                    {
                        this.field_94594_d[i] = par1IconRegister.registerIcon("Esquire:" + field_94595_b[i] + "Salt");
                    }
            }
    }
