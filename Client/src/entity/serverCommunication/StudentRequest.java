package entity.serverCommunication;

import java.io.Serializable;

public class StudentRequest implements Serializable {
    private Request Request;
    private Object body;

    public Request getRequest() {
        return Request;
    }

    public void setRequest(Request Request) {
        this.Request = Request;
    }

    public Object getBody() {
        return this.body;
    }

    public void setBody(Object body) {
        this.body = body;
    }
}