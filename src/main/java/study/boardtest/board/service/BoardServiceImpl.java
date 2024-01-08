package study.boardtest.board.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import study.boardtest.board.dto.BoardDto;
import study.boardtest.board.entity.Board;
import study.boardtest.board.repository.BoardRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{

    private final BoardRepository boardRepository;

    @Override
    @Transactional
    public Long saveBoard(BoardDto boardDto) {
        Board board = boardDto.toEntity();
        boardRepository.save(board);
        return board.getId();
    }

    @Override
    @Transactional
    public void updateBoard(long id, BoardDto boardDto) {
        Board board = boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 글 없음 id = " + id));
        board.update(boardDto.getTitle(), boardDto.getName());
    }

    @Override
    @Transactional(readOnly = true)
    public BoardDto findById(long id) {
        Board board = boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글 없음 Id= + id"));
        return new BoardDto(board);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<BoardDto> getBoardList(BoardDto condition, Pageable pageable) {
        return boardRepository.search(condition, pageable);
    }


    @Override
    @Transactional
    public void deleteById(Long id) {
        Board board = boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 존재 하지 않음. id = " +  id));
        boardRepository.delete(board);
        // boardRepository.deleteById(id);
    }

}
