package dao.impl;

import dao.SocketManager;
import dao.UserDao;
import entity.User;
import entity.serverCommunication.Request;
import entity.serverCommunication.StudentResponse;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class UserDaoImpl implements UserDao {
    private final SocketManager socketManager = new SocketManager("localhost", 5555);
    public User checkUser(User user) throws ParserConfigurationException, IOException, SAXException {
//        Document document = getDocument();
//        NodeList nodeList = document.getDocumentElement().getElementsByTagName("user");
//
//        for (int i = 0; i < nodeList.getLength(); i++) {
//            Node node = nodeList.item(i);
//
//            if (node.getNodeType() == Node.ELEMENT_NODE) {
//                Element elem = (Element) node;
//                String login = elem.getElementsByTagName("login").item(0).getTextContent();
//
//                if (login.equals(user.getLogin())) {
//                    String password = elem.getElementsByTagName("password").item(0).getTextContent();
//
//                    if (password.equals(user.getPassword())) {
//                        String permission= elem.getElementsByTagName("permission").item(0).getTextContent();
//                        user.setPermission(permission);
//                        return user;
//                    }
//                }
//            }
//        }
//        return null;
    }

    public User registration(User user) throws ParserConfigurationException, IOException, SAXException {
        StudentResponse response = socketManager
                .sendRequest(user, Request.REGISTER);
        if (response.getBody() instanceof User body) {
            return body;
        }

        return null;
    }
}
