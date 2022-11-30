package service.impl;

import dao.DaoFactory;
import dao.UserDao;
import entity.Student;
import entity.User;
import org.xml.sax.SAXException;
import service.UserService;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public class UserServiceImpl implements UserService {
    private final DaoFactory daoFactory = DaoFactory.getInstance();
    private final UserDao userDAO = daoFactory.getApplianceDAO();

    @Override
    public User login(User user) {
        User editUser = null;
        editUser = userDAO.login(user);
        return editUser;

    }

    @Override
    public void registrationUser(User user) {
        userDAO.registration(user);
    }

    @Override
    public boolean edit(Student newValue) {
        return userDAO.edit(newValue);
    }

    @Override
    public List<Student> getAll() {
        return userDAO.getAll();
    }

    @Override
    public List<Student> get(String lastname) {
        return userDAO.get(lastname);
    }

    @Override
    public boolean create(Student student) {
        return userDAO.create(student);
    }
}
