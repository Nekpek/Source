package nekpek.mod.Naturalis.common;

import nekpek.mod.Naturalis.Entity.EntityNaturalisFish;
import nekpek.mod.Naturalis.models.NaturalisFish;
import nekpek.mod.Naturalis.render.RenderNaturalisFish;
import cpw.mods.fml.client.registry.RenderingRegistry;
import nekpek.mod.Naturalis.common.CommonProxy;

public class ClientProxy extends CommonProxy
    {
        @Override
        public void registerRenderInformation()
            {
                RenderingRegistry.registerEntityRenderingHandler(EntityNaturalisFish.class, new RenderNaturalisFish(new NaturalisFish(), 0.3f));

            }
    }
