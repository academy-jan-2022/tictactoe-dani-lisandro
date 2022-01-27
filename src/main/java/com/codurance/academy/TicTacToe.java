package com.codurance.academy;

import java.util.Optional;

import static com.codurance.academy.Token.*;


public class TicTacToe {

    public static final String END_OF_LINE = "\n";
    public static final int END_OF_MATRIX = 2;
    private final MovesList playerMoves = new MovesList();
    private Token currentPlayer = PLAYER_A;

    public String play(Point currentPlay) {
        playerMoves.add(new Move(currentPlay, currentPlayer.token));
        currentPlayer = getNextPlayer();

        return renderMatrix();
    }

    private Token getNextPlayer() {
        return currentPlayer == PLAYER_A ? PLAYER_B : PLAYER_A;
    }

    private String renderMatrix() {
        return renderMatrixRecursive(new Point(0, 0), new StringBuilder());
    }

    private String renderMatrixRecursive(Point point, StringBuilder matrix) {
        matrix.append(getCurrentCellContent(point));
        matrix.append(getSeparator(point.getX()));

        if (isEndOfLine(point) && !isEndOfMatrix(point))
            matrix.append(END_OF_LINE);

        if (point.getX() < END_OF_MATRIX)
            return renderMatrixRecursive(point.moveRight(), matrix);

        if (point.getY() < END_OF_MATRIX)
            return renderMatrixRecursive(point.moveDown(), matrix);

        return matrix.toString();
    }

    private boolean isEndOfMatrix(Point point) {
        return point.getY() == END_OF_MATRIX;
    }

    private boolean isEndOfLine(Point point) {
        return point.getX() == END_OF_MATRIX;
    }

    private String getCurrentCellContent(Point cellPosition) {
        Optional<Move> move = playerMoves.playerMove(cellPosition);
        if (move.isPresent()) {
            return move.get().token();
        }

        return EMPTY.token;
    }

    private String getSeparator(int xIndex) {
        return xIndex < END_OF_MATRIX ? "|" : "";
    }
}
