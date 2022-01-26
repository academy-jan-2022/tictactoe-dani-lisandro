package com.codurance.academy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TicTacToShould {
    @Test public void
    place_X_first(){
        var game = new TicTacToe();

        String result = game.play(0, 0);

        assertEquals("X|_|_" +
            "_|_|_"+
            "_|_|_", result);
    }
}
