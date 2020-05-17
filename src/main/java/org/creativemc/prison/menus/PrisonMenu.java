package org.creativemc.prison.menus;

import me.arcaniax.hdb.api.HeadDatabaseAPI;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.creativemc.prison.tools.HardendDiamondPick;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.menu.Menu;
import org.mineacademy.fo.menu.MenuTools;
import org.mineacademy.fo.menu.button.Button;
import org.mineacademy.fo.menu.button.ButtonMenu;
import org.mineacademy.fo.menu.button.ButtonReturnBack;
import org.mineacademy.fo.menu.model.ItemCreator;
import org.mineacademy.fo.remain.CompMaterial;
import org.mineacademy.fo.remain.CompSound;

import java.util.ArrayList;
import java.util.Collections;

public class PrisonMenu extends Menu {

    private final Button ViewHomes, Storage, Tools, Warps, Skiils,
            ShadowyAuction;

    public PrisonMenu() {
        setSize(45);
        setTitle("&8Prison Menu");

        ShadowyAuction = new Button() {
            @Override
            public void onClickedInMenu(final Player player, final Menu menu, final ClickType click) {

            }

            @Override
            public ItemStack getItem() {
                final HeadDatabaseAPI api = new HeadDatabaseAPI();


                final ItemStack ShadowyAuction = new ItemStack(api.getItemHead("36261"));
                final ItemMeta meta = ShadowyAuction.getItemMeta();
                meta.setDisplayName(Common.colorize("&AShadowy Auction Calendar"));
                final ArrayList<String> lore = new ArrayList();

                lore.add(Common.colorize("&7Jump in front of &BThe Guy"));
                lore.add(Common.colorize("&7to get in the &CShadowy Auction"));
                lore.add(Common.colorize(" "));
                lore.add(Common.colorize("&8Requires &B(Mega Mine Unlocked)"));
                lore.add(Common.colorize(" "));
                lore.add(Common.colorize("&8Happens on:"));
                lore.add(Common.colorize("&FEvery Saturday"));
                lore.add(Common.colorize(" "));
                lore.add(Common.colorize("&EClick to view!"));


                meta.setLore(lore);
                ShadowyAuction.setItemMeta(meta);
                return ShadowyAuction;
            }
        };

        Skiils = new Button() {
            @Override
            public void onClickedInMenu(final Player player, final Menu menu, final ClickType click) {
                new PlayerSkills().displayTo(player);
            }

            @Override
            public ItemStack getItem() {

                final Player player = getViewer();
                final String name = player.getName();
                final HeadDatabaseAPI api = new HeadDatabaseAPI();


                final ItemStack Skiils = new ItemStack(api.getItemHead("3025"));
                final ItemMeta meta = Skiils.getItemMeta();
                meta.setDisplayName(Common.colorize("&A" + name + " " + "&Askills"));
                final ArrayList<String> lore = new ArrayList();

                lore.add(Common.colorize("&7View your current skills inside"));
                lore.add(Common.colorize("&7prison like &BBlocks Mined &7etc!"));
                lore.add(Common.colorize(" "));
                lore.add(Common.colorize("&BBlocks Mined: &772"));
                lore.add(Common.colorize("&EMines Unlocked: &7(&F2/3&7)"));
                lore.add(Common.colorize("&BQuests Completed: &F2"));
                lore.add(Common.colorize(" "));
                lore.add(Common.colorize("&EClick to view!"));


                meta.setLore(lore);
                Skiils.setItemMeta(meta);


                return Skiils;
            }
        };

        Warps = new Button() {
            @Override
            public void onClickedInMenu(final Player player, final Menu menu, final ClickType click) {
                new WarpsMenu().displayTo(player);
            }

            @Override
            public ItemStack getItem() {

                final HeadDatabaseAPI api = new HeadDatabaseAPI();

                final ItemStack Warps = new ItemStack(api.getItemHead("566"));
                final ItemMeta meta = Warps.getItemMeta();
                meta.setDisplayName(Common.colorize("&AWarps"));
                final ArrayList<String> lore = new ArrayList();

                lore.add(Common.colorize("&7Teleport to different places by"));
                lore.add(Common.colorize("&7finding maps for that location!"));
                lore.add(Common.colorize(" "));
                lore.add(Common.colorize("&8Unlocked: &7(&F2/12&7)"));
                lore.add(Common.colorize(" "));
                lore.add(Common.colorize("&EClick to browse!"));


                meta.setLore(lore);
                Warps.setItemMeta(meta);

                return Warps;
            }
        };

        Tools = new ButtonMenu(new ProToolsMenu(), CompMaterial.DIAMOND_PICKAXE,
                "&ATools Manager", "&7Use special tools to help", "&7building your home further!",
                "", "&EClick to open!");

        Storage = new Button() {
            @Override
            public void onClickedInMenu(final Player player, final Menu menu, final ClickType click) {
                new StorageMenu().displayTo(player);
            }

            @Override
            public ItemStack getItem() {
                return ItemCreator.of(CompMaterial.ENDER_CHEST, "&BItems Keeper",
                        "&7Store your items inside", "&7this portable ender chest!", "", "&8Slots Unlocked: &7(&F20/54&7)", "",
                        "&EClick to open!").build().make();
            }
        };


        ViewHomes = new Button() {
            @Override
            public void onClickedInMenu(final Player player, final Menu menu, final ClickType click) {
                new ViewHomesMenu().displayTo(player);
            }

            @Override
            public ItemStack getItem() {
                return ItemCreator.of(CompMaterial.ANVIL, "&AHomes Viewer",
                        "&7View your created homes", "&7spectate them and edit them!", "",
                        "&EClick to view!").build().make();
            }
        };
    }

    @Override
    public ItemStack getItemAt(final int slot) {

        if (slot == 4)
            return Skiils.getItem();

        if (slot == 10)
            return ViewHomes.getItem();

        if (slot == 11)
            return Tools.getItem();

        if (slot == 12)
            return Warps.getItem();

        if (slot == 13)
            return Storage.getItem();

        if (slot == 14)
            return ShadowyAuction.getItem();

        return ItemCreator.of(CompMaterial.BLACK_STAINED_GLASS_PANE,
                " ")
                .build().make();
    }

    class ViewHomesMenu extends Menu {

        public ViewHomesMenu() {
            super(PrisonMenu.this);
            setSize(45);
            setTitle("&8View Homes");
            ButtonReturnBack.setTitle("&AGo Back");
            ButtonReturnBack.setLore(Collections.singletonList("&7to Prison Menu"));
            ButtonReturnBack.setMaterial(CompMaterial.ARROW);

        }

        @Override
        public ItemStack getItemAt(final int slot) {
            return ItemCreator.of(CompMaterial.BLACK_STAINED_GLASS_PANE, " ")
                    .build().make();
        }
    }

    class StorageMenu extends Menu {
        public StorageMenu() {
            super(PrisonMenu.this);
            setSize(54);
            setTitle("&8Virtual Storage");
            ButtonReturnBack.setTitle("&AGo Back");
            ButtonReturnBack.setLore(Collections.singletonList("&7to Prison Menu"));
            ButtonReturnBack.setMaterial(CompMaterial.ARROW);
        }
    }

    class ProToolsMenu extends MenuTools {

        public ProToolsMenu() {
            super(PrisonMenu.this);
            setSize(9);
            setTitle("&8Pro Tools Menu");
            ButtonReturnBack.setTitle("&AGo Back");
            ButtonReturnBack.setLore(Collections.singletonList("&7to Prison Menu"));
            ButtonReturnBack.setMaterial(CompMaterial.ARROW);
        }

        @Override
        protected Object[] compileTools() {
            return new Object[]{
                    HardendDiamondPick.getInstance()
            };
        }
    }

    class WarpsMenu extends Menu {

        private final Button HomeWarp, Marketplace;

        public WarpsMenu() {
            super(PrisonMenu.this);
            setSize(54);
            setTitle("&8Prison Warps");
            ButtonReturnBack.setTitle("&AGo Back");
            ButtonReturnBack.setLore(Collections.singletonList("&7to Prison Menu"));
            ButtonReturnBack.setMaterial(CompMaterial.ARROW);


            Marketplace = new Button() {
                @Override
                public void onClickedInMenu(final Player player, final Menu menu, final ClickType click) {
                    player.teleport(new Location(player.getWorld(), 32, 114, 56));
                    CompSound.NOTE_PLING.play(player);
                }

                @Override
                public ItemStack getItem() {

                    final HeadDatabaseAPI api = new HeadDatabaseAPI();

                    final ItemStack Marketplace = new ItemStack(api.getItemHead("33098"));
                    final ItemMeta meta = Marketplace.getItemMeta();
                    meta.setDisplayName(Common.colorize("&EMarketplace"));
                    final ArrayList<String> lore = new ArrayList();

                    lore.add(Common.colorize("&7Purchase items, weapons and food"));
                    lore.add(Common.colorize("&7or sell anything for good price!"));
                    lore.add(Common.colorize(" "));
                    lore.add(Common.colorize("&EClick to warp!"));


                    meta.setLore(lore);
                    Marketplace.setItemMeta(meta);


                    return Marketplace;
                }
            };

            HomeWarp = new Button() {
                @Override
                public void onClickedInMenu(final Player player, final Menu menu, final ClickType click) {

                }

                @Override
                public ItemStack getItem() {

                    final HeadDatabaseAPI api = new HeadDatabaseAPI();

                    final ItemStack HomeWarp = new ItemStack(api.getItemHead("4449"));
                    final ItemMeta meta = HomeWarp.getItemMeta();
                    meta.setDisplayName(Common.colorize("&EHome Warp"));
                    final ArrayList<String> lore = new ArrayList();

                    lore.add(Common.colorize("&7Go back to your house"));
                    lore.add(Common.colorize("&7just in a click of second!"));
                    lore.add(Common.colorize(" "));
                    lore.add(Common.colorize("&EClick to warp!"));


                    meta.setLore(lore);
                    HomeWarp.setItemMeta(meta);

                    return HomeWarp;
                }
            };
        }

        @Override
        public ItemStack getItemAt(final int slot) {

            if (slot == 10)
                return HomeWarp.getItem();

            if (slot == 28)
                return Marketplace.getItem();


            return ItemCreator.of(CompMaterial.BLACK_STAINED_GLASS_PANE, " ")
                    .build().make();
        }
    }

    class PlayerSkills extends Menu {

        public PlayerSkills() {
            super(PrisonMenu.this);
            setSize(45);
            setTitle("&8Your Skills");
            ButtonReturnBack.setTitle("&AGo Back");
            ButtonReturnBack.setLore(Collections.singletonList("&7to Prison Menu"));
            ButtonReturnBack.setMaterial(CompMaterial.ARROW);
        }
    }

    class AuctionCalendar extends Menu {

        public AuctionCalendar() {
            super(PrisonMenu.this);
            setSize(45);
            setTitle("&8Shadowy Auction Calendar");
            ButtonReturnBack.setTitle("&AGo Back");
            ButtonReturnBack.setLore(Collections.singletonList("&7to Prison Menu"));
            ButtonReturnBack.setMaterial(CompMaterial.ARROW);
        }

    }
}


