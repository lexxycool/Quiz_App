package dao;

import org.springframework.jdbc.core.JdbcTemplate;
import quizdata.User;

import javax.sql.DataSource;
import java.util.List;


public class JdbcUserDAO implements UserDAO {

    private JdbcTemplate jdbcTemplate;


    public JdbcUserDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public User saveUser(String username, String password) {
        return null;
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
