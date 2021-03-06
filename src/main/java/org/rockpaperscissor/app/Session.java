package org.rockpaperscissor.app;

import java.util.Scanner;

public class Session {

    private Integer userWins = 0;
    private Integer computerWins = 0;
    private final Scanner scanner = new Scanner(System.in);

    public void startSession() {

        printGameInstructions();

        while (true) {

            Game game = new Game();
            Integer gameResult = game.startGame();

            if(gameResult == 1) userWins++;
            else computerWins++;    // gameResult == 2

            Boolean playNextGame = askContinueToPlay();

            if(!playNextGame) {
                System.out.println("\nTotal games played: " + (userWins + computerWins));
                System.out.println("You won " + userWins + " games and Computer won " + computerWins + " games.");
                return;
            }

        }
    }


    public void printGameInstructions() {
        System.out.println("Instructions for playing the game: enter 0 for Rock, 1 for Paper and 2 for Scissor.");
    }


    /*
    * Returns true if user enters 1
    * Returns false if user enters 0
    * Prompts the user again if he enters any other valid integer
    * Returns false if he enters something other than integer
    * */
    public Boolean askContinueToPlay() {

        System.out.print("\nEnter 1 to continue playing, 0 to quit: ");
        Integer playNextGame = 0;

        try {
            playNextGame = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Encountered Exception: " + e);
            scanner.nextLine();
        }

        if(playNextGame != 0 && playNextGame != 1) {
            System.out.println("Please enter a valid choice");
            return askContinueToPlay();
        }

        return playNextGame == 1;
    }
}
