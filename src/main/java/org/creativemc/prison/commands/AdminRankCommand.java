package org.creativemc.prison.commands;

import org.bukkit.entity.Player;
import org.creativemc.prison.PlayerCache;
import org.creativemc.prison.ranks.Rank;
import org.mineacademy.fo.command.SimpleCommand;

public class AdminRankCommand extends SimpleCommand {

    public AdminRankCommand() {
        super("hired");
        setPermission("admin.set.board");

    }

    @Override
    protected void onCommand() {
        checkConsole();

        final Player player = getPlayer();
        final PlayerCache cache = PlayerCache.getCache(getPlayer());
        cache.setRank(Rank.ADMIN);
    }
}
