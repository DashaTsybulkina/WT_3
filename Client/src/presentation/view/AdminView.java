package presentation.view;

import entity.User;
import presentation.view.studentsView.CreateView;
import presentation.view.studentsView.EditView;
import presentation.view.studentsView.GetAllView;
import presentation.view.studentsView.GetView;

import java.util.Scanner;

public class AdminView extends PresentationView{
    public AdminView(User user) {
        super(user);
    }

    @Override
    public PresentationView show() {
        System.out.println("1: GetAll\n2: Create\n3: Get\n4: Edit");
        Scanner scanner = new Scanner(System.in);
        return switch (scanner.nextLine()) {
            case "1" -> new GetAllView(currentUser);
            case "2" -> new CreateView(currentUser);
            case "3" -> new GetView(currentUser);
            case "4" -> new EditView(currentUser);
            default -> new AdminView(currentUser);
        };
    }
}
