package net.ltecher.infinawater.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.ltecher.infinawater.FluidMixinUtil;
import net.minecraft.fluid.LavaFluid;
import net.minecraft.world.WorldView;

@Mixin(LavaFluid.class)
public abstract class MixinLavaFluid {
    @Inject(method = "getLevelDecreasePerBlock", at = @At("HEAD"), cancellable = true)
    private void onGetLevelDecreasePerBlock(WorldView world, CallbackInfoReturnable<Integer> cir) {
		FluidMixinUtil.onGetLevelDecreasePerBlock(world, cir);
    }
}
