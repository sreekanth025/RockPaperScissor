package org.rockpaperscissor.app;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;


class SessionTest {

    @Test
    public void testAskContinueToPlay() {

        InputStream sysInBackup = System.in;
        PrintStream sysOutBackup = System.out;

        ByteArrayInputStream in = new ByteArrayInputStream("0 1 k\r\n".getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        System.setIn(in);
        System.setOut(new PrintStream(out));

        Session session = new Session();
        assertAll(
                () -> assertEquals(false, session.askContinueToPlay()),
                () -> assertEquals(true, session.askContinueToPlay()),
                () -> assertEquals(false, session.askContinueToPlay())
        );

        System.setIn(sysInBackup);
        System.setOut(sysOutBackup);
    }
}