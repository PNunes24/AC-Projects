package org.academiadecodigo.arabiannights;

import org.academiadecodigo.arabiannights.genie.FriendlyGenie;
import org.academiadecodigo.arabiannights.genie.Genie;
import org.academiadecodigo.arabiannights.genie.GrumpyGenie;
import org.academiadecodigo.arabiannights.genie.RecyclableDemon;

/**
 * A Magic Lamp, capable of providing Geniuses when rubbed
 */
public class MagicLamp {

    private int capacity;
    private int timesRubbed;
    private int timesRecharged;

    public MagicLamp(int capacity) {
        this.timesRubbed = 0;
        this.timesRecharged = 0;
        this.capacity = capacity;
    }

    public Genie rub() {

        System.out.println("*** rub ***");
        timesRubbed++;

        int randomNumWishes = (int) ((Math.random() * 5) + 1);

        if (!hasGeniesLeft()) {
            return new RecyclableDemon(randomNumWishes);
        }

        return isEven() ? new FriendlyGenie(randomNumWishes) : new GrumpyGenie(randomNumWishes);
    }

    public void recharge(RecyclableDemon demon) {

        if (demon.isRecycled()) {
            return;
        }

        demon.recycle();
        timesRubbed = 0;
        timesRecharged++;

        System.out.println("The lamp is being recharged by a " + demon.getClass().getSimpleName() + ".");
    }

    private boolean hasGeniesLeft() {
        return timesRubbed <= capacity;
    }


    private boolean isEven() {
        return timesRubbed % 2 == 0;
    }


    public boolean equals(MagicLamp lamp) {
        return this.capacity == lamp.capacity
                && this.timesRubbed == lamp.timesRubbed
                && this.timesRecharged == lamp.timesRecharged;

    }

}
