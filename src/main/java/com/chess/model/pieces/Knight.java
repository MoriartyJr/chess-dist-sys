package com.chess.model.pieces;

public class Knight extends Piece {
    private int kid;

    public Knight(int rack, int file, String color, int id) {
        super(rack, file, color);
        this.kid = id;
        setName("Knight");
    }

    @Override
    public boolean isInMoveSet(int[] destination, Piece[][] tiles) {
        for (int[] tile: moveTiles(tiles)) {
            if (tile[0] == destination[0] && tile[1] == destination[1] ) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void move(int[] destination) {
        this.setPosition(destination);
    }

    @Override
    public String toString() {
        return "[k]";
    }

    private int[][] moveTiles(Piece[][] gameTiles) {
        int[][] tiles = initMoveTiles();
        int posX = this.getPosition()[0];
        int posY = this.getPosition()[1];

        if (this.getColor().equals("Red")) {

            if (posX + 1 <= 7 && posY + 2 <= 7) {
                this.fillMoveTiles(gameTiles, tiles, 0, posX + 1, posY + 2, "Red");
            }

            if (posX + 1 <= 7 && posY - 2 >= 0) {
                this.fillMoveTiles(gameTiles, tiles, 1, posX + 1, posY - 2, "Red");
            }

            if (posX - 1 >= 0 && posY + 2 <= 7) {
                this.fillMoveTiles(gameTiles, tiles, 2, posX - 1, posY + 2, "Red");
            }

            if (posX - 1 >= 0 && posY - 2 >= 0) {
                this.fillMoveTiles(gameTiles, tiles, 3, posX - 1, posY - 2, "Red");
            }

            if (posX + 2 <= 7 && posY + 1 <= 7) {
                this.fillMoveTiles(gameTiles, tiles, 4, posX + 2, posY + 1, "Red");
            }

            if (posX + 2 <= 7 && posY - 1 >= 0) {
                this.fillMoveTiles(gameTiles, tiles, 5, posX + 2, posY - 1, "Red");
            }

            if (posX - 2 >= 0 && posY + 1 <= 7) {
                this.fillMoveTiles(gameTiles, tiles, 6, posX - 2, posY + 1, "Red");
            }

            if (posX - 2 >= 0 && posY - 1 >= 0) {
                this.fillMoveTiles(gameTiles, tiles, 7, posX - 2, posY - 1, "Red");
            }
        }
        else {
            if (posX + 1 <= 7 && posY + 2 <= 7) {
                this.fillMoveTiles(gameTiles, tiles, 0, posX + 1, posY + 2, "Blue");
            }

            if (posX + 1 <= 7 && posY - 2 >= 0) {
                this.fillMoveTiles(gameTiles, tiles, 1, posX + 1, posY - 2, "Blue");
            }

            if (posX - 1 >= 0 && posY + 2 <= 7) {
                this.fillMoveTiles(gameTiles, tiles, 2, posX - 1, posY + 2, "Blue");
            }

            if (posX - 1 >= 0 && posY - 2 >= 0) {
                this.fillMoveTiles(gameTiles, tiles, 3, posX - 1, posY - 2, "Blue");
            }

            if (posX + 2 <= 7 && posY + 1 <= 7) {
                this.fillMoveTiles(gameTiles, tiles, 4, posX + 2, posY + 1, "Blue");
            }

            if (posX + 2 <= 7 && posY - 1 >= 0) {
                this.fillMoveTiles(gameTiles, tiles, 5, posX + 2, posY - 1, "Blue");
            }

            if (posX - 2 >= 0 && posY + 1 <= 7) {
                this.fillMoveTiles(gameTiles, tiles, 6, posX - 2, posY + 1, "Blue");
            }

            if (posX - 2 >= 0 && posY - 1 >= 0) {
                this.fillMoveTiles(gameTiles, tiles, 7, posX - 2, posY - 1, "Blue");
            }
        }

        return tiles;
    }

    private int[][] initMoveTiles() {
        int[][] tiles = new int[8][2];
        int xValue = 0;
        for (int[] x:tiles) {
            for (int y: x) {
                tiles[xValue][y] = 99;
            }
            xValue++;
        }
        return tiles;
    }

    private void fillMoveTiles(Piece[][] gameTiles, int[][] tiles, int moveNum, int posX, int posY, String color) {
        if (!gameTiles[posX][posY].getColor().equals(color)) {
            tiles[moveNum][0] = posX;
            tiles[moveNum][1] = posY;
        }
    }
}
