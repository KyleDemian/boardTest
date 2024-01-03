package study.boardtest.board.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import study.boardtest.board.dto.BoardDto;
import study.boardtest.board.repository.BoardRepository;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{

    private final BoardRepository boardRepository;

    @Override
    public Page<BoardDto> getBoardList(BoardDto condition, Pageable pageable) {
        return boardRepository.search(condition, pageable);
    }
}
