package ru.kpfu.itis.demo.blog.web.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.demo.blog.api.dto.CommentDTO;
import ru.kpfu.itis.demo.blog.api.service.CommentService;
import ru.kpfu.itis.demo.blog.impl.entity.CommentEntity;

@RestController
@RequestMapping("/posts/{postId}/comments")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

//        @GetMapping
//    public Page<CommentDTO> comments(@PathVariable Long postId, Pageable pageable) {
//        return commentService.findAll(pageable);
//    }

    @GetMapping
    public Page<CommentDTO> commentsByPost(@PathVariable Long postId, Pageable pageable) {
        return commentService.findAllByPostId(postId, pageable);
    }

    @PostMapping
    public void save(@RequestBody CommentDTO commentDTO) {
        commentService.save(commentDTO);
    }

    @DeleteMapping("/{commentId}")
    public void delete(@PathVariable Long commentId) {
        commentService.deleteById(commentId);
    }

    @PatchMapping("/{commentId}")
    public void update(@PathVariable Long commentId, @RequestBody CommentDTO commentDTO) {
        commentDTO.setId(commentId);
        commentService.save(commentDTO);
    }
}
