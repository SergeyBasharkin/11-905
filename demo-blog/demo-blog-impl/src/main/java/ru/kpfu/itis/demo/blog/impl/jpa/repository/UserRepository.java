package ru.kpfu.itis.demo.blog.impl.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.demo.blog.impl.entity.UserEntity;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
    Optional<UserEntity> findByUsername(String username);
}
