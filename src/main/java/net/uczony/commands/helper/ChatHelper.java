package net.uczony.commands.helper;

import org.bukkit.ChatColor;

/**
 * made by uczony
 *
 * @since 01/02/2020
 **/

public class ChatHelper {

    public static String fixColor(final String string) {
        return ChatColor.translateAlternateColorCodes('&', string)
                .replace(">>", "»")
                .replace("<<", "«");
    }
}
