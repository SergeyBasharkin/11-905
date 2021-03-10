package ru.kpfu.itis.demo.blog.web.command;

import org.dummycreator.ClassBindings;
import org.dummycreator.DummyCreator;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.kpfu.itis.demo.blog.impl.entity.PostEntity;
import ru.kpfu.itis.demo.blog.impl.jpa.repository.PostRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

@Component
public class InitRunner implements CommandLineRunner {
    private final PostRepository postRepository;

    public InitRunner(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        DummyCreator dummyCreator = new DummyCreator(ClassBindings.defaultBindings());

        IntStream.range(0, 5).forEach(value -> {
            PostEntity postEntity = dummyCreator.create(PostEntity.class);
            postEntity.setId(null);
            postEntity.setCreatedAt(null);
            postEntity.setUpdatedAt(null);
            postEntity.getComments()
                    .forEach(commentEntity -> {
                        commentEntity.setId(null);
                        commentEntity.setCreatedDate(null);
                        commentEntity.setPost(postEntity);
                    });
            postEntity.getAccount().setId(null);
//            PostEntity postEntity = new PostEntity();
//            postEntity.setTittle("Title " + value);
//            postEntity.setTittle("Body " + value);
            postRepository.save(postEntity);
        });

        //        ArrayList<PostEntity> arrayList = new ArrayList<>();
//        arrayList.add(dummyCreator.create(PostEntity.class));
//        arrayList.add(dummyCreator.create(PostEntity.class));
//        arrayList.add(dummyCreator.create(PostEntity.class));
//        arrayList.add(dummyCreator.create(PostEntity.class));
//        arrayList.add(dummyCreator.create(PostEntity.class));
//        arrayList.add(dummyCreator.create(PostEntity.class));
//        arrayList.add(dummyCreator.create(PostEntity.class));
//        postRepository.initPosts(arrayList);
//        IntStream.range(0, postRepository.getPosts().size())
//                .forEach(value -> {
//                    postRepository.getPosts().get(value).setId((long) value);
//                });
    }
}
