package com.gdx.neuroshima.server;

import com.gdx.neuroshima.server.bus.Bus;
import com.gdx.neuroshima.server.bus.Event;
import com.gdx.neuroshima.server.bus.EventHandler;
import com.gdx.neuroshima.server.bus.EventType;

import java.util.ArrayList;
import java.util.List;

public class GameLogic implements EventHandler {
    private List<Player> players = new ArrayList<>();
    private Player actual;

    public GameLogic() {
        Player player1 = new Player("Player");
        Player player2 = new Player("Computer");
        players.add(player1);
        players.add(player2);
        actual = player1;
        Bus.register(this, EventType.TURN_STARTED);
    }

    public void startGame() {
        Event event = new Event(EventType.TURN_STARTED);
        event.setPlayer(actual);
        Bus.send(event);
    }

    @Override
    public void handle(Event event) {
        //reakcja na eventy
        //zeby klasa reagowala na eveny musi implementowac Eventhandlera
        //trzeba zarjestrowac w even Busie
        //w metodzie handle trzeba napisac reakcje
        System.out.println("tak");
        Hex hex = new Hex(HexType.BASE);
        Player actual = event.getPlayer();
        actual.addHex(hex);

    }
}
