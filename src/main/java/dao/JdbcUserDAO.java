package dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import quizdata.User;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;


public class JdbcUserDAO implements UserDAO {

    public JdbcTemplate jdbcTemplate;


    public JdbcUserDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<User> getAllUsers() {
        List<User> user = new ArrayList<>();
        String sql = "select * from quiztable";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
        while(result.next()) {
            User userList = new User();
            userList = mapRowToUser(result);
            user.add(userList);
        }

        return user;
    }

    @Override
    public User getUserById(int id) {
        User user = null;
        String sql = "select user_id, username, user_password, user_score from quiztable where user_id = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, id);

        if(result.next()) {
           user = mapRowToUser(result);
        }
        return user;
    }

    @Override
    public User createUser(User user) {

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

    private User mapRowToUser(SqlRowSet result) {
        User user = new User();
        user.setUser_id(result.getLong("user_id"));
        user.setUsername(result.getString("username"));
        user.setUser_password(result.getString("user_password"));
        user.setUser_score(result.getInt("user_score"));
        return user;
    }


}
