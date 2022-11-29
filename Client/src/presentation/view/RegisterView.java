package presentation.view;

import entity.User;
import service.ServiceFactory;
import service.UserService;

import java.util.Scanner;

public class RegisterView implements PresentationView{

    private UserService service;

    public RegisterView() {
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
        String permission;
        System.out.println("Enter permission:\n1.Admin\n2.User");
        switch (scanner.nextLine()) {
            case "1" ->  permission = "RW";
            case "2" -> permission = "R";
            default -> throw new IllegalArgumentException();
        };
        user.setPermission(permission);
        user.setLogin(login);
        user.setPassword(password);
        service.registrationUser(user);
        return new LoginView();
    }
}
