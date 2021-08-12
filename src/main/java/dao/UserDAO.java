package dao;

import quizdata.User;

import java.util.List;

public interface UserDAO {

    public User saveUser(String username, String password);
    public boolean isUsernameAndPasswordValid(String username, String password);
    public List<User> getAllUserScores();
}
