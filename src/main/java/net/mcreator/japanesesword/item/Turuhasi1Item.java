
package net.mcreator.japanesesword.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.japanesesword.JapaneseswordModElements;

@JapaneseswordModElements.ModElement.Tag
public class Turuhasi1Item extends JapaneseswordModElements.ModElement {
	@ObjectHolder("japanesesword:turuhasi_1")
	public static final Item block = null;

	public Turuhasi1Item(JapaneseswordModElements instance) {
		super(instance, 230);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
			public int getMaxUses() {
				return 300;
			}

			public float getEfficiency() {
				return 20f;
			}

			public float getAttackDamage() {
				return 6f;
			}

			public int getHarvestLevel() {
				return 20;
			}

			public int getEnchantability() {
				return 9;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(NItem.block), new ItemStack(Turuhasi1Item.block));
			}
		}, 1, 6f, new Item.Properties().group(ItemGroup.TOOLS)) {
		}.setRegistryName("turuhasi_1"));
	}
}
