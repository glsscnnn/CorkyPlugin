package me.eeayor.CorkyPlugin.Events;

import org.bukkit.entity.*;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockEvent;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.inventory.FurnaceSmeltEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.block.EnchantingTable;
import org.bukkit.inventory.ItemStack;

public class EventsListener implements Listener {

    @EventHandler
    public void veryHardMobs(CreatureSpawnEvent event) {

        // Create very hard Creeper
        if(event.getEntityType() == EntityType.CREEPER) {
            Creeper creeper = (Creeper) event.getEntity();

            // Creeper on spawn is charged
            creeper.setPowered(true);
        }

        // Create very hard Zombie
        if(event.getEntityType() == EntityType.ZOMBIE) {
            Zombie zombie = (Zombie) event.getEntity();

            zombie.getEquipment().setHelmet(new ItemStack(Material.DIAMOND_HELMET));
            zombie.getEquipment().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
            zombie.getEquipment().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS));
            zombie.getEquipment().setBoots(new ItemStack(Material.DIAMOND_BOOTS));
        }

        // Create very hard Skeleton
        if(event.getEntityType() == EntityType.SKELETON) {
            Skeleton skeleton = (Skeleton) event.getEntity();

            skeleton.getEquipment().setHelmet(new ItemStack(Material.DIAMOND_HELMET));
            skeleton.getEquipment().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
            skeleton.getEquipment().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS));
            skeleton.getEquipment().setBoots(new ItemStack(Material.DIAMOND_BOOTS));

            ItemStack punchBow = new ItemStack(Material.BOW);
            punchBow.addEnchantment(Enchantment.ARROW_KNOCKBACK, 2);
            punchBow.addEnchantment(Enchantment.ARROW_DAMAGE, 5);

            skeleton.getEquipment().setItemInMainHand(punchBow);
        }

        // Create the very hard Zombie Piglin
        if(event.getEntityType() == EntityType.ZOMBIFIED_PIGLIN) {
            PigZombie zpiglin = (PigZombie) event.getEntity();

            zpiglin.getEquipment().setHelmet(new ItemStack(Material.NETHERITE_HELMET));
            zpiglin.getEquipment().setChestplate(new ItemStack(Material.NETHERITE_CHESTPLATE));
            zpiglin.getEquipment().setLeggings(new ItemStack(Material.NETHERITE_LEGGINGS));
            zpiglin.getEquipment().setBoots(new ItemStack(Material.NETHERITE_BOOTS));
        }

        // Create the very hard Piglin
        if(event.getEntityType() == EntityType.PIGLIN) {
            Piglin piglin = (Piglin) event.getEntity();

            piglin.getEquipment().setHelmet(new ItemStack(Material.DIAMOND_HELMET));
            piglin.getEquipment().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
            piglin.getEquipment().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS));
            piglin.getEquipment().setBoots(new ItemStack(Material.DIAMOND_BOOTS));

            ItemStack gamerSword = new ItemStack(Material.NETHERITE_SWORD);
            gamerSword.addEnchantment(Enchantment.DAMAGE_ALL, 5);

            piglin.getEquipment().setItemInMainHand(gamerSword);
        }

    }


}
