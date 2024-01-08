package study.boardtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing  // @EntityListeners(AuditingEntityListener.class) 없다면 등록 안됌, 필수 등록
public class BoardTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoardTestApplication.class, args);
    }

}
