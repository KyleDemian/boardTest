package study.boardtest.board.dto;

import com.querydsl.core.annotations.QueryProjection;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import study.boardtest.board.entity.Board;
import study.boardtest.board.entity.BoardCategories;
import study.boardtest.common.BaseEntity;


@Getter
@Builder
//@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardDto{

    private Long id;

    private String title;

    private String name;

    @NotNull(message = "카테고리가 없음.")
    private BoardCategories categories;

    @QueryProjection
    public BoardDto(Long id, String title, String name, BoardCategories categories) {
        this.id = id;
        this.title = title;
        this.name = name;
        this.categories = categories;
    }


    // 2024 01 09 변경
    // DTO -> Entity
    public Board toEntity(){
        Board board = Board.builder()
//                .id(id)
                .title(title)
                .name(name)
                .categories(categories)
                .build();
        return board;
    }

    // Entity -> DTO
    public BoardDto(Board board) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.name = board.getName();
        this.categories = board.getCategories();
    }
}
