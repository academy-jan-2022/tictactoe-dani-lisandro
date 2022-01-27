package com.codurance.academy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static com.codurance.academy.Token.PLAYER_A;

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

    public boolean winner() {
        int rowMoves = 0;

        for(int i = 0; i< 3; i++){
            var allXPlayerMoves = moves.stream().filter(playerMove -> playerMove.token().equals(PLAYER_A.token)).map(move -> move.point()).toList();
            var move = new Point(i, 0);

            if(allXPlayerMoves.contains(move)) rowMoves++;
        }

        return rowMoves == 3;

    }
}
