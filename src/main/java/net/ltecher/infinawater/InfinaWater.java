package net.ltecher.infinawater;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.minecraft.world.GameRules;
import net.minecraft.world.GameRules.Category;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InfinaWater implements ModInitializer {
	public static final String MOD_ID = "infinawater";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final GameRules.Key<GameRules.BooleanRule> GAMERULE_DO_INFINITE_LIQUIDS = GameRuleRegistry.register("doInfiniteLiquids", Category.MISC, GameRuleFactory.createBooleanRule(false));
	public static final GameRules.Key<GameRules.BooleanRule> GAMERULE_DO_INFINITE_WATER = GameRuleRegistry.register("doInfiniteWater", Category.MISC, GameRuleFactory.createBooleanRule(true));
	public static final GameRules.Key<GameRules.BooleanRule> GAMERULE_DO_INFINITE_LAVA = GameRuleRegistry.register("doInfiniteLava", Category.MISC, GameRuleFactory.createBooleanRule(true));

	@Override
	public void onInitialize() {
	}
}
