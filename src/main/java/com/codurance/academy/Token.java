package com.codurance.academy;

public enum Token {
    PLAYER_A("X"), PLAYER_B("O"), EMPTY("_");

    public final String token;

    Token(String token) {

        this.token = token;
    }
}
