package presentation.view;

import entity.User;
import presentation.view.studentsView.GetAllView;
import presentation.view.studentsView.GetView;

import java.util.Scanner;

public class UserView extends PresentationView{
    public UserView(User user) {
        super(user);
    }

    @Override
    public PresentationView show() {
        System.out.println("1: Get\n2: Get all\n3: exit");
        Scanner scanner = new Scanner(System.in);
        return switch (scanner.nextLine()) {
            case "1" -> new GetView(currentUser);
            case "2" -> new GetAllView(currentUser);
            case "3" -> null;
            default -> new UserView(currentUser);
        };
    }
}
