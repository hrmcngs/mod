
package japanesesword.gui.overlay;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.Minecraft;

import japanesesword.JapaneseswordModVariables;

@Mod.EventBusSubscriber
public class Tap2Overlay {
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(RenderGameOverlayEvent.Post event) {
		if (event.getType() == RenderGameOverlayEvent.ElementType.HELMET) {
			int w = event.getWindow().getScaledWidth();
			int h = event.getWindow().getScaledHeight();
			int posX = w / 2;
			int posY = h / 2;
			World _world = null;
			double _x = 0;
			double _y = 0;
			double _z = 0;
			PlayerEntity entity = Minecraft.getInstance().player;
			if (entity != null) {
				_world = entity.world;
				_x = entity.getPosX();
				_y = entity.getPosY();
				_z = entity.getPosZ();
			}
			World world = _world;
			double x = _x;
			double y = _y;
			double z = _z;
			if (true) {
				Minecraft.getInstance().fontRenderer.drawString(event.getMatrixStack(),
						"" + ((entity.getCapability(JapaneseswordModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JapaneseswordModVariables.PlayerVariables())).naninisiyoukana) + "", posX + -203, posY + 104, -16711681);
				Minecraft.getInstance().fontRenderer.drawString(event.getMatrixStack(), "" + ((entity.getCapability(JapaneseswordModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JapaneseswordModVariables.PlayerVariables())).nanndarou) + "",
						posX + 128, posY + 104, -6710887);
			}
		}
	}
}
