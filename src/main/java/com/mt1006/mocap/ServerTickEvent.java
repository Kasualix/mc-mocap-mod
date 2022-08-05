package com.mt1006.mocap;

import com.mt1006.mocap.mocap.PlayedScene;
import com.mt1006.mocap.mocap.PlayerState;
import com.mt1006.mocap.mocap.Playing;
import com.mt1006.mocap.mocap.Recording;
import net.minecraft.util.Util;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MocapMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ServerTickEvent
{
	private static PlayerState oldPlayerState = null;

	@SubscribeEvent
	public static void onServerTick(TickEvent.ServerTickEvent tickEvent)
	{
		if (tickEvent.phase == TickEvent.Phase.END)
		{
			if (Recording.state == Recording.State.WAITING_FOR_ACTION)
			{
				PlayerState playerState = new PlayerState(Recording.serverPlayer);
				if (!playerState.compare(oldPlayerState))
				{
					Recording.previousPlayerState = null;
					Recording.state = Recording.State.RECORDING;
					Recording.serverPlayer.sendMessage(new TranslationTextComponent("mocap.commands.recording.start.recording_started"), Util.NIL_UUID);
					oldPlayerState = null;
				}
				else
				{
					oldPlayerState = playerState;
				}
			}

			if (Recording.state == Recording.State.RECORDING)
			{
				PlayerState playerState = new PlayerState(Recording.serverPlayer);
				playerState.saveDifference(Recording.recording, Recording.previousPlayerState);
				Recording.previousPlayerState = playerState;
			}

			Playing.onTick();
		}
	}
}