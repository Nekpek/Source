package sdc.nekpek.Esquire.PoweredFurnace;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import sdc.nekpek.Esquire.Entities.EsquireFurnaceTileEntity;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EsquirePowerFurnaceContainer extends Container
    {
        private final EsquireFurnaceTileEntity furnace;
        private int lastCookTime;
        private int lastBurnTime;
        private int lastItemBurnTime;

        public EsquirePowerFurnaceContainer(InventoryPlayer par1InventoryPlayer, EsquireFurnaceTileEntity par2TileEntityFurnace)
            {
                this.furnace = par2TileEntityFurnace;
                this.addSlotToContainer(new Slot(par2TileEntityFurnace, 0, 56, 17));
                this.addSlotToContainer(new Slot(par2TileEntityFurnace, 3, 20, 17));
                this.addSlotToContainer(new EsquireFurnaceSlots(par1InventoryPlayer.player, par2TileEntityFurnace, 2, 116, 22));
                this.addSlotToContainer(new EsquireFurnaceSlots(par1InventoryPlayer.player, par2TileEntityFurnace, 4, 116, 48));
                int i;

                for (i = 0; i < 3; ++i)
                    {
                        for (int j = 0; j < 9; ++j)
                            {
                                this.addSlotToContainer(new Slot(par1InventoryPlayer, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
                            }
                    }

                for (i = 0; i < 9; ++i)
                    {
                        this.addSlotToContainer(new Slot(par1InventoryPlayer, i, 8 + i * 18, 142));
                    }
            }

        @Override
        public void addCraftingToCrafters(ICrafting par1ICrafting)
            {
                super.addCraftingToCrafters(par1ICrafting);
                par1ICrafting.sendProgressBarUpdate(this, 0, this.furnace.furnaceCookTime);
                par1ICrafting.sendProgressBarUpdate(this, 1, this.furnace.furnaceBurnTime);
                par1ICrafting.sendProgressBarUpdate(this, 2, this.furnace.currentItemBurnTime);
                par1ICrafting.sendProgressBarUpdate(this, 3, this.furnace.furnaceCookTime);
            }

        /**
         * Looks for changes made in the container, sends them to every
         * listener.
         */
        @Override
        public void detectAndSendChanges()
            {
                super.detectAndSendChanges();

                for (int i = 0; i < this.crafters.size(); ++i)
                    {
                        ICrafting icrafting = (ICrafting) this.crafters.get(i);

                        if (this.lastCookTime != this.furnace.furnaceCookTime)
                            {
                                icrafting.sendProgressBarUpdate(this, 0, this.furnace.furnaceCookTime);
                            }
                        if (this.lastCookTime != this.furnace.furnaceCookTime)
                            {
                                icrafting.sendProgressBarUpdate(this, 3, this.furnace.furnaceCookTime);
                            }
                        if (this.lastBurnTime != this.furnace.furnaceBurnTime)
                            {
                                icrafting.sendProgressBarUpdate(this, 1, this.furnace.furnaceBurnTime);
                            }

                        if (this.lastItemBurnTime != this.furnace.currentItemBurnTime)
                            {
                                icrafting.sendProgressBarUpdate(this, 2, this.furnace.currentItemBurnTime);
                            }
                    }

                this.lastCookTime = this.furnace.furnaceCookTime;
                this.lastBurnTime = this.furnace.furnaceBurnTime;
                this.lastItemBurnTime = this.furnace.currentItemBurnTime;
            }

        @Override
        @SideOnly(Side.CLIENT)
        public void updateProgressBar(int par1, int par2)
            {
                if (par1 == 0)
                    {
                        this.furnace.furnaceCookTime = par2;
                    }

                if (par1 == 1)
                    {
                        this.furnace.furnaceBurnTime = par2;
                    }

                if (par1 == 2)
                    {
                        this.furnace.currentItemBurnTime = par2;
                    }
            }

        @Override
        public boolean canInteractWith(EntityPlayer par1EntityPlayer)
            {
                return this.furnace.isUseableByPlayer(par1EntityPlayer);
            }

        /**
         * Called when a player shift-clicks on a slot. You must override this
         * or you will crash when someone does that.
         */
        @Override
        public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2)
            {

                return null;
            }
    }
