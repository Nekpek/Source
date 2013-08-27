package sdc.nekpek.Esquire.Items;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import sdc.nekpek.Esquire.CreativeTabs.EsquireTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemEsquireSushi extends ItemFood
    {
        public static final String[] SaltNames = new String[] { "Squid", "Fish" };
        public static final String[] field_94595_b = new String[] { "Squid", "Fish" };
        private Icon[] field_94594_d;

        public ItemEsquireSushi(int par1, int par2, float par3, boolean par4)
            {
                super(par1, par2, par3, par4);
                setHasSubtypes(true);
                setMaxDamage(0);
                setCreativeTab(EsquireTabs.EsquireTabItems);
            }

        @Override
        @SideOnly(Side.CLIENT)
        /**
         * Gets an icon index based on an item's damage value
         */
        public Icon getIconFromDamage(int par1)
            {
                int j = MathHelper.clamp_int(par1, 0, 1);
                return this.field_94594_d[j];
            }

        @Override
        public String getUnlocalizedName(ItemStack par1ItemStack)
            {
                int i = MathHelper.clamp_int(par1ItemStack.getItemDamage(), 0, 1);
                return super.getUnlocalizedName() + SaltNames[i];
            }

        @Override
        @SideOnly(Side.CLIENT)
        public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List)
            {
                for (int j = 0; j < 2; ++j)
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
                        this.field_94594_d[i] = par1IconRegister.registerIcon("Esquire:" + field_94595_b[i] + "Sushi");
                    }
            }

    }
