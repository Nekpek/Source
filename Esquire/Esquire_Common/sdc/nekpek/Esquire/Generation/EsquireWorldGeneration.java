package sdc.nekpek.Esquire.Generation;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenOcean;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import sdc.nekpek.Esquire.Blocks.EsquireBlocks;
import cpw.mods.fml.common.IWorldGenerator;

public class EsquireWorldGeneration implements IWorldGenerator
    {
        @Override
        public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
            {
                switch (world.provider.dimensionId) {
                    case -1:
                        generateNether(world, random, chunkX * 16, chunkZ * 16);

                    case 0:
                        generateSurface(world, random, chunkX * 16, chunkZ * 16);
                }
            }

        private void generateSurface(World world, Random random, int X, int Z)
            {
                int Xcoord = X + random.nextInt(16);
                int Ycoord = random.nextInt(52);
                int Zcoord = Z + random.nextInt(16);
                BiomeGenBase biome = world.getWorldChunkManager().getBiomeGenAt(Xcoord, Zcoord);
                new WorldGenMinable(EsquireBlocks.EsquireSaltOre.blockID, 12).generate(world, random, Xcoord, Ycoord, Zcoord);

                if (biome instanceof BiomeGenOcean)
                    {
                        Ycoord = random.nextInt(60);
                        new EsquireSeaPleantGen(EsquireBlocks.EsquireSeaWeed.blockID).generate(world, random, Xcoord, Ycoord, Zcoord);
                    }
            }

        private void generateNether(World world, Random random, int X, int Z)
            {
            }

    }
