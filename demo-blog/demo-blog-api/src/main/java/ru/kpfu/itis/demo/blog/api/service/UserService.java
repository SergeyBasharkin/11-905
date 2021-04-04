package ru.kpfu.itis.demo.blog.api.service;

import ru.kpfu.itis.demo.blog.api.dto.UserDTO;

import java.util.Optional;

public interface UserService extends CrudService<UserDTO, Long> {
    Optional<UserDTO> findByEmail(String email);
}
