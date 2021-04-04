package ru.kpfu.itis.demo.blog.web.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.kpfu.itis.demo.blog.impl.config.BlogImplConfiguration;

@Configuration
@Import(BlogImplConfiguration.class)
public class BlogPostWebConfiguration {

}
