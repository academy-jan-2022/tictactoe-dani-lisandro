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
        line.append("\n");

        if(point.getX() == 1){
            return "_|_|_\n" + line + "_|_|_";
        }

        if (point.getY() == 2) {
            return "_|_|_\n" + "_|_|_\n" + "X|_|_";
        }
        return "X|_|_\n" + "_|_|_\n" + "_|_|_";
    }
}
