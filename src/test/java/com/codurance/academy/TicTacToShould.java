package com.codurance.academy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TicTacToShould {

    private TicTacToe game;

    @BeforeEach
    void setUp() {
        game = new TicTacToe();
    }

    @Test
    void
    mark_X_in_the_top_left_cell() {
        String result = game.play(new Point(0, 0));

        assertEquals("""
            X|_|_
            _|_|_
            _|_|_""", result);
    }

    @Test
    void
    mark_X_in_the_bottom_left_cell() {
        String result = game.play(new Point(1, 0));

        assertEquals("""
            _|X|_
            _|_|_
            _|_|_""", result);
    }

    @Test
    void
    mark_X_in_the_center_cell() {
        String result = game.play(new Point(2, 0));

        assertEquals("""
            _|_|X
            _|_|_
            _|_|_""", result);
    }

    @Test
    void
    mark_O_in_the_center_right_cell() {
        game.play(new Point(0, 0));
        String result = game.play(new Point(2, 0));

        assertEquals("""
            X|_|O
            _|_|_
            _|_|_""", result);
    }

    @Test
    void
    mark_O_in_the_top_center_cell() {
        game.play(new Point(0, 0));
        String result = game.play(new Point(1, 0));

        assertEquals("""
            X|O|_
            _|_|_
            _|_|_""", result);
    }

    @Test
    void
    mark_all_top_cells() {
        game.play(new Point(0, 0));
        game.play(new Point(1, 0));
        String result = game.play(new Point(2, 0));

        assertEquals("""
            X|O|X
            _|_|_
            _|_|_""", result);
    }

    @Test
    void
    mark_X_in_center_cell() {
        String result = game.play(new Point(1, 1));

        assertEquals("""
            _|_|_
            _|X|_
            _|_|_""", result);
    }

    @Test
    void
    mark_0_in_bottom_right() {
        String result = game.play(new Point(2, 2));

        assertEquals("""
            _|_|_
            _|_|_
            _|_|X""", result);
    }


    @Test
    void
    mark_all_center_cells() {
        game.play(new Point(0,1));
        game.play(new Point(1,1));
        String result = game.play(new Point(2, 1));

        assertEquals("""
            _|_|_
            X|O|X
            _|_|_""", result);
    }

    @Test
    void
    mark_all_bottom_cells() {
        game.play(new Point(0,2));
        game.play(new Point(1,2));
        String result = game.play(new Point(2, 2));

        assertEquals("""
            _|_|_
            _|_|_
            X|O|X""", result);
    }

    @Test
    void mark_tie_game() {

        game.play(new Point(0,0));
        game.play(new Point(1,0));
        game.play(new Point(0,1));
        game.play(new Point(0,2));

        game.play(new Point(1,2));
        game.play(new Point(1,1));
        game.play(new Point(2,0));
        game.play(new Point(2,2));
        String result = game.play(new Point(2, 1));

        assertEquals("""
            X|O|X
            X|O|X
            O|X|O""", result);
    }


    @Test
    void
    not_allow_to_keep_playing_after_row_win() {
        game.play(new Point(0,0));
        game.play(new Point(0,1));
        game.play(new Point(1,0));
        game.play(new Point(0,2));
        var result = game.play(new Point(2,0));

        assertEquals("""
            X|X|X
            O|_|_
            O|_|_""", result);
    }
}
