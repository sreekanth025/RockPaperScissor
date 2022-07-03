package org.rockpaperscissor.app;

public class Game {

    private Integer numMoves = 0;

    public Integer startGame() {

        System.out.println("\nThe game has started.");

        while (true) {

            Move userMove = Utils.takeUserInput();
            Move computerMove = Utils.randomMoveGenerator();

            System.out.println("Your move:      " + userMove);
            System.out.println("Computer Move:  " + computerMove);
            numMoves++;
            Integer gameResult = checkWinner(userMove, computerMove);

            switch (gameResult) {

                case 1:
                    System.out.println("\nYou won the game !!!");
                    System.out.println("Game finished in " + numMoves.toString() + " moves.");
                    return 1;

                case 2:
                    System.out.println("\nComputer won the game !");
                    System.out.println("Game finished in " + numMoves.toString() + " moves.");
                    return 2;

                default:
                    // Case 0: Continue the game
                    break;
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

}
