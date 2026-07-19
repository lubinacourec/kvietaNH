package com.kvieta.nh.gt5;

import com.kvieta.nh.common.material.MaterialUtil;
import com.kvieta.nh.kvietaNH;
import com.kvieta.nh.util.enums.kvietaMachineID;

import gregtech.api.enums.Materials;

public class MachineLoader {

    public static void registerPipes() {
        MaterialUtil.registerItemPipe(kvietaMachineID.BRICK_PIPE.ID, Materials.Brick, 4, 1024, false, 20, false);
    }

    public static void registerRecipes() {

    }

    public static void registry() {
        kvietaNH.LOG.info("GT5U: Registering MTE Block Machine.");
        registerPipes();
        registerRecipes();
    }
}
