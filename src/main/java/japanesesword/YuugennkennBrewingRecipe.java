
package japanesesword;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.common.brewing.IBrewingRecipe;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;

import net.minecraft.item.ItemStack;

import japanesesword.item.YuugenkennItem;
import japanesesword.item.TiItem;
import japanesesword.item.JapaneseSwordItem;

@JapaneseswordModElements.ModElement.Tag
public class YuugennkennBrewingRecipe extends JapaneseswordModElements.ModElement {
	public YuugennkennBrewingRecipe(JapaneseswordModElements instance) {
		super(instance, 60);
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		BrewingRecipeRegistry.addRecipe(new CustomBrewingRecipe());
	}

	public static class CustomBrewingRecipe implements IBrewingRecipe {
		@Override
		public boolean isInput(ItemStack input) {
			return input.getItem() == JapaneseSwordItem.block;
		}

		@Override
		public boolean isIngredient(ItemStack ingredient) {
			return ingredient.getItem() == TiItem.block;
		}

		@Override
		public ItemStack getOutput(ItemStack input, ItemStack ingredient) {
			if (isInput(input) && isIngredient(ingredient)) {
				return new ItemStack(YuugenkennItem.block);
			}
			return ItemStack.EMPTY;
		}
	}
}