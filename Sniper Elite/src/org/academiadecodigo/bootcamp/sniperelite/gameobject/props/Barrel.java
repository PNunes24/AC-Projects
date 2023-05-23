package org.academiadecodigo.bootcamp.sniperelite.gameobject.props;

import org.academiadecodigo.bootcamp.sniperelite.gameobject.Destroyable;
import org.academiadecodigo.bootcamp.sniperelite.gameobject.GameObject;


public class Barrel extends GameObject implements Destroyable {

    private BarrelType barrelType;
    private int currentDamage;

    public Barrel() {

        int index = (int) (Math.random() * (BarrelType.values().length));
        barrelType = BarrelType.values()[index];

    }

    @Override
    public boolean isDestroyed() {
        return currentDamage >= barrelType.getMaxDamage();
    }

    @Override
    public void hit(int damage) {
        currentDamage++;
    }

    @Override
    public String getMessage() {
        return "Barrel found. Let's blow it!";
    }
}
