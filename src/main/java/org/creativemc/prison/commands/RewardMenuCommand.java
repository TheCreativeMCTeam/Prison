package org.creativemc.prison.commands;

import org.creativemc.prison.menus.RewardsMenu;
import org.mineacademy.fo.command.SimpleCommand;


public class RewardMenuCommand extends SimpleCommand {

    public RewardMenuCommand() {
        super("rewards");
    }

    @Override
    protected void onCommand() {
        checkConsole();
        new RewardsMenu().displayTo(getPlayer());
    }
}
