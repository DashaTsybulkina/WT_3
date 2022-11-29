package presentation.view;

import entity.User;

import java.util.Scanner;

public class GuestView implements PresentationView{
    @Override
    public PresentationView show(User user) {
        System.out.println("1: Register\n2: Login\n3: exit");
        Scanner scanner = new Scanner(System.in);
        return switch (scanner.nextLine()) {
            case "1" -> new RegisterView();
            case "2" -> new LoginView();
            case "3" -> null;
            default -> throw new IllegalArgumentException();
        };
    }
}
