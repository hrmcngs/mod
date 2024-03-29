package japanesesword.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.util.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

import japanesesword.potion.KurutaimunasiPotionEffect;

import japanesesword.JapaneseswordMod;

public class WazakigaYasaretatokiProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				JapaneseswordMod.LOGGER.warn("Failed to load dependency entity for procedure WazakigaYasaretatoki!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
				? ((ServerPlayerEntity) entity).getAdvancements().getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager().getAdvancement(new ResourceLocation("japanesesword:deleted_mod_element"))).isDone()
				: false) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(KurutaimunasiPotionEffect.potion, (int) 300, (int) 1, true, false));
		}
	}
}
