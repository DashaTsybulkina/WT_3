package server;

import entity.Student;
import entity.User;
import entity.serverCommunication.Response;
import entity.serverCommunication.StudentRequest;
import entity.serverCommunication.StudentResponse;
import service.ServerService;
import service.ServiceFactory;

import java.util.List;

public class ClientController {
        private ServerService service;

        public ClientController() {
            ServiceFactory serviceFactory = ServiceFactory.getInstance();
            service = serviceFactory.getServerService();
        }

        public StudentResponse create(StudentRequest request) {
            Student student;
            StudentResponse response = new StudentResponse();
            if (request.getBody() instanceof Student body) {
                student = body;
            } else {
                response.setResponse(Response.ERROR);
                return response;
            }

            if (this.service.create(student)) {
                response.setResponse(Response.OK);
            } else {
                response.setResponse(Response.ERROR);
            }

            return response;
        }

        public StudentResponse edit(StudentRequest request) {
            Student student;
            StudentResponse response = new StudentResponse();
            if (request.getBody() instanceof Student body) {
                student = body;
            } else {
                response.setResponse(Response.ERROR);
                return response;
            }

            if (this.service.edit(student)) {
                response.setResponse(Response.OK);
            } else {
                response.setResponse(Response.ERROR);
            }

            return response;
        }

        public StudentResponse getAll() {
            List<Student> students = this.service.getAll();
            StudentResponse response = new StudentResponse();
            if (students == null) {
                response.setResponse(Response.ERROR);
                response.setBody(null);
            }
            else {
                response.setResponse(Response.OK);
                response.setBody(students);
            }

            return response;
        }

        public StudentResponse get(StudentRequest request) {
            String lastName;
            StudentResponse response = new StudentResponse();
            if (request.getBody() instanceof String) {
                lastName = (String) request.getBody();
            } else {
                response.setResponse(Response.ERROR);
                return response;
            }

            List<Student> studentsToSend = service.get(lastName);
            if (studentsToSend != null) {
                response.setResponse(Response.OK);
                response.setBody(studentsToSend);
            } else {
                response.setResponse(Response.ERROR);
            }

            return response;
        }

        public StudentResponse register(StudentRequest request) {
            User user;
            StudentResponse response = new StudentResponse();
            if (request.getBody() instanceof User body) {
                user = body;
            } else {
                response.setResponse(Response.ERROR);
                return response;
            }

            User userResult = service.register(user);
            if (userResult != null) {
                response.setResponse(Response.OK);
                response.setBody(userResult);
            } else {
                response.setResponse(Response.ERROR);
            }

            return response;
        }

        public StudentResponse login(StudentRequest request) {
            User user;
            StudentResponse response = new StudentResponse();
            if (request.getBody() instanceof User body) {
                user = body;
            } else {
                response.setResponse(Response.ERROR);
                return response;
            }

            User userResult = service.login(user);
            if (userResult != null) {
                response.setResponse(Response.OK);
                response.setBody(userResult);
            } else {
                response.setResponse(Response.ERROR);
            }

            return response;
        }

        public StudentResponse notFound() {
            StudentResponse response = new StudentResponse();
            response.setResponse(Response.NOTFOUND);
            return response;
        }
}
