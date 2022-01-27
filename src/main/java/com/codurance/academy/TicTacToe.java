package com.codurance.academy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TicTacToe {

    public static final String EMPTY_LINE = "_|_|_";
    public static final String SEPARATOR = "\n";
    private final List<Point> plays = new ArrayList<>();
    private boolean isX = false;

    public String play(Point currentPlay) {
        plays.add(currentPlay);

        String playLine = buildLine();

        return playLine + SEPARATOR + EMPTY_LINE + SEPARATOR + EMPTY_LINE;
    }

    private String buildLine() {
        StringBuilder line = new StringBuilder();

        for (int xIndex = 0; xIndex < 3; xIndex++) {
            line.append(getCurrentCellContent(new Point(xIndex, 0)));
            line.append(getSeparator(xIndex));
        }

        return line.toString();
    }

    private String getCurrentCellContent(Point xIndex) {
        String currentChar = "_";

        for(Point point : plays){
            currentChar = getCellContent(xIndex, currentChar, point);
        }

        return currentChar;
    }

    private String getCellContent(Point xIndex, String currentChar, Point i) {
        if(isSamePoint(i, xIndex)){
            return getPlayer();
        }

        return currentChar;
    }

    private String getPlayer() {
        String result = isX ? "X" : "O";
        isX = !isX;
        return result;
    }

    private boolean isSamePoint(Point previousPlay, Point xIndex) {
        return Objects.equals(previousPlay, xIndex);
    }

    private String getSeparator(int xIndex) {
        return xIndex < 2 ? "|" : "";
    }
}
