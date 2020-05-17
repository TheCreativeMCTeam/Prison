package org.creativemc.prison.hotbar;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.creativemc.prison.menus.PrisonMenu;
import org.mineacademy.fo.menu.model.ItemCreator;
import org.mineacademy.fo.menu.tool.Tool;
import org.mineacademy.fo.remain.CompMaterial;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PrisonMenuItem extends Tool {

    @Getter
    private static final Tool instance = new PrisonMenuItem();

    @Override
    public ItemStack getItem() {
        return ItemCreator.of(CompMaterial.NETHER_STAR, "&APrison menu &7(Right-Click)",
                "&7Opens your prison menu in", "&7you can vie and manage", "&7your homes, stats, recipes etc"
                , "", "&EClick to open!")
                .build().make();
    }

    @Override
    protected void onBlockClick(final PlayerInteractEvent event) {

        final Player player = event.getPlayer();

        if (event.getAction() == Action.RIGHT_CLICK_AIR && event.getAction() == Action.RIGHT_CLICK_BLOCK
                && event.getAction() == Action.LEFT_CLICK_AIR && event.getAction() == Action.LEFT_CLICK_BLOCK)

            return;

        new PrisonMenu().displayTo(player);
    }

    @Override
    protected boolean ignoreCancelled() {
        return false;
    }
}
