package com.codurance.academy;

public class TicTacToe {
    public String play(Point point) {
        StringBuilder line = new StringBuilder();
        for(int xIndex = 0; xIndex < 3; xIndex++){
            if(xIndex == point.getX()){
                line.append("X");
            }else{
                line.append("_");
            }

            if(xIndex < 2){
                line.append("|");
            }
        }

        if(point.getX() == 1){
            return "_|_|_" + line + "_|_|_";
        }

        if (point.getY() == 2) {
            return "_|_|_" + "_|_|_" + "X|_|_";
        }
        return "X|_|_" + "_|_|_" + "_|_|_";
    }
}
