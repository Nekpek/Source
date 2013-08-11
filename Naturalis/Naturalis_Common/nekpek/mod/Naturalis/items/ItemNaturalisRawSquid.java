package nekpek.mod.Naturalis.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;

public class ItemNaturalisRawSquid extends ItemFood
    {

        public ItemNaturalisRawSquid(int par1, int par2, float par3, boolean par4)
            {
                super(par1, par2, par3, par4);
            }

        @Override
        public void registerIcons(IconRegister iconRegister)
            {
                itemIcon = iconRegister.registerIcon("Naturalis:NaturalisRawSquid");
            }

        @Override
        public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par2List, boolean par4)
            {
                par2List.add("\u00a77" + "Adding breading or seaweed");
                par2List.add("\u00a77" + "should do all the tricks");
            }
    }
