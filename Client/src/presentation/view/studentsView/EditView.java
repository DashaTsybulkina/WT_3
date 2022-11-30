package presentation.view.studentsView;

import entity.Student;
import entity.User;
import presentation.view.AdminView;
import presentation.view.PresentationView;
import service.ServiceFactory;
import service.UserService;

import java.util.List;
import java.util.Scanner;

public class EditView extends PresentationView {
    private UserService service;
    public EditView(User user) {
        super(user);
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        service = serviceFactory.getApplianceService();
    }

    @Override
    public PresentationView show() {
        Student editStudent = new Student();
        Scanner scanner = new Scanner(System.in);
        List<Student> studentList = service.getAll();
        for (Student student : studentList) {
            System.out.println(student.getName()+" " + student.getLastname());
        }
        System.out.println("Select student lastname: ");
        String lastname = scanner.nextLine();
        List<Student> findStudents= service.get(lastname);
        if (!(findStudents==null)){
            Student student = new Student();
            student.setLastname(lastname);
            System.out.println("Spec of student");
            String spec = scanner.nextLine();
            student.setSpec(spec);
            System.out.println("Age of student");
            String age = scanner.nextLine();
            student.setAge(Integer.parseInt(age));
            if (!service.edit(student)) {
                System.out.println("Error writing: Probably student changed by other client.");
            }
        } else {
            System.out.println("Not found.");
        }
        return new AdminView(currentUser);
    }
}
