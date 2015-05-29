package pl.upir.learn1.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.security.PrivateKey;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.Properties;

/**
 * Created by Vitalii on 25.05.2015.
 */
@Service("injectCollection")
public class CollectionInjection {
    @Resource(name = "map")
    private Map<String,Object> map;
    @Resource(name = "props")
    private Properties props;
    @Resource(name = "set")
    private Set set;
    @Resource(name = "list")
    private List list;

    public static void main(String[] args){
        ApplicationContext ctx= new ClassPathXmlApplicationContext("WEB-INF/spring/root-context.xml");
        CollectionInjection instance=(CollectionInjection)ctx.getBean("injectCollection");
        instance.displayInfo();

    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public void setProps(Properties properties) {
        this.props = properties;
    }

    public void setSet(Set set) {
        this.set = set;
    }

    public void setList(List list) {
        this.list = list;
    }

    public void displayInfo(){
        System.out.println("Map content:");
        for(Map.Entry<String, Object> entry: map.entrySet()) {
            System.out.println("Key:"+entry.getKey()+"- value: "+entry.getValue());
        }

        System.out.println("\nProperties content:");
        for(Map.Entry entry: props.entrySet()){
            System.out.println("Key:"+entry.getKey()+"- value: "+entry.getValue());
        }

        System.out.println("\nSet content:");
        for(Object o:set){
            System.out.println("value: "+o);
        }

        System.out.println("\nList content:");
        for(Object o:list){
            System.out.println("value: "+o);
        }

    }

}
