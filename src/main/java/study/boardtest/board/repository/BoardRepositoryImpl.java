package study.boardtest.board.repository;

import com.querydsl.core.QueryResults;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.util.StringUtils;
import study.boardtest.board.dto.BoardDto;
import study.boardtest.board.dto.QBoardDto;
import study.boardtest.board.entity.Board;
import study.boardtest.board.entity.BoardCategories;
import study.boardtest.board.entity.QBoard;

import java.util.List;

import static study.boardtest.board.entity.QBoard.board;

public class BoardRepositoryImpl implements BoardRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public BoardRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    public Page<BoardDto> search(BoardDto condition, Pageable pageable) {
        List<BoardDto> contents = queryFactory
                .select(new QBoardDto(
                        board.id,
                        board.title,
                        board.name,
                        board.categories
                ))
                .from(board)
                .where(
                        titleEq(condition.getTitle())
                        , nameEq(condition.getName())
                        , categoriesEq(condition.getCategories())
                )
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        JPAQuery<Board> bCount = queryFactory
                .select(board)
                .from(board)
                .where(
                        titleEq(condition.getTitle()),
                        nameEq(condition.getName())
                );
        return PageableExecutionUtils.getPage(contents, pageable, bCount::fetchCount);
    }

    private BooleanExpression categoriesEq(BoardCategories categories) {
        if (categories == null) {
            return null;
        }

        switch (categories) {
            case Spring -> {
                return board.categories.eq(BoardCategories.valueOf("Spring"));
            }
            case Summer -> {
                return board.categories.eq(BoardCategories.valueOf("Summer"));
            }
            case Autumn -> {
                return board.categories.eq(BoardCategories.valueOf("Autumn"));
            }
            case Winter -> {
                return board.categories.eq(BoardCategories.valueOf("Winter"));
            }
            default -> {
                return null;
            }
        }
    }

    private BooleanExpression nameEq(String name) {
        return StringUtils.hasText(name) ? board.name.eq(name) : null;
    }

    private BooleanExpression titleEq(String title) {
        return StringUtils.hasText(title) ? board.title.eq(title) : null;
    }
}
