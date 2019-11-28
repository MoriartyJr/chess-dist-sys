package com.chess.model.pieces;

public abstract class Piece {
    private String Name;
    private String Color;
    private int[] Position = new int[2];

    public Piece( int rack, int file, String color) {
        this.Color = color;
        this.Position[0] = rack;
        this.Position[1] = file;
    }

    public abstract boolean isInMoveSet(int[] destination, Piece[][] tiles);

    public abstract void move(int[] destination);

    @Override
    public abstract String toString();

    public String getColor() { return this.Color; }

    public void setPosition(int[] position) {
        Position = position;
    }

    public int[] getPosition() {
        return Position;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}