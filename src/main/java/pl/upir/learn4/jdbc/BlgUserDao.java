package pl.upir.learn4.jdbc;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Vitalii on 28.05.2015.
 */

public interface BlgUserDao {

    public List<BlgUser> findAll();
    public List<BlgUser> findByLogin(String login);
    public String findLoginbyId(int id);
    public void insert(BlgUser blgUser);
    public void update(BlgUser blgUser);
    public void delete(int usr_id);
}
