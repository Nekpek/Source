package nekpek.mod.Naturalis.common;

import nekpek.mod.Naturalis.block.TileEntityNaturalisFurnace;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler
    {

        @Override
        public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
            {
                TileEntity tile_entity = world.getBlockTileEntity(x, y, z);

                if (tile_entity instanceof TileEntityNaturalisFurnace)
                    {
                        return new NaturalisContainerPowerFurnace(player.inventory, (TileEntityNaturalisFurnace) tile_entity);
                    }

                return null;
            }

        @Override
        public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
            {
                TileEntity tile_entity = world.getBlockTileEntity(x, y, z);

                if (tile_entity instanceof TileEntityNaturalisFurnace)
                    {
                        return new NaturalisGuiFurnace(player.inventory, (TileEntityNaturalisFurnace) tile_entity);
                    }

                return null;
            }

    }
