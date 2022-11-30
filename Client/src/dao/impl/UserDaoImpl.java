package dao.impl;

import dao.SocketManager;
import dao.UserDao;
import entity.Student;
import entity.User;
import entity.serverCommunication.Request;
import entity.serverCommunication.Response;
import entity.serverCommunication.StudentResponse;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private final SocketManager socketManager = new SocketManager("localhost", 5555);
    public User login(User user)  {
        StudentResponse response = socketManager
                .sendRequest(user, Request.LOGIN);
        if (response.getBody() instanceof User body) {
            return body;
        }
        return null;
    }

    public User registration(User user) {
        StudentResponse response = socketManager
                .sendRequest(user, Request.REGISTER);
        if (response.getBody() instanceof User body) {
            return body;
        }

        return null;
    }

    @Override
    public boolean edit(Student newValue) {
        StudentResponse response = socketManager
                .sendRequest(newValue, Request.EDIT);
        return (response != null)
                && (response.getResponse() == Response.OK);
    }

    @Override
    public List<Student> getAll() {
        StudentResponse response = socketManager
                .sendRequest(null, Request.GET_ALL);

        if ((response != null)
                && (response.getResponse() == Response.OK)
                && (response.getBody() instanceof ArrayList<?>)) {
            try {
                return (ArrayList<Student>) response.getBody();
            } catch (ClassCastException e) {
                return new ArrayList<>();
            }
        }
        return new ArrayList<>();
    }

    @Override
    public List<Student> get(String lastname) {
        StudentResponse response = socketManager
                .sendRequest(lastname, Request.GET);

        if ((response != null)
                && (response.getResponse() == Response.OK)
                && (response.getBody() instanceof ArrayList<?>)) {
            return (ArrayList<Student>) response.getBody();
        }

        return null;
    }

    @Override
    public boolean create(Student item) {
        StudentResponse response = socketManager
                .sendRequest(item, Request.CREATE);
        return (response != null)
                && (response.getResponse() == Response.OK);
    }
}
