package org.academiadecodigo.bootcamp.guessnumber;

public class Game {

    private int maxGuess;
    private Player[] players;

    public Game(int maxGuess, Player[] players) {
        this.maxGuess = maxGuess;
        this.players = players;
    }

    // 1. Make sure players do not choose the same number twice
    // 2. Have a max number of rounds, if no player wins, the system does

    public void start() {

        int systemGuess = chooseNumber();
        System.out.println("## The system chooses the number " + systemGuess + " ##");

        boolean winnerFound = false;

        while(winnerFound == false) {

            for (Player player : players) {

                int playerGuess = player.chooseNumber(maxGuess);
                System.out.println(player.getName() + " guessed number " + playerGuess);

                if (systemGuess == playerGuess) {
                    System.out.println("## " + player.getName() + " wins! ##");
                    winnerFound = true;
                    break;
                }
            }
        }
    }

    private int chooseNumber() {
        return RandomGenerator.getRandom(maxGuess);
    }

}
