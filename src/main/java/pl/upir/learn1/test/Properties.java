package pl.upir.learn1.test;

import org.springframework.stereotype.Component;

/**
 * Created by Vitalii on 25.05.2015.
 */
@Component
public class Properties {
    private String messageXml="Hallo world Properties XML";
    private String messageAnnotation="Hallo world Properties Annotation";
    private int i;

    public String getMessageXml() {
        return messageXml;
    }

    public void setMessageXml(String messageXml) {
        this.messageXml = messageXml;
    }



    public String getMessageAnnotation() {
        return messageAnnotation;
    }

    public void setMessageAnnotation(String message) {
        this.messageAnnotation = message;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }





}
