package ru.kpfu.itis.demo.blog.impl.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.demo.blog.impl.entity.UserEntity;

import java.util.Optional;

/**
 * @author Roman Leontev
 * 22:00 29.03.2021
 * group 11-905
 */

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmail(String email);
}
