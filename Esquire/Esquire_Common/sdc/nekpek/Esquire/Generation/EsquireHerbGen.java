package sdc.nekpek.Esquire.Generation;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class EsquireHerbGen extends WorldGenerator
    {
        /** The ID of the plant block used in this plant generator. */
        private int Id;
        private int MetaData;
        private int Rareness;

        public EsquireHerbGen(int par1, int par2, int par3)
            {
                this.Id = par1;
                this.MetaData = par2;
                this.Rareness = par3;
            }

        @Override
        public boolean generate(World par1World, Random par2Random, int par3, int par4, int par5)
            {
                for (int l = 0; l < Rareness; ++l)
                    {
                        int i1 = par3 + par2Random.nextInt(8) - par2Random.nextInt(8);
                        int j1 = par4 + par2Random.nextInt(4) - par2Random.nextInt(4);
                        int k1 = par5 + par2Random.nextInt(8) - par2Random.nextInt(8);

                        if (par1World.isAirBlock(i1, j1, k1) && (!par1World.provider.hasNoSky || j1 < 127) && Block.blocksList[this.Id].canBlockStay(par1World, i1, j1, k1))
                            {
                                par1World.setBlock(i1, j1, k1, this.Id, this.MetaData, 2);
                            }
                    }

                return true;
            }
    }
