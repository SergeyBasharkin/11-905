package ru.kpfu.itis.demo.blog.api.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.kpfu.itis.demo.blog.api.dto.CommentDTO;

public interface CommentService {
    Page<CommentDTO> findAll(Pageable pageable, Long postId);

    Boolean save(CommentDTO commentDTO);

    Boolean deleteById(Long commentId);
}
