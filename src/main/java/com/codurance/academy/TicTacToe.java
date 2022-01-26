package com.codurance.academy;

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
            if (previousPlay == null) {
                line.append(getCellMarkerX(point, xIndex));
            } else {
                line.append(getCellMarkerO(point, xIndex));
                line.append(getCellMarkerX(previousPlay, xIndex));
            }
                line.append(getSeparator(xIndex));
        }


        return line.toString().replace("|","|_");
    }

    private String getSeparator(int xIndex) {
        return xIndex < 2 ? "|" : "";
    }

    private String getCellMarkerX(Point point, int xIndex) {
        return xIndex == point.getX() ? "X" : "";
    }

    private String getCellMarkerO(Point point, int xIndex) {
        return xIndex == point.getX() ? "O" : "";
    }

}
