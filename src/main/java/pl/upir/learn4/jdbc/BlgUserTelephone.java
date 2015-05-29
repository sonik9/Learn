package pl.upir.learn4.jdbc;

import java.io.Serializable;

/**
 * Created by Vitalii on 28.05.2015.
 */
public class BlgUserTelephone implements Serializable {
    private int usr_tel_id;
    private int usr_id;
    private String usr_tel_type;
    private String usr_tel_numb;

    public int getUsr_tel_id() {
        return usr_tel_id;
    }

    public void setUsr_tel_id(int usr_tel_id) {
        this.usr_tel_id = usr_tel_id;
    }

    public int getUsr_id() {
        return usr_id;
    }

    public void setUsr_id(int usr_id) {
        this.usr_id = usr_id;
    }

    public String getUsr_tel_type() {
        return usr_tel_type;
    }

    public void setUsr_tel_type(String usr_tel_type) {
        this.usr_tel_type = usr_tel_type;
    }

    public String getUsr_tel_numb() {
        return usr_tel_numb;
    }

    public void setUsr_tel_numb(String usr_tel_numb) {
        this.usr_tel_numb = usr_tel_numb;
    }

    @Override
    public String toString() {
        return "BlgUserTelephone{" +
                "usr_tel_id=" + usr_tel_id +
                ", usr_id=" + usr_id +
                ", usr_tel_type='" + usr_tel_type + '\'' +
                ", usr_tel_numb='" + usr_tel_numb + '\'' +
                '}';
    }
}
