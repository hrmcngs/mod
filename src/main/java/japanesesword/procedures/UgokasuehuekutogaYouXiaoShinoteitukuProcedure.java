package japanesesword.procedures;

import net.minecraft.entity.Entity;

import java.util.Map;

import japanesesword.JapaneseswordMod;

public class UgokasuehuekutogaYouXiaoShinoteitukuProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				JapaneseswordMod.LOGGER.warn("Failed to load dependency entity for procedure UgokasuehuekutogaYouXiaoShinoteituku!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.setMotion(0, 5, 0);
	}
}
