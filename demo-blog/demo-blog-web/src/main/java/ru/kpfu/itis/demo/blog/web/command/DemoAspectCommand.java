package ru.kpfu.itis.demo.blog.web.command;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.kpfu.itis.demo.blog.impl.service.TestAopService;

@Component
public class DemoAspectCommand implements CommandLineRunner {
    private final TestAopService service;

    public DemoAspectCommand(TestAopService service) {
        this.service = service;
    }

    @Override
    public void run(String... args) throws Exception {
        service.sayHello();
        service.publicHello();
        System.out.println(service.hello());
    }
}
