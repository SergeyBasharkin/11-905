package ru.kpfu.itis.demo.blog.impl.jpa.repository;

import com.sun.xml.bind.v2.schemagen.episode.SchemaBindings;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.demo.blog.impl.entity.CommentEntity;

import java.util.List;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
    List<CommentEntity> findByPost_IdIn(List<Long> ids);

    Page<CommentEntity> findCommentEntityByPostId(Long postId, Pageable pageable);
}
