package ua.cats.exceptions;

public class CatsServiceApplicationException  extends  RuntimeException{
    public CatsServiceApplicationException() {
    }

    public CatsServiceApplicationException(String message) {
        super(message);
    }

    public CatsServiceApplicationException(String message, Throwable cause) {
        super(message, cause);
    }
}
