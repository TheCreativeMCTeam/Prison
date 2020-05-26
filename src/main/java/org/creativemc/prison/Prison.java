package org.creativemc.prison;

import me.arcaniax.hdb.api.DatabaseLoadEvent;
import me.arcaniax.hdb.api.HeadDatabaseAPI;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.creativemc.prison.commands.*;
import org.creativemc.prison.database.MYSQL;
import org.creativemc.prison.database.MySqlListener;
import org.creativemc.prison.events.PlayerListener;
import org.creativemc.prison.events.RankPrefix;
import org.creativemc.prison.notifications.CustomTAB;
import org.creativemc.prison.notifications.PrisonScoreboard;
import org.creativemc.prison.notifications.Rewards;
import org.creativemc.prison.settings.Settings;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.debug.LagCatcher;
import org.mineacademy.fo.plugin.SimplePlugin;
import org.mineacademy.fo.settings.YamlStaticConfig;

import java.util.Arrays;
import java.util.List;

public final class Prison extends SimplePlugin implements Listener {


    @Override
    protected void onPluginStart() {

        /*
        Connection between database has been registered below.
         */

        LagCatcher.start("database");
        MYSQL.getInstance().connect("localhost", 3306, "prison_data",
                "root", "root", "prison_stats");
        LagCatcher.end("database", 0, "MYSQL has been sucessfully connected!");

        Common.log("&m" + " " + Common.consoleLineSmooth());
        Common.log(" ");
        Common.log(getName() + " " + "has been enabled!");
        Common.log(" ");
        Common.log("&m" + " " + Common.consoleLineSmooth());


        Common.ADD_LOG_PREFIX = true;
        Common.ADD_TELL_PREFIX = true;

        /*
        Commands and Commands groups has been registered below.
         */
        registerCommand(new ReloadPrison());
        registerCommand(new PrisonMenuCommand());
        registerCommand(new DiamondSwordArmourStand());
        registerCommand(new AdminRankCommand());
        registerCommand(new RewardMenuCommand());


        /*
        Events has been registered below.
         */
        registerEvents(new PrisonScoreboard());
        registerEvents(new CustomTAB());
        registerEvents(new RankPrefix());
        registerEvents(new PlayerListener());
        registerEvents(new Rewards());
        registerEvents(new MySqlListener());
    }

    /*
    HeadDatabase Plugin hooking has been done below.
     */

    @EventHandler
    public void onDatabaseLoad(final DatabaseLoadEvent e) {
        final HeadDatabaseAPI api = new HeadDatabaseAPI();
        try {
            Common.log("HeadDatabase plugin has been hooked successfully!");
        } catch (final NullPointerException nullpointer) {
            Common.log("Failed to hook into HeadDatabase plugin!");
        }
    }

    /*
    Settings files has been registered below for this plugin. You can always add more by
    putting a comma after Settings.class then your new settings file name.
     */

    @Override
    public List<Class<? extends YamlStaticConfig>> getSettings() {
        return Arrays.asList(Settings.class);
    }
}
