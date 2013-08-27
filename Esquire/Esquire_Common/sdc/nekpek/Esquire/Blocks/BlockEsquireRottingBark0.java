package sdc.nekpek.Esquire.Blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.world.World;
import sdc.nekpek.Esquire.CreativeTabs.EsquireTabs;

public class BlockEsquireRottingBark0 extends Block
    {
        public BlockEsquireRottingBark0(int par1, Material par2Material)
            {
                super(par1, par2Material);
                this.setBlockBounds(0.035F, 0.0F, 0.15F, 0.965F, 0.07F, 0.85F);
                setHardness(2.0f);
                setStepSound(Block.soundWoodFootstep);
                setCreativeTab(EsquireTabs.EsquireTabBlocks);
            }

        @Override
        public void registerIcons(IconRegister iconRegister)
            {
                blockIcon = iconRegister.registerIcon("Esquire:RottingBark0");
            }

        @Override
        public void onBlockAdded(World world, int x, int y, int z)
            {
                world.scheduleBlockUpdate(x, y, z, blockID, 6000);
            }

        @Override
        public void updateTick(World world, int x, int y, int z, Random par5Random)
            {
                world.setBlock(x, y, z, EsquireBlocks.EsquireRottingBark1.blockID);
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
