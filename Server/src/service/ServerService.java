package service;

import entity.Student;
import entity.User;

import java.util.List;

public interface ServerService {
    boolean edit(Student newValue);

    List<Student> getAll();

    List<Student> get(String lastName);

    boolean create(Student student);

    User login(User user);

    User register(User user);
}
