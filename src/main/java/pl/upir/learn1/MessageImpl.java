package pl.upir.learn1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import pl.upir.learn1.MessageInterface;


/**
 * Created by Vitalii on 21.05.2015.
 */
@Service("messageInterface")
@Scope("prototype")
public class MessageImpl implements MessageInterface{
    @Value("#{properties.messageXml}")
    private String message;
/*    @Autowired
    public MessageImpl(@Value("#{properties.messageAnnotation}")String message){
        this.message=message;
    }*/
    @Override
    public String getMessage() {
        return message;
    }
    @Autowired
    public void setMessage(String message){
        this.message=message;
    }
}
