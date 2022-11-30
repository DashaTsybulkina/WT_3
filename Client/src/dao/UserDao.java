package dao;

import entity.Student;
import entity.User;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public interface UserDao {
    User login(User user) ;
    User registration(User user) ;

    boolean edit(Student newValue);

    List<Student> getAll();

    List<Student> get(String lastname);

    boolean create(Student item);

}
