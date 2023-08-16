package com.gdx.neuroshima.client;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;

public class HexGroup extends Group {
    private Actor before;

    @Override
    public void addActor(Actor actor) {
        if (before != null) {
            actor.setPosition(0, before.getY() + actor.getHeight() + 10);
        }
        before = actor;
        super.addActor(actor);

    }
}
