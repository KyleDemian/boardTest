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
        // 왜 Id
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

        // 변경감지.. 그럼 상세를 1회 조회를 하고, 해당 조회한 값을 persistEntity로만 호출 하면 자동 변경되겠네
        Optional<BoardDto> boardDetail = boardService.findById(id);

        BoardDto saveBoard = boardService.saveBoard(board.toEntity().toResponseDto());

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
