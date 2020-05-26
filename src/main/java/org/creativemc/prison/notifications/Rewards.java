package org.creativemc.prison.notifications;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.model.SimpleComponent;

public class Rewards implements Listener {

    @EventHandler
    public void onJoin(final PlayerJoinEvent event) {

        final Player target = event.getPlayer();

        SimpleComponent.of(Common.getTellPrefix() + " " + "&FClaim your &Breward &Fto earn experience!")
                .onHover("&BClick to claim reward!").onClickRunCmd("/rewards")
                .send(target);

    }
}
