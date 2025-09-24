package net.ltecher.infinawater.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.ltecher.infinawater.FluidMixinUtil;
import net.minecraft.fluid.WaterFluid;
import net.minecraft.world.WorldView;

@Mixin(WaterFluid.class)
public abstract class MixinWaterFluid {
    @Inject(method = "getLevelDecreasePerBlock", at = @At("HEAD"), cancellable = true)
    private void onGetLevelDecreasePerBlock(WorldView worldView, CallbackInfoReturnable<Integer> cir) {
		FluidMixinUtil.onGetLevelDecreasePerBlock(worldView, cir);
    }
}
