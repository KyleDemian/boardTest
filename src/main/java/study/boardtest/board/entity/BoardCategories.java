package study.boardtest.board.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.querydsl.core.types.dsl.BooleanExpression;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.util.StringUtils;

import java.util.function.Function;
import java.util.stream.Stream;

@Getter
public enum BoardCategories {
    Spring("Spring"),
    Summer("Summer"),
    Autumn("Autumn"),
    Winter("Winter")
    ;

    private final String boardName;

    BoardCategories(String boardName) {
        this.boardName = boardName;
    }

// https://green-bin.tistory.com/90
    // Json데이터를 역직렬화 하는 과정을 수동 설정하는 것
    @JsonCreator
    public static BoardCategories parsing(String value) {
        if (StringUtils.isEmpty(value)) {
            return null;
        }

        return Stream.of(BoardCategories.values())
                .filter(cate -> cate.toString().equals(value))
                .findAny()
//                .orElse(NONE);
                .orElseThrow(() -> new IllegalArgumentException("해당 게시판이 존재하지 않습니다."));
    }

}
