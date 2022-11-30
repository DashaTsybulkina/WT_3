package entity;

import java.io.Serializable;

public class User implements Serializable {
    private String login;
    private String password;
    private String permission;

    public User(String login, String password, String premission) {
        this.login = login;
        this.password = password;
        this.permission = premission;
    }

    public User() {
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

    public String getPermission() {
        return permission;
    }

    public void setPermission(String premission) {
        this.permission = premission;
    }
}
