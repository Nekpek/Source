package sdc.nekpek.Esquire.common;

import net.minecraftforge.common.MinecraftForge;
import sdc.nekpek.Esquire.Blocks.EsquireBlocks;
import sdc.nekpek.Esquire.CooknCraft.CraftingHandler;
import sdc.nekpek.Esquire.CooknCraft.EsquireCooknCrafts;
import sdc.nekpek.Esquire.CreativeTabs.EsquireTabs;
import sdc.nekpek.Esquire.Generation.WorldGenerations;
import sdc.nekpek.Esquire.Gui.GuiHandler;
import sdc.nekpek.Esquire.Items.EsquireItems;
import sdc.nekpek.Esquire.Mobs.EsquireDrops;
import sdc.nekpek.Esquire.Mobs.EsquireMobs;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = "Esquire", name = "Esquire", version = "1.0.0")
@NetworkMod(clientSideRequired = true, serverSideRequired = false, channels = "Esquire", packetHandler = EsquirePacketHandler.class)
public class Esquire
    {
        @Instance
        public static Esquire instance = new Esquire();
        private final GuiHandler guihandler = new GuiHandler();
        @SidedProxy(clientSide = "sdc.nekpek.Esquire.common.ClientProxy", serverSide = "sdc.nekpek.Esquire.common.CommonProxy")
        public static CommonProxy proxy;

        @EventHandler
        public void load(FMLPreInitializationEvent event)
            {
                MinecraftForge.EVENT_BUS.register(new WorldGenerations());
                NetworkRegistry.instance().registerGuiHandler(this, guihandler);
                MinecraftForge.EVENT_BUS.register(new EsquireDrops());
            }

        @EventHandler
        public void load(FMLInitializationEvent event)
            {
                proxy.registerRenderInformation();

                MinecraftForge.EVENT_BUS.register(new EsquireItems());
                EsquireItems.ItemNames();

                MinecraftForge.EVENT_BUS.register(new EsquireBlocks());
                EsquireBlocks.Blocks();
                EsquireBlocks.BlockNames();

                MinecraftForge.EVENT_BUS.register(new EsquireTabs());

                EsquireMobs.EsquireFish();

                GameRegistry.registerWorldGenerator(WorldGenerations.EsquireGeneration);

                EsquireCooknCrafts.OreDic();
                EsquireCooknCrafts.Craftings();
                EsquireCooknCrafts.Cookings();
                GameRegistry.registerCraftingHandler(new CraftingHandler());

            }

        @EventHandler
        public void load(FMLPostInitializationEvent event)
            {

            }
    }
