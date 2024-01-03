package study.boardtest.board.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import study.boardtest.board.dto.BoardDto;

public interface BoardRepositoryCustom {

    Page<BoardDto> search(BoardDto condition, Pageable pageable);
}
