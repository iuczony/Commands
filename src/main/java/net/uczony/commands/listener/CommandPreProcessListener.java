package net.uczony.commands.listener;

import net.uczony.commands.CommandsPlugin;
import net.uczony.commands.helper.ChatHelper;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

/**
 * made by uczony
 *
 * @since 14/11/2018
 **/

public class CommandPreProcessListener implements Listener {

    @EventHandler
    public void onPlayerCommandPreproces(PlayerCommandPreprocessEvent e) {
        for (final String string : CommandsPlugin.getInstance().getConfig().getConfigurationSection("commands").getKeys(false)) {
            final String[] cmd = e.getMessage().split(" ");
            if (cmd[0].equals("/" + string)) {
                for (final String string1 : CommandsPlugin.getInstance().getConfig().getStringList("commands." + string)) {
                    e.getPlayer().sendMessage(ChatHelper.fixColor(ChatColor.translateAlternateColorCodes('&', string1)));
                }
                e.setCancelled(true);
            }
        }
    }
}
