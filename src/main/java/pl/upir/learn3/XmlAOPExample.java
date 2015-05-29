package pl.upir.learn3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Vitalii on 26.05.2015.
 */
public class XmlAOPExample {
    public static void main(String[] args){
        ApplicationContext applicationContext= new ClassPathXmlApplicationContext("WEB-INF/spring/aop-annot-app-context.xml");
     /*   TestBean mb=(TestBean)applicationContext.getBean("proxy");
        mb.bar();
        mb.foo()*/;


        /*MyBean bean2 = (MyBean)applicationContext.getBean("myBean2");
        MyBean bean3 = (MyBean)applicationContext.getBean("myBean3");
        bean2.execute();
        bean3.execute();*/

        MyBean bean4 = (MyBean)applicationContext.getBean("myBean");
        bean4.execute();
    }
}
