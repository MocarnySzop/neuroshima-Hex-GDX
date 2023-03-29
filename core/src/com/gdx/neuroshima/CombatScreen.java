package com.gdx.neuroshima;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class CombatScreen implements Screen {
    private Neuroshima neuroshima;
    private OrthographicCamera camera;

    public CombatScreen(Neuroshima neuroshima) {
        this.neuroshima = neuroshima;
        this.camera = new OrthographicCamera();
        camera.setToOrtho(false,ScreenParams.WIDTH, ScreenParams.HEIGHT);

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

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
