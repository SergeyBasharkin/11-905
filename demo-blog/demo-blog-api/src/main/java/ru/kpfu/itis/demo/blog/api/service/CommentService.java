package ru.kpfu.itis.demo.blog.api.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.kpfu.itis.demo.blog.api.dto.CommentDTO;

public interface CommentService extends CrudService<CommentDTO, Long> {
    Page<CommentDTO> findAll(Long postId, Pageable pageable);
}
