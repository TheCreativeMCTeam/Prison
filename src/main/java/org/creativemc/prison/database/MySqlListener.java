package org.creativemc.prison.database;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.creativemc.prison.PlayerCache;
import org.mineacademy.fo.Common;

import java.util.UUID;

public class MySqlListener implements Listener {

    @EventHandler
    public void onPlayerLogin(final AsyncPlayerPreLoginEvent event) {
        final UUID uuid = event.getUniqueId();


        if (event.getLoginResult() == AsyncPlayerPreLoginEvent.Result.ALLOWED) {
            final PlayerCache cache = PlayerCache.getCache(uuid);

            MYSQL.getInstance().load(uuid, cache);
        }
    }

    @EventHandler
    public void onQuit(final PlayerQuitEvent event) {
        final Player player = event.getPlayer();
        final UUID uuid = event.getPlayer().getUniqueId();

        final PlayerCache cache = PlayerCache.getCache(uuid);

        Common.runLaterAsync(() -> MYSQL.getInstance().save(player.getName(), player.getUniqueId(), cache));
    }
}
