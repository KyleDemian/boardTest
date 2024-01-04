package study.boardtest.board.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import study.boardtest.board.dto.BoardDto;
import study.boardtest.common.BaseEntity;

import java.time.LocalDateTime;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board extends BaseEntity {

    @Id @Column(name = "board_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;
    private String name;
    @Enumerated(EnumType.STRING)
    private BoardCategories categories;

    // https://jjunn93.com/entry/JPA-entity-DTO-%EB%B3%80%ED%99%98
    // https://lealea.tistory.com/248
    public BoardDto toResponseDto(){
        return BoardDto.builder()
                .id(id)
                .title(title)
                .name(name)
                .categories(categories)
                .build();
    }
}
