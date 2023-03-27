package ua.cats.exceptions;

import java.util.Date;

public class ErrorMessage {
    private Date timestamp;
    private String message;
    private String description;

    public ErrorMessage(Date timestamp, String message, String description) {

        this.timestamp = timestamp;
        this.message = message;
        this.description = description;
    }
}
