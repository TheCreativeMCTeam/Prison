package org.creativemc.prison.notifications;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.creativemc.prison.PlayerCache;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.scoreboard.AdvancedScoreboard;

import java.util.ArrayList;

public class PrisonScoreboard implements Listener {

    @EventHandler
    public void onJoin(final PlayerJoinEvent event) {


        final Player player = event.getPlayer();
        final String name = player.getName();
        final AdvancedScoreboard PrisonScoreboard = new AdvancedScoreboard(player);
        final String node = Bukkit.getServer().getName();
        final PlayerCache cache = PlayerCache.getCache(player);
        final String rankname = cache.getRank().getName();
        final ChatColor rankcolor = cache.getRank().getColor();

        final ArrayList<String> lines = new ArrayList();

        lines.add(Common.colorize(" "));
        lines.add(Common.colorize("&FPlayer:" + " " + "&A" + name));
        lines.add(Common.colorize("&FRank:" + " " + rankcolor + rankname));
        lines.add(Common.colorize(" "));
        lines.add(Common.colorize("&FQuest: &EMerchant I"));
        lines.add(Common.colorize("&FMine: &AMega"));
        lines.add(Common.colorize(" "));
        lines.add(Common.colorize("&E➜ &BDiamond Mine"));
        lines.add(Common.colorize(" "));
        lines.add(Common.colorize("&FCoins:"));
        lines.add(Common.colorize("&FNode:" + " " + ChatColor.AQUA + node));
        lines.add(Common.colorize(" "));
        lines.add(Common.colorize("&Ewww.creativemc.org"));


        Common.runTimerAsync(20, () -> {
            PrisonScoreboard.setTitle(Common.colorize("&E&LPRISON &A&LREVAMP"));
            PrisonScoreboard.setLines(lines);
        });
    }
}
