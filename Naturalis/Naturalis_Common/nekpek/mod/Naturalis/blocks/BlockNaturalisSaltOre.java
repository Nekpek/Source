package nekpek.mod.Naturalis.blocks;

import java.util.Random;

import nekpek.mod.Naturalis.common.Naturalis;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.item.EntityFallingSand;
import net.minecraft.world.World;

public class BlockNaturalisSaltOre extends Block
    {
        public static boolean fallInstantly = false;

        public BlockNaturalisSaltOre(int par1, Material par2Material)
            {
                super(par1, par2Material);
            }

        @Override
        public void registerIcons(IconRegister iconRegister)
            {
                blockIcon = iconRegister.registerIcon("Naturalis:NaturalisSaltOre");
            }

        @Override
        public void onBlockAdded(World par1World, int par2, int par3, int par4)
            {
                par1World.scheduleBlockUpdate(par2, par3, par4, blockID, this.tickRate(par1World));
            }

        @Override
        public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
            {
                if (!par1World.isRemote)
                    {
                        this.tryToFall(par1World, par2, par3, par4);
                    }
            }

        private void tryToFall(World par1World, int par2, int par3, int par4)
            {
                if (canFallBelow(par1World, par2, par3 - 1, par4) && par3 >= 0)
                    {
                        byte b0 = 32;

                        if (!fallInstantly && par1World.checkChunksExist(par2 - b0, par3 - b0, par4 - b0, par2 + b0, par3 + b0, par4 + b0))
                            {
                                if (!par1World.isRemote)
                                    {
                                        EntityFallingSand entityfallingsand = new EntityFallingSand(par1World, par2 + 0.5F, par3 + 0.5F, par4 + 0.5F, blockID, par1World.getBlockMetadata(par2, par3, par4));
                                        this.onStartFalling(entityfallingsand);
                                        par1World.spawnEntityInWorld(entityfallingsand);
                                    }
                            }
                        else
                            {
                                par1World.setBlockToAir(par2, par3, par4);

                                while (canFallBelow(par1World, par2, par3 - 1, par4) && par3 > 0)
                                    {
                                        --par3;
                                    }

                                if (par3 > 0)
                                    {
                                        par1World.setBlock(par2, par3, par4, blockID);
                                    }
                            }
                    }
            }

        protected void onStartFalling(EntityFallingSand par1EntityFallingSand)
            {
            }

        @Override
        public int tickRate(World par1World)
            {
                return 2;
            }

        public static boolean canFallBelow(World par0World, int par1, int par2, int par3)
            {
                int l = par0World.getBlockId(par1, par2, par3);

                if (l == 0)
                    {
                        return true;
                    }
                else
                    if (l == Block.fire.blockID)
                        {
                            return true;
                        }
                    else
                        {
                            Material material = Block.blocksList[l].blockMaterial;
                            return material == Material.water ? true : material == Material.lava;
                        }
            }

        public void onFinishFalling(World par1World, int par2, int par3, int par4, int par5)
            {
            }

        @Override
        public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5)
            {
                par1World.scheduleBlockUpdate(par2, par3, par4, blockID, this.tickRate(par1World));
            }

        @Override
        public int idDropped(int par1, Random par2Random, int par3)
            {
                return Naturalis.NaturalisRawRockSalt.itemID;
            }

        @Override
        public int quantityDroppedWithBonus(int par1, Random par2Random)
            {
                return this.quantityDropped(par2Random) + par2Random.nextInt(par1 + 3);
            }
    }
