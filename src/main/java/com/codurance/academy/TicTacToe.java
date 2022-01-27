package com.codurance.academy;

import java.util.Optional;

import static com.codurance.academy.Token.*;


public class TicTacToe {

    public static final String EMPTY_LINE = "_|_|_";
    public static final String SEPARATOR = "\n";
    private final MovesList playerMoves = new MovesList();
    private Token currentPlayer = PLAYER_A;

    public String play(Point currentPlay) {
        playerMoves.add(new Move(currentPlay,currentPlayer.token));
        currentPlayer = getNextPlayer();



        return buildLine(0) + SEPARATOR + buildLine(1) + SEPARATOR + EMPTY_LINE;
    }

    private Token getNextPlayer() {
        return currentPlayer == PLAYER_A ? PLAYER_B : PLAYER_A;
    }

    private String buildLine(int yIndex) {
        StringBuilder line = new StringBuilder();

        for (int xIndex = 0; xIndex < 3; xIndex++) {
            line.append(getCurrentCellContent(new Point(xIndex, yIndex)));
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

    private String getSeparator(int xIndex) {
        return xIndex < 2 ? "|" : "";
    }
}
