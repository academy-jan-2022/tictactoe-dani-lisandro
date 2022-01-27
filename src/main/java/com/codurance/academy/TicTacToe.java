package com.codurance.academy;

import java.util.Optional;
import java.util.stream.IntStream;

import static com.codurance.academy.Token.*;


public class TicTacToe {

    public static final String EMPTY_LINE = "_|_|_";
    public static final String END_OF_LINE = "\n";
    private final MovesList playerMoves = new MovesList();
    private Token currentPlayer = PLAYER_A;

    public String play(Point currentPlay) {
        playerMoves.add(new Move(currentPlay,currentPlayer.token));
        currentPlayer = getNextPlayer();

        return renderMatrix();
    }

    private Token getNextPlayer() {
        return currentPlayer == PLAYER_A ? PLAYER_B : PLAYER_A;
    }

    private String renderMatrix() {
        StringBuilder matrix = new StringBuilder();

        for(int yIndex = 0; yIndex < 3; yIndex++){
            for (int xIndex = 0; xIndex < 3; xIndex++) {
                matrix.append(getCurrentCellContent(new Point(xIndex, yIndex)));
                matrix.append(getSeparator(xIndex));
            }
            if(yIndex < 2)
                matrix.append(END_OF_LINE);
        }

        return matrix.toString();
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
