package ru.kpfu.itis.demo.blog.impl.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.demo.blog.api.dto.SignUpForm;
import ru.kpfu.itis.demo.blog.api.dto.UserDTO.State;
import ru.kpfu.itis.demo.blog.api.dto.UserDTO.Role;
import ru.kpfu.itis.demo.blog.api.service.SignUpService;
import ru.kpfu.itis.demo.blog.impl.entity.UserEntity;
import ru.kpfu.itis.demo.blog.impl.jpa.repository.UserRepository;

@Service
public class BlogSignUpService implements SignUpService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public BlogSignUpService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Boolean signUp(SignUpForm signUpForm) {
        if (userRepository.findByEmail(signUpForm.getEmail()).isPresent()) {
            return false;
        }

        UserEntity userEntity = modelMapper.map(signUpForm, UserEntity.class);

        userEntity.setRole(Role.USER);
        userEntity.setState(State.ACTIVE);

        userRepository.save(userEntity);
        return true;
    }
}
