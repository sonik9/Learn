package pl.upir.learn3;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by Vitalii on 26.05.2015.
 */
@Component("myAdvice")
@Aspect
public class MyAdvice {

    @Pointcut("execution(* pl.upir.learn3..foo*(int)) && args(i)")
    public void fooExecution(int i) {

    }

    @Pointcut("bean(testBean)")
    public void inTestBean() {

    }

    /*public void simpleBeforeAdvice(JoinPoint joinPoint){
        System.out.println("Execute: "+joinPoint.getSignature().getDeclaringTypeName()+" "+joinPoint.getSignature().getName());
    }*/
    @Before("fooExecution(i) && inTestBean()")
    public void simpleBeforeAdvice(JoinPoint joinPoint, int i) {
        if (i != 100) {
            System.out.println("Execute: " + joinPoint.getSignature().getDeclaringTypeName() + " " + joinPoint.getSignature().getName());
        }
    }

    @Around("fooExecution(i)&& inTestBean()")
    public Object simpleAroundAdvice(ProceedingJoinPoint pjp, int i) throws Throwable {
        System.out.println("before Execute: " + pjp.getSignature().getDeclaringTypeName() + " " + pjp.getSignature().getName());
        Object o = pjp.proceed();
        System.out.println("after Execute: " + pjp.getSignature().getDeclaringTypeName() + " " + pjp.getSignature().getName());
        return o;
    }

}
