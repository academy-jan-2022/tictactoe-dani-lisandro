package com.codurance.academy;

public class TicTacToe {
    public String play(Point point) {
        StringBuilder line = buildLine(point);

        if(point.getX() == 1){
            return "_|_|_\n" + line + "_|_|_";
        }

        if (point.getY() == 2) {
            return "_|_|_\n" + "_|_|_\n" + "X|_|_";
        }
        return "X|_|_\n" + "_|_|_\n" + "_|_|_";
    }

    private StringBuilder buildLine(Point point) {
        StringBuilder line = new StringBuilder();

        for(int xIndex = 0; xIndex < 3; xIndex++){
            line.append(getCellMarker(point, xIndex));
            line.append(getSeparator(xIndex));
        }
        line.append("\n");

        return line;
    }

    private String getSeparator(int xIndex) {
        return xIndex < 2 ? "|" : "";
    }

    private String getCellMarker(Point point, int xIndex) {
        return xIndex == point.getX() ? "X" : "_";
    }
}
