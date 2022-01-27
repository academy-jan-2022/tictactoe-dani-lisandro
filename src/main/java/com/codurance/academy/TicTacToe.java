package com.codurance.academy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static com.codurance.academy.TicTacToe.Cell.*;


public class TicTacToe {

    public enum Cell {
        PLAYER_A("X"), PLAYER_B("O"), EMPTY("_");

        private final String token;

        Cell(String token) {

            this.token = token;
        }
    }

    public static final String EMPTY_LINE = "_|_|_";
    public static final String SEPARATOR = "\n";
    private final List<Point> playerMoves = new ArrayList<>();
    private boolean isX = false;

    public String play(Point currentPlay) {
        playerMoves.add(currentPlay);

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

    private String getCurrentCellContent(Point cellPosition) {

        Optional<Point> playerMoveFound = playerMoves.stream()
            .filter(playerMove -> isSamePoint(playerMove, cellPosition))
            .findFirst();

        if (playerMoveFound.isPresent()) {
            return getPlayerToken();
        }

        return EMPTY.token;
    }

    private String getPlayerToken() {
        String result = isX ? PLAYER_A.token : PLAYER_B.token;
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
