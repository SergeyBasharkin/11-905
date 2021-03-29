package ru.kpfu.itis.demo.blog.impl.repository;

import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import ru.kpfu.itis.demo.blog.api.dto.PostDTO;
import ru.kpfu.itis.demo.blog.impl.entity.PostEntity;

import java.util.List;
import java.util.Optional;

@Data
@Component
public class PostRepositoryInMemory {
    private List<PostEntity> posts;

    public void initPosts(List<PostEntity> posts){
        this.posts = posts;
    }

    public Optional<PostEntity> findById(Long aLong) {
        return posts.stream()
                .filter(postEntity -> postEntity.getId().equals(aLong))
                .findFirst();
    }

    public Boolean save(PostEntity post) {
        if (post.getId() == null) {
            post.setId((long) posts.size());
            posts.add(post);
            return true;
        } else {
            return false;
        }
    }

    public Boolean delete(Long aLong) {
        return posts.removeIf(postEntity ->
                postEntity.getId().equals(aLong)
        );
    }
}
