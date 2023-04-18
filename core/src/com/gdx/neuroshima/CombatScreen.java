package com.gdx.neuroshima;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScalingViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class CombatScreen implements Screen {
    private Neuroshima neuroshima;
    private OrthographicCamera camera;
    private Stage stage; //doczytac o scene2d module
    private Texture background;

    public CombatScreen(Neuroshima neuroshima) {
        this.neuroshima = neuroshima;
        this.camera = new OrthographicCamera();
        camera.setToOrtho(false,ScreenParams.WIDTH, ScreenParams.HEIGHT);
        stage = new Stage(new ScreenViewport(camera), neuroshima.getBatch());
        background = new Texture(Gdx.files.internal("board.jpg"));

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(Color.GRAY);
        camera.update();
        Batch batch = neuroshima.getBatch();
        batch.setProjectionMatrix(camera.combined);
        stage.act(delta);
        stage.draw();
        batch.begin();
        batch.draw(background,ScreenParams.BOARD_X, ScreenParams.BOARD_Y,ScreenParams.BOARD_WIDTH, ScreenParams.BOARD_HEIGHT);
        batch.end();



    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
