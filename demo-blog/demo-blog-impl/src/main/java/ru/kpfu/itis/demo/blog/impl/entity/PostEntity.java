package ru.kpfu.itis.demo.blog.impl.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "post")
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String tittle;
    private String body;
    @CreationTimestamp
    private Date createdAt;
    @LastModifiedDate
    private Date updatedAt;

    @ManyToOne
    private UserEntity account;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    public List<CommentEntity> comments;
}
