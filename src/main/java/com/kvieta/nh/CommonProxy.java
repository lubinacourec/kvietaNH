package com.kvieta.nh;

import static com.kvieta.nh.tcon.Casting.registerTinkerIngotCasting;
import static com.kvieta.nh.util.dev.DumpMTE.dumpMTEs;

import com.gtnewhorizon.gtnhlib.config.ConfigurationManager;
import com.kvieta.nh.config.ModConfig;
import com.kvieta.nh.gt5.MachineLoader;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLLoadCompleteEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;

public class CommonProxy {

    // preInit "Run before anything else. Read your config, create blocks, items, etc, and register them with the
    // GameRegistry." (Remove if not needed)
    public void preInit(FMLPreInitializationEvent event) {
        ConfigurationManager.registerConfig(ModConfig.class);

        kvietaNH.LOG.info("I am kvietaNH at version " + Tags.VERSION);
    }

    // load "Do your mod setup. Build whatever data structures you care about. Register recipes." (Remove if not needed)
    public void init(FMLInitializationEvent event) {}

    // postInit "Handle interaction with other mods, complete your setup based on this." (Remove if not needed)
    public void postInit(FMLPostInitializationEvent event) {
        MachineLoader.registry();
    }

    public void loadComplete(FMLLoadCompleteEvent event) {
        if (ModConfig.debug.dumpMTEs) {
            dumpMTEs();
        }
        registerTinkerIngotCasting();
    }

    // register server commands in this event handler (Remove if not needed)
    public void serverStarting(FMLServerStartingEvent event) {}
}
