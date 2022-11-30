import entity.User;
import org.xml.sax.SAXException;
import presentation.Presentation;
import service.ServiceFactory;

import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {
        Presentation presentation = new Presentation();
        presentation.show();
    }
}