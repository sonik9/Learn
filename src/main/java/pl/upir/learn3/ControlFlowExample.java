package pl.upir.learn3;

import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.ControlFlowPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;

import java.lang.annotation.Target;

/**
 * Created by Vitalii on 26.05.2015.
 */
public class ControlFlowExample {
    public static void main(String[] args){
        ControlFlowExample example=new ControlFlowExample();
        example.run();
    }

    public void run(){
        TestBean target = new TestBean();

        Pointcut pc= new ControlFlowPointcut(ControlFlowExample.class, "test");
        Advisor advisor= new DefaultPointcutAdvisor(pc, new SimpleBeforeAdvice());
        ProxyFactory proxyFactory= new ProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.addAdvisor(advisor);
        TestBean proxy=(TestBean)proxyFactory.getProxy();
        System.out.println("Trying normal invoke");
        proxy.foo(1);

    }

    private void test(TestBean testBean){
        testBean.foo(1);
        System.out.print("ewefefwe");
    }
}
