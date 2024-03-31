package com.anchovypizzahelper;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class AnchovyPizzaHelperTest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(AnchovyPizzaHelperPlugin.class);
		RuneLite.main(args);
	}
}
