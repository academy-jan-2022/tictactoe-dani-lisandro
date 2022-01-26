package com.codurance.academy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TicTacToShould {
    @Test public void
    mark_X_in_the_top_left_cell(){
        var game = new TicTacToe();

        String result = game.play(0, 0);

        assertEquals("X|_|_" +
            "_|_|_"+
            "_|_|_", result);
    }
}
