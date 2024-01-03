package study.boardtest.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.boardtest.board.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Long>, BoardRepositoryCustom {
}
