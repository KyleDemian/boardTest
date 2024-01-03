package study.boardtest.board.entity;

import jakarta.persistence.*;
import study.boardtest.common.BaseEntity;

import java.time.LocalDateTime;

@Entity
public class Board extends BaseEntity {

    @Id @Column(name = "board_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;
    private String name;
    @Enumerated(EnumType.STRING)
    private BoardCategories categories;


}
