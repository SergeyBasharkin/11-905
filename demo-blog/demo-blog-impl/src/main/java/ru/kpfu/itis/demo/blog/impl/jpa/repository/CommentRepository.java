package ru.kpfu.itis.demo.blog.impl.jpa.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.demo.blog.impl.entity.CommentEntity;

import java.util.List;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
    List<CommentEntity> findByPost_IdIn(List<Long> ids);

    Page<CommentEntity> findAllByPostId(Long id, Pageable pageable);
}
