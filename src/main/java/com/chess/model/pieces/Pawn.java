package com.chess.model.pieces;

public class Pawn extends Piece {
    private int pid;
    private int moved = 0;

    public Pawn(int rack, int file, String color, int id) {
        super(rack, file, color);
        this.pid = id;
        setName("Pawn");
    }

    @Override
    public boolean isInMoveSet(int[] destination, Piece[][] tiles) {
        for (int[] tile: moveTiles(tiles)) {
            if (tile[0] == destination[0] && tile[1] == destination[1] ) {
                return true;
            }
        }
        for (int[] tile: attackTiles(tiles)) {
            if (tile[0] == destination[0] && tile[1] == destination[1] ) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void move(int[] destination) {
        this.setPosition(destination);
        this.moved++;
    }

    @Override
    public String toString() {
        return "[P]";
    }

    private int[][] moveTiles(Piece[][] gameTiles) {
        int[][] tiles = new int[1][2];

        if (moved <= 0) {
            return firstMoveTiles(gameTiles);
        }
        else {
            if (this.getColor().equals("Red")) {
                if (gameTiles[getPosition()[0] + 1][getPosition()[1]].getColor().equals("")) {
                    tiles[0][0] = getPosition()[0] + 1;
                    tiles[0][1] = getPosition()[1];
                }
            }
            else {
                if (gameTiles[getPosition()[0] - 1][getPosition()[1]].getColor().equals("")) {
                    tiles[0][0] = getPosition()[0] - 1;
                    tiles[0][1] = getPosition()[1];
                }
            }
            return tiles;
        }
    }

    private int[][] firstMoveTiles(Piece[][] gameTiles) {
        int[][] tiles = new int[2][2];

        if (this.getColor().equals("Red")) {
            if (this.getPosition()[0] == 7) {
                return tiles;
            }
            if (!gameTiles[getPosition()[0] + 1][getPosition()[1]].getColor().equals("")) {
                return tiles;
            }
            if (gameTiles[getPosition()[0] + 1][getPosition()[1]].getColor().equals("")) {
                tiles[0][0] = getPosition()[0] + 1;
                tiles[0][1] = getPosition()[1];
            }
            if (gameTiles[getPosition()[0] + 2][getPosition()[1]].getColor().equals("")) {
                tiles[1][0] = getPosition()[0] + 2;
                tiles[1][1] = getPosition()[1];
            }
        }
        else {
            if (this.getPosition()[0] == 0) {
                return tiles;
            }
            if (!gameTiles[getPosition()[0] - 1][getPosition()[1]].getColor().equals("")) {
                return tiles;
            }
            if (gameTiles[getPosition()[0] - 1][getPosition()[1]].getColor().equals("")) {
                tiles[0][0] = getPosition()[0] - 1;
                tiles[0][1] = getPosition()[1];
            }
            if (gameTiles[getPosition()[0] - 2][getPosition()[1]].getColor().equals("")) {
                tiles[1][0] = getPosition()[0] - 2;
                tiles[1][1] = getPosition()[1];
            }
        }

        return tiles;
    }

    public int[][] attackTiles(Piece[][] gameTiles) {
        int[][] tiles = new int[2][2];

        if (this.getColor().equals("Red")) {
            if (this.getPosition()[0] == 7) {
                return tiles;
            }
            if (getPosition()[1] < 7) {
                if (!gameTiles[getPosition()[0] + 1][getPosition()[1] + 1].getName().equals("Empty")) {
                    tiles[0][0] = getPosition()[0] + 1;
                    tiles[0][1] = getPosition()[1] + 1;
                }
            }
            if (getPosition()[1] > 0) {
                if (!gameTiles[getPosition()[0] + 1][getPosition()[1] - 1].getName().equals("Empty")) {
                    tiles[1][0] = getPosition()[0] + 1;
                    tiles[1][1] = getPosition()[1] - 1;
                }
            }
        }
        else {
            if (this.getPosition()[0] == 0) {
                return tiles;
            }
            if (getPosition()[1] < 7) {
                if (!gameTiles[getPosition()[0] - 1][getPosition()[1] + 1].getName().equals("Empty")) {
                    tiles[0][0] = getPosition()[0] - 1;
                    tiles[0][1] = getPosition()[1] + 1;
            }
        }
            if (getPosition()[1] > 0) {
                if (!gameTiles[getPosition()[0] - 1][getPosition()[1] - 1].getName().equals("Empty")) {
                    tiles[1][0] = getPosition()[0] - 1;
                    tiles[1][1] = getPosition()[1] - 1;
                }
            }
        }

        return tiles;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }
}
