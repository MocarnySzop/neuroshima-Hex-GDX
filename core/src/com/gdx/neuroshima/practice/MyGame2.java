package com.gdx.neuroshima.practice;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class MyGame2 extends ApplicationAdapter {
    Stage stage;
    DragAndDrop dragAndDrop;

    @Override
    public void create() {
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
         dragAndDrop = new DragAndDrop();

        final Image image = new Image(new Texture("hex.jpg"));
        image.setBounds(50, 50, 100, 100);
        stage.addActor(image);

        dragAndDrop.addSource(new DragAndDrop.Source(image) {
            @Override
            public DragAndDrop.Payload dragStart(InputEvent event, float x, float y, int pointer) {
                DragAndDrop.Payload payload = new DragAndDrop.Payload();
                payload.setObject(image);
                payload.setDragActor(image);
                return payload;
            }
        });

       /* dragAndDrop.addTarget(new DragAndDrop.Target(image) {
            @Override
            public boolean drag(DragAndDrop.Source source, DragAndDrop.Payload payload, float x, float y, int pointer) {
                payload.getDragActor().moveBy(x - payload.getDragActor().getWidth() / 2, y - payload.getDragActor().getHeight() / 2);
                return true;
            }

            @Override
            public void drop(DragAndDrop.Source source, DragAndDrop.Payload payload, float x, float y, int pointer) {
                payload.getDragActor().addAction(Actions.moveTo(x - payload.getDragActor().getWidth() / 2, y - payload.getDragActor().getHeight() / 2, .5f));
            }
        });*/

    }

    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
