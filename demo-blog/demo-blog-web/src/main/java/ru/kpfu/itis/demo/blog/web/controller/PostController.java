package ru.kpfu.itis.demo.blog.web.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.demo.blog.api.dto.PostDTO;
import ru.kpfu.itis.demo.blog.impl.jpa.repository.projection.OnlyTittlePost;
import ru.kpfu.itis.demo.blog.impl.service.BlogPostService;
import ru.kpfu.itis.demo.blog.web.exception.PostNotFoundException;

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
    public Page<PostDTO> findAll( @RequestParam(required = false) String name, Pageable pageable){
        return blogPostService.findAllByName(name, pageable);
    }

    @GetMapping("/{id}")
    public PostDTO post(@PathVariable Long id) throws PostNotFoundException {
        return blogPostService.findById(id)
                .orElseThrow(() -> new PostNotFoundException("Post not found"));
    }

    @PostMapping
    public void save(@RequestBody PostDTO postDTO){
        blogPostService.save(postDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        blogPostService.deleteById(id);
    }

}
