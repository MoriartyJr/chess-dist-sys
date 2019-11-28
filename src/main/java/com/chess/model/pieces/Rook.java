package com.chess.model.pieces;

public class Rook extends Piece {
    private int rid;

    public Rook(int rack, int file, String color, int id) {
        super(rack, file, color);
        this.rid = id;
        setName("Rook");
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
        return "[R]";
    }

    private int[][] moveTiles(Piece[][] gameTiles) {
        int[][] tiles = initMoveTiles();
        int posX = this.getPosition()[0];
        int posY = this.getPosition()[1];

        if (this.getColor().equals("Red")) {
           for (int i = posX+1; i < 8; i++) {
               if (gameTiles[i][posY].getColor().equals("Red")) {
                   break;
               }
               if (gameTiles[i][posY].getColor().equals("Blue")) {
                   tiles[i][0] = i;
                   tiles[i][1] = posY;
                   break;
               }
               tiles[i][0] = i;
               tiles[i][1] = posY;
           }

            for (int i = posX-1; i >= 0; i--) {
                if (gameTiles[i][posY].getColor().equals("Red")) {
                    break;
                }
                if (gameTiles[i][posY].getColor().equals("Blue")) {
                    tiles[i][0] = i;
                    tiles[i][1] = posY;
                    break;
                }
                tiles[i][0] = i;
                tiles[i][1] = posY;
            }

            for (int i = posY+1; i < 8; i++) {
                if (gameTiles[posX][i].getColor().equals("Red")) {
                    break;
                }
                if (gameTiles[posX][i].getColor().equals("Blue")) {
                    tiles[i+8][0] = posX;
                    tiles[i+8][1] = i;
                    break;
                }
                tiles[i+8][0] = posX;
                tiles[i+8][1] = i;
            }

            for (int i = posY-1; i >= 0; i--) {
                if (gameTiles[posX][i].getColor().equals("Red")) {
                    break;
                }
                if (gameTiles[posX][i].getColor().equals("Blue")) {
                    tiles[i+8][0] = posX;
                    tiles[i+8][1] = i;
                    break;
                }
                tiles[i+8][0] = posX;
                tiles[i+8][1] = i;
            }
        }
        else {
            for (int i = posX+1; i < 8; i++) {
                if (gameTiles[i][posY].getColor().equals("Blue")) {
                    break;
                }
                if (gameTiles[i][posY].getColor().equals("Red")) {
                    tiles[i][0] = i;
                    tiles[i][1] = posY;
                    break;
                }
            tiles[i][0] = i;
            tiles[i][1] = posY;
            }

            for (int i = posX-1; i >= 0; i--) {
                if (gameTiles[i][posY].getColor().equals("Blue")) {
                    break;
                }
                if (gameTiles[i][posY].getColor().equals("Red")) {
                    tiles[i][0] = i;
                    tiles[i][1] = posY;
                    break;
                }
                tiles[i][0] = i;
                tiles[i][1] = posY;
            }

            for (int i = posY+1; i < 8; i++) {
                if (gameTiles[posX][i].getColor().equals("Blue")) {
                    break;
                }
                if (gameTiles[posX][i].getColor().equals("Red")) {
                    tiles[i+8][0] = posX;
                    tiles[i+8][1] = i;
                    break;
                }
                tiles[i+8][0] = posX;
                tiles[i+8][1] = i;
            }

            for (int i = posY-1; i >= 0; i--) {
                if (gameTiles[posX][i].getColor().equals("Blue")) {
                    break;
                }
                if (gameTiles[posX][i].getColor().equals("Red")) {
                    tiles[i+8][0] = posX;
                    tiles[i+8][1] = i;
                    break;
                }
                tiles[i+8][0] = posX;
                tiles[i+8][1] = i;
            }
        }
        return tiles;
    }

    private int[][] initMoveTiles() {
        int[][] tiles = new int[16][2];
        int xValue = 0;
        for (int[] x:tiles) {
            for (int y: x) {
                tiles[xValue][y] = 99;
            }
            xValue++;
        }
        return tiles;
    }
}