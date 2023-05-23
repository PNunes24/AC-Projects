package org.academiadecodigo.arabiannights.genie;


public class Genie {

    private int wishLimit;
    private int grantedWishes;

    Genie(int wishLimit) {
        this.grantedWishes = 0;
        this.wishLimit = wishLimit;
    }

    public int getWishLimit() {
        return wishLimit;
    }

    public int getGrantedWishes() {
        return grantedWishes;
    }

    private int getRemainingWishes() {
        int remaining = getWishLimit() - getGrantedWishes();
        return remaining >= 0 ? remaining : 0;
    }


    public boolean hasWishesLeft() {
        return getRemainingWishes() > 0;
    }


    private void doGrantWish() {
        this.grantedWishes++;
        System.out.println("Wish granted by " + this.getClass().getSimpleName());
    }


    public boolean grantWish() {

        if (!hasWishesLeft()) {
            return false;
        }

        doGrantWish();
        return true;
    }
}
