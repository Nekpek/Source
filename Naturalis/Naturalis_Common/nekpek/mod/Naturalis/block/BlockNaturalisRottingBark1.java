package nekpek.mod.Naturalis.block;

import java.util.Random;

import nekpek.mod.Naturalis.common.Naturalis;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.world.World;

public class BlockNaturalisRottingBark1 extends Block
    {
        public BlockNaturalisRottingBark1(int par1, Material par2Material)
            {
                super(par1, par2Material);
                this.setBlockBounds(0.035F, 0.0F, 0.15F, 0.965F, 0.07F, 0.85F);
            }

        @Override
        public void registerIcons(IconRegister iconRegister)
            {
                blockIcon = iconRegister.registerIcon("Naturalis:NaturalisRottingBark1");
            }

        @Override
        public void onBlockAdded(World world, int x, int y, int z)
            {
                world.scheduleBlockUpdate(x, y, z, blockID, 6000);
            }

        @Override
        public void updateTick(World world, int x, int y, int z, Random par5Random)
            {
                world.setBlock(x, y, z, Naturalis.NaturalisRottingBark2.blockID);
            }

        @Override
        public boolean renderAsNormalBlock()
            {
                return false;
            }

        @Override
        public boolean isOpaqueCube()
            {
                return false;
            }
    }
