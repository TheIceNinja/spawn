package net.theiceninja.spawn.commands;

import net.theiceninja.spawn.Main;
import net.theiceninja.spawn.utils.ColorUtils;
import net.theiceninja.spawn.utils.MessageUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCommand implements CommandExecutor {
    Main plugin;

    public SpawnCommand(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player p = (Player) sender;
                if (args.length == 0) {
                    if (p.hasPermission("spawn.spawn")) {
                        Location location = plugin.getConfig().getLocation("spawn");
                        if (location != null) {
                            p.teleport(location);
                            p.sendMessage(ColorUtils.color(MessageUtils.PREFIX + " &aהשתגרת לספאון!"));
                        } else {
                            p.sendMessage(ColorUtils.color(MessageUtils.PREFIX + " &cצריך לעשות /setspawn בשביל שיהיה ספאון למקום שאתה רוצה!"));
                        }
                    }else{
                        p.sendMessage(MessageUtils.PREFIX + " " + MessageUtils.NO_PERMS);
                    }
                }else if (args.length == 1) {
                    if (p.hasPermission("spawn.spawn.other")) {
                        Player target = Bukkit.getPlayer(args[0]);
                        Location location = plugin.getConfig().getLocation("spawn");
                        if (location != null) {
                            if (target != null) {
                                target.teleport(location);
                                target.sendMessage(ColorUtils.color(MessageUtils.PREFIX + " &aהשתגרת לספאון!"));
                                p.sendMessage(ColorUtils.color(MessageUtils.PREFIX + " &aהשיגור של &2" + target.getDisplayName() + " &aבוצע בהצלחה!"));
                            } else {
                                p.sendMessage(MessageUtils.PLAYER_ERR);
                            }

                        } else {
                            p.sendMessage(MessageUtils.NO_SPAWN);
                        }
                    }else{
                        p.sendMessage(MessageUtils.PREFIX + " " + MessageUtils.NO_PERMS);
                    }
                }

        }else{
            sender.sendMessage(MessageUtils.NOT_PLAYER);
        }
        return true;
    }
}
