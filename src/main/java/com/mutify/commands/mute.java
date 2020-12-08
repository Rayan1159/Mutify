package com.mutify.commands;

import files.muteFile;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class mute implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;

        if (player.hasPermission("mutify.mute")){
            if (args.length == 1) {
                Player target = Bukkit.getServer().getPlayerExact(args[0]);

                if (target != null) {
                    muteFile.build(target.getName());
                    boolean isMuted = muteFile.get().getBoolean("muted");

                    if (!(isMuted)) {
                        muteFile.config.set("muted", true);
                        player.sendMessage(ChatColor.RED + "[Mutify] " + ChatColor.BLUE + "Muted " + ChatColor.GOLD + target.getName());
                    } else {
                        muteFile.config.set("muted", false);
                        player.sendMessage(ChatColor.RED + "[Mutify] " + ChatColor.BLUE + "Unmuted " + ChatColor.GOLD + target.getName());
                    }
                    muteFile.save();
                } else {
                    player.sendMessage(ChatColor.RED + "[Mutify] " + ChatColor.BLUE + "Player is not online");
                }
            } else {
                player.sendMessage(ChatColor.RED + "[Mutify] " + ChatColor.BLUE + "specify a player to mute.");
            }
        } else {
            player.sendMessage(ChatColor.RED + "[Mutify] " + ChatColor.BLUE + "You do not have permission to use /mute");
        }
        return true;
    }
}
