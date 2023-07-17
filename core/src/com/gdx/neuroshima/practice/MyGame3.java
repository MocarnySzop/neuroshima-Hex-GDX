package com.gdx.neuroshima.practice;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import javax.xml.transform.Source;
import java.lang.annotation.Target;

public class MyGame3 extends ApplicationAdapter {
    Stage stage;
    DragAndDrop dragAndDrop;

    @Override
    public void create () {
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        dragAndDrop = new DragAndDrop();
        dragAndDrop.setDragActorPosition(50,-50);
        // Tworzenie źródeł
        final Image sourceImage = new Image(new Texture("hex.jpg")); // dodaj odpowiednie tekstury
        sourceImage.setBounds(800, 800, 100, 100);
        stage.addActor(sourceImage);



        dragAndDrop.addSource(new DragAndDrop.Source(sourceImage) {
            @Override
            public DragAndDrop.Payload dragStart(InputEvent event, float x, float y, int pointer) {
                DragAndDrop.Payload payload = new DragAndDrop.Payload();
                payload.setObject(sourceImage);
                payload.setDragActor(sourceImage);
                return payload;
            }
        });

        // Tworzenie celów
        final Group targetGroup = new Group();
        targetGroup.setBounds(0, 0, 500, 500);
        stage.addActor(targetGroup);

        dragAndDrop.addTarget(new DragAndDrop.Target(targetGroup) {
            @Override
            public boolean drag(DragAndDrop.Source source, DragAndDrop.Payload payload, float x, float y, int pointer) {
//                System.out.println("test");
//                float dragActorWidth = payload.getDragActor().getWidth(); // szerokość drag actora
//                float dragActorHeight = payload.getDragActor().getHeight(); // wysokość drag actora
//
//// Ustaw wypośrodkowane położenie drag actora
//                payload.getDragActor().setPosition(dragActorWidth , dragActorHeight);
                return true;
            }

            @Override
            public void drop(DragAndDrop.Source source, DragAndDrop.Payload payload, float x, float y, int pointer) {
                System.out.println("Upuszczono");
                Image draggedImage = (Image) payload.getObject();
                draggedImage.remove(); // usuń z poprzedniego miejsca
                targetGroup.addActor(draggedImage); // dodaj do grupy
                payload.getDragActor().setPosition(0,0);
            }
        });
    }

    @Override
    public void render () {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }

    @Override
    public void dispose () {
        stage.dispose();
    }
}
