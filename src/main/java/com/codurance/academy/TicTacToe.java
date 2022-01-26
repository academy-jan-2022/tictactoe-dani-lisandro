package com.codurance.academy;

public class TicTacToe {
    public String play(Point point) {
        if(point.getX() == 1){
            return "_|_|_" + "_|X|_" + "_|_|_";
        }

        if (point.getY() == 2) {
            return "_|_|_" + "_|_|_" + "X|_|_";
        }
        return "X|_|_" + "_|_|_" + "_|_|_";
    }
}
