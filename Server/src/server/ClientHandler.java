package server;

import entity.serverCommunication.StudentRequest;
import entity.serverCommunication.StudentResponse;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


public class ClientHandler extends Thread{
    private final ObjectInputStream in;
    private final ObjectOutputStream out;
    private final ClientController controller;

    public ClientHandler(Socket socket) throws IOException {
        this.out = new ObjectOutputStream(socket.getOutputStream());
        this.in = new ObjectInputStream(socket.getInputStream());
        this.controller = new ClientController();
        start();
    }

    @Override
    public void run() {
        try {
            while (true) {
                StudentRequest request = (StudentRequest) this.in.readObject();
                StudentResponse response = switch (request.getRequest()) {
                    case CREATE -> this.controller.create(request);
                    case GET -> this.controller.get(request);
                    case GET_ALL -> this.controller.getAll();
                    case EDIT -> this.controller.edit(request);
                    case REGISTER -> this.controller.register(request);
                    case LOGIN -> this.controller.login(request);
                    default -> this.controller.notFound();
                };

                this.out.writeObject(response);
                this.out.flush();
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.printf("Failed read: %s%n", e.getMessage());
        }
    }
}
