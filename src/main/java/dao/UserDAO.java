package dao;

import quizdata.User;

import java.util.List;

public interface UserDAO {

    List<User> getAllUsers();
    User getUserById(int id);
    User createUser(User user);
    boolean isUsernameAndPasswordValid(String username, String password);
    List<User> getAllUserScores();


}
