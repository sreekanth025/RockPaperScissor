package org.rockpaperscissor.app;

import java.util.Scanner;

public class Session {

    private Integer userWins = 0;
    private Integer computerWins = 0;
    private Scanner scanner = new Scanner(System.in);

    public void startSession() {

        printGameInstructions();

        while (true) {

            Game game = new Game();
            Integer gameResult = game.startGame();

            if(gameResult == 1) userWins++;
            else computerWins++;                // gameResult == 2

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


    public Boolean askContinueToPlay() {

        System.out.print("\nEnter 1 to continue playing, 0 to quit: ");
        Integer playNextGame = scanner.nextInt();

        if(playNextGame != 0 && playNextGame != 1) {
            System.out.println("Please enter a valid choice");
            return askContinueToPlay();
        }

        return playNextGame == 1 ? true : false;
    }
}
