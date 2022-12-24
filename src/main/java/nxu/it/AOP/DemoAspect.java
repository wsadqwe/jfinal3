package nxu.it.AOP;

import cn.hutool.aop.aspects.SimpleAspect;

import java.lang.reflect.Method;

public class DemoAspect extends SimpleAspect {

    @Override
    public boolean before(Object target, Method method, Object[] args) {
        System.out.println("你好");
        return true;
    }

    @Override
    public boolean after(Object target, Method method, Object[] args, Object returnVal) {
        System.out.println("再见");
        return true;
    }
}
