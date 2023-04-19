
package com.gdx.neuroshima.client;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class CombatScreen implements Screen {
    private NeuroshimaGame neuroshimaGame;
    private OrthographicCamera camera;
    private Stage stage; //doczytac o scene2d module
    private Texture background;

    public CombatScreen(NeuroshimaGame neuroshimaGame) {
        this.neuroshimaGame = neuroshimaGame;
        this.camera = new OrthographicCamera();
        camera.setToOrtho(false, ScreenParams.WIDTH, ScreenParams.HEIGHT);
        stage = new Stage(new ScreenViewport(camera), neuroshimaGame.getBatch());
        background = new Texture(Gdx.files.internal("board.jpg"));
        createBoard();


    }

    void createBoard() {
        Texture texture = new Texture(Gdx.files.internal("hexfinal2.png"));
        BoardGroup boardGroup = new BoardGroup();
        for (int x = 0; x < 5; x++) {
            for (int y = 0; y < 5; y++) {
                if(x==0 && y == 0 || x == 0 && y == 4 || x==1 && y == 4 || x == 4 && y == 4 || x== 4 && y == 0 || x == 3 && y == 4   ){
                    continue;
                }
                HexSlotActor hexSlotActor = new HexSlotActor(texture, x, y);
                boardGroup.addActor(hexSlotActor);
                stage.addActor(boardGroup);
            }
        }
        boardGroup.setPosition(ScreenParams.BOARD_X + 45, ScreenParams.BOARD_Y + 35);
    }

    @Override
    public void show() {

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
