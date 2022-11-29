package service;

import service.impl.UserServiceImpl;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();
    private final UserService applianceService = new UserServiceImpl();

    /**
     * Private constructor to have no possibilities to create object of class
     */
    private ServiceFactory() {}

    public UserService getApplianceService() {
        return applianceService;
    }

    public static ServiceFactory getInstance() {
        return instance;
    }
}
