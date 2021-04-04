package ru.kpfu.itis.demo.blog.impl.config;

import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Configuration
//@ComponentScan("ru.kpfu.itis.demo.blog.impl.repository")
@ComponentScan({
        "ru.kpfu.itis.demo.blog.impl.service",
        "ru.kpfu.itis.demo.blog.impl.aspect"
})
@EnableJpaRepositories(basePackages = "ru.kpfu.itis.demo.blog.impl.jpa.repository")
@EntityScan(basePackages = "ru.kpfu.itis.demo.blog.impl.entity")
@EnableJpaAuditing
@EnableAspectJAutoProxy
public class BlogImplConfiguration {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
