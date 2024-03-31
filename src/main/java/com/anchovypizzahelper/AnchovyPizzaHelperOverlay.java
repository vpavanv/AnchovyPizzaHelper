package com.anchovypizzahelper;

import net.runelite.api.Client;
import net.runelite.api.widgets.WidgetItem;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.overlay.*;

import javax.inject.Inject;
import java.awt.*;
import java.awt.image.BufferedImage;

public class AnchovyPizzaHelperOverlay extends WidgetItemOverlay
{
    private final Client client;
    private final AnchovyPizzaHelperPlugin plugin;
    private final ItemManager itemManager;

    final int ANCHOVY_PIZZA_ID = 2297;

    @Inject
    private AnchovyPizzaHelperOverlay(Client client, AnchovyPizzaHelperPlugin plugin, ItemManager itemManager)
    {
        this.client = client;
        this.plugin = plugin;
        this.itemManager = itemManager;
        showOnInventory();
    }

    @Override
    public void renderItemOverlay(Graphics2D graphics, int itemId, WidgetItem widgetItem)
    {
        Rectangle bounds = widgetItem.getCanvasBounds();

        if (itemId == ANCHOVY_PIZZA_ID && AnchovyPizzaHelperPlugin.highlightAnchovyPizza)
        {
            final BufferedImage outline = itemManager.getItemOutline(itemId, widgetItem.getQuantity(), Color.red);
            graphics.drawImage(outline, (int) bounds.getX(), (int) bounds.getY(), null);
        }
    }

}
