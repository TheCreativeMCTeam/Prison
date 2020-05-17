package org.creativemc.prison.setup;

import org.mineacademy.fo.command.SimpleCommandGroup;

public class PrisonSetupCommandGroup extends SimpleCommandGroup {

    @Override
    protected void registerSubcommands() {
        registerSubcommand(new PrisonSetupMineSet(this));
        registerSubcommand(new PrisonMineCreateCommand(this));
    }

    @Override
    protected String getCredits() {
        return "&CPrison is currently under development. Report bugs on the forums!";
    }
}
