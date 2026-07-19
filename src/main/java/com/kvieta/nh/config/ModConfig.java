package com.kvieta.nh.config;

import com.gtnewhorizon.gtnhlib.config.Config;

@Config(modid = com.kvieta.nh.kvietaNH.MODID, filename = "kvietaNH")
public class ModConfig {

    @Config.Comment("Debug section")
    public static final Debug debug = new Debug();

    public static class Debug {

        @Config.Comment("Dump all GregTech MetaTileEntity IDs")
        public boolean dumpMTEs = false;
    }
}
