package com.gdx.neuroshima.server.bus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BusImplementation {
    private Map<EventType, List<EventHandler>> handlers = new HashMap<>();

    public BusImplementation() {
        for (EventType type : EventType.values()) {
            handlers.put(type, new ArrayList<>());
        }
    }

    public void register(EventHandler eventHandler, EventType eventType){
        handlers.get(eventType).add(eventHandler);

    }
    public void send(Event event){
        List<EventHandler> correctHandlers = handlers.get(event.getEventType());
        for (EventHandler correctHandler : correctHandlers) {
            correctHandler.handle(event);
        }
    }
}
