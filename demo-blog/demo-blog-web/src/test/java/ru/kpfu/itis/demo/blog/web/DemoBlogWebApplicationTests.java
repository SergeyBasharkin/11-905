package ru.kpfu.itis.demo.blog.web;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import ru.kpfu.itis.demo.blog.web.mock.CustomMockInvocationHandler;
import ru.kpfu.itis.demo.blog.web.mock.CustomMockito;

import static ru.kpfu.itis.demo.blog.web.mock.CustomMockito.when;

//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;

class DemoBlogWebApplicationTests {

    @Test
    void contextLoads() {

//        TestMock mock = mock(TestMock.class);
        TestMock mock2 = CustomMockito.mock(TestMock.class);

        when(mock2.hello("asd")).thenReturn("Bye Any");
        System.out.println(mock2.hello("World"));
        when(mock2.hello()).thenReturn("Bye");
        System.out.println(mock2.hello());



//        when(mock.hello()).thenReturn("Bye");
//        when(mock.hello(any())).thenReturn("Bye Any");

//        System.out.println(mock.hello());
//        System.out.println(mock.hello("World"));
    }

    public interface TestMock {
        String hello();

        String hello(String name);

    }

}
