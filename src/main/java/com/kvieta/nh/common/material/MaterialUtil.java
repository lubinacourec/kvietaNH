package com.kvieta.nh.common.material;

import bartworks.system.material.Werkstoff;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.metatileentity.implementations.MTEItemPipe;
import gregtech.api.util.GTLanguageManager;
import gregtech.api.util.GTOreDictUnificator;

public class MaterialUtil {

    public static void registerItemPipe(int ID, Werkstoff material, int aInvSlotCount, int aStepSize,
        boolean aIsRestrictive, int aTickTime) {
        registerItemPipe(ID, material.getBridgeMaterial(), aInvSlotCount, aStepSize, aIsRestrictive, aTickTime, true);
    }

    public static void registerItemPipe(int ID, Werkstoff material, int aInvSlotCount, int aStepSize,
        boolean aIsRestrictive, int aTickTime, boolean generateTinyAndSmall) {
        registerItemPipe(
            ID,
            material.getBridgeMaterial(),
            aInvSlotCount,
            aStepSize,
            aIsRestrictive,
            aTickTime,
            generateTinyAndSmall);
    }

    public static void registerItemPipe(int ID, Materials material, int aInvSlotCount, int aStepSize,
        boolean aIsRestrictive, int aTickTime) {
        registerItemPipe(ID, material, aInvSlotCount, aStepSize, aIsRestrictive, aTickTime, true);
    }

    public static void registerItemPipe(int ID, Materials material, int aInvSlotCount, int aStepSize,
        boolean aIsRestrictive, int aTickTime, boolean generateTinyAndSmall) {
        String unName = material.mName;
        if (generateTinyAndSmall) {
            GTOreDictUnificator.registerOre(
                OrePrefixes.pipeTiny.get(material),
                new MTEItemPipe(
                    ID,
                    "GT_Pipe_" + unName + "_Tiny",
                    GTLanguageManager.i18nPlaceholder ? "gt.oreprefix.tiny_material_item_pipe"
                        : "Tiny " + material.mDefaultLocalName + " Item Pipe",
                    0.25F,
                    material,
                    Math.max(aInvSlotCount / 4, 1),
                    aStepSize * 4,
                    aIsRestrictive,
                    aTickTime).getStackForm(1L));
            GTOreDictUnificator.registerOre(
                OrePrefixes.pipeSmall.get(material),
                new MTEItemPipe(
                    ID + 1,
                    "GT_Pipe_" + unName + "_Small",
                    GTLanguageManager.i18nPlaceholder ? "gt.oreprefix.small_material_item_pipe"
                        : "Small " + material.mDefaultLocalName + " Item Pipe",
                    0.375F,
                    material,
                    Math.max(aInvSlotCount / 2, 1),
                    aStepSize * 2,
                    aIsRestrictive,
                    aTickTime).getStackForm(1L));
        }
        GTOreDictUnificator.registerOre(
            OrePrefixes.pipeMedium.get(material),
            new MTEItemPipe(
                ID + 2,
                "GT_Pipe_" + unName,
                GTLanguageManager.i18nPlaceholder ? "gt.oreprefix.material_item_pipe"
                    : material.mDefaultLocalName + " Item Pipe",
                0.5F,
                material,
                aInvSlotCount,
                aStepSize,
                aIsRestrictive,
                aTickTime).getStackForm(1L));
        GTOreDictUnificator.registerOre(
            OrePrefixes.pipeLarge.get(material),
            new MTEItemPipe(
                ID + 3,
                "GT_Pipe_" + unName + "_Large",
                GTLanguageManager.i18nPlaceholder ? "gt.oreprefix.large_material_item_pipe"
                    : "Large " + material.mDefaultLocalName + " Item Pipe",
                0.75F,
                material,
                aInvSlotCount * 2,
                aStepSize / 2,
                aIsRestrictive,
                aTickTime).getStackForm(1L));
        GTOreDictUnificator.registerOre(
            OrePrefixes.pipeHuge.get(material),
            new MTEItemPipe(
                ID + 4,
                "GT_Pipe_" + unName + "_Huge",
                GTLanguageManager.i18nPlaceholder ? "gt.oreprefix.huge_material_item_pipe"
                    : "Huge " + material.mDefaultLocalName + " Item Pipe",
                0.875F,
                material,
                aInvSlotCount * 4,
                aStepSize / 4,
                aIsRestrictive,
                aTickTime).getStackForm(1L));
    }

}
