package ru.kpfu.itis.demo.blog.impl.service;

import org.springframework.stereotype.Service;
import ru.kpfu.itis.demo.blog.impl.aspect.DemoBefore;

@Service
public class TestAopService {
    public void sayHello(){
        System.out.println("Hello");
        privateHello();
    }

    @DemoBefore
    public String hello(){
        return "Hello";
    }

    public void publicHello(){
        System.out.println("public Hello");
    }
    private void privateHello(){
        System.out.println("private Hello");
    }
}
