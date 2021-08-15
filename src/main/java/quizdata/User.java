package quizdata;

public class User {

    private long user_id;
    private String username;
    private String user_password;
    private int user_score;

    public User(String username) {
        this.username = username;
    }

    public User() {

    }

    public long getUser_id() {
        return user_id;
    }

    public String getUsername() {
        return username;
    }

    public String getUser_password() {
        return user_password;
    }

    public int getUser_score() {
        return user_score;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public void setUser_score(int user_score) {
        this.user_score = user_score;
    }

    @Override
    public String toString() {

        return username;
    }
}
