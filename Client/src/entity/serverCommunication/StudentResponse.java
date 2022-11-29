package entity.serverCommunication;

import java.io.Serializable;

public class StudentResponse implements Serializable {
    private Response Response;
    private Object body;

    public Response getResponse() {
        return Response;
    }

    public void setResponse(Response Response) {
        this.Response = Response;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }
}
