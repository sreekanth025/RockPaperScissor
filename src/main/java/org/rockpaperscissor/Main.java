package org.rockpaperscissor;

import org.rockpaperscissor.app.Session;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to Rock Paper Scissor Game !");

        Session session = new Session();
        session.startSession();

        System.out.println("Closing the session, Thank you for playing..");
    }
}
