package nekpek.mod.Naturalis.common;

import net.minecraft.entity.passive.EntitySquid;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingDropsEvent;

public class NaturalisDrops
    {
        public static double rand;

        @ForgeSubscribe
        public void onEntityDrop(LivingDropsEvent event)
            {
                if (event.source.getDamageType().equals("player"))
                    {
                        rand = Math.random();
                        if (event.entityLiving instanceof EntitySquid)
                            {
                                if (rand < 1D)
                                    { // Makes drop 100% drop chance. Example:
                                      // (0.25D = 25%, 1D = 100%, etc.);
                                        event.entityLiving.dropItem(Naturalis.NaturalisRawSquid.itemID, 1);
                                    }
                            }
                    }
            }
    }
