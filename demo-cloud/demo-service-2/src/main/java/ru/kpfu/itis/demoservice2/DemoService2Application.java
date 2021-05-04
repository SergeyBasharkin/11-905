package ru.kpfu.itis.demoservice2;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class DemoService2Application {

    public static void main(String[] args) {
        SpringApplication.run(DemoService2Application.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){return new RestTemplate();}

    @Value("${server.port}")
    private String port;

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public IRule ribbonRule(){
        return new RandomRule();
    }

    @GetMapping
    public String hello(){
        return "Hello from service-2 on " + port;
    }

    @GetMapping("/{serviceName}")
    public String hello(@PathVariable String serviceName){
        System.out.println("/{serviceName}");
        return restTemplate.getForObject("http://" + serviceName + "/", String.class);
    }
}
