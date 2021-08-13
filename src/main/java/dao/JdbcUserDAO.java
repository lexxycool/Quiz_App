package dao;

import org.springframework.jdbc.core.JdbcTemplate;
import quizdata.User;

import javax.sql.DataSource;
import java.util.List;


public class JdbcUserDAO implements UserDAO {

    public JdbcTemplate jdbcTemplate;


    public JdbcUserDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public User saveUser(String username, String password) {
      int id = jdbcTemplate.queryForObject("insert into quiztable (username, user_password) " +
              "values(?, ?) returning id", int.class, username, password);

      User newUser = new User();
      newUser.setUser_id(id);
      newUser.setUsername(username);
      newUser.setUser_password(password);

      return newUser;

    }

    @Override
    public boolean isUsernameAndPasswordValid(String username, String password) {
        return false;
    }

    @Override
    public List<User> getAllUserScores() {
        return null;
    }
}
