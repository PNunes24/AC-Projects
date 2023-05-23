package org.academiadecodigo.bootcamp.sniperelite.weapons;

import org.academiadecodigo.bootcamp.sniperelite.gameobject.Destroyable;


public class SniperRifle {

    public static final double HIT_PROBABILITY = 0.7;

    private int shotsFired;
    private int bulletDamage;


    public SniperRifle(int bulletDamage) {
        this.bulletDamage = bulletDamage;
    }

    public int getShotsFired() {
        return shotsFired;
    }


    public void shoot(Destroyable target) {

        shotsFired++;

        if(Math.random() < HIT_PROBABILITY) {

            target.hit(bulletDamage);
            System.out.println("It's a hit!");

        } else {
            System.out.println("It's a miss!");
        }

    }
}
