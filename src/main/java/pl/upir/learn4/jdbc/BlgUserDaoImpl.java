package pl.upir.learn4.jdbc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vitalii on 28.05.2015.
 */
public class BlgUserDaoImpl implements BlgUserDao {
   // @Value("#{app.jdbc.url}")
    private static String url="jdbc:mysql://localhost:3306/blog_java";
    //@Value("#{app.jdbc.username}")
    private static String dbUsername="root";
   // @Value("#{app.jdbc.password}")
    private static String dbPass="bridg01";

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException ex){
            System.out.println("Driver is unable " + ex.getMessage());
        }
    }

    private Connection getConnection() throws SQLException{

        return DriverManager.getConnection(url,dbUsername,dbPass);
    }

    private void closeConnection(Connection connection){
        if(connection==null) return;
        try{
            connection.close();
        }catch (SQLException ex){
            System.out.println("Close connection problems " + ex.getMessage());
        }
    }

    @Override
    public List<BlgUser> findAll() {
        List<BlgUser> result=new ArrayList<BlgUser>();
        Connection connection=null;
        try{
            connection=getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM blg_users");
            ResultSet resultSet=statement.executeQuery();
            while (resultSet.next()){
                BlgUser blgUser = new BlgUser();
                blgUser.setUsr_id(resultSet.getInt("usr_id"));
                blgUser.setUsr_login(resultSet.getString("usr_login"));
                //blgUser.setUsr_pass(resultSet.getString("usr_pass"));
                blgUser.setUsr_dateTimeChange(resultSet.getTimestamp("usr_dateTimeChange"));
                result.add(blgUser);
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }finally {
            closeConnection(connection);
        }
        return result;
    }

    @Override
    public List<BlgUser> findByLogin(String login) {
        return null;
    }

    @Override
    public String findLoginbyId(int id) {
        return null;
    }

    @Override
    public void insert(BlgUser blgUser) {
        Connection connection=null;
        try{
            connection=getConnection();
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO blg_users(usr_login,usr_password) VALUES (?,?)",
                    Statement.RETURN_GENERATED_KEYS
            );
            statement.setString(1, blgUser.getUsr_login());
            statement.setString(2, blgUser.getUsr_pass());
            statement.execute();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if(generatedKeys.next()){
                blgUser.setUsr_id(generatedKeys.getInt(1));
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }finally {
            closeConnection(connection);
        }

    }

    @Override
    public void update(BlgUser blgUser) {

    }

    @Override
    public void delete(int usr_id) {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement statement= connection.prepareStatement("DELETE FROM blg_users WHERE usr_id=?");
            statement.setInt(1,usr_id);
            statement.execute();
        }catch (SQLException ex){
            ex.printStackTrace();
        }finally {
            closeConnection(connection);
        }

    }
}
