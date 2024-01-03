package study.boardtest.board.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.Getter;
import org.antlr.v4.runtime.misc.NotNull;
import study.boardtest.board.entity.BoardCategories;

import java.time.LocalDateTime;

@Getter
public class BoardDto {

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
}
