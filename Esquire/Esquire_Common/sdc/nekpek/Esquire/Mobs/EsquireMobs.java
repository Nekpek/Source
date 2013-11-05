package sdc.nekpek.Esquire.Mobs;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import sdc.nekpek.Esquire.Entities.EsquireEntity;
import sdc.nekpek.Esquire.Entities.EsquireEntityFish;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class EsquireMobs
    {
        public static void EsquireFish()
            {
                EntityRegistry.registerGlobalEntityID(EsquireEntityFish.class, "Fish", 1);
                EntityRegistry.addSpawn(EsquireEntityFish.class, 10, 5, 12, EnumCreatureType.waterCreature, BiomeGenBase.ocean);
                EntityRegistry.findGlobalUniqueEntityId();
                EsquireEntity.registerEntityEgg(EsquireEntityFish.class, 0x0FF7700, 0x0FFC592);

                LanguageRegistry.instance().addStringLocalization("entity.Fish.name", "Caviar");
            }
    }
