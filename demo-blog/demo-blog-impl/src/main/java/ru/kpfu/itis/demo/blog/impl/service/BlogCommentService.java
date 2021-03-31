package ru.kpfu.itis.demo.blog.impl.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.demo.blog.api.dto.CommentDTO;
import ru.kpfu.itis.demo.blog.api.dto.PostDTO;
import ru.kpfu.itis.demo.blog.api.service.CommentService;
import ru.kpfu.itis.demo.blog.impl.entity.CommentEntity;
import ru.kpfu.itis.demo.blog.impl.jpa.repository.CommentRepository;

import java.util.Optional;

@Service
public class BlogCommentService implements CommentService {
    @Autowired
    private ModelMapper modelMapper;

    private final CommentRepository commentRepository;

    public BlogCommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public Page<CommentDTO> findAll(Pageable pageable) {
        return commentRepository.findAll(pageable)
                .map(commentEntity -> modelMapper.map(commentEntity, CommentDTO.class));

    }

    @Override
    public Optional<CommentDTO> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public Boolean save(CommentDTO commentDTO) {
        commentRepository.save(modelMapper.map(commentDTO, CommentEntity.class));
        return true;
    }

    @Override
    public Boolean delete(CommentDTO commentDTO) {
        return null;
    }

    @Override
    public Boolean deleteById(Long aLong) {
        commentRepository.deleteById(aLong);
        return true;
    }
}
