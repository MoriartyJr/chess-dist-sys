package com.chess.model.domain;

import javax.persistence.*;

@Entity
@Table(name = "game")
public class Game {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private User playerBlue;

    @OneToOne
    private User playerRed;
}
