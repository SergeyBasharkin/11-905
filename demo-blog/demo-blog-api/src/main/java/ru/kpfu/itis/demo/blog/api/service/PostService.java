package ru.kpfu.itis.demo.blog.api.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.kpfu.itis.demo.blog.api.dto.PostDTO;

import java.util.Optional;

public interface PostService {

    Page<PostDTO> findAll(Pageable pageable);
    Optional<PostDTO> findById(Long aLong);
    Boolean save(PostDTO postDTO);
    Boolean deleteById(Long aLong);
}
