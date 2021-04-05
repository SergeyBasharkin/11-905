package ru.kpfu.itis.demo.blog.impl.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.demo.blog.api.dto.UserDTO;
import ru.kpfu.itis.demo.blog.api.service.SignUpService;
import ru.kpfu.itis.demo.blog.impl.entity.UserEntity;
import ru.kpfu.itis.demo.blog.impl.jpa.repository.UserRepository;

import java.util.Optional;

@Service
public class BlogSignUpService implements SignUpService {

    @Autowired
    public UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Boolean signUp(UserDTO userDTO) {

        UserEntity userEntity = UserEntity.builder()
                .email(userDTO.getEmail())
                .name(userDTO.getName())
                .hashPassword(passwordEncoder.encode(userDTO.getPassword()))
                .role(UserEntity.Role.USER)
                .build();
        userRepository.save(userEntity);

        return true;
    }

    @Override
    public Page<UserDTO> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Optional<UserDTO> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public Boolean save(UserDTO userDTO) {
        return null;
    }

    @Override
    public Boolean delete(UserDTO userDTO) {
        return null;
    }

    @Override
    public Boolean deleteById(Long aLong) {
        return null;
    }
}
