package com.codurance.academy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static com.codurance.academy.Cell.*;


public class TicTacToe {

    public static final String EMPTY_LINE = "_|_|_";
    public static final String SEPARATOR = "\n";
    private final MovesList playerMoves = new MovesList();
    private boolean isX = true;

    public String play(Point currentPlay) {
        playerMoves.add(new Move(currentPlay,getPlayerToken()));

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
        Optional<Move> move = playerMoves.playerMove(cellPosition);
        if (move.isPresent()) {
            return move.get().token();
        }

        return EMPTY.token;
    }

    private String getPlayerToken() {
        String result = isX ? PLAYER_A.token : PLAYER_B.token;
        isX = !isX;
        return result;
    }

    private String getSeparator(int xIndex) {
        return xIndex < 2 ? "|" : "";
    }
}
