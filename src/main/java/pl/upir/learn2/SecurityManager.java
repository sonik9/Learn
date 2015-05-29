package pl.upir.learn2;

/**
 * Created by Vitalii on 26.05.2015.
 */
public class SecurityManager {
    private static ThreadLocal<UserInfo> threadLocal = new ThreadLocal<UserInfo>();

    public void login(String userName, String password){
        threadLocal.set(new UserInfo(userName,password));
    }

    public void logout(){
        threadLocal.set(null);
    }

    public UserInfo getLoggedOnUser(){
        return threadLocal.get();
    }


}
