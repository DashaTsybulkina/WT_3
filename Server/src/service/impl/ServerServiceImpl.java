package service.impl;

import dao.DAOFactory;
import dao.ServerDAO;
import entity.Student;
import entity.User;
import org.xml.sax.SAXException;
import service.ServerService;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ServerServiceImpl implements ServerService {
    private final DAOFactory daoFactory = DAOFactory.getInstance();
    private final ServerDAO serverDAO = daoFactory.getApplianceDAO();

    @Override
    public boolean edit(Student newValue) {
        try {
            serverDAO.edit(newValue);
            return true;
        } catch (ParserConfigurationException | IOException | SAXException|TransformerException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Student> getAll() {
        List<Student> students= new ArrayList<>();
        try {
            students = serverDAO.getAll();;
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public List<Student> get(String lastName) {
        List<Student> students= new ArrayList<>();
        try {
            students = serverDAO.get(lastName);;
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public boolean create(Student student) {
        try {
            serverDAO.addStudent(student);
            return true;
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public User login(User user) {
        User loginUser  = null;
        try {
            loginUser = serverDAO.login(user);;
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
        return loginUser;
    }

    @Override
    public User register(User user) {
        User registerUser = null;;
        try {
            registerUser = serverDAO.register(user);;
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
        return registerUser;
    }
}
