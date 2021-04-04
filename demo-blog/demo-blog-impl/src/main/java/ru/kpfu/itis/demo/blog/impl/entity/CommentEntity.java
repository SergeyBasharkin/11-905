package ru.kpfu.itis.demo.blog.impl.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
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

    @CreationTimestamp
    public Date createdDate;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private UserEntity account;

    @ManyToOne(fetch = FetchType.LAZY)
    private PostEntity post;
}
