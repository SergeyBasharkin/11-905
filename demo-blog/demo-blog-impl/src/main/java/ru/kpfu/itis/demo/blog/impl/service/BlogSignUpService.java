package ru.kpfu.itis.demo.blog.impl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.demo.blog.api.dto.UserDTO;
import ru.kpfu.itis.demo.blog.api.form.UserForm;
import ru.kpfu.itis.demo.blog.api.service.SignUpService;
import ru.kpfu.itis.demo.blog.impl.entity.UserEntity;
import ru.kpfu.itis.demo.blog.impl.jpa.repository.UserRepository;

/**
 * @author Anvar Khasanov
 * student of ITIS KFU
 * group 11-905
 */

@Service
public class BlogSignUpService implements SignUpService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void register(UserForm userForm) {
        UserEntity newUser = UserEntity.builder()
                .name(userForm.getName())
                .email(userForm.getEmail())
                .password(passwordEncoder.encode(userForm.getPassword()))
                .role(UserEntity.Role.USER)
                .build();

        userRepository.save(newUser);
    }
}
