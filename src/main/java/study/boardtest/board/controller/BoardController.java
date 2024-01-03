package study.boardtest.board.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import study.boardtest.board.dto.BoardDto;
import study.boardtest.board.service.BoardService;

@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/board/list")
    public Page<BoardDto> list(BoardDto condition, Pageable pageable) {
        return boardService.getBoardList(condition, pageable);
    }
}
