package com.googol24.spring.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LogInterceptor implements InvocationHandler {

    // 被代理对象
    private Object target;

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    private void beforeMethod(Method m) {
        System.out.println(m.getName() + " start......");
    }

    private void afterMethod(Method m) {
        System.out.println(m.getName() + " end------");
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 代理自己的业务逻辑
        this.beforeMethod(method);

        // proxy:com.sun.proxy.$Proxy2类的实例

        // 被代理对象的业务逻辑
        method.invoke(target, args);

        // 代理自己的业务逻辑
        this.afterMethod(method);

        return null;
    }
}
