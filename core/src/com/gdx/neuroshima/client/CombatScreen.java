
package com.gdx.neuroshima.client;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.gdx.neuroshima.server.GameLogic;
import com.gdx.neuroshima.server.Hex;
import com.gdx.neuroshima.server.HexType;
import com.gdx.neuroshima.server.bus.Bus;
import com.gdx.neuroshima.server.bus.Event;
import com.gdx.neuroshima.server.bus.EventHandler;
import com.gdx.neuroshima.server.bus.EventType;

public class CombatScreen implements Screen, EventHandler {
    private NeuroshimaGame neuroshimaGame;
    private OrthographicCamera camera;
    private Stage stage; //doczytac o scene2d module
    private Texture background;
    private HexGroup hexGroup;


    public CombatScreen(NeuroshimaGame neuroshimaGame) {
        this.neuroshimaGame = neuroshimaGame;
        this.camera = new OrthographicCamera();
        camera.setToOrtho(false, ScreenParams.WIDTH, ScreenParams.HEIGHT);
        stage = new Stage(new ScreenViewport(camera), neuroshimaGame.getBatch());
        Gdx.input.setInputProcessor(stage);
        background = new Texture(Gdx.files.internal("board.jpg"));
        BoardGroup boardGroup = new BoardGroup();
        stage.addActor(boardGroup);
        UiPanelGroup uiPanelGroup = new UiPanelGroup();
        stage.addActor(uiPanelGroup);
        uiPanelGroup.setPosition(600, 150);
        GameLogic gameLogic = new GameLogic();
        Bus.register(this, EventType.TURN_STARTED);
        hexGroup = new HexGroup();
        stage.addActor(hexGroup);
        gameLogic.startGame();



    }



    @Override
    public void show() {

    }

    @Override
    public void handle(Event event) {
        System.out.println("nie");
        HexActor hexActor = new HexActor(new Texture(Gdx.files.internal("hexactor.jpg")),new Hex(HexType.PAWN));
        hexGroup.addActor(hexActor);
        HexActor hexActor2 = new HexActor(new Texture(Gdx.files.internal("hexactor.jpg")),new Hex(HexType.PAWN));
        hexGroup.addActor(hexActor2);
        HexActor hexActor3 = new HexActor(new Texture(Gdx.files.internal("hexactor.jpg")),new Hex(HexType.PAWN));
        hexGroup.addActor(hexActor3);


    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(Color.GRAY);
        camera.update();
        Batch batch = neuroshimaGame.getBatch();
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        batch.draw(background, ScreenParams.BOARD_X, ScreenParams.BOARD_Y, ScreenParams.BOARD_WIDTH, ScreenParams.BOARD_HEIGHT);
        batch.end();
        stage.act(delta);
        stage.draw();
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
