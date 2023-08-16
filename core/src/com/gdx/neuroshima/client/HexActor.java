package com.gdx.neuroshima.client;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop;
import com.gdx.neuroshima.server.Hex;

public class HexActor extends Actor {
    private Texture texture;
    private Hex hex;
    private DragAndDrop dragAndDrop;


    public HexActor(Texture texture, Hex hex) {
        this.texture = texture;
        this.hex = hex;
        setBounds(25, 0, ScreenParams.HEX_WIDTH, ScreenParams.HEX_HEIGHT);
        dragAndDrop = new DragAndDrop(); // obiekt drag and drop zarzadza przeciaganiem
        dragAndDrop.setKeepWithinStage(false);
        //dragAndDrop.setDragActorPosition(getWidth() / 2, -getHeight() / 2); Centruje miejsce przeciagania na srodek hexa(domyslnie jest prawy dolny rog 0, 0)
        configureDragAndDropSource();
    }

    private void configureDragAndDropSource() {
        dragAndDrop.addSource(new DragAndDrop.Source(this) { // ustwianie zrodla przeciagania
            @Override
            public DragAndDrop.Payload dragStart(InputEvent event, float x, float y, int pointer) {

                dragAndDrop.setDragActorPosition(ScreenParams.HEX_WIDTH - x - getParent().getX() , -y ); // centrowanie jest dynamicznie wyliczane na bazie miejsca gdzie zostal zlapany obrazek
                DragAndDrop.Payload payload = new DragAndDrop.Payload(); // co jest zawartoscia rpzeciagania
                payload.setObject(HexActor.this); // ten obiekt
                payload.setDragActor(HexActor.this);
                return payload;
            }
        });
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

    public DragAndDrop getDragAndDrop() {
        return dragAndDrop;
    }
}
