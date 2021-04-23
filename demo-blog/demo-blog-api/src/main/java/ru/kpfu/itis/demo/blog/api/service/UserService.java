package ru.kpfu.itis.demo.blog.api.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.kpfu.itis.demo.blog.api.dto.UserDTO;

import java.util.Optional;

public interface UserService<UserDto, Long> {
    Page<UserDTO> findAll(Pageable pageable);

    Optional<UserDTO> findById(java.lang.Long aLong);

    Boolean save(UserDTO userDTO);

    Boolean delete(UserDTO userDTO);

    Boolean deleteById(java.lang.Long aLong);

    Optional<UserDTO> findByEmail(String email);
}
