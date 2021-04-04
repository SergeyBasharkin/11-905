package ru.kpfu.itis.demo.blog.api.service;

import org.springframework.stereotype.Service;
import ru.kpfu.itis.demo.blog.api.dto.UserDTO;

import java.util.Optional;

@Service
public interface UserService extends CrudService<UserDTO, Long> {
    Optional<UserDTO> findByEmail(String email);
}
