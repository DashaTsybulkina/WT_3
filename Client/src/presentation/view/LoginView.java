package presentation.view;

import entity.User;
import service.ServiceFactory;
import service.UserService;

import java.util.Scanner;

public class LoginView implements PresentationView{
    private UserService service;

    public LoginView() {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        service = serviceFactory.getApplianceService();
    }
    @Override
    public PresentationView show(User user) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter login");
        String login = scanner.nextLine();
        System.out.println("Enter password");
        String password = scanner.nextLine();
        user.setLogin(login);
        user.setPassword(password);
        user = service.checkUser(user);
        return new LoginView();
    }
}
