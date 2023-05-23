package org.academiadecodigo.arabiannights.genie;


public class GrumpyGenie extends Genie {


    public GrumpyGenie(int wishLimit) {
        super(wishLimit);
    }

    @Override
    public boolean hasWishesLeft() {
        return super.getGrantedWishes() == 0;
    }

}
