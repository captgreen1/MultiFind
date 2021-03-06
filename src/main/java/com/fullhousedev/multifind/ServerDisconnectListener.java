package com.fullhousedev.multifind;

import net.md_5.bungee.api.event.PlayerDisconnectEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import redis.clients.jedis.Jedis;

/**
 * This is a description of the class.
 *
 * @author Austin Bolstridge (WolfyTheFur).
 */
public class ServerDisconnectListener implements Listener {
    private MultiFind plugin;

    public ServerDisconnectListener(MultiFind plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerDisconnect(PlayerDisconnectEvent event) {
        final String username = event.getPlayer().getName();

        plugin.getProxy().getScheduler().runAsync(plugin, new Runnable() {
            @Override
            public void run() {
                try(Jedis redis = plugin.getRedisConnection()) {
                    if(redis.exists(username)) {
                        redis.del(username);
                    }
                }
            }
        });
    }
}
