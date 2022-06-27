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
        if (!(sender instanceof Player)) {
            sender.sendMessage(MessageUtils.NOT_PLAYER.getMessage());
            return true;
        }

        Player p = (Player) sender;

        if (!p.hasPermission("spawn.setspawn")) {
            p.sendMessage(MessageUtils.PREFIX.getMessage() + " " + MessageUtils.NO_PERMS);
            return true;
        }

        Location location = p.getLocation();
        plugin.getConfig().set("spawn", location);
        plugin.saveConfig();
        p.sendMessage(ColorUtils.color(MessageUtils.PREFIX.getMessage() + " &aנשמר מיקום הספאון!"));

        return true;
    }
}
