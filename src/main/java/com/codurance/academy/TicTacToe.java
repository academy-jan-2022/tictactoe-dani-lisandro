package com.codurance.academy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static com.codurance.academy.Cell.*;


public class TicTacToe {

    private record Move(Point point, String token){};

    public static final String EMPTY_LINE = "_|_|_";
    public static final String SEPARATOR = "\n";
    private final List<Move> playerMoves2 = new ArrayList<>();
    private boolean isX = true;

    public String play(Point currentPlay) {
        playerMoves2.add(new Move(currentPlay,getPlayerToken()));

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
        Optional<Move> move = playerMove(cellPosition);
        if (move.isPresent()) {
            return move.get().token;
        }

        return EMPTY.token;
    }


    private Optional<Move> playerMove(Point cellPosition) {
        return playerMoves2.stream()
            .filter(playerMove -> isSamePoint(playerMove.point, cellPosition))
            .findFirst();
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
