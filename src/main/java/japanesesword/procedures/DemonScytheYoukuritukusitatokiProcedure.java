package japanesesword.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.world.GameType;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Hand;
import net.minecraft.util.DamageSource;
import net.minecraft.server.MinecraftServer;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;
import net.minecraft.client.network.play.NetworkPlayerInfo;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.Minecraft;

import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.Map;
import java.util.List;
import java.util.Comparator;
import java.util.Collections;
import java.util.Collection;

import japanesesword.potion.UgokasuPotionEffect;
import japanesesword.potion.TpPotionEffect;
import japanesesword.potion.Tp1PotionEffect;
import japanesesword.potion.KurutaimunasiPotionEffect;
import japanesesword.potion.Effect10PotionEffect;
import japanesesword.potion.BloodPotionEffect;

import japanesesword.particle.DokuroParticle;

import japanesesword.item.TokinohonnItem;
import japanesesword.item.PoisonbookItem;
import japanesesword.item.DemonizedkatanaItem;
import japanesesword.item.DemonScytheItem;
import japanesesword.item.BookbloodItem;

import japanesesword.enchantment.KillEnchantment;
import japanesesword.enchantment.DemonizedEnchantment;

import japanesesword.JapaneseswordModVariables;

import japanesesword.JapaneseswordMod;

public class DemonScytheYoukuritukusitatokiProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				JapaneseswordMod.LOGGER.warn("Failed to load dependency world for procedure DemonScytheYoukuritukusitatoki!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				JapaneseswordMod.LOGGER.warn("Failed to load dependency x for procedure DemonScytheYoukuritukusitatoki!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				JapaneseswordMod.LOGGER.warn("Failed to load dependency y for procedure DemonScytheYoukuritukusitatoki!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				JapaneseswordMod.LOGGER.warn("Failed to load dependency z for procedure DemonScytheYoukuritukusitatoki!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				JapaneseswordMod.LOGGER.warn("Failed to load dependency entity for procedure DemonScytheYoukuritukusitatoki!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		double ZRadius2 = 0;
		double zRadius = 0;
		double xRadius6 = 0;
		double Numerical_value = 0;
		double zRadius6 = 0;
		double zRadius5 = 0;
		double xRadius5 = 0;
		double loop = 0;
		double X = 0;
		double Z2 = 0;
		double Y = 0;
		double angle = 0;
		double Z3 = 0;
		double Z = 0;
		double X2 = 0;
		double Z4 = 0;
		double X3 = 0;
		double Z5 = 0;
		double X4 = 0;
		double Z6 = 0;
		double X5 = 0;
		double X6 = 0;
		double zRaduis3 = 0;
		double loop2 = 0;
		double loop3 = 0;
		double yaw = 0;
		double loop6 = 0;
		double radiu = 0;
		double xRadius = 0;
		double loop4 = 0;
		double XRadius2 = 0;
		double loop5 = 0;
		double xRaduis4 = 0;
		double Y2 = 0;
		double Y3 = 0;
		double xRaduis3 = 0;
		double Y4 = 0;
		double zRaduis4 = 0;
		double Y5 = 0;
		double Y_pos = 0;
		double Y6 = 0;
		double r = 0;
		double alpha = 0;
		double beta = 0;
		if ((entity.getCapability(JapaneseswordModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new JapaneseswordModVariables.PlayerVariables())).kaunnto == 2) {
			if (2 < ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) || new Object() {
				public boolean checkGamemode(Entity _ent) {
					if (_ent instanceof ServerPlayerEntity) {
						return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.CREATIVE;
					} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
						NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
								.getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
						return _npi != null && _npi.getGameType() == GameType.CREATIVE;
					}
					return false;
				}
			}.checkGamemode(entity) || new Object() {
				public boolean checkGamemode(Entity _ent) {
					if (_ent instanceof ServerPlayerEntity) {
						return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.SPECTATOR;
					} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
						NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
								.getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
						return _npi != null && _npi.getGameType() == GameType.SPECTATOR;
					}
					return false;
				}
			}.checkGamemode(entity)
					|| (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
							? ((ServerPlayerEntity) entity).getAdvancements()
									.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
											.getAdvancement(new ResourceLocation("japanesesword:tidaisuki")))
									.isDone()
							: false)) {
				if (entity instanceof LivingEntity) {
					((LivingEntity) entity).swing(Hand.MAIN_HAND, true);
				}
				loop = Math.toRadians(entity.rotationYaw);
				XRadius2 = 3;
				ZRadius2 = 3;
				Y_pos = (y + 2);
				for (int index0 = 0; index0 < (int) (36); index0++) {
					X = (x + Math.cos(loop) * XRadius2);
					Y = Y_pos;
					Z = (z + Math.sin(loop) * ZRadius2);
					if (world instanceof ServerWorld) {
						((ServerWorld) world).spawnParticle(ParticleTypes.SWEEP_ATTACK, X, Y, Z, (int) 3, 0.1, 0.1, 0.1, 0);
					}
					if (world instanceof ServerWorld) {
						((ServerWorld) world).spawnParticle(ParticleTypes.CLOUD, X, Y, Z, (int) 3, 0.1, 0.1, 0.1, 0);
					}
					if (world instanceof ServerWorld) {
						((ServerWorld) world).spawnParticle(ParticleTypes.TOTEM_OF_UNDYING, X, Y, Z, (int) 3, 0.1, 0.1, 0.1, 0);
					}
					if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
							.getItem() == BookbloodItem.block) {
						if ((EnchantmentHelper.getEnchantmentLevel(KillEnchantment.enchantment,
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)) != 0)) {
							if (world instanceof ServerWorld) {
								((ServerWorld) world).spawnParticle(ParticleTypes.SOUL_FIRE_FLAME, X, Y, Z, (int) 3, 0.1, 0.1, 0.1, 0);
							}
						} else {
							if (world instanceof ServerWorld) {
								((ServerWorld) world).spawnParticle(ParticleTypes.FLAME, X, Y, Z, (int) 3, 0.1, 0.1, 0.1, 0);
							}
						}
					}
					if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
							.getItem() == PoisonbookItem.block) {
						if (world instanceof ServerWorld) {
							((ServerWorld) world).spawnParticle(DokuroParticle.particle, X, Y, Z, (int) 3, 0.1, 0.1, 0.1, 0);
						}
					}
					{
						List<Entity> _entfound = world
								.getEntitiesWithinAABB(Entity.class,
										new AxisAlignedBB(X - (3 / 2d), Y - (3 / 2d), Z - (3 / 2d), X + (3 / 2d), Y + (3 / 2d), Z + (3 / 2d)), null)
								.stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
									}
								}.compareDistOf(X, Y, Z)).collect(Collectors.toList());
						for (Entity entityiterator : _entfound) {
							if (!(entityiterator == entity)) {
								if ((EnchantmentHelper.getEnchantmentLevel(KillEnchantment.enchantment,
										((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)) != 0)) {
									if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
											.getItem() == BookbloodItem.block
											|| ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
													.getItem() == PoisonbookItem.block) {
										if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
												.getItem() == BookbloodItem.block) {
											if (entityiterator instanceof MobEntity) {
												if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
														((entity instanceof LivingEntity)
																? ((LivingEntity) entity).getHeldItemMainhand()
																: ItemStack.EMPTY)) != 0)) {
													if (entity instanceof LivingEntity)
														((LivingEntity) entity).setHealth(
																(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																		+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																				((entity instanceof LivingEntity)
																						? ((LivingEntity) entity).getHeldItemMainhand()
																						: ItemStack.EMPTY))));
												}
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator).addPotionEffect(
															new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
												entityiterator.setFire((int) 15);
												{
													Entity _ent = entityiterator;
													if (!_ent.world.isRemote && _ent.world.getServer() != null) {
														_ent.world.getServer().getCommandManager().handleCommand(
																_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "/kill @s");
													}
												}
												{
													Entity _ent = entityiterator;
													if (!_ent.world.isRemote && _ent.world.getServer() != null) {
														_ent.world.getServer().getCommandManager().handleCommand(
																_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																"/deta merge entity @s (Health:0)");
													}
												}
											}
										}
										if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
												.getItem() == PoisonbookItem.block) {
											if (entityiterator instanceof MobEntity) {
												if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
														((entity instanceof LivingEntity)
																? ((LivingEntity) entity).getHeldItemMainhand()
																: ItemStack.EMPTY)) != 0)) {
													if (entity instanceof LivingEntity)
														((LivingEntity) entity).setHealth(
																(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																		+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																				((entity instanceof LivingEntity)
																						? ((LivingEntity) entity).getHeldItemMainhand()
																						: ItemStack.EMPTY))));
												}
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator).addPotionEffect(
															new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator)
															.addPotionEffect(new EffectInstance(Effects.POISON, (int) 300, (int) 1));
												{
													Entity _ent = entityiterator;
													if (!_ent.world.isRemote && _ent.world.getServer() != null) {
														_ent.world.getServer().getCommandManager().handleCommand(
																_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "/kill @s");
													}
												}
												{
													Entity _ent = entityiterator;
													if (!_ent.world.isRemote && _ent.world.getServer() != null) {
														_ent.world.getServer().getCommandManager().handleCommand(
																_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																"/deta merge entity @s (Health:0)");
													}
												}
											}
										}
									} else {
										if (entityiterator instanceof MobEntity) {
											if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
													((entity instanceof LivingEntity)
															? ((LivingEntity) entity).getHeldItemMainhand()
															: ItemStack.EMPTY)) != 0)) {
												if (entity instanceof LivingEntity)
													((LivingEntity) entity).setHealth(
															(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																	+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																			((entity instanceof LivingEntity)
																					? ((LivingEntity) entity).getHeldItemMainhand()
																					: ItemStack.EMPTY))));
											}
											if (entityiterator instanceof LivingEntity)
												((LivingEntity) entityiterator).addPotionEffect(
														new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
											{
												Entity _ent = entityiterator;
												if (!_ent.world.isRemote && _ent.world.getServer() != null) {
													_ent.world.getServer().getCommandManager().handleCommand(
															_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "/kill @s");
												}
											}
											{
												Entity _ent = entityiterator;
												if (!_ent.world.isRemote && _ent.world.getServer() != null) {
													_ent.world.getServer().getCommandManager().handleCommand(
															_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
															"/deta merge entity @s (Health:0)");
												}
											}
										}
									}
								} else {
									if (entityiterator instanceof MobEntity) {
										if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
												.getItem() == DemonScytheItem.block) {
											if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
													((entity instanceof LivingEntity)
															? ((LivingEntity) entity).getHeldItemMainhand()
															: ItemStack.EMPTY)) != 0)) {
												if (entity instanceof LivingEntity)
													((LivingEntity) entity).setHealth(
															(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																	+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																			((entity instanceof LivingEntity)
																					? ((LivingEntity) entity).getHeldItemMainhand()
																					: ItemStack.EMPTY))));
											}
											if (entityiterator instanceof LivingEntity)
												((LivingEntity) entityiterator).addPotionEffect(
														new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
											entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 10);
										} else {
											if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
													((entity instanceof LivingEntity)
															? ((LivingEntity) entity).getHeldItemMainhand()
															: ItemStack.EMPTY)) != 0)) {
												if (entity instanceof LivingEntity)
													((LivingEntity) entity).setHealth(
															(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																	+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																			((entity instanceof LivingEntity)
																					? ((LivingEntity) entity).getHeldItemMainhand()
																					: ItemStack.EMPTY))));
											}
											if (entityiterator instanceof LivingEntity)
												((LivingEntity) entityiterator).addPotionEffect(
														new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
											entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 5);
										}
										if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
												.getItem() == BookbloodItem.block) {
											if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
													((entity instanceof LivingEntity)
															? ((LivingEntity) entity).getHeldItemMainhand()
															: ItemStack.EMPTY)) != 0)) {
												if (entity instanceof LivingEntity)
													((LivingEntity) entity).setHealth(
															(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																	+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																			((entity instanceof LivingEntity)
																					? ((LivingEntity) entity).getHeldItemMainhand()
																					: ItemStack.EMPTY))));
											}
											if (entityiterator instanceof LivingEntity)
												((LivingEntity) entityiterator).addPotionEffect(
														new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
											entityiterator.setFire((int) 15);
											entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 5);
										}
										if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
												.getItem() == PoisonbookItem.block) {
											if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
													((entity instanceof LivingEntity)
															? ((LivingEntity) entity).getHeldItemMainhand()
															: ItemStack.EMPTY)) != 0)) {
												if (entity instanceof LivingEntity)
													((LivingEntity) entity).setHealth(
															(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																	+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																			((entity instanceof LivingEntity)
																					? ((LivingEntity) entity).getHeldItemMainhand()
																					: ItemStack.EMPTY))));
											}
											if (entityiterator instanceof LivingEntity)
												((LivingEntity) entityiterator).addPotionEffect(
														new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
											if (entityiterator instanceof LivingEntity)
												((LivingEntity) entityiterator)
														.addPotionEffect(new EffectInstance(Effects.POISON, (int) 300, (int) 1));
											entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 5);
										}
									}
								}
							}
						}
					}
					loop = (loop + Math.toRadians(5));
					Y_pos = (Y_pos - 0.0555555555555556);
				}
				loop = Math.toRadians(entity.rotationYaw);
				XRadius2 = 3.5;
				ZRadius2 = 3.5;
				Y_pos = (y + 2);
				for (int index1 = 0; index1 < (int) (36); index1++) {
					X = (x + Math.cos(loop) * XRadius2);
					Y = Y_pos;
					Z = (z + Math.sin(loop) * ZRadius2);
					if (world instanceof ServerWorld) {
						((ServerWorld) world).spawnParticle(ParticleTypes.SWEEP_ATTACK, X, Y, Z, (int) 3, 0.1, 0.1, 0.1, 0);
					}
					if (world instanceof ServerWorld) {
						((ServerWorld) world).spawnParticle(ParticleTypes.CLOUD, X, Y, Z, (int) 3, 0.1, 0.1, 0.1, 0);
					}
					if (world instanceof ServerWorld) {
						((ServerWorld) world).spawnParticle(ParticleTypes.TOTEM_OF_UNDYING, X, Y, Z, (int) 3, 0.1, 0.1, 0.1, 0);
					}
					if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
							.getItem() == BookbloodItem.block) {
						if ((EnchantmentHelper.getEnchantmentLevel(KillEnchantment.enchantment,
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)) != 0)) {
							if (world instanceof ServerWorld) {
								((ServerWorld) world).spawnParticle(ParticleTypes.SOUL_FIRE_FLAME, X, Y, Z, (int) 3, 0.1, 0.1, 0.1, 0);
							}
						} else {
							if (world instanceof ServerWorld) {
								((ServerWorld) world).spawnParticle(ParticleTypes.FLAME, X, Y, Z, (int) 3, 0.1, 0.1, 0.1, 0);
							}
						}
					}
					if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
							.getItem() == PoisonbookItem.block) {
						if (world instanceof ServerWorld) {
							((ServerWorld) world).spawnParticle(DokuroParticle.particle, X, Y, Z, (int) 3, 0.1, 0.1, 0.1, 0);
						}
					}
					{
						List<Entity> _entfound = world
								.getEntitiesWithinAABB(Entity.class,
										new AxisAlignedBB(X - (3 / 2d), Y - (3 / 2d), Z - (3 / 2d), X + (3 / 2d), Y + (3 / 2d), Z + (3 / 2d)), null)
								.stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
									}
								}.compareDistOf(X, Y, Z)).collect(Collectors.toList());
						for (Entity entityiterator : _entfound) {
							if (!(entityiterator == entity)) {
								if ((EnchantmentHelper.getEnchantmentLevel(KillEnchantment.enchantment,
										((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)) != 0)) {
									if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
											.getItem() == BookbloodItem.block
											|| ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
													.getItem() == PoisonbookItem.block) {
										if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
												.getItem() == BookbloodItem.block) {
											if (entityiterator instanceof MobEntity) {
												if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
														((entity instanceof LivingEntity)
																? ((LivingEntity) entity).getHeldItemMainhand()
																: ItemStack.EMPTY)) != 0)) {
													if (entity instanceof LivingEntity)
														((LivingEntity) entity).setHealth(
																(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																		+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																				((entity instanceof LivingEntity)
																						? ((LivingEntity) entity).getHeldItemMainhand()
																						: ItemStack.EMPTY))));
												}
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator).addPotionEffect(
															new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
												entityiterator.setFire((int) 15);
												{
													Entity _ent = entityiterator;
													if (!_ent.world.isRemote && _ent.world.getServer() != null) {
														_ent.world.getServer().getCommandManager().handleCommand(
																_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "/kill @s");
													}
												}
												{
													Entity _ent = entityiterator;
													if (!_ent.world.isRemote && _ent.world.getServer() != null) {
														_ent.world.getServer().getCommandManager().handleCommand(
																_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																"/deta merge entity @s (Health:0)");
													}
												}
											}
										}
										if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
												.getItem() == PoisonbookItem.block) {
											if (entityiterator instanceof MobEntity) {
												if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
														((entity instanceof LivingEntity)
																? ((LivingEntity) entity).getHeldItemMainhand()
																: ItemStack.EMPTY)) != 0)) {
													if (entity instanceof LivingEntity)
														((LivingEntity) entity).setHealth(
																(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																		+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																				((entity instanceof LivingEntity)
																						? ((LivingEntity) entity).getHeldItemMainhand()
																						: ItemStack.EMPTY))));
												}
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator).addPotionEffect(
															new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator)
															.addPotionEffect(new EffectInstance(Effects.POISON, (int) 300, (int) 1));
												{
													Entity _ent = entityiterator;
													if (!_ent.world.isRemote && _ent.world.getServer() != null) {
														_ent.world.getServer().getCommandManager().handleCommand(
																_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "/kill @s");
													}
												}
												{
													Entity _ent = entityiterator;
													if (!_ent.world.isRemote && _ent.world.getServer() != null) {
														_ent.world.getServer().getCommandManager().handleCommand(
																_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																"/deta merge entity @s (Health:0)");
													}
												}
											}
										}
									} else {
										if (entityiterator instanceof MobEntity) {
											if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
													((entity instanceof LivingEntity)
															? ((LivingEntity) entity).getHeldItemMainhand()
															: ItemStack.EMPTY)) != 0)) {
												if (entity instanceof LivingEntity)
													((LivingEntity) entity).setHealth(
															(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																	+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																			((entity instanceof LivingEntity)
																					? ((LivingEntity) entity).getHeldItemMainhand()
																					: ItemStack.EMPTY))));
											}
											if (entityiterator instanceof LivingEntity)
												((LivingEntity) entityiterator).addPotionEffect(
														new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
											{
												Entity _ent = entityiterator;
												if (!_ent.world.isRemote && _ent.world.getServer() != null) {
													_ent.world.getServer().getCommandManager().handleCommand(
															_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "/kill @s");
												}
											}
											{
												Entity _ent = entityiterator;
												if (!_ent.world.isRemote && _ent.world.getServer() != null) {
													_ent.world.getServer().getCommandManager().handleCommand(
															_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
															"/deta merge entity @s (Health:0)");
												}
											}
										}
									}
								} else {
									if (entityiterator instanceof MobEntity) {
										if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
												.getItem() == DemonScytheItem.block) {
											if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
													((entity instanceof LivingEntity)
															? ((LivingEntity) entity).getHeldItemMainhand()
															: ItemStack.EMPTY)) != 0)) {
												if (entity instanceof LivingEntity)
													((LivingEntity) entity).setHealth(
															(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																	+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																			((entity instanceof LivingEntity)
																					? ((LivingEntity) entity).getHeldItemMainhand()
																					: ItemStack.EMPTY))));
											}
											if (entityiterator instanceof LivingEntity)
												((LivingEntity) entityiterator).addPotionEffect(
														new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
											entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 10);
										} else {
											if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
													((entity instanceof LivingEntity)
															? ((LivingEntity) entity).getHeldItemMainhand()
															: ItemStack.EMPTY)) != 0)) {
												if (entity instanceof LivingEntity)
													((LivingEntity) entity).setHealth(
															(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																	+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																			((entity instanceof LivingEntity)
																					? ((LivingEntity) entity).getHeldItemMainhand()
																					: ItemStack.EMPTY))));
											}
											if (entityiterator instanceof LivingEntity)
												((LivingEntity) entityiterator).addPotionEffect(
														new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
											entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 5);
										}
										if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
												.getItem() == BookbloodItem.block) {
											if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
													((entity instanceof LivingEntity)
															? ((LivingEntity) entity).getHeldItemMainhand()
															: ItemStack.EMPTY)) != 0)) {
												if (entity instanceof LivingEntity)
													((LivingEntity) entity).setHealth(
															(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																	+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																			((entity instanceof LivingEntity)
																					? ((LivingEntity) entity).getHeldItemMainhand()
																					: ItemStack.EMPTY))));
											}
											if (entityiterator instanceof LivingEntity)
												((LivingEntity) entityiterator).addPotionEffect(
														new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
											entityiterator.setFire((int) 15);
											entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 5);
										}
										if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
												.getItem() == PoisonbookItem.block) {
											if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
													((entity instanceof LivingEntity)
															? ((LivingEntity) entity).getHeldItemMainhand()
															: ItemStack.EMPTY)) != 0)) {
												if (entity instanceof LivingEntity)
													((LivingEntity) entity).setHealth(
															(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																	+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																			((entity instanceof LivingEntity)
																					? ((LivingEntity) entity).getHeldItemMainhand()
																					: ItemStack.EMPTY))));
											}
											if (entityiterator instanceof LivingEntity)
												((LivingEntity) entityiterator).addPotionEffect(
														new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
											if (entityiterator instanceof LivingEntity)
												((LivingEntity) entityiterator)
														.addPotionEffect(new EffectInstance(Effects.POISON, (int) 300, (int) 1));
											entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 5);
										}
									}
								}
							}
						}
					}
					loop = (loop + Math.toRadians(5));
					Y_pos = (Y_pos - 0.0555555555555556);
				}
				loop = Math.toRadians(entity.rotationYaw);
				XRadius2 = 4;
				ZRadius2 = 4;
				Y_pos = (y + 2);
				for (int index2 = 0; index2 < (int) (36); index2++) {
					X = (x + Math.cos(loop) * XRadius2);
					Y = Y_pos;
					Z = (z + Math.sin(loop) * ZRadius2);
					if (world instanceof ServerWorld) {
						((ServerWorld) world).spawnParticle(ParticleTypes.SWEEP_ATTACK, X, Y, Z, (int) 3, 0.1, 0.1, 0.1, 0);
					}
					if (world instanceof ServerWorld) {
						((ServerWorld) world).spawnParticle(ParticleTypes.CLOUD, X, Y, Z, (int) 3, 0.1, 0.1, 0.1, 0);
					}
					if (world instanceof ServerWorld) {
						((ServerWorld) world).spawnParticle(ParticleTypes.TOTEM_OF_UNDYING, X, Y, Z, (int) 3, 0.1, 0.1, 0.1, 0);
					}
					if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
							.getItem() == BookbloodItem.block) {
						if ((EnchantmentHelper.getEnchantmentLevel(KillEnchantment.enchantment,
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)) != 0)) {
							if (world instanceof ServerWorld) {
								((ServerWorld) world).spawnParticle(ParticleTypes.SOUL_FIRE_FLAME, X, Y, Z, (int) 3, 0.1, 0.1, 0.1, 0);
							}
						} else {
							if (world instanceof ServerWorld) {
								((ServerWorld) world).spawnParticle(ParticleTypes.FLAME, X, Y, Z, (int) 3, 0.1, 0.1, 0.1, 0);
							}
						}
					}
					if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
							.getItem() == PoisonbookItem.block) {
						if (world instanceof ServerWorld) {
							((ServerWorld) world).spawnParticle(DokuroParticle.particle, X, Y, Z, (int) 3, 0.1, 0.1, 0.1, 0);
						}
					}
					{
						List<Entity> _entfound = world
								.getEntitiesWithinAABB(Entity.class,
										new AxisAlignedBB(X - (3 / 2d), Y - (3 / 2d), Z - (3 / 2d), X + (3 / 2d), Y + (3 / 2d), Z + (3 / 2d)), null)
								.stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
									}
								}.compareDistOf(X, Y, Z)).collect(Collectors.toList());
						for (Entity entityiterator : _entfound) {
							if (!(entityiterator == entity)) {
								if ((EnchantmentHelper.getEnchantmentLevel(KillEnchantment.enchantment,
										((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)) != 0)) {
									if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
											.getItem() == BookbloodItem.block
											|| ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
													.getItem() == PoisonbookItem.block) {
										if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
												.getItem() == BookbloodItem.block) {
											if (entityiterator instanceof MobEntity) {
												if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
														((entity instanceof LivingEntity)
																? ((LivingEntity) entity).getHeldItemMainhand()
																: ItemStack.EMPTY)) != 0)) {
													if (entity instanceof LivingEntity)
														((LivingEntity) entity).setHealth(
																(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																		+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																				((entity instanceof LivingEntity)
																						? ((LivingEntity) entity).getHeldItemMainhand()
																						: ItemStack.EMPTY))));
												}
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator).addPotionEffect(
															new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
												entityiterator.setFire((int) 15);
												{
													Entity _ent = entityiterator;
													if (!_ent.world.isRemote && _ent.world.getServer() != null) {
														_ent.world.getServer().getCommandManager().handleCommand(
																_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "/kill @s");
													}
												}
												{
													Entity _ent = entityiterator;
													if (!_ent.world.isRemote && _ent.world.getServer() != null) {
														_ent.world.getServer().getCommandManager().handleCommand(
																_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																"/deta merge entity @s (Health:0)");
													}
												}
											}
										}
										if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
												.getItem() == PoisonbookItem.block) {
											if (entityiterator instanceof MobEntity) {
												if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
														((entity instanceof LivingEntity)
																? ((LivingEntity) entity).getHeldItemMainhand()
																: ItemStack.EMPTY)) != 0)) {
													if (entity instanceof LivingEntity)
														((LivingEntity) entity).setHealth(
																(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																		+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																				((entity instanceof LivingEntity)
																						? ((LivingEntity) entity).getHeldItemMainhand()
																						: ItemStack.EMPTY))));
												}
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator).addPotionEffect(
															new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator)
															.addPotionEffect(new EffectInstance(Effects.POISON, (int) 300, (int) 1));
												{
													Entity _ent = entityiterator;
													if (!_ent.world.isRemote && _ent.world.getServer() != null) {
														_ent.world.getServer().getCommandManager().handleCommand(
																_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "/kill @s");
													}
												}
												{
													Entity _ent = entityiterator;
													if (!_ent.world.isRemote && _ent.world.getServer() != null) {
														_ent.world.getServer().getCommandManager().handleCommand(
																_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																"/deta merge entity @s (Health:0)");
													}
												}
											}
										}
									} else {
										if (entityiterator instanceof MobEntity) {
											if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
													((entity instanceof LivingEntity)
															? ((LivingEntity) entity).getHeldItemMainhand()
															: ItemStack.EMPTY)) != 0)) {
												if (entity instanceof LivingEntity)
													((LivingEntity) entity).setHealth(
															(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																	+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																			((entity instanceof LivingEntity)
																					? ((LivingEntity) entity).getHeldItemMainhand()
																					: ItemStack.EMPTY))));
											}
											if (entityiterator instanceof LivingEntity)
												((LivingEntity) entityiterator).addPotionEffect(
														new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
											{
												Entity _ent = entityiterator;
												if (!_ent.world.isRemote && _ent.world.getServer() != null) {
													_ent.world.getServer().getCommandManager().handleCommand(
															_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "/kill @s");
												}
											}
											{
												Entity _ent = entityiterator;
												if (!_ent.world.isRemote && _ent.world.getServer() != null) {
													_ent.world.getServer().getCommandManager().handleCommand(
															_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
															"/deta merge entity @s (Health:0)");
												}
											}
										}
									}
								} else {
									if (entityiterator instanceof MobEntity) {
										if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
												.getItem() == DemonScytheItem.block) {
											if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
													((entity instanceof LivingEntity)
															? ((LivingEntity) entity).getHeldItemMainhand()
															: ItemStack.EMPTY)) != 0)) {
												if (entity instanceof LivingEntity)
													((LivingEntity) entity).setHealth(
															(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																	+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																			((entity instanceof LivingEntity)
																					? ((LivingEntity) entity).getHeldItemMainhand()
																					: ItemStack.EMPTY))));
											}
											if (entityiterator instanceof LivingEntity)
												((LivingEntity) entityiterator).addPotionEffect(
														new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
											entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 10);
										} else {
											if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
													((entity instanceof LivingEntity)
															? ((LivingEntity) entity).getHeldItemMainhand()
															: ItemStack.EMPTY)) != 0)) {
												if (entity instanceof LivingEntity)
													((LivingEntity) entity).setHealth(
															(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																	+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																			((entity instanceof LivingEntity)
																					? ((LivingEntity) entity).getHeldItemMainhand()
																					: ItemStack.EMPTY))));
											}
											if (entityiterator instanceof LivingEntity)
												((LivingEntity) entityiterator).addPotionEffect(
														new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
											entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 5);
										}
										if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
												.getItem() == BookbloodItem.block) {
											if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
													((entity instanceof LivingEntity)
															? ((LivingEntity) entity).getHeldItemMainhand()
															: ItemStack.EMPTY)) != 0)) {
												if (entity instanceof LivingEntity)
													((LivingEntity) entity).setHealth(
															(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																	+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																			((entity instanceof LivingEntity)
																					? ((LivingEntity) entity).getHeldItemMainhand()
																					: ItemStack.EMPTY))));
											}
											if (entityiterator instanceof LivingEntity)
												((LivingEntity) entityiterator).addPotionEffect(
														new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
											entityiterator.setFire((int) 15);
											entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 5);
										}
										if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
												.getItem() == PoisonbookItem.block) {
											if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
													((entity instanceof LivingEntity)
															? ((LivingEntity) entity).getHeldItemMainhand()
															: ItemStack.EMPTY)) != 0)) {
												if (entity instanceof LivingEntity)
													((LivingEntity) entity).setHealth(
															(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																	+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																			((entity instanceof LivingEntity)
																					? ((LivingEntity) entity).getHeldItemMainhand()
																					: ItemStack.EMPTY))));
											}
											if (entityiterator instanceof LivingEntity)
												((LivingEntity) entityiterator).addPotionEffect(
														new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
											if (entityiterator instanceof LivingEntity)
												((LivingEntity) entityiterator)
														.addPotionEffect(new EffectInstance(Effects.POISON, (int) 300, (int) 1));
											entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 5);
										}
									}
								}
							}
						}
					}
					loop = (loop + Math.toRadians(5));
					Y_pos = (Y_pos - 0.0555555555555556);
				}
				loop = Math.toRadians(entity.rotationYaw);
				XRadius2 = 4.5;
				ZRadius2 = 4.5;
				Y_pos = (y + 2);
				for (int index3 = 0; index3 < (int) (36); index3++) {
					X = (x + Math.cos(loop) * XRadius2);
					Y = Y_pos;
					Z = (z + Math.sin(loop) * ZRadius2);
					if (world instanceof ServerWorld) {
						((ServerWorld) world).spawnParticle(ParticleTypes.SWEEP_ATTACK, X, Y, Z, (int) 3, 0.1, 0.1, 0.1, 0);
					}
					if (world instanceof ServerWorld) {
						((ServerWorld) world).spawnParticle(ParticleTypes.CLOUD, X, Y, Z, (int) 3, 0.1, 0.1, 0.1, 0);
					}
					if (world instanceof ServerWorld) {
						((ServerWorld) world).spawnParticle(ParticleTypes.TOTEM_OF_UNDYING, X, Y, Z, (int) 3, 0.1, 0.1, 0.1, 0);
					}
					if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
							.getItem() == BookbloodItem.block) {
						if ((EnchantmentHelper.getEnchantmentLevel(KillEnchantment.enchantment,
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)) != 0)) {
							if (world instanceof ServerWorld) {
								((ServerWorld) world).spawnParticle(ParticleTypes.SOUL_FIRE_FLAME, X, Y, Z, (int) 3, 0.1, 0.1, 0.1, 0);
							}
						} else {
							if (world instanceof ServerWorld) {
								((ServerWorld) world).spawnParticle(ParticleTypes.FLAME, X, Y, Z, (int) 3, 0.1, 0.1, 0.1, 0);
							}
						}
					}
					if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
							.getItem() == PoisonbookItem.block) {
						if (world instanceof ServerWorld) {
							((ServerWorld) world).spawnParticle(DokuroParticle.particle, X, Y, Z, (int) 3, 0.1, 0.1, 0.1, 0);
						}
					}
					{
						List<Entity> _entfound = world
								.getEntitiesWithinAABB(Entity.class,
										new AxisAlignedBB(X - (3 / 2d), Y - (3 / 2d), Z - (3 / 2d), X + (3 / 2d), Y + (3 / 2d), Z + (3 / 2d)), null)
								.stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
									}
								}.compareDistOf(X, Y, Z)).collect(Collectors.toList());
						for (Entity entityiterator : _entfound) {
							if (!(entityiterator == entity)) {
								if ((EnchantmentHelper.getEnchantmentLevel(KillEnchantment.enchantment,
										((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)) != 0)) {
									if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
											.getItem() == BookbloodItem.block
											|| ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
													.getItem() == PoisonbookItem.block) {
										if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
												.getItem() == BookbloodItem.block) {
											if (entityiterator instanceof MobEntity) {
												if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
														((entity instanceof LivingEntity)
																? ((LivingEntity) entity).getHeldItemMainhand()
																: ItemStack.EMPTY)) != 0)) {
													if (entity instanceof LivingEntity)
														((LivingEntity) entity).setHealth(
																(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																		+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																				((entity instanceof LivingEntity)
																						? ((LivingEntity) entity).getHeldItemMainhand()
																						: ItemStack.EMPTY))));
												}
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator).addPotionEffect(
															new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
												entityiterator.setFire((int) 15);
												{
													Entity _ent = entityiterator;
													if (!_ent.world.isRemote && _ent.world.getServer() != null) {
														_ent.world.getServer().getCommandManager().handleCommand(
																_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "/kill @s");
													}
												}
												{
													Entity _ent = entityiterator;
													if (!_ent.world.isRemote && _ent.world.getServer() != null) {
														_ent.world.getServer().getCommandManager().handleCommand(
																_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																"/deta merge entity @s (Health:0)");
													}
												}
											}
										}
										if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
												.getItem() == PoisonbookItem.block) {
											if (entityiterator instanceof MobEntity) {
												if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
														((entity instanceof LivingEntity)
																? ((LivingEntity) entity).getHeldItemMainhand()
																: ItemStack.EMPTY)) != 0)) {
													if (entity instanceof LivingEntity)
														((LivingEntity) entity).setHealth(
																(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																		+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																				((entity instanceof LivingEntity)
																						? ((LivingEntity) entity).getHeldItemMainhand()
																						: ItemStack.EMPTY))));
												}
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator).addPotionEffect(
															new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator)
															.addPotionEffect(new EffectInstance(Effects.POISON, (int) 300, (int) 1));
												{
													Entity _ent = entityiterator;
													if (!_ent.world.isRemote && _ent.world.getServer() != null) {
														_ent.world.getServer().getCommandManager().handleCommand(
																_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "/kill @s");
													}
												}
												{
													Entity _ent = entityiterator;
													if (!_ent.world.isRemote && _ent.world.getServer() != null) {
														_ent.world.getServer().getCommandManager().handleCommand(
																_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																"/deta merge entity @s (Health:0)");
													}
												}
											}
										}
									} else {
										if (entityiterator instanceof MobEntity) {
											if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
													((entity instanceof LivingEntity)
															? ((LivingEntity) entity).getHeldItemMainhand()
															: ItemStack.EMPTY)) != 0)) {
												if (entity instanceof LivingEntity)
													((LivingEntity) entity).setHealth(
															(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																	+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																			((entity instanceof LivingEntity)
																					? ((LivingEntity) entity).getHeldItemMainhand()
																					: ItemStack.EMPTY))));
											}
											if (entityiterator instanceof LivingEntity)
												((LivingEntity) entityiterator).addPotionEffect(
														new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
											{
												Entity _ent = entityiterator;
												if (!_ent.world.isRemote && _ent.world.getServer() != null) {
													_ent.world.getServer().getCommandManager().handleCommand(
															_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "/kill @s");
												}
											}
											{
												Entity _ent = entityiterator;
												if (!_ent.world.isRemote && _ent.world.getServer() != null) {
													_ent.world.getServer().getCommandManager().handleCommand(
															_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
															"/deta merge entity @s (Health:0)");
												}
											}
										}
									}
								} else {
									if (entityiterator instanceof MobEntity) {
										if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
												.getItem() == DemonScytheItem.block) {
											if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
													((entity instanceof LivingEntity)
															? ((LivingEntity) entity).getHeldItemMainhand()
															: ItemStack.EMPTY)) != 0)) {
												if (entity instanceof LivingEntity)
													((LivingEntity) entity).setHealth(
															(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																	+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																			((entity instanceof LivingEntity)
																					? ((LivingEntity) entity).getHeldItemMainhand()
																					: ItemStack.EMPTY))));
											}
											if (entityiterator instanceof LivingEntity)
												((LivingEntity) entityiterator).addPotionEffect(
														new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
											entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 10);
										} else {
											if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
													((entity instanceof LivingEntity)
															? ((LivingEntity) entity).getHeldItemMainhand()
															: ItemStack.EMPTY)) != 0)) {
												if (entity instanceof LivingEntity)
													((LivingEntity) entity).setHealth(
															(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																	+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																			((entity instanceof LivingEntity)
																					? ((LivingEntity) entity).getHeldItemMainhand()
																					: ItemStack.EMPTY))));
											}
											if (entityiterator instanceof LivingEntity)
												((LivingEntity) entityiterator).addPotionEffect(
														new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
											entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 5);
										}
										if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
												.getItem() == BookbloodItem.block) {
											if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
													((entity instanceof LivingEntity)
															? ((LivingEntity) entity).getHeldItemMainhand()
															: ItemStack.EMPTY)) != 0)) {
												if (entity instanceof LivingEntity)
													((LivingEntity) entity).setHealth(
															(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																	+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																			((entity instanceof LivingEntity)
																					? ((LivingEntity) entity).getHeldItemMainhand()
																					: ItemStack.EMPTY))));
											}
											if (entityiterator instanceof LivingEntity)
												((LivingEntity) entityiterator).addPotionEffect(
														new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
											entityiterator.setFire((int) 15);
											entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 5);
										}
										if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
												.getItem() == PoisonbookItem.block) {
											if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
													((entity instanceof LivingEntity)
															? ((LivingEntity) entity).getHeldItemMainhand()
															: ItemStack.EMPTY)) != 0)) {
												if (entity instanceof LivingEntity)
													((LivingEntity) entity).setHealth(
															(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																	+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																			((entity instanceof LivingEntity)
																					? ((LivingEntity) entity).getHeldItemMainhand()
																					: ItemStack.EMPTY))));
											}
											if (entityiterator instanceof LivingEntity)
												((LivingEntity) entityiterator).addPotionEffect(
														new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
											if (entityiterator instanceof LivingEntity)
												((LivingEntity) entityiterator)
														.addPotionEffect(new EffectInstance(Effects.POISON, (int) 300, (int) 1));
											entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 5);
										}
									}
								}
							}
						}
					}
					loop = (loop + Math.toRadians(5));
					Y_pos = (Y_pos - 0.0555555555555556);
				}
				loop = Math.toRadians(entity.rotationYaw);
				XRadius2 = 5;
				ZRadius2 = 5;
				Y_pos = (y + 2);
				for (int index4 = 0; index4 < (int) (36); index4++) {
					X = (x + Math.cos(loop) * XRadius2);
					Y = Y_pos;
					Z = (z + Math.sin(loop) * ZRadius2);
					if (world instanceof ServerWorld) {
						((ServerWorld) world).spawnParticle(ParticleTypes.SWEEP_ATTACK, X, Y, Z, (int) 3, 0.1, 0.1, 0.1, 0);
					}
					if (world instanceof ServerWorld) {
						((ServerWorld) world).spawnParticle(ParticleTypes.CLOUD, X, Y, Z, (int) 3, 0.1, 0.1, 0.1, 0);
					}
					if (world instanceof ServerWorld) {
						((ServerWorld) world).spawnParticle(ParticleTypes.TOTEM_OF_UNDYING, X, Y, Z, (int) 3, 0.1, 0.1, 0.1, 0);
					}
					if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
							.getItem() == BookbloodItem.block) {
						if ((EnchantmentHelper.getEnchantmentLevel(KillEnchantment.enchantment,
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)) != 0)) {
							if (world instanceof ServerWorld) {
								((ServerWorld) world).spawnParticle(ParticleTypes.SOUL_FIRE_FLAME, X, Y, Z, (int) 3, 0.1, 0.1, 0.1, 0);
							}
						} else {
							if (world instanceof ServerWorld) {
								((ServerWorld) world).spawnParticle(ParticleTypes.FLAME, X, Y, Z, (int) 3, 0.1, 0.1, 0.1, 0);
							}
						}
					}
					if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
							.getItem() == PoisonbookItem.block) {
						if (world instanceof ServerWorld) {
							((ServerWorld) world).spawnParticle(DokuroParticle.particle, X, Y, Z, (int) 3, 0.1, 0.1, 0.1, 0);
						}
					}
					{
						List<Entity> _entfound = world
								.getEntitiesWithinAABB(Entity.class,
										new AxisAlignedBB(X - (3 / 2d), Y - (3 / 2d), Z - (3 / 2d), X + (3 / 2d), Y + (3 / 2d), Z + (3 / 2d)), null)
								.stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
									}
								}.compareDistOf(X, Y, Z)).collect(Collectors.toList());
						for (Entity entityiterator : _entfound) {
							if (!(entityiterator == entity)) {
								if ((EnchantmentHelper.getEnchantmentLevel(KillEnchantment.enchantment,
										((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)) != 0)) {
									if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
											.getItem() == BookbloodItem.block
											|| ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
													.getItem() == PoisonbookItem.block) {
										if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
												.getItem() == BookbloodItem.block) {
											if (entityiterator instanceof MobEntity) {
												if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
														((entity instanceof LivingEntity)
																? ((LivingEntity) entity).getHeldItemMainhand()
																: ItemStack.EMPTY)) != 0)) {
													if (entity instanceof LivingEntity)
														((LivingEntity) entity).setHealth(
																(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																		+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																				((entity instanceof LivingEntity)
																						? ((LivingEntity) entity).getHeldItemMainhand()
																						: ItemStack.EMPTY))));
												}
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator).addPotionEffect(
															new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
												entityiterator.setFire((int) 15);
												{
													Entity _ent = entityiterator;
													if (!_ent.world.isRemote && _ent.world.getServer() != null) {
														_ent.world.getServer().getCommandManager().handleCommand(
																_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "/kill @s");
													}
												}
												{
													Entity _ent = entityiterator;
													if (!_ent.world.isRemote && _ent.world.getServer() != null) {
														_ent.world.getServer().getCommandManager().handleCommand(
																_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																"/deta merge entity @s (Health:0)");
													}
												}
											}
										}
										if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
												.getItem() == PoisonbookItem.block) {
											if (entityiterator instanceof MobEntity) {
												if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
														((entity instanceof LivingEntity)
																? ((LivingEntity) entity).getHeldItemMainhand()
																: ItemStack.EMPTY)) != 0)) {
													if (entity instanceof LivingEntity)
														((LivingEntity) entity).setHealth(
																(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																		+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																				((entity instanceof LivingEntity)
																						? ((LivingEntity) entity).getHeldItemMainhand()
																						: ItemStack.EMPTY))));
												}
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator).addPotionEffect(
															new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator)
															.addPotionEffect(new EffectInstance(Effects.POISON, (int) 300, (int) 1));
												{
													Entity _ent = entityiterator;
													if (!_ent.world.isRemote && _ent.world.getServer() != null) {
														_ent.world.getServer().getCommandManager().handleCommand(
																_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "/kill @s");
													}
												}
												{
													Entity _ent = entityiterator;
													if (!_ent.world.isRemote && _ent.world.getServer() != null) {
														_ent.world.getServer().getCommandManager().handleCommand(
																_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																"/deta merge entity @s (Health:0)");
													}
												}
											}
										}
									} else {
										if (entityiterator instanceof MobEntity) {
											if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
													((entity instanceof LivingEntity)
															? ((LivingEntity) entity).getHeldItemMainhand()
															: ItemStack.EMPTY)) != 0)) {
												if (entity instanceof LivingEntity)
													((LivingEntity) entity).setHealth(
															(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																	+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																			((entity instanceof LivingEntity)
																					? ((LivingEntity) entity).getHeldItemMainhand()
																					: ItemStack.EMPTY))));
											}
											if (entityiterator instanceof LivingEntity)
												((LivingEntity) entityiterator).addPotionEffect(
														new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
											{
												Entity _ent = entityiterator;
												if (!_ent.world.isRemote && _ent.world.getServer() != null) {
													_ent.world.getServer().getCommandManager().handleCommand(
															_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "/kill @s");
												}
											}
											{
												Entity _ent = entityiterator;
												if (!_ent.world.isRemote && _ent.world.getServer() != null) {
													_ent.world.getServer().getCommandManager().handleCommand(
															_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
															"/deta merge entity @s (Health:0)");
												}
											}
										}
									}
								} else {
									if (entityiterator instanceof MobEntity) {
										if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
												.getItem() == DemonScytheItem.block) {
											if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
													((entity instanceof LivingEntity)
															? ((LivingEntity) entity).getHeldItemMainhand()
															: ItemStack.EMPTY)) != 0)) {
												if (entity instanceof LivingEntity)
													((LivingEntity) entity).setHealth(
															(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																	+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																			((entity instanceof LivingEntity)
																					? ((LivingEntity) entity).getHeldItemMainhand()
																					: ItemStack.EMPTY))));
											}
											if (entityiterator instanceof LivingEntity)
												((LivingEntity) entityiterator).addPotionEffect(
														new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
											entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 10);
										} else {
											if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
													((entity instanceof LivingEntity)
															? ((LivingEntity) entity).getHeldItemMainhand()
															: ItemStack.EMPTY)) != 0)) {
												if (entity instanceof LivingEntity)
													((LivingEntity) entity).setHealth(
															(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																	+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																			((entity instanceof LivingEntity)
																					? ((LivingEntity) entity).getHeldItemMainhand()
																					: ItemStack.EMPTY))));
											}
											if (entityiterator instanceof LivingEntity)
												((LivingEntity) entityiterator).addPotionEffect(
														new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
											entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 5);
										}
										if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
												.getItem() == BookbloodItem.block) {
											if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
													((entity instanceof LivingEntity)
															? ((LivingEntity) entity).getHeldItemMainhand()
															: ItemStack.EMPTY)) != 0)) {
												if (entity instanceof LivingEntity)
													((LivingEntity) entity).setHealth(
															(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																	+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																			((entity instanceof LivingEntity)
																					? ((LivingEntity) entity).getHeldItemMainhand()
																					: ItemStack.EMPTY))));
											}
											if (entityiterator instanceof LivingEntity)
												((LivingEntity) entityiterator).addPotionEffect(
														new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
											entityiterator.setFire((int) 15);
											entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 5);
										}
										if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
												.getItem() == PoisonbookItem.block) {
											if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
													((entity instanceof LivingEntity)
															? ((LivingEntity) entity).getHeldItemMainhand()
															: ItemStack.EMPTY)) != 0)) {
												if (entity instanceof LivingEntity)
													((LivingEntity) entity).setHealth(
															(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																	+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																			((entity instanceof LivingEntity)
																					? ((LivingEntity) entity).getHeldItemMainhand()
																					: ItemStack.EMPTY))));
											}
											if (entityiterator instanceof LivingEntity)
												((LivingEntity) entityiterator).addPotionEffect(
														new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
											if (entityiterator instanceof LivingEntity)
												((LivingEntity) entityiterator)
														.addPotionEffect(new EffectInstance(Effects.POISON, (int) 300, (int) 1));
											entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 5);
										}
									}
								}
							}
						}
					}
					loop = (loop + Math.toRadians(5));
					Y_pos = (Y_pos - 0.0555555555555556);
				}
				loop = Math.toRadians(entity.rotationYaw);
				XRadius2 = 5.5;
				ZRadius2 = 5.5;
				Y_pos = (y + 2);
				for (int index5 = 0; index5 < (int) (36); index5++) {
					X = (x + Math.cos(loop) * XRadius2);
					Y = Y_pos;
					Z = (z + Math.sin(loop) * ZRadius2);
					if (world instanceof ServerWorld) {
						((ServerWorld) world).spawnParticle(ParticleTypes.SWEEP_ATTACK, X, Y, Z, (int) 3, 0.1, 0.1, 0.1, 0);
					}
					if (world instanceof ServerWorld) {
						((ServerWorld) world).spawnParticle(ParticleTypes.CLOUD, X, Y, Z, (int) 3, 0.1, 0.1, 0.1, 0);
					}
					if (world instanceof ServerWorld) {
						((ServerWorld) world).spawnParticle(ParticleTypes.TOTEM_OF_UNDYING, X, Y, Z, (int) 3, 0.1, 0.1, 0.1, 0);
					}
					if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
							.getItem() == BookbloodItem.block) {
						if ((EnchantmentHelper.getEnchantmentLevel(KillEnchantment.enchantment,
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)) != 0)) {
							if (world instanceof ServerWorld) {
								((ServerWorld) world).spawnParticle(ParticleTypes.SOUL_FIRE_FLAME, X, Y, Z, (int) 3, 0.1, 0.1, 0.1, 0);
							}
						} else {
							if (world instanceof ServerWorld) {
								((ServerWorld) world).spawnParticle(ParticleTypes.FLAME, X, Y, Z, (int) 3, 0.1, 0.1, 0.1, 0);
							}
						}
					}
					if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
							.getItem() == PoisonbookItem.block) {
						if (world instanceof ServerWorld) {
							((ServerWorld) world).spawnParticle(DokuroParticle.particle, X, Y, Z, (int) 3, 0.1, 0.1, 0.1, 0);
						}
					}
					{
						List<Entity> _entfound = world
								.getEntitiesWithinAABB(Entity.class,
										new AxisAlignedBB(X - (3 / 2d), Y - (3 / 2d), Z - (3 / 2d), X + (3 / 2d), Y + (3 / 2d), Z + (3 / 2d)), null)
								.stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
									}
								}.compareDistOf(X, Y, Z)).collect(Collectors.toList());
						for (Entity entityiterator : _entfound) {
							if (!(entityiterator == entity)) {
								if ((EnchantmentHelper.getEnchantmentLevel(KillEnchantment.enchantment,
										((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)) != 0)) {
									if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
											.getItem() == BookbloodItem.block
											|| ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
													.getItem() == PoisonbookItem.block) {
										if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
												.getItem() == BookbloodItem.block) {
											if (entityiterator instanceof MobEntity) {
												if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
														((entity instanceof LivingEntity)
																? ((LivingEntity) entity).getHeldItemMainhand()
																: ItemStack.EMPTY)) != 0)) {
													if (entity instanceof LivingEntity)
														((LivingEntity) entity).setHealth(
																(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																		+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																				((entity instanceof LivingEntity)
																						? ((LivingEntity) entity).getHeldItemMainhand()
																						: ItemStack.EMPTY))));
												}
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator).addPotionEffect(
															new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
												entityiterator.setFire((int) 15);
												{
													Entity _ent = entityiterator;
													if (!_ent.world.isRemote && _ent.world.getServer() != null) {
														_ent.world.getServer().getCommandManager().handleCommand(
																_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "/kill @s");
													}
												}
												{
													Entity _ent = entityiterator;
													if (!_ent.world.isRemote && _ent.world.getServer() != null) {
														_ent.world.getServer().getCommandManager().handleCommand(
																_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																"/deta merge entity @s (Health:0)");
													}
												}
											}
										}
										if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
												.getItem() == PoisonbookItem.block) {
											if (entityiterator instanceof MobEntity) {
												if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
														((entity instanceof LivingEntity)
																? ((LivingEntity) entity).getHeldItemMainhand()
																: ItemStack.EMPTY)) != 0)) {
													if (entity instanceof LivingEntity)
														((LivingEntity) entity).setHealth(
																(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																		+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																				((entity instanceof LivingEntity)
																						? ((LivingEntity) entity).getHeldItemMainhand()
																						: ItemStack.EMPTY))));
												}
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator).addPotionEffect(
															new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator)
															.addPotionEffect(new EffectInstance(Effects.POISON, (int) 300, (int) 1));
												{
													Entity _ent = entityiterator;
													if (!_ent.world.isRemote && _ent.world.getServer() != null) {
														_ent.world.getServer().getCommandManager().handleCommand(
																_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "/kill @s");
													}
												}
												{
													Entity _ent = entityiterator;
													if (!_ent.world.isRemote && _ent.world.getServer() != null) {
														_ent.world.getServer().getCommandManager().handleCommand(
																_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																"/deta merge entity @s (Health:0)");
													}
												}
											}
										}
									} else {
										if (entityiterator instanceof MobEntity) {
											if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
													((entity instanceof LivingEntity)
															? ((LivingEntity) entity).getHeldItemMainhand()
															: ItemStack.EMPTY)) != 0)) {
												if (entity instanceof LivingEntity)
													((LivingEntity) entity).setHealth(
															(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																	+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																			((entity instanceof LivingEntity)
																					? ((LivingEntity) entity).getHeldItemMainhand()
																					: ItemStack.EMPTY))));
											}
											if (entityiterator instanceof LivingEntity)
												((LivingEntity) entityiterator).addPotionEffect(
														new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
											{
												Entity _ent = entityiterator;
												if (!_ent.world.isRemote && _ent.world.getServer() != null) {
													_ent.world.getServer().getCommandManager().handleCommand(
															_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "/kill @s");
												}
											}
											{
												Entity _ent = entityiterator;
												if (!_ent.world.isRemote && _ent.world.getServer() != null) {
													_ent.world.getServer().getCommandManager().handleCommand(
															_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
															"/deta merge entity @s (Health:0)");
												}
											}
										}
									}
								} else {
									if (entityiterator instanceof MobEntity) {
										if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
												.getItem() == DemonScytheItem.block) {
											if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
													((entity instanceof LivingEntity)
															? ((LivingEntity) entity).getHeldItemMainhand()
															: ItemStack.EMPTY)) != 0)) {
												if (entity instanceof LivingEntity)
													((LivingEntity) entity).setHealth(
															(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																	+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																			((entity instanceof LivingEntity)
																					? ((LivingEntity) entity).getHeldItemMainhand()
																					: ItemStack.EMPTY))));
											}
											if (entityiterator instanceof LivingEntity)
												((LivingEntity) entityiterator).addPotionEffect(
														new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
											entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 10);
										} else {
											if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
													((entity instanceof LivingEntity)
															? ((LivingEntity) entity).getHeldItemMainhand()
															: ItemStack.EMPTY)) != 0)) {
												if (entity instanceof LivingEntity)
													((LivingEntity) entity).setHealth(
															(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																	+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																			((entity instanceof LivingEntity)
																					? ((LivingEntity) entity).getHeldItemMainhand()
																					: ItemStack.EMPTY))));
											}
											if (entityiterator instanceof LivingEntity)
												((LivingEntity) entityiterator).addPotionEffect(
														new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
											entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 5);
										}
										if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
												.getItem() == BookbloodItem.block) {
											if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
													((entity instanceof LivingEntity)
															? ((LivingEntity) entity).getHeldItemMainhand()
															: ItemStack.EMPTY)) != 0)) {
												if (entity instanceof LivingEntity)
													((LivingEntity) entity).setHealth(
															(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																	+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																			((entity instanceof LivingEntity)
																					? ((LivingEntity) entity).getHeldItemMainhand()
																					: ItemStack.EMPTY))));
											}
											if (entityiterator instanceof LivingEntity)
												((LivingEntity) entityiterator).addPotionEffect(
														new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
											entityiterator.setFire((int) 15);
											entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 5);
										}
										if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
												.getItem() == PoisonbookItem.block) {
											if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
													((entity instanceof LivingEntity)
															? ((LivingEntity) entity).getHeldItemMainhand()
															: ItemStack.EMPTY)) != 0)) {
												if (entity instanceof LivingEntity)
													((LivingEntity) entity).setHealth(
															(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																	+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																			((entity instanceof LivingEntity)
																					? ((LivingEntity) entity).getHeldItemMainhand()
																					: ItemStack.EMPTY))));
											}
											if (entityiterator instanceof LivingEntity)
												((LivingEntity) entityiterator).addPotionEffect(
														new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
											if (entityiterator instanceof LivingEntity)
												((LivingEntity) entityiterator)
														.addPotionEffect(new EffectInstance(Effects.POISON, (int) 300, (int) 1));
											entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 5);
										}
									}
								}
							}
						}
					}
					loop = (loop + Math.toRadians(5));
					Y_pos = (Y_pos - 0.0555555555555556);
				}
				if (!(new Object() {
					public boolean checkGamemode(Entity _ent) {
						if (_ent instanceof ServerPlayerEntity) {
							return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.CREATIVE;
						} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
							NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
									.getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
							return _npi != null && _npi.getGameType() == GameType.CREATIVE;
						}
						return false;
					}
				}.checkGamemode(entity) || new Object() {
					public boolean checkGamemode(Entity _ent) {
						if (_ent instanceof ServerPlayerEntity) {
							return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.SPECTATOR;
						} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
							NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
									.getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
							return _npi != null && _npi.getGameType() == GameType.SPECTATOR;
						}
						return false;
					}
				}.checkGamemode(entity)
						|| (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
								? ((ServerPlayerEntity) entity).getAdvancements()
										.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
												.getAdvancement(new ResourceLocation("japanesesword:tidaisuki")))
										.isDone()
								: false))) {
					if (entity instanceof LivingEntity)
						((LivingEntity) entity)
								.setHealth((float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) - 2));
				}
				if (!(new Object() {
					boolean check(Entity _entity) {
						if (_entity instanceof LivingEntity) {
							Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
							for (EffectInstance effect : effects) {
								if (effect.getPotion() == KurutaimunasiPotionEffect.potion)
									return true;
							}
						}
						return false;
					}
				}.check(entity))) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).getCooldownTracker().setCooldown(DemonScytheItem.block, (int) 10);
				}
			}
		}
		if ((entity.getCapability(JapaneseswordModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new JapaneseswordModVariables.PlayerVariables())).kaunnto == 3) {
			if (2 < ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) || new Object() {
				public boolean checkGamemode(Entity _ent) {
					if (_ent instanceof ServerPlayerEntity) {
						return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.CREATIVE;
					} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
						NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
								.getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
						return _npi != null && _npi.getGameType() == GameType.CREATIVE;
					}
					return false;
				}
			}.checkGamemode(entity) || new Object() {
				public boolean checkGamemode(Entity _ent) {
					if (_ent instanceof ServerPlayerEntity) {
						return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.SPECTATOR;
					} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
						NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
								.getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
						return _npi != null && _npi.getGameType() == GameType.SPECTATOR;
					}
					return false;
				}
			}.checkGamemode(entity)
					|| (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
							? ((ServerPlayerEntity) entity).getAdvancements()
									.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
											.getAdvancement(new ResourceLocation("japanesesword:tidaisuki")))
									.isDone()
							: false)) {
				if (((Entity) world
						.getEntitiesWithinAABB(MobEntity.class,
								new AxisAlignedBB(x - (50 / 2d), y - (50 / 2d), z - (50 / 2d), x + (50 / 2d), y + (50 / 2d), z + (50 / 2d)), null)
						.stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)) != null) {
					entity.getPersistentData().putBoolean("tp", (true));
					entity.getPersistentData().putDouble("X", x);
					entity.getPersistentData().putDouble("Y", y);
					entity.getPersistentData().putDouble("Z", z);
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.BLINDNESS, (int) 60, (int) 255, (false), (false)));
					new Object() {
						private int ticks = 0;
						private float waitTicks;
						private IWorld world;

						public void start(IWorld world, int waitTicks) {
							this.waitTicks = waitTicks;
							MinecraftForge.EVENT_BUS.register(this);
							this.world = world;
						}

						@SubscribeEvent
						public void tick(TickEvent.ServerTickEvent event) {
							if (event.phase == TickEvent.Phase.END) {
								this.ticks += 1;
								if (this.ticks >= this.waitTicks)
									run();
							}
						}

						private void run() {
							if (entity instanceof LivingEntity)
								((LivingEntity) entity)
										.addPotionEffect(new EffectInstance(TpPotionEffect.potion, (int) 60, (int) 1, (false), (false)));
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 60);
					{
						List<Entity> _entfound = world.getEntitiesWithinAABB(Entity.class,
								new AxisAlignedBB(x - (50 / 2d), y - (50 / 2d), z - (50 / 2d), x + (50 / 2d), y + (50 / 2d), z + (50 / 2d)), null)
								.stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
									}
								}.compareDistOf(x, y, z)).collect(Collectors.toList());
						for (Entity entityiterator : _entfound) {
							if (!(entityiterator == entity)) {
								if (entityiterator instanceof MobEntity) {
									if (entityiterator instanceof LivingEntity)
										((LivingEntity) entityiterator)
												.addPotionEffect(new EffectInstance(Effects.GLOWING, (int) 150, (int) 255, (false), (false)));
									if (entityiterator instanceof LivingEntity)
										((LivingEntity) entityiterator)
												.addPotionEffect(new EffectInstance(Tp1PotionEffect.potion, (int) 150, (int) 1, (false), (false)));
								}
							}
						}
					}
				}
				if (!(new Object() {
					public boolean checkGamemode(Entity _ent) {
						if (_ent instanceof ServerPlayerEntity) {
							return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.CREATIVE;
						} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
							NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
									.getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
							return _npi != null && _npi.getGameType() == GameType.CREATIVE;
						}
						return false;
					}
				}.checkGamemode(entity) || new Object() {
					public boolean checkGamemode(Entity _ent) {
						if (_ent instanceof ServerPlayerEntity) {
							return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.SPECTATOR;
						} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
							NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
									.getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
							return _npi != null && _npi.getGameType() == GameType.SPECTATOR;
						}
						return false;
					}
				}.checkGamemode(entity)
						|| (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
								? ((ServerPlayerEntity) entity).getAdvancements()
										.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
												.getAdvancement(new ResourceLocation("japanesesword:tidaisuki")))
										.isDone()
								: false))) {
					if (entity instanceof LivingEntity)
						((LivingEntity) entity)
								.setHealth((float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) - 2));
				}
				if (!(new Object() {
					boolean check(Entity _entity) {
						if (_entity instanceof LivingEntity) {
							Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
							for (EffectInstance effect : effects) {
								if (effect.getPotion() == KurutaimunasiPotionEffect.potion)
									return true;
							}
						}
						return false;
					}
				}.check(entity))) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).getCooldownTracker().setCooldown(DemonScytheItem.block, (int) 140);
				}
			}
		}
		if ((entity.getCapability(JapaneseswordModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new JapaneseswordModVariables.PlayerVariables())).kaunnto == 4) {
			if (2 < ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) || new Object() {
				public boolean checkGamemode(Entity _ent) {
					if (_ent instanceof ServerPlayerEntity) {
						return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.CREATIVE;
					} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
						NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
								.getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
						return _npi != null && _npi.getGameType() == GameType.CREATIVE;
					}
					return false;
				}
			}.checkGamemode(entity) || new Object() {
				public boolean checkGamemode(Entity _ent) {
					if (_ent instanceof ServerPlayerEntity) {
						return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.SPECTATOR;
					} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
						NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
								.getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
						return _npi != null && _npi.getGameType() == GameType.SPECTATOR;
					}
					return false;
				}
			}.checkGamemode(entity)
					|| (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
							? ((ServerPlayerEntity) entity).getAdvancements()
									.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
											.getAdvancement(new ResourceLocation("japanesesword:tidaisuki")))
									.isDone()
							: false)) {
				if (entity instanceof LivingEntity) {
					((LivingEntity) entity).swing(Hand.MAIN_HAND, true);
				}
				angle = (entity.rotationYaw);
				angle = (entity.rotationYaw - 180);
				radiu = 1;
				X = (x + radiu * Math.sin(Math.toRadians(angle)) * 5);
				Z = (z - radiu * Math.cos(Math.toRadians(angle)) * 5);
				for (int index6 = 0; index6 < (int) (5); index6++) {
					for (int index7 = 0; index7 < (int) (15); index7++) {
						if (world instanceof ServerWorld) {
							((ServerWorld) world).spawnParticle(ParticleTypes.SWEEP_ATTACK, (X + radiu * Math.sin(Math.toRadians(angle))), (y + 1),
									(Z + radiu * Math.sin(Math.toRadians(angle))), (int) 2, ((-0.1) * Math.sin(Math.toRadians(angle))), 3,
									((-0.1) * Math.cos(Math.toRadians(angle))), 1);
						}
					}
					{
						List<Entity> _entfound = world.getEntitiesWithinAABB(Entity.class,
								new AxisAlignedBB(X - (4 / 2d), (y + 1) - (4 / 2d), Z - (4 / 2d), X + (4 / 2d), (y + 1) + (4 / 2d), Z + (4 / 2d)),
								null).stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
									}
								}.compareDistOf(X, (y + 1), Z)).collect(Collectors.toList());
						for (Entity entityiterator : _entfound) {
							if (!(entityiterator == entity)) {
								if ((EnchantmentHelper.getEnchantmentLevel(KillEnchantment.enchantment,
										((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)) != 0)) {
									if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
											.getItem() == BookbloodItem.block
											|| ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
													.getItem() == PoisonbookItem.block) {
										if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
												.getItem() == BookbloodItem.block) {
											if (entityiterator instanceof MobEntity) {
												if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
														((entity instanceof LivingEntity)
																? ((LivingEntity) entity).getHeldItemMainhand()
																: ItemStack.EMPTY)) != 0)) {
													if (entity instanceof LivingEntity)
														((LivingEntity) entity).setHealth(
																(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																		+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																				((entity instanceof LivingEntity)
																						? ((LivingEntity) entity).getHeldItemMainhand()
																						: ItemStack.EMPTY))));
												}
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator).addPotionEffect(
															new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
												entityiterator.setFire((int) 15);
												{
													Entity _ent = entityiterator;
													if (!_ent.world.isRemote && _ent.world.getServer() != null) {
														_ent.world.getServer().getCommandManager().handleCommand(
																_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "/kill @s");
													}
												}
												{
													Entity _ent = entityiterator;
													if (!_ent.world.isRemote && _ent.world.getServer() != null) {
														_ent.world.getServer().getCommandManager().handleCommand(
																_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																"/deta merge entity @s (Health:0)");
													}
												}
											}
										}
										if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
												.getItem() == PoisonbookItem.block) {
											if (entityiterator instanceof MobEntity) {
												if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
														((entity instanceof LivingEntity)
																? ((LivingEntity) entity).getHeldItemMainhand()
																: ItemStack.EMPTY)) != 0)) {
													if (entity instanceof LivingEntity)
														((LivingEntity) entity).setHealth(
																(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																		+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																				((entity instanceof LivingEntity)
																						? ((LivingEntity) entity).getHeldItemMainhand()
																						: ItemStack.EMPTY))));
												}
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator).addPotionEffect(
															new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator)
															.addPotionEffect(new EffectInstance(Effects.POISON, (int) 300, (int) 1));
												{
													Entity _ent = entityiterator;
													if (!_ent.world.isRemote && _ent.world.getServer() != null) {
														_ent.world.getServer().getCommandManager().handleCommand(
																_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "/kill @s");
													}
												}
												{
													Entity _ent = entityiterator;
													if (!_ent.world.isRemote && _ent.world.getServer() != null) {
														_ent.world.getServer().getCommandManager().handleCommand(
																_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																"/deta merge entity @s (Health:0)");
													}
												}
											}
										}
									} else {
										if (entityiterator instanceof MobEntity) {
											if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
													((entity instanceof LivingEntity)
															? ((LivingEntity) entity).getHeldItemMainhand()
															: ItemStack.EMPTY)) != 0)) {
												if (entity instanceof LivingEntity)
													((LivingEntity) entity).setHealth(
															(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																	+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																			((entity instanceof LivingEntity)
																					? ((LivingEntity) entity).getHeldItemMainhand()
																					: ItemStack.EMPTY))));
											}
											if (entityiterator instanceof LivingEntity)
												((LivingEntity) entityiterator).addPotionEffect(
														new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
											{
												Entity _ent = entityiterator;
												if (!_ent.world.isRemote && _ent.world.getServer() != null) {
													_ent.world.getServer().getCommandManager().handleCommand(
															_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "/kill @s");
												}
											}
											{
												Entity _ent = entityiterator;
												if (!_ent.world.isRemote && _ent.world.getServer() != null) {
													_ent.world.getServer().getCommandManager().handleCommand(
															_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
															"/deta merge entity @s (Health:0)");
												}
											}
										}
									}
								} else {
									if (entityiterator instanceof MobEntity) {
										if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
												.getItem() == DemonScytheItem.block) {
											if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
													((entity instanceof LivingEntity)
															? ((LivingEntity) entity).getHeldItemMainhand()
															: ItemStack.EMPTY)) != 0)) {
												if (entity instanceof LivingEntity)
													((LivingEntity) entity).setHealth(
															(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																	+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																			((entity instanceof LivingEntity)
																					? ((LivingEntity) entity).getHeldItemMainhand()
																					: ItemStack.EMPTY))));
											}
											if (entityiterator instanceof LivingEntity)
												((LivingEntity) entityiterator).addPotionEffect(
														new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
											entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 10);
										} else {
											if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
													((entity instanceof LivingEntity)
															? ((LivingEntity) entity).getHeldItemMainhand()
															: ItemStack.EMPTY)) != 0)) {
												if (entity instanceof LivingEntity)
													((LivingEntity) entity).setHealth(
															(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																	+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																			((entity instanceof LivingEntity)
																					? ((LivingEntity) entity).getHeldItemMainhand()
																					: ItemStack.EMPTY))));
											}
											if (entityiterator instanceof LivingEntity)
												((LivingEntity) entityiterator).addPotionEffect(
														new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
											entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 5);
										}
										if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
												.getItem() == BookbloodItem.block) {
											if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
													((entity instanceof LivingEntity)
															? ((LivingEntity) entity).getHeldItemMainhand()
															: ItemStack.EMPTY)) != 0)) {
												if (entity instanceof LivingEntity)
													((LivingEntity) entity).setHealth(
															(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																	+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																			((entity instanceof LivingEntity)
																					? ((LivingEntity) entity).getHeldItemMainhand()
																					: ItemStack.EMPTY))));
											}
											if (entityiterator instanceof LivingEntity)
												((LivingEntity) entityiterator).addPotionEffect(
														new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
											entityiterator.setFire((int) 15);
											entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 5);
										}
										if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
												.getItem() == PoisonbookItem.block) {
											if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
													((entity instanceof LivingEntity)
															? ((LivingEntity) entity).getHeldItemMainhand()
															: ItemStack.EMPTY)) != 0)) {
												if (entity instanceof LivingEntity)
													((LivingEntity) entity).setHealth(
															(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																	+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																			((entity instanceof LivingEntity)
																					? ((LivingEntity) entity).getHeldItemMainhand()
																					: ItemStack.EMPTY))));
											}
											if (entityiterator instanceof LivingEntity)
												((LivingEntity) entityiterator).addPotionEffect(
														new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
											if (entityiterator instanceof LivingEntity)
												((LivingEntity) entityiterator)
														.addPotionEffect(new EffectInstance(Effects.POISON, (int) 300, (int) 1));
											entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 5);
										}
									}
								}
							}
						}
					}
					angle = (entity.rotationYaw - 80);
				}
				if (!(new Object() {
					public boolean checkGamemode(Entity _ent) {
						if (_ent instanceof ServerPlayerEntity) {
							return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.CREATIVE;
						} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
							NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
									.getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
							return _npi != null && _npi.getGameType() == GameType.CREATIVE;
						}
						return false;
					}
				}.checkGamemode(entity) || new Object() {
					public boolean checkGamemode(Entity _ent) {
						if (_ent instanceof ServerPlayerEntity) {
							return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.SPECTATOR;
						} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
							NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
									.getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
							return _npi != null && _npi.getGameType() == GameType.SPECTATOR;
						}
						return false;
					}
				}.checkGamemode(entity)
						|| (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
								? ((ServerPlayerEntity) entity).getAdvancements()
										.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
												.getAdvancement(new ResourceLocation("japanesesword:tidaisuki")))
										.isDone()
								: false))) {
					if (entity instanceof LivingEntity)
						((LivingEntity) entity)
								.setHealth((float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) - 2));
				}
				if (!(new Object() {
					boolean check(Entity _entity) {
						if (_entity instanceof LivingEntity) {
							Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
							for (EffectInstance effect : effects) {
								if (effect.getPotion() == KurutaimunasiPotionEffect.potion)
									return true;
							}
						}
						return false;
					}
				}.check(entity))) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).getCooldownTracker().setCooldown(DemonScytheItem.block, (int) 50);
				}
			}
		}
		if ((entity.getCapability(JapaneseswordModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new JapaneseswordModVariables.PlayerVariables())).kaunnto == 5) {
			if (2 < ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) || new Object() {
				public boolean checkGamemode(Entity _ent) {
					if (_ent instanceof ServerPlayerEntity) {
						return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.CREATIVE;
					} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
						NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
								.getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
						return _npi != null && _npi.getGameType() == GameType.CREATIVE;
					}
					return false;
				}
			}.checkGamemode(entity) || new Object() {
				public boolean checkGamemode(Entity _ent) {
					if (_ent instanceof ServerPlayerEntity) {
						return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.SPECTATOR;
					} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
						NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
								.getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
						return _npi != null && _npi.getGameType() == GameType.SPECTATOR;
					}
					return false;
				}
			}.checkGamemode(entity)
					|| (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
							? ((ServerPlayerEntity) entity).getAdvancements()
									.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
											.getAdvancement(new ResourceLocation("japanesesword:tidaisuki")))
									.isDone()
							: false)) {
				if (entity instanceof LivingEntity) {
					((LivingEntity) entity).swing(Hand.MAIN_HAND, true);
				}
				if (new Object() {
					public boolean checkGamemode(Entity _ent) {
						if (_ent instanceof ServerPlayerEntity) {
							return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.SPECTATOR;
						} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
							NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
									.getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
							return _npi != null && _npi.getGameType() == GameType.SPECTATOR;
						}
						return false;
					}
				}.checkGamemode(entity) || new Object() {
					public boolean checkGamemode(Entity _ent) {
						if (_ent instanceof ServerPlayerEntity) {
							return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.CREATIVE;
						} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
							NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
									.getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
							return _npi != null && _npi.getGameType() == GameType.CREATIVE;
						}
						return false;
					}
				}.checkGamemode(entity)) {
					if (entity instanceof PlayerEntity) {
						((PlayerEntity) entity).abilities.disableDamage = (true);
						((PlayerEntity) entity).sendPlayerAbilities();
					}
					new Object() {
						private int ticks = 0;
						private float waitTicks;
						private IWorld world;

						public void start(IWorld world, int waitTicks) {
							this.waitTicks = waitTicks;
							MinecraftForge.EVENT_BUS.register(this);
							this.world = world;
						}

						@SubscribeEvent
						public void tick(TickEvent.ServerTickEvent event) {
							if (event.phase == TickEvent.Phase.END) {
								this.ticks += 1;
								if (this.ticks >= this.waitTicks)
									run();
							}
						}

						private void run() {
							if (entity instanceof PlayerEntity) {
								((PlayerEntity) entity).abilities.disableDamage = (false);
								((PlayerEntity) entity).sendPlayerAbilities();
							}
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 40);
				}
				r = 1;
				alpha = (entity.rotationYaw);
				beta = (entity.rotationPitch);
				{
					List<Entity> _entfound = world
							.getEntitiesWithinAABB(Entity.class,
									new AxisAlignedBB(x - (4 / 2d), y - (4 / 2d), z - (4 / 2d), x + (4 / 2d), y + (4 / 2d), z + (4 / 2d)), null)
							.stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
								}
							}.compareDistOf(x, y, z)).collect(Collectors.toList());
					for (Entity entityiterator : _entfound) {
						{
							Entity _ent = entityiterator;
							_ent.setPositionAndUpdate((entity.getPosX()), (entity.getPosY()), (entity.getPosZ()));
							if (_ent instanceof ServerPlayerEntity) {
								((ServerPlayerEntity) _ent).connection.setPlayerLocation((entity.getPosX()), (entity.getPosY()), (entity.getPosZ()),
										_ent.rotationYaw, _ent.rotationPitch, Collections.emptySet());
							}
						}
					}
				}
				for (int index8 = 0; index8 < (int) (100); index8++) {
					{
						List<Entity> _entfound = world
								.getEntitiesWithinAABB(Entity.class,
										new AxisAlignedBB((x - r * Math.cos(Math.toRadians(beta)) * Math.sin(Math.toRadians(alpha))) - (1 / 2d),
												((y + 1) - r * Math.sin(Math.toRadians(beta))) - (1 / 2d),
												(z + r * Math.cos(Math.toRadians(beta)) * Math.cos(Math.toRadians(alpha))) - (1 / 2d),
												(x - r * Math.cos(Math.toRadians(beta)) * Math.sin(Math.toRadians(alpha))) + (1 / 2d),
												((y + 1) - r * Math.sin(Math.toRadians(beta))) + (1 / 2d),
												(z + r * Math.cos(Math.toRadians(beta)) * Math.cos(Math.toRadians(alpha))) + (1 / 2d)),
										null)
								.stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
									}
								}.compareDistOf((x - r * Math.cos(Math.toRadians(beta)) * Math.sin(Math.toRadians(alpha))),
										((y + 1) - r * Math.sin(Math.toRadians(beta))),
										(z + r * Math.cos(Math.toRadians(beta)) * Math.cos(Math.toRadians(alpha)))))
								.collect(Collectors.toList());
						for (Entity entityiterator : _entfound) {
							{
								Entity _ent = entityiterator;
								_ent.setPositionAndUpdate((entity.getPosX()), (entity.getPosY()), (entity.getPosZ()));
								if (_ent instanceof ServerPlayerEntity) {
									((ServerPlayerEntity) _ent).connection.setPlayerLocation((entity.getPosX()), (entity.getPosY()),
											(entity.getPosZ()), _ent.rotationYaw, _ent.rotationPitch, Collections.emptySet());
								}
							}
						}
					}
					r = (r + 0.2);
				}
				if (!(new Object() {
					public boolean checkGamemode(Entity _ent) {
						if (_ent instanceof ServerPlayerEntity) {
							return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.CREATIVE;
						} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
							NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
									.getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
							return _npi != null && _npi.getGameType() == GameType.CREATIVE;
						}
						return false;
					}
				}.checkGamemode(entity) || new Object() {
					public boolean checkGamemode(Entity _ent) {
						if (_ent instanceof ServerPlayerEntity) {
							return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.SPECTATOR;
						} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
							NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
									.getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
							return _npi != null && _npi.getGameType() == GameType.SPECTATOR;
						}
						return false;
					}
				}.checkGamemode(entity)
						|| (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
								? ((ServerPlayerEntity) entity).getAdvancements()
										.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
												.getAdvancement(new ResourceLocation("japanesesword:tidaisuki")))
										.isDone()
								: false))) {
					if (entity instanceof LivingEntity)
						((LivingEntity) entity)
								.setHealth((float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) - 2));
				}
				if (!(new Object() {
					boolean check(Entity _entity) {
						if (_entity instanceof LivingEntity) {
							Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
							for (EffectInstance effect : effects) {
								if (effect.getPotion() == KurutaimunasiPotionEffect.potion)
									return true;
							}
						}
						return false;
					}
				}.check(entity))) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).getCooldownTracker().setCooldown(DemonScytheItem.block, (int) 7.5);
				}
			}
		}
		if ((entity.getCapability(JapaneseswordModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new JapaneseswordModVariables.PlayerVariables())).kaunnto == 6) {
			if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
					.getItem() == TokinohonnItem.block) {
				if (4 < ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) || new Object() {
					public boolean checkGamemode(Entity _ent) {
						if (_ent instanceof ServerPlayerEntity) {
							return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.CREATIVE;
						} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
							NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
									.getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
							return _npi != null && _npi.getGameType() == GameType.CREATIVE;
						}
						return false;
					}
				}.checkGamemode(entity) || new Object() {
					public boolean checkGamemode(Entity _ent) {
						if (_ent instanceof ServerPlayerEntity) {
							return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.SPECTATOR;
						} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
							NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
									.getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
							return _npi != null && _npi.getGameType() == GameType.SPECTATOR;
						}
						return false;
					}
				}.checkGamemode(entity)
						|| (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
								? ((ServerPlayerEntity) entity).getAdvancements()
										.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
												.getAdvancement(new ResourceLocation("japanesesword:tidaisuki")))
										.isDone()
								: false)) {
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).swing(Hand.MAIN_HAND, true);
					}
					loop = Math.toRadians(entity.rotationYaw);
					xRadius = 3;
					zRadius = 3;
					loop2 = Math.toRadians(entity.rotationYaw);
					loop = 5;
					loop = 5;
					loop3 = Math.toRadians(entity.rotationYaw);
					xRaduis3 = 8;
					zRaduis3 = 8;
					loop4 = Math.toRadians(entity.rotationYaw);
					xRaduis4 = 10;
					zRaduis4 = 10;
					loop5 = Math.toRadians(entity.rotationYaw);
					xRadius5 = 15;
					zRadius5 = 15;
					loop6 = Math.toRadians(entity.rotationYaw);
					xRadius6 = 20;
					zRadius6 = 20;
					for (int index9 = 0; index9 < (int) (36); index9++) {
						X = (x + Math.cos(loop) * xRadius);
						Y = (y + 1);
						Z = (z + Math.sin(loop) * zRadius);
						X2 = (x + Math.cos(loop2) * loop);
						Y2 = (y + 1);
						Z2 = (z + Math.sin(loop2) * loop);
						X3 = (x + Math.cos(loop3) * xRaduis3);
						Y3 = (y + 1);
						Z3 = (z + Math.sin(loop3) * zRaduis3);
						X4 = (x + Math.cos(loop4) * xRaduis4);
						Y4 = (y + 1);
						Z4 = (z + Math.sin(loop4) * zRaduis4);
						X5 = (x + Math.cos(loop5) * xRadius5);
						Y5 = (y + 1);
						Z5 = (z + Math.sin(loop5) * zRadius5);
						X6 = (x + Math.cos(loop6) * xRadius6);
						Y6 = (y + 1);
						Z6 = (z + Math.sin(loop6) * zRadius6);
						if (world instanceof ServerWorld) {
							((ServerWorld) world).spawnParticle(ParticleTypes.END_ROD, X, Y, Z, (int) 3, 0.1, 0.1, 0.1, 0);
						}
						if (world instanceof ServerWorld) {
							((ServerWorld) world).spawnParticle(ParticleTypes.SWEEP_ATTACK, X, Y, Z, (int) 3, 0.1, 0.1, 0.1, 0);
						}
						if (world instanceof ServerWorld) {
							((ServerWorld) world).spawnParticle(ParticleTypes.TOTEM_OF_UNDYING, X, Y, Z, (int) 3, 0.1, 0.1, 0.1, 0);
						}
						if (world instanceof ServerWorld) {
							((ServerWorld) world).spawnParticle(ParticleTypes.END_ROD, X2, Y2, Z2, (int) 3, 0.1, 0.1, 0.1, 0);
						}
						if (world instanceof ServerWorld) {
							((ServerWorld) world).spawnParticle(ParticleTypes.SWEEP_ATTACK, X2, Y2, Z2, (int) 3, 0.1, 0.1, 0.1, 0);
						}
						if (world instanceof ServerWorld) {
							((ServerWorld) world).spawnParticle(ParticleTypes.TOTEM_OF_UNDYING, X2, Y2, Z2, (int) 3, 0.1, 0.1, 0.1, 0);
						}
						if (world instanceof ServerWorld) {
							((ServerWorld) world).spawnParticle(ParticleTypes.END_ROD, X3, Y3, Z3, (int) 3, 0.1, 0.1, 0.1, 0);
						}
						if (world instanceof ServerWorld) {
							((ServerWorld) world).spawnParticle(ParticleTypes.SWEEP_ATTACK, X3, Y3, Z3, (int) 3, 0.1, 0.1, 0.1, 0);
						}
						if (world instanceof ServerWorld) {
							((ServerWorld) world).spawnParticle(ParticleTypes.TOTEM_OF_UNDYING, X3, Y3, Z3, (int) 3, 0.1, 0.1, 0.1, 0);
						}
						if (world instanceof ServerWorld) {
							((ServerWorld) world).spawnParticle(ParticleTypes.END_ROD, X4, Y4, Z4, (int) 3, 0.1, 0.1, 0.1, 0);
						}
						if (world instanceof ServerWorld) {
							((ServerWorld) world).spawnParticle(ParticleTypes.SWEEP_ATTACK, X4, Y4, Z4, (int) 3, 0.1, 0.1, 0.1, 0);
						}
						if (world instanceof ServerWorld) {
							((ServerWorld) world).spawnParticle(ParticleTypes.TOTEM_OF_UNDYING, X4, Y4, Z4, (int) 3, 0.1, 0.1, 0.1, 0);
						}
						if (world instanceof ServerWorld) {
							((ServerWorld) world).spawnParticle(ParticleTypes.END_ROD, X5, Y5, Z5, (int) 3, 0.1, 0.1, 0.1, 0);
						}
						if (world instanceof ServerWorld) {
							((ServerWorld) world).spawnParticle(ParticleTypes.SWEEP_ATTACK, X5, Y5, Z5, (int) 3, 0.1, 0.1, 0.1, 0);
						}
						if (world instanceof ServerWorld) {
							((ServerWorld) world).spawnParticle(ParticleTypes.TOTEM_OF_UNDYING, X5, Y5, Z5, (int) 3, 0.1, 0.1, 0.1, 0);
						}
						if (world instanceof ServerWorld) {
							((ServerWorld) world).spawnParticle(ParticleTypes.END_ROD, X6, Y6, Z6, (int) 3, 0.1, 0.1, 0.1, 0);
						}
						if (world instanceof ServerWorld) {
							((ServerWorld) world).spawnParticle(ParticleTypes.SWEEP_ATTACK, X6, Y6, Z6, (int) 3, 0.1, 0.1, 0.1, 0);
						}
						if (world instanceof ServerWorld) {
							((ServerWorld) world).spawnParticle(ParticleTypes.TOTEM_OF_UNDYING, X6, Y6, Z6, (int) 3, 0.1, 0.1, 0.1, 0);
						}
						{
							List<Entity> _entfound = world.getEntitiesWithinAABB(Entity.class,
									new AxisAlignedBB(X - (3 / 2d), Y - (3 / 2d), Z - (3 / 2d), X + (3 / 2d), Y + (3 / 2d), Z + (3 / 2d)), null)
									.stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
										}
									}.compareDistOf(X, Y, Z)).collect(Collectors.toList());
							for (Entity entityiterator : _entfound) {
								if (!(entityiterator == entity)) {
									if ((EnchantmentHelper.getEnchantmentLevel(KillEnchantment.enchantment,
											((entity instanceof LivingEntity)
													? ((LivingEntity) entity).getHeldItemMainhand()
													: ItemStack.EMPTY)) != 0)) {
										if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
												.getItem() == BookbloodItem.block
												|| ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
														.getItem() == PoisonbookItem.block) {
											if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
													.getItem() == BookbloodItem.block) {
												if (entityiterator instanceof MobEntity) {
													if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
															((entity instanceof LivingEntity)
																	? ((LivingEntity) entity).getHeldItemMainhand()
																	: ItemStack.EMPTY)) != 0)) {
														if (entity instanceof LivingEntity)
															((LivingEntity) entity).setHealth((float) (((entity instanceof LivingEntity)
																	? ((LivingEntity) entity).getHealth()
																	: -1)
																	+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																			((entity instanceof LivingEntity)
																					? ((LivingEntity) entity).getHeldItemMainhand()
																					: ItemStack.EMPTY))));
													}
													if (entityiterator instanceof LivingEntity)
														((LivingEntity) entityiterator).addPotionEffect(
																new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
													entityiterator.setFire((int) 15);
													{
														Entity _ent = entityiterator;
														if (!_ent.world.isRemote && _ent.world.getServer() != null) {
															_ent.world.getServer().getCommandManager().handleCommand(
																	_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																	"/kill @s");
														}
													}
													{
														Entity _ent = entityiterator;
														if (!_ent.world.isRemote && _ent.world.getServer() != null) {
															_ent.world.getServer().getCommandManager().handleCommand(
																	_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																	"/deta merge entity @s (Health:0)");
														}
													}
												}
											}
											if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
													.getItem() == PoisonbookItem.block) {
												if (entityiterator instanceof MobEntity) {
													if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
															((entity instanceof LivingEntity)
																	? ((LivingEntity) entity).getHeldItemMainhand()
																	: ItemStack.EMPTY)) != 0)) {
														if (entity instanceof LivingEntity)
															((LivingEntity) entity).setHealth((float) (((entity instanceof LivingEntity)
																	? ((LivingEntity) entity).getHealth()
																	: -1)
																	+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																			((entity instanceof LivingEntity)
																					? ((LivingEntity) entity).getHeldItemMainhand()
																					: ItemStack.EMPTY))));
													}
													if (entityiterator instanceof LivingEntity)
														((LivingEntity) entityiterator).addPotionEffect(
																new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
													if (entityiterator instanceof LivingEntity)
														((LivingEntity) entityiterator)
																.addPotionEffect(new EffectInstance(Effects.POISON, (int) 300, (int) 1));
													{
														Entity _ent = entityiterator;
														if (!_ent.world.isRemote && _ent.world.getServer() != null) {
															_ent.world.getServer().getCommandManager().handleCommand(
																	_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																	"/kill @s");
														}
													}
													{
														Entity _ent = entityiterator;
														if (!_ent.world.isRemote && _ent.world.getServer() != null) {
															_ent.world.getServer().getCommandManager().handleCommand(
																	_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																	"/deta merge entity @s (Health:0)");
														}
													}
												}
											}
										} else {
											if (entityiterator instanceof MobEntity) {
												if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
														((entity instanceof LivingEntity)
																? ((LivingEntity) entity).getHeldItemMainhand()
																: ItemStack.EMPTY)) != 0)) {
													if (entity instanceof LivingEntity)
														((LivingEntity) entity).setHealth(
																(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																		+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																				((entity instanceof LivingEntity)
																						? ((LivingEntity) entity).getHeldItemMainhand()
																						: ItemStack.EMPTY))));
												}
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator).addPotionEffect(
															new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
												{
													Entity _ent = entityiterator;
													if (!_ent.world.isRemote && _ent.world.getServer() != null) {
														_ent.world.getServer().getCommandManager().handleCommand(
																_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "/kill @s");
													}
												}
												{
													Entity _ent = entityiterator;
													if (!_ent.world.isRemote && _ent.world.getServer() != null) {
														_ent.world.getServer().getCommandManager().handleCommand(
																_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																"/deta merge entity @s (Health:0)");
													}
												}
											}
										}
									} else {
										if (entityiterator instanceof MobEntity) {
											if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
													.getItem() == DemonScytheItem.block) {
												if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
														((entity instanceof LivingEntity)
																? ((LivingEntity) entity).getHeldItemMainhand()
																: ItemStack.EMPTY)) != 0)) {
													if (entity instanceof LivingEntity)
														((LivingEntity) entity).setHealth(
																(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																		+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																				((entity instanceof LivingEntity)
																						? ((LivingEntity) entity).getHeldItemMainhand()
																						: ItemStack.EMPTY))));
												}
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator).addPotionEffect(
															new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
												entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 10);
											} else {
												if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
														((entity instanceof LivingEntity)
																? ((LivingEntity) entity).getHeldItemMainhand()
																: ItemStack.EMPTY)) != 0)) {
													if (entity instanceof LivingEntity)
														((LivingEntity) entity).setHealth(
																(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																		+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																				((entity instanceof LivingEntity)
																						? ((LivingEntity) entity).getHeldItemMainhand()
																						: ItemStack.EMPTY))));
												}
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator).addPotionEffect(
															new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
												entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 5);
											}
											if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
													.getItem() == BookbloodItem.block) {
												if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
														((entity instanceof LivingEntity)
																? ((LivingEntity) entity).getHeldItemMainhand()
																: ItemStack.EMPTY)) != 0)) {
													if (entity instanceof LivingEntity)
														((LivingEntity) entity).setHealth(
																(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																		+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																				((entity instanceof LivingEntity)
																						? ((LivingEntity) entity).getHeldItemMainhand()
																						: ItemStack.EMPTY))));
												}
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator).addPotionEffect(
															new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
												entityiterator.setFire((int) 15);
												entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 5);
											}
											if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
													.getItem() == PoisonbookItem.block) {
												if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
														((entity instanceof LivingEntity)
																? ((LivingEntity) entity).getHeldItemMainhand()
																: ItemStack.EMPTY)) != 0)) {
													if (entity instanceof LivingEntity)
														((LivingEntity) entity).setHealth(
																(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																		+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																				((entity instanceof LivingEntity)
																						? ((LivingEntity) entity).getHeldItemMainhand()
																						: ItemStack.EMPTY))));
												}
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator).addPotionEffect(
															new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator)
															.addPotionEffect(new EffectInstance(Effects.POISON, (int) 300, (int) 1));
												entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 5);
											}
										}
									}
								}
							}
						}
						{
							List<Entity> _entfound = world.getEntitiesWithinAABB(Entity.class,
									new AxisAlignedBB(X2 - (3 / 2d), Y2 - (3 / 2d), Z2 - (3 / 2d), X2 + (3 / 2d), Y2 + (3 / 2d), Z2 + (3 / 2d)), null)
									.stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
										}
									}.compareDistOf(X2, Y2, Z2)).collect(Collectors.toList());
							for (Entity entityiterator : _entfound) {
								if (!(entityiterator == entity)) {
									if ((EnchantmentHelper.getEnchantmentLevel(KillEnchantment.enchantment,
											((entity instanceof LivingEntity)
													? ((LivingEntity) entity).getHeldItemMainhand()
													: ItemStack.EMPTY)) != 0)) {
										if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
												.getItem() == BookbloodItem.block
												|| ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
														.getItem() == PoisonbookItem.block) {
											if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
													.getItem() == BookbloodItem.block) {
												if (entityiterator instanceof MobEntity) {
													if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
															((entity instanceof LivingEntity)
																	? ((LivingEntity) entity).getHeldItemMainhand()
																	: ItemStack.EMPTY)) != 0)) {
														if (entity instanceof LivingEntity)
															((LivingEntity) entity).setHealth((float) (((entity instanceof LivingEntity)
																	? ((LivingEntity) entity).getHealth()
																	: -1)
																	+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																			((entity instanceof LivingEntity)
																					? ((LivingEntity) entity).getHeldItemMainhand()
																					: ItemStack.EMPTY))));
													}
													if (entityiterator instanceof LivingEntity)
														((LivingEntity) entityiterator).addPotionEffect(
																new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
													entityiterator.setFire((int) 15);
													{
														Entity _ent = entityiterator;
														if (!_ent.world.isRemote && _ent.world.getServer() != null) {
															_ent.world.getServer().getCommandManager().handleCommand(
																	_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																	"/kill @s");
														}
													}
													{
														Entity _ent = entityiterator;
														if (!_ent.world.isRemote && _ent.world.getServer() != null) {
															_ent.world.getServer().getCommandManager().handleCommand(
																	_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																	"/deta merge entity @s (Health:0)");
														}
													}
												}
											}
											if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
													.getItem() == PoisonbookItem.block) {
												if (entityiterator instanceof MobEntity) {
													if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
															((entity instanceof LivingEntity)
																	? ((LivingEntity) entity).getHeldItemMainhand()
																	: ItemStack.EMPTY)) != 0)) {
														if (entity instanceof LivingEntity)
															((LivingEntity) entity).setHealth((float) (((entity instanceof LivingEntity)
																	? ((LivingEntity) entity).getHealth()
																	: -1)
																	+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																			((entity instanceof LivingEntity)
																					? ((LivingEntity) entity).getHeldItemMainhand()
																					: ItemStack.EMPTY))));
													}
													if (entityiterator instanceof LivingEntity)
														((LivingEntity) entityiterator).addPotionEffect(
																new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
													if (entityiterator instanceof LivingEntity)
														((LivingEntity) entityiterator)
																.addPotionEffect(new EffectInstance(Effects.POISON, (int) 300, (int) 1));
													{
														Entity _ent = entityiterator;
														if (!_ent.world.isRemote && _ent.world.getServer() != null) {
															_ent.world.getServer().getCommandManager().handleCommand(
																	_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																	"/kill @s");
														}
													}
													{
														Entity _ent = entityiterator;
														if (!_ent.world.isRemote && _ent.world.getServer() != null) {
															_ent.world.getServer().getCommandManager().handleCommand(
																	_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																	"/deta merge entity @s (Health:0)");
														}
													}
												}
											}
										} else {
											if (entityiterator instanceof MobEntity) {
												if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
														((entity instanceof LivingEntity)
																? ((LivingEntity) entity).getHeldItemMainhand()
																: ItemStack.EMPTY)) != 0)) {
													if (entity instanceof LivingEntity)
														((LivingEntity) entity).setHealth(
																(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																		+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																				((entity instanceof LivingEntity)
																						? ((LivingEntity) entity).getHeldItemMainhand()
																						: ItemStack.EMPTY))));
												}
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator).addPotionEffect(
															new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
												{
													Entity _ent = entityiterator;
													if (!_ent.world.isRemote && _ent.world.getServer() != null) {
														_ent.world.getServer().getCommandManager().handleCommand(
																_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "/kill @s");
													}
												}
												{
													Entity _ent = entityiterator;
													if (!_ent.world.isRemote && _ent.world.getServer() != null) {
														_ent.world.getServer().getCommandManager().handleCommand(
																_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																"/deta merge entity @s (Health:0)");
													}
												}
											}
										}
									} else {
										if (entityiterator instanceof MobEntity) {
											if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
													.getItem() == DemonScytheItem.block) {
												if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
														((entity instanceof LivingEntity)
																? ((LivingEntity) entity).getHeldItemMainhand()
																: ItemStack.EMPTY)) != 0)) {
													if (entity instanceof LivingEntity)
														((LivingEntity) entity).setHealth(
																(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																		+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																				((entity instanceof LivingEntity)
																						? ((LivingEntity) entity).getHeldItemMainhand()
																						: ItemStack.EMPTY))));
												}
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator).addPotionEffect(
															new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
												entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 10);
											} else {
												if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
														((entity instanceof LivingEntity)
																? ((LivingEntity) entity).getHeldItemMainhand()
																: ItemStack.EMPTY)) != 0)) {
													if (entity instanceof LivingEntity)
														((LivingEntity) entity).setHealth(
																(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																		+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																				((entity instanceof LivingEntity)
																						? ((LivingEntity) entity).getHeldItemMainhand()
																						: ItemStack.EMPTY))));
												}
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator).addPotionEffect(
															new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
												entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 5);
											}
											if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
													.getItem() == BookbloodItem.block) {
												if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
														((entity instanceof LivingEntity)
																? ((LivingEntity) entity).getHeldItemMainhand()
																: ItemStack.EMPTY)) != 0)) {
													if (entity instanceof LivingEntity)
														((LivingEntity) entity).setHealth(
																(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																		+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																				((entity instanceof LivingEntity)
																						? ((LivingEntity) entity).getHeldItemMainhand()
																						: ItemStack.EMPTY))));
												}
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator).addPotionEffect(
															new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
												entityiterator.setFire((int) 15);
												entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 5);
											}
											if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
													.getItem() == PoisonbookItem.block) {
												if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
														((entity instanceof LivingEntity)
																? ((LivingEntity) entity).getHeldItemMainhand()
																: ItemStack.EMPTY)) != 0)) {
													if (entity instanceof LivingEntity)
														((LivingEntity) entity).setHealth(
																(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																		+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																				((entity instanceof LivingEntity)
																						? ((LivingEntity) entity).getHeldItemMainhand()
																						: ItemStack.EMPTY))));
												}
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator).addPotionEffect(
															new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator)
															.addPotionEffect(new EffectInstance(Effects.POISON, (int) 300, (int) 1));
												entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 5);
											}
										}
									}
								}
							}
						}
						{
							List<Entity> _entfound = world.getEntitiesWithinAABB(Entity.class,
									new AxisAlignedBB(X3 - (3 / 2d), Y3 - (3 / 2d), Z3 - (3 / 2d), X3 + (3 / 2d), Y3 + (3 / 2d), Z3 + (3 / 2d)), null)
									.stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
										}
									}.compareDistOf(X3, Y3, Z3)).collect(Collectors.toList());
							for (Entity entityiterator : _entfound) {
								if (!(entityiterator == entity)) {
									if ((EnchantmentHelper.getEnchantmentLevel(KillEnchantment.enchantment,
											((entity instanceof LivingEntity)
													? ((LivingEntity) entity).getHeldItemMainhand()
													: ItemStack.EMPTY)) != 0)) {
										if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
												.getItem() == BookbloodItem.block
												|| ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
														.getItem() == PoisonbookItem.block) {
											if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
													.getItem() == BookbloodItem.block) {
												if (entityiterator instanceof MobEntity) {
													if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
															((entity instanceof LivingEntity)
																	? ((LivingEntity) entity).getHeldItemMainhand()
																	: ItemStack.EMPTY)) != 0)) {
														if (entity instanceof LivingEntity)
															((LivingEntity) entity).setHealth((float) (((entity instanceof LivingEntity)
																	? ((LivingEntity) entity).getHealth()
																	: -1)
																	+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																			((entity instanceof LivingEntity)
																					? ((LivingEntity) entity).getHeldItemMainhand()
																					: ItemStack.EMPTY))));
													}
													if (entityiterator instanceof LivingEntity)
														((LivingEntity) entityiterator).addPotionEffect(
																new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
													entityiterator.setFire((int) 15);
													{
														Entity _ent = entityiterator;
														if (!_ent.world.isRemote && _ent.world.getServer() != null) {
															_ent.world.getServer().getCommandManager().handleCommand(
																	_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																	"/kill @s");
														}
													}
													{
														Entity _ent = entityiterator;
														if (!_ent.world.isRemote && _ent.world.getServer() != null) {
															_ent.world.getServer().getCommandManager().handleCommand(
																	_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																	"/deta merge entity @s (Health:0)");
														}
													}
												}
											}
											if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
													.getItem() == PoisonbookItem.block) {
												if (entityiterator instanceof MobEntity) {
													if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
															((entity instanceof LivingEntity)
																	? ((LivingEntity) entity).getHeldItemMainhand()
																	: ItemStack.EMPTY)) != 0)) {
														if (entity instanceof LivingEntity)
															((LivingEntity) entity).setHealth((float) (((entity instanceof LivingEntity)
																	? ((LivingEntity) entity).getHealth()
																	: -1)
																	+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																			((entity instanceof LivingEntity)
																					? ((LivingEntity) entity).getHeldItemMainhand()
																					: ItemStack.EMPTY))));
													}
													if (entityiterator instanceof LivingEntity)
														((LivingEntity) entityiterator).addPotionEffect(
																new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
													if (entityiterator instanceof LivingEntity)
														((LivingEntity) entityiterator)
																.addPotionEffect(new EffectInstance(Effects.POISON, (int) 300, (int) 1));
													{
														Entity _ent = entityiterator;
														if (!_ent.world.isRemote && _ent.world.getServer() != null) {
															_ent.world.getServer().getCommandManager().handleCommand(
																	_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																	"/kill @s");
														}
													}
													{
														Entity _ent = entityiterator;
														if (!_ent.world.isRemote && _ent.world.getServer() != null) {
															_ent.world.getServer().getCommandManager().handleCommand(
																	_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																	"/deta merge entity @s (Health:0)");
														}
													}
												}
											}
										} else {
											if (entityiterator instanceof MobEntity) {
												if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
														((entity instanceof LivingEntity)
																? ((LivingEntity) entity).getHeldItemMainhand()
																: ItemStack.EMPTY)) != 0)) {
													if (entity instanceof LivingEntity)
														((LivingEntity) entity).setHealth(
																(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																		+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																				((entity instanceof LivingEntity)
																						? ((LivingEntity) entity).getHeldItemMainhand()
																						: ItemStack.EMPTY))));
												}
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator).addPotionEffect(
															new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
												{
													Entity _ent = entityiterator;
													if (!_ent.world.isRemote && _ent.world.getServer() != null) {
														_ent.world.getServer().getCommandManager().handleCommand(
																_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "/kill @s");
													}
												}
												{
													Entity _ent = entityiterator;
													if (!_ent.world.isRemote && _ent.world.getServer() != null) {
														_ent.world.getServer().getCommandManager().handleCommand(
																_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																"/deta merge entity @s (Health:0)");
													}
												}
											}
										}
									} else {
										if (entityiterator instanceof MobEntity) {
											if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
													.getItem() == DemonScytheItem.block) {
												if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
														((entity instanceof LivingEntity)
																? ((LivingEntity) entity).getHeldItemMainhand()
																: ItemStack.EMPTY)) != 0)) {
													if (entity instanceof LivingEntity)
														((LivingEntity) entity).setHealth(
																(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																		+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																				((entity instanceof LivingEntity)
																						? ((LivingEntity) entity).getHeldItemMainhand()
																						: ItemStack.EMPTY))));
												}
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator).addPotionEffect(
															new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
												entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 10);
											} else {
												if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
														((entity instanceof LivingEntity)
																? ((LivingEntity) entity).getHeldItemMainhand()
																: ItemStack.EMPTY)) != 0)) {
													if (entity instanceof LivingEntity)
														((LivingEntity) entity).setHealth(
																(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																		+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																				((entity instanceof LivingEntity)
																						? ((LivingEntity) entity).getHeldItemMainhand()
																						: ItemStack.EMPTY))));
												}
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator).addPotionEffect(
															new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
												entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 5);
											}
											if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
													.getItem() == BookbloodItem.block) {
												if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
														((entity instanceof LivingEntity)
																? ((LivingEntity) entity).getHeldItemMainhand()
																: ItemStack.EMPTY)) != 0)) {
													if (entity instanceof LivingEntity)
														((LivingEntity) entity).setHealth(
																(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																		+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																				((entity instanceof LivingEntity)
																						? ((LivingEntity) entity).getHeldItemMainhand()
																						: ItemStack.EMPTY))));
												}
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator).addPotionEffect(
															new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
												entityiterator.setFire((int) 15);
												entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 5);
											}
											if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
													.getItem() == PoisonbookItem.block) {
												if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
														((entity instanceof LivingEntity)
																? ((LivingEntity) entity).getHeldItemMainhand()
																: ItemStack.EMPTY)) != 0)) {
													if (entity instanceof LivingEntity)
														((LivingEntity) entity).setHealth(
																(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																		+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																				((entity instanceof LivingEntity)
																						? ((LivingEntity) entity).getHeldItemMainhand()
																						: ItemStack.EMPTY))));
												}
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator).addPotionEffect(
															new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator)
															.addPotionEffect(new EffectInstance(Effects.POISON, (int) 300, (int) 1));
												entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 5);
											}
										}
									}
								}
							}
						}
						{
							List<Entity> _entfound = world.getEntitiesWithinAABB(Entity.class,
									new AxisAlignedBB(X4 - (3 / 2d), Y4 - (3 / 2d), Z4 - (3 / 2d), X4 + (3 / 2d), Y4 + (3 / 2d), Z4 + (3 / 2d)), null)
									.stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
										}
									}.compareDistOf(X4, Y4, Z4)).collect(Collectors.toList());
							for (Entity entityiterator : _entfound) {
								if (!(entityiterator == entity)) {
									if ((EnchantmentHelper.getEnchantmentLevel(KillEnchantment.enchantment,
											((entity instanceof LivingEntity)
													? ((LivingEntity) entity).getHeldItemMainhand()
													: ItemStack.EMPTY)) != 0)) {
										if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
												.getItem() == BookbloodItem.block
												|| ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
														.getItem() == PoisonbookItem.block) {
											if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
													.getItem() == BookbloodItem.block) {
												if (entityiterator instanceof MobEntity) {
													if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
															((entity instanceof LivingEntity)
																	? ((LivingEntity) entity).getHeldItemMainhand()
																	: ItemStack.EMPTY)) != 0)) {
														if (entity instanceof LivingEntity)
															((LivingEntity) entity).setHealth((float) (((entity instanceof LivingEntity)
																	? ((LivingEntity) entity).getHealth()
																	: -1)
																	+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																			((entity instanceof LivingEntity)
																					? ((LivingEntity) entity).getHeldItemMainhand()
																					: ItemStack.EMPTY))));
													}
													if (entityiterator instanceof LivingEntity)
														((LivingEntity) entityiterator).addPotionEffect(
																new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
													entityiterator.setFire((int) 15);
													{
														Entity _ent = entityiterator;
														if (!_ent.world.isRemote && _ent.world.getServer() != null) {
															_ent.world.getServer().getCommandManager().handleCommand(
																	_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																	"/kill @s");
														}
													}
													{
														Entity _ent = entityiterator;
														if (!_ent.world.isRemote && _ent.world.getServer() != null) {
															_ent.world.getServer().getCommandManager().handleCommand(
																	_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																	"/deta merge entity @s (Health:0)");
														}
													}
												}
											}
											if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
													.getItem() == PoisonbookItem.block) {
												if (entityiterator instanceof MobEntity) {
													if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
															((entity instanceof LivingEntity)
																	? ((LivingEntity) entity).getHeldItemMainhand()
																	: ItemStack.EMPTY)) != 0)) {
														if (entity instanceof LivingEntity)
															((LivingEntity) entity).setHealth((float) (((entity instanceof LivingEntity)
																	? ((LivingEntity) entity).getHealth()
																	: -1)
																	+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																			((entity instanceof LivingEntity)
																					? ((LivingEntity) entity).getHeldItemMainhand()
																					: ItemStack.EMPTY))));
													}
													if (entityiterator instanceof LivingEntity)
														((LivingEntity) entityiterator).addPotionEffect(
																new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
													if (entityiterator instanceof LivingEntity)
														((LivingEntity) entityiterator)
																.addPotionEffect(new EffectInstance(Effects.POISON, (int) 300, (int) 1));
													{
														Entity _ent = entityiterator;
														if (!_ent.world.isRemote && _ent.world.getServer() != null) {
															_ent.world.getServer().getCommandManager().handleCommand(
																	_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																	"/kill @s");
														}
													}
													{
														Entity _ent = entityiterator;
														if (!_ent.world.isRemote && _ent.world.getServer() != null) {
															_ent.world.getServer().getCommandManager().handleCommand(
																	_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																	"/deta merge entity @s (Health:0)");
														}
													}
												}
											}
										} else {
											if (entityiterator instanceof MobEntity) {
												if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
														((entity instanceof LivingEntity)
																? ((LivingEntity) entity).getHeldItemMainhand()
																: ItemStack.EMPTY)) != 0)) {
													if (entity instanceof LivingEntity)
														((LivingEntity) entity).setHealth(
																(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																		+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																				((entity instanceof LivingEntity)
																						? ((LivingEntity) entity).getHeldItemMainhand()
																						: ItemStack.EMPTY))));
												}
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator).addPotionEffect(
															new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
												{
													Entity _ent = entityiterator;
													if (!_ent.world.isRemote && _ent.world.getServer() != null) {
														_ent.world.getServer().getCommandManager().handleCommand(
																_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "/kill @s");
													}
												}
												{
													Entity _ent = entityiterator;
													if (!_ent.world.isRemote && _ent.world.getServer() != null) {
														_ent.world.getServer().getCommandManager().handleCommand(
																_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																"/deta merge entity @s (Health:0)");
													}
												}
											}
										}
									} else {
										if (entityiterator instanceof MobEntity) {
											if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
													.getItem() == DemonScytheItem.block) {
												if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
														((entity instanceof LivingEntity)
																? ((LivingEntity) entity).getHeldItemMainhand()
																: ItemStack.EMPTY)) != 0)) {
													if (entity instanceof LivingEntity)
														((LivingEntity) entity).setHealth(
																(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																		+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																				((entity instanceof LivingEntity)
																						? ((LivingEntity) entity).getHeldItemMainhand()
																						: ItemStack.EMPTY))));
												}
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator).addPotionEffect(
															new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
												entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 10);
											} else {
												if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
														((entity instanceof LivingEntity)
																? ((LivingEntity) entity).getHeldItemMainhand()
																: ItemStack.EMPTY)) != 0)) {
													if (entity instanceof LivingEntity)
														((LivingEntity) entity).setHealth(
																(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																		+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																				((entity instanceof LivingEntity)
																						? ((LivingEntity) entity).getHeldItemMainhand()
																						: ItemStack.EMPTY))));
												}
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator).addPotionEffect(
															new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
												entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 5);
											}
											if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
													.getItem() == BookbloodItem.block) {
												if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
														((entity instanceof LivingEntity)
																? ((LivingEntity) entity).getHeldItemMainhand()
																: ItemStack.EMPTY)) != 0)) {
													if (entity instanceof LivingEntity)
														((LivingEntity) entity).setHealth(
																(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																		+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																				((entity instanceof LivingEntity)
																						? ((LivingEntity) entity).getHeldItemMainhand()
																						: ItemStack.EMPTY))));
												}
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator).addPotionEffect(
															new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
												entityiterator.setFire((int) 15);
												entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 5);
											}
											if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
													.getItem() == PoisonbookItem.block) {
												if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
														((entity instanceof LivingEntity)
																? ((LivingEntity) entity).getHeldItemMainhand()
																: ItemStack.EMPTY)) != 0)) {
													if (entity instanceof LivingEntity)
														((LivingEntity) entity).setHealth(
																(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																		+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																				((entity instanceof LivingEntity)
																						? ((LivingEntity) entity).getHeldItemMainhand()
																						: ItemStack.EMPTY))));
												}
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator).addPotionEffect(
															new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator)
															.addPotionEffect(new EffectInstance(Effects.POISON, (int) 300, (int) 1));
												entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 5);
											}
										}
									}
								}
							}
						}
						{
							List<Entity> _entfound = world.getEntitiesWithinAABB(Entity.class,
									new AxisAlignedBB(X5 - (3 / 2d), Y5 - (3 / 2d), Z5 - (3 / 2d), X5 + (3 / 2d), Y5 + (3 / 2d), Z5 + (3 / 2d)), null)
									.stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
										}
									}.compareDistOf(X5, Y5, Z5)).collect(Collectors.toList());
							for (Entity entityiterator : _entfound) {
								if (!(entityiterator == entity)) {
									if ((EnchantmentHelper.getEnchantmentLevel(KillEnchantment.enchantment,
											((entity instanceof LivingEntity)
													? ((LivingEntity) entity).getHeldItemMainhand()
													: ItemStack.EMPTY)) != 0)) {
										if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
												.getItem() == BookbloodItem.block
												|| ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
														.getItem() == PoisonbookItem.block) {
											if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
													.getItem() == BookbloodItem.block) {
												if (entityiterator instanceof MobEntity) {
													if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
															((entity instanceof LivingEntity)
																	? ((LivingEntity) entity).getHeldItemMainhand()
																	: ItemStack.EMPTY)) != 0)) {
														if (entity instanceof LivingEntity)
															((LivingEntity) entity).setHealth((float) (((entity instanceof LivingEntity)
																	? ((LivingEntity) entity).getHealth()
																	: -1)
																	+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																			((entity instanceof LivingEntity)
																					? ((LivingEntity) entity).getHeldItemMainhand()
																					: ItemStack.EMPTY))));
													}
													if (entityiterator instanceof LivingEntity)
														((LivingEntity) entityiterator).addPotionEffect(
																new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
													entityiterator.setFire((int) 15);
													{
														Entity _ent = entityiterator;
														if (!_ent.world.isRemote && _ent.world.getServer() != null) {
															_ent.world.getServer().getCommandManager().handleCommand(
																	_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																	"/kill @s");
														}
													}
													{
														Entity _ent = entityiterator;
														if (!_ent.world.isRemote && _ent.world.getServer() != null) {
															_ent.world.getServer().getCommandManager().handleCommand(
																	_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																	"/deta merge entity @s (Health:0)");
														}
													}
												}
											}
											if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
													.getItem() == PoisonbookItem.block) {
												if (entityiterator instanceof MobEntity) {
													if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
															((entity instanceof LivingEntity)
																	? ((LivingEntity) entity).getHeldItemMainhand()
																	: ItemStack.EMPTY)) != 0)) {
														if (entity instanceof LivingEntity)
															((LivingEntity) entity).setHealth((float) (((entity instanceof LivingEntity)
																	? ((LivingEntity) entity).getHealth()
																	: -1)
																	+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																			((entity instanceof LivingEntity)
																					? ((LivingEntity) entity).getHeldItemMainhand()
																					: ItemStack.EMPTY))));
													}
													if (entityiterator instanceof LivingEntity)
														((LivingEntity) entityiterator).addPotionEffect(
																new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
													if (entityiterator instanceof LivingEntity)
														((LivingEntity) entityiterator)
																.addPotionEffect(new EffectInstance(Effects.POISON, (int) 300, (int) 1));
													{
														Entity _ent = entityiterator;
														if (!_ent.world.isRemote && _ent.world.getServer() != null) {
															_ent.world.getServer().getCommandManager().handleCommand(
																	_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																	"/kill @s");
														}
													}
													{
														Entity _ent = entityiterator;
														if (!_ent.world.isRemote && _ent.world.getServer() != null) {
															_ent.world.getServer().getCommandManager().handleCommand(
																	_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																	"/deta merge entity @s (Health:0)");
														}
													}
												}
											}
										} else {
											if (entityiterator instanceof MobEntity) {
												if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
														((entity instanceof LivingEntity)
																? ((LivingEntity) entity).getHeldItemMainhand()
																: ItemStack.EMPTY)) != 0)) {
													if (entity instanceof LivingEntity)
														((LivingEntity) entity).setHealth(
																(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																		+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																				((entity instanceof LivingEntity)
																						? ((LivingEntity) entity).getHeldItemMainhand()
																						: ItemStack.EMPTY))));
												}
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator).addPotionEffect(
															new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
												{
													Entity _ent = entityiterator;
													if (!_ent.world.isRemote && _ent.world.getServer() != null) {
														_ent.world.getServer().getCommandManager().handleCommand(
																_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "/kill @s");
													}
												}
												{
													Entity _ent = entityiterator;
													if (!_ent.world.isRemote && _ent.world.getServer() != null) {
														_ent.world.getServer().getCommandManager().handleCommand(
																_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																"/deta merge entity @s (Health:0)");
													}
												}
											}
										}
									} else {
										if (entityiterator instanceof MobEntity) {
											if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
													.getItem() == DemonScytheItem.block) {
												if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
														((entity instanceof LivingEntity)
																? ((LivingEntity) entity).getHeldItemMainhand()
																: ItemStack.EMPTY)) != 0)) {
													if (entity instanceof LivingEntity)
														((LivingEntity) entity).setHealth(
																(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																		+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																				((entity instanceof LivingEntity)
																						? ((LivingEntity) entity).getHeldItemMainhand()
																						: ItemStack.EMPTY))));
												}
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator).addPotionEffect(
															new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
												entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 10);
											} else {
												if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
														((entity instanceof LivingEntity)
																? ((LivingEntity) entity).getHeldItemMainhand()
																: ItemStack.EMPTY)) != 0)) {
													if (entity instanceof LivingEntity)
														((LivingEntity) entity).setHealth(
																(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																		+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																				((entity instanceof LivingEntity)
																						? ((LivingEntity) entity).getHeldItemMainhand()
																						: ItemStack.EMPTY))));
												}
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator).addPotionEffect(
															new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
												entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 5);
											}
											if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
													.getItem() == BookbloodItem.block) {
												if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
														((entity instanceof LivingEntity)
																? ((LivingEntity) entity).getHeldItemMainhand()
																: ItemStack.EMPTY)) != 0)) {
													if (entity instanceof LivingEntity)
														((LivingEntity) entity).setHealth(
																(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																		+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																				((entity instanceof LivingEntity)
																						? ((LivingEntity) entity).getHeldItemMainhand()
																						: ItemStack.EMPTY))));
												}
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator).addPotionEffect(
															new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
												entityiterator.setFire((int) 15);
												entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 5);
											}
											if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
													.getItem() == PoisonbookItem.block) {
												if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
														((entity instanceof LivingEntity)
																? ((LivingEntity) entity).getHeldItemMainhand()
																: ItemStack.EMPTY)) != 0)) {
													if (entity instanceof LivingEntity)
														((LivingEntity) entity).setHealth(
																(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																		+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																				((entity instanceof LivingEntity)
																						? ((LivingEntity) entity).getHeldItemMainhand()
																						: ItemStack.EMPTY))));
												}
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator).addPotionEffect(
															new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator)
															.addPotionEffect(new EffectInstance(Effects.POISON, (int) 300, (int) 1));
												entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 5);
											}
										}
									}
								}
							}
						}
						{
							List<Entity> _entfound = world.getEntitiesWithinAABB(Entity.class,
									new AxisAlignedBB(X6 - (3 / 2d), Y6 - (3 / 2d), Z6 - (3 / 2d), X6 + (3 / 2d), Y6 + (3 / 2d), Z6 + (3 / 2d)), null)
									.stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
										}
									}.compareDistOf(X6, Y6, Z6)).collect(Collectors.toList());
							for (Entity entityiterator : _entfound) {
								if (!(entityiterator == entity)) {
									if ((EnchantmentHelper.getEnchantmentLevel(KillEnchantment.enchantment,
											((entity instanceof LivingEntity)
													? ((LivingEntity) entity).getHeldItemMainhand()
													: ItemStack.EMPTY)) != 0)) {
										if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
												.getItem() == BookbloodItem.block
												|| ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
														.getItem() == PoisonbookItem.block) {
											if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
													.getItem() == BookbloodItem.block) {
												if (entityiterator instanceof MobEntity) {
													if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
															((entity instanceof LivingEntity)
																	? ((LivingEntity) entity).getHeldItemMainhand()
																	: ItemStack.EMPTY)) != 0)) {
														if (entity instanceof LivingEntity)
															((LivingEntity) entity).setHealth((float) (((entity instanceof LivingEntity)
																	? ((LivingEntity) entity).getHealth()
																	: -1)
																	+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																			((entity instanceof LivingEntity)
																					? ((LivingEntity) entity).getHeldItemMainhand()
																					: ItemStack.EMPTY))));
													}
													if (entityiterator instanceof LivingEntity)
														((LivingEntity) entityiterator).addPotionEffect(
																new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
													entityiterator.setFire((int) 15);
													{
														Entity _ent = entityiterator;
														if (!_ent.world.isRemote && _ent.world.getServer() != null) {
															_ent.world.getServer().getCommandManager().handleCommand(
																	_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																	"/kill @s");
														}
													}
													{
														Entity _ent = entityiterator;
														if (!_ent.world.isRemote && _ent.world.getServer() != null) {
															_ent.world.getServer().getCommandManager().handleCommand(
																	_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																	"/deta merge entity @s (Health:0)");
														}
													}
												}
											}
											if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
													.getItem() == PoisonbookItem.block) {
												if (entityiterator instanceof MobEntity) {
													if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
															((entity instanceof LivingEntity)
																	? ((LivingEntity) entity).getHeldItemMainhand()
																	: ItemStack.EMPTY)) != 0)) {
														if (entity instanceof LivingEntity)
															((LivingEntity) entity).setHealth((float) (((entity instanceof LivingEntity)
																	? ((LivingEntity) entity).getHealth()
																	: -1)
																	+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																			((entity instanceof LivingEntity)
																					? ((LivingEntity) entity).getHeldItemMainhand()
																					: ItemStack.EMPTY))));
													}
													if (entityiterator instanceof LivingEntity)
														((LivingEntity) entityiterator).addPotionEffect(
																new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
													if (entityiterator instanceof LivingEntity)
														((LivingEntity) entityiterator)
																.addPotionEffect(new EffectInstance(Effects.POISON, (int) 300, (int) 1));
													{
														Entity _ent = entityiterator;
														if (!_ent.world.isRemote && _ent.world.getServer() != null) {
															_ent.world.getServer().getCommandManager().handleCommand(
																	_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																	"/kill @s");
														}
													}
													{
														Entity _ent = entityiterator;
														if (!_ent.world.isRemote && _ent.world.getServer() != null) {
															_ent.world.getServer().getCommandManager().handleCommand(
																	_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																	"/deta merge entity @s (Health:0)");
														}
													}
												}
											}
										} else {
											if (entityiterator instanceof MobEntity) {
												if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
														((entity instanceof LivingEntity)
																? ((LivingEntity) entity).getHeldItemMainhand()
																: ItemStack.EMPTY)) != 0)) {
													if (entity instanceof LivingEntity)
														((LivingEntity) entity).setHealth(
																(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																		+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																				((entity instanceof LivingEntity)
																						? ((LivingEntity) entity).getHeldItemMainhand()
																						: ItemStack.EMPTY))));
												}
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator).addPotionEffect(
															new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
												{
													Entity _ent = entityiterator;
													if (!_ent.world.isRemote && _ent.world.getServer() != null) {
														_ent.world.getServer().getCommandManager().handleCommand(
																_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "/kill @s");
													}
												}
												{
													Entity _ent = entityiterator;
													if (!_ent.world.isRemote && _ent.world.getServer() != null) {
														_ent.world.getServer().getCommandManager().handleCommand(
																_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																"/deta merge entity @s (Health:0)");
													}
												}
											}
										}
									} else {
										if (entityiterator instanceof MobEntity) {
											if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
													.getItem() == DemonScytheItem.block) {
												if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
														((entity instanceof LivingEntity)
																? ((LivingEntity) entity).getHeldItemMainhand()
																: ItemStack.EMPTY)) != 0)) {
													if (entity instanceof LivingEntity)
														((LivingEntity) entity).setHealth(
																(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																		+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																				((entity instanceof LivingEntity)
																						? ((LivingEntity) entity).getHeldItemMainhand()
																						: ItemStack.EMPTY))));
												}
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator).addPotionEffect(
															new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
												entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 10);
											} else {
												if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
														((entity instanceof LivingEntity)
																? ((LivingEntity) entity).getHeldItemMainhand()
																: ItemStack.EMPTY)) != 0)) {
													if (entity instanceof LivingEntity)
														((LivingEntity) entity).setHealth(
																(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																		+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																				((entity instanceof LivingEntity)
																						? ((LivingEntity) entity).getHeldItemMainhand()
																						: ItemStack.EMPTY))));
												}
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator).addPotionEffect(
															new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
												entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 5);
											}
											if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
													.getItem() == BookbloodItem.block) {
												if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
														((entity instanceof LivingEntity)
																? ((LivingEntity) entity).getHeldItemMainhand()
																: ItemStack.EMPTY)) != 0)) {
													if (entity instanceof LivingEntity)
														((LivingEntity) entity).setHealth(
																(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																		+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																				((entity instanceof LivingEntity)
																						? ((LivingEntity) entity).getHeldItemMainhand()
																						: ItemStack.EMPTY))));
												}
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator).addPotionEffect(
															new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
												entityiterator.setFire((int) 15);
												entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 5);
											}
											if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
													.getItem() == PoisonbookItem.block) {
												if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
														((entity instanceof LivingEntity)
																? ((LivingEntity) entity).getHeldItemMainhand()
																: ItemStack.EMPTY)) != 0)) {
													if (entity instanceof LivingEntity)
														((LivingEntity) entity).setHealth(
																(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																		+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																				((entity instanceof LivingEntity)
																						? ((LivingEntity) entity).getHeldItemMainhand()
																						: ItemStack.EMPTY))));
												}
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator).addPotionEffect(
															new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator)
															.addPotionEffect(new EffectInstance(Effects.POISON, (int) 300, (int) 1));
												entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 5);
											}
										}
									}
								}
							}
						}
						loop = (loop + Math.toRadians(5));
						loop2 = (loop2 + Math.toRadians(5));
						loop3 = (loop3 + Math.toRadians(5));
						loop4 = (loop4 + Math.toRadians(5));
						loop5 = (loop5 + Math.toRadians(5));
						loop6 = (loop6 + Math.toRadians(5));
					}
					if (!(new Object() {
						public boolean checkGamemode(Entity _ent) {
							if (_ent instanceof ServerPlayerEntity) {
								return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.CREATIVE;
							} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
								NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
										.getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
								return _npi != null && _npi.getGameType() == GameType.CREATIVE;
							}
							return false;
						}
					}.checkGamemode(entity) || new Object() {
						public boolean checkGamemode(Entity _ent) {
							if (_ent instanceof ServerPlayerEntity) {
								return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.SPECTATOR;
							} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
								NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
										.getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
								return _npi != null && _npi.getGameType() == GameType.SPECTATOR;
							}
							return false;
						}
					}.checkGamemode(entity)
							|| (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
									? ((ServerPlayerEntity) entity).getAdvancements()
											.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
													.getAdvancement(new ResourceLocation("japanesesword:tidaisuki")))
											.isDone()
									: false))) {
						if (entity instanceof LivingEntity)
							((LivingEntity) entity)
									.setHealth((float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) - 4));
					}
					if (!(new Object() {
						boolean check(Entity _entity) {
							if (_entity instanceof LivingEntity) {
								Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
								for (EffectInstance effect : effects) {
									if (effect.getPotion() == KurutaimunasiPotionEffect.potion)
										return true;
								}
							}
							return false;
						}
					}.check(entity))) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(DemonScytheItem.block, (int) 40);
					}
				}
			} else {
				if (5 < ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) || new Object() {
					public boolean checkGamemode(Entity _ent) {
						if (_ent instanceof ServerPlayerEntity) {
							return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.CREATIVE;
						} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
							NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
									.getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
							return _npi != null && _npi.getGameType() == GameType.CREATIVE;
						}
						return false;
					}
				}.checkGamemode(entity) || new Object() {
					public boolean checkGamemode(Entity _ent) {
						if (_ent instanceof ServerPlayerEntity) {
							return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.SPECTATOR;
						} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
							NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
									.getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
							return _npi != null && _npi.getGameType() == GameType.SPECTATOR;
						}
						return false;
					}
				}.checkGamemode(entity)
						|| (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
								? ((ServerPlayerEntity) entity).getAdvancements()
										.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
												.getAdvancement(new ResourceLocation("japanesesword:tidaisuki")))
										.isDone()
								: false)) {
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).swing(Hand.MAIN_HAND, true);
					}
					loop = Math.toRadians(entity.rotationYaw - 180);
					XRadius2 = 3;
					ZRadius2 = 3;
					Y_pos = (y + 5);
					for (int index10 = 0; index10 < (int) (36); index10++) {
						X = (x + Math.cos(loop) * XRadius2);
						Y = Y_pos;
						Z = (z + Math.sin(loop) * ZRadius2);
						if (world instanceof ServerWorld) {
							((ServerWorld) world).spawnParticle(ParticleTypes.SWEEP_ATTACK, X, Y, Z, (int) 3, 0.1, 0.1, 0.1, 0);
						}
						if (world instanceof ServerWorld) {
							((ServerWorld) world).spawnParticle(ParticleTypes.END_ROD, X, Y, Z, (int) 5, 0.1, 0.1, 0.1, 0.2);
						}
						if (world instanceof ServerWorld) {
							((ServerWorld) world).spawnParticle(ParticleTypes.FIREWORK, X, Y, Z, (int) 5, 0.1, 0.1, 0.1, 0.2);
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(X, Y, Z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"particle minecraft:dust 1.000 0.953 0.278 1 ~ ~ ~ 0.2 0.2 0.2 1 10");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(X, Y, Z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"particle minecraft:dust 0.965 1.000 0.490 1 ~ ~ ~ 0.2 0.2 0.2 1 10");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(X, Y, Z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"particle minecraft:dust 0.965 1.000 0.490 1 ~ ~ ~ 0.2 0.2 0.2 1 10");
						}
						if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
								.getItem() == BookbloodItem.block) {
							if ((EnchantmentHelper.getEnchantmentLevel(KillEnchantment.enchantment,
									((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)) != 0)) {
								if (world instanceof ServerWorld) {
									((ServerWorld) world).spawnParticle(ParticleTypes.SOUL_FIRE_FLAME, X, Y, Z, (int) 3, 0.1, 0.1, 0.1, 0);
								}
							} else {
								if (world instanceof ServerWorld) {
									((ServerWorld) world).spawnParticle(ParticleTypes.FLAME, X, Y, Z, (int) 3, 0.1, 0.1, 0.1, 0);
								}
							}
						}
						if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
								.getItem() == PoisonbookItem.block) {
							if (world instanceof ServerWorld) {
								((ServerWorld) world).spawnParticle(DokuroParticle.particle, X, Y, Z, (int) 3, 0.1, 0.1, 0.1, 0);
							}
						}
						{
							List<Entity> _entfound = world.getEntitiesWithinAABB(Entity.class,
									new AxisAlignedBB(X - (3 / 2d), Y - (3 / 2d), Z - (3 / 2d), X + (3 / 2d), Y + (3 / 2d), Z + (3 / 2d)), null)
									.stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
										}
									}.compareDistOf(X, Y, Z)).collect(Collectors.toList());
							for (Entity entityiterator : _entfound) {
								if (!(entityiterator == entity)) {
									if ((EnchantmentHelper.getEnchantmentLevel(KillEnchantment.enchantment,
											((entity instanceof LivingEntity)
													? ((LivingEntity) entity).getHeldItemMainhand()
													: ItemStack.EMPTY)) != 0)) {
										if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
												.getItem() == BookbloodItem.block
												|| ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
														.getItem() == PoisonbookItem.block) {
											if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
													.getItem() == BookbloodItem.block) {
												if (entityiterator instanceof MobEntity) {
													if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
															((entity instanceof LivingEntity)
																	? ((LivingEntity) entity).getHeldItemMainhand()
																	: ItemStack.EMPTY)) != 0)) {
														if (entity instanceof LivingEntity)
															((LivingEntity) entity).setHealth((float) (((entity instanceof LivingEntity)
																	? ((LivingEntity) entity).getHealth()
																	: -1)
																	+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																			((entity instanceof LivingEntity)
																					? ((LivingEntity) entity).getHeldItemMainhand()
																					: ItemStack.EMPTY))));
													}
													if (entityiterator instanceof LivingEntity)
														((LivingEntity) entityiterator).addPotionEffect(
																new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
													entityiterator.setFire((int) 15);
													{
														Entity _ent = entityiterator;
														if (!_ent.world.isRemote && _ent.world.getServer() != null) {
															_ent.world.getServer().getCommandManager().handleCommand(
																	_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																	"/kill @s");
														}
													}
													{
														Entity _ent = entityiterator;
														if (!_ent.world.isRemote && _ent.world.getServer() != null) {
															_ent.world.getServer().getCommandManager().handleCommand(
																	_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																	"/deta merge entity @s (Health:0)");
														}
													}
												}
											}
											if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
													.getItem() == PoisonbookItem.block) {
												if (entityiterator instanceof MobEntity) {
													if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
															((entity instanceof LivingEntity)
																	? ((LivingEntity) entity).getHeldItemMainhand()
																	: ItemStack.EMPTY)) != 0)) {
														if (entity instanceof LivingEntity)
															((LivingEntity) entity).setHealth((float) (((entity instanceof LivingEntity)
																	? ((LivingEntity) entity).getHealth()
																	: -1)
																	+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																			((entity instanceof LivingEntity)
																					? ((LivingEntity) entity).getHeldItemMainhand()
																					: ItemStack.EMPTY))));
													}
													if (entityiterator instanceof LivingEntity)
														((LivingEntity) entityiterator).addPotionEffect(
																new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
													if (entityiterator instanceof LivingEntity)
														((LivingEntity) entityiterator)
																.addPotionEffect(new EffectInstance(Effects.POISON, (int) 300, (int) 1));
													{
														Entity _ent = entityiterator;
														if (!_ent.world.isRemote && _ent.world.getServer() != null) {
															_ent.world.getServer().getCommandManager().handleCommand(
																	_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																	"/kill @s");
														}
													}
													{
														Entity _ent = entityiterator;
														if (!_ent.world.isRemote && _ent.world.getServer() != null) {
															_ent.world.getServer().getCommandManager().handleCommand(
																	_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																	"/deta merge entity @s (Health:0)");
														}
													}
												}
											}
										} else {
											if (entityiterator instanceof MobEntity) {
												if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
														((entity instanceof LivingEntity)
																? ((LivingEntity) entity).getHeldItemMainhand()
																: ItemStack.EMPTY)) != 0)) {
													if (entity instanceof LivingEntity)
														((LivingEntity) entity).setHealth(
																(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																		+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																				((entity instanceof LivingEntity)
																						? ((LivingEntity) entity).getHeldItemMainhand()
																						: ItemStack.EMPTY))));
												}
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator).addPotionEffect(
															new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
												{
													Entity _ent = entityiterator;
													if (!_ent.world.isRemote && _ent.world.getServer() != null) {
														_ent.world.getServer().getCommandManager().handleCommand(
																_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "/kill @s");
													}
												}
												{
													Entity _ent = entityiterator;
													if (!_ent.world.isRemote && _ent.world.getServer() != null) {
														_ent.world.getServer().getCommandManager().handleCommand(
																_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																"/deta merge entity @s (Health:0)");
													}
												}
											}
										}
									} else {
										if (entityiterator instanceof MobEntity) {
											if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
													.getItem() == DemonScytheItem.block) {
												if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
														((entity instanceof LivingEntity)
																? ((LivingEntity) entity).getHeldItemMainhand()
																: ItemStack.EMPTY)) != 0)) {
													if (entity instanceof LivingEntity)
														((LivingEntity) entity).setHealth(
																(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																		+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																				((entity instanceof LivingEntity)
																						? ((LivingEntity) entity).getHeldItemMainhand()
																						: ItemStack.EMPTY))));
												}
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator).addPotionEffect(
															new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
												entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 10);
											} else {
												if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
														((entity instanceof LivingEntity)
																? ((LivingEntity) entity).getHeldItemMainhand()
																: ItemStack.EMPTY)) != 0)) {
													if (entity instanceof LivingEntity)
														((LivingEntity) entity).setHealth(
																(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																		+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																				((entity instanceof LivingEntity)
																						? ((LivingEntity) entity).getHeldItemMainhand()
																						: ItemStack.EMPTY))));
												}
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator).addPotionEffect(
															new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
												entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 5);
											}
											if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
													.getItem() == BookbloodItem.block) {
												if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
														((entity instanceof LivingEntity)
																? ((LivingEntity) entity).getHeldItemMainhand()
																: ItemStack.EMPTY)) != 0)) {
													if (entity instanceof LivingEntity)
														((LivingEntity) entity).setHealth(
																(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																		+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																				((entity instanceof LivingEntity)
																						? ((LivingEntity) entity).getHeldItemMainhand()
																						: ItemStack.EMPTY))));
												}
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator).addPotionEffect(
															new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
												entityiterator.setFire((int) 15);
												entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 5);
											}
											if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
													.getItem() == PoisonbookItem.block) {
												if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
														((entity instanceof LivingEntity)
																? ((LivingEntity) entity).getHeldItemMainhand()
																: ItemStack.EMPTY)) != 0)) {
													if (entity instanceof LivingEntity)
														((LivingEntity) entity).setHealth(
																(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																		+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																				((entity instanceof LivingEntity)
																						? ((LivingEntity) entity).getHeldItemMainhand()
																						: ItemStack.EMPTY))));
												}
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator).addPotionEffect(
															new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator)
															.addPotionEffect(new EffectInstance(Effects.POISON, (int) 300, (int) 1));
												entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 5);
											}
										}
									}
								}
							}
						}
						loop = (loop - Math.toRadians(5));
						Y_pos = (Y_pos - 0.1666666666666667);
					}
					loop = Math.toRadians(entity.rotationYaw);
					XRadius2 = 3;
					ZRadius2 = 3;
					Y_pos = (y + 5);
					for (int index11 = 0; index11 < (int) (36); index11++) {
						X = (x + Math.cos(loop) * XRadius2);
						Y = Y_pos;
						Z = (z + Math.sin(loop) * ZRadius2);
						if (world instanceof ServerWorld) {
							((ServerWorld) world).spawnParticle(ParticleTypes.SWEEP_ATTACK, X, Y, Z, (int) 3, 0.1, 0.1, 0.1, 0);
						}
						if (world instanceof ServerWorld) {
							((ServerWorld) world).spawnParticle(ParticleTypes.END_ROD, X, Y, Z, (int) 5, 0.1, 0.1, 0.1, 0.2);
						}
						if (world instanceof ServerWorld) {
							((ServerWorld) world).spawnParticle(ParticleTypes.FIREWORK, X, Y, Z, (int) 5, 0.1, 0.1, 0.1, 0.2);
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(X, Y, Z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"particle minecraft:dust 1.000 0.914 0.129 1 ~ ~ ~ 0.2 0.2 0.2 1 10");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(X, Y, Z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"particle minecraft:dust 0.941 1.000 0.412 1 ~ ~ ~ 0.2 0.2 0.2 1 10");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(X, Y, Z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"particle minecraft:dust 0.980 1.000 0.729 1 ~ ~ ~ 0.2 0.2 0.2 1 10");
						}
						if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
								.getItem() == BookbloodItem.block) {
							if ((EnchantmentHelper.getEnchantmentLevel(KillEnchantment.enchantment,
									((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)) != 0)) {
								if (world instanceof ServerWorld) {
									((ServerWorld) world).spawnParticle(ParticleTypes.SOUL_FIRE_FLAME, X, Y, Z, (int) 3, 0.1, 0.1, 0.1, 0);
								}
							} else {
								if (world instanceof ServerWorld) {
									((ServerWorld) world).spawnParticle(ParticleTypes.FLAME, X, Y, Z, (int) 3, 0.1, 0.1, 0.1, 0);
								}
							}
						}
						if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
								.getItem() == PoisonbookItem.block) {
							if (world instanceof ServerWorld) {
								((ServerWorld) world).spawnParticle(DokuroParticle.particle, X, Y, Z, (int) 3, 0.1, 0.1, 0.1, 0);
							}
						}
						{
							List<Entity> _entfound = world.getEntitiesWithinAABB(Entity.class,
									new AxisAlignedBB(X - (3 / 2d), Y - (3 / 2d), Z - (3 / 2d), X + (3 / 2d), Y + (3 / 2d), Z + (3 / 2d)), null)
									.stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
										}
									}.compareDistOf(X, Y, Z)).collect(Collectors.toList());
							for (Entity entityiterator : _entfound) {
								if (!(entityiterator == entity)) {
									if ((EnchantmentHelper.getEnchantmentLevel(KillEnchantment.enchantment,
											((entity instanceof LivingEntity)
													? ((LivingEntity) entity).getHeldItemMainhand()
													: ItemStack.EMPTY)) != 0)) {
										if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
												.getItem() == BookbloodItem.block
												|| ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
														.getItem() == PoisonbookItem.block) {
											if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
													.getItem() == BookbloodItem.block) {
												if (entityiterator instanceof MobEntity) {
													if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
															((entity instanceof LivingEntity)
																	? ((LivingEntity) entity).getHeldItemMainhand()
																	: ItemStack.EMPTY)) != 0)) {
														if (entity instanceof LivingEntity)
															((LivingEntity) entity).setHealth((float) (((entity instanceof LivingEntity)
																	? ((LivingEntity) entity).getHealth()
																	: -1)
																	+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																			((entity instanceof LivingEntity)
																					? ((LivingEntity) entity).getHeldItemMainhand()
																					: ItemStack.EMPTY))));
													}
													if (entityiterator instanceof LivingEntity)
														((LivingEntity) entityiterator).addPotionEffect(
																new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
													entityiterator.setFire((int) 15);
													{
														Entity _ent = entityiterator;
														if (!_ent.world.isRemote && _ent.world.getServer() != null) {
															_ent.world.getServer().getCommandManager().handleCommand(
																	_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																	"/kill @s");
														}
													}
													{
														Entity _ent = entityiterator;
														if (!_ent.world.isRemote && _ent.world.getServer() != null) {
															_ent.world.getServer().getCommandManager().handleCommand(
																	_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																	"/deta merge entity @s (Health:0)");
														}
													}
												}
											}
											if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
													.getItem() == PoisonbookItem.block) {
												if (entityiterator instanceof MobEntity) {
													if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
															((entity instanceof LivingEntity)
																	? ((LivingEntity) entity).getHeldItemMainhand()
																	: ItemStack.EMPTY)) != 0)) {
														if (entity instanceof LivingEntity)
															((LivingEntity) entity).setHealth((float) (((entity instanceof LivingEntity)
																	? ((LivingEntity) entity).getHealth()
																	: -1)
																	+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																			((entity instanceof LivingEntity)
																					? ((LivingEntity) entity).getHeldItemMainhand()
																					: ItemStack.EMPTY))));
													}
													if (entityiterator instanceof LivingEntity)
														((LivingEntity) entityiterator).addPotionEffect(
																new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
													if (entityiterator instanceof LivingEntity)
														((LivingEntity) entityiterator)
																.addPotionEffect(new EffectInstance(Effects.POISON, (int) 300, (int) 1));
													{
														Entity _ent = entityiterator;
														if (!_ent.world.isRemote && _ent.world.getServer() != null) {
															_ent.world.getServer().getCommandManager().handleCommand(
																	_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																	"/kill @s");
														}
													}
													{
														Entity _ent = entityiterator;
														if (!_ent.world.isRemote && _ent.world.getServer() != null) {
															_ent.world.getServer().getCommandManager().handleCommand(
																	_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																	"/deta merge entity @s (Health:0)");
														}
													}
												}
											}
										} else {
											if (entityiterator instanceof MobEntity) {
												if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
														((entity instanceof LivingEntity)
																? ((LivingEntity) entity).getHeldItemMainhand()
																: ItemStack.EMPTY)) != 0)) {
													if (entity instanceof LivingEntity)
														((LivingEntity) entity).setHealth(
																(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																		+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																				((entity instanceof LivingEntity)
																						? ((LivingEntity) entity).getHeldItemMainhand()
																						: ItemStack.EMPTY))));
												}
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator).addPotionEffect(
															new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
												{
													Entity _ent = entityiterator;
													if (!_ent.world.isRemote && _ent.world.getServer() != null) {
														_ent.world.getServer().getCommandManager().handleCommand(
																_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "/kill @s");
													}
												}
												{
													Entity _ent = entityiterator;
													if (!_ent.world.isRemote && _ent.world.getServer() != null) {
														_ent.world.getServer().getCommandManager().handleCommand(
																_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																"/deta merge entity @s (Health:0)");
													}
												}
											}
										}
									} else {
										if (entityiterator instanceof MobEntity) {
											if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
													.getItem() == DemonScytheItem.block) {
												if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
														((entity instanceof LivingEntity)
																? ((LivingEntity) entity).getHeldItemMainhand()
																: ItemStack.EMPTY)) != 0)) {
													if (entity instanceof LivingEntity)
														((LivingEntity) entity).setHealth(
																(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																		+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																				((entity instanceof LivingEntity)
																						? ((LivingEntity) entity).getHeldItemMainhand()
																						: ItemStack.EMPTY))));
												}
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator).addPotionEffect(
															new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
												entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 10);
											} else {
												if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
														((entity instanceof LivingEntity)
																? ((LivingEntity) entity).getHeldItemMainhand()
																: ItemStack.EMPTY)) != 0)) {
													if (entity instanceof LivingEntity)
														((LivingEntity) entity).setHealth(
																(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																		+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																				((entity instanceof LivingEntity)
																						? ((LivingEntity) entity).getHeldItemMainhand()
																						: ItemStack.EMPTY))));
												}
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator).addPotionEffect(
															new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
												entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 5);
											}
											if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
													.getItem() == BookbloodItem.block) {
												if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
														((entity instanceof LivingEntity)
																? ((LivingEntity) entity).getHeldItemMainhand()
																: ItemStack.EMPTY)) != 0)) {
													if (entity instanceof LivingEntity)
														((LivingEntity) entity).setHealth(
																(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																		+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																				((entity instanceof LivingEntity)
																						? ((LivingEntity) entity).getHeldItemMainhand()
																						: ItemStack.EMPTY))));
												}
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator).addPotionEffect(
															new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
												entityiterator.setFire((int) 15);
												entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 5);
											}
											if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
													.getItem() == PoisonbookItem.block) {
												if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
														((entity instanceof LivingEntity)
																? ((LivingEntity) entity).getHeldItemMainhand()
																: ItemStack.EMPTY)) != 0)) {
													if (entity instanceof LivingEntity)
														((LivingEntity) entity).setHealth(
																(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																		+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																				((entity instanceof LivingEntity)
																						? ((LivingEntity) entity).getHeldItemMainhand()
																						: ItemStack.EMPTY))));
												}
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator).addPotionEffect(
															new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator)
															.addPotionEffect(new EffectInstance(Effects.POISON, (int) 300, (int) 1));
												entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 5);
											}
										}
									}
								}
							}
						}
						loop = (loop + Math.toRadians(5));
						Y_pos = (Y_pos - 0.1666666666666667);
					}
					loop = Math.toRadians(entity.rotationYaw - 180);
					XRadius2 = 4;
					ZRadius2 = 4;
					Y_pos = (y + 5);
					for (int index12 = 0; index12 < (int) (36); index12++) {
						X = (x + Math.cos(loop) * XRadius2);
						Y = Y_pos;
						Z = (z + Math.sin(loop) * ZRadius2);
						if (world instanceof ServerWorld) {
							((ServerWorld) world).spawnParticle(ParticleTypes.SWEEP_ATTACK, X, Y, Z, (int) 3, 0.1, 0.1, 0.1, 0);
						}
						if (world instanceof ServerWorld) {
							((ServerWorld) world).spawnParticle(ParticleTypes.END_ROD, X, Y, Z, (int) 5, 0.1, 0.1, 0.1, 0.2);
						}
						if (world instanceof ServerWorld) {
							((ServerWorld) world).spawnParticle(ParticleTypes.FIREWORK, X, Y, Z, (int) 5, 0.1, 0.1, 0.1, 0.2);
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(X, Y, Z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"particle minecraft:dust 1.000 0.953 0.278 1 ~ ~ ~ 0.2 0.2 0.2 1 10");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(X, Y, Z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"particle minecraft:dust 0.965 1.000 0.490 1 ~ ~ ~ 0.2 0.2 0.2 1 10");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(X, Y, Z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"particle minecraft:dust 0.965 1.000 0.490 1 ~ ~ ~ 0.2 0.2 0.2 1 10");
						}
						if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
								.getItem() == BookbloodItem.block) {
							if ((EnchantmentHelper.getEnchantmentLevel(KillEnchantment.enchantment,
									((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)) != 0)) {
								if (world instanceof ServerWorld) {
									((ServerWorld) world).spawnParticle(ParticleTypes.SOUL_FIRE_FLAME, X, Y, Z, (int) 3, 0.1, 0.1, 0.1, 0);
								}
							} else {
								if (world instanceof ServerWorld) {
									((ServerWorld) world).spawnParticle(ParticleTypes.FLAME, X, Y, Z, (int) 3, 0.1, 0.1, 0.1, 0);
								}
							}
						}
						if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
								.getItem() == PoisonbookItem.block) {
							if (world instanceof ServerWorld) {
								((ServerWorld) world).spawnParticle(DokuroParticle.particle, X, Y, Z, (int) 3, 0.1, 0.1, 0.1, 0);
							}
						}
						{
							List<Entity> _entfound = world.getEntitiesWithinAABB(Entity.class,
									new AxisAlignedBB(X - (3 / 2d), Y - (3 / 2d), Z - (3 / 2d), X + (3 / 2d), Y + (3 / 2d), Z + (3 / 2d)), null)
									.stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
										}
									}.compareDistOf(X, Y, Z)).collect(Collectors.toList());
							for (Entity entityiterator : _entfound) {
								if (!(entityiterator == entity)) {
									if ((EnchantmentHelper.getEnchantmentLevel(KillEnchantment.enchantment,
											((entity instanceof LivingEntity)
													? ((LivingEntity) entity).getHeldItemMainhand()
													: ItemStack.EMPTY)) != 0)) {
										if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
												.getItem() == BookbloodItem.block
												|| ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
														.getItem() == PoisonbookItem.block) {
											if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
													.getItem() == BookbloodItem.block) {
												if (entityiterator instanceof MobEntity) {
													if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
															((entity instanceof LivingEntity)
																	? ((LivingEntity) entity).getHeldItemMainhand()
																	: ItemStack.EMPTY)) != 0)) {
														if (entity instanceof LivingEntity)
															((LivingEntity) entity).setHealth((float) (((entity instanceof LivingEntity)
																	? ((LivingEntity) entity).getHealth()
																	: -1)
																	+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																			((entity instanceof LivingEntity)
																					? ((LivingEntity) entity).getHeldItemMainhand()
																					: ItemStack.EMPTY))));
													}
													if (entityiterator instanceof LivingEntity)
														((LivingEntity) entityiterator).addPotionEffect(
																new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
													entityiterator.setFire((int) 15);
													{
														Entity _ent = entityiterator;
														if (!_ent.world.isRemote && _ent.world.getServer() != null) {
															_ent.world.getServer().getCommandManager().handleCommand(
																	_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																	"/kill @s");
														}
													}
													{
														Entity _ent = entityiterator;
														if (!_ent.world.isRemote && _ent.world.getServer() != null) {
															_ent.world.getServer().getCommandManager().handleCommand(
																	_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																	"/deta merge entity @s (Health:0)");
														}
													}
												}
											}
											if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
													.getItem() == PoisonbookItem.block) {
												if (entityiterator instanceof MobEntity) {
													if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
															((entity instanceof LivingEntity)
																	? ((LivingEntity) entity).getHeldItemMainhand()
																	: ItemStack.EMPTY)) != 0)) {
														if (entity instanceof LivingEntity)
															((LivingEntity) entity).setHealth((float) (((entity instanceof LivingEntity)
																	? ((LivingEntity) entity).getHealth()
																	: -1)
																	+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																			((entity instanceof LivingEntity)
																					? ((LivingEntity) entity).getHeldItemMainhand()
																					: ItemStack.EMPTY))));
													}
													if (entityiterator instanceof LivingEntity)
														((LivingEntity) entityiterator).addPotionEffect(
																new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
													if (entityiterator instanceof LivingEntity)
														((LivingEntity) entityiterator)
																.addPotionEffect(new EffectInstance(Effects.POISON, (int) 300, (int) 1));
													{
														Entity _ent = entityiterator;
														if (!_ent.world.isRemote && _ent.world.getServer() != null) {
															_ent.world.getServer().getCommandManager().handleCommand(
																	_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																	"/kill @s");
														}
													}
													{
														Entity _ent = entityiterator;
														if (!_ent.world.isRemote && _ent.world.getServer() != null) {
															_ent.world.getServer().getCommandManager().handleCommand(
																	_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																	"/deta merge entity @s (Health:0)");
														}
													}
												}
											}
										} else {
											if (entityiterator instanceof MobEntity) {
												if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
														((entity instanceof LivingEntity)
																? ((LivingEntity) entity).getHeldItemMainhand()
																: ItemStack.EMPTY)) != 0)) {
													if (entity instanceof LivingEntity)
														((LivingEntity) entity).setHealth(
																(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																		+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																				((entity instanceof LivingEntity)
																						? ((LivingEntity) entity).getHeldItemMainhand()
																						: ItemStack.EMPTY))));
												}
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator).addPotionEffect(
															new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
												{
													Entity _ent = entityiterator;
													if (!_ent.world.isRemote && _ent.world.getServer() != null) {
														_ent.world.getServer().getCommandManager().handleCommand(
																_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "/kill @s");
													}
												}
												{
													Entity _ent = entityiterator;
													if (!_ent.world.isRemote && _ent.world.getServer() != null) {
														_ent.world.getServer().getCommandManager().handleCommand(
																_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																"/deta merge entity @s (Health:0)");
													}
												}
											}
										}
									} else {
										if (entityiterator instanceof MobEntity) {
											if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
													.getItem() == DemonScytheItem.block) {
												if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
														((entity instanceof LivingEntity)
																? ((LivingEntity) entity).getHeldItemMainhand()
																: ItemStack.EMPTY)) != 0)) {
													if (entity instanceof LivingEntity)
														((LivingEntity) entity).setHealth(
																(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																		+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																				((entity instanceof LivingEntity)
																						? ((LivingEntity) entity).getHeldItemMainhand()
																						: ItemStack.EMPTY))));
												}
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator).addPotionEffect(
															new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
												entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 10);
											} else {
												if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
														((entity instanceof LivingEntity)
																? ((LivingEntity) entity).getHeldItemMainhand()
																: ItemStack.EMPTY)) != 0)) {
													if (entity instanceof LivingEntity)
														((LivingEntity) entity).setHealth(
																(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																		+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																				((entity instanceof LivingEntity)
																						? ((LivingEntity) entity).getHeldItemMainhand()
																						: ItemStack.EMPTY))));
												}
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator).addPotionEffect(
															new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
												entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 5);
											}
											if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
													.getItem() == BookbloodItem.block) {
												if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
														((entity instanceof LivingEntity)
																? ((LivingEntity) entity).getHeldItemMainhand()
																: ItemStack.EMPTY)) != 0)) {
													if (entity instanceof LivingEntity)
														((LivingEntity) entity).setHealth(
																(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																		+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																				((entity instanceof LivingEntity)
																						? ((LivingEntity) entity).getHeldItemMainhand()
																						: ItemStack.EMPTY))));
												}
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator).addPotionEffect(
															new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
												entityiterator.setFire((int) 15);
												entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 5);
											}
											if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
													.getItem() == PoisonbookItem.block) {
												if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
														((entity instanceof LivingEntity)
																? ((LivingEntity) entity).getHeldItemMainhand()
																: ItemStack.EMPTY)) != 0)) {
													if (entity instanceof LivingEntity)
														((LivingEntity) entity).setHealth(
																(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																		+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																				((entity instanceof LivingEntity)
																						? ((LivingEntity) entity).getHeldItemMainhand()
																						: ItemStack.EMPTY))));
												}
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator).addPotionEffect(
															new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator)
															.addPotionEffect(new EffectInstance(Effects.POISON, (int) 300, (int) 1));
												entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 5);
											}
										}
									}
								}
							}
						}
						loop = (loop - Math.toRadians(5));
						Y_pos = (Y_pos - 0.1666666666666667);
					}
					loop = Math.toRadians(entity.rotationYaw);
					XRadius2 = 4;
					ZRadius2 = 4;
					Y_pos = (y + 5);
					for (int index13 = 0; index13 < (int) (36); index13++) {
						X = (x + Math.cos(loop) * XRadius2);
						Y = Y_pos;
						Z = (z + Math.sin(loop) * ZRadius2);
						if (world instanceof ServerWorld) {
							((ServerWorld) world).spawnParticle(ParticleTypes.SWEEP_ATTACK, X, Y, Z, (int) 3, 0.1, 0.1, 0.1, 0);
						}
						if (world instanceof ServerWorld) {
							((ServerWorld) world).spawnParticle(ParticleTypes.END_ROD, X, Y, Z, (int) 5, 0.1, 0.1, 0.1, 0.2);
						}
						if (world instanceof ServerWorld) {
							((ServerWorld) world).spawnParticle(ParticleTypes.FIREWORK, X, Y, Z, (int) 5, 0.1, 0.1, 0.1, 0.2);
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(X, Y, Z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"particle minecraft:dust 1.000 0.914 0.129 1 ~ ~ ~ 0.2 0.2 0.2 1 10");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(X, Y, Z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"particle minecraft:dust 0.941 1.000 0.412 1 ~ ~ ~ 0.2 0.2 0.2 1 10");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(X, Y, Z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"particle minecraft:dust 0.980 1.000 0.729 1 ~ ~ ~ 0.2 0.2 0.2 1 10");
						}
						if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
								.getItem() == BookbloodItem.block) {
							if ((EnchantmentHelper.getEnchantmentLevel(KillEnchantment.enchantment,
									((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)) != 0)) {
								if (world instanceof ServerWorld) {
									((ServerWorld) world).spawnParticle(ParticleTypes.SOUL_FIRE_FLAME, X, Y, Z, (int) 3, 0.1, 0.1, 0.1, 0);
								}
							} else {
								if (world instanceof ServerWorld) {
									((ServerWorld) world).spawnParticle(ParticleTypes.FLAME, X, Y, Z, (int) 3, 0.1, 0.1, 0.1, 0);
								}
							}
						}
						if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
								.getItem() == PoisonbookItem.block) {
							if (world instanceof ServerWorld) {
								((ServerWorld) world).spawnParticle(DokuroParticle.particle, X, Y, Z, (int) 3, 0.1, 0.1, 0.1, 0);
							}
						}
						{
							List<Entity> _entfound = world.getEntitiesWithinAABB(Entity.class,
									new AxisAlignedBB(X - (3 / 2d), Y - (3 / 2d), Z - (3 / 2d), X + (3 / 2d), Y + (3 / 2d), Z + (3 / 2d)), null)
									.stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
										}
									}.compareDistOf(X, Y, Z)).collect(Collectors.toList());
							for (Entity entityiterator : _entfound) {
								if (!(entityiterator == entity)) {
									if ((EnchantmentHelper.getEnchantmentLevel(KillEnchantment.enchantment,
											((entity instanceof LivingEntity)
													? ((LivingEntity) entity).getHeldItemMainhand()
													: ItemStack.EMPTY)) != 0)) {
										if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
												.getItem() == BookbloodItem.block
												|| ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
														.getItem() == PoisonbookItem.block) {
											if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
													.getItem() == BookbloodItem.block) {
												if (entityiterator instanceof MobEntity) {
													if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
															((entity instanceof LivingEntity)
																	? ((LivingEntity) entity).getHeldItemMainhand()
																	: ItemStack.EMPTY)) != 0)) {
														if (entity instanceof LivingEntity)
															((LivingEntity) entity).setHealth((float) (((entity instanceof LivingEntity)
																	? ((LivingEntity) entity).getHealth()
																	: -1)
																	+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																			((entity instanceof LivingEntity)
																					? ((LivingEntity) entity).getHeldItemMainhand()
																					: ItemStack.EMPTY))));
													}
													if (entityiterator instanceof LivingEntity)
														((LivingEntity) entityiterator).addPotionEffect(
																new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
													entityiterator.setFire((int) 15);
													{
														Entity _ent = entityiterator;
														if (!_ent.world.isRemote && _ent.world.getServer() != null) {
															_ent.world.getServer().getCommandManager().handleCommand(
																	_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																	"/kill @s");
														}
													}
													{
														Entity _ent = entityiterator;
														if (!_ent.world.isRemote && _ent.world.getServer() != null) {
															_ent.world.getServer().getCommandManager().handleCommand(
																	_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																	"/deta merge entity @s (Health:0)");
														}
													}
												}
											}
											if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
													.getItem() == PoisonbookItem.block) {
												if (entityiterator instanceof MobEntity) {
													if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
															((entity instanceof LivingEntity)
																	? ((LivingEntity) entity).getHeldItemMainhand()
																	: ItemStack.EMPTY)) != 0)) {
														if (entity instanceof LivingEntity)
															((LivingEntity) entity).setHealth((float) (((entity instanceof LivingEntity)
																	? ((LivingEntity) entity).getHealth()
																	: -1)
																	+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																			((entity instanceof LivingEntity)
																					? ((LivingEntity) entity).getHeldItemMainhand()
																					: ItemStack.EMPTY))));
													}
													if (entityiterator instanceof LivingEntity)
														((LivingEntity) entityiterator).addPotionEffect(
																new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
													if (entityiterator instanceof LivingEntity)
														((LivingEntity) entityiterator)
																.addPotionEffect(new EffectInstance(Effects.POISON, (int) 300, (int) 1));
													{
														Entity _ent = entityiterator;
														if (!_ent.world.isRemote && _ent.world.getServer() != null) {
															_ent.world.getServer().getCommandManager().handleCommand(
																	_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																	"/kill @s");
														}
													}
													{
														Entity _ent = entityiterator;
														if (!_ent.world.isRemote && _ent.world.getServer() != null) {
															_ent.world.getServer().getCommandManager().handleCommand(
																	_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																	"/deta merge entity @s (Health:0)");
														}
													}
												}
											}
										} else {
											if (entityiterator instanceof MobEntity) {
												if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
														((entity instanceof LivingEntity)
																? ((LivingEntity) entity).getHeldItemMainhand()
																: ItemStack.EMPTY)) != 0)) {
													if (entity instanceof LivingEntity)
														((LivingEntity) entity).setHealth(
																(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																		+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																				((entity instanceof LivingEntity)
																						? ((LivingEntity) entity).getHeldItemMainhand()
																						: ItemStack.EMPTY))));
												}
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator).addPotionEffect(
															new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
												{
													Entity _ent = entityiterator;
													if (!_ent.world.isRemote && _ent.world.getServer() != null) {
														_ent.world.getServer().getCommandManager().handleCommand(
																_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "/kill @s");
													}
												}
												{
													Entity _ent = entityiterator;
													if (!_ent.world.isRemote && _ent.world.getServer() != null) {
														_ent.world.getServer().getCommandManager().handleCommand(
																_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																"/deta merge entity @s (Health:0)");
													}
												}
											}
										}
									} else {
										if (entityiterator instanceof MobEntity) {
											if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
													.getItem() == DemonScytheItem.block) {
												if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
														((entity instanceof LivingEntity)
																? ((LivingEntity) entity).getHeldItemMainhand()
																: ItemStack.EMPTY)) != 0)) {
													if (entity instanceof LivingEntity)
														((LivingEntity) entity).setHealth(
																(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																		+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																				((entity instanceof LivingEntity)
																						? ((LivingEntity) entity).getHeldItemMainhand()
																						: ItemStack.EMPTY))));
												}
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator).addPotionEffect(
															new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
												entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 10);
											} else {
												if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
														((entity instanceof LivingEntity)
																? ((LivingEntity) entity).getHeldItemMainhand()
																: ItemStack.EMPTY)) != 0)) {
													if (entity instanceof LivingEntity)
														((LivingEntity) entity).setHealth(
																(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																		+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																				((entity instanceof LivingEntity)
																						? ((LivingEntity) entity).getHeldItemMainhand()
																						: ItemStack.EMPTY))));
												}
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator).addPotionEffect(
															new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
												entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 5);
											}
											if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
													.getItem() == BookbloodItem.block) {
												if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
														((entity instanceof LivingEntity)
																? ((LivingEntity) entity).getHeldItemMainhand()
																: ItemStack.EMPTY)) != 0)) {
													if (entity instanceof LivingEntity)
														((LivingEntity) entity).setHealth(
																(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																		+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																				((entity instanceof LivingEntity)
																						? ((LivingEntity) entity).getHeldItemMainhand()
																						: ItemStack.EMPTY))));
												}
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator).addPotionEffect(
															new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
												entityiterator.setFire((int) 15);
												entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 5);
											}
											if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
													.getItem() == PoisonbookItem.block) {
												if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
														((entity instanceof LivingEntity)
																? ((LivingEntity) entity).getHeldItemMainhand()
																: ItemStack.EMPTY)) != 0)) {
													if (entity instanceof LivingEntity)
														((LivingEntity) entity).setHealth(
																(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																		+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																				((entity instanceof LivingEntity)
																						? ((LivingEntity) entity).getHeldItemMainhand()
																						: ItemStack.EMPTY))));
												}
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator).addPotionEffect(
															new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator)
															.addPotionEffect(new EffectInstance(Effects.POISON, (int) 300, (int) 1));
												entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 5);
											}
										}
									}
								}
							}
						}
						loop = (loop + Math.toRadians(5));
						Y_pos = (Y_pos - 0.1666666666666667);
					}
					loop = Math.toRadians(entity.rotationYaw - 180);
					XRadius2 = 5;
					ZRadius2 = 5;
					Y_pos = (y + 5);
					for (int index14 = 0; index14 < (int) (36); index14++) {
						X = (x + Math.cos(loop) * XRadius2);
						Y = Y_pos;
						Z = (z + Math.sin(loop) * ZRadius2);
						if (world instanceof ServerWorld) {
							((ServerWorld) world).spawnParticle(ParticleTypes.SWEEP_ATTACK, X, Y, Z, (int) 3, 0.1, 0.1, 0.1, 0);
						}
						if (world instanceof ServerWorld) {
							((ServerWorld) world).spawnParticle(ParticleTypes.END_ROD, X, Y, Z, (int) 5, 0.1, 0.1, 0.1, 0.2);
						}
						if (world instanceof ServerWorld) {
							((ServerWorld) world).spawnParticle(ParticleTypes.FIREWORK, X, Y, Z, (int) 5, 0.1, 0.1, 0.1, 0.2);
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(X, Y, Z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"particle minecraft:dust 1.000 0.953 0.278 1 ~ ~ ~ 0.2 0.2 0.2 1 10");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(X, Y, Z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"particle minecraft:dust 0.965 1.000 0.490 1 ~ ~ ~ 0.2 0.2 0.2 1 10");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(X, Y, Z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"particle minecraft:dust 0.965 1.000 0.490 1 ~ ~ ~ 0.2 0.2 0.2 1 10");
						}
						if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
								.getItem() == BookbloodItem.block) {
							if ((EnchantmentHelper.getEnchantmentLevel(KillEnchantment.enchantment,
									((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)) != 0)) {
								if (world instanceof ServerWorld) {
									((ServerWorld) world).spawnParticle(ParticleTypes.SOUL_FIRE_FLAME, X, Y, Z, (int) 3, 0.1, 0.1, 0.1, 0);
								}
							} else {
								if (world instanceof ServerWorld) {
									((ServerWorld) world).spawnParticle(ParticleTypes.FLAME, X, Y, Z, (int) 3, 0.1, 0.1, 0.1, 0);
								}
							}
						}
						if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
								.getItem() == PoisonbookItem.block) {
							if (world instanceof ServerWorld) {
								((ServerWorld) world).spawnParticle(DokuroParticle.particle, X, Y, Z, (int) 3, 0.1, 0.1, 0.1, 0);
							}
						}
						{
							List<Entity> _entfound = world.getEntitiesWithinAABB(Entity.class,
									new AxisAlignedBB(X - (3 / 2d), Y - (3 / 2d), Z - (3 / 2d), X + (3 / 2d), Y + (3 / 2d), Z + (3 / 2d)), null)
									.stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
										}
									}.compareDistOf(X, Y, Z)).collect(Collectors.toList());
							for (Entity entityiterator : _entfound) {
								if (!(entityiterator == entity)) {
									if ((EnchantmentHelper.getEnchantmentLevel(KillEnchantment.enchantment,
											((entity instanceof LivingEntity)
													? ((LivingEntity) entity).getHeldItemMainhand()
													: ItemStack.EMPTY)) != 0)) {
										if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
												.getItem() == BookbloodItem.block
												|| ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
														.getItem() == PoisonbookItem.block) {
											if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
													.getItem() == BookbloodItem.block) {
												if (entityiterator instanceof MobEntity) {
													if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
															((entity instanceof LivingEntity)
																	? ((LivingEntity) entity).getHeldItemMainhand()
																	: ItemStack.EMPTY)) != 0)) {
														if (entity instanceof LivingEntity)
															((LivingEntity) entity).setHealth((float) (((entity instanceof LivingEntity)
																	? ((LivingEntity) entity).getHealth()
																	: -1)
																	+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																			((entity instanceof LivingEntity)
																					? ((LivingEntity) entity).getHeldItemMainhand()
																					: ItemStack.EMPTY))));
													}
													if (entityiterator instanceof LivingEntity)
														((LivingEntity) entityiterator).addPotionEffect(
																new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
													entityiterator.setFire((int) 15);
													{
														Entity _ent = entityiterator;
														if (!_ent.world.isRemote && _ent.world.getServer() != null) {
															_ent.world.getServer().getCommandManager().handleCommand(
																	_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																	"/kill @s");
														}
													}
													{
														Entity _ent = entityiterator;
														if (!_ent.world.isRemote && _ent.world.getServer() != null) {
															_ent.world.getServer().getCommandManager().handleCommand(
																	_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																	"/deta merge entity @s (Health:0)");
														}
													}
												}
											}
											if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
													.getItem() == PoisonbookItem.block) {
												if (entityiterator instanceof MobEntity) {
													if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
															((entity instanceof LivingEntity)
																	? ((LivingEntity) entity).getHeldItemMainhand()
																	: ItemStack.EMPTY)) != 0)) {
														if (entity instanceof LivingEntity)
															((LivingEntity) entity).setHealth((float) (((entity instanceof LivingEntity)
																	? ((LivingEntity) entity).getHealth()
																	: -1)
																	+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																			((entity instanceof LivingEntity)
																					? ((LivingEntity) entity).getHeldItemMainhand()
																					: ItemStack.EMPTY))));
													}
													if (entityiterator instanceof LivingEntity)
														((LivingEntity) entityiterator).addPotionEffect(
																new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
													if (entityiterator instanceof LivingEntity)
														((LivingEntity) entityiterator)
																.addPotionEffect(new EffectInstance(Effects.POISON, (int) 300, (int) 1));
													{
														Entity _ent = entityiterator;
														if (!_ent.world.isRemote && _ent.world.getServer() != null) {
															_ent.world.getServer().getCommandManager().handleCommand(
																	_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																	"/kill @s");
														}
													}
													{
														Entity _ent = entityiterator;
														if (!_ent.world.isRemote && _ent.world.getServer() != null) {
															_ent.world.getServer().getCommandManager().handleCommand(
																	_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																	"/deta merge entity @s (Health:0)");
														}
													}
												}
											}
										} else {
											if (entityiterator instanceof MobEntity) {
												if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
														((entity instanceof LivingEntity)
																? ((LivingEntity) entity).getHeldItemMainhand()
																: ItemStack.EMPTY)) != 0)) {
													if (entity instanceof LivingEntity)
														((LivingEntity) entity).setHealth(
																(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																		+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																				((entity instanceof LivingEntity)
																						? ((LivingEntity) entity).getHeldItemMainhand()
																						: ItemStack.EMPTY))));
												}
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator).addPotionEffect(
															new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
												{
													Entity _ent = entityiterator;
													if (!_ent.world.isRemote && _ent.world.getServer() != null) {
														_ent.world.getServer().getCommandManager().handleCommand(
																_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "/kill @s");
													}
												}
												{
													Entity _ent = entityiterator;
													if (!_ent.world.isRemote && _ent.world.getServer() != null) {
														_ent.world.getServer().getCommandManager().handleCommand(
																_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																"/deta merge entity @s (Health:0)");
													}
												}
											}
										}
									} else {
										if (entityiterator instanceof MobEntity) {
											if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
													.getItem() == DemonScytheItem.block) {
												if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
														((entity instanceof LivingEntity)
																? ((LivingEntity) entity).getHeldItemMainhand()
																: ItemStack.EMPTY)) != 0)) {
													if (entity instanceof LivingEntity)
														((LivingEntity) entity).setHealth(
																(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																		+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																				((entity instanceof LivingEntity)
																						? ((LivingEntity) entity).getHeldItemMainhand()
																						: ItemStack.EMPTY))));
												}
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator).addPotionEffect(
															new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
												entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 10);
											} else {
												if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
														((entity instanceof LivingEntity)
																? ((LivingEntity) entity).getHeldItemMainhand()
																: ItemStack.EMPTY)) != 0)) {
													if (entity instanceof LivingEntity)
														((LivingEntity) entity).setHealth(
																(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																		+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																				((entity instanceof LivingEntity)
																						? ((LivingEntity) entity).getHeldItemMainhand()
																						: ItemStack.EMPTY))));
												}
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator).addPotionEffect(
															new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
												entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 5);
											}
											if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
													.getItem() == BookbloodItem.block) {
												if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
														((entity instanceof LivingEntity)
																? ((LivingEntity) entity).getHeldItemMainhand()
																: ItemStack.EMPTY)) != 0)) {
													if (entity instanceof LivingEntity)
														((LivingEntity) entity).setHealth(
																(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																		+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																				((entity instanceof LivingEntity)
																						? ((LivingEntity) entity).getHeldItemMainhand()
																						: ItemStack.EMPTY))));
												}
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator).addPotionEffect(
															new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
												entityiterator.setFire((int) 15);
												entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 5);
											}
											if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
													.getItem() == PoisonbookItem.block) {
												if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
														((entity instanceof LivingEntity)
																? ((LivingEntity) entity).getHeldItemMainhand()
																: ItemStack.EMPTY)) != 0)) {
													if (entity instanceof LivingEntity)
														((LivingEntity) entity).setHealth(
																(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																		+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																				((entity instanceof LivingEntity)
																						? ((LivingEntity) entity).getHeldItemMainhand()
																						: ItemStack.EMPTY))));
												}
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator).addPotionEffect(
															new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator)
															.addPotionEffect(new EffectInstance(Effects.POISON, (int) 300, (int) 1));
												entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 5);
											}
										}
									}
								}
							}
						}
						loop = (loop - Math.toRadians(5));
						Y_pos = (Y_pos - 0.1666666666666667);
					}
					loop = Math.toRadians(entity.rotationYaw);
					XRadius2 = 5;
					ZRadius2 = 5;
					Y_pos = (y + 5);
					for (int index15 = 0; index15 < (int) (36); index15++) {
						X = (x + Math.cos(loop) * XRadius2);
						Y = Y_pos;
						Z = (z + Math.sin(loop) * ZRadius2);
						if (world instanceof ServerWorld) {
							((ServerWorld) world).spawnParticle(ParticleTypes.SWEEP_ATTACK, X, Y, Z, (int) 3, 0.1, 0.1, 0.1, 0);
						}
						if (world instanceof ServerWorld) {
							((ServerWorld) world).spawnParticle(ParticleTypes.END_ROD, X, Y, Z, (int) 5, 0.1, 0.1, 0.1, 0.2);
						}
						if (world instanceof ServerWorld) {
							((ServerWorld) world).spawnParticle(ParticleTypes.FIREWORK, X, Y, Z, (int) 5, 0.1, 0.1, 0.1, 0.2);
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(X, Y, Z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"particle minecraft:dust 1.000 0.914 0.129 1 ~ ~ ~ 0.2 0.2 0.2 1 10");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(X, Y, Z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"particle minecraft:dust 0.941 1.000 0.412 1 ~ ~ ~ 0.2 0.2 0.2 1 10");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(X, Y, Z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"particle minecraft:dust 0.980 1.000 0.729 1 ~ ~ ~ 0.2 0.2 0.2 1 10");
						}
						if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
								.getItem() == BookbloodItem.block) {
							if ((EnchantmentHelper.getEnchantmentLevel(KillEnchantment.enchantment,
									((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)) != 0)) {
								if (world instanceof ServerWorld) {
									((ServerWorld) world).spawnParticle(ParticleTypes.SOUL_FIRE_FLAME, X, Y, Z, (int) 3, 0.1, 0.1, 0.1, 0);
								}
							} else {
								if (world instanceof ServerWorld) {
									((ServerWorld) world).spawnParticle(ParticleTypes.FLAME, X, Y, Z, (int) 3, 0.1, 0.1, 0.1, 0);
								}
							}
						}
						if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
								.getItem() == PoisonbookItem.block) {
							if (world instanceof ServerWorld) {
								((ServerWorld) world).spawnParticle(DokuroParticle.particle, X, Y, Z, (int) 3, 0.1, 0.1, 0.1, 0);
							}
						}
						{
							List<Entity> _entfound = world.getEntitiesWithinAABB(Entity.class,
									new AxisAlignedBB(X - (3 / 2d), Y - (3 / 2d), Z - (3 / 2d), X + (3 / 2d), Y + (3 / 2d), Z + (3 / 2d)), null)
									.stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
										}
									}.compareDistOf(X, Y, Z)).collect(Collectors.toList());
							for (Entity entityiterator : _entfound) {
								if (!(entityiterator == entity)) {
									if ((EnchantmentHelper.getEnchantmentLevel(KillEnchantment.enchantment,
											((entity instanceof LivingEntity)
													? ((LivingEntity) entity).getHeldItemMainhand()
													: ItemStack.EMPTY)) != 0)) {
										if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
												.getItem() == BookbloodItem.block
												|| ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
														.getItem() == PoisonbookItem.block) {
											if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
													.getItem() == BookbloodItem.block) {
												if (entityiterator instanceof MobEntity) {
													if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
															((entity instanceof LivingEntity)
																	? ((LivingEntity) entity).getHeldItemMainhand()
																	: ItemStack.EMPTY)) != 0)) {
														if (entity instanceof LivingEntity)
															((LivingEntity) entity).setHealth((float) (((entity instanceof LivingEntity)
																	? ((LivingEntity) entity).getHealth()
																	: -1)
																	+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																			((entity instanceof LivingEntity)
																					? ((LivingEntity) entity).getHeldItemMainhand()
																					: ItemStack.EMPTY))));
													}
													if (entityiterator instanceof LivingEntity)
														((LivingEntity) entityiterator).addPotionEffect(
																new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
													entityiterator.setFire((int) 15);
													{
														Entity _ent = entityiterator;
														if (!_ent.world.isRemote && _ent.world.getServer() != null) {
															_ent.world.getServer().getCommandManager().handleCommand(
																	_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																	"/kill @s");
														}
													}
													{
														Entity _ent = entityiterator;
														if (!_ent.world.isRemote && _ent.world.getServer() != null) {
															_ent.world.getServer().getCommandManager().handleCommand(
																	_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																	"/deta merge entity @s (Health:0)");
														}
													}
												}
											}
											if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
													.getItem() == PoisonbookItem.block) {
												if (entityiterator instanceof MobEntity) {
													if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
															((entity instanceof LivingEntity)
																	? ((LivingEntity) entity).getHeldItemMainhand()
																	: ItemStack.EMPTY)) != 0)) {
														if (entity instanceof LivingEntity)
															((LivingEntity) entity).setHealth((float) (((entity instanceof LivingEntity)
																	? ((LivingEntity) entity).getHealth()
																	: -1)
																	+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																			((entity instanceof LivingEntity)
																					? ((LivingEntity) entity).getHeldItemMainhand()
																					: ItemStack.EMPTY))));
													}
													if (entityiterator instanceof LivingEntity)
														((LivingEntity) entityiterator).addPotionEffect(
																new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
													if (entityiterator instanceof LivingEntity)
														((LivingEntity) entityiterator)
																.addPotionEffect(new EffectInstance(Effects.POISON, (int) 300, (int) 1));
													{
														Entity _ent = entityiterator;
														if (!_ent.world.isRemote && _ent.world.getServer() != null) {
															_ent.world.getServer().getCommandManager().handleCommand(
																	_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																	"/kill @s");
														}
													}
													{
														Entity _ent = entityiterator;
														if (!_ent.world.isRemote && _ent.world.getServer() != null) {
															_ent.world.getServer().getCommandManager().handleCommand(
																	_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																	"/deta merge entity @s (Health:0)");
														}
													}
												}
											}
										} else {
											if (entityiterator instanceof MobEntity) {
												if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
														((entity instanceof LivingEntity)
																? ((LivingEntity) entity).getHeldItemMainhand()
																: ItemStack.EMPTY)) != 0)) {
													if (entity instanceof LivingEntity)
														((LivingEntity) entity).setHealth(
																(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																		+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																				((entity instanceof LivingEntity)
																						? ((LivingEntity) entity).getHeldItemMainhand()
																						: ItemStack.EMPTY))));
												}
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator).addPotionEffect(
															new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
												{
													Entity _ent = entityiterator;
													if (!_ent.world.isRemote && _ent.world.getServer() != null) {
														_ent.world.getServer().getCommandManager().handleCommand(
																_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "/kill @s");
													}
												}
												{
													Entity _ent = entityiterator;
													if (!_ent.world.isRemote && _ent.world.getServer() != null) {
														_ent.world.getServer().getCommandManager().handleCommand(
																_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																"/deta merge entity @s (Health:0)");
													}
												}
											}
										}
									} else {
										if (entityiterator instanceof MobEntity) {
											if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
													.getItem() == DemonScytheItem.block) {
												if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
														((entity instanceof LivingEntity)
																? ((LivingEntity) entity).getHeldItemMainhand()
																: ItemStack.EMPTY)) != 0)) {
													if (entity instanceof LivingEntity)
														((LivingEntity) entity).setHealth(
																(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																		+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																				((entity instanceof LivingEntity)
																						? ((LivingEntity) entity).getHeldItemMainhand()
																						: ItemStack.EMPTY))));
												}
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator).addPotionEffect(
															new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
												entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 10);
											} else {
												if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
														((entity instanceof LivingEntity)
																? ((LivingEntity) entity).getHeldItemMainhand()
																: ItemStack.EMPTY)) != 0)) {
													if (entity instanceof LivingEntity)
														((LivingEntity) entity).setHealth(
																(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																		+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																				((entity instanceof LivingEntity)
																						? ((LivingEntity) entity).getHeldItemMainhand()
																						: ItemStack.EMPTY))));
												}
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator).addPotionEffect(
															new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
												entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 5);
											}
											if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
													.getItem() == BookbloodItem.block) {
												if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
														((entity instanceof LivingEntity)
																? ((LivingEntity) entity).getHeldItemMainhand()
																: ItemStack.EMPTY)) != 0)) {
													if (entity instanceof LivingEntity)
														((LivingEntity) entity).setHealth(
																(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																		+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																				((entity instanceof LivingEntity)
																						? ((LivingEntity) entity).getHeldItemMainhand()
																						: ItemStack.EMPTY))));
												}
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator).addPotionEffect(
															new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
												entityiterator.setFire((int) 15);
												entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 5);
											}
											if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
													.getItem() == PoisonbookItem.block) {
												if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
														((entity instanceof LivingEntity)
																? ((LivingEntity) entity).getHeldItemMainhand()
																: ItemStack.EMPTY)) != 0)) {
													if (entity instanceof LivingEntity)
														((LivingEntity) entity).setHealth(
																(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																		+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																				((entity instanceof LivingEntity)
																						? ((LivingEntity) entity).getHeldItemMainhand()
																						: ItemStack.EMPTY))));
												}
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator).addPotionEffect(
															new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator)
															.addPotionEffect(new EffectInstance(Effects.POISON, (int) 300, (int) 1));
												entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 5);
											}
										}
									}
								}
							}
						}
						loop = (loop + Math.toRadians(5));
						Y_pos = (Y_pos - 0.1666666666666667);
					}
					loop = Math.toRadians(entity.rotationYaw - 180);
					XRadius2 = 5.5;
					ZRadius2 = 5.5;
					Y_pos = (y + 5);
					for (int index16 = 0; index16 < (int) (36); index16++) {
						X = (x + Math.cos(loop) * XRadius2);
						Y = Y_pos;
						Z = (z + Math.sin(loop) * ZRadius2);
						if (world instanceof ServerWorld) {
							((ServerWorld) world).spawnParticle(ParticleTypes.SWEEP_ATTACK, X, Y, Z, (int) 3, 0.1, 0.1, 0.1, 0);
						}
						if (world instanceof ServerWorld) {
							((ServerWorld) world).spawnParticle(ParticleTypes.END_ROD, X, Y, Z, (int) 5, 0.1, 0.1, 0.1, 0.2);
						}
						if (world instanceof ServerWorld) {
							((ServerWorld) world).spawnParticle(ParticleTypes.FIREWORK, X, Y, Z, (int) 5, 0.1, 0.1, 0.1, 0.2);
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(X, Y, Z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"particle minecraft:dust 1.000 0.953 0.278 1 ~ ~ ~ 0.2 0.2 0.2 1 10");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(X, Y, Z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"particle minecraft:dust 0.965 1.000 0.490 1 ~ ~ ~ 0.2 0.2 0.2 1 10");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(X, Y, Z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"particle minecraft:dust 0.965 1.000 0.490 1 ~ ~ ~ 0.2 0.2 0.2 1 10");
						}
						if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
								.getItem() == BookbloodItem.block) {
							if ((EnchantmentHelper.getEnchantmentLevel(KillEnchantment.enchantment,
									((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)) != 0)) {
								if (world instanceof ServerWorld) {
									((ServerWorld) world).spawnParticle(ParticleTypes.SOUL_FIRE_FLAME, X, Y, Z, (int) 3, 0.1, 0.1, 0.1, 0);
								}
							} else {
								if (world instanceof ServerWorld) {
									((ServerWorld) world).spawnParticle(ParticleTypes.FLAME, X, Y, Z, (int) 3, 0.1, 0.1, 0.1, 0);
								}
							}
						}
						if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
								.getItem() == PoisonbookItem.block) {
							if (world instanceof ServerWorld) {
								((ServerWorld) world).spawnParticle(DokuroParticle.particle, X, Y, Z, (int) 3, 0.1, 0.1, 0.1, 0);
							}
						}
						{
							List<Entity> _entfound = world.getEntitiesWithinAABB(Entity.class,
									new AxisAlignedBB(X - (3 / 2d), Y - (3 / 2d), Z - (3 / 2d), X + (3 / 2d), Y + (3 / 2d), Z + (3 / 2d)), null)
									.stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
										}
									}.compareDistOf(X, Y, Z)).collect(Collectors.toList());
							for (Entity entityiterator : _entfound) {
								if (!(entityiterator == entity)) {
									if ((EnchantmentHelper.getEnchantmentLevel(KillEnchantment.enchantment,
											((entity instanceof LivingEntity)
													? ((LivingEntity) entity).getHeldItemMainhand()
													: ItemStack.EMPTY)) != 0)) {
										if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
												.getItem() == BookbloodItem.block
												|| ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
														.getItem() == PoisonbookItem.block) {
											if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
													.getItem() == BookbloodItem.block) {
												if (entityiterator instanceof MobEntity) {
													if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
															((entity instanceof LivingEntity)
																	? ((LivingEntity) entity).getHeldItemMainhand()
																	: ItemStack.EMPTY)) != 0)) {
														if (entity instanceof LivingEntity)
															((LivingEntity) entity).setHealth((float) (((entity instanceof LivingEntity)
																	? ((LivingEntity) entity).getHealth()
																	: -1)
																	+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																			((entity instanceof LivingEntity)
																					? ((LivingEntity) entity).getHeldItemMainhand()
																					: ItemStack.EMPTY))));
													}
													if (entityiterator instanceof LivingEntity)
														((LivingEntity) entityiterator).addPotionEffect(
																new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
													entityiterator.setFire((int) 15);
													{
														Entity _ent = entityiterator;
														if (!_ent.world.isRemote && _ent.world.getServer() != null) {
															_ent.world.getServer().getCommandManager().handleCommand(
																	_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																	"/kill @s");
														}
													}
													{
														Entity _ent = entityiterator;
														if (!_ent.world.isRemote && _ent.world.getServer() != null) {
															_ent.world.getServer().getCommandManager().handleCommand(
																	_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																	"/deta merge entity @s (Health:0)");
														}
													}
												}
											}
											if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
													.getItem() == PoisonbookItem.block) {
												if (entityiterator instanceof MobEntity) {
													if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
															((entity instanceof LivingEntity)
																	? ((LivingEntity) entity).getHeldItemMainhand()
																	: ItemStack.EMPTY)) != 0)) {
														if (entity instanceof LivingEntity)
															((LivingEntity) entity).setHealth((float) (((entity instanceof LivingEntity)
																	? ((LivingEntity) entity).getHealth()
																	: -1)
																	+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																			((entity instanceof LivingEntity)
																					? ((LivingEntity) entity).getHeldItemMainhand()
																					: ItemStack.EMPTY))));
													}
													if (entityiterator instanceof LivingEntity)
														((LivingEntity) entityiterator).addPotionEffect(
																new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
													if (entityiterator instanceof LivingEntity)
														((LivingEntity) entityiterator)
																.addPotionEffect(new EffectInstance(Effects.POISON, (int) 300, (int) 1));
													{
														Entity _ent = entityiterator;
														if (!_ent.world.isRemote && _ent.world.getServer() != null) {
															_ent.world.getServer().getCommandManager().handleCommand(
																	_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																	"/kill @s");
														}
													}
													{
														Entity _ent = entityiterator;
														if (!_ent.world.isRemote && _ent.world.getServer() != null) {
															_ent.world.getServer().getCommandManager().handleCommand(
																	_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																	"/deta merge entity @s (Health:0)");
														}
													}
												}
											}
										} else {
											if (entityiterator instanceof MobEntity) {
												if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
														((entity instanceof LivingEntity)
																? ((LivingEntity) entity).getHeldItemMainhand()
																: ItemStack.EMPTY)) != 0)) {
													if (entity instanceof LivingEntity)
														((LivingEntity) entity).setHealth(
																(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																		+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																				((entity instanceof LivingEntity)
																						? ((LivingEntity) entity).getHeldItemMainhand()
																						: ItemStack.EMPTY))));
												}
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator).addPotionEffect(
															new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
												{
													Entity _ent = entityiterator;
													if (!_ent.world.isRemote && _ent.world.getServer() != null) {
														_ent.world.getServer().getCommandManager().handleCommand(
																_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "/kill @s");
													}
												}
												{
													Entity _ent = entityiterator;
													if (!_ent.world.isRemote && _ent.world.getServer() != null) {
														_ent.world.getServer().getCommandManager().handleCommand(
																_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																"/deta merge entity @s (Health:0)");
													}
												}
											}
										}
									} else {
										if (entityiterator instanceof MobEntity) {
											if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
													.getItem() == DemonScytheItem.block) {
												if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
														((entity instanceof LivingEntity)
																? ((LivingEntity) entity).getHeldItemMainhand()
																: ItemStack.EMPTY)) != 0)) {
													if (entity instanceof LivingEntity)
														((LivingEntity) entity).setHealth(
																(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																		+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																				((entity instanceof LivingEntity)
																						? ((LivingEntity) entity).getHeldItemMainhand()
																						: ItemStack.EMPTY))));
												}
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator).addPotionEffect(
															new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
												entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 10);
											} else {
												if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
														((entity instanceof LivingEntity)
																? ((LivingEntity) entity).getHeldItemMainhand()
																: ItemStack.EMPTY)) != 0)) {
													if (entity instanceof LivingEntity)
														((LivingEntity) entity).setHealth(
																(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																		+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																				((entity instanceof LivingEntity)
																						? ((LivingEntity) entity).getHeldItemMainhand()
																						: ItemStack.EMPTY))));
												}
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator).addPotionEffect(
															new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
												entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 5);
											}
											if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
													.getItem() == BookbloodItem.block) {
												if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
														((entity instanceof LivingEntity)
																? ((LivingEntity) entity).getHeldItemMainhand()
																: ItemStack.EMPTY)) != 0)) {
													if (entity instanceof LivingEntity)
														((LivingEntity) entity).setHealth(
																(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																		+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																				((entity instanceof LivingEntity)
																						? ((LivingEntity) entity).getHeldItemMainhand()
																						: ItemStack.EMPTY))));
												}
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator).addPotionEffect(
															new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
												entityiterator.setFire((int) 15);
												entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 5);
											}
											if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
													.getItem() == PoisonbookItem.block) {
												if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
														((entity instanceof LivingEntity)
																? ((LivingEntity) entity).getHeldItemMainhand()
																: ItemStack.EMPTY)) != 0)) {
													if (entity instanceof LivingEntity)
														((LivingEntity) entity).setHealth(
																(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																		+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																				((entity instanceof LivingEntity)
																						? ((LivingEntity) entity).getHeldItemMainhand()
																						: ItemStack.EMPTY))));
												}
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator).addPotionEffect(
															new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator)
															.addPotionEffect(new EffectInstance(Effects.POISON, (int) 300, (int) 1));
												entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 5);
											}
										}
									}
								}
							}
						}
						loop = (loop - Math.toRadians(5));
						Y_pos = (Y_pos - 0.1666666666666667);
					}
					loop = Math.toRadians(entity.rotationYaw);
					XRadius2 = 5.5;
					ZRadius2 = 5.5;
					Y_pos = (y + 5);
					for (int index17 = 0; index17 < (int) (36); index17++) {
						X = (x + Math.cos(loop) * XRadius2);
						Y = Y_pos;
						Z = (z + Math.sin(loop) * ZRadius2);
						if (world instanceof ServerWorld) {
							((ServerWorld) world).spawnParticle(ParticleTypes.SWEEP_ATTACK, X, Y, Z, (int) 3, 0.1, 0.1, 0.1, 0);
						}
						if (world instanceof ServerWorld) {
							((ServerWorld) world).spawnParticle(ParticleTypes.END_ROD, X, Y, Z, (int) 5, 0.1, 0.1, 0.1, 0.2);
						}
						if (world instanceof ServerWorld) {
							((ServerWorld) world).spawnParticle(ParticleTypes.FIREWORK, X, Y, Z, (int) 5, 0.1, 0.1, 0.1, 0.2);
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(X, Y, Z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"particle minecraft:dust 1.000 0.914 0.129 1 ~ ~ ~ 0.2 0.2 0.2 1 10");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(X, Y, Z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"particle minecraft:dust 0.941 1.000 0.412 1 ~ ~ ~ 0.2 0.2 0.2 1 10");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(X, Y, Z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"particle minecraft:dust 0.980 1.000 0.729 1 ~ ~ ~ 0.2 0.2 0.2 1 10");
						}
						if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
								.getItem() == BookbloodItem.block) {
							if ((EnchantmentHelper.getEnchantmentLevel(KillEnchantment.enchantment,
									((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)) != 0)) {
								if (world instanceof ServerWorld) {
									((ServerWorld) world).spawnParticle(ParticleTypes.SOUL_FIRE_FLAME, X, Y, Z, (int) 3, 0.1, 0.1, 0.1, 0);
								}
							} else {
								if (world instanceof ServerWorld) {
									((ServerWorld) world).spawnParticle(ParticleTypes.FLAME, X, Y, Z, (int) 3, 0.1, 0.1, 0.1, 0);
								}
							}
						}
						if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
								.getItem() == PoisonbookItem.block) {
							if (world instanceof ServerWorld) {
								((ServerWorld) world).spawnParticle(DokuroParticle.particle, X, Y, Z, (int) 3, 0.1, 0.1, 0.1, 0);
							}
						}
						{
							List<Entity> _entfound = world.getEntitiesWithinAABB(Entity.class,
									new AxisAlignedBB(X - (3 / 2d), Y - (3 / 2d), Z - (3 / 2d), X + (3 / 2d), Y + (3 / 2d), Z + (3 / 2d)), null)
									.stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
										}
									}.compareDistOf(X, Y, Z)).collect(Collectors.toList());
							for (Entity entityiterator : _entfound) {
								if (!(entityiterator == entity)) {
									if ((EnchantmentHelper.getEnchantmentLevel(KillEnchantment.enchantment,
											((entity instanceof LivingEntity)
													? ((LivingEntity) entity).getHeldItemMainhand()
													: ItemStack.EMPTY)) != 0)) {
										if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
												.getItem() == BookbloodItem.block
												|| ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
														.getItem() == PoisonbookItem.block) {
											if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
													.getItem() == BookbloodItem.block) {
												if (entityiterator instanceof MobEntity) {
													if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
															((entity instanceof LivingEntity)
																	? ((LivingEntity) entity).getHeldItemMainhand()
																	: ItemStack.EMPTY)) != 0)) {
														if (entity instanceof LivingEntity)
															((LivingEntity) entity).setHealth((float) (((entity instanceof LivingEntity)
																	? ((LivingEntity) entity).getHealth()
																	: -1)
																	+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																			((entity instanceof LivingEntity)
																					? ((LivingEntity) entity).getHeldItemMainhand()
																					: ItemStack.EMPTY))));
													}
													if (entityiterator instanceof LivingEntity)
														((LivingEntity) entityiterator).addPotionEffect(
																new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
													entityiterator.setFire((int) 15);
													{
														Entity _ent = entityiterator;
														if (!_ent.world.isRemote && _ent.world.getServer() != null) {
															_ent.world.getServer().getCommandManager().handleCommand(
																	_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																	"/kill @s");
														}
													}
													{
														Entity _ent = entityiterator;
														if (!_ent.world.isRemote && _ent.world.getServer() != null) {
															_ent.world.getServer().getCommandManager().handleCommand(
																	_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																	"/deta merge entity @s (Health:0)");
														}
													}
												}
											}
											if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
													.getItem() == PoisonbookItem.block) {
												if (entityiterator instanceof MobEntity) {
													if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
															((entity instanceof LivingEntity)
																	? ((LivingEntity) entity).getHeldItemMainhand()
																	: ItemStack.EMPTY)) != 0)) {
														if (entity instanceof LivingEntity)
															((LivingEntity) entity).setHealth((float) (((entity instanceof LivingEntity)
																	? ((LivingEntity) entity).getHealth()
																	: -1)
																	+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																			((entity instanceof LivingEntity)
																					? ((LivingEntity) entity).getHeldItemMainhand()
																					: ItemStack.EMPTY))));
													}
													if (entityiterator instanceof LivingEntity)
														((LivingEntity) entityiterator).addPotionEffect(
																new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
													if (entityiterator instanceof LivingEntity)
														((LivingEntity) entityiterator)
																.addPotionEffect(new EffectInstance(Effects.POISON, (int) 300, (int) 1));
													{
														Entity _ent = entityiterator;
														if (!_ent.world.isRemote && _ent.world.getServer() != null) {
															_ent.world.getServer().getCommandManager().handleCommand(
																	_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																	"/kill @s");
														}
													}
													{
														Entity _ent = entityiterator;
														if (!_ent.world.isRemote && _ent.world.getServer() != null) {
															_ent.world.getServer().getCommandManager().handleCommand(
																	_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																	"/deta merge entity @s (Health:0)");
														}
													}
												}
											}
										} else {
											if (entityiterator instanceof MobEntity) {
												if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
														((entity instanceof LivingEntity)
																? ((LivingEntity) entity).getHeldItemMainhand()
																: ItemStack.EMPTY)) != 0)) {
													if (entity instanceof LivingEntity)
														((LivingEntity) entity).setHealth(
																(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																		+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																				((entity instanceof LivingEntity)
																						? ((LivingEntity) entity).getHeldItemMainhand()
																						: ItemStack.EMPTY))));
												}
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator).addPotionEffect(
															new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
												{
													Entity _ent = entityiterator;
													if (!_ent.world.isRemote && _ent.world.getServer() != null) {
														_ent.world.getServer().getCommandManager().handleCommand(
																_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "/kill @s");
													}
												}
												{
													Entity _ent = entityiterator;
													if (!_ent.world.isRemote && _ent.world.getServer() != null) {
														_ent.world.getServer().getCommandManager().handleCommand(
																_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																"/deta merge entity @s (Health:0)");
													}
												}
											}
										}
									} else {
										if (entityiterator instanceof MobEntity) {
											if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
													.getItem() == DemonScytheItem.block) {
												if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
														((entity instanceof LivingEntity)
																? ((LivingEntity) entity).getHeldItemMainhand()
																: ItemStack.EMPTY)) != 0)) {
													if (entity instanceof LivingEntity)
														((LivingEntity) entity).setHealth(
																(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																		+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																				((entity instanceof LivingEntity)
																						? ((LivingEntity) entity).getHeldItemMainhand()
																						: ItemStack.EMPTY))));
												}
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator).addPotionEffect(
															new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
												entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 10);
											} else {
												if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
														((entity instanceof LivingEntity)
																? ((LivingEntity) entity).getHeldItemMainhand()
																: ItemStack.EMPTY)) != 0)) {
													if (entity instanceof LivingEntity)
														((LivingEntity) entity).setHealth(
																(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																		+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																				((entity instanceof LivingEntity)
																						? ((LivingEntity) entity).getHeldItemMainhand()
																						: ItemStack.EMPTY))));
												}
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator).addPotionEffect(
															new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
												entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 5);
											}
											if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
													.getItem() == BookbloodItem.block) {
												if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
														((entity instanceof LivingEntity)
																? ((LivingEntity) entity).getHeldItemMainhand()
																: ItemStack.EMPTY)) != 0)) {
													if (entity instanceof LivingEntity)
														((LivingEntity) entity).setHealth(
																(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																		+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																				((entity instanceof LivingEntity)
																						? ((LivingEntity) entity).getHeldItemMainhand()
																						: ItemStack.EMPTY))));
												}
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator).addPotionEffect(
															new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
												entityiterator.setFire((int) 15);
												entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 5);
											}
											if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
													.getItem() == PoisonbookItem.block) {
												if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
														((entity instanceof LivingEntity)
																? ((LivingEntity) entity).getHeldItemMainhand()
																: ItemStack.EMPTY)) != 0)) {
													if (entity instanceof LivingEntity)
														((LivingEntity) entity).setHealth(
																(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																		+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																				((entity instanceof LivingEntity)
																						? ((LivingEntity) entity).getHeldItemMainhand()
																						: ItemStack.EMPTY))));
												}
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator).addPotionEffect(
															new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator)
															.addPotionEffect(new EffectInstance(Effects.POISON, (int) 300, (int) 1));
												entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 5);
											}
										}
									}
								}
							}
						}
						loop = (loop + Math.toRadians(5));
						Y_pos = (Y_pos - 0.1666666666666667);
					}
					if (!(new Object() {
						public boolean checkGamemode(Entity _ent) {
							if (_ent instanceof ServerPlayerEntity) {
								return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.CREATIVE;
							} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
								NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
										.getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
								return _npi != null && _npi.getGameType() == GameType.CREATIVE;
							}
							return false;
						}
					}.checkGamemode(entity) || new Object() {
						public boolean checkGamemode(Entity _ent) {
							if (_ent instanceof ServerPlayerEntity) {
								return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.SPECTATOR;
							} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
								NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
										.getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
								return _npi != null && _npi.getGameType() == GameType.SPECTATOR;
							}
							return false;
						}
					}.checkGamemode(entity)
							|| (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
									? ((ServerPlayerEntity) entity).getAdvancements()
											.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
													.getAdvancement(new ResourceLocation("japanesesword:tidaisuki")))
											.isDone()
									: false))) {
						if (entity instanceof LivingEntity)
							((LivingEntity) entity)
									.setHealth((float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) - 5));
					}
					if (!(new Object() {
						boolean check(Entity _entity) {
							if (_entity instanceof LivingEntity) {
								Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
								for (EffectInstance effect : effects) {
									if (effect.getPotion() == KurutaimunasiPotionEffect.potion)
										return true;
								}
							}
							return false;
						}
					}.check(entity))) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(DemonScytheItem.block, (int) 25);
					}
				}
			}
		}
		if ((entity.getCapability(JapaneseswordModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new JapaneseswordModVariables.PlayerVariables())).kaunnto == 7) {
			if (2 < ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) || new Object() {
				public boolean checkGamemode(Entity _ent) {
					if (_ent instanceof ServerPlayerEntity) {
						return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.CREATIVE;
					} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
						NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
								.getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
						return _npi != null && _npi.getGameType() == GameType.CREATIVE;
					}
					return false;
				}
			}.checkGamemode(entity) || new Object() {
				public boolean checkGamemode(Entity _ent) {
					if (_ent instanceof ServerPlayerEntity) {
						return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.SPECTATOR;
					} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
						NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
								.getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
						return _npi != null && _npi.getGameType() == GameType.SPECTATOR;
					}
					return false;
				}
			}.checkGamemode(entity)
					|| (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
							? ((ServerPlayerEntity) entity).getAdvancements()
									.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
											.getAdvancement(new ResourceLocation("japanesesword:tidaisuki")))
									.isDone()
							: false)) {
				if (TokinohonnItem.block == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
						.getItem()) {
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addPotionEffect(new EffectInstance(Effect10PotionEffect.potion, (int) 60, (int) 1, (true), (false)));
				} else {
					{
						List<Entity> _entfound = world
								.getEntitiesWithinAABB(Entity.class,
										new AxisAlignedBB(x - (5 / 2d), y - (5 / 2d), z - (5 / 2d), x + (5 / 2d), y + (5 / 2d), z + (5 / 2d)), null)
								.stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
									}
								}.compareDistOf(x, y, z)).collect(Collectors.toList());
						for (Entity entityiterator : _entfound) {
							if (world instanceof ServerWorld) {
								((ServerWorld) world).spawnParticle(ParticleTypes.CLOUD, x, y, z, (int) 5, 3, 3, 3, 1);
							}
							if (!(entityiterator == entity)) {
								if (entityiterator instanceof MobEntity) {
									if (entityiterator instanceof LivingEntity)
										((LivingEntity) entityiterator)
												.addPotionEffect(new EffectInstance(UgokasuPotionEffect.potion, (int) 240, (int) 1, (true), (false)));
									if (!(entityiterator == entity)) {
										if ((EnchantmentHelper.getEnchantmentLevel(KillEnchantment.enchantment,
												((entity instanceof LivingEntity)
														? ((LivingEntity) entity).getHeldItemMainhand()
														: ItemStack.EMPTY)) != 0)) {
											if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
													.getItem() == BookbloodItem.block
													|| ((entity instanceof LivingEntity)
															? ((LivingEntity) entity).getHeldItemOffhand()
															: ItemStack.EMPTY).getItem() == PoisonbookItem.block) {
												if (((entity instanceof LivingEntity)
														? ((LivingEntity) entity).getHeldItemOffhand()
														: ItemStack.EMPTY).getItem() == BookbloodItem.block) {
													if (entityiterator instanceof MobEntity) {
														if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																((entity instanceof LivingEntity)
																		? ((LivingEntity) entity).getHeldItemMainhand()
																		: ItemStack.EMPTY)) != 0)) {
															if (entity instanceof LivingEntity)
																((LivingEntity) entity).setHealth((float) (((entity instanceof LivingEntity)
																		? ((LivingEntity) entity).getHealth()
																		: -1)
																		+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																				((entity instanceof LivingEntity)
																						? ((LivingEntity) entity).getHeldItemMainhand()
																						: ItemStack.EMPTY))));
														}
														if (entityiterator instanceof LivingEntity)
															((LivingEntity) entityiterator).addPotionEffect(
																	new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
														entityiterator.setFire((int) 15);
														{
															Entity _ent = entityiterator;
															if (!_ent.world.isRemote && _ent.world.getServer() != null) {
																_ent.world.getServer().getCommandManager().handleCommand(
																		_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																		"/kill @s");
															}
														}
														{
															Entity _ent = entityiterator;
															if (!_ent.world.isRemote && _ent.world.getServer() != null) {
																_ent.world.getServer().getCommandManager().handleCommand(
																		_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																		"/deta merge entity @s (Health:0)");
															}
														}
													}
												}
												if (((entity instanceof LivingEntity)
														? ((LivingEntity) entity).getHeldItemOffhand()
														: ItemStack.EMPTY).getItem() == PoisonbookItem.block) {
													if (entityiterator instanceof MobEntity) {
														if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																((entity instanceof LivingEntity)
																		? ((LivingEntity) entity).getHeldItemMainhand()
																		: ItemStack.EMPTY)) != 0)) {
															if (entity instanceof LivingEntity)
																((LivingEntity) entity).setHealth((float) (((entity instanceof LivingEntity)
																		? ((LivingEntity) entity).getHealth()
																		: -1)
																		+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																				((entity instanceof LivingEntity)
																						? ((LivingEntity) entity).getHeldItemMainhand()
																						: ItemStack.EMPTY))));
														}
														if (entityiterator instanceof LivingEntity)
															((LivingEntity) entityiterator).addPotionEffect(
																	new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
														if (entityiterator instanceof LivingEntity)
															((LivingEntity) entityiterator)
																	.addPotionEffect(new EffectInstance(Effects.POISON, (int) 300, (int) 1));
														{
															Entity _ent = entityiterator;
															if (!_ent.world.isRemote && _ent.world.getServer() != null) {
																_ent.world.getServer().getCommandManager().handleCommand(
																		_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																		"/kill @s");
															}
														}
														{
															Entity _ent = entityiterator;
															if (!_ent.world.isRemote && _ent.world.getServer() != null) {
																_ent.world.getServer().getCommandManager().handleCommand(
																		_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																		"/deta merge entity @s (Health:0)");
															}
														}
													}
												}
											} else {
												if (entityiterator instanceof MobEntity) {
													if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
															((entity instanceof LivingEntity)
																	? ((LivingEntity) entity).getHeldItemMainhand()
																	: ItemStack.EMPTY)) != 0)) {
														if (entity instanceof LivingEntity)
															((LivingEntity) entity).setHealth((float) (((entity instanceof LivingEntity)
																	? ((LivingEntity) entity).getHealth()
																	: -1)
																	+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																			((entity instanceof LivingEntity)
																					? ((LivingEntity) entity).getHeldItemMainhand()
																					: ItemStack.EMPTY))));
													}
													if (entityiterator instanceof LivingEntity)
														((LivingEntity) entityiterator).addPotionEffect(
																new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
													{
														Entity _ent = entityiterator;
														if (!_ent.world.isRemote && _ent.world.getServer() != null) {
															_ent.world.getServer().getCommandManager().handleCommand(
																	_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																	"/kill @s");
														}
													}
													{
														Entity _ent = entityiterator;
														if (!_ent.world.isRemote && _ent.world.getServer() != null) {
															_ent.world.getServer().getCommandManager().handleCommand(
																	_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																	"/deta merge entity @s (Health:0)");
														}
													}
												}
											}
										} else {
											if (entityiterator instanceof MobEntity) {
												if (((entity instanceof LivingEntity)
														? ((LivingEntity) entity).getHeldItemOffhand()
														: ItemStack.EMPTY).getItem() == DemonScytheItem.block) {
													if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
															((entity instanceof LivingEntity)
																	? ((LivingEntity) entity).getHeldItemMainhand()
																	: ItemStack.EMPTY)) != 0)) {
														if (entity instanceof LivingEntity)
															((LivingEntity) entity).setHealth((float) (((entity instanceof LivingEntity)
																	? ((LivingEntity) entity).getHealth()
																	: -1)
																	+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																			((entity instanceof LivingEntity)
																					? ((LivingEntity) entity).getHeldItemMainhand()
																					: ItemStack.EMPTY))));
													}
													if (entityiterator instanceof LivingEntity)
														((LivingEntity) entityiterator).addPotionEffect(
																new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
													entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 10);
												} else {
													if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
															((entity instanceof LivingEntity)
																	? ((LivingEntity) entity).getHeldItemMainhand()
																	: ItemStack.EMPTY)) != 0)) {
														if (entity instanceof LivingEntity)
															((LivingEntity) entity).setHealth((float) (((entity instanceof LivingEntity)
																	? ((LivingEntity) entity).getHealth()
																	: -1)
																	+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																			((entity instanceof LivingEntity)
																					? ((LivingEntity) entity).getHeldItemMainhand()
																					: ItemStack.EMPTY))));
													}
													if (entityiterator instanceof LivingEntity)
														((LivingEntity) entityiterator).addPotionEffect(
																new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
													entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 5);
												}
												if (((entity instanceof LivingEntity)
														? ((LivingEntity) entity).getHeldItemOffhand()
														: ItemStack.EMPTY).getItem() == BookbloodItem.block) {
													if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
															((entity instanceof LivingEntity)
																	? ((LivingEntity) entity).getHeldItemMainhand()
																	: ItemStack.EMPTY)) != 0)) {
														if (entity instanceof LivingEntity)
															((LivingEntity) entity).setHealth((float) (((entity instanceof LivingEntity)
																	? ((LivingEntity) entity).getHealth()
																	: -1)
																	+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																			((entity instanceof LivingEntity)
																					? ((LivingEntity) entity).getHeldItemMainhand()
																					: ItemStack.EMPTY))));
													}
													if (entityiterator instanceof LivingEntity)
														((LivingEntity) entityiterator).addPotionEffect(
																new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
													entityiterator.setFire((int) 15);
													entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 5);
												}
												if (((entity instanceof LivingEntity)
														? ((LivingEntity) entity).getHeldItemOffhand()
														: ItemStack.EMPTY).getItem() == PoisonbookItem.block) {
													if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
															((entity instanceof LivingEntity)
																	? ((LivingEntity) entity).getHeldItemMainhand()
																	: ItemStack.EMPTY)) != 0)) {
														if (entity instanceof LivingEntity)
															((LivingEntity) entity).setHealth((float) (((entity instanceof LivingEntity)
																	? ((LivingEntity) entity).getHealth()
																	: -1)
																	+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																			((entity instanceof LivingEntity)
																					? ((LivingEntity) entity).getHeldItemMainhand()
																					: ItemStack.EMPTY))));
													}
													if (entityiterator instanceof LivingEntity)
														((LivingEntity) entityiterator).addPotionEffect(
																new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
													if (entityiterator instanceof LivingEntity)
														((LivingEntity) entityiterator)
																.addPotionEffect(new EffectInstance(Effects.POISON, (int) 300, (int) 1));
													entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 5);
												}
											}
										}
									}
								}
							}
						}
					}
					if (!(new Object() {
						public boolean checkGamemode(Entity _ent) {
							if (_ent instanceof ServerPlayerEntity) {
								return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.CREATIVE;
							} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
								NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
										.getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
								return _npi != null && _npi.getGameType() == GameType.CREATIVE;
							}
							return false;
						}
					}.checkGamemode(entity) || new Object() {
						public boolean checkGamemode(Entity _ent) {
							if (_ent instanceof ServerPlayerEntity) {
								return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.SPECTATOR;
							} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
								NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
										.getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
								return _npi != null && _npi.getGameType() == GameType.SPECTATOR;
							}
							return false;
						}
					}.checkGamemode(entity)
							|| (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
									? ((ServerPlayerEntity) entity).getAdvancements()
											.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
													.getAdvancement(new ResourceLocation("japanesesword:tidaisuki")))
											.isDone()
									: false))) {
						if (entity instanceof LivingEntity)
							((LivingEntity) entity)
									.setHealth((float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) - 2));
					}
					if (!(new Object() {
						boolean check(Entity _entity) {
							if (_entity instanceof LivingEntity) {
								Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
								for (EffectInstance effect : effects) {
									if (effect.getPotion() == KurutaimunasiPotionEffect.potion)
										return true;
								}
							}
							return false;
						}
					}.check(entity))) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(DemonScytheItem.block, (int) 10);
					}
				}
			}
		}
		if ((entity.getCapability(JapaneseswordModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new JapaneseswordModVariables.PlayerVariables())).kaunnto == 8) {
			if (5 < ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) || new Object() {
				public boolean checkGamemode(Entity _ent) {
					if (_ent instanceof ServerPlayerEntity) {
						return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.CREATIVE;
					} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
						NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
								.getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
						return _npi != null && _npi.getGameType() == GameType.CREATIVE;
					}
					return false;
				}
			}.checkGamemode(entity) || new Object() {
				public boolean checkGamemode(Entity _ent) {
					if (_ent instanceof ServerPlayerEntity) {
						return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.SPECTATOR;
					} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
						NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
								.getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
						return _npi != null && _npi.getGameType() == GameType.SPECTATOR;
					}
					return false;
				}
			}.checkGamemode(entity)
					|| (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
							? ((ServerPlayerEntity) entity).getAdvancements()
									.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
											.getAdvancement(new ResourceLocation("japanesesword:tidaisuki")))
									.isDone()
							: false)) {
				if (entity instanceof LivingEntity) {
					((LivingEntity) entity).swing(Hand.MAIN_HAND, true);
				}
				Numerical_value = 1;
				yaw = (entity.rotationYaw);
				angle = (entity.rotationPitch);
				for (int index18 = 0; index18 < (int) (100); index18++) {
					{
						List<Entity> _entfound = world.getEntitiesWithinAABB(Entity.class,
								new AxisAlignedBB((x - Numerical_value * Math.cos(Math.toRadians(angle)) * Math.sin(Math.toRadians(yaw))) - (5 / 2d),
										((y + 1) - Numerical_value * Math.sin(Math.toRadians(angle))) - (5 / 2d),
										(z + Numerical_value * Math.cos(Math.toRadians(angle)) * Math.cos(Math.toRadians(yaw))) - (5 / 2d),
										(x - Numerical_value * Math.cos(Math.toRadians(angle)) * Math.sin(Math.toRadians(yaw))) + (5 / 2d),
										((y + 1) - Numerical_value * Math.sin(Math.toRadians(angle))) + (5 / 2d),
										(z + Numerical_value * Math.cos(Math.toRadians(angle)) * Math.cos(Math.toRadians(yaw))) + (5 / 2d)),
								null).stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
									}
								}.compareDistOf((x - Numerical_value * Math.cos(Math.toRadians(angle)) * Math.sin(Math.toRadians(yaw))),
										((y + 1) - Numerical_value * Math.sin(Math.toRadians(angle))),
										(z + Numerical_value * Math.cos(Math.toRadians(angle)) * Math.cos(Math.toRadians(yaw)))))
								.collect(Collectors.toList());
						for (Entity entityiterator : _entfound) {
							if (!(entityiterator == entity)) {
								if ((EnchantmentHelper.getEnchantmentLevel(KillEnchantment.enchantment,
										((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)) != 0)) {
									if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
											.getItem() == BookbloodItem.block
											|| ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
													.getItem() == PoisonbookItem.block) {
										if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
												.getItem() == BookbloodItem.block) {
											if (entityiterator instanceof MobEntity) {
												if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
														((entity instanceof LivingEntity)
																? ((LivingEntity) entity).getHeldItemMainhand()
																: ItemStack.EMPTY)) != 0)) {
													if (entity instanceof LivingEntity)
														((LivingEntity) entity).setHealth(
																(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																		+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																				((entity instanceof LivingEntity)
																						? ((LivingEntity) entity).getHeldItemMainhand()
																						: ItemStack.EMPTY))));
												}
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator).addPotionEffect(
															new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
												entityiterator.setFire((int) 15);
												{
													Entity _ent = entityiterator;
													if (!_ent.world.isRemote && _ent.world.getServer() != null) {
														_ent.world.getServer().getCommandManager().handleCommand(
																_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "/kill @s");
													}
												}
												{
													Entity _ent = entityiterator;
													if (!_ent.world.isRemote && _ent.world.getServer() != null) {
														_ent.world.getServer().getCommandManager().handleCommand(
																_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																"/deta merge entity @s (Health:0)");
													}
												}
											}
										}
										if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
												.getItem() == PoisonbookItem.block) {
											if (entityiterator instanceof MobEntity) {
												if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
														((entity instanceof LivingEntity)
																? ((LivingEntity) entity).getHeldItemMainhand()
																: ItemStack.EMPTY)) != 0)) {
													if (entity instanceof LivingEntity)
														((LivingEntity) entity).setHealth(
																(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																		+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																				((entity instanceof LivingEntity)
																						? ((LivingEntity) entity).getHeldItemMainhand()
																						: ItemStack.EMPTY))));
												}
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator).addPotionEffect(
															new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator)
															.addPotionEffect(new EffectInstance(Effects.POISON, (int) 300, (int) 1));
												{
													Entity _ent = entityiterator;
													if (!_ent.world.isRemote && _ent.world.getServer() != null) {
														_ent.world.getServer().getCommandManager().handleCommand(
																_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "/kill @s");
													}
												}
												{
													Entity _ent = entityiterator;
													if (!_ent.world.isRemote && _ent.world.getServer() != null) {
														_ent.world.getServer().getCommandManager().handleCommand(
																_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																"/deta merge entity @s (Health:0)");
													}
												}
											}
										}
									} else {
										if (entityiterator instanceof MobEntity) {
											if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
													((entity instanceof LivingEntity)
															? ((LivingEntity) entity).getHeldItemMainhand()
															: ItemStack.EMPTY)) != 0)) {
												if (entity instanceof LivingEntity)
													((LivingEntity) entity).setHealth(
															(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																	+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																			((entity instanceof LivingEntity)
																					? ((LivingEntity) entity).getHeldItemMainhand()
																					: ItemStack.EMPTY))));
											}
											if (entityiterator instanceof LivingEntity)
												((LivingEntity) entityiterator).addPotionEffect(
														new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
											{
												Entity _ent = entityiterator;
												if (!_ent.world.isRemote && _ent.world.getServer() != null) {
													_ent.world.getServer().getCommandManager().handleCommand(
															_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "/kill @s");
												}
											}
											{
												Entity _ent = entityiterator;
												if (!_ent.world.isRemote && _ent.world.getServer() != null) {
													_ent.world.getServer().getCommandManager().handleCommand(
															_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
															"/deta merge entity @s (Health:0)");
												}
											}
										}
									}
								} else {
									if (entityiterator instanceof MobEntity) {
										if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
												.getItem() == DemonizedkatanaItem.block) {
											if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
													((entity instanceof LivingEntity)
															? ((LivingEntity) entity).getHeldItemMainhand()
															: ItemStack.EMPTY)) != 0)) {
												if (entity instanceof LivingEntity)
													((LivingEntity) entity).setHealth(
															(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																	+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																			((entity instanceof LivingEntity)
																					? ((LivingEntity) entity).getHeldItemMainhand()
																					: ItemStack.EMPTY))));
											}
											if (entityiterator instanceof LivingEntity)
												((LivingEntity) entityiterator).addPotionEffect(
														new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
											entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 10);
										} else {
											if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
													((entity instanceof LivingEntity)
															? ((LivingEntity) entity).getHeldItemMainhand()
															: ItemStack.EMPTY)) != 0)) {
												if (entity instanceof LivingEntity)
													((LivingEntity) entity).setHealth(
															(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																	+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																			((entity instanceof LivingEntity)
																					? ((LivingEntity) entity).getHeldItemMainhand()
																					: ItemStack.EMPTY))));
											}
											if (entityiterator instanceof LivingEntity)
												((LivingEntity) entityiterator).addPotionEffect(
														new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
											entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 5);
										}
										if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
												.getItem() == BookbloodItem.block) {
											if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
													((entity instanceof LivingEntity)
															? ((LivingEntity) entity).getHeldItemMainhand()
															: ItemStack.EMPTY)) != 0)) {
												if (entity instanceof LivingEntity)
													((LivingEntity) entity).setHealth(
															(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																	+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																			((entity instanceof LivingEntity)
																					? ((LivingEntity) entity).getHeldItemMainhand()
																					: ItemStack.EMPTY))));
											}
											if (entityiterator instanceof LivingEntity)
												((LivingEntity) entityiterator).addPotionEffect(
														new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
											entityiterator.setFire((int) 15);
											entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 5);
										}
										if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
												.getItem() == PoisonbookItem.block) {
											if ((EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
													((entity instanceof LivingEntity)
															? ((LivingEntity) entity).getHeldItemMainhand()
															: ItemStack.EMPTY)) != 0)) {
												if (entity instanceof LivingEntity)
													((LivingEntity) entity).setHealth(
															(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
																	+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																			((entity instanceof LivingEntity)
																					? ((LivingEntity) entity).getHeldItemMainhand()
																					: ItemStack.EMPTY))));
											}
											if (entityiterator instanceof LivingEntity)
												((LivingEntity) entityiterator).addPotionEffect(
														new EffectInstance(BloodPotionEffect.potion, (int) 20, (int) 5, (true), (false)));
											if (entityiterator instanceof LivingEntity)
												((LivingEntity) entityiterator)
														.addPotionEffect(new EffectInstance(Effects.POISON, (int) 300, (int) 1));
											entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 5);
										}
									}
								}
							}
						}
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager()
								.handleCommand(new CommandSource(ICommandSource.DUMMY,
										new Vector3d((x - Numerical_value * Math.cos(Math.toRadians(angle)) * Math.sin(Math.toRadians(yaw))),
												((y + 1) - Numerical_value * Math.sin(Math.toRadians(angle))),
												(z + Numerical_value * Math.cos(Math.toRadians(angle)) * Math.cos(Math.toRadians(yaw)))),
										Vector2f.ZERO, (ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(), null)
										.withFeedbackDisabled(), "particle minecraft:dust 0.385 0 0.213 1 ^ ^ ^ 0.01 0.01 0.01 0 10");
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager()
								.handleCommand(new CommandSource(ICommandSource.DUMMY,
										new Vector3d((x - Numerical_value * Math.cos(Math.toRadians(angle)) * Math.sin(Math.toRadians(yaw))),
												((y + 1) - Numerical_value * Math.sin(Math.toRadians(angle))),
												(z + Numerical_value * Math.cos(Math.toRadians(angle)) * Math.cos(Math.toRadians(yaw)))),
										Vector2f.ZERO, (ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(), null)
										.withFeedbackDisabled(), "particle minecraft:dust 0.385 0 0.213 1 ^0.3 ^ ^ 0.01 0.01 0.01 0 10");
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager()
								.handleCommand(
										new CommandSource(ICommandSource.DUMMY,
												new Vector3d((x - Numerical_value * Math.cos(Math.toRadians(angle)) * Math.sin(Math.toRadians(yaw))),
														((y + 1) - Numerical_value * Math.sin(Math.toRadians(angle))),
														(z + Numerical_value * Math.cos(Math.toRadians(angle)) * Math.cos(Math.toRadians(yaw)))),
												Vector2f.ZERO, (ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(),
												null).withFeedbackDisabled(),
										"particle minecraft:dust 0.385 0 0.213 1 ^-0.3 ^ ^ 0.01 0.01 0.01 0 10");
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager()
								.handleCommand(new CommandSource(ICommandSource.DUMMY,
										new Vector3d((x - Numerical_value * Math.cos(Math.toRadians(angle)) * Math.sin(Math.toRadians(yaw))),
												((y + 1) - Numerical_value * Math.sin(Math.toRadians(angle))),
												(z + Numerical_value * Math.cos(Math.toRadians(angle)) * Math.cos(Math.toRadians(yaw)))),
										Vector2f.ZERO, (ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(), null)
										.withFeedbackDisabled(), "particle minecraft:dust 0.385 0 0.213 1 ^0.6 ^ ^ 0.01 0.01 0.01 0 10");
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager()
								.handleCommand(
										new CommandSource(ICommandSource.DUMMY,
												new Vector3d((x - Numerical_value * Math.cos(Math.toRadians(angle)) * Math.sin(Math.toRadians(yaw))),
														((y + 1) - Numerical_value * Math.sin(Math.toRadians(angle))),
														(z + Numerical_value * Math.cos(Math.toRadians(angle)) * Math.cos(Math.toRadians(yaw)))),
												Vector2f.ZERO, (ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(),
												null).withFeedbackDisabled(),
										"particle minecraft:dust 0.385 0 0.213 1 ^-0.6 ^ ^ 0.01 0.01 0.01 0 10");
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager()
								.handleCommand(new CommandSource(ICommandSource.DUMMY,
										new Vector3d((x - Numerical_value * Math.cos(Math.toRadians(angle)) * Math.sin(Math.toRadians(yaw))),
												((y + 1) - Numerical_value * Math.sin(Math.toRadians(angle))),
												(z + Numerical_value * Math.cos(Math.toRadians(angle)) * Math.cos(Math.toRadians(yaw)))),
										Vector2f.ZERO, (ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(), null)
										.withFeedbackDisabled(), "particle minecraft:dust 0.385 0 0.213 1 ^0.9 ^ ^ 0.01 0.01 0.01 0 10");
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager()
								.handleCommand(
										new CommandSource(ICommandSource.DUMMY,
												new Vector3d((x - Numerical_value * Math.cos(Math.toRadians(angle)) * Math.sin(Math.toRadians(yaw))),
														((y + 1) - Numerical_value * Math.sin(Math.toRadians(angle))),
														(z + Numerical_value * Math.cos(Math.toRadians(angle)) * Math.cos(Math.toRadians(yaw)))),
												Vector2f.ZERO, (ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(),
												null).withFeedbackDisabled(),
										"particle minecraft:dust 0.385 0 0.213 1 ^-0.9 ^ ^ 0.01 0.01 0.01 0 10");
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager()
								.handleCommand(new CommandSource(ICommandSource.DUMMY,
										new Vector3d((x - Numerical_value * Math.cos(Math.toRadians(angle)) * Math.sin(Math.toRadians(yaw))),
												((y + 1) - Numerical_value * Math.sin(Math.toRadians(angle))),
												(z + Numerical_value * Math.cos(Math.toRadians(angle)) * Math.cos(Math.toRadians(yaw)))),
										Vector2f.ZERO, (ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(), null)
										.withFeedbackDisabled(), "particle minecraft:dust 0.385 0 0.213 1 ^ ^ ^0.3 0.01 0.01 0.01 0 10");
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager()
								.handleCommand(new CommandSource(ICommandSource.DUMMY,
										new Vector3d((x - Numerical_value * Math.cos(Math.toRadians(angle)) * Math.sin(Math.toRadians(yaw))),
												((y + 1) - Numerical_value * Math.sin(Math.toRadians(angle))),
												(z + Numerical_value * Math.cos(Math.toRadians(angle)) * Math.cos(Math.toRadians(yaw)))),
										Vector2f.ZERO, (ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(), null)
										.withFeedbackDisabled(), "particle minecraft:dust 0.385 0 0.213 1 ^ ^ ^0.6 0.01 0.01 0.01 0 10");
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager()
								.handleCommand(new CommandSource(ICommandSource.DUMMY,
										new Vector3d((x - Numerical_value * Math.cos(Math.toRadians(angle)) * Math.sin(Math.toRadians(yaw))),
												((y + 1) - Numerical_value * Math.sin(Math.toRadians(angle))),
												(z + Numerical_value * Math.cos(Math.toRadians(angle)) * Math.cos(Math.toRadians(yaw)))),
										Vector2f.ZERO, (ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(), null)
										.withFeedbackDisabled(), "particle minecraft:dust 0.385 0 0.213 1 ^ ^ ^0.9 0.01 0.01 0.01 0 10");
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager()
								.handleCommand(
										new CommandSource(ICommandSource.DUMMY,
												new Vector3d((x - Numerical_value * Math.cos(Math.toRadians(angle)) * Math.sin(Math.toRadians(yaw))),
														((y + 1) - Numerical_value * Math.sin(Math.toRadians(angle))),
														(z + Numerical_value * Math.cos(Math.toRadians(angle)) * Math.cos(Math.toRadians(yaw)))),
												Vector2f.ZERO, (ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(),
												null).withFeedbackDisabled(),
										"particle minecraft:dust 0.385 0 0.213 1 ^ ^ ^-0.3 0.01 0.01 0.01 0 10");
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager()
								.handleCommand(
										new CommandSource(ICommandSource.DUMMY,
												new Vector3d((x - Numerical_value * Math.cos(Math.toRadians(angle)) * Math.sin(Math.toRadians(yaw))),
														((y + 1) - Numerical_value * Math.sin(Math.toRadians(angle))),
														(z + Numerical_value * Math.cos(Math.toRadians(angle)) * Math.cos(Math.toRadians(yaw)))),
												Vector2f.ZERO, (ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(),
												null).withFeedbackDisabled(),
										"particle minecraft:dust 0.385 0 0.213 1 ^ ^ ^-0.6 0.01 0.01 0.01 0 10");
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager()
								.handleCommand(
										new CommandSource(ICommandSource.DUMMY,
												new Vector3d((x - Numerical_value * Math.cos(Math.toRadians(angle)) * Math.sin(Math.toRadians(yaw))),
														((y + 1) - Numerical_value * Math.sin(Math.toRadians(angle))),
														(z + Numerical_value * Math.cos(Math.toRadians(angle)) * Math.cos(Math.toRadians(yaw)))),
												Vector2f.ZERO, (ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(),
												null).withFeedbackDisabled(),
										"particle minecraft:dust 0.385 0 0.213 1 ^ ^ ^-0.9 0.01 0.01 0.01 0 10");
					}
					if (world instanceof ServerWorld) {
						((ServerWorld) world).spawnParticle(ParticleTypes.SWEEP_ATTACK,
								(x - Numerical_value * Math.cos(Math.toRadians(angle)) * Math.sin(Math.toRadians(yaw))),
								((y + 1) - Numerical_value * Math.sin(Math.toRadians(angle))),
								(z + Numerical_value * Math.cos(Math.toRadians(angle)) * Math.cos(Math.toRadians(yaw))), (int) 1, 0.01, 0.01, 0.01,
								0.75);
					}
					if (world instanceof ServerWorld) {
						((ServerWorld) world).spawnParticle(ParticleTypes.TOTEM_OF_UNDYING,
								(x - Numerical_value * Math.cos(Math.toRadians(angle)) * Math.sin(Math.toRadians(yaw))),
								((y + 1) - Numerical_value * Math.sin(Math.toRadians(angle))),
								(z + Numerical_value * Math.cos(Math.toRadians(angle)) * Math.cos(Math.toRadians(yaw))), (int) 15, 0.01, 0.01, 0.01,
								0.75);
					}
					if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
							.getItem() == PoisonbookItem.block) {
						if (world instanceof ServerWorld) {
							((ServerWorld) world).spawnParticle(DokuroParticle.particle,
									(x - Numerical_value * Math.cos(Math.toRadians(angle)) * Math.sin(Math.toRadians(yaw))),
									((y + 1) - Numerical_value * Math.sin(Math.toRadians(angle))),
									(z + Numerical_value * Math.cos(Math.toRadians(angle)) * Math.cos(Math.toRadians(yaw))), (int) 15, 0.01, 0.01,
									0.01, 0.75);
						}
					}
					if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
							.getItem() == BookbloodItem.block) {
						if ((EnchantmentHelper.getEnchantmentLevel(KillEnchantment.enchantment,
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)) != 0)) {
							if (world instanceof ServerWorld) {
								((ServerWorld) world).spawnParticle(ParticleTypes.SOUL_FIRE_FLAME,
										(x - Numerical_value * Math.cos(Math.toRadians(angle)) * Math.sin(Math.toRadians(yaw))),
										((y + 1) - Numerical_value * Math.sin(Math.toRadians(angle))),
										(z + Numerical_value * Math.cos(Math.toRadians(angle)) * Math.cos(Math.toRadians(yaw))), (int) 15, 0.01, 0.01,
										0.01, 0.75);
							}
						} else {
							if (world instanceof ServerWorld) {
								((ServerWorld) world).spawnParticle(ParticleTypes.FLAME,
										(x - Numerical_value * Math.cos(Math.toRadians(angle)) * Math.sin(Math.toRadians(yaw))),
										((y + 1) - Numerical_value * Math.sin(Math.toRadians(angle))),
										(z + Numerical_value * Math.cos(Math.toRadians(angle)) * Math.cos(Math.toRadians(yaw))), (int) 15, 0.01, 0.01,
										0.01, 0.75);
							}
						}
					}
					Numerical_value = (Numerical_value + 0.2);
				}
				if (!(new Object() {
					boolean check(Entity _entity) {
						if (_entity instanceof LivingEntity) {
							Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
							for (EffectInstance effect : effects) {
								if (effect.getPotion() == KurutaimunasiPotionEffect.potion)
									return true;
							}
						}
						return false;
					}
				}.check(entity))) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).getCooldownTracker().setCooldown(DemonScytheItem.block, (int) 25);
				}
				if (!(new Object() {
					public boolean checkGamemode(Entity _ent) {
						if (_ent instanceof ServerPlayerEntity) {
							return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.CREATIVE;
						} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
							NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
									.getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
							return _npi != null && _npi.getGameType() == GameType.CREATIVE;
						}
						return false;
					}
				}.checkGamemode(entity) || new Object() {
					public boolean checkGamemode(Entity _ent) {
						if (_ent instanceof ServerPlayerEntity) {
							return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.SPECTATOR;
						} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
							NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
									.getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
							return _npi != null && _npi.getGameType() == GameType.SPECTATOR;
						}
						return false;
					}
				}.checkGamemode(entity)
						|| (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
								? ((ServerPlayerEntity) entity).getAdvancements()
										.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
												.getAdvancement(new ResourceLocation("japanesesword:tidaisuki")))
										.isDone()
								: false))) {
					if (entity instanceof LivingEntity)
						((LivingEntity) entity)
								.setHealth((float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) - 5));
				}
			}
		}
	}
}
