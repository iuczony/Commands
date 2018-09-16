package net.uczony.listeners;

import net.uczony.CommandsPlugin;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class CommandPreProcessListener implements Listener
{
    public static String fixColor(final String t) {
        return t.replace(">>", "\u00BB");

    }

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent e) {
        for (final String s : CommandsPlugin.getInst().getConfig().getConfigurationSection("commands").getKeys(false)) {
            final String[] cmd = e.getMessage().split(" ");
            if (cmd[0].equals("/" + s)) {
                for (final String ss : CommandsPlugin.getInst().getConfig().getStringList("commands." + s)) {
                    e.getPlayer().sendMessage(CommandPreProcessListener.fixColor(ChatColor.translateAlternateColorCodes('&', ss)));
                }
                e.setCancelled(true);
            }
        }
    }
}
