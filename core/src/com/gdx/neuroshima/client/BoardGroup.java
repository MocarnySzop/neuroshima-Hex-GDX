package com.gdx.neuroshima.client;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Group;

public class BoardGroup extends Group {
    public BoardGroup() {
        createHexSlots();
        setPosition(ScreenParams.BOARD_X + 45, ScreenParams.BOARD_Y + 35);
    }

    void createHexSlots() {
        Texture texture = new Texture(Gdx.files.internal("hexfinal2.png"));
        for (int x = 0; x < 5; x++) {
            for (int y = 0; y < 5; y++) {
                if(x==0 && y == 0 || x == 0 && y == 4 || x==1 && y == 4 || x == 4 && y == 4 || x== 4 && y == 0 || x == 3 && y == 4   ){
                    continue;
                }
                HexSlotActor hexSlotActor = new HexSlotActor(texture, x, y);
                addActor(hexSlotActor);
            }
        }
    }

}

