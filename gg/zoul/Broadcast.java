package gg.zoul;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author Geuxy
 */
public class Broadcast extends JavaPlugin implements CommandExecutor {

    @Override
    public void onEnable() {
        this.saveDefaultConfig();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (s.equalsIgnoreCase("bc") || s.equalsIgnoreCase("broadcast")) {
            if (sender.hasPermission(translate(this.getConfig().getString("broadcast-permission")))) {
                String message = "";
                if (args.length >= 1) {
                    for (int i = 0; i < args.length; i++) {
                        message = message = args[i] + " ";
                    }
                    Bukkit.broadcastMessage(translate(this.getConfig().getString("prefix")) + translate(message));
                } else {
                    sender.sendMessage(translate(this.getConfig().getString("usage-message")));
                }
            } else {
                sender.sendMessage(translate(this.getConfig().getString("permission-message")));
            }
        }
        if (s.equalsIgnoreCase("bcreload") || s.equalsIgnoreCase("bc-reload")) {
            if(sender.hasPermission(translate(this.getConfig().getString("reload-permission")))) {
                sender.sendMessage(translate(this.getConfig().getString("reload-message")));
                this.reloadConfig();
            } else {
                sender.sendMessage(translate(this.getConfig().getString("permission-message")));
            }
        }
        return false;
    }

    public String translate(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }

}
