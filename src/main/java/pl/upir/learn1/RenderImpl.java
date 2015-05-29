package pl.upir.learn1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Created by Vitalii on 21.05.2015.
 */
@Service("renderInterface")
@Scope("prototype")
public class RenderImpl implements RenderInterface {
    private MessageInterface messageInterface;
    @Override
    public void render() {
        if(messageInterface==null){
            throw new RuntimeException(RenderImpl.class.getName());
        }else
            System.out.println(getMessage().getMessage());
    }

    @Override
    @Autowired
    public void setMessage(MessageInterface message) {
        this.messageInterface=message;
    }

    @Override
    public MessageInterface getMessage() {
        return messageInterface;
    }
}
