package study.boardtest.board.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import study.boardtest.board.dto.BoardDto;
import study.boardtest.board.entity.Board;
import study.boardtest.board.service.BoardService;

import java.io.IOException;
import java.net.URI;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/board")
    public ResponseEntity createBoard(@RequestBody BoardDto boardDto) {
        return ResponseEntity.ok(boardService.saveBoard(boardDto));
    }

    @GetMapping("/board/list")
    public Page<BoardDto> boardList(BoardDto condition, Pageable pageable) {
        return boardService.getBoardList(condition, pageable);
    }

    @GetMapping("/board/{id}")
    public ResponseEntity boardDetail(@PathVariable long id) {
        return ResponseEntity.ok(boardService.findById(id));
    }

    @PostMapping("/board/{id}/update")
    public ResponseEntity createPost(@PathVariable long id, @RequestBody BoardDto boardDto) {
        boardService.updateBoard(id, boardDto);
        return ResponseEntity.ok(id);
    }

    @DeleteMapping("/board/{id}")
    public ResponseEntity deleteBoard(@PathVariable long id) {
        boardService.deleteById(id);
        return ResponseEntity.ok(id);
    }
}
