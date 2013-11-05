package sdc.nekpek.Esquire.Gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import sdc.nekpek.Esquire.Blocks.EsquireBlocks;
import sdc.nekpek.Esquire.Entities.EsquireFurnaceTileEntity;
import sdc.nekpek.Esquire.Mortar.MortarContainer;
import sdc.nekpek.Esquire.Mortar.MortarGui;
import sdc.nekpek.Esquire.PoweredFurnace.EsquirePowerFurnaceContainer;
import sdc.nekpek.Esquire.PoweredFurnace.EsquirePowerFurnaceGui;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler
    {

        @Override
        public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
            {

                TileEntity tile_entity = world.getBlockTileEntity(x, y, z);
                switch (ID) {
                    case 0:
                        return new EsquirePowerFurnaceContainer(player.inventory, (EsquireFurnaceTileEntity) tile_entity);
                    case 1:
                        return ID == 1 && world.getBlockId(x, y, z) == EsquireBlocks.EsquireMortarStone.blockID ? new MortarContainer(player.inventory, world, x, y, z) : null;

                }
                return null;
            }

        @Override
        public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
            {
                TileEntity tile_entity = world.getBlockTileEntity(x, y, z);
                switch (ID) {
                    case 0:
                        return new EsquirePowerFurnaceGui(player.inventory, (EsquireFurnaceTileEntity) tile_entity);
                    case 1:
                        return ID == 1 && world.getBlockId(x, y, z) == EsquireBlocks.EsquireMortarStone.blockID ? new MortarGui(player.inventory, world, x, y, z) : null;
                }
                return null;
            }
    }
