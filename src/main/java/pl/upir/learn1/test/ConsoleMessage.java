package pl.upir.learn1.test;

import pl.upir.learn1.MessageInterface;
import pl.upir.learn1.RenderInterface;

/**
 * Created by Vitalii on 21.05.2015.
 */
public class ConsoleMessage {
    public static void main(String[] args){
        RenderInterface ri = MessageSupportFactory.getInstance().getRender();
        MessageInterface mi = MessageSupportFactory.getInstance().getMessage();
        ri.setMessage(mi);
        ri.render();
    }
}