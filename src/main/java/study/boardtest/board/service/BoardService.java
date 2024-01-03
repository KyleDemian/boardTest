package study.boardtest.board.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import study.boardtest.board.dto.BoardDto;

public interface BoardService {
    Page<BoardDto> getBoardList(BoardDto condition, Pageable pageable);
}
