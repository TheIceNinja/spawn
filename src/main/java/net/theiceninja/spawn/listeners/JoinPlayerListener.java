package net.theiceninja.spawn.listeners;

import net.theiceninja.spawn.Main;
import net.theiceninja.spawn.utils.MessageUtils;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinPlayerListener implements Listener {
    Main plugin;

    public JoinPlayerListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();
        Location location = plugin.getConfig().getLocation("spawn");
        if (location != null) p.teleport(location);

    }
}
