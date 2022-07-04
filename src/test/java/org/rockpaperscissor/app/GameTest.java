package org.rockpaperscissor.app;

import com.ginsberg.junit.exit.ExpectSystemExitWithStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    private Game game;

    @BeforeEach
    public void initEach() {
        game = new Game();
    }


    @Test
    public void testCheckWinner() {

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


    @Test
    public void testStartGame1() {

        Game mockGame = Mockito.spy(game);

        //  Mocking userMove - ROCK
        Mockito.doReturn(Move.ROCK).when(mockGame).takeUserInput();

        //  Mocking computerMove - SCISSOR
        Mockito.doReturn(Move.SCISSOR).when(mockGame).randomMoveGenerator();

        assertEquals(1, mockGame.startGame());
    }


    @Test
    public void testStartGame2() {

        Game mockGame = Mockito.spy(game);

        // Mocking userMove sequence - ROCK, SCISSOR, PAPER
        Mockito.doReturn(Move.ROCK, Move.SCISSOR, Move.PAPER)
                .when(mockGame).takeUserInput();

        // Mocking computerMove sequence - ROCK, SCISSOR, ROCK
        Mockito.doReturn(Move.ROCK, Move.SCISSOR, Move.ROCK)
                .when(mockGame).randomMoveGenerator();

        assertEquals(2, mockGame.startGame());
    }


    /*
    * Testing application behaviour with valid inputs
    * */
    @Test
    public void testTakeUserInput1() {

        InputStream sysInBackup = System.in;
        PrintStream sysOutBackup = System.out;

        ByteArrayInputStream in = new ByteArrayInputStream("0 1 2\r\n".getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        System.setIn(in);
        System.setOut(new PrintStream(out));

        Game game1 = new Game();
        assertAll(
                () -> assertEquals(Move.ROCK, game1.takeUserInput()),
                () -> assertEquals(Move.PAPER, game1.takeUserInput()),
                () -> assertEquals(Move.SCISSOR, game1.takeUserInput())
        );

        System.setIn(sysInBackup);
        System.setOut(sysOutBackup);
    }


    /*
    * Testing application response to invalid input
    * */
    @Test
    @ExpectSystemExitWithStatus(1)
    public void testTakeUserInput2() {

        InputStream sysInBackup = System.in;
        PrintStream sysOutBackup = System.out;

        ByteArrayInputStream in = new ByteArrayInputStream("k\r\n".getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        System.setIn(in);
        System.setOut(new PrintStream(out));

        Game game1 = new Game();
        game1.takeUserInput();

        System.setIn(sysInBackup);
        System.setOut(sysOutBackup);
    }
}