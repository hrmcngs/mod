
package japanesesword.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ArmorItem;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.Entity;

import japanesesword.itemgroup.BukiItemGroup;

import japanesesword.JapaneseswordModElements;

@JapaneseswordModElements.ModElement.Tag
public class HanyouItem extends JapaneseswordModElements.ModElement {
	@ObjectHolder("japanesesword:hanyou_helmet")
	public static final Item helmet = null;
	@ObjectHolder("japanesesword:hanyou_chestplate")
	public static final Item body = null;
	@ObjectHolder("japanesesword:hanyou_leggings")
	public static final Item legs = null;
	@ObjectHolder("japanesesword:hanyou_boots")
	public static final Item boots = null;

	public HanyouItem(JapaneseswordModElements instance) {
		super(instance, 362);
	}

	@Override
	public void initElements() {
		IArmorMaterial armormaterial = new IArmorMaterial() {
			@Override
			public int getDurability(EquipmentSlotType slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 0;
			}

			@Override
			public int getDamageReductionAmount(EquipmentSlotType slot) {
				return new int[]{456, 456, 456, 456}[slot.getIndex()];
			}

			@Override
			public int getEnchantability() {
				return 9;
			}

			@Override
			public net.minecraft.util.SoundEvent getSoundEvent() {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
			}

			@Override
			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}

			@OnlyIn(Dist.CLIENT)
			@Override
			public String getName() {
				return "hanyou";
			}

			@Override
			public float getToughness() {
				return 10f;
			}

			@Override
			public float getKnockbackResistance() {
				return 5f;
			}
		};
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.HEAD, new Item.Properties().group(BukiItemGroup.tab)) {
			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "japanesesword:textures/models/armor/reikonnsiro_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}
		}.setRegistryName("hanyou_helmet"));
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.CHEST, new Item.Properties().group(BukiItemGroup.tab)) {
			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "japanesesword:textures/models/armor/reikonnsiro_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}
		}.setRegistryName("hanyou_chestplate"));
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.LEGS, new Item.Properties().group(BukiItemGroup.tab)) {
			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "japanesesword:textures/models/armor/reikonnsiro_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}
		}.setRegistryName("hanyou_leggings"));
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.FEET, new Item.Properties().group(BukiItemGroup.tab)) {
			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "japanesesword:textures/models/armor/reikonnsiro_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}
		}.setRegistryName("hanyou_boots"));
	}

}
