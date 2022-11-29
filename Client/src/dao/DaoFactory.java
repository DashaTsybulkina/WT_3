package dao;

import dao.impl.UserDaoImpl;

public class DaoFactory {
    private static final DaoFactory instance = new DaoFactory();
    private final UserDao userDAO = new UserDaoImpl();

    private DaoFactory() {}
    public static DaoFactory getInstance() {
        return instance;
    }
    public UserDao getApplianceDAO() {
        return userDAO;
    }

}
