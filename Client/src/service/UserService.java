package service;

import entity.Student;
import entity.User;

import java.util.List;

public interface UserService {
    User login(User user);
    void registrationUser(User user);

    boolean edit(Student newValue);

    List<Student> getAll();

    List<Student> get(String lastname);

    boolean create(Student student);
}
