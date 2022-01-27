package com.codurance.academy;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TicTacToShould {
    @Test
    void
    mark_X_in_the_top_left_cell(){
        var game = new TicTacToe();

        String result = game.play(new Point(0, 0));

        assertEquals("""
            X|_|_
            _|_|_
            _|_|_""", result);
    }

    @Test
    void
    mark_X_in_the_bottom_left_cell(){
        var game = new TicTacToe();

        String result = game.play(new Point(1, 0));

        assertEquals("""
            _|X|_
            _|_|_
            _|_|_""", result);
    }

    @Test
    void
    mark_X_in_the_center_cell(){
        var game = new TicTacToe();

        String result = game.play(new Point(2,  0));

        assertEquals("""
            _|_|X
            _|_|_
            _|_|_""", result);
    }

    @Test
    void
    mark_O_in_the_center_right_cell(){
        var game = new TicTacToe();

        game.play(new Point(0, 0));
        String result = game.play(new Point(2, 0));

        assertEquals("""
            X|_|O
            _|_|_
            _|_|_""", result);
    }

    @Test
    void
    mark_O_in_the_center_cell(){
        var game = new TicTacToe();

        game.play(new Point(0, 0));
        String result = game.play(new Point(1, 0));

        assertEquals("""
            X|O|_
            _|_|_
            _|_|_""", result);
    }

    @Test
    void
    mark_all_top_cells(){
        var game = new TicTacToe();

        game.play(new Point(0, 0));
        game.play(new Point(1, 0));
        String result = game.play(new Point(2, 0));

        assertEquals("""
            X|O|X
            _|_|_
            _|_|_""", result);
    }

}
