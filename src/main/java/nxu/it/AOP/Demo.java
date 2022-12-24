package nxu.it.AOP;

import cn.hutool.aop.ProxyUtil;

public class Demo {

    public void doIt(){
        System.out.println("doIt()!");
    }

    public static void main(String[] args) {
        Demo demo = ProxyUtil.proxy(new Demo(), DemoAspect.class);
        demo.doIt();
    }
}
