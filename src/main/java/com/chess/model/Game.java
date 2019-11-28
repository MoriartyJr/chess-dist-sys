package com.chess.model;

import com.chess.model.Board;
import com.chess.model.Move;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Long id;
    private Board board;
    private List<Move> moveList;

    public Game() {
        this.board = new Board();
        this.moveList = new ArrayList<>();
    }

    public Board getBoard() {
        return board;
    }

    public List<Move> getMoveList() {
        return moveList;
    }

    public boolean addMove(Move newMove) {
        this.moveList.add(newMove);
        boolean allowed = this.board.makeMove(newMove);
        this.board.drawBoard();

        return allowed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void setMoveList(List<Move> moveList) {
        this.moveList = moveList;
    }
}