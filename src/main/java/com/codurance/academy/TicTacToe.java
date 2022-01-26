package com.codurance.academy;

public class TicTacToe {

    public static final String EMPTY_LINE = "_|_|_";

    public String play(Point point) {
        return buildMatrix(point);
    }

    private String buildMatrix(Point point) {
        StringBuilder matrix = new StringBuilder();

        for (int yIndex = 0; yIndex < 3; yIndex++) {
            matrix.append(getLine(point, yIndex));

            matrix.append(getEndOfLine(yIndex));
        }

        return matrix.toString();
    }

    private String getEndOfLine(int yIndex) {
        return yIndex < 2 ? "\n" : "";
    }

    private String getLine(Point point, int yIndex) {
        return yIndex == point.getY() ? buildLine(point) : EMPTY_LINE;
    }

    private String buildLine(Point point) {
        StringBuilder line = new StringBuilder();

        for (int xIndex = 0; xIndex < 3; xIndex++) {
            line.append(getCellMarker(point, xIndex));
            line.append(getSeparator(xIndex));
        }

        return line.toString();
    }

    private String getSeparator(int xIndex) {
        return xIndex < 2 ? "|" : "";
    }

    private String getCellMarker(Point point, int xIndex) {
        return xIndex == point.getX() ? "X" : "_";
    }
}
