package ru.kpfu.itis.demo.blog.web.security.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "jwt.authentication")
public class JwtProperties {
    private String secret;
    private Long validity;
}
