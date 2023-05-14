package me.bluedyaishela.foodeffect;

import org.bukkit.plugin.java.JavaPlugin;

public final class FoodEffect extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("FoodEffect a démarré avec succès !");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("FoodEffect s'est arrêté avec succès !");
    }
}
