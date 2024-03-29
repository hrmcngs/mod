package japanesesword.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.projectile.TridentEntity;
import net.minecraft.entity.projectile.SpectralArrowEntity;
import net.minecraft.entity.projectile.SnowballEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.entity.projectile.EggEntity;
import net.minecraft.entity.projectile.DragonFireballEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;

import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.Random;
import java.util.Map;
import java.util.List;
import java.util.Comparator;

import japanesesword.item.PoisonbookItem;
import japanesesword.item.NgskItem;
import japanesesword.item.BookbloodItem;

import japanesesword.enchantment.KillEnchantment;
import japanesesword.enchantment.DemonizedEnchantment;

import japanesesword.JapaneseswordMod;

public class GehuekutogaYouXiaoShinoteitukuProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				JapaneseswordMod.LOGGER.warn("Failed to load dependency world for procedure GehuekutogaYouXiaoShinoteituku!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				JapaneseswordMod.LOGGER.warn("Failed to load dependency x for procedure GehuekutogaYouXiaoShinoteituku!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				JapaneseswordMod.LOGGER.warn("Failed to load dependency y for procedure GehuekutogaYouXiaoShinoteituku!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				JapaneseswordMod.LOGGER.warn("Failed to load dependency z for procedure GehuekutogaYouXiaoShinoteituku!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				JapaneseswordMod.LOGGER.warn("Failed to load dependency entity for procedure GehuekutogaYouXiaoShinoteituku!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		double dis = 0;
		double xRadius = 0;
		double loop = 0;
		double XRadius2 = 0;
		double ZRadius2 = 0;
		double zRadius = 0;
		double X = 0;
		double Y = 0;
		double Z = 0;
		double particleAmount = 0;
		double Y_pos = 0;
		double dis1 = 0;
		world.addParticle(ParticleTypes.SWEEP_ATTACK, x, y, z, 0, 1, 0);
		{
			List<Entity> _entfound = world
					.getEntitiesWithinAABB(Entity.class,
							new AxisAlignedBB(x - (1 / 2d), y - (1 / 2d), z - (1 / 2d), x + (1 / 2d), y + (1 / 2d), z + (1 / 2d)), null)
					.stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
						}
					}.compareDistOf(x, y, z)).collect(Collectors.toList());
			for (Entity entityiterator : _entfound) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"particle minecraft:dust ~ ~ ~ ~ ~ ~ 0 0 0");
				}
				if (entityiterator instanceof ArrowEntity || entityiterator instanceof SpectralArrowEntity || entityiterator instanceof TridentEntity
						|| entityiterator instanceof FireballEntity || entityiterator instanceof DragonFireballEntity
						|| entityiterator instanceof SnowballEntity || entityiterator instanceof EggEntity) {
					if (!(entityiterator.getPosX() + entityiterator.getPosY() + entityiterator.getPosZ() == 0)) {
						if (entityiterator.getPersistentData().getBoolean("Check") == false) {
							entityiterator.getPersistentData().putBoolean("Check", (true));
							dis1 = Math.sqrt(Math.pow(entityiterator.getPosX() - entity.getPosX(), 0.4)
									+ Math.pow(entityiterator.getPosY() - entity.getPosY(), 0.4)
									+ Math.pow(entityiterator.getPosZ() - entity.getPosZ(), 0.4));
							if (dis1 <= 0.4) {
								entityiterator.getPersistentData().putBoolean("My arrow", (true));
							} else {
								entityiterator.getPersistentData().putBoolean("My arrow", (false));
							}
							if (entityiterator.getPersistentData().getBoolean("battozyutu") == false
									&& entityiterator.getPersistentData().getBoolean("My arrow") == false) {
								if (entityiterator.getPersistentData().getBoolean("Check2") == false) {
									entityiterator.getPersistentData().putBoolean("Check2", (true));
									if (world instanceof World && !world.isRemote()) {
										((World) world).playSound(null,
												new BlockPos(entityiterator.getPosX(), entityiterator.getPosY(), entityiterator.getPosZ()),
												(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
														.getValue(new ResourceLocation("block.anvil.land")),
												SoundCategory.VOICE, (float) 1, (float) 1);
									} else {
										((World) world).playSound((entityiterator.getPosX()), (entityiterator.getPosY()), (entityiterator.getPosZ()),
												(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
														.getValue(new ResourceLocation("block.anvil.land")),
												SoundCategory.VOICE, (float) 1, (float) 1, false);
									}
									if (world instanceof World && !world.isRemote()) {
										((World) world).playSound(null, new BlockPos(x, y, z),
												(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
														.getValue(new ResourceLocation("entity.drowned.shoot")),
												SoundCategory.VOICE, (float) 1, (float) 1);
									} else {
										((World) world).playSound(x, y, z,
												(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
														.getValue(new ResourceLocation("entity.drowned.shoot")),
												SoundCategory.VOICE, (float) 1, (float) 1, false);
									}
									world.addParticle(ParticleTypes.SWEEP_ATTACK, (entityiterator.getPosX()),
											(entityiterator.getPosY() + MathHelper.nextDouble(new Random(), -0.1, 0.5)), (entityiterator.getPosZ()),
											0, 1, 0);
									{
										Entity _ent = entityiterator;
										if (!_ent.world.isRemote && _ent.world.getServer() != null) {
											_ent.world.getServer().getCommandManager().handleCommand(
													_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
													"/particle dust 0.639 0.169 0.169 1 ~ ~0.5 ~ 0.3 0.1 0.3 0.1 10 force");
										}
									}
									{
										Entity _ent = entityiterator;
										if (!_ent.world.isRemote && _ent.world.getServer() != null) {
											_ent.world.getServer().getCommandManager()
													.handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "kill");
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
								} else {
									if (world instanceof World && !world.isRemote()) {
										((World) world).playSound(null,
												new BlockPos(entityiterator.getPosX(), entityiterator.getPosY(), entityiterator.getPosZ()),
												(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
														.getValue(new ResourceLocation("block.anvil.land")),
												SoundCategory.VOICE, (float) 1, (float) 1);
									} else {
										((World) world).playSound((entityiterator.getPosX()), (entityiterator.getPosY()), (entityiterator.getPosZ()),
												(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
														.getValue(new ResourceLocation("block.anvil.land")),
												SoundCategory.VOICE, (float) 1, (float) 1, false);
									}
									if (world instanceof World && !world.isRemote()) {
										((World) world).playSound(null, new BlockPos(x, y, z),
												(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
														.getValue(new ResourceLocation("entity.drowned.shoot")),
												SoundCategory.VOICE, (float) 1, (float) 1);
									} else {
										((World) world).playSound(x, y, z,
												(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
														.getValue(new ResourceLocation("entity.drowned.shoot")),
												SoundCategory.VOICE, (float) 1, (float) 1, false);
									}
									world.addParticle(ParticleTypes.SWEEP_ATTACK, (entityiterator.getPosX()),
											(entityiterator.getPosY() + MathHelper.nextDouble(new Random(), -0.1, 0.5)), (entityiterator.getPosZ()),
											0, 1, 0);
									{
										Entity _ent = entityiterator;
										if (!_ent.world.isRemote && _ent.world.getServer() != null) {
											_ent.world.getServer().getCommandManager().handleCommand(
													_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
													"/particle dust 0.639 0.169 0.169 1 ~ ~0.5 ~ 0.3 0.1 0.3 0.1 10 force");
										}
									}
									{
										Entity _ent = entityiterator;
										if (!_ent.world.isRemote && _ent.world.getServer() != null) {
											_ent.world.getServer().getCommandManager()
													.handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "kill");
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
						}
					}
				}
			}
		}
		{
			List<Entity> _entfound = world
					.getEntitiesWithinAABB(Entity.class,
							new AxisAlignedBB(x - (2 / 2d), y - (2 / 2d), z - (2 / 2d), x + (2 / 2d), y + (2 / 2d), z + (2 / 2d)), null)
					.stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
						}
					}.compareDistOf(x, y, z)).collect(Collectors.toList());
			for (Entity entityiterator : _entfound) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"particle minecraft:dust ~ ~ ~ ~ ~ ~ 0 0 0");
				}
				if (entityiterator instanceof ArrowEntity || entityiterator instanceof SpectralArrowEntity || entityiterator instanceof TridentEntity
						|| entityiterator instanceof FireballEntity || entityiterator instanceof DragonFireballEntity
						|| entityiterator instanceof SnowballEntity || entityiterator instanceof EggEntity) {
					if (!(entityiterator.getPosX() + entityiterator.getPosY() + entityiterator.getPosZ() == 0)) {
						if (entityiterator.getPersistentData().getBoolean("Check") == false) {
							entityiterator.getPersistentData().putBoolean("Check", (true));
							dis1 = Math.sqrt(Math.pow(entityiterator.getPosX() - entity.getPosX(), 0.4)
									+ Math.pow(entityiterator.getPosY() - entity.getPosY(), 0.4)
									+ Math.pow(entityiterator.getPosZ() - entity.getPosZ(), 0.4));
							if (dis1 <= 0.8) {
								entityiterator.getPersistentData().putBoolean("My arrow", (true));
							} else {
								entityiterator.getPersistentData().putBoolean("My arrow", (false));
							}
							if (entityiterator.getPersistentData().getBoolean("battozyutu") == false
									&& entityiterator.getPersistentData().getBoolean("My arrow") == false) {
								if (entityiterator.getPersistentData().getBoolean("Check2") == false) {
									entityiterator.getPersistentData().putBoolean("Check2", (true));
									if (world instanceof World && !world.isRemote()) {
										((World) world).playSound(null,
												new BlockPos(entityiterator.getPosX(), entityiterator.getPosY(), entityiterator.getPosZ()),
												(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
														.getValue(new ResourceLocation("block.anvil.land")),
												SoundCategory.VOICE, (float) 1, (float) 1);
									} else {
										((World) world).playSound((entityiterator.getPosX()), (entityiterator.getPosY()), (entityiterator.getPosZ()),
												(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
														.getValue(new ResourceLocation("block.anvil.land")),
												SoundCategory.VOICE, (float) 1, (float) 1, false);
									}
									if (world instanceof World && !world.isRemote()) {
										((World) world).playSound(null, new BlockPos(x, y, z),
												(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
														.getValue(new ResourceLocation("entity.drowned.shoot")),
												SoundCategory.VOICE, (float) 1, (float) 1);
									} else {
										((World) world).playSound(x, y, z,
												(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
														.getValue(new ResourceLocation("entity.drowned.shoot")),
												SoundCategory.VOICE, (float) 1, (float) 1, false);
									}
									world.addParticle(ParticleTypes.SWEEP_ATTACK, (entityiterator.getPosX()),
											(entityiterator.getPosY() + MathHelper.nextDouble(new Random(), -0.1, 0.5)), (entityiterator.getPosZ()),
											0, 1, 0);
									{
										Entity _ent = entityiterator;
										if (!_ent.world.isRemote && _ent.world.getServer() != null) {
											_ent.world.getServer().getCommandManager().handleCommand(
													_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
													"/particle dust 0.639 0.169 0.169 1 ~ ~0.5 ~ 0.3 0.1 0.3 0.1 10 force");
										}
									}
									{
										Entity _ent = entityiterator;
										if (!_ent.world.isRemote && _ent.world.getServer() != null) {
											_ent.world.getServer().getCommandManager()
													.handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "kill");
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
								} else {
									if (world instanceof World && !world.isRemote()) {
										((World) world).playSound(null,
												new BlockPos(entityiterator.getPosX(), entityiterator.getPosY(), entityiterator.getPosZ()),
												(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
														.getValue(new ResourceLocation("block.anvil.land")),
												SoundCategory.VOICE, (float) 1, (float) 1);
									} else {
										((World) world).playSound((entityiterator.getPosX()), (entityiterator.getPosY()), (entityiterator.getPosZ()),
												(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
														.getValue(new ResourceLocation("block.anvil.land")),
												SoundCategory.VOICE, (float) 1, (float) 1, false);
									}
									if (world instanceof World && !world.isRemote()) {
										((World) world).playSound(null, new BlockPos(x, y, z),
												(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
														.getValue(new ResourceLocation("entity.drowned.shoot")),
												SoundCategory.VOICE, (float) 1, (float) 1);
									} else {
										((World) world).playSound(x, y, z,
												(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
														.getValue(new ResourceLocation("entity.drowned.shoot")),
												SoundCategory.VOICE, (float) 1, (float) 1, false);
									}
									world.addParticle(ParticleTypes.SWEEP_ATTACK, (entityiterator.getPosX()),
											(entityiterator.getPosY() + MathHelper.nextDouble(new Random(), -0.1, 0.5)), (entityiterator.getPosZ()),
											0, 1, 0);
									{
										Entity _ent = entityiterator;
										if (!_ent.world.isRemote && _ent.world.getServer() != null) {
											_ent.world.getServer().getCommandManager().handleCommand(
													_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
													"/particle dust 0.639 0.169 0.169 1 ~ ~0.5 ~ 0.3 0.1 0.3 0.1 10 force");
										}
									}
									{
										Entity _ent = entityiterator;
										if (!_ent.world.isRemote && _ent.world.getServer() != null) {
											_ent.world.getServer().getCommandManager()
													.handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "kill");
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
						}
					}
				}
			}
		}
		{
			List<Entity> _entfound = world
					.getEntitiesWithinAABB(Entity.class,
							new AxisAlignedBB(x - (3 / 2d), y - (3 / 2d), z - (3 / 2d), x + (3 / 2d), y + (3 / 2d), z + (3 / 2d)), null)
					.stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
						}
					}.compareDistOf(x, y, z)).collect(Collectors.toList());
			for (Entity entityiterator : _entfound) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"particle minecraft:dust ~ ~ ~ ~ ~ ~ 0 0 0");
				}
				if (entityiterator instanceof ArrowEntity || entityiterator instanceof SpectralArrowEntity || entityiterator instanceof TridentEntity
						|| entityiterator instanceof FireballEntity || entityiterator instanceof DragonFireballEntity
						|| entityiterator instanceof SnowballEntity || entityiterator instanceof EggEntity) {
					if (!(entityiterator.getPosX() + entityiterator.getPosY() + entityiterator.getPosZ() == 0)) {
						if (entityiterator.getPersistentData().getBoolean("Check") == false) {
							entityiterator.getPersistentData().putBoolean("Check", (true));
							dis1 = Math.sqrt(Math.pow(entityiterator.getPosX() - entity.getPosX(), 0.4)
									+ Math.pow(entityiterator.getPosY() - entity.getPosY(), 0.4)
									+ Math.pow(entityiterator.getPosZ() - entity.getPosZ(), 0.4));
							if (dis1 <= 1.2) {
								entityiterator.getPersistentData().putBoolean("My arrow", (true));
							} else {
								entityiterator.getPersistentData().putBoolean("My arrow", (false));
							}
							if (entityiterator.getPersistentData().getBoolean("battozyutu") == false
									&& entityiterator.getPersistentData().getBoolean("My arrow") == false) {
								if (entityiterator.getPersistentData().getBoolean("Check2") == false) {
									entityiterator.getPersistentData().putBoolean("Check2", (true));
									if (world instanceof World && !world.isRemote()) {
										((World) world).playSound(null,
												new BlockPos(entityiterator.getPosX(), entityiterator.getPosY(), entityiterator.getPosZ()),
												(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
														.getValue(new ResourceLocation("block.anvil.land")),
												SoundCategory.VOICE, (float) 1, (float) 1);
									} else {
										((World) world).playSound((entityiterator.getPosX()), (entityiterator.getPosY()), (entityiterator.getPosZ()),
												(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
														.getValue(new ResourceLocation("block.anvil.land")),
												SoundCategory.VOICE, (float) 1, (float) 1, false);
									}
									if (world instanceof World && !world.isRemote()) {
										((World) world).playSound(null, new BlockPos(x, y, z),
												(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
														.getValue(new ResourceLocation("entity.drowned.shoot")),
												SoundCategory.VOICE, (float) 1, (float) 1);
									} else {
										((World) world).playSound(x, y, z,
												(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
														.getValue(new ResourceLocation("entity.drowned.shoot")),
												SoundCategory.VOICE, (float) 1, (float) 1, false);
									}
									world.addParticle(ParticleTypes.SWEEP_ATTACK, (entityiterator.getPosX()),
											(entityiterator.getPosY() + MathHelper.nextDouble(new Random(), -0.1, 0.5)), (entityiterator.getPosZ()),
											0, 1, 0);
									{
										Entity _ent = entityiterator;
										if (!_ent.world.isRemote && _ent.world.getServer() != null) {
											_ent.world.getServer().getCommandManager().handleCommand(
													_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
													"/particle dust 0.639 0.169 0.169 1 ~ ~0.5 ~ 0.3 0.1 0.3 0.1 10 force");
										}
									}
									{
										Entity _ent = entityiterator;
										if (!_ent.world.isRemote && _ent.world.getServer() != null) {
											_ent.world.getServer().getCommandManager()
													.handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "kill");
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
								} else {
									if (world instanceof World && !world.isRemote()) {
										((World) world).playSound(null,
												new BlockPos(entityiterator.getPosX(), entityiterator.getPosY(), entityiterator.getPosZ()),
												(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
														.getValue(new ResourceLocation("block.anvil.land")),
												SoundCategory.VOICE, (float) 1, (float) 1);
									} else {
										((World) world).playSound((entityiterator.getPosX()), (entityiterator.getPosY()), (entityiterator.getPosZ()),
												(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
														.getValue(new ResourceLocation("block.anvil.land")),
												SoundCategory.VOICE, (float) 1, (float) 1, false);
									}
									if (world instanceof World && !world.isRemote()) {
										((World) world).playSound(null, new BlockPos(x, y, z),
												(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
														.getValue(new ResourceLocation("entity.drowned.shoot")),
												SoundCategory.VOICE, (float) 1, (float) 1);
									} else {
										((World) world).playSound(x, y, z,
												(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
														.getValue(new ResourceLocation("entity.drowned.shoot")),
												SoundCategory.VOICE, (float) 1, (float) 1, false);
									}
									world.addParticle(ParticleTypes.SWEEP_ATTACK, (entityiterator.getPosX()),
											(entityiterator.getPosY() + MathHelper.nextDouble(new Random(), -0.1, 0.5)), (entityiterator.getPosZ()),
											0, 1, 0);
									{
										Entity _ent = entityiterator;
										if (!_ent.world.isRemote && _ent.world.getServer() != null) {
											_ent.world.getServer().getCommandManager().handleCommand(
													_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
													"/particle dust 0.639 0.169 0.169 1 ~ ~0.5 ~ 0.3 0.1 0.3 0.1 10 force");
										}
									}
									{
										Entity _ent = entityiterator;
										if (!_ent.world.isRemote && _ent.world.getServer() != null) {
											_ent.world.getServer().getCommandManager()
													.handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "kill");
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
						}
					}
				}
			}
		}
		{
			List<Entity> _entfound = world
					.getEntitiesWithinAABB(Entity.class,
							new AxisAlignedBB(x - (3 / 2d), y - (3 / 2d), z - (3 / 2d), x + (3 / 2d), y + (3 / 2d), z + (3 / 2d)), null)
					.stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
						}
					}.compareDistOf(x, y, z)).collect(Collectors.toList());
			for (Entity entityiterator : _entfound) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"particle minecraft:dust ~ ~ ~ ~ ~ ~ 0 0 0");
				}
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
									if (EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
											((entity instanceof LivingEntity)
													? ((LivingEntity) entity).getHeldItemMainhand()
													: ItemStack.EMPTY)) > 0) {
										if (entity instanceof LivingEntity)
											((LivingEntity) entity)
													.setHealth((float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
															+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																	((entity instanceof LivingEntity)
																			? ((LivingEntity) entity).getHeldItemMainhand()
																			: ItemStack.EMPTY))));
									}
									entityiterator.setFire((int) 15);
									{
										Entity _ent = entityiterator;
										if (!_ent.world.isRemote && _ent.world.getServer() != null) {
											_ent.world.getServer().getCommandManager()
													.handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "/kill @s");
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
									if (EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
											((entity instanceof LivingEntity)
													? ((LivingEntity) entity).getHeldItemMainhand()
													: ItemStack.EMPTY)) > 0) {
										if (entity instanceof LivingEntity)
											((LivingEntity) entity)
													.setHealth((float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
															+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																	((entity instanceof LivingEntity)
																			? ((LivingEntity) entity).getHeldItemMainhand()
																			: ItemStack.EMPTY))));
									}
									if (entityiterator instanceof LivingEntity)
										((LivingEntity) entityiterator).addPotionEffect(new EffectInstance(Effects.POISON, (int) 300, (int) 1));
									entityiterator.setFire((int) 15);
									{
										Entity _ent = entityiterator;
										if (!_ent.world.isRemote && _ent.world.getServer() != null) {
											_ent.world.getServer().getCommandManager()
													.handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "/kill @s");
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
								if (EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
										((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)) > 0) {
									if (entity instanceof LivingEntity)
										((LivingEntity) entity)
												.setHealth((float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
														+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																((entity instanceof LivingEntity)
																		? ((LivingEntity) entity).getHeldItemMainhand()
																		: ItemStack.EMPTY))));
								}
								{
									Entity _ent = entityiterator;
									if (!_ent.world.isRemote && _ent.world.getServer() != null) {
										_ent.world.getServer().getCommandManager()
												.handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "/kill @s");
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
									.getItem() == NgskItem.block) {
								if (EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
										((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)) > 0) {
									if (entity instanceof LivingEntity)
										((LivingEntity) entity)
												.setHealth((float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
														+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																((entity instanceof LivingEntity)
																		? ((LivingEntity) entity).getHeldItemMainhand()
																		: ItemStack.EMPTY))));
								}
								entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 10);
							} else {
								if (EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
										((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)) > 0) {
									if (entity instanceof LivingEntity)
										((LivingEntity) entity)
												.setHealth((float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
														+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																((entity instanceof LivingEntity)
																		? ((LivingEntity) entity).getHeldItemMainhand()
																		: ItemStack.EMPTY))));
								}
								entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 5);
							}
							if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
									.getItem() == BookbloodItem.block) {
								if (EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
										((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)) > 0) {
									if (entity instanceof LivingEntity)
										((LivingEntity) entity)
												.setHealth((float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
														+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																((entity instanceof LivingEntity)
																		? ((LivingEntity) entity).getHeldItemMainhand()
																		: ItemStack.EMPTY))));
								}
								entityiterator.setFire((int) 15);
								entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 5);
							}
							if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
									.getItem() == PoisonbookItem.block) {
								if (EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
										((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)) > 0) {
									if (entity instanceof LivingEntity)
										((LivingEntity) entity)
												.setHealth((float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
														+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																((entity instanceof LivingEntity)
																		? ((LivingEntity) entity).getHeldItemMainhand()
																		: ItemStack.EMPTY))));
								}
								if (entityiterator instanceof LivingEntity)
									((LivingEntity) entityiterator).addPotionEffect(new EffectInstance(Effects.POISON, (int) 300, (int) 1));
								entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 5);
							}
						}
					}
				}
			}
		}
		{
			List<Entity> _entfound = world
					.getEntitiesWithinAABB(Entity.class,
							new AxisAlignedBB(x - (2 / 2d), y - (2 / 2d), z - (2 / 2d), x + (2 / 2d), y + (2 / 2d), z + (2 / 2d)), null)
					.stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
						}
					}.compareDistOf(x, y, z)).collect(Collectors.toList());
			for (Entity entityiterator : _entfound) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"particle minecraft:dust ~ ~ ~ ~ ~ ~ 0 0 0");
				}
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
									if (EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
											((entity instanceof LivingEntity)
													? ((LivingEntity) entity).getHeldItemMainhand()
													: ItemStack.EMPTY)) > 0) {
										if (entity instanceof LivingEntity)
											((LivingEntity) entity)
													.setHealth((float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
															+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																	((entity instanceof LivingEntity)
																			? ((LivingEntity) entity).getHeldItemMainhand()
																			: ItemStack.EMPTY))));
									}
									entityiterator.setFire((int) 15);
									{
										Entity _ent = entityiterator;
										if (!_ent.world.isRemote && _ent.world.getServer() != null) {
											_ent.world.getServer().getCommandManager()
													.handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "/kill @s");
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
									if (EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
											((entity instanceof LivingEntity)
													? ((LivingEntity) entity).getHeldItemMainhand()
													: ItemStack.EMPTY)) > 0) {
										if (entity instanceof LivingEntity)
											((LivingEntity) entity)
													.setHealth((float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
															+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																	((entity instanceof LivingEntity)
																			? ((LivingEntity) entity).getHeldItemMainhand()
																			: ItemStack.EMPTY))));
									}
									if (entityiterator instanceof LivingEntity)
										((LivingEntity) entityiterator).addPotionEffect(new EffectInstance(Effects.POISON, (int) 300, (int) 1));
									entityiterator.setFire((int) 15);
									{
										Entity _ent = entityiterator;
										if (!_ent.world.isRemote && _ent.world.getServer() != null) {
											_ent.world.getServer().getCommandManager()
													.handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "/kill @s");
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
								if (EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
										((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)) > 0) {
									if (entity instanceof LivingEntity)
										((LivingEntity) entity)
												.setHealth((float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
														+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																((entity instanceof LivingEntity)
																		? ((LivingEntity) entity).getHeldItemMainhand()
																		: ItemStack.EMPTY))));
								}
								{
									Entity _ent = entityiterator;
									if (!_ent.world.isRemote && _ent.world.getServer() != null) {
										_ent.world.getServer().getCommandManager()
												.handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "/kill @s");
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
									.getItem() == NgskItem.block) {
								if (EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
										((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)) > 0) {
									if (entity instanceof LivingEntity)
										((LivingEntity) entity)
												.setHealth((float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
														+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																((entity instanceof LivingEntity)
																		? ((LivingEntity) entity).getHeldItemMainhand()
																		: ItemStack.EMPTY))));
								}
								entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 10);
							} else {
								if (EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
										((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)) > 0) {
									if (entity instanceof LivingEntity)
										((LivingEntity) entity)
												.setHealth((float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
														+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																((entity instanceof LivingEntity)
																		? ((LivingEntity) entity).getHeldItemMainhand()
																		: ItemStack.EMPTY))));
								}
								entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 5);
							}
							if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
									.getItem() == BookbloodItem.block) {
								if (EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
										((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)) > 0) {
									if (entity instanceof LivingEntity)
										((LivingEntity) entity)
												.setHealth((float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
														+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																((entity instanceof LivingEntity)
																		? ((LivingEntity) entity).getHeldItemMainhand()
																		: ItemStack.EMPTY))));
								}
								entityiterator.setFire((int) 15);
								entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 5);
							}
							if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
									.getItem() == PoisonbookItem.block) {
								if (EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
										((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)) > 0) {
									if (entity instanceof LivingEntity)
										((LivingEntity) entity)
												.setHealth((float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
														+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																((entity instanceof LivingEntity)
																		? ((LivingEntity) entity).getHeldItemMainhand()
																		: ItemStack.EMPTY))));
								}
								if (entityiterator instanceof LivingEntity)
									((LivingEntity) entityiterator).addPotionEffect(new EffectInstance(Effects.POISON, (int) 300, (int) 1));
								entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 5);
							}
						}
					}
				}
			}
		}
		{
			List<Entity> _entfound = world
					.getEntitiesWithinAABB(Entity.class,
							new AxisAlignedBB(x - (1 / 2d), y - (1 / 2d), z - (1 / 2d), x + (1 / 2d), y + (1 / 2d), z + (1 / 2d)), null)
					.stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
						}
					}.compareDistOf(x, y, z)).collect(Collectors.toList());
			for (Entity entityiterator : _entfound) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"particle minecraft:dust ~ ~ ~ ~ ~ ~ 0 0 0");
				}
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
									{
										Entity _ent = entityiterator;
										if (!_ent.world.isRemote && _ent.world.getServer() != null) {
											_ent.world.getServer().getCommandManager().handleCommand(
													_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
													"particle item redstone ~ ~1 ~ 0.5 0.5 0.5 0.3 100 force");
										}
									}
									if (EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
											((entity instanceof LivingEntity)
													? ((LivingEntity) entity).getHeldItemMainhand()
													: ItemStack.EMPTY)) > 0) {
										if (entity instanceof LivingEntity)
											((LivingEntity) entity)
													.setHealth((float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
															+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																	((entity instanceof LivingEntity)
																			? ((LivingEntity) entity).getHeldItemMainhand()
																			: ItemStack.EMPTY))));
									}
									entityiterator.setFire((int) 15);
									{
										Entity _ent = entityiterator;
										if (!_ent.world.isRemote && _ent.world.getServer() != null) {
											_ent.world.getServer().getCommandManager()
													.handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "/kill @s");
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
									{
										Entity _ent = entityiterator;
										if (!_ent.world.isRemote && _ent.world.getServer() != null) {
											_ent.world.getServer().getCommandManager().handleCommand(
													_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
													"particle item redstone ~ ~1 ~ 0.5 0.5 0.5 0.3 100 force");
										}
									}
									if (EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
											((entity instanceof LivingEntity)
													? ((LivingEntity) entity).getHeldItemMainhand()
													: ItemStack.EMPTY)) > 0) {
										if (entity instanceof LivingEntity)
											((LivingEntity) entity)
													.setHealth((float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
															+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																	((entity instanceof LivingEntity)
																			? ((LivingEntity) entity).getHeldItemMainhand()
																			: ItemStack.EMPTY))));
									}
									if (entityiterator instanceof LivingEntity)
										((LivingEntity) entityiterator).addPotionEffect(new EffectInstance(Effects.POISON, (int) 300, (int) 1));
									{
										Entity _ent = entityiterator;
										if (!_ent.world.isRemote && _ent.world.getServer() != null) {
											_ent.world.getServer().getCommandManager()
													.handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "/kill @s");
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
								{
									Entity _ent = entityiterator;
									if (!_ent.world.isRemote && _ent.world.getServer() != null) {
										_ent.world.getServer().getCommandManager().handleCommand(
												_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
												"particle item redstone ~ ~1 ~ 0.5 0.5 0.5 0.3 100 force");
									}
								}
								if (EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
										((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)) > 0) {
									if (entity instanceof LivingEntity)
										((LivingEntity) entity)
												.setHealth((float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
														+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																((entity instanceof LivingEntity)
																		? ((LivingEntity) entity).getHeldItemMainhand()
																		: ItemStack.EMPTY))));
								}
								{
									Entity _ent = entityiterator;
									if (!_ent.world.isRemote && _ent.world.getServer() != null) {
										_ent.world.getServer().getCommandManager()
												.handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "/kill @s");
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
							{
								Entity _ent = entityiterator;
								if (!_ent.world.isRemote && _ent.world.getServer() != null) {
									_ent.world.getServer().getCommandManager().handleCommand(
											_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
											"particle item redstone ~ ~1 ~ 0.5 0.5 0.5 0.3 100 force");
								}
							}
							entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 5);
							if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
									.getItem() == BookbloodItem.block) {
								if (EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
										((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)) > 0) {
									if (entity instanceof LivingEntity)
										((LivingEntity) entity)
												.setHealth((float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
														+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																((entity instanceof LivingEntity)
																		? ((LivingEntity) entity).getHeldItemMainhand()
																		: ItemStack.EMPTY))));
								}
								entityiterator.setFire((int) 15);
							}
							if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
									.getItem() == PoisonbookItem.block) {
								if (EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
										((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)) > 0) {
									if (entity instanceof LivingEntity)
										((LivingEntity) entity)
												.setHealth((float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
														+ EnchantmentHelper.getEnchantmentLevel(DemonizedEnchantment.enchantment,
																((entity instanceof LivingEntity)
																		? ((LivingEntity) entity).getHeldItemMainhand()
																		: ItemStack.EMPTY))));
								}
								if (entityiterator instanceof LivingEntity)
									((LivingEntity) entityiterator).addPotionEffect(new EffectInstance(Effects.POISON, (int) 300, (int) 1));
							}
						}
					}
				}
			}
		}
		entity.fallDistance = (float) (0);
		entity.setMotion((entity.world
				.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
						entity.getEyePosition(1f).add(entity.getLook(1f).x * 5, entity.getLook(1f).y * 5, entity.getLook(1f).z * 5),
						RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
				.getPos().getX()
				- entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
						entity.getEyePosition(1f).add(entity.getLook(1f).x * 0, entity.getLook(1f).y * 0, entity.getLook(1f).z * 0),
						RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getX()),
				0,
				(entity.world
						.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
								entity.getEyePosition(1f).add(entity.getLook(1f).x * 5, entity.getLook(1f).y * 5, entity.getLook(1f).z * 5),
								RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
						.getPos().getZ()
						- entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
								entity.getEyePosition(1f).add(entity.getLook(1f).x * 0, entity.getLook(1f).y * 0, entity.getLook(1f).z * 0),
								RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ()));
	}
}
