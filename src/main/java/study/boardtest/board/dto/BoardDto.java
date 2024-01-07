package study.boardtest.board.dto;

import com.querydsl.core.annotations.QueryProjection;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import study.boardtest.board.entity.Board;
import study.boardtest.board.entity.BoardCategories;


@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardDto {

    private Long id;

    private String title;

    private String name;

    @NotNull(message = "카테고리가 없음.")
    private BoardCategories categories;

    // https://9hyuk9.tistory.com/85
    @QueryProjection
    public BoardDto(String title, String name, BoardCategories categories) {
        this.title = title;
        this.name = name;
        this.categories = categories;
    }

    public Board toEntity(){
        Board board = Board.builder()
//                .id(id)
                .title(title)
                .name(name)
                .categories(categories)
                .build();

        return board;
    }
}
