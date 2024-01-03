package study.boardtest.member.entity;

import jakarta.persistence.*;
import study.boardtest.common.BaseEntity;

@Entity
public class Member extends BaseEntity {

    @Id @Column(name = "member_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;
    private String userName;
    private String password;
    private int age;
    private String address;
}
