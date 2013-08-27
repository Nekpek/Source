package sdc.nekpek.Esquire.Gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import sdc.nekpek.Esquire.Entities.EsquireFurnaceTileEntity;
import sdc.nekpek.Esquire.PoweredFurnace.EsquirePowerFurnaceContainer;
import sdc.nekpek.Esquire.PoweredFurnace.EsquirePowerFurnaceGui;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler
    {

        @Override
        public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
            {
                TileEntity tile_entity = world.getBlockTileEntity(x, y, z);

                if (tile_entity instanceof EsquireFurnaceTileEntity)
                    {
                        return new EsquirePowerFurnaceContainer(player.inventory, (EsquireFurnaceTileEntity) tile_entity);
                    }

                return null;
            }

        @Override
        public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
            {
                TileEntity tile_entity = world.getBlockTileEntity(x, y, z);

                if (tile_entity instanceof EsquireFurnaceTileEntity)
                    {
                        return new EsquirePowerFurnaceGui(player.inventory, (EsquireFurnaceTileEntity) tile_entity);
                    }

                return null;
            }

    }
