package service;

import service.impl.ServerServiceImpl;
import service.impl.UserServiceImpl;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();
    private final ServerService serverService = new ServerServiceImpl();

    /**
     * Private constructor to have no possibilities to create object of class
     */
    private ServiceFactory() {}

    public ServerService getServerService() {
        return serverService;
    }

    public static ServiceFactory getInstance() {
        return instance;
    }
}
