package pl.upir.learn2;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by Vitalii on 26.05.2015.
 */
public class SecurityAdvice implements MethodBeforeAdvice {

    private SecurityManager securityManager;
    public SecurityAdvice(){
        this.securityManager=new SecurityManager();
    }


    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        UserInfo user = securityManager.getLoggedOnUser();

        if(user==null){
            System.out.println("No user auth");
            throw new SecurityException("You must login before attempting to invoke the method"+method.getName());
        }else if("clarence".equals(user.getUserName())){
            System.out.println("Logged in user is clarance - OKAY!");
        }else {
            System.out.println("Logged in user is " + user.getUserName() + " not good");
            throw new SecurityException("User"+user.getUserName()+" is not allowed to meth "+method.getName());
        }

    }
}
