package net.uczony;

import net.uczony.listeners.CommandPreProcessListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class CommandsPlugin extends JavaPlugin
{
    private static CommandsPlugin inst;

    public void onEnable() {
        (CommandsPlugin.inst = this).saveDefaultConfig();
        Bukkit.getPluginManager().registerEvents(new CommandPreProcessListener(), this);
    }

    public static CommandsPlugin getInst() {
        return CommandsPlugin.inst;
    }
}
