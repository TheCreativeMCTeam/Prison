package org.creativemc.prison.commands;

import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.util.EulerAngle;
import org.mineacademy.fo.command.SimpleCommand;
import org.mineacademy.fo.menu.model.ItemCreator;
import org.mineacademy.fo.remain.CompMaterial;


public class DiamondSwordArmourStand extends SimpleCommand {

    public DiamondSwordArmourStand() {
        super("diy");
    }

    @Override
    protected void onCommand() {
        checkConsole();

        final Player player = getPlayer();
        final ArmorStand as = player.getWorld().spawn(player.getLocation(), ArmorStand.class);
        as.setItemInHand(ItemCreator.of(CompMaterial.DIAMOND_SWORD, "", "").build().make());
        as.setVisible(false);
        as.setArms(false);
        as.setGravity(false);
        as.setRightArmPose(new EulerAngle(002f, 004f, 003f));
    }
}
