package com.gdx.neuroshima.client;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.gdx.neuroshima.server.Hex;

public class HexActor extends Actor {
    private Texture texture;
    private Hex hex;

    public HexActor(Texture texture,Hex hex) {
        this.texture = texture;
        this.hex = hex;
        setBounds(0,0, ScreenParams.HEX_WIDTH, ScreenParams.HEX_HEIGHT);
    }
    @Override
    public void draw(Batch batch, float parentAlpha) {
        //card
        Color color = getColor();
        batch.setColor(color.r, color.g, color.b, color.a * parentAlpha);
        batch.draw(texture, getX(), getY(), getOriginX(), getOriginY(),
                getWidth(), getHeight(), getScaleX(), getScaleY(),
                getRotation(), 0, 0, texture.getWidth(), texture.getHeight(),
                false, false);
        batch.setColor(Color.WHITE);
    }
}
