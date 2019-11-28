package com.chess.model.pieces;

public class King extends Piece {
    private int kid;

    public King(int rack, int file, String color, int id) {
        super(rack, file, color);
        this.kid = id;

        setName("King");
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

    private int[][] moveTiles(Piece[][] gameTiles) {
        int[][] tiles = initMoveTiles();
        int posX = this.getPosition()[0];
        int posY = this.getPosition()[1];

        if (this.getColor().equals("Red")) {
            if (posX+1 < 8 && !gameTiles[posX+1][posY].getColor().equals("Red")) {
                tiles[0][0] = posX+1;
                tiles[0][1] = posY;
            }
            if (posX+1 < 8 && posY+1 < 8 && !gameTiles[posX+1][posY+1].getColor().equals("Red")) {
                tiles[1][0] = posX + 1;
                tiles[1][1] = posY + 1;
            }
            if (posX+1 < 8 && posY-1 >= 0  && !gameTiles[posX+1][posY-1].getColor().equals("Red")) {
                tiles[2][0] = posX + 1;
                tiles[2][1] = posY - 1;
            }
            if (posY+1 < 8 && !gameTiles[posX][posY+1].getColor().equals("Red")) {
                tiles[3][0] = posX;
                tiles[3][1] = posY + 1;
            }
            if (posY-1 >= 0 && !gameTiles[posX][posY-1].getColor().equals("Red")) {
                tiles[4][0] = posX;
                tiles[4][1] = posY - 1;
            }
            if (posX-1 >= 0  && !gameTiles[posX-1][posY].getColor().equals("Red")) {
                tiles[5][0] = posX - 1;
                tiles[5][1] = posY;
            }
            if (posX-1 >= 0 && posY+1 < 8 && !gameTiles[posX-1][posY+1].getColor().equals("Red")) {
                tiles[6][0] = posX - 1;
                tiles[6][1] = posY + 1;
            }
            if (posX-1 >= 0 && posY-1 >= 0 && !gameTiles[posX-1][posY-1].getColor().equals("Red")) {
                tiles[7][0] = posX - 1;
                tiles[7][1] = posY - 1;
            }
        }
        if (this.getColor().equals("Blue")) {
            if (posX+1 < 8 && !gameTiles[posX+1][posY].getColor().equals("Blue")) {
                tiles[0][0] = posX+1;
                tiles[0][1] = posY;
            }
            if (posX+1 < 8 && posY+1 < 8 && !gameTiles[posX+1][posY+1].getColor().equals("Blue")) {
                tiles[1][0] = posX + 1;
                tiles[1][1] = posY + 1;
            }
            if (posX+1 < 8 && posY-1 >= 0  && !gameTiles[posX+1][posY-1].getColor().equals("Blue")) {
                tiles[2][0] = posX + 1;
                tiles[2][1] = posY - 1;
            }
            if (posY+1 < 8 && !gameTiles[posX][posY+1].getColor().equals("Blue")) {
                tiles[3][0] = posX;
                tiles[3][1] = posY + 1;
            }
            if (posY-1 >= 0 && !gameTiles[posX][posY-1].getColor().equals("Blue")) {
                tiles[4][0] = posX;
                tiles[4][1] = posY - 1;
            }
            if (posX-1 >= 0  && !gameTiles[posX-1][posY].getColor().equals("Blue")) {
                tiles[5][0] = posX - 1;
                tiles[5][1] = posY;
            }
            if (posX-1 >= 0 && posY+1 < 8 && !gameTiles[posX-1][posY+1].getColor().equals("Blue")) {
                tiles[6][0] = posX - 1;
                tiles[6][1] = posY + 1;
            }
            if (posX-1 >= 0 && posY-1 >= 0 && !gameTiles[posX-1][posY-1].getColor().equals("Blue")) {
                tiles[7][0] = posX - 1;
                tiles[7][1] = posY - 1;
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

    @Override
    public void move(int[] destination) {
        this.setPosition(destination);
    }

    @Override
    public String toString() {
        return "[K]";
    }
}
