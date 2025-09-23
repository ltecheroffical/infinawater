package net.ltecher.infinawater.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import net.minecraft.fluid.LavaFluid;
import net.minecraft.world.WorldView;

@Mixin(LavaFluid.class)
public abstract class MixinLavaFluid {
	@Overwrite
	public int getLevelDecreasePerBlock(WorldView world) {
		return 0;
	}
}
