package entity.serverCommunication;

import java.io.Serializable;

public enum Response implements Serializable {
    OK,
    ERROR,
    UPDATED,
    NOTFOUND,
}