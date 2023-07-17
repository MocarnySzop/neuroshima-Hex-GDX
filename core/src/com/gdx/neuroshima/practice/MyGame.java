package com.gdx.neuroshima.practice;


import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop;

public class MyGame extends ApplicationAdapter {
    private Stage stage;
    private DragAndDrop dragAndDrop;
    private Group group;

    @Override
    public void create() {
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        dragAndDrop = new DragAndDrop();

        group = new Group();
        Image image = new Image(new Texture("hex.jpg"));
        group.addActor(image);

        // Dodajemy obiekt do sceny
        stage.addActor(group);

        // Utworzenie akcji przeciągania
        dragAndDrop.addSource(new DragAndDrop.Source(image) {
            @Override
            public DragAndDrop.Payload dragStart(InputEvent event, float x, float y, int pointer) {
                // Początek przeciągania
                DragAndDrop.Payload payload = new DragAndDrop.Payload();
                payload.setObject(group);

                // Zablokowanie innych akcji przeciągania dla tego źródła
                dragAndDrop.setDragActorPosition(-x, -y + image.getHeight());
//                    dragAndDrop.setDragActorScale(1.2f);

                // Przeniesienie obiektu na wierzch sceny
                group.toFront();

                return payload;
            }
        });

        dragAndDrop.addTarget(new DragAndDrop.Target(group) {
            @Override
            public boolean drag(DragAndDrop.Source source, DragAndDrop.Payload payload, float x, float y, int pointer) {
                // Wykonywane, gdy przeciąganie jest w toku
                group.setPosition(x, y);
                return true;
            }

            @Override
            public void drop(DragAndDrop.Source source, DragAndDrop.Payload payload, float x, float y, int pointer) {
                // Wykonywane po zakończeniu przeciągania
                group.setPosition(x, y);
            }
        });
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

