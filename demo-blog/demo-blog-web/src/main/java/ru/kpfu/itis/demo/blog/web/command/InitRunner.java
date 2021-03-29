package ru.kpfu.itis.demo.blog.web.command;

import org.dummycreator.ClassBindings;
import org.dummycreator.DummyCreator;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import ru.kpfu.itis.demo.blog.impl.entity.CommentEntity;
import ru.kpfu.itis.demo.blog.impl.entity.PostEntity;
import ru.kpfu.itis.demo.blog.impl.jpa.repository.CommentRepository;
import ru.kpfu.itis.demo.blog.impl.jpa.repository.PostRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

//@Component
public class InitRunner implements CommandLineRunner {
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    public InitRunner(PostRepository postRepository, CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        DummyCreator dummyCreator = new DummyCreator(ClassBindings.defaultBindings());

//        IntStream.range(0, 5).forEach(value -> {
//            PostEntity postEntity = dummyCreator.create(PostEntity.class);
//            postEntity.setId(null);
//            postEntity.setCreatedAt(null);
//            postEntity.setUpdatedAt(null);
//            postEntity.getComments()
//                    .forEach(commentEntity -> {
//                        commentEntity.setId(null);
//                        commentEntity.setCreatedDate(null);
//                        commentEntity.setPost(postEntity);
//                    });
//            postEntity.getAccount().setId(null);
////            PostEntity postEntity = new PostEntity();
////            postEntity.setTittle("Title " + value);
////            postEntity.setTittle("Body " + value);
//            postRepository.save(postEntity);
//        });
//
//       .forEach(postEntity -> {
//            System.out.println("PostId=" + postEntity.getId());
//            postEntity.getComments().forEach(commentEntity -> {
//                System.out.println("CommentId=" + commentEntity.getId());
//                System.out.println("UserId=" + commentEntity.getAccount().getName());
//            });
//        });


        Page<PostEntity> posts = postRepository.findAll(PageRequest.of(1, 2));
        List<CommentEntity> byPost_idIn = commentRepository.findByPost_IdIn(
                posts.stream()
                        .map(PostEntity::getId)
                        .collect(Collectors.toList())
        );


        //                .forEach(postEntity -> {
//                    System.out.println("PostId=" + postEntity.getId());
//                    postEntity.getComments().forEach(commentEntity -> {
//                        System.out.println("CommentId=" + commentEntity.getId());
//                        System.out.println("UserId=" + commentEntity.getAccount().getName());
//                    });
//                });
//        postRepository.findAll((root, criteriaQuery, criteriaBuilder) -> {
//            if (criteriaQuery.getResultType().equals(Long.class)) return null;
//            root.fetch("comments").fetch("account");
//            return null;
//        }, PageRequest.of(1, 2)).forEach(postEntity -> {
//            System.out.println("PostId=" + postEntity.getId());
//            postEntity.getComments().forEach(commentEntity -> {
//                System.out.println("CommentId=" + commentEntity.getId());
//                System.out.println("UserId=" + commentEntity.getAccount().getName());
//            });
//        });
//        postRepository.findAll(SpecificationUtils
//                .byId(null)
//                .and(SpecificationUtils.byBodyLike("amet"))
//                .and((root, criteriaQuery, criteriaBuilder) -> {
//                    root.fetch("comments").fetch("account");
//                    return null;
//                })
//        ).forEach(postEntity -> {
//            System.out.println("PostId=" + postEntity.getId());
//            postEntity.getComments().forEach(commentEntity -> {
//                System.out.println("CommentId=" + commentEntity.getId());
//                System.out.println("UserId=" + commentEntity.getAccount().getName());
//            });
//        });

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

    public static class SpecificationUtils {
        public static Specification<PostEntity> byId(Long id) {
            return (root, criteriaQuery, criteriaBuilder) -> {
                if (id == null) return null;
                return criteriaBuilder.equal(root.get("id"), id);
            };
        }

        public static Specification<PostEntity> byBodyLike(String body) {
            return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("body"), "%" + body + "%");
        }


    }
}
