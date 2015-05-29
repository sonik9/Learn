package pl.upir.learn1.test;

import pl.upir.learn1.MessageInterface;
import pl.upir.learn1.RenderInterface;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * Created by Vitalii on 21.05.2015.
 */
public class MessageSupportFactory {

    private static MessageSupportFactory instance=null;
    private Properties props=null;
    private RenderInterface render = null;
    private MessageInterface message=null;

    private MessageSupportFactory(){
        props = new Properties();
        try{
            props.load(new FileInputStream("D:\\Projects\\Java\\JAVA EE\\Learn1\\src\\main\\resources\\consoleMessage.properties"));
            String renderClass=props.getProperty("render.class");
            String messageClass=props.getProperty("message.class");
            render=(RenderInterface)Class.forName(renderClass).newInstance();
            message=(MessageInterface)Class.forName(messageClass).newInstance();
        }catch (Exception ex){
            ex.printStackTrace();
        };

    }
    static {instance=new MessageSupportFactory();}
    public static MessageSupportFactory getInstance(){
        return instance;
    }
    public RenderInterface getRender(){
        return render;
    }
    public MessageInterface getMessage(){
        return message;
    }

}
