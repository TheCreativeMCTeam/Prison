package org.creativemc.prison.commands;

import org.bukkit.entity.Player;
import org.creativemc.prison.menus.PrisonMenu;
import org.mineacademy.fo.command.SimpleCommand;


public class PrisonMenuCommand extends SimpleCommand {
    public PrisonMenuCommand() {
        super("prison");
    }

    @Override
    protected void onCommand() {
        checkConsole();
        final Player player = getPlayer();
        new PrisonMenu().displayTo(player);
    }
}
