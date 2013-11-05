package sdc.nekpek.Esquire.common;

import sdc.nekpek.Esquire.Entities.EsquireEntityFish;
import sdc.nekpek.Esquire.Entities.EsquireMortarTileEntity;
import sdc.nekpek.Esquire.Mobs.EsquireFish;
import sdc.nekpek.Esquire.Render.EsquireRenderFish;
import sdc.nekpek.Esquire.Render.EsquireRenderMortar;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy
    {
        @Override
        public void registerRenderInformation()
            {
                RenderingRegistry.registerEntityRenderingHandler(EsquireEntityFish.class, new EsquireRenderFish(new EsquireFish(), 0.3f));
                ClientRegistry.bindTileEntitySpecialRenderer(EsquireMortarTileEntity.class, new EsquireRenderMortar());

            }
    }
