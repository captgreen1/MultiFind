package com.fullhousedev.multifind.events;

import net.md_5.bungee.api.plugin.Event;

/**
 * This is a description of the class.
 *
 * @author Austin Bolstridge (WolfyTheFur).
 */
public class RemoteProxyPlayerLoginEvent extends Event {

    private String username;
    private String server;

    public RemoteProxyPlayerLoginEvent(String username, String server) {
        this.username = username;
        this.server = server;
    }

    public String getUsername() {
        return username;
    }

    public String getServer() {
        return server;
    }
}
