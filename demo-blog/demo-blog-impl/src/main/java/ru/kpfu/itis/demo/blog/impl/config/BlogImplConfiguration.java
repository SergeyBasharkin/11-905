package ru.kpfu.itis.demo.blog.impl.config;

import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

@Configuration
//@ComponentScan("ru.kpfu.itis.demo.blog.impl.repository")
@ComponentScan("ru.kpfu.itis.demo.blog.impl.service")
@EnableJpaRepositories(basePackages = "ru.kpfu.itis.demo.blog.impl.jpa.repository")
@EntityScan(basePackages = "ru.kpfu.itis.demo.blog.impl.entity")
public class BlogImplConfiguration {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
