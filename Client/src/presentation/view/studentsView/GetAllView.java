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

public class GetAllView extends PresentationView {
    private UserService service;
    public GetAllView(User user) {
        super(user);
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        service = serviceFactory.getApplianceService();
    }

    @Override
    public PresentationView show() {
        List<Student> studentList = service.getAll();
        if (studentList.isEmpty()){
            System.out.println("Students not found!");
        }
        for (Student student : studentList) {
            System.out.println(student);
        }
        return switch (this.currentUser.getPermission()) {
            case "R" -> new UserView(currentUser);
            case "RW" -> new AdminView(currentUser);
            default -> new GuestView(new User());
        };
    }
}
