package ru.kpfu.itis.demo.blog.impl.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.demo.blog.api.dto.UserDTO;
import ru.kpfu.itis.demo.blog.api.service.UserService;
import ru.kpfu.itis.demo.blog.impl.entity.UserEntity;
import ru.kpfu.itis.demo.blog.impl.jpa.repository.UserRepository;

import java.util.Optional;

@Service
public class BlogUserService implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public BlogUserService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Optional<UserDTO> findByEmail(String email) {
        return userRepository.findByEmail(email)
                .map(userEntity -> modelMapper.map(userEntity, UserDTO.class));
    }

    @Override
    public Page<UserDTO> findAll(Pageable pageable) {
        return userRepository.findAll(pageable)
                .map(userEntity -> modelMapper.map(userEntity, UserDTO.class));
    }

    @Override
    public Optional<UserDTO> findById(Long aLong) {
        return userRepository.findById(aLong)
                .map(userEntity -> modelMapper.map(userEntity, UserDTO.class));
    }

    @Override
    public Boolean save(UserDTO userDTO) {
        userDTO.setId(null);
        userRepository.save(modelMapper.map(userDTO, UserEntity.class));
        return true;
    }

    @Override
    public Boolean delete(UserDTO userDTO) {
        return null;
    }

    @Override
    public Boolean deleteById(Long aLong) {
        userRepository.deleteById(aLong);
        return false;
    }
}
