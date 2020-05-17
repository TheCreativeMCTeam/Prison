package org.creativemc.prison.commands;

import org.creativemc.prison.menus.PrisonMenu;
import org.mineacademy.fo.command.SimpleCommand;


public class HomesManagerCommand extends SimpleCommand {

    public HomesManagerCommand() {
        super("homes|home|h");
    }

    @Override
    protected void onCommand() {
        checkConsole();
        new PrisonMenu().displayTo(getPlayer());
    }
}
