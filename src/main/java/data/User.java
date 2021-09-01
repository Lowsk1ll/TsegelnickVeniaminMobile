package data;

public class User {

    public static final User DEFAULT = new User("example@gmail.com", "example", "12345678");

    private String email;
    private String userName;
    private String password;

    public String getEmail() {
        return this.email;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getPassword() {
        return this.password;
    }

    public User(String email, String userName, String password) {
        this.email = email;
        this.userName = userName;
        this.password = password;
    }
}
