package com.kvieta.nh.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(targets = "com.rwtema.extrautils.tileentity.TileEntityFilingCabinet", priority = 1200)
public abstract class MixinXUFilingCabinet {

    @Inject(method = "arrayContain([I[I)Z", at = @At("HEAD"), cancellable = true, remap = false)
    private static void arrayComparisonFix(int[] a, int[] b, CallbackInfoReturnable<Boolean> cir) {
        for (int oreID_foo : a) {
            for (int oreID_bar : b) {
                if (oreID_foo == oreID_bar) {
                    cir.setReturnValue(true);
                    return;
                }
            }
        }

        cir.setReturnValue(false);
    }
}
