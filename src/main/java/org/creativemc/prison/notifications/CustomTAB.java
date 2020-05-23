package org.creativemc.prison.notifications;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.remain.Remain;

public class CustomTAB implements Listener {

    @EventHandler
    public void onPlayerJoin(final PlayerJoinEvent event) {

        final Player player = event.getPlayer();

        Remain.sendTablist(player, Common.colorize("&BYou are currently playing on &E&LOP PRISON!")
                , Common.colorize("&EPurchase &C&LRanks, &A&LBoosters &Eand more!"));

    }
}
