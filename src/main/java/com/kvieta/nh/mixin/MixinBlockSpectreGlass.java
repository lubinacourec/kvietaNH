package com.kvieta.nh.mixin;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

// @Mixin(BlockSpectreGlass.class)
@Mixin(targets = "lumien.randomthings.Blocks.Spectre.BlockSpectreGlass")
public class MixinBlockSpectreGlass {

    @Inject(method = "addCollisionBoxesToList", at = @At("HEAD"), cancellable = true)
    private void addCollisionBoxes(World world, int x, int y, int z, AxisAlignedBB mask, List<AxisAlignedBB> list,
        Entity entity, CallbackInfo ci) {

        AxisAlignedBB box = ((Block) (Object) this).getCollisionBoundingBoxFromPool(world, x, y, z);

        if (box != null && mask.intersectsWith(box)
            && (entity instanceof EntityPlayer || entity instanceof EntityItem)) {
            list.add(box);
        }

        ci.cancel();
    }
}
