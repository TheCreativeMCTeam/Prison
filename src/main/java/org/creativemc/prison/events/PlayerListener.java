package org.creativemc.prison.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.FileUtil;
import org.mineacademy.fo.TimeUtil;

public class PlayerListener implements Listener {

    //-----------------------------------------------

    @EventHandler
    public void onPlayerChat(final AsyncPlayerChatEvent event) {

        final Player player = event.getPlayer();

        FileUtil.write("chatlogs/" + player.getName() + ".log", "[" + TimeUtil.getFormattedDate() + "]"
                + " " + player.getName() + ":" + " " + Common.stripColors(event.getMessage()));

    }

    //-----------------------------------------------

    //TODO If in case the network goes under heavy watch dog (anti-cheat)
    // needed then we will enable this below.
    /*
    @EventHandler
    public void onPlayerCommandUse(final PlayerCommandPreprocessEvent event) {

        final Player player = event.getPlayer();

        FileUtil.write("commandlogs/" + player.getName() + ".log", "[" + TimeUtil.getFormattedDate() + "]"
                + " " + player.getName() + ":" + Common.stripColors(event.getMessage()));

    }
     */
}
