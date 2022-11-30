package presentation.view;

import entity.User;
import service.ServiceFactory;
import service.UserService;

import javax.swing.plaf.IconUIResource;
import java.util.Scanner;

public class LoginView extends PresentationView{
    private UserService service;

    public LoginView(User user) {
        super(user);
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        service = serviceFactory.getApplianceService();
    }
    @Override
    public PresentationView show() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter login");
        String login = scanner.nextLine();
        System.out.println("Enter password");
        String password = scanner.nextLine();
        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        currentUser = service.login(user);
        return switch (this.currentUser.getPermission()) {
            case "R" -> new UserView(currentUser);
            case "RW" -> new AdminView(currentUser);
            default -> new GuestView(new User());
        };
    }
}
