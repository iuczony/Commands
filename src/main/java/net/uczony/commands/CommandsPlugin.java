package net.uczony.commands;

import net.uczony.commands.listener.CommandPreProcessListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * made by uczony
 *
 * @since 14/11/2018
 **/

public final class CommandsPlugin extends JavaPlugin {

    private static CommandsPlugin instance;

    public void onEnable() {
        this.saveDefaultConfig();
        Bukkit.getPluginManager().registerEvents(new CommandPreProcessListener(), this);
    }

    public static CommandsPlugin getInstance() {
        return instance;
    }
}
