package presentation.view;

import entity.User;

import java.util.Scanner;

public class GuestView extends PresentationView{
    public GuestView(User user) {
        super(user);
    }

    @Override
    public PresentationView show() {
        System.out.println("1: Register\n2: Login\n3: exit");
        Scanner scanner = new Scanner(System.in);
        return switch (scanner.nextLine()) {
            case "1" -> new RegisterView(currentUser);
            case "2" -> new LoginView(currentUser);
            case "3" -> null;
            default -> throw new IllegalArgumentException();
        };
    }
}
