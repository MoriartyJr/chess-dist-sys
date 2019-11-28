package com.chess.model;

import com.chess.model.pieces.*;

public class Board {
    private Piece[][] Tiles;

    private int racks = 8;
    private int files = 8;

    private int id = 0;

    public Board() {
        Tiles = new Piece[racks][files];

        initEmptyTiles();
        initPawns();
        initRooks();
        initNights();
        initBishops();
        initQueens();
        initKings();

        drawBoard();
    }

    public void drawBoard() {
        StringBuilder board = new StringBuilder();

        for (int i = racks -1; i>=0; i--) {
            for (int j = 0; j<files; j++) {
                if (Tiles[i][j] != null) {
                    board.append(this.Tiles[i][j].toString());
                }
                else {
                    board.append("[ ]");
                }
            }
            board.append("\n");
        }

        System.out.println(board.toString());
    }

    public boolean makeMove(Move newMove) {
        // From origin piece to destination
        int[] origin = new int[2];
        int[] destination = new int[2];

        origin[0] = newMove.getOrigin() / 8;
        origin[1] = newMove.getOrigin() % 8;
        destination[0] = newMove.getDestiny() / 8;
        destination[1] = newMove.getDestiny() % 8;

        Piece PiecetoMove = this.Tiles[origin[0]][origin[1]];

        if (PiecetoMove.isInMoveSet(destination, this.getTiles())) {
            PiecetoMove.move(destination);
            updateTiles(origin, destination, PiecetoMove);
            return true;
        }
        return false;
    }

    private void updateTiles(int[] origin, int[] destination, Piece toUpdate) {
        this.Tiles[origin[0]][origin[1]] = new EmptyPiece(origin[0], origin[1], "");
        this.Tiles[destination[0]][destination[1]] = toUpdate;
    }

    private void initKings() {
        Tiles[0][4] = new King(0, 4, "Red", 1);
        Tiles[7][4] = new King(7, 4, "Blue", 2);
    }

    private void initQueens() {
        Tiles[0][3] = new Queen(0, 3, "Red", 3);
        Tiles[7][3] = new Queen(7, 3, "Blue", 4);
    }

    private void initBishops() {
        Tiles[0][2] = new Bishop(0, 2, "Red", 5);
        Tiles[0][5] = new Bishop(0, 5, "Red", 6);
        Tiles[7][2] = new Bishop(7, 2, "Blue", 7);
        Tiles[7][5] = new Bishop(7, 5, "Blue", 8);
    }

    private void initNights() {
        Tiles[0][1] = new Knight(0, 1, "Red", 9);
        Tiles[0][6] = new Knight(0, 6, "Red", 10);
        Tiles[7][1] = new Knight(7, 1, "Blue", 11);
        Tiles[7][6] = new Knight(7, 6, "Blue", 12);
    }

    private void initRooks() {
        Tiles[0][0] = new Rook(0, 0, "Red", 13);
        Tiles[0][7] = new Rook(0, 7, "Red", 14);
        Tiles[7][0] = new Rook(7, 0, "Blue", 15);
        Tiles[7][7] = new Rook(7, 7, "Blue", 16);
    }

    private void initPawns() {
        for (int i = 0; i < files; i++) {
            Tiles[1][i] = new Pawn(1, i, "Red", id);
            id++;
            Tiles[6][i] = new Pawn(6, i, "Blue", id);
            id++;
        }
    }

    private void initEmptyTiles() {
        int i = 0;
        for (Piece[] tileRow: Tiles) {
            int j = 0;
            for (Piece tile: tileRow) {
                Tiles[i][j] = new EmptyPiece(i, j, "");
                j++;
            }
            i++;
        }
    }


    public Piece[][] getTiles() {
        return Tiles;
    }

    public int getRacks() {
        return racks;
    }

    public int getFiles() {
        return files;
    }

    public int getId() {
        return id;
    }
}