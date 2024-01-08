package study.boardtest.board.dto;

import com.querydsl.core.annotations.QueryProjection;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import study.boardtest.board.entity.Board;
import study.boardtest.board.entity.BoardCategories;
import study.boardtest.common.BaseEntity;


@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardDto{

    private Long id;

    private String title;

    private String name;

    @NotNull(message = "카테고리가 없음.")
    private BoardCategories categories;

    // https://9hyuk9.tistory.com/85
    @QueryProjection
    public BoardDto( String title, String name, BoardCategories categories) {
        this.title = title;
        this.name = name;
        this.categories = categories;
    }


    /**
     * 확인 필수 << 다시 올릴것
     * */
    // https://github.com/hojunnnnn/board/blob/master/src/main/java/com/coco/board/domain/Posts.java 확인 필수
    // https://golf-dev.tistory.com/40

    // https://jojoldu.tistory.com/122 "Enum.." ㅇ므..
    // 객체 매핑, 맵 스트럭트, 모델 맵퍼... 뭐가 좋을까..
    // https://lob-dev.tistory.com/entry/%EA%B0%9D%EC%B2%B4-%EB%B3%80%ED%99%98%ED%95%98%EA%B8%B0-%EC%9E%90%EB%B0%94-%EC%BD%94%EB%93%9C-%EB%A7%A4%ED%95%91-vs-MapStruct-vs-ModelMapper
    // https://velog.io/@papakang22/JavaMapStruct-%EC%82%AC%EC%9A%A9%ED%95%98%EA%B8%B0

    // https://jjunn93.com/entry/JPA-entity-DTO-%EB%B3%80%ED%99%98
    // https://lealea.tistory.com/248

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
