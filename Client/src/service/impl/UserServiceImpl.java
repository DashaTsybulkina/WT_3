package service.impl;

import dao.DaoFactory;
import dao.UserDao;
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
    public User checkUser(User user) {
        User editUser = null;
        try {
            editUser = userDAO.checkUser(user);
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
        return editUser;

    }

    @Override
    public void registrationUser(User user) {
        try {
            userDAO.registration(user);
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }
}
