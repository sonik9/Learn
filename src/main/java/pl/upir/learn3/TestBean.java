package pl.upir.learn3;

import org.springframework.stereotype.Component;

/**
 * Created by Vitalii on 26.05.2015.
 */
@Component("testBean")
public class TestBean {
    public void foo(int i){
        System.out.println("foo()"+i);
    }

    public void bar(){
        System.out.println("bar()");
    }
}
