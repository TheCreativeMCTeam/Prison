package org.creativemc.prison.settings;

import org.mineacademy.fo.settings.SimpleSettings;

public class Settings extends SimpleSettings {

    @Override
    protected int getConfigVersion() {
        return 1;
    }

    public static String REWARDS_TITLE;


    private static void init() {
        REWARDS_TITLE = getString("Rewards.Title");
    }
}
