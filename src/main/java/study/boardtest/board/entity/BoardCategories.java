package study.boardtest.board.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.util.StringUtils;

import java.util.stream.Stream;

@Getter
@AllArgsConstructor
public enum BoardCategories {
    Spring("봄 게시판","a"),
    Summer("여름 게시판","b"),
    Autumn("가을 게시판","c"),
    Winter("겨울 게시판","d"),
    NONE("게시판 없음","e")
    ;

    private final String boardName;
    private final String nickName;

    // https://green-bin.tistory.com/90
    // Json데이터를 역직렬화 하는 과정을 수동 설정하는 것
//    @JsonCreator
//    public static BoardCategories parsing(String value) {
//        if (StringUtils.isEmpty(value)) {
//            return null;
//        }
//
//        return Stream.of(BoardCategories.values())
//                .filter(cate -> cate.toString().equals(value.toUpperCase()))
//                .findAny()
//                .orElse(NONE);
//    }

}
