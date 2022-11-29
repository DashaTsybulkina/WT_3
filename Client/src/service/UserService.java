package service;

import entity.User;

import java.util.List;

public interface UserService {
    User checkUser(User user);
    void registrationUser(User user);
}
