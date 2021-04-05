package ru.kpfu.itis.demo.blog.web.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http.formLogin()
                .loginPage("/signIn")
                .usernameParameter("email")
                .loginProcessingUrl("/signIn")
                .defaultSuccessUrl("/profile")
                .failureUrl("/signIn&error");

        http.logout()
                .logoutUrl("/logOut")
                .logoutRequestMatcher(new AntPathRequestMatcher("/logOut", "GET"))
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID");

    }
}
