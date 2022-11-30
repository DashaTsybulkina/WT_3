package dao;

import entity.Student;
import entity.User;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface ServerDAO {

    List<Student> getAll() throws ParserConfigurationException, IOException, SAXException;
    void addStudent(Student student) throws ParserConfigurationException, IOException, SAXException;

    List<Student> get(String lastName) throws ParserConfigurationException, IOException, SAXException;

    User login(User user) throws ParserConfigurationException, IOException, SAXException;

    User register (User user) throws ParserConfigurationException, IOException, SAXException;

    void edit(Student student) throws IOException, ParserConfigurationException, SAXException, TransformerException;
}
