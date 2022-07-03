package org.rockpaperscissor.app;

import java.util.Random;
import java.util.Scanner;

public class Utils {

    private static final Move[] MOVES = Move.values();
    private static Scanner scanner = new Scanner(System.in);


    public static Move randomMoveGenerator() {
        return MOVES[new Random().nextInt(3)];
    }


    public static void printGameInstructions() {
        System.out.println("Instructions for playing the game: enter 0 for Rock, 1 for Paper and 2 for Scissor.");
    }


    public static Move takeUserInput() {
        System.out.print("\nEnter your choice: ");
        Integer userMove = scanner.nextInt();

        if(userMove < 0 || userMove > 2) {
            System.out.println("Please enter a valid choice");
            return takeUserInput();
        }

        return MOVES[userMove];
    }

    public static Boolean askContinueToPlay() {

        System.out.print("\nEnter 1 to continue playing, 0 to quit: ");
        Integer playNextGame = scanner.nextInt();


        if(playNextGame != 0 && playNextGame != 1) {
            System.out.println("Please enter a valid choice");
            return askContinueToPlay();
        }

        return playNextGame == 1 ? true : false;
    }
}
