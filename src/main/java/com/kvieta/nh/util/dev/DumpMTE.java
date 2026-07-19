package com.kvieta.nh.util.dev;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import gregtech.api.GregTechAPI;
import gregtech.api.interfaces.metatileentity.IMetaTileEntity;

public class DumpMTE {

    public static void dumpMTEs() {
        File file = new File("mte_ids.txt");

        try (FileWriter writer = new FileWriter(file)) {
            for (int i = 0; i < GregTechAPI.METATILEENTITIES.length; i++) {
                IMetaTileEntity mte = GregTechAPI.METATILEENTITIES[i];

                if (mte != null) {
                    writer.write(
                        i + " : "
                            + mte.getClass()
                                .getName()
                            + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
