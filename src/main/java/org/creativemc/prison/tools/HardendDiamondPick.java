package org.creativemc.prison.tools;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.creativemc.prison.utils.TypePrison;
import org.mineacademy.fo.menu.model.ItemCreator;
import org.mineacademy.fo.menu.tool.Tool;
import org.mineacademy.fo.remain.CompMaterial;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class HardendDiamondPick extends Tool {


    @Getter
    private static final Tool instance = new HardendDiamondPick();

    @Override
    public ItemStack getItem() {
        return ItemCreator.of(CompMaterial.DIAMOND_PICKAXE, "&9Hardend Diamond Pickaxe",
                "&A85% &7chance of double drops", "&7when using this pickaxe!", "",
                "&7Require Materials:", "&F• &EDiamond Mine", "&F• &8(64x) &BChopped Logs", "",
                TypePrison.XPENCHANTING.name()).glow(true)
                .build().make();
    }


    @Override
    protected void onBlockClick(final PlayerInteractEvent event) {

    }
}
