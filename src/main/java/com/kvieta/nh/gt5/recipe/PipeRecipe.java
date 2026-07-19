package com.kvieta.nh.gt5.recipe;

import net.minecraft.item.ItemStack;

import com.kvieta.nh.common.ModCheck;
import com.kvieta.nh.compat.ThinkTechCompat;

import cpw.mods.fml.common.registry.GameRegistry;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GTOreDictUnificator;

public class PipeRecipe {

    private static void registerBrickPipeSmelting() {
        OrePrefixes[] pipeSizes = {
            // OrePrefixes.pipeTiny,
            // OrePrefixes.pipeSmall,
            OrePrefixes.pipeMedium, OrePrefixes.pipeLarge, OrePrefixes.pipeHuge };

        for (OrePrefixes prefix : pipeSizes) {
            ItemStack clayPipe = GTOreDictUnificator.get(prefix, Materials.Clay, 1);
            ItemStack brickPipe = GTOreDictUnificator.get(prefix, Materials.Brick, 1);

            if (clayPipe != null && brickPipe != null) {
                GameRegistry.addSmelting(clayPipe, brickPipe, 0.0F);
                if (ModCheck.ThinkTech) {
                    ThinkTechCompat.registerKilnRecipe(
                        GTOreDictUnificator.get(prefix, Materials.Clay, 64),
                        GTOreDictUnificator.get(prefix, Materials.Brick, 64),
                        60 * 20);
                }
                // TODO: add brick pipe recycling recipes to macerator - generated recycling recipes give twice as much
                // dust as they should
            }
        }
    }

    public static void registerPipeRecipes() {
        registerBrickPipeSmelting();
    }
}
