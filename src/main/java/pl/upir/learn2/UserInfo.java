package pl.upir.learn2;

/**
 * Created by Vitalii on 26.05.2015.
 */
public class UserInfo {
    private String userName;
    private String password;

    public UserInfo(String userName, String password){
        this.password=password;
        this.userName=userName;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
