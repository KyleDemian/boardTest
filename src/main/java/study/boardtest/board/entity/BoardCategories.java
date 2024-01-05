package study.boardtest.board.entity;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.stream.Stream;

public enum BoardCategories {
    Spring, Summer, Autumn, Winter;

    // Json데이터를 역직렬화 하는 과정을 수동 설정하는 것
//    @JsonCreator
//    public static BoardCategories parsing(String value) {
//        return Stream.of(BoardCategories.values())
//                .filter(cate -> cate.toString().equals(value.toUpperCase()))
//                .findFirst()
//                .orElse(null);
//    }

}
