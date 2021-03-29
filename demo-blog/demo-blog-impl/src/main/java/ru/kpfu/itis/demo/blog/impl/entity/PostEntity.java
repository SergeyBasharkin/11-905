package ru.kpfu.itis.demo.blog.impl.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "post")
@EntityListeners(AuditingEntityListener.class)
@NamedEntityGraph(
        name = "Post.Comments",
        attributeNodes = @NamedAttributeNode(
                value = "comments",
                subgraph = "Comment.User"
        ),
        subgraphs = @NamedSubgraph(
                name = "Comment.User",
                attributeNodes = @NamedAttributeNode("account")
        )
)
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String tittle;
    private String body;
    @CreatedDate
    private Date createdAt;
    @LastModifiedDate
    private Date updatedAt;

    @ManyToOne
    private UserEntity account;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    public List<CommentEntity> comments;
}
