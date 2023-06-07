package com.gdx.neuroshima.server;

import java.util.ArrayList;
import java.util.List;

public class Player {
   private String name;
   private List<Hex> hexList = new ArrayList<>();


    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addHex(Hex hex){
        hexList.add(hex);
    }
}
