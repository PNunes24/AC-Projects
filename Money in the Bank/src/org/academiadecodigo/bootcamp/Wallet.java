package org.academiadecodigo.bootcamp;

/**
 * Wallet Class
 */
public class Wallet {

    private int money = 0;

    public int getMoney() {
        return money;
    }

    public void add(int money) {
        this.money += money;
    }

    public int use(int money) {

        if (money > this.money) {
            int removedMoney = this.money;
            this.money = 0;
            return removedMoney;
        }

        // normal case
        this.money -= money;
        return money;

    }

    @Override
    public String toString() {
        return "Wallet{" +
                "money=" + money +
                '}';
    }
}
