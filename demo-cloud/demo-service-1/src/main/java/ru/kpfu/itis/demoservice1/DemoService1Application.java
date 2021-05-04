package ru.kpfu.itis.demoservice1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class DemoService1Application {

    public static void main(String[] args) {
        SpringApplication.run(DemoService1Application.class, args);
    }

    @Value("${server.port}")
    private String port;

    @GetMapping
    public String hello(){
        return "Hello from service-1 on " + port;
    }
}
