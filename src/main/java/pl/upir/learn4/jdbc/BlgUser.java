package pl.upir.learn4.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Vitalii on 28.05.2015.
 */
public class BlgUser implements Serializable{
    private int usr_id;
    private String usr_login;
    private String usr_pass;
    private Timestamp usr_dateTimeChange;
   // private List<BlgUserTelephone> blgUserTelephones;

    public int getUsr_id() {
        return usr_id;
    }
    public void setUsr_id(int usr_id) {
        this.usr_id = usr_id;
    }
    public String getUsr_login() {
        return usr_login;
    }
    public void setUsr_login(String usr_login) {
        this.usr_login = usr_login;
    }

    public Timestamp getUsr_dateTimeChange() {
        return usr_dateTimeChange;
    }
    public void setUsr_dateTimeChange(Timestamp usr_dateTimeChange) {
        this.usr_dateTimeChange = usr_dateTimeChange;
    }

   /* public List<BlgUserTelephone> getBlgUserTelephones() {
        return blgUserTelephones;
    }

    public void setBlgUserTelephones(List<BlgUserTelephone> blgUserTelephones) {
        this.blgUserTelephones = blgUserTelephones;
    }*/

   // @Override
    public String toString() {
        return "BlgUser{usr_id=" + usr_id + " usr_login=" + usr_login + " usr_dateTimeChange=" + usr_dateTimeChange +"}";
    }

    public String getUsr_pass() {
        return usr_pass;
    }

    public void setUsr_pass(String usr_pass) {
        this.usr_pass = usr_pass;
    }
}
