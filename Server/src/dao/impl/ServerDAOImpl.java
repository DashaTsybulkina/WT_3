package dao.impl;

import dao.ServerDAO;
import entity.Student;
import entity.User;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ServerDAOImpl implements ServerDAO {
    private static final String STUDENTS_XML = "resources/students.xml";
    private static final String USERS_XML = "resources/users.xml";

    @Override
    public List<Student> getAll() throws ParserConfigurationException, IOException, SAXException {
        ArrayList<Student> contracts = new ArrayList<Student>();
        Document document = getDocument(STUDENTS_XML);
        NodeList contractElements = document.getDocumentElement().getElementsByTagName("student");
        for (int i = 0; i < contractElements.getLength(); i++) {
            Node node = contractElements.item(i);
            String[] fields = getFieldsArray(node.getChildNodes());
            contracts.add(new Student(fields));
        }
        return contracts;
    }

    @Override
    public void addStudent(Student student) throws ParserConfigurationException, IOException, SAXException {
        Document document = getDocument(STUDENTS_XML);
        Node root = document.getDocumentElement();
        Element studentElement = document.createElement("student");

        Element name = document.createElement("name");
        name.setTextContent(student.getName());

        Element lastname = document.createElement("lastname");
        lastname.setTextContent(student.getLastname());

        Element spec = document.createElement("spec");
        spec.setTextContent(student.getSpec());

        Element age = document.createElement("age");
        age.setTextContent(student.getAge().toString());

        studentElement.appendChild(name);
        studentElement.appendChild(lastname);
        studentElement.appendChild(spec);
        studentElement.appendChild(age);
        root.appendChild(studentElement);

        try {
            writeXml(document, STUDENTS_XML);
        } catch (TransformerException | IOException e) {
            e.printStackTrace(System.out);
        }
    }

    @Override
    public List<Student> get(String lastName) throws ParserConfigurationException, IOException, SAXException {
        List<Student> students = new ArrayList<>();
        Document doc = getDocument(STUDENTS_XML);
        NodeList nList = doc.getDocumentElement().getElementsByTagName("student");
        for (int i = 0; i < nList.getLength(); i++) {
            Node node = nList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
             //   Element elem = (Element) node;
                NodeList fields = node.getChildNodes();//.getElementsByTagName("lastName").item(0).getTextContent();
                for (int j = 0; j < fields.getLength(); j++) {
                    if (fields.item(j).getNodeType() == Node.ELEMENT_NODE) {
                        String name = fields.item(j).getNodeName();
                        String value = fields.item(j).getTextContent();
                        if ((name.equals("lastname")) && lastName.equals(value)) {
                            String[] fieldsString = getFieldsArray(node.getChildNodes());
                            students.add(new Student(fieldsString));
                        }
                    }
                }
            }
        }
        return students;
    }

    private Document getDocument(String path) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        return documentBuilder.parse(new File(path));
    }

    @Override
    public User login(User user) throws ParserConfigurationException, IOException, SAXException {
        Document doc = getDocument(USERS_XML);
        NodeList nList = doc.getDocumentElement().getElementsByTagName("user");
        for (int i = 0; i < nList.getLength(); i++) {
            Node nNode = nList.item(i);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) nNode;
                String login = elem.getElementsByTagName("login").item(0).getTextContent();
                if (login.equals(user.getLogin())) {
                    String password = elem.getElementsByTagName("password").item(0).getTextContent();
                    if (password.equals(user.getPassword())) {
                        String permission = elem.getElementsByTagName("permission").item(0).getTextContent();
                        user.setPermission(permission);
                        return user;
                    }
                }
            }
        }
        return null;
    }

    private void addUser(User user, Document document) {
        Node root = document.getDocumentElement();
        Element userElement = document.createElement("user");

        Element login = document.createElement("login");
        login.setTextContent(user.getLogin());

        Element password = document.createElement("password");
        password.setTextContent(user.getPassword());

        Element permission = document.createElement("permission");
        permission.setTextContent(user.getPermission());

        userElement.appendChild(login);
        userElement.appendChild(password);
        userElement.appendChild(permission);

        root.appendChild(userElement);

        // Записываем XML в файл
        try {
            writeXml(document, USERS_XML);
        } catch (TransformerException | IOException e) {
            e.printStackTrace(System.out);
        }
    }

    private void writeXml(Document document, String path) throws TransformerException, FileNotFoundException {
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        DOMSource source = new DOMSource(document);
        FileOutputStream fos = new FileOutputStream(path);
        StreamResult result = new StreamResult(fos);
        transformer.transform(source, result);
    }

    @Override
    public User register(User user) throws ParserConfigurationException, IOException, SAXException {
        Boolean isFind = false;
        Document doc = getDocument(USERS_XML);
        NodeList nList = doc.getDocumentElement().getElementsByTagName("user");
        for (int i = 0; i < nList.getLength(); i++) {
            Node nNode = nList.item(i);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) nNode;
                String login = elem.getElementsByTagName("login").item(0).getTextContent();
                if (login.equals(user.getLogin())) {
                    isFind = true;
                }
            }
        }
        if (isFind == false) {
            addUser(user, doc);
        }
        return null;
    }


    @Override
    public void edit(Student student) throws IOException, ParserConfigurationException, SAXException, TransformerException {
        List<Student> students = new ArrayList<>();
        Document doc = getDocument(STUDENTS_XML);
        NodeList nList = doc.getDocumentElement().getElementsByTagName("student");
        Node findStudent = null;
        for (int i = 0; i < nList.getLength(); i++) {
            Node nNode = nList.item(i);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) nNode;
                String lastName = elem.getElementsByTagName("lastName").item(0).getTextContent();
                if (lastName.equals(student.getLastname())) {
                    findStudent = nNode;
                }
            }
        }
        NodeList fields = findStudent.getChildNodes();
        fields.item(0).setTextContent(student.getLastname());
        fields.item(1).setTextContent(student.getName());
        fields.item(2).setTextContent(student.getSpec());
        fields.item(3).setTextContent(student.getAge().toString());

        writeXml(doc, STUDENTS_XML);
    }

    private String[] getFieldsArray(NodeList fieldsNodes) {
        String[] fields = new String[fieldsNodes.getLength()];
        int i = 0;
        for (int j = 0; j < fieldsNodes.getLength(); j++) {
            if (fieldsNodes.item(j).getNodeType() == Node.ELEMENT_NODE) {
                fields[i++] = fieldsNodes.item(j).getTextContent();
            }
        }
        return fields;
    }
}
