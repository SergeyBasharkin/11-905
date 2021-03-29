package ru.kpfu.itis.demo.blog.api.dto;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Data
public class CommentDTO {
    private Long id;
    private String text;
    private Date createdDate;
    private Long postId;
    private Long userId;
}
