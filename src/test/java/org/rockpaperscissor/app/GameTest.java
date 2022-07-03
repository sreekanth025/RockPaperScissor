package org.rockpaperscissor.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    private Game game;


    @BeforeEach
    void initEach() {
        game = new Game();
    }

    @Test
    void testCheckWinner() {
        System.out.println("This test ran");
        assertAll(
                () -> assertEquals(0, game.checkWinner(Move.PAPER, Move.PAPER)),
                () -> assertEquals(1, game.checkWinner(Move.PAPER, Move.ROCK)),
                () -> assertEquals(2, game.checkWinner(Move.PAPER, Move.SCISSOR)),
                () -> assertEquals(2, game.checkWinner(Move.ROCK, Move.PAPER)),
                () -> assertEquals(0, game.checkWinner(Move.ROCK, Move.ROCK)),
                () -> assertEquals(1, game.checkWinner(Move.ROCK, Move.SCISSOR)),
                () -> assertEquals(1, game.checkWinner(Move.SCISSOR, Move.PAPER)),
                () -> assertEquals(2, game.checkWinner(Move.SCISSOR, Move.ROCK)),
                () -> assertEquals(0, game.checkWinner(Move.SCISSOR, Move.SCISSOR))
        );
    }
}