package com.codurance.academy;

import java.util.Objects;

public class TicTacToe {

    public static final String EMPTY_LINE = "_|_|_";
    public static final String SEPARATOR = "\n";
    private Plays plays = new Plays();


    public String play(Point currentPlay) {
        plays = plays.updateCurrent(currentPlay);

        String playLine = buildLine();

        plays = plays.updatePrevious(currentPlay);

        return playLine + SEPARATOR + EMPTY_LINE + SEPARATOR + EMPTY_LINE;
    }

    private String buildLine() {
        StringBuilder line = new StringBuilder();

        for (int xIndex = 0; xIndex < 3; xIndex++) {
            line.append(getCurrentChar(xIndex));
            line.append(getSeparator(xIndex));
        }

        return line.toString();
    }


    private String getCurrentChar(int xIndex) {
        if (plays.isPreviousSamePoint(new Point(xIndex,0))) {
            return "X";
        }
        if (plays.isCurrentSamePoint(new Point(xIndex,0))) {
            return plays.hasPreviousPlay() ? "O" : "X";
        }

        return "_";
    }

    private String getSeparator(int xIndex) {
        return xIndex < 2 ? "|" : "";
    }
}
