package ru.kpfu.itis.demo.blog.impl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.kpfu.itis.demo.blog.api.dto.UserForm;
import ru.kpfu.itis.demo.blog.api.service.SignUpService;
import ru.kpfu.itis.demo.blog.impl.entity.UserEntity;
import ru.kpfu.itis.demo.blog.impl.jpa.repository.UsersRepository;

@Component
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public void signUp(UserForm userForm) {
        UserEntity newUser = UserEntity.builder()
                .email(userForm.getEmail())
                .hashPassword(passwordEncoder.encode(userForm.getPassword()))
                .role(UserEntity.Role.USER)
                .state(UserEntity.State.ACTIVE)
                .build();
        usersRepository.save(newUser);
    }
}
