package dao;

import dao.impl.ServerDAOImpl;

public class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();
    private final ServerDAO userDAO = new ServerDAOImpl();
    private DAOFactory() {}
    public static DAOFactory getInstance() {
        return instance;
    }
    public ServerDAO getApplianceDAO() {
        return userDAO;
    }
}
