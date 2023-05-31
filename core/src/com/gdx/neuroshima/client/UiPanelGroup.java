package com.gdx.neuroshima.client;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.gdx.neuroshima.server.bus.Bus;
import com.gdx.neuroshima.server.bus.Event;
import com.gdx.neuroshima.server.bus.EventHandler;
import com.gdx.neuroshima.server.bus.EventType;

import java.awt.*;

public class UiPanelGroup extends Group implements EventHandler {
    String name;
    private Label playerTurnLabel;

    public UiPanelGroup() {
        BitmapFont bitmapFont = new BitmapFont();
        Label.LabelStyle style = new Label.LabelStyle();
        style.font = bitmapFont;
        style.fontColor = Color.BLUE;
        playerTurnLabel = new Label("test", style);
        addActor(playerTurnLabel);
        Bus.register(this, EventType.TURN_STARTED);
    }

    @Override
    public void handle(Event event) {
        if(event.getEventType()== EventType.TURN_STARTED) {
            playerTurnLabel.setText("tura gracza:" + event.getPlayer().getName());
        }
    }
}
