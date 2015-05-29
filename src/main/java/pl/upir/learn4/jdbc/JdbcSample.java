package pl.upir.learn4.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pl.upir.learn4.spring.JdbcBlgUserDao;

import java.util.List;

/**
 * Created by Vitalii on 28.05.2015.
 */
public class JdbcSample {
    private static BlgUserDao blgUserDao=new JdbcBlgUserDao();

    public static void main(String[] args){
        ApplicationContext ctx= new ClassPathXmlApplicationContext("WEB-INF/spring/jdbc-app-context.xml");
        //ctx.
        /*System.out.println("Listing all users:");
        listAllUsers();
        System.out.println("---------------------");
        System.out.println("New user");
        BlgUser blgUser = new BlgUser();
        blgUser.setUsr_login("User1");
        blgUser.setUsr_pass("1");
        blgUserDao.insert(blgUser);
        System.out.println("---------------------");
        System.out.println("Listing all users with new user:");
        listAllUsers();
        System.out.println("---------------------");
        System.out.println("Delete new user: user1:");
        blgUserDao.delete(blgUser.getUsr_id());
        System.out.println("---------------------");
        System.out.println("Listing all users without user1:");
        listAllUsers();*/

        blgUserDao = ctx.getBean("blgUserDao", BlgUserDao.class);
        System.out.println("Logins : " + blgUserDao.findLoginbyId(2));
        //List<BlgUser> blgUsers=blgUserDao.findAll();
        //listAllUsers(blgUsers);
        listAllUsers();

    }

    private static void listAllUsers(){
        List<BlgUser> users = blgUserDao.findAll();
        for(BlgUser user:users){
        //for(int i=0;i<=users.size();i++){
            System.out.println(user);
        }
    }

    private static void listByLogin(){
        List<BlgUser> users = blgUserDao.findByLogin("son");
        for (BlgUser user: users){
            System.out.println(user);
        }
    }

    private static void findAllUsers(){
        //List<BlgUser> users = blgUserDao.findAll();
    }
}
