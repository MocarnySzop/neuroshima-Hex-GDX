package com.gdx.neuroshima.server;

import com.gdx.neuroshima.server.bus.Bus;
import com.gdx.neuroshima.server.bus.Event;
import com.gdx.neuroshima.server.bus.EventType;

import java.util.ArrayList;
import java.util.List;

public class GameLogic {
    private List<Player> players = new ArrayList<>();
    private Player actual;
  public  void startGame(){
        Player player1 = new Player("Player");
        Player player2 = new Player("Computer");
        players.add(player1);
        players.add(player2);
        actual = player1;
        Event event = new Event(EventType.TURN_STARTED);
        event.setPlayer(actual);
        Bus.send(event);
    }
}
