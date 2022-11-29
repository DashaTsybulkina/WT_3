package dao;

import entity.User;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public interface UserDao {
    User checkUser(User user) throws ParserConfigurationException, IOException, SAXException;
    User registration(User user) throws ParserConfigurationException, IOException, SAXException;
}
