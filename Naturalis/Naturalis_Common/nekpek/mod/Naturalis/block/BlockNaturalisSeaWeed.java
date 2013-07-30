package nekpek.mod.Naturalis.block;

import java.util.Random;

import nekpek.mod.Naturalis.common.NaturalisGenSeaWeed;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.world.World;

public class BlockNaturalisSeaWeed extends Block
    {

        public BlockNaturalisSeaWeed(int par1, Material par2Material)
            {
                super(par1, par2Material);
                this.setTickRandomly(true);
                float f = 0.375F;
                this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 1.0F, 0.5F + f);
            }

        @Override
        public boolean renderAsNormalBlock()
            {
                return false;
            }

        @Override
        public int getRenderType()
            {
                return 6;
            }

        @Override
        public boolean isOpaqueCube()
            {
                return false;
            }

        @Override
        public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5)
            {
                if (!this.canBlockStay(par1World, par2, par3, par4))
                    {
                        par1World.destroyBlock(par2, par3, par4, true);
                        par1World.setBlockToAir(par2, par3, par4);
                    }
            }

        @Override
        public boolean canBlockStay(World par1World, int par2, int par3, int par4)
            {
                int block = par1World.getBlockId(par2, par3 - 1, par4);
                return block != 0 && block != 9;
            }

        @Override
        public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
            {
                if (NaturalisGenSeaWeed.isSeaBottom(par1World, par2, par3 + 1, par4))
                    {
                        int l;

                        for (l = 1; par1World.getBlockId(par2, par3 - l, par4) == blockID; ++l)
                            {
                                ;
                            }

                        if (l < 3)
                            {
                                par1World.setBlock(par2, par3 + 1, par4, blockID);
                            }
                    }
            }

        @Override
        public void registerIcons(IconRegister iconRegister)
            {
                blockIcon = iconRegister.registerIcon("Naturalis:NaturalisSeaWeed");
            }
    }
