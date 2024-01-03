package study.boardtest.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.boardtest.member.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
