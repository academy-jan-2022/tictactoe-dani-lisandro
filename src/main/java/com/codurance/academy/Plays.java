package com.codurance.academy;

import java.util.Objects;

class Plays {
    private Point currentPlay;
    private Point previousPlay;

    public Plays(){};

    private Plays(Point currentPlay, Point previousPlay) {
        this.currentPlay = currentPlay;
        this.previousPlay = previousPlay;
    }

    public Plays updateCurrent(Point play) {
        return new Plays(play, previousPlay);
    }

    public Plays updatePrevious(Point play) {
        return new Plays(currentPlay, play);
    }

    public boolean isCurrentSamePoint(Point point) {
        return currentPlay.equals(point);
    }


    public boolean isPreviousSamePoint(Point point) {
        return Objects.equals(previousPlay,point);
    }

    public boolean hasPreviousPlay() {
        return previousPlay != null;
    }
}
