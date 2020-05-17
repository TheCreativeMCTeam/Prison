package org.creativemc.prison.ranks;

import lombok.Getter;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.creativemc.prison.PlayerCache;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.remain.CompSound;

import java.util.HashMap;
import java.util.Map;

public abstract class Rank {

    // Ranks are stored by name, this is registered automatically
    // when you call a static method from this call.
    //
    // The reason why we are storing them is the getByName method below
    private static final Map<String, Rank> byName = new HashMap<>();

    public static final Rank PRISONER = new RankPrisoner();
    public static final Rank ADMIN = new RankAdmin();
    public static final Rank MOD = new RankRandom();


    @Getter
    private final String name;

    @Getter
    private final ChatColor color;

    protected Rank(final String name, final ChatColor color) {
        this.name = name;
        this.color = color;

        byName.put(name, this);
    }

    public Rank getNext() {
        return null;
    }

    public boolean upgradeToNextRank(final Player player) {
        return upgradeToNextRank(player, false);
    }

    // Return false if we could not upgrade the player to the next rank
    // Otherwise return true
    // This also sets the next rank automatically in the player cache file (data.db)
    public boolean upgradeToNextRank(final Player player, final boolean force) {
        final Rank nextRank = getNext();

        if (nextRank == null)
            return false;

        final PlayerCache cache = PlayerCache.getCache(player);

        if (canUpgrade(player, cache, nextRank) || force) {

            // Set his rank in cache and save the data.db file
            cache.setRank(nextRank);

            // Call a protected method you can override to do additional stuff when the player ranks up
            onUpgrade(player, nextRank);

            CompSound.NOTE_PLING.play(player);
            Common.tellNoPrefix(player, "&B&LLEVEL UP! &ACongratulations &7your rank has been leveled up!");
            return true;
        }


        return false;
    }

    protected boolean canUpgrade(final Player player, final PlayerCache cache, final Rank next) {
        return false;
    }

    protected void onUpgrade(final Player player, final Rank next) {
    }

    public static final Rank getFirstRank() {
        return PRISONER;
    }

    public static final Rank getByName(final String name) {
        return byName.get(name);
    }
}
