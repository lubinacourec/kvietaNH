package com.kvieta.nh.tcon;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GTOreDictUnificator;
import tconstruct.library.TConstructRegistry;
import tconstruct.smeltery.TinkerSmeltery;

public class Casting {

    public static void registerTinkerIngotCasting() {
        // cobalt casting not required
        // addCastingGreg(Materials.Ardite);
        addCastingTiC(FluidRegistry.getFluid("ardite.molten"), Materials.Ardite);
        // addCastingGreg(Materials.Manyullyn);
        addCastingTiC(FluidRegistry.getFluid("manyullyn.molten"), Materials.Manyullyn);

    }

    private static void addCastingGreg(Materials materialGT) {
        FluidStack molten = materialGT.getMolten(144);

        if (molten == null) {
            return;
        }

        ItemStack ingotCast = new ItemStack(TinkerSmeltery.metalPattern, 1, 0);
        TConstructRegistry.getTableCasting()
            .addCastingRecipe(GTOreDictUnificator.get(OrePrefixes.ingot, materialGT, 1), molten, ingotCast, 160);
    }

    private static void addCastingTiC(Fluid ticFluid, Materials materialGT) {
        FluidStack molten = new FluidStack(ticFluid, 144);

        ItemStack ingotCast = new ItemStack(TinkerSmeltery.metalPattern, 1, 0);
        TConstructRegistry.getTableCasting()
            .addCastingRecipe(GTOreDictUnificator.get(OrePrefixes.ingot, materialGT, 1), molten, ingotCast, 160);
    }
}
