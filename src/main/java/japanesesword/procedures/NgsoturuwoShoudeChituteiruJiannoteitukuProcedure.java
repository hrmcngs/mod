package japanesesword.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.enchantment.EnchantmentHelper;

import java.util.Map;

import japanesesword.potion.Arrow2PotionEffect;
import japanesesword.potion.Arrow1PotionEffect;

import japanesesword.enchantment.YawoEnchantment;
import japanesesword.enchantment.HasiruEnchantment;
import japanesesword.enchantment.AnsiEnchantment;

import japanesesword.JapaneseswordMod;

public class NgsoturuwoShoudeChituteiruJiannoteitukuProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				JapaneseswordMod.LOGGER.warn("Failed to load dependency entity for procedure NgsoturuwoShoudeChituteiruJiannoteituku!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment, ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)) != 0)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Arrow2PotionEffect.potion, (int) 1, (int) 1, true, false));
		}
		if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment, ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)) != 0)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.HUNGER, (int) 1, (int) 4, true, false));
		}
		if ((EnchantmentHelper.getEnchantmentLevel(YawoEnchantment.enchantment, ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)) != 0)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Arrow1PotionEffect.potion, (int) 1, (int) 1, true, false));
		}
		if ((EnchantmentHelper.getEnchantmentLevel(AnsiEnchantment.enchantment, ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)) != 0)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.NIGHT_VISION, (int) 300, (int) 255, true, false));
		}
		if ((EnchantmentHelper.getEnchantmentLevel(HasiruEnchantment.enchantment, ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)) != 0)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SPEED, (int) 1,
						(int) (EnchantmentHelper.getEnchantmentLevel(HasiruEnchantment.enchantment, ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY))), true, false));
		} else {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 1, (int) 2, true, false));
		}
	}
}
