package pl.upir.learn4.spring;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.impl.LogFactoryImpl;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import pl.upir.learn4.jdbc.BlgUser;
import pl.upir.learn4.jdbc.BlgUserDao;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Vitalii on 28.05.2015.
 */
//@Service("blgUserDao")
@Repository("blgUserDao")
public class JdbcBlgUserDao implements BlgUserDao, InitializingBean {
   // private Log log = LogFactory.getLog(JdbcBlgUserDao.class);

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate parameterJdbcTemplate;

    private SelectAllUsers selectAllUsers;

    //@Resource(name="dataSource")
    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.parameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
       /* MySQLErrorCodesTranslator errorCodesTranslator= new MySQLErrorCodesTranslator();
        errorCodesTranslator.setDataSource(dataSource);
        jdbcTemplate.setExceptionTranslator(errorCodesTranslator);*/
        selectAllUsers = new SelectAllUsers(dataSource);

    }

    public DataSource getDataSource(){
        return dataSource;
    }

    public void afterPropertiesSet() throws Exception{
        if (dataSource==null){
            throw new BeanCreationException("Must set dataSource on BlgUserDao");
        }
    }

    public List<BlgUser> findAll() {
        return selectAllUsers.execute();
    }

    @Override
    public List<BlgUser> findByLogin(String login) {
        //return jdbcTemplate.query("select usr_id, usr_login, usr_dateTimeChange from blg_users", new UserMapper());
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("usr_login",login);
        return parameterJdbcTemplate.query("select * from blg_users",map,new UserMapper());
    }

    @Override
    public String findLoginbyId(int id) {
        //String login = jdbcTemplate.queryForObject("select us_login from blg_users where usr_id=?",new Object[]{id},String.class);
        // return login;
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("usr_id",id);
        return parameterJdbcTemplate.queryForObject("select usr_login from blg_users where usr_id=:usr_id", map, String.class);
    }

    @Override
    public void insert(BlgUser blgUser) {

    }

    @Override
    public void update(BlgUser blgUser) {

    }

    @Override
    public void delete(int usr_id) {

    }

    private static final class UserMapper implements RowMapper<BlgUser> {

        @Override
        public BlgUser mapRow(ResultSet rs, int rowNum) throws SQLException {
            BlgUser blgUser = new BlgUser();
            blgUser.setUsr_id(rs.getInt("usr_id"));
            blgUser.setUsr_login(rs.getString("usr_login"));
            blgUser.setUsr_dateTimeChange(rs.getTimestamp("usr_dateTimeChange"));
            return blgUser;
        }
    }
}

