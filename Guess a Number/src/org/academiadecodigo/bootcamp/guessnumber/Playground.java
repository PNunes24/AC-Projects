package org.academiadecodigo.bootcamp.guessnumber;

public class Playground {

    public static void main(String[] args) {

        Player[] players = new Player[2];

        players[0] = new Player("Pedro");
        players[1] = new Player("Catarina");

        Game game = new Game(10, players);
        game.start();
    }
}
