package net.ltecher.infinawater.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.ltecher.infinawater.InfinaWater;
import net.minecraft.block.BlockState;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

@Mixin(FlowableFluid.class)
public abstract class MixinFlowableFluid {
    @Inject(method = "tryFlow", at = @At("HEAD"), cancellable = true)
	private void onTryFlow(ServerWorld world, BlockPos fluidPos, BlockState blockState, FluidState fluidState, CallbackInfo ci) {
		boolean infiniteLiquids = world.getGameRules().getBoolean(InfinaWater.GAMERULE_DO_INFINITE_LIQUIDS);
		if (!infiniteLiquids) {
			return;
		}

		ci.cancel();
		FlowableFluid self = (FlowableFluid) (Object) this;
		for (var direction : Direction.values()) {
			if (direction == Direction.UP) {
				continue;
			}

			BlockPos neighborPos = fluidPos.offset(direction);
			BlockState neighborState = world.getBlockState(neighborPos);

			if (!neighborState.contains(Properties.WATERLOGGED)) {
				if (!neighborState.canBucketPlace(neighborState.getFluidState().getFluid())) {
					continue;
				}

				if (!neighborState.getFluidState().isEmpty()) {
					continue;
				}
			} else {
				world.setBlockState(neighborPos, neighborState.with(Properties.WATERLOGGED, true), 3);
				continue;
			}

			world.setBlockState(neighborPos, self.getStill(true).getBlockState());
		}
	}
}
