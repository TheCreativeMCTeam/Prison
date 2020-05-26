package org.creativemc.prison;

import lombok.Getter;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.creativemc.prison.ranks.Rank;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.settings.YamlSectionConfig;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Getter
public class PlayerCache extends YamlSectionConfig {

    private static final Map<UUID, PlayerCache> cacheMap = new HashMap<>();


    private ChatColor color;
    private int level = 1;
    private Rank rank;

    protected PlayerCache(final String uuid) {

        // This will prepend this cache with the players unique id just like you use pathPrefix in SimpleSettings
        super(uuid);

        // Load our player cache from the disk however do not use any default file
        // from our source code
        loadConfiguration(null, "data.db");
    }

    public static PlayerCache getCache(final UUID uuid) {
        return null;
    }

    @Override
    protected void onLoadFinish() {
        if (isSet("Class")) {
            final String className = getString("Class");

        }

        if (isSet("Color"))
            color = getEnum("Color", ChatColor.class);

        if (isSet("Level"))
            level = getInteger("Level");

        if (isSet("Rank"))
            rank = Rank.getByName(getString("Rank"));
    }


    public void setColor(final ChatColor color) {
        this.color = color;

        save("Color", color.name());
    }

    public void setLevel(final int level) {
        this.level = level;

        save("Level", level);
    }

    public Rank getRank() {
        return Common.getOrDefault(rank, Rank.getFirstRank());
    }

    public void setRank(final Rank rank) {
        this.rank = rank;

        save("Rank", rank.getName());
    }

    public static PlayerCache getCache(final Player player, final UUID uuid) {
        PlayerCache cache = cacheMap.get(uuid);

        if (cache == null) {
            cache = new PlayerCache(player.toString());

            cacheMap.put(uuid, cache);
        }

        return cache;
    }
}
