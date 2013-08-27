package sdc.nekpek.Esquire.Blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import sdc.nekpek.Esquire.CreativeTabs.EsquireTabs;
import sdc.nekpek.Esquire.Generation.EsquireSeaPleantGen;

public class BlockEsquireSeaWeed extends Block implements IPlantable
    {

        public BlockEsquireSeaWeed(int par1, Material par2Material)
            {
                super(par1, par2Material);
                this.setTickRandomly(true);
                float f = 0.375F;
                this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 1.0F, 0.5F + f);
                setCreativeTab(EsquireTabs.EsquireTabBlocks);
                setHardness(0.4f);
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
                if (EsquireSeaPleantGen.isSeaBottom(par1World, par2, par3 + 1, par4))
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
                blockIcon = iconRegister.registerIcon("Esquire:SeaWeed");
            }

        @Override
        public EnumPlantType getPlantType(World world, int x, int y, int z)
            {
                return EnumPlantType.Water;
            }

        @Override
        public int getPlantID(World world, int x, int y, int z)
            {

                return blockID;
            }

        @Override
        public int getPlantMetadata(World world, int x, int y, int z)
            {
                return world.getBlockMetadata(x, y, z);
            }

        @Override
        public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
            {
                return null;
            }
    }
