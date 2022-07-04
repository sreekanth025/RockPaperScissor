package org.rockpaperscissor.app;

import java.util.Random;
import java.util.Scanner;

public class Game {

    private static final Move[] MOVES = Move.values();
    private static final Random RANDOM = new Random();
    private Scanner scanner = new Scanner(System.in);
    private Integer numMoves = 0;


    public Integer startGame() {

        System.out.println("\nThe game has started.");

        while (true) {

            Move userMove = takeUserInput();
            Move computerMove = randomMoveGenerator();

            System.out.println("Your move:      " + userMove);
            System.out.println("Computer Move:  " + computerMove);
            numMoves++;
            Integer gameResult = checkWinner(userMove, computerMove);

            if(gameResult == 1) {
                System.out.println("\nYou won the game !!!");
                System.out.println("Game finished in " + numMoves + " moves.");
                return 1;
            }
            else { // gameResult == 2
                System.out.println("\nComputer won the game !");
                System.out.println("Game finished in " + numMoves + " moves.");
                return 2;
            }
        }
    }


    /*
     * Returns 1 if user wins
     * Returns 2 if computer wins
     * Returns 0 otherwise
     * */
    public Integer checkWinner(Move userMove, Move computerMove) {

        if(userMove == Move.SCISSOR && computerMove == Move.PAPER) return 1;
        if(userMove == Move.PAPER && computerMove == Move.SCISSOR) return 2;

        if(userMove == Move.ROCK && computerMove == Move.SCISSOR) return 1;
        if(userMove == Move.SCISSOR && computerMove == Move.ROCK) return 2;

        if(userMove == Move.PAPER && computerMove == Move.ROCK) return 1;
        if(userMove == Move.ROCK && computerMove == Move.PAPER) return 2;

        return 0;
    }


    public Move randomMoveGenerator() {
        return MOVES[RANDOM.nextInt(3)];
    }


    public Move takeUserInput() {
        System.out.print("\nEnter your choice: ");
        Integer userMove = 0;

        try{
            userMove = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Encountered Exception: " + e);
            scanner.nextLine();
            System.exit(1);
        }

        if(userMove < 0 || userMove > 2) {
            System.out.println("Please enter a valid choice");
            return takeUserInput();
        }

        return MOVES[userMove];
    }
}
