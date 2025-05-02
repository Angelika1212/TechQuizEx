package model;

public class User {
    private String login;
    private String password;
    private int openedLevels;

    public User() {}

    public User(String login, String password, int openedLevels) {
        this.login = login;
        this.password = password;
        this.openedLevels = openedLevels;
    }
    
    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public int getOpenedLevels() {
        return openedLevels;
    }

    public void setOpenedLevels(int openedLevels) {
        this.openedLevels = openedLevels;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
