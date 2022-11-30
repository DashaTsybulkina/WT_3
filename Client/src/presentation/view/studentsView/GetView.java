package presentation.view.studentsView;

import entity.Student;
import entity.User;
import presentation.view.AdminView;
import presentation.view.GuestView;
import presentation.view.PresentationView;
import presentation.view.UserView;
import service.ServiceFactory;
import service.UserService;

import java.util.List;
import java.util.Scanner;

public class GetView extends PresentationView {
    private UserService service;

    public GetView(User user) {
        super(user);
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        service = serviceFactory.getApplianceService();
    }

    @Override
    public PresentationView show() {
        Scanner scanner = new Scanner(System.in);
        List<Student> studentList = service.getAll();
        for (Student student : studentList) {
            System.out.println(student.getLastname() +" "+ student.getName());
        }
        System.out.println("Select student lastname: ");
        String lastname = scanner.nextLine();
        List<Student> findStudents = service.get(lastname);
        if (findStudents != null && findStudents.size() != 0) {
            for (Student student : findStudents) {
                System.out.println(student);
            }
        } else {
            System.out.println("Not found.");
        }
        return switch (this.currentUser.getPermission()) {
            case "R" -> new UserView(currentUser);
            case "RW" -> new AdminView(currentUser);
            default -> new GuestView(new User());
        };
    }
}
