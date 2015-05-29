package pl.upir.learn3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Vitalii on 26.05.2015.
 */
@Component("myBean")
public class MyBean {
    private TestBean testBean;

   public void execute(){
        testBean.foo(101);
        testBean.bar();
    }

@Autowired
    public void setTestBean(TestBean testBean){
        this.testBean=testBean;
    }
}