package pl.upir.learn4.spring;

import org.springframework.jdbc.object.MappingSqlQuery;
import pl.upir.learn4.jdbc.BlgUser;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Vitalii on 29.05.2015.
 */
public class SelectAllUsers extends MappingSqlQuery<BlgUser> {

    private static final String SQL_SELECT="SELECT usr_id,usr_login,usr_password,usr_dateTimeChange FROM blg_users";
    public SelectAllUsers(DataSource dataSource){
        super(dataSource,SQL_SELECT);
    }

    @Override
    protected BlgUser mapRow(ResultSet rs, int rowNum) throws SQLException {
       BlgUser blgUser = new BlgUser();
        try {
            blgUser.setUsr_id(rs.getInt("usr_id"));
            blgUser.setUsr_login(rs.getString("usr_login"));
            blgUser.setUsr_pass(rs.getString("usr_pass"));
            blgUser.setUsr_dateTimeChange(rs.getTimestamp("usr_dateTimeChange"));
        }catch (SQLException e){
            e.printStackTrace();
        }
        return blgUser;
    }
}
