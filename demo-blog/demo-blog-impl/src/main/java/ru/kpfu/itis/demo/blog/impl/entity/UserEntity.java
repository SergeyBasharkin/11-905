package ru.kpfu.itis.demo.blog.impl.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "account")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;

    public enum Role {
        ADMIN, USER
    }

    @Enumerated(value = EnumType.STRING)
    private Role role;

    private String password;


}
