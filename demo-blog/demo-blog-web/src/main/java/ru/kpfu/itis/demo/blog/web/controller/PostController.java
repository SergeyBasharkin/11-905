package ru.kpfu.itis.demo.blog.web.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.demo.blog.api.dto.PostDTO;
import ru.kpfu.itis.demo.blog.impl.jpa.repository.projection.OnlyTittlePost;
import ru.kpfu.itis.demo.blog.impl.service.BlogPostService;
import ru.kpfu.itis.demo.blog.web.exception.PostNotFoundException;

import javax.annotation.security.PermitAll;
import java.util.List;

@RequestMapping("/posts")
@RestController
public class PostController {
    private final BlogPostService blogPostService;

    public PostController(BlogPostService blogPostService) {
        this.blogPostService = blogPostService;
    }
//
//    @GetMapping("/proj")
//    public List<PostDTO> find(){
//        return blogPostService.findAllProj();
//    }
    @GetMapping
    @PermitAll
    public Page<PostDTO> findAll( @RequestParam(required = false) String name, Pageable pageable){
        return blogPostService.findAllByName(name, pageable);
    }

    @GetMapping("/{id}")
    @PermitAll
    public PostDTO post(@PathVariable Long id) throws PostNotFoundException {
        return blogPostService.findById(id)
                .orElseThrow(() -> new PostNotFoundException("Post not found"));
    }

    @PostMapping
    @PreAuthorize("isAuthenticated()")
    @PermitAll
    public void save(@RequestBody PostDTO postDTO){
        blogPostService.save(postDTO);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    @PermitAll
    public void delete(@PathVariable Long id){
        blogPostService.deleteById(id);
    }

}
