package nekpek.mod.Naturalis.common;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.ICraftingHandler;

public class CraftingHandler implements ICraftingHandler
    {

        @Override
        public void onCrafting(EntityPlayer player, ItemStack item, IInventory craftMatrix)
            {
                for (int i = 0; i < craftMatrix.getSizeInventory(); i++) // Checks
                                                                         // all
                // the slots
                    {
                        if (craftMatrix.getStackInSlot(i) != null) // If there
                                                                   // is an item
                            {
                                ItemStack j = craftMatrix.getStackInSlot(i); // Gets
                                                                             // the
                                                                             // item
                                if (j.getItem() != null && j.getItem() == Naturalis.NaturalisStoneMortar)
                                    {
                                        ItemStack k = new ItemStack(Naturalis.NaturalisStoneMortar, 2, (j.getItemDamage() + 1));
                                        if (k.getItemDamage() >= k.getMaxDamage())
                                            {
                                                k.stackSize--;
                                            }
                                        craftMatrix.setInventorySlotContents(i, k);
                                    }
                                if (j.getItem() != null && j.getItem() == Naturalis.NaturalisWoodMortar)
                                    {
                                        ItemStack k = new ItemStack(Naturalis.NaturalisWoodMortar, 2, (j.getItemDamage() + 1));
                                        if (k.getItemDamage() >= k.getMaxDamage())
                                            {
                                                k.stackSize--;
                                            }
                                        craftMatrix.setInventorySlotContents(i, k);
                                    }
                                if (j.getItem() != null && j.getItem() == Naturalis.NaturalisPestle)
                                    {
                                        ItemStack k = new ItemStack(Naturalis.NaturalisPestle, 2);
                                        craftMatrix.setInventorySlotContents(i, k);
                                    }
                            }
                    }
            }

        @Override
        public void onSmelting(EntityPlayer player, ItemStack item)
            {

            }

    }
