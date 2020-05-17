package org.creativemc.prison.setup;

import org.bukkit.entity.Player;
import org.mineacademy.fo.command.SimpleCommandGroup;
import org.mineacademy.fo.command.SimpleSubCommand;
import org.mineacademy.fo.remain.CompSound;
import org.mineacademy.fo.remain.Remain;

public class PrisonMineCreateCommand extends SimpleSubCommand {

    protected PrisonMineCreateCommand(final SimpleCommandGroup parent) {
        super(parent, "create");
        setMinArguments(1);
        setUsage("<name>");
    }

    @Override
    protected void onCommand() {
        checkConsole();

        if (args.length == 1) {
            String name;

            final Player player = getPlayer();

            Remain.sendTitle(player, 20, 50, 20, "&E&LMine Created", "");
            CompSound.LEVEL_UP.play(player);
        }
    }
}
