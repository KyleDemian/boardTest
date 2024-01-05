package study.boardtest.board.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import study.boardtest.board.dto.BoardDto;
import study.boardtest.board.service.BoardService;

import java.io.IOException;
import java.net.URI;
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
    public Page<BoardDto> boardList(BoardDto condition, Pageable pageable) {
        return boardService.getBoardList(condition, pageable);
    }

    @GetMapping("/board/{id}")
    public ResponseEntity boardDetail(@PathVariable long id) {
        Optional<BoardDto> board = boardService.findById(id);
        if (!board.isPresent()) {
            throw new IllegalArgumentException("해당 게시물은 없음.");
        }

        return ResponseEntity.ok(board);
    }

    @PostMapping("/board")
    public ResponseEntity<BoardDto> createBoard(@RequestBody BoardDto board) {
        BoardDto saveBoard = boardService.saveBoard(board);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(saveBoard.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @PostMapping("/board/{id}/update")
    public ResponseEntity<BoardDto> createPost(@PathVariable int id, @RequestBody BoardDto board) {

        // 변경감지.. 동일하게.. 근데 같은걸 줘도 되려나?
        BoardDto saveBoard = boardService.saveBoard(board);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(saveBoard.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/board/{id}")
    public ResponseEntity deleteBoard(@PathVariable long id) {
        boardService.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
