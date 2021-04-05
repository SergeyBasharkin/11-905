package ru.kpfu.itis.demo.blog.api.dto;

import lombok.Data;
import lombok.Builder;

import java.util.Date;

@Data
@Builder
public class CommentDTO {

    private Long id;
    private String text;
    private Date createdDate;
    private Long postId;
    private Long userId;
}
