package com.codurance.academy;

public enum Cell {
    PLAYER_A("X"), PLAYER_B("O"), EMPTY("_");

    public final String token;

    Cell(String token) {

        this.token = token;
    }
}
