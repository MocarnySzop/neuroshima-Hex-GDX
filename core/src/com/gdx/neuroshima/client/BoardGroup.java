package com.gdx.neuroshima.client;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop;

public class BoardGroup extends Group {
    public BoardGroup() {
        createHexSlots();
        setPosition(ScreenParams.BOARD_X + 45, ScreenParams.BOARD_Y + 35);
    }
    public void configureDragAndDropTarget(DragAndDrop dragAndDrop){
      for (Actor slot : getChildren()) {

            dragAndDrop.addTarget(new DragAndDrop.Target(slot) {
                @Override
                public boolean drag(DragAndDrop.Source source, DragAndDrop.Payload payload, float v, float v1, int i) {
                    return true;
                }

                @Override
                public void drop(DragAndDrop.Source source, DragAndDrop.Payload payload, float v, float v1, int i) {
                    addActor(source.getActor());
                    source.getActor().setPosition(slot.getX(), slot.getY());

                }
            });
        }


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

