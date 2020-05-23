package org.creativemc.prison;

import me.arcaniax.hdb.api.DatabaseLoadEvent;
import me.arcaniax.hdb.api.HeadDatabaseAPI;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.creativemc.prison.commands.AdminRankCommand;
import org.creativemc.prison.commands.DiamondSwordArmourStand;
import org.creativemc.prison.commands.PrisonMenuCommand;
import org.creativemc.prison.events.PlayerListener;
import org.creativemc.prison.events.RankPrefix;
import org.creativemc.prison.notifications.CustomTAB;
import org.creativemc.prison.notifications.PrisonScoreboard;
import org.creativemc.prison.setup.PrisonSetupCommandGroup;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.plugin.SimplePlugin;

public final class Prison extends SimplePlugin implements Listener {


    @Override
    protected void onPluginStart() {

        Common.log("&m" + " " + Common.consoleLineSmooth());
        Common.log(" ");
        Common.log(getName() + " " + "has been enabled!");
        Common.log(" ");
        Common.log("&m" + " " + Common.consoleLineSmooth());


        Common.ADD_LOG_PREFIX = true;
        Common.ADD_TELL_PREFIX = true;

        /*
        Commands and Commands groups has been registered below.
        Events are also registered below as well.
         */

        registerEvents(new PrisonScoreboard());
        registerCommand(new PrisonMenuCommand());
        registerCommand(new DiamondSwordArmourStand());
        registerEvents(new CustomTAB());
        registerEvents(new RankPrefix());
        registerCommand(new AdminRankCommand());
        registerEvents(new PlayerListener());
        registerCommands("setup", new PrisonSetupCommandGroup());

    }

    @EventHandler
    public void onDatabaseLoad(final DatabaseLoadEvent e) {
        final HeadDatabaseAPI api = new HeadDatabaseAPI();
        try {
            final ItemStack item = api.getItemHead("7129");
            getLogger().info(api.getItemID(item));
        } catch (final NullPointerException nullpointer) {
            getLogger().info("could not find the head you were looking for");
        }
    }

}
