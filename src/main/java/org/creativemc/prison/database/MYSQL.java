package org.creativemc.prison.database;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.creativemc.prison.PlayerCache;
import org.creativemc.prison.ranks.Rank;
import org.mineacademy.fo.collection.SerializedMap;
import org.mineacademy.fo.database.SimpleFlatDatabase;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MYSQL extends SimpleFlatDatabase<PlayerCache> {

    @Getter
    private static final MYSQL instance = new MYSQL();

    @Override
    protected void onLoad(final SerializedMap map, final PlayerCache data) {

        final Rank rank = map.get("Rank", Rank.class);

        if (data.getRank() != null) {
            data.setRank(rank);
        }

    }

    @Override
    protected SerializedMap onSave(final PlayerCache data) {

        final SerializedMap map = new SerializedMap();

        if (data.getRank() != null)
            map.put("Rank", data.getRank());

        return map;
    }
}
