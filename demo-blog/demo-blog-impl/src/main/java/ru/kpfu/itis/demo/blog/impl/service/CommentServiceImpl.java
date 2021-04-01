package ru.kpfu.itis.demo.blog.impl.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.demo.blog.api.dto.CommentDTO;
import ru.kpfu.itis.demo.blog.api.service.CommentService;
import ru.kpfu.itis.demo.blog.impl.entity.CommentEntity;
import ru.kpfu.itis.demo.blog.impl.entity.PostEntity;
import ru.kpfu.itis.demo.blog.impl.jpa.repository.CommentRepository;
import ru.kpfu.itis.demo.blog.impl.jpa.repository.PostRepository;

import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Page<CommentDTO> findAll(Pageable pageable) {
        return commentRepository.findAll(pageable)
                .map(commentEntity -> modelMapper.map(commentEntity, CommentDTO.class));
    }

    @Override
    public Page<CommentDTO> findAllByPostId(Long postId, Pageable pageable) {
        return commentRepository.findByPost_Id(postId, pageable)
                .map(commentEntity -> modelMapper.map(commentEntity, CommentDTO.class));
    }

    @Override
    public Optional<CommentDTO> findById(Long aLong) {
        return commentRepository.findById(aLong)
                .map(commentEntity -> modelMapper.map(commentEntity, CommentDTO.class));
    }

    @Override
    public Boolean save(CommentDTO commentDTO) {
        System.out.println("Yaaaaa" + commentDTO.getText());
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
