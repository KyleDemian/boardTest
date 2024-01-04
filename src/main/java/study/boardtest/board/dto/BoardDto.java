package study.boardtest.board.dto;

import com.querydsl.core.annotations.QueryProjection;
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

    private BoardCategories categories;

    // https://9hyuk9.tistory.com/85
    @QueryProjection
    public BoardDto(String title, String name, BoardCategories categories) {
        this.title = title;
        this.name = name;
        this.categories = categories;
    }

    public Board toEntity(){
        return Board.builder()
                .id(id)
                .title(title)
                .name(name)
                .categories(categories)
                .build();
    }
}
