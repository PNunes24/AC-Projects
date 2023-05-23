package org.academiadecodigo.bootcamp.sniperelite.gameobject.enemy;

import org.academiadecodigo.bootcamp.sniperelite.gameobject.Destroyable;
import org.academiadecodigo.bootcamp.sniperelite.gameobject.GameObject;


public abstract class Enemy extends GameObject implements Destroyable {

    private int health;


    public Enemy(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    @Override
    public boolean isDestroyed() {
        return health <= 0;
    }


    public void hit(int damage) {

        health = health > damage ? health - damage : 0;
    }

    @Override
    public String getMessage() {
        return "Tango Acquired. Taking it down!";
    }

}
