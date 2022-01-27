package com.codurance.academy;

import java.util.Objects;

public class TicTacToe {

    public static final String EMPTY_LINE = "_|_|_";
    public static final String SEPARATOR = "\n";
    private Point previousPlay = null;

    public String play(Point currentPlay) {
        String playLine = buildLine(currentPlay, previousPlay);
        previousPlay = currentPlay;

        return playLine + SEPARATOR + EMPTY_LINE + SEPARATOR + EMPTY_LINE;
    }

    private String buildLine(Point currentPlay, Point previousPlay) {
        StringBuilder line = new StringBuilder();

        for (int xIndex = 0; xIndex < 3; xIndex++) {
            line.append(getCurrentChar(currentPlay, previousPlay, xIndex));
            line.append(getSeparator(xIndex));
        }

        return line.toString();
    }

    private String getCurrentChar(Point currentPlay, Point previousPlay, int xIndex) {
        if (isSamePoint(previousPlay, xIndex)) {
            return "X";
        }
        if (isSamePoint(currentPlay, xIndex)) {
            return previousPlay == null ? "X" : "O";
        }

        return "_";
    }

    private boolean isSamePoint(Point previousPlay, int xIndex) {
        return Objects.equals(previousPlay, new Point(xIndex, 0));
    }

    private String getSeparator(int xIndex) {
        return xIndex < 2 ? "|" : "";
    }
}
