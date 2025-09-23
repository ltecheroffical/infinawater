package net.ltecher.infinawater.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import net.minecraft.fluid.WaterFluid;
import net.minecraft.world.WorldView;

@Mixin(WaterFluid.class)
public abstract class MixinWaterFluid {
	@Overwrite
	public int getLevelDecreasePerBlock(WorldView world) {
		return 0;
	}
}
