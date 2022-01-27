package com.codurance.academy;

import java.util.Objects;

public class TicTacToe {

    public static final String EMPTY_LINE = "_|_|_";
    public static final String SEPARATOR = "\n";
    private Point previousPlay = null;

    public String play(Point point) {
        String playLine = buildLine(point, previousPlay);
        previousPlay = point;

        return playLine + SEPARATOR + EMPTY_LINE + SEPARATOR + EMPTY_LINE;
    }

    private String buildLine(Point point, Point previousPlay) {
        StringBuilder line = new StringBuilder();

        for (int xIndex = 0; xIndex < 3; xIndex++) {
            if (Objects.equals(previousPlay, new Point(xIndex, 0))) {
                line.append("X");
            } else if (Objects.equals(point, new Point(xIndex, 0))) {
                line.append(previousPlay == null ? "X" : "O");
            } else {
                line.append("_");
            }

            line.append(getSeparator(xIndex));
        }

        return line.toString();

    }

    private String getSeparator(int xIndex) {
        return xIndex < 2 ? "|" : "";
    }

}
