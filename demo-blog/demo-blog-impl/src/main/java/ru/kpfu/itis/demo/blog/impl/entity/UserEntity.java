package ru.kpfu.itis.demo.blog.impl.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@ToString
@Entity
@Table(name = "account")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String email;
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;


    public enum Role {
        ADMIN, USER
    }

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    public List<CommentEntity> comments;
}
