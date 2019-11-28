package com.chess.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "move")
public class Move {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private int origin;
    private int destiny;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "game", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Move move;

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