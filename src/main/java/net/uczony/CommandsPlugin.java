package net.uczony;

import net.uczony.listeners.CommandPreProcessListener;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class CommandsPlugin extends JavaPlugin
{
    public static CommandsPlugin inst;

    public void onEnable() {
        (CommandsPlugin.inst = this).saveDefaultConfig();
        Bukkit.getPluginManager().registerEvents((Listener)new CommandPreProcessListener(), (Plugin)this);
    }

    public static CommandsPlugin getInst() {
        return CommandsPlugin.inst;
    }
}
