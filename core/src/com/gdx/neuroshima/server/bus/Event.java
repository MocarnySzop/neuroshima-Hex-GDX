package com.gdx.neuroshima.server.bus;

import com.gdx.neuroshima.server.Player;

public class Event {
    private EventType eventType;
    private Player player;

    public Event(EventType eventType) {
        this.eventType = eventType;
    }

    public EventType getEventType() {
        return eventType;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
