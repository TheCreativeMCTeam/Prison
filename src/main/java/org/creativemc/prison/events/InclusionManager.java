package org.creativemc.prison.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.creativemc.prison.hotbar.PrisonMenuItem;
import org.mineacademy.fo.PlayerUtil;

public class InclusionManager implements Listener {

    @EventHandler
    public void onJoin(final PlayerJoinEvent event) {

        final Player player = event.getPlayer();

        PlayerUtil.addItems(player.getInventory(), PrisonMenuItem.getInstance().getItem());
    }
}
