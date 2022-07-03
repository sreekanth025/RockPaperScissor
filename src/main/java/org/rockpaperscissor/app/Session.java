package org.rockpaperscissor.app;

public class Session {

    private Integer userWins = 0;
    private Integer computerWins = 0;


    public void startSession() {

        Utils.printGameInstructions();

        while (true) {

            Game game = new Game();
            Integer gameResult = game.startGame();

            switch (gameResult) {
                case 1:
                    userWins++;
                    break;

                case 2:
                    computerWins++;
                    break;

                default:
                    // Unreachable
                    break;
            }

            Boolean playNextGame = Utils.askContinueToPlay();

            if(!playNextGame) {
                System.out.println("\nTotal games played: " + Integer.toString(userWins + computerWins));
                System.out.println("You won " + userWins.toString() + " games and Computer won " + computerWins.toString() + " games.");
                return;
            }

        }
    }

}
