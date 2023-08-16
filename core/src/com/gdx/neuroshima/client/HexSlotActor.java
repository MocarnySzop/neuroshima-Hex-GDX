package com.gdx.neuroshima.client;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.gdx.neuroshima.server.Hex;

public class HexSlotActor extends Actor {
    private Texture texture;
    private int gridX;
    private int gridY;

    public HexSlotActor(Texture texture, int gridX, int gridY) {
        this.texture = texture;
        this.gridX = gridX;
        this.gridY = gridY;
        float pixelY = gridY * ScreenParams.HEX_HEIGHT * 1.03f;
        if (gridX % 2 != 0) {
            pixelY += 0.5 * ScreenParams.HEX_HEIGHT;
        }
        setBounds(gridX * (0.78f * ScreenParams.HEX_WIDTH), pixelY, ScreenParams.HEX_WIDTH, ScreenParams.HEX_HEIGHT);
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

    @Override
    public String toString() {
        return "HexSlotActor{" +
                "texture=" + texture +
                ", gridX=" + gridX +
                ", gridY=" + gridY +
                '}';
    }
}
