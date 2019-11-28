package com.chess.model;

public class Move {
    private int origin;
    private int destiny;

    public Move(int origin, int destiny) {
        this.origin = origin;
        this.destiny = destiny;
    }

    public int getOrigin() {
        return origin;
    }

    public int getDestiny() {
        return destiny;
    }
}