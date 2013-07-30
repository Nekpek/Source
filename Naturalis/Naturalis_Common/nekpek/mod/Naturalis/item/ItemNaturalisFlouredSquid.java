package nekpek.mod.Naturalis.item;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemNaturalisFlouredSquid extends Item
    {

        public ItemNaturalisFlouredSquid(int par1)
            {
                super(par1);
            }

        @Override
        public void registerIcons(IconRegister iconRegister)
            {
                itemIcon = iconRegister.registerIcon("Naturalis:NaturalisFlouredSquid");
            }

        @Override
        public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par2List, boolean par4)
            {
                par2List.add("\u00a77" + "Raw, perhaps i should cook this");
            }

    }
