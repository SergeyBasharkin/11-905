package ru.kpfu.itis.demo.blog.web.security.provider;

import io.jsonwebtoken.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import ru.kpfu.itis.demo.blog.api.exception.NotFoundException;
import ru.kpfu.itis.demo.blog.impl.entity.UserEntity;
import ru.kpfu.itis.demo.blog.web.exception.PostNotFoundException;
import ru.kpfu.itis.demo.blog.web.security.config.JwtProperties;
import ru.kpfu.itis.demo.blog.web.security.details.UserDetailsImpl;

import java.util.Collections;
import java.util.Date;
import java.util.Optional;

@Component
public class JwtAuthenticationProvider {

    private final JwtProperties jwtProperties;

    public JwtAuthenticationProvider(JwtProperties jwtProperties) {
        this.jwtProperties = jwtProperties;
    }

    public Optional<Authentication> authenticate(String token) throws PostNotFoundException {
        if (StringUtils.hasLength(token)){
            try {
                Jws<Claims> claims = Jwts.parser().setSigningKey(jwtProperties.getSecret()).parseClaimsJws(token);
                UserEntity userEntity = new UserEntity();
                userEntity.setUsername(claims.getBody().getSubject());
                return Optional.of(new UsernamePasswordAuthenticationToken(new UserDetailsImpl(userEntity), "",  Collections.singleton(new SimpleGrantedAuthority("Test"))));
            } catch (JwtException | IllegalArgumentException e) {
                throw new PostNotFoundException("Unauthorized");
            }

        }
        return Optional.empty();
    }

    public String createToken(String login) {
        Claims claims = Jwts.claims().setSubject(login);
        Date now = new Date();
        Date validity = new Date(now.getTime() + jwtProperties.getValidity());
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(SignatureAlgorithm.HS256, jwtProperties.getSecret())
                .compact();

    }
}
