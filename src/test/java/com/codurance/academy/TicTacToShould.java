package com.codurance.academy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TicTacToShould {
    @Test
    void
    mark_X_in_the_top_left_cell(){
        var game = new TicTacToe();

        String result = game.play(new Point(0, 0));

        assertEquals("X|_|_\n" +
            "_|_|_\n"+
            "_|_|_", result);
    }

    @Test
    void
    mark_X_in_the_bottom_left_cell(){
        var game = new TicTacToe();

        String result = game.play(new Point(0, 2));

        assertEquals("_|_|_\n" +
            "_|_|_\n"+
            "X|_|_", result);
    }


    @Test
    void
    mark_X_in_the_center_cell(){
        var game = new TicTacToe();

        String result = game.play(new Point(1, 1));

        assertEquals("_|_|_\n" +
            "_|X|_\n"+
            "_|_|_", result);
    }
}
