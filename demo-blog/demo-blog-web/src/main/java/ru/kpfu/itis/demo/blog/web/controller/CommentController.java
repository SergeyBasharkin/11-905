package ru.kpfu.itis.demo.blog.web.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.demo.blog.api.dto.CommentDTO;
import ru.kpfu.itis.demo.blog.api.service.CommentService;
import ru.kpfu.itis.demo.blog.impl.entity.CommentEntity;
import ru.kpfu.itis.demo.blog.web.security.details.UserDetailsImpl;

import javax.annotation.security.PermitAll;

@RestController
@RequestMapping("/posts/{postId}/comments")
public class CommentController {

    private  final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public Page<CommentDTO> comments(@PathVariable Long postId, Pageable pageable){
        return commentService.findAll(pageable);
    }

    @PostMapping
    @PermitAll
    @PreAuthorize("isAuthenticated()")
    public void save(@RequestBody CommentDTO commentDTO, @AuthenticationPrincipal UserDetailsImpl user) {
        commentDTO.setId(commentDTO.getUserId());
        commentService.save(commentDTO);
    }

    @DeleteMapping("/{commentId}")
    @PermitAll
    @PreAuthorize("isAuthenticated()")
    public void delete(@PathVariable Long commentId){
        commentService.deleteById(commentId);
    }

    @PatchMapping("/{commentId}")
    public void update(@PathVariable Long commentId, @RequestBody CommentDTO commentDTO){
        commentDTO.setId(commentId);
        commentService.save(commentDTO);
    }
}
