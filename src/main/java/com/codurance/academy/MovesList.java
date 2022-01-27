package com.codurance.academy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class MovesList {
    private List<Move> moves = new ArrayList();

    public void add(Move move){
        moves.add(move);
    }

    public Optional<Move> playerMove(Point cellPosition) {
        return moves.stream()
            .filter(playerMove -> isSamePoint(playerMove.point(), cellPosition)).findFirst();
    }


    private boolean isSamePoint(Point previousPlay, Point xIndex) {
        return Objects.equals(previousPlay, xIndex);
    }
}
