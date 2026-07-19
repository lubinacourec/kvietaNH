package com.kvieta.nh.compat;

import net.minecraft.item.ItemStack;

import com.OL925.ThinkTech.Recipe.ThTRecipeMap;

import gregtech.api.enums.GTValues;

public class ThinkTechCompat {

    public static void registerKilnRecipe(ItemStack input, ItemStack output, int duration) {
        registerKilnRecipe(new ItemStack[] { input }, output, duration);
    }

    public static void registerKilnRecipe(ItemStack[] inputs, ItemStack output, int duration) {
        if (inputs == null || output == null) {
            return;
        }

        for (ItemStack input : inputs) {
            if (input == null) {
                return;
            }
        }

        GTValues.RA.stdBuilder()
            .itemInputs(inputs)
            .itemOutputs(output)
            .eut(0)
            .duration(duration)
            .addTo(ThTRecipeMap.Kiln);
    }
}
