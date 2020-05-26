package org.creativemc.prison.commands;

import org.bukkit.entity.Player;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.FileUtil;
import org.mineacademy.fo.TimeUtil;
import org.mineacademy.fo.command.SimpleCommand;
import org.mineacademy.fo.plugin.SimplePlugin;
import org.mineacademy.fo.remain.Remain;

public class ReloadPrison extends SimpleCommand {


    public ReloadPrison() {
        super("update");
        setPermission("creative.reload.prison");
    }

    @Override
    protected void onCommand() {
        checkConsole();
        final Player player = getPlayer();


        try {
            SimplePlugin.getInstance().reload();
            Remain.sendTitle(player, 20, 30, 20, "&AUpdate Success!",
                    "");
        } catch (final Throwable throwable) {

            FileUtil.write("errors/" + "[" + TimeUtil.getFormattedDate() + "]" + ".log",
                    "[" + TimeUtil.getFormattedDate() + "]" + " " + throwable);
            throwable.printStackTrace();

            Common.tellNoPrefix(player, "&CAn error file has been &Ccreated &Ainside plugins/Prison/errors folder");
            Remain.sendTitle(player, 20, 30, 20, "&CUpdate Failed!",
                    "");

        }
    }
}



