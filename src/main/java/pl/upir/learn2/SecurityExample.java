package pl.upir.learn2;

import org.springframework.aop.framework.ProxyFactory;

/**
 * Created by Vitalii on 26.05.2015.
 */
public class SecurityExample {

    public static void main(String[] args){
        SecurityManager securityManager=new SecurityManager();
        SecureBean secureBean = getSecureBean();

        securityManager.login("clarence1","pwd");
        secureBean.WriteSecureMessage();
        securityManager.logout();

       /* try{
            securityManager.login("wetal","wetal");
            secureBean.WriteSecureMessage();
        }catch (SecurityException ex){
            System.out.println("Exception: " + ex.getMessage());
        }finally {
            securityManager.logout();
        }

        try{
            secureBean.WriteSecureMessage();
        }catch (SecurityException ex){
            System.out.println("Exception: "+ex.getMessage());
        }*/
    }

    private static SecureBean getSecureBean(){
        SecureBean target = new SecureBean();
        SecurityAdvice advice = new SecurityAdvice();
        ProxyFactory factory = new ProxyFactory();
        factory.setTarget(target);
        factory.addAdvice(advice);
        SecureBean proxy=(SecureBean)factory.getProxy();
        return proxy;
    }
}
