package me.eeayor.CorkyPlugin;

// Deps
import me.eeayor.CorkyPlugin.Events.EventsListener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class CorkyPlugin extends JavaPlugin {
    public void onEnable() {

        // Console Log
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "\n\nCorky has started!\n\n");
        getServer().getPluginManager().registerEvents(new EventsListener(), this);

        // Crafting Recipe
        ItemStack item = new ItemStack(Material.END_CRYSTAL);
        NamespacedKey key = new NamespacedKey(this, "end_crystal_op");
        ShapedRecipe recipe = new ShapedRecipe(key, item);
        recipe.shape("E");
        recipe.setIngredient('E', Material.EMERALD);
        Bukkit.addRecipe(recipe);

    }

    public void onDisable() {
        // Console Log
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "\n\nCorky has been stopped!\n\n");
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // kit command, technically speaking this would be in another package
        if(command.getName().equals("kit")){
            if (sender instanceof Player) {
                Player player = (Player) sender;

                // Kit items
                ItemStack sword = new ItemStack(Material.STONE_SWORD);
                ItemStack pick = new ItemStack(Material.STONE_PICKAXE);
                ItemStack helmet = new ItemStack(Material.LEATHER_HELMET);
                ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
                ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS);
                ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);

                // Give player items
                player.getInventory().addItem(sword, pick, helmet, chestplate, leggings, boots);

                // Message player
                player.sendMessage("Here you go!");
            }

            else {
                // If console not player
                System.out.println("You must be player!");
            }
        }
        // Fuck java
        return false;
    }
}
