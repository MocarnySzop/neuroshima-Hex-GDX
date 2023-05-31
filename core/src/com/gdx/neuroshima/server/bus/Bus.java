package com.gdx.neuroshima.server.bus;

public class Bus {
    private static BusImplementation busImplementation = new BusImplementation();

   public static void register(EventHandler eventHandler, EventType eventType){
        busImplementation.register(eventHandler, eventType);
    }
    public static void send(Event event){
       busImplementation.send(event);
    }
}
