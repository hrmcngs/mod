package japanesesword.procedures;

import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

import japanesesword.potion.OtirutokidamenaiPotionEffect;

import japanesesword.JapaneseswordMod;

public class OtirutokidamenaiehuekutogaYouXiaoShinoteitukuProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				JapaneseswordMod.LOGGER.warn("Failed to load dependency entity for procedure OtirutokidamenaiehuekutogaYouXiaoShinoteituku!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (!entity.isOnGround()) {
			entity.fallDistance = (float) (0);
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(OtirutokidamenaiPotionEffect.potion, (int) 1, (int) 1, true, true));
		}
	}
}
