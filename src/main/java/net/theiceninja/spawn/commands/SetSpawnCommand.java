package net.theiceninja.spawn.commands;

import net.theiceninja.spawn.Main;
import net.theiceninja.spawn.utils.ColorUtils;
import net.theiceninja.spawn.utils.MessageUtils;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetSpawnCommand implements CommandExecutor {
    Main plugin;

    public SetSpawnCommand(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player p = (Player) sender;
            if (p.hasPermission("spawn.setspawn")){
                Location location = p.getLocation();
                plugin.getConfig().set("spawn", location);
                plugin.saveConfig();
                p.sendMessage(ColorUtils.color(MessageUtils.PREFIX + " &aנשמר מיקום הספאון!"));

            }else{
                p.sendMessage(MessageUtils.PREFIX + " " + MessageUtils.NO_PERMS);
            }

        }else{
            sender.sendMessage(MessageUtils.NOT_PLAYER);
        }
        return true;
    }
}
