package study.boardtest.board.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import study.boardtest.board.dto.BoardDto;

import java.util.Optional;

public interface BoardService {
    Page<BoardDto> getBoardList(BoardDto condition, Pageable pageable);

    void deleteById(Long id);

    Optional<BoardDto> findById(long id);
}
