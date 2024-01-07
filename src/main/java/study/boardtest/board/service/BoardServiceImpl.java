package study.boardtest.board.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
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
    public Page<BoardDto> getBoardList(BoardDto condition, Pageable pageable) {


        return boardRepository.search(condition, pageable);
//        return new Result<List<Page<BoardDto>>>(condition, pageable);
    }

    @Getter
    @Setter
    private static class Result<T>{
        private T data;
        private int count;

        public Result(T data, int count) {
            this.data = data;
            this.count = count;
        }
    }


    @Override
    public void deleteById(Long id) {
        Optional<Board> findBoard = boardRepository.findById(id);
        if (findBoard.isPresent()) {
            boardRepository.deleteById(id);
        }
    }

    @Override
    public Optional<BoardDto> findById(long id) {
        Optional<Board> detail = boardRepository.findById(id);

        return Optional.ofNullable(detail.get().toResponseDto());
    }

    @Override
    public BoardDto saveBoard(BoardDto board) {
        boardRepository.save(board.toEntity());
        return board;
    }
}
