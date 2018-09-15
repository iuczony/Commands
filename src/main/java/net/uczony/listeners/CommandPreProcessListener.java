package net.uczony.listeners;

import net.uczony.CommandsPlugin;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class CommandPreProcessListener implements Listener
{
    public String colors(final String str) {
        return str.replace(">>", "U+00BB"));
    }

    @EventHandler
    public void onCommand(final PlayerCommandPreprocessEvent e) {
        for (final String s : CommandsPlugin.getInst().getConfig().getConfigurationSection("commands").getKeys(false)) {
            final String[] cmd = e.getMessage().split(" ");
            if (cmd[0].equals("/" + s)) {
                for (final String ss : CommandsPlugin.getInst().getConfig().getStringList("commands." + s)) {
                    e.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', ss));
                }
                e.setCancelled(true);
            }
        }
    }
}
