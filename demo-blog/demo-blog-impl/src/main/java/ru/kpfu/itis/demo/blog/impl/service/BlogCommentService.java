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
import ru.kpfu.itis.demo.blog.impl.entity.PostEntity;
import ru.kpfu.itis.demo.blog.impl.jpa.repository.CommentRepository;

import java.util.Optional;

@Service
public class BlogCommentService implements CommentService {

    private final CommentRepository commentRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public BlogCommentService(CommentRepository commentRepository, ModelMapper modelMapper) {
        this.commentRepository = commentRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Page<CommentDTO> findAll(Pageable pageable) {
        return commentRepository.findAll(pageable)
                .map(commentEntity -> modelMapper.map(commentEntity, CommentDTO.class));
    }

    @Override
    public Optional<CommentDTO> findById(Long aLong) {
        return commentRepository.findById(aLong)
                .map(commentEntity -> modelMapper.map(commentEntity, CommentDTO.class));
    }

    @Override
    public Boolean save(CommentDTO commentDTO) {
        commentDTO.setId(null);
        commentRepository.save(modelMapper.map(commentDTO, CommentEntity.class));
        return true;

    }

    @Override
    public Boolean delete(CommentDTO commentDTO) {
        commentRepository.delete(modelMapper.map(commentDTO, CommentEntity.class));
        return false;
    }

    @Override
    public Boolean deleteById(Long aLong) {
        commentRepository.deleteById(aLong);
        return false;
    }
}
