package ru.kpfu.itis.demo.blog.web.mock;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Method;

public class DataHolder {
    private Method method;
    private Object[] args;
    private Object returnObject;

    public DataHolder(Method method, Object[] args, Object returnObject) {
        this.method = method;
        this.args = args;
        this.returnObject = returnObject;
    }

    public Method getMethod() {
        return method;
    }

    public Object[] getArgs() {
        return args;
    }

    public Object getReturnObject() {
        return returnObject;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }

    public void setReturnObject(Object returnObject) {
        this.returnObject = returnObject;
    }
}
