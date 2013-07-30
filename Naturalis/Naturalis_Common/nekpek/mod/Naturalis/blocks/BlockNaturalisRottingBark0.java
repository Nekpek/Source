package nekpek.mod.Naturalis.blocks;

import java.util.Random;

import nekpek.mod.Naturalis.common.Naturalis;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.world.World;

public class BlockNaturalisRottingBark0 extends Block
    {
        public BlockNaturalisRottingBark0(int par1, Material par2Material)
            {
                super(par1, par2Material);
                this.setBlockBounds(0.035F, 0.0F, 0.15F, 0.965F, 0.07F, 0.85F);
            }

        @Override
        public void registerIcons(IconRegister iconRegister)
            {
                blockIcon = iconRegister.registerIcon("Naturalis:NaturalisRottingBark0");
            }

        @Override
        public void onBlockAdded(World world, int x, int y, int z)
            {
                world.scheduleBlockUpdate(x, y, z, blockID, 6000);
            }

        @Override
        public void updateTick(World world, int x, int y, int z, Random par5Random)
            {
                world.setBlock(x, y, z, Naturalis.NaturalisRottingBark1.blockID);
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

        @Override
        public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4)
            {
                int l = par1World.getBlockId(par2, par3 - 1, par4);
                Block block = Block.blocksList[l];

                if (block == null)
                    {
                        return false;
                    }

                if (block == this && (par1World.getBlockMetadata(par2, par3 - 1, par4) & 7) == 7)
                    {
                        return true;
                    }

                if (!block.isLeaves(par1World, par2, par3 - 1, par4) && !Block.blocksList[l].isOpaqueCube())
                    {
                        return false;
                    }

                return par1World.getBlockMaterial(par2, par3 - 1, par4).blocksMovement();
            }
    }
