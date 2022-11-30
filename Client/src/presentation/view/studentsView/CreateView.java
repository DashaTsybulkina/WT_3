package presentation.view.studentsView;

import entity.Student;
import entity.User;
import presentation.view.AdminView;
import presentation.view.LoginView;
import presentation.view.PresentationView;
import service.ServiceFactory;
import service.UserService;

import java.util.Scanner;

public class CreateView extends PresentationView {
    private UserService service;
    public CreateView(User user) {
        super(user);
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        service = serviceFactory.getApplianceService();
    }

    @Override
    public PresentationView show() {
        Student student = new Student();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Name of student:");
        String name = scanner.nextLine();
        student.setName(name);
        System.out.println("Lastname of student");
        String lastName = scanner.nextLine();
        student.setLastname(lastName);
        System.out.println("Spec of student");
        String spec = scanner.nextLine();
        student.setSpec(spec);
        System.out.println("Age of student");
        String age = scanner.nextLine();
        student.setAge(Integer.parseInt(age));

        if (!service.create(student)) {
            System.out.println("Error creating");
        }
        return new AdminView(currentUser);
    }
}
