package dao;

import quizdata.User;

import java.util.List;

public interface UserDAO {

    List<User> getAllUsers();
    User getUserById(int id);
    void createUser(String user, String password);
    boolean isUsernameValid(String username);
    boolean isPasswordValid(String password);
    void getUserAndScore(String username);
    void scores(int score, String username);




}
