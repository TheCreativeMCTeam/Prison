package org.creativemc.prison.setup;

import org.bukkit.entity.Player;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.command.SimpleCommandGroup;
import org.mineacademy.fo.command.SimpleSubCommand;
import org.mineacademy.fo.remain.CompSound;

public class PrisonSetupMineSet extends SimpleSubCommand {

    protected PrisonSetupMineSet(final SimpleCommandGroup parent) {
        super(parent, "setmine");
    }

    @Override
    protected void onCommand() {
        checkConsole();
        final Player player = getPlayer();

        final int X = player.getLocation().getBlockX();
        final int Y = player.getLocation().getBlockY();
        final int Z = player.getLocation().getBlockZ();

        Common.tellNoPrefix(player, "&8[&C!&8] &APrison mine location has been set at" + " " + "&b" +
                X + "&b," + " " + Y + "&b," + " " + Z);
        CompSound.NOTE_PLING.play(player);
    }
}
