package ru.kpfu.itis.demo.blog.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.zip.Adler32;

import static java.util.Optional.ofNullable;

@SpringBootApplication
public class DemoBlogApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoBlogApiApplication.class, args);
    }

}
