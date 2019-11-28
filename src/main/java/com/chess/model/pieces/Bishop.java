package com.chess.model.pieces;

public class Bishop extends Piece {
    private int bid;

    public Bishop(int rack, int file, String color, int id) {
        super(rack, file, color);
        this.bid = id;

        setName("Bishop");
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
        return "[B]";
    }

    private int[][] moveTiles(Piece[][] gameTiles) {
        int[][] tiles = initMoveTiles();
        int posX = this.getPosition()[0];
        int posY = this.getPosition()[1];

        if (this.getColor().equals("Red")) {
            int j = posY+1;
            for (int i = posX+1; i < 8; i++) {
                if (j > 7) {
                    break;
                }
                if (gameTiles[i][j].getColor().equals("Red")) {
                    break;
                }
                if (gameTiles[i][j].getColor().equals("Blue")) {
                    tiles[i][0] = i;
                    tiles[i][1] = j;
                    break;
                }
                tiles[i][0] = i;
                tiles[i][1] = j;
                j++;
            }

            j = posY-1;
            for (int i = posX+1; i < 8; i++) {
                if (j < 0) {
                    break;
                }
                if (gameTiles[i][j].getColor().equals("Red")) {
                    break;
                }
                if (gameTiles[i][j].getColor().equals("Blue")) {
                    tiles[i+8][0] = i;
                    tiles[i+8][1] = j;
                    break;
                }
                tiles[i+8][0] = i;
                tiles[i+8][1] = j;
                j--;
            }

            j = posY+1;
            for (int i = posX-1; i >= 0; i--) {
                if (j > 7) {
                    break;
                }
                if (gameTiles[i][j].getColor().equals("Red")) {
                    break;
                }
                if (gameTiles[i][j].getColor().equals("Blue")) {
                    tiles[i][0] = i;
                    tiles[i][1] = j;
                    break;
                }
                tiles[i][0] = i;
                tiles[i][1] = j;
                j++;
            }

            j = posY-1;
            for (int i = posX-1; i >= 0; i--) {
                if (j < 0) {
                    break;
                }
                if (gameTiles[i][j].getColor().equals("Red")) {
                    break;
                }
                if (gameTiles[i][j].getColor().equals("Blue")) {
                    tiles[i+8][0] = i;
                    tiles[i+8][1] = j;
                    break;
                }
                tiles[i+8][0] = i;
                tiles[i+8][1] = j;
                j--;
            }
        }
        if (this.getColor().equals("Blue")) {
            int j = posY+1;
            for (int i = posX+1; i < 8; i++) {
                if (j > 7) {
                    break;
                }
                if (gameTiles[i][j].getColor().equals("Blue")) {
                    break;
                }
                if (gameTiles[i][j].getColor().equals("Red")) {
                    tiles[i][0] = i;
                    tiles[i][1] = j;
                    break;
                }
                tiles[i][0] = i;
                tiles[i][1] = j;
                j++;
            }

            j = posY-1;
            for (int i = posX+1; i < 8; i++) {
                if (j < 0) {
                    break;
                }
                if (gameTiles[i][j].getColor().equals("Blue")) {
                    break;
                }
                if (gameTiles[i][j].getColor().equals("Red")) {
                    tiles[i+8][0] = i;
                    tiles[i+8][1] = j;
                    break;
                }
                tiles[i+8][0] = i;
                tiles[i+8][1] = j;
                j--;
            }

            j = posY+1;
            for (int i = posX-1; i >= 0; i--) {
                if (j > 7) {
                    break;
                }
                if (gameTiles[i][j].getColor().equals("Blue")) {
                    break;
                }
                if (gameTiles[i][j].getColor().equals("Red")) {
                    tiles[i][0] = i;
                    tiles[i][1] = j;
                    break;
                }
                tiles[i][0] = i;
                tiles[i][1] = j;
                j++;
            }

            j = posY-1;
            for (int i = posX-1; i >= 0; i--) {
                if (j < 0) {
                    break;
                }
                if (gameTiles[i][j].getColor().equals("Blue")) {
                    break;
                }
                if (gameTiles[i][j].getColor().equals("Red")) {
                    tiles[i+8][0] = i;
                    tiles[i+8][1] = j;
                    break;
                }
                tiles[i+8][0] = i;
                tiles[i+8][1] = j;
                j--;
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
