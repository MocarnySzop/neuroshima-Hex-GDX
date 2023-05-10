package com.gdx.neuroshima.client;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

import java.awt.*;

public class UiPanelGroup extends Group {
    String name;
    private Label playerTurnLabel;

    public UiPanelGroup() {
        BitmapFont bitmapFont = new BitmapFont();
        Label.LabelStyle style = new Label.LabelStyle();
        style.font = bitmapFont;
        style.fontColor = Color.BLUE;
        playerTurnLabel = new Label("test", style);
        addActor(playerTurnLabel);
    }
}
