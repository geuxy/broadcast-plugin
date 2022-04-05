package gg.zoul;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class ZoulPlugin extends JavaPlugin implements CommandExecutor  {

    @Override
    public void onEnable() {
        this.saveDefaultConfig();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(s.equalsIgnoreCase("bc") || s.equalsIgnoreCase("broadcast")) {
            if (sender.hasPermission("zbc.broadcast")) {
                String message = "";
                if (args.length >= 1) {
                    for (int i = 0; i < args.length; i++) {
                        message = message = args[i] + " ";
                    }
                    Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("prefix")) + message.replaceAll("&", "§"));
                } else {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("usage-message")));
                }
            } else {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("permission-message")));
            }
        }
        if(s.equalsIgnoreCase("bcreload") || s.equalsIgnoreCase("bc-reload")) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("reload-message")));
            this.reloadConfig();
        }
        return false;
    }
}
