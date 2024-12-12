package gg.quartzdev.mc.taskcrafter.gui;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionType;

import java.util.ArrayList;
import java.util.List;

public class ExchangeInventory extends ExchangeInventoryHolder
{
    public ExchangeInventory(Player player) {
        super();
        String title = "Collection List";
        this.createInv(27, title);
        fillInventory();
        player.openInventory(this.getInventory());
    }

    @Override
    public void onClick(InventoryClickEvent event)
    {
        event.setCancelled(true);
    }

    public void fillInventory()
    {

        String durabilityWarning = "<italic><gold>Note: Must be full durability & no enchants!";

        // Tier 1 (top row)
        final List<ItemStack> tier1 = List.of(
                item(Material.COAL, 16, 1, null, null),
                item(Material.IRON_INGOT, 16, 1, null, null),
                item(Material.LAPIS_LAZULI, 32, 1, null, null),
                item(Material.GLISTERING_MELON_SLICE, 9, 1, null, null),
                item(Material.GOLDEN_APPLE, 2, 1, null, null),
                item(Material.PUMPKIN_PIE, 1, 1, null, null),
                item(Material.MUSHROOM_STEW, 1, 1, null, null),
                item(Material.SWEET_BERRIES, 32, 1, null, null),
                item(Material.SNOW_BLOCK, 64, 1, null, null)
        );

        // Tier 2 (middle row)
        final List<ItemStack> tier2 = List.of(
                item(Material.ENCHANTING_TABLE, 1, 2, null, null),
                item(Material.SPYGLASS, 1, 2, null, null),
                item(Material.CRYING_OBSIDIAN, 1, 2, null, null),
                item(Material.AXOLOTL_BUCKET, 1, 2, null, null),
                item(Material.BLUE_ICE, 1, 2, null, null),
                item(Material.FIREWORK_ROCKET, 32, 2, null, null),
                item(Material.BREEZE_ROD, 3, 2, null, null),
                item(Material.BLAZE_ROD, 3, 2, null, null),
                item(Material.CAKE, 1, 2, null, null)
        );



        // Tier 3 (bottom row)
        final List<ItemStack> tier3 = List.of(
                potion( 1, 3, null, null, false, PotionType.STRONG_REGENERATION),
                potion( 1, 3, null, null, true, PotionType.SLOW_FALLING),
                item(Material.DIAMOND_HOE, 1, 3, null, durabilityWarning),
                item(Material.TRIDENT, 1, 3, null, durabilityWarning),
                item(Material.ANCIENT_DEBRIS, 1, 3, null, null),
                item(Material.RECOVERY_COMPASS, 1, 3, null, null),
                item(Material.SPONGE, 1, 3, null, null),
                item(Material.MUSIC_DISC_CAT, 1, 3, "Any Music Disc", null),
                item(Material.NETHERITE_UPGRADE_SMITHING_TEMPLATE, 1, 3, "Any Smithing Template", null)
        );
        for(ItemStack itemStack : tier1)
        {
            inventory.addItem(itemStack);
        }
        for(ItemStack itemStack : tier2)
        {
            inventory.addItem(itemStack);
        }
        for(ItemStack itemStack : tier3)
        {
            inventory.addItem(itemStack);
        }
    }

    public ItemStack item(Material material, int amount, int tier, String name, String lore){
        final ItemStack item = new ItemStack(material, amount);
        final ItemMeta meta = item.getItemMeta();

//        Display Name
        if(name != null && name.isEmpty()) meta.displayName(setText(name));

//        Lore
        final List<Component> loreList = new ArrayList<>();
        loreList.add(setText("<green>Tier: " + tier));
        loreList.add(setText("Don't forget to exchange for an ornament!"));
        if(lore != null && !lore.isEmpty()) {
            loreList.add(setText(" "));
            loreList.add(setText(lore));
        }
        meta.lore(loreList);

//        Hide Flags
        for(ItemFlag flag : ItemFlag.values()){
            meta.addItemFlags(flag);
        }

//        Update and Return Item
        item.setItemMeta(meta);
        return item;
    }

    public ItemStack potion(int amount, int tier, String name, String lore, boolean splash, PotionType type){
        final ItemStack item = new ItemStack(splash ? Material.SPLASH_POTION : Material.POTION, amount);
        final PotionMeta meta = (PotionMeta) item.getItemMeta();

        meta.setBasePotionType(type);

//        Display Name
        if(name != null && name.isEmpty()) meta.displayName(setText(name));

//        Lore
        final List<Component> loreList = new ArrayList<>();
        loreList.add(setText("<green>Tier: 3"));
        loreList.add(setText("Don't forget to exchange for an ornament!"));
        if(lore != null && !lore.isEmpty()) {
            loreList.add(setText(" "));
            loreList.add(setText(lore));
        }
        meta.lore(loreList);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

//        Update and Return Item
        item.setItemMeta(meta);
        return item;
    }


    public Component setText(String name){
        return MiniMessage.miniMessage().deserialize(name).decoration(TextDecoration.ITALIC, false);
    }


}
