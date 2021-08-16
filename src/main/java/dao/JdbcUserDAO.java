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
    public void createUser(String user, String password) {
        String sql = "insert into quiztable (user_id, username, user_password, user_score) values (?, ?, ?, ?)";
        int userID = (int) getUserCount() + 1;
        jdbcTemplate.update(sql, userID, user, password, 0);


   }

    @Override
    public boolean isUsernameValid(String username) {
        String checkForUsername = "";
        String sql = "select * from quiztable where username = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, username);
        if(results.next()) {
           checkForUsername = results.getString("username");
        }
        if(checkForUsername.equals(username)){
            System.out.println("username is valid");
            return true;
        }

        System.out.println("username is not valid");
        return false;
    }

    @Override
    public boolean isPasswordValid(String password) {
        String checkForPassword = "";
        String sql = "select * from quiztable where user_password = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, password);
        if(results.next()) {
            checkForPassword = results.getString("user_password");
        }
        if(checkForPassword.equals(password)){
            System.out.println("password is valid");
            return true;
        }

        System.out.println("password is not valid");
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

    private long getUserCount() {
        long getCount = 0;
        String sql1 = "select count(*) from quiztable";
        long count = jdbcTemplate.queryForObject(sql1, Long.class);
        getCount = count;

        return getCount;
    }

}
