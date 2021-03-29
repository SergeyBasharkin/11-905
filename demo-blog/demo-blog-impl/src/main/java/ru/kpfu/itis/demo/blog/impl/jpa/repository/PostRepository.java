package ru.kpfu.itis.demo.blog.impl.jpa.repository;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import ru.kpfu.itis.demo.blog.api.dto.PostDTO;
import ru.kpfu.itis.demo.blog.impl.jpa.repository.projection.OnlyTittlePost;
import ru.kpfu.itis.demo.blog.impl.entity.PostEntity;

import java.util.List;

public interface PostRepository extends JpaSpecificationExecutor<PostEntity>, JpaRepository<PostEntity, Long> {
    Page<PostEntity> findAllByTittle(String name, Pageable pageable);
    List<PostDTO> findAllByIdIsNotNull();

    @Override
    @EntityGraph(value = "Post.Comments")
    Page<PostEntity> findAll(Pageable pageable);
}
