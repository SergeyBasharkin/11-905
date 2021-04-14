package ru.kpfu.itis.demo.blog.web.mock;

import java.lang.reflect.Proxy;

public class CustomMockito {

    static CustomMockInvocationHandler lastInvocationHandler;

    public static <T> T mock(Class<T> c) {
        return (T) Proxy.newProxyInstance(
                CustomMockito.class.getClassLoader(),
                new Class[]{c},
                new CustomMockInvocationHandler()
        );
    }

    public static When when(Object o) {
        return new When();
    }

    public static class When{
        public void thenReturn(Object o) {
            lastInvocationHandler.setReturnObject(o);
        }
    }
}
