package entities;

public enum User {

    ROMAN("user@Renata", "Roman", "1234567890");

    private final String email;
    private final String username;
    private final String password;

    User(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
