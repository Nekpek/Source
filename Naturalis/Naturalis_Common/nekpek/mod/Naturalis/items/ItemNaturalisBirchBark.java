package nekpek.mod.Naturalis.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemNaturalisBirchBark extends Item
    {
        public ItemNaturalisBirchBark(int par1)
            {
                super(par1);
            }

        @Override
        public void registerIcons(IconRegister iconRegister)
            {
                itemIcon = iconRegister.registerIcon("Naturalis:NaturalisBirchBark");
            }

        @Override
        public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par2List, boolean par4)
            {
                par2List.add("\u00a77" + "Looks like it contains string");
                par2List.add("\u00a77" + "Better rot off the excess bark");
            }
    }
