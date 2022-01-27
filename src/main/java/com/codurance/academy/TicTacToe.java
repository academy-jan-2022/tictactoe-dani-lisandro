package com.codurance.academy;

import java.util.Objects;

public class TicTacToe {

    public static final String EMPTY_LINE = "_|_|_";
    public static final String SEPARATOR = "\n";
    private Point previousPlay = null;
    private Point previousPreviousPlay = null;

    public String play(Point currentPlay) {
        String playLine = buildLine(currentPlay);
        previousPreviousPlay = previousPlay;
        previousPlay = currentPlay;


        return playLine + SEPARATOR + EMPTY_LINE + SEPARATOR + EMPTY_LINE;
    }

    private String buildLine(Point currentPlay) {
        StringBuilder line = new StringBuilder();

        for (int xIndex = 0; xIndex < 3; xIndex++) {
            line.append(getCurrentChar(currentPlay, new Point(xIndex, 0)));
            line.append(getSeparator(xIndex));
        }

        return line.toString();
    }

    private String getCurrentChar(Point currentPlay, Point xIndex) {
        if (isSamePoint(previousPreviousPlay, xIndex)) {
            return "X";
        }

        if (isSamePoint(previousPlay, xIndex)) {
            return previousPreviousPlay == null ? "X" : "O";
        }

        if (isSamePoint(currentPlay, xIndex)) {
            if(previousPreviousPlay != null){
                return "X";
            }
            return previousPlay == null ? "X" : "O";
        }

        return "_";
    }

    private boolean isSamePoint(Point previousPlay, Point xIndex) {
        return Objects.equals(previousPlay, xIndex);
    }

    private String getSeparator(int xIndex) {
        return xIndex < 2 ? "|" : "";
    }
}
