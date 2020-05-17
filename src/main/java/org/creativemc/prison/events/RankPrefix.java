package org.creativemc.prison.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.creativemc.prison.PlayerCache;
import org.creativemc.prison.ranks.Rank;
import org.mineacademy.fo.Common;

public class RankPrefix implements Listener {


    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = false)
    public void onChat(final AsyncPlayerChatEvent event) {


        final Player player = event.getPlayer();
        final PlayerCache cache = PlayerCache.getCache(player);

        final Rank rank = cache.getRank();

        event.setFormat(Common.colorize("&7[") + rank.getColor() + rank.getName() + Common.colorize("&7]")
                + " " + player.getName() + ":" + " " + event.getMessage());
    }
}
