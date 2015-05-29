package pl.upir.learn1;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

/**
 * Created by Vitalii on 21.05.2015.
 */

public class ConsoleMessageSpring {
   public static void main(String[] args){
       ApplicationContext ctx= new ClassPathXmlApplicationContext("WEB-INF/spring/root-context.xml");
       //BeanFactory beanFactory = getBeanFactory();
       MessageInterface mi=ctx.getBean("messageInterface",MessageInterface.class);
       mi.setMessage("Hallo");
       RenderInterface ri= ctx.getBean("renderInterface", RenderInterface.class);
       RenderInterface ri1= ctx.getBean("renderInterface", RenderInterface.class);
       ri.setMessage(mi);
       ri.render();
       ri1.render();
   }

}
