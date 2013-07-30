package nekpek.mod.Naturalis.common;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class NaturalisGenSeaWeed extends WorldGenerator
    {
        /** The ID of the plant block used in this plant generator. */
        private int plantBlockId;

        public NaturalisGenSeaWeed(int par1)
            {
                plantBlockId = par1;
            }

        public static boolean isSeaBottom(World par1World, int par1, int par2, int par3)
            {

                int water = par1World.getBlockId(par1, par2, par3);
                int ground = par1World.getBlockId(par1, par2 - 1, par3);
                int top = par1World.getBlockId(par1, par2 + 1, par3);
                if (water == 9 && ground != 9 && top != 0)
                    {

                        return true;
                    }
                else
                    {
                        return false;
                    }
            }

        @Override
        public boolean generate(World par1World, Random par2Random, int par3, int par4, int par5)
            {
                for (int l = 0; l < 64; ++l)
                    {
                        int i1 = par3 + par2Random.nextInt(8) - par2Random.nextInt(8);
                        int j1 = par4 + par2Random.nextInt(4) - par2Random.nextInt(4);
                        int k1 = par5 + par2Random.nextInt(8) - par2Random.nextInt(8);

                        if (isSeaBottom(par1World, i1, j1, k1) && (!par1World.provider.hasNoSky || j1 < 127) && Block.blocksList[plantBlockId].canBlockStay(par1World, i1, j1, k1))
                            {
                                par1World.setBlock(i1, j1, k1, plantBlockId, 0, 2);
                            }
                    }

                return true;
            }
    }
