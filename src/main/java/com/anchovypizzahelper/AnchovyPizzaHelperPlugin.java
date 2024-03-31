package com.anchovypizzahelper;

import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.*;
import net.runelite.api.events.GameTick;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;


@Slf4j
@PluginDescriptor(
	name = "AnchovyPizzaHelper"
)
public class AnchovyPizzaHelperPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private AnchovyPizzaHelperOverlay anchovyPizzaHelperOverlay;

	public static boolean highlightAnchovyPizza = false;

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(anchovyPizzaHelperOverlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(anchovyPizzaHelperOverlay);
	}

	@Subscribe
	public void onGameTick(GameTick gameTick)
	{
		ItemContainer inventory = client.getItemContainer(InventoryID.INVENTORY);
		highlightAnchovyPizza = false;

		if (inventory != null)
		{
			Item[] playerInventory = inventory.getItems();

			for(int i = 0; i < playerInventory.length; i++)
			{
				if(playerInventory[i].getId() == 2297)
				{
					highlightAnchovyPizza = true;
				}
			}
		}
	}

}
