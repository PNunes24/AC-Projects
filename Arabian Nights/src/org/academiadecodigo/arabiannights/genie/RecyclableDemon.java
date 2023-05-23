package org.academiadecodigo.arabiannights.genie;


public class RecyclableDemon extends Genie {

    private boolean recycled = false;


    public RecyclableDemon(int wishLimit) {
        super(wishLimit);
    }

    public boolean isRecycled() {
        return recycled;
    }

    public void recycle() {
        recycled = true;
    }

    /**
     * @see Genie#hasWishesLeft()
     */
    @Override
    public boolean hasWishesLeft() {
        return !recycled;
    }
}
