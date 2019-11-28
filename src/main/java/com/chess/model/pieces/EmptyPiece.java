package com.chess.model.pieces;

public class EmptyPiece extends Piece {

    public EmptyPiece(int rack, int file, String color) {
        super(rack, file, color);
        setName("Empty");
    }

    @Override
    public boolean isInMoveSet(int[] destination, Piece[][] tiles) {
        return false;
    }

    @Override
    public void move(int[] destination) {

    }

    @Override
    public String toString() {
        return "[ ]";
    }
}
