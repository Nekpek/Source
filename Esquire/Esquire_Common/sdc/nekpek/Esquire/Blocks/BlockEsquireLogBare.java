package sdc.nekpek.Esquire.Blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import sdc.nekpek.Esquire.CreativeTabs.EsquireTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockEsquireLogBare extends BlockRotatedPillar
    {
        public static final String[] woodType = new String[] { "Oak", "Spruce", "Birch", "Jungle" };
        @SideOnly(Side.CLIENT)
        private Icon[] field_111052_c;
        @SideOnly(Side.CLIENT)
        private Icon[] tree_top;

        protected BlockEsquireLogBare(int par1, Material par2Material)
            {
                super(par1, par2Material);
                this.setBlockBounds(0.06F, 0.0F, 0.06F, 0.94F, 1F, 0.94F);
                this.setHardness(2.0F);
                this.setStepSound(Block.soundWoodFootstep);
                this.setCreativeTab(EsquireTabs.EsquireTabBlocks);

            }

        /**
         * Returns the quantity of items to drop on block destruction.
         */
        @Override
        public int quantityDropped(Random par1Random)
            {
                return 1;
            }

        /**
         * Returns the ID of the items to drop on destruction.
         */
        @Override
        public int idDropped(int par1, Random par2Random, int par3)
            {
                return EsquireBlocks.EsquireLogBare.blockID;
            }

        /**
         * ejects contained items into the world, and notifies neighbours of an
         * update, as appropriate
         */
        @Override
        public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6)
            {
                byte b0 = 4;
                int j1 = b0 + 1;

                if (par1World.checkChunksExist(par2 - j1, par3 - j1, par4 - j1, par2 + j1, par3 + j1, par4 + j1))
                    {
                        for (int k1 = -b0; k1 <= b0; ++k1)
                            {
                                for (int l1 = -b0; l1 <= b0; ++l1)
                                    {
                                        for (int i2 = -b0; i2 <= b0; ++i2)
                                            {
                                                int j2 = par1World.getBlockId(par2 + k1, par3 + l1, par4 + i2);

                                                if (Block.blocksList[j2] != null)
                                                    {
                                                        Block.blocksList[j2].beginLeavesDecay(par1World, par2 + k1, par3 + l1, par4 + i2);
                                                    }
                                            }
                                    }
                            }
                    }
            }

        @Override
        @SideOnly(Side.CLIENT)
        protected Icon func_111048_c(int par1)
            {
                return this.field_111052_c[par1];
            }

        @Override
        @SideOnly(Side.CLIENT)
        protected Icon func_111049_d(int par1)
            {
                return this.tree_top[par1];
            }

        /**
         * returns a number between 0 and 3
         */
        public static int limitToValidMetadata(int par0)
            {
                return par0 & 3;
            }

        @Override
        @SideOnly(Side.CLIENT)
        /**
         * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
         */
        public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
            {
                par3List.add(new ItemStack(par1, 1, 0));
                par3List.add(new ItemStack(par1, 1, 1));
                par3List.add(new ItemStack(par1, 1, 2));
                par3List.add(new ItemStack(par1, 1, 3));
            }

        @Override
        @SideOnly(Side.CLIENT)
        /**
         * When this method is called, your block should register all the icons it needs with the given IconRegister. This
         * is the only chance you get to register icons.
         */
        public void registerIcons(IconRegister par1IconRegister)
            {
                this.field_111052_c = new Icon[woodType.length];
                this.tree_top = new Icon[woodType.length];

                for (int i = 0; i < this.field_111052_c.length; ++i)
                    {
                        this.field_111052_c[i] = par1IconRegister.registerIcon("Esquire:" + woodType[i] + "Bare");
                        this.tree_top[i] = par1IconRegister.registerIcon("Esquire:" + woodType[i] + "Top");
                    }
            }

        @Override
        public boolean canSustainLeaves(World world, int x, int y, int z)
            {
                return true;
            }

        @Override
        public boolean isWood(World world, int x, int y, int z)
            {
                return true;
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
