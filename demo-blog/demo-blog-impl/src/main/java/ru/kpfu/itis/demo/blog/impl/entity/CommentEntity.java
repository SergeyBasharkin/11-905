package ru.kpfu.itis.demo.blog.impl.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "comment")
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    public String text;
    @CreatedDate
    public Date createdDate;

    @ManyToOne
    private UserEntity account;

    @ManyToOne
    private PostEntity post;
}
