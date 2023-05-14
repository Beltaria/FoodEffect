package me.bluedyaishela.foodeffect;

import jdk.jfr.internal.tool.Main;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ItemMergeEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.io.File;

public final class FoodEffect extends JavaPlugin implements Listener {
    private static Main plugin;

    public FileConfiguration config;

    public File cfile;
    @Override
    public void onEnable() {
        // Plugin startup logic
        // Fichier de configuration
        this.cfile = new File(getDataFolder(), "config.yml");
        if (!this.cfile.exists()) {
            getLogger().info("Le fichier config.yml n'a pas été trouvé, création en cours...");
            saveDefaultConfig();
        } else {
            getLogger().info("Le fichier de configuration a été trouvé, chargement en cours...");
        }
        //
        this.config = getConfig();
        getServer().getPluginManager().registerEvents(this, this);

        // Message après démarrage
        System.out.println("FoodEffect a démarré avec succès !");
    }

    public void onPayerConsumeSpeed(PlayerItemConsumeEvent event) {
        ItemStack item = event.getItem();
        if (item.getType() == Material.SPECKLED_MELON && item.hasItemMeta()) {
            ItemMeta meta = item.getItemMeta();
            if (meta.hasLore() && meta.getLore().contains("Speed 2")) {
                Player player = event.getPlayer();
                player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 20 * 10, 1));
            }
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("FoodEffect s'est arrêté avec succès !");
    }
}
