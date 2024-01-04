package study.boardtest.board.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import study.boardtest.board.dto.BoardDto;
import study.boardtest.board.service.BoardService;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    /**
    * Get Method
    * List & Search
    * */
    @GetMapping("/board/list")
    public Page<BoardDto> list(BoardDto condition, Pageable pageable) {
        return boardService.getBoardList(condition, pageable);
    }

    @GetMapping("/board/{id}")
    public ResponseEntity list(@PathVariable long id) {
        Optional<BoardDto> board = boardService.findById(id);
        if (!board.isPresent()) {

        }

        return ResponseEntity.ok(board);
    }

    @PostMapping("/board")

    @DeleteMapping("/board/{id}")
    public ResponseEntity deleteBoard(@PathVariable long id) {
        boardService.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
