package net.ltecher.infinawater;

import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.WorldView;

public class FluidMixinUtil {
	public static void onGetLevelDecreasePerBlock(WorldView worldView, CallbackInfoReturnable<Integer> cir) {
		if (worldView instanceof ServerWorld serverWorld) {
			boolean infiniteLiquids = serverWorld.getGameRules().getBoolean(InfinaWater.GAMERULE_DO_INFINITE_LIQUIDS);
			if (!infiniteLiquids) {
				return;
			}
			cir.setReturnValue(0);
		}
    }
}
