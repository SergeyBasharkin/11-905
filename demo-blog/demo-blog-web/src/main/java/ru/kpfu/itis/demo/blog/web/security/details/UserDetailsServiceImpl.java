package ru.kpfu.itis.demo.blog.web.security.details;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ru.kpfu.itis.demo.blog.impl.entity.UserEntity;
import ru.kpfu.itis.demo.blog.impl.jpa.repository.UserRepository;

@Component("customUserDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity user = repository.findByEmail(email).orElseThrow(()-> new UsernameNotFoundException("User nor found"));
        return new UserDetailsImpl(user);
    }
}
